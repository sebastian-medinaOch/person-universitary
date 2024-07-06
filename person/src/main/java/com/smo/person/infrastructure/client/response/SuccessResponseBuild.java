package com.smo.person.infrastructure.client.response;

import lombok.Data;

@Data
public class SuccessResponseBuild {

    private String timestamp;
    private String status;
    private DataResponse dataResponse;

}
