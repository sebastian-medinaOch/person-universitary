package com.smo.person.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class PersonRequest {

    @NotBlank(message = "El nombre de la persona no puede estar vacio.")
    private String personName;
    @NotBlank(message = "El apellido de la persona no puede estar vacio.")
    private String personLastName;
    @NotBlank(message = "La edad de la persona no puede estar vacio.")
    private String personYear;
    @NotBlank(message = "El numero de documento de la persona no puede estar vacio.")
    private String personNumDoc;
    @NotBlank(message = "La profesion de la persona no puede estar vacio.")
    private String personProfession;

}
