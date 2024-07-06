package com.smo.person.infrastructure.client;

import com.smo.person.application.request.ProfessionRequest;
import com.smo.person.domain.gateways.ProfessionClientInt;
import com.smo.person.domain.model.FinalResponse;
import com.smo.person.infrastructure.client.configuration.ProfessionAdapterConfig;
import com.smo.person.infrastructure.client.response.SuccessResponseBuild;
import com.smo.person.infrastructure.client.util.CodeBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import javax.net.ssl.SSLException;
import java.time.Duration;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProfessionAdapter implements ProfessionClientInt {

    private final ProfessionAdapterConfig professionAdapterConfig;
    private final CodeBuilder codeBuilder;

    @Override
    public Mono<FinalResponse> createProfession(ProfessionRequest professionRequest) throws SSLException {
        log.info("Información enviada al servicio de profession: {}", professionRequest);

        return Mono.just(FinalResponse.builder().body("test").build());

    }

    private Mono<FinalResponse> buildResponse(ClientResponse clientResponse) {
        int status = clientResponse.statusCode().value();
        if (status == HttpStatus.OK.value()) {
            return clientResponse.bodyToMono(SuccessResponseBuild.class).map(objectResponse -> {
                log.info("Respuesta Exitosa Api:  {}, Status: {}, bodyResponse: {}", "MS-PROFESSION",
                        clientResponse.statusCode().value(), objectResponse);
                return codeBuilder.toResponseSucces(clientResponse.statusCode().value(), objectResponse);
            });
        }
        /*else {
            return clientResponse.bodyToMono(SuccessResponseBuild.class).map(objectResponse -> {
                log.info("Respuesta Erronea Api: {}, Status: {}, bodyResponse: {}", API_NAME,
                        clientResponse.statusCode().value(), objectResponse);
                return codeBuilder.toResponseErrorSucces(clientResponse.statusCode().value(), objectResponse);
            });
        }
         */
        return null;
    }

}
