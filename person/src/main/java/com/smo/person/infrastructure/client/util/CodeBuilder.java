package com.smo.person.infrastructure.client.util;

import com.smo.person.domain.model.DataResponseProfessionModel;
import com.smo.person.domain.model.FinalResponse;
import com.smo.person.domain.model.SuccessResponseCreateProfession;
import com.smo.person.infrastructure.client.response.SuccessResponseBuild;

public class CodeBuilder {

    public FinalResponse toResponseSucces(int code, SuccessResponseBuild body) {
        return FinalResponse.builder()
                .code(code)
                .body(SuccessResponseCreateProfession.builder()
                        .timestamp(body.getTimestamp())
                        .status(body.getStatus())
                        .dataResponse(DataResponseProfessionModel.builder()
                                .message(body.getDataResponse().getMessage())
                                .data(body.getDataResponse().getData())
                                .build())
                        .build())
                .build();
    }

}
