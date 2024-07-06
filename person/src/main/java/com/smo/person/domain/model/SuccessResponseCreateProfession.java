package com.smo.person.domain.model;

import com.smo.person.domain.answer.DataResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@Builder
public  class SuccessResponseCreateProfession {

    private String timestamp;
    private String status;
    private DataResponseProfessionModel dataResponse;

}