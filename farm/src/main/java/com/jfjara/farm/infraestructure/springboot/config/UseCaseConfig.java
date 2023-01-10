package com.jfjara.farm.infraestructure.springboot.config;

import com.jfjara.farm.application.GetTypeAnimalUseCaseImpl;
import com.jfjara.farm.application.ports.GetTypeAnimalsUseCase;
import com.jfjara.farm.infraestructure.cache.repository.AnimalCacheRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetTypeAnimalsUseCase getTypeAnimalsUseCase(final AnimalCacheRepository animalCacheRepository) {
        return new GetTypeAnimalUseCaseImpl(animalCacheRepository);
    }

}
