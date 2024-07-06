package com.smo.profession.infrastructure.configuration;

import com.smo.profession.application.services.ServicesCreateProfession;
import com.smo.profession.application.util.ProfessionRepositoryBuild;
import com.smo.profession.domain.gateways.ProfessionRepositoryInt;
import com.smo.profession.domain.usecase.ProfessionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ServicesCreateProfession servicesCreateProfession(ProfessionRepositoryBuild professionRepositoryBuild,
                                                             ProfessionUseCase professionUseCase){
        return new ServicesCreateProfession(professionRepositoryBuild, professionUseCase);
    }

    @Bean
    public ProfessionUseCase professionUseCase(ProfessionRepositoryInt professionRepositoryInt){
        return new ProfessionUseCase(professionRepositoryInt);
    }

    @Bean
    public ProfessionRepositoryBuild personRepositoryBuild(){
        return new ProfessionRepositoryBuild();
    }

}
