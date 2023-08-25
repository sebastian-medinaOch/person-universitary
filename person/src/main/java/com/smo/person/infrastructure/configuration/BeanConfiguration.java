package com.smo.person.infrastructure.configuration;

import com.smo.person.application.services.ServiceCreatePerson;
import com.smo.person.application.services.ServicesGetPersons;
import com.smo.person.application.services.ServicesDeletePerson;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.domain.usecase.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ServiceCreatePerson serviceCreatePerson(PersonUseCase personUseCase, PersonRepositoryBuild personRepositoryBuild){
        return new ServiceCreatePerson(personRepositoryBuild,personUseCase);
    }

    @Bean
    public ServicesGetPersons servicesGetPersons(PersonUseCase personUseCase, PersonRepositoryBuild personRepositoryBuild){
        return new ServicesGetPersons(personUseCase, personRepositoryBuild);
    }

    @Bean
    public ServicesDeletePerson serviceDeletePerson(PersonUseCase personUseCase){
        return new ServicesDeletePerson(personUseCase);
    }

    @Bean
    public PersonUseCase personUseCase(PersonRepositoryInt personRepositoryInt){
        return new PersonUseCase(personRepositoryInt);
    }

    @Bean
    public PersonRepositoryBuild personRepositoryBuild(){
        return new PersonRepositoryBuild();
    }

}
