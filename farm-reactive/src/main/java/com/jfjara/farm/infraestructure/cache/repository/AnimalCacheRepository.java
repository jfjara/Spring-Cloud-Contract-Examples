package com.jfjara.farm.infraestructure.cache.repository;

import com.jfjara.farm.domain.dto.AnimalTypeDto;
import com.jfjara.farm.domain.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnimalCacheRepository implements AnimalRepository {

    @Override
    public List<String> getAnimalTypes() {
        return Stream
                .of(AnimalTypeDto.values())
                .map(AnimalTypeDto::getValue)
                .collect(Collectors.toList());
    }

}
