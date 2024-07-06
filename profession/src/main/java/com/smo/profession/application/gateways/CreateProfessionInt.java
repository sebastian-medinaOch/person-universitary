package com.smo.profession.application.gateways;

import com.smo.profession.application.request.ProfessionRequest;
import org.springframework.stereotype.Service;

@Service
public interface CreateProfessionInt {

    void createProfession(ProfessionRequest professionRequest);

}
