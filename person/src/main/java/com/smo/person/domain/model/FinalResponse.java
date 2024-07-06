package com.smo.person.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FinalResponse {

    public int code;
    public Object body;

}
