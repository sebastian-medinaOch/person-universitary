package com.smo.person.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataResponseProfessionModel {

    private String message;
    private String data;

}
