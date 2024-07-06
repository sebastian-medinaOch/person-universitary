package com.smo.profession.infrastructure.rest.controller;


import com.smo.profession.application.gateways.CreateProfessionInt;
import com.smo.profession.domain.answer.AnswerData;
import com.smo.profession.domain.answer.DataResponse;
import com.smo.profession.application.request.ProfessionRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/profession")
@RequiredArgsConstructor
public class EndpointCreatePerson {

    private final CreateProfessionInt createProfessionInt;

    @PostMapping(value = "/createProfession")
    public ResponseEntity<AnswerData> createProfession(@Valid @RequestBody ProfessionRequest profession){
        createProfessionInt.createProfession(profession);
        DataResponse dataResponse = DataResponse.builder()
                .message("Sastifactorio")
                .data(Optional.of("Profession creada sastifactoriamente"))
                .build();
        AnswerData answerData = new AnswerData(HttpStatus.OK,dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
