package com.smo.profession.domain.answer;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class DataResponse {

    private String message;
    private Optional<Object> data;

}
