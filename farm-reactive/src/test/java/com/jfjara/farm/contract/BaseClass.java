package com.jfjara.farm.contract;

import com.jfjara.farm.application.GetTypeAnimalUseCaseImpl;
import com.jfjara.farm.infraestructure.cache.repository.AnimalCacheRepository;
import com.jfjara.farm.infraestructure.springboot.api.controller.FarmController;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseClass {


    @BeforeEach
    public void setup() {
        FarmController farmController = new FarmController(new GetTypeAnimalUseCaseImpl(new AnimalCacheRepository()));
        RestAssuredWebTestClient.standaloneSetup(farmController);
    }

}
