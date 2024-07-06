package com.smo.person.domain.usecase;

import com.smo.person.application.request.PersonRequest;
import com.smo.person.application.request.ProfessionRequest;
import com.smo.person.domain.gateways.ProfessionClientInt;
import com.smo.person.domain.model.FinalResponse;
import com.smo.person.domain.util.ProfessionBuild;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLException;

@RequiredArgsConstructor
public class ProfessionUseCase {

    private final ProfessionBuild professionBuild;
    private final ProfessionClientInt professionClientInt;

    public void createProfession(PersonRequest personRequest) throws SSLException {
        ProfessionRequest professionRequest = professionBuild.buildProfessionRequest(personRequest);
        professionClientInt.createProfession(professionRequest).subscribe();
    }

}
