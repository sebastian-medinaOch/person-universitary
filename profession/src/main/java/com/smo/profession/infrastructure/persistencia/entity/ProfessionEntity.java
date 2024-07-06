package com.smo.profession.infrastructure.persistencia.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(value = "Profession")
public class ProfessionEntity {

    private String nameProfession;
    private String numberDNI;

}
