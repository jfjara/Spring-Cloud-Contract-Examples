package com.jfjara.farm.infraestructure.springboot.api.controller;

import com.jfjara.farm.application.ports.GetTypeAnimalsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class FarmController {


    private final GetTypeAnimalsUseCase getTypeAnimalsUseCase;

    public FarmController(final GetTypeAnimalsUseCase getTypeAnimalsUseCase) {
        this.getTypeAnimalsUseCase = getTypeAnimalsUseCase;
    }

    @GetMapping("/farm/animals")
    public Mono<List<String>> getTypeAnimals() {
        return Mono.just(getTypeAnimalsUseCase.execute());
    }

}
