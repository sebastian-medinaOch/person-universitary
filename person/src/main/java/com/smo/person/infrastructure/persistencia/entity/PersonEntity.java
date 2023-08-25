package com.smo.person.infrastructure.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;

@Data
@Entity
@Table(name = "TBL_PERSON")
@NoArgsConstructor
public class PersonEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    @Column(name = "PERSON_NAME")
    private String personName;
    @Column(name = "PERSON_LAST_NAME")
    private String personLastName;
    @Column(name = "PERSON_YEAR")
    private String personYear;
    @Column(name = "PERSON_NUM_DOC")
    private String personNumDoc;

}
