package com.smo.person.infrastructure.persistencia.dao.gateways;


import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PersonDaoInt extends JpaRepository<PersonEntity, Long> {

    ArrayList<PersonEntity> findAll();
    Long deleteByPersonNumDoc(String personNumDoc);

}
