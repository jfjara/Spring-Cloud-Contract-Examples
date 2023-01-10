package com.jfjara.farm.domain.repository;

import com.jfjara.farm.domain.dto.AnimalTypeDto;

import java.util.List;

public interface AnimalRepository {

    List<String> getAnimalTypes();

}
