package com.jfjara.farm.application;

import com.jfjara.farm.application.ports.GetTypeAnimalsUseCase;
import com.jfjara.farm.domain.dto.AnimalTypeDto;
import com.jfjara.farm.domain.repository.AnimalRepository;

import java.util.List;

public class GetTypeAnimalUseCaseImpl implements GetTypeAnimalsUseCase {

    private final AnimalRepository animalRepository;

    public GetTypeAnimalUseCaseImpl(final AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<String> execute() {
        return animalRepository.getAnimalTypes();
    }

}
