package com.smo.person.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private Long personId;
    private String personName;
    private String personLastName;
    private String personYear;
    private String personNumDoc;
    private String personProfession;

}
