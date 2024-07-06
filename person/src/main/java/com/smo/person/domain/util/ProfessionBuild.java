package com.smo.person.domain.util;

import com.smo.person.application.request.PersonRequest;
import com.smo.person.application.request.ProfessionRequest;

public class ProfessionBuild {

    public ProfessionRequest buildProfessionRequest(PersonRequest personRequest){
        ProfessionRequest professionRequest = new ProfessionRequest();
        professionRequest.setNameProfession(personRequest.getPersonProfession());
        professionRequest.setNumberDNI(personRequest.getPersonNumDoc());
        return professionRequest;
    }

}
