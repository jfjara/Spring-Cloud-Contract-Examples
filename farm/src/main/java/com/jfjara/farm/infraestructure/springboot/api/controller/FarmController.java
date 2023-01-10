package com.jfjara.farm.infraestructure.springboot.api.controller;

import com.jfjara.farm.application.ports.GetTypeAnimalsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FarmController {

    @Autowired
    private GetTypeAnimalsUseCase getTypeAnimalsUseCase;

    @GetMapping("/farm/animals")
    public ResponseEntity<List<String>> getTypeAnimals() {
        var animalTypes = getTypeAnimalsUseCase.execute();
        return ResponseEntity.ok(animalTypes);
    }

}
