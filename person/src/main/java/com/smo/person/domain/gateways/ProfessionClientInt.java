package com.smo.person.domain.gateways;

import com.smo.person.application.request.ProfessionRequest;
import com.smo.person.domain.model.FinalResponse;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLException;

public interface ProfessionClientInt {

    Mono<FinalResponse> createProfession(ProfessionRequest professionRequest) throws SSLException;

}
