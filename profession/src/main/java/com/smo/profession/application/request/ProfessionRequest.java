package com.smo.profession.application.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfessionRequest {

    @NotBlank(message = "El nombre de la profession no puede quedar vacio.")
    private String nameProfession;
    @NotBlank(message = "El numero de identidad no puede quedar vacio.")
    private String numberDNI;

}
