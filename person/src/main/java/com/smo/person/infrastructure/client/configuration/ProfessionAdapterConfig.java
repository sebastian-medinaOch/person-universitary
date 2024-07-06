package com.smo.person.infrastructure.client.configuration;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

import static io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class ProfessionAdapterConfig {

    private final Environment environment;


    @Bean(name = "consumption-apiconnect")
    public WebClient getWebClientProfession()
            throws SSLException {

        return WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.bancolombia.v4+json")
                .defaultHeader(HttpHeaders.ACCEPT, "application/vnd.bancolombia.v4+json")
                .clientConnector(getClientHttpConnector())
                .build();
    }

    public ClientHttpConnector getClientHttpConnector() throws SSLException {
        SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        return new ReactorClientHttpConnector(HttpClient.create()
                .compress(true)
                .secure(sslContextSpec -> sslContextSpec.sslContext(sslContext))
                .keepAlive(true)
                .option(CONNECT_TIMEOUT_MILLIS, 1000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(Integer.parseInt("10000"), MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(Integer.parseInt("10000"), MILLISECONDS));
                }));
    }

}
