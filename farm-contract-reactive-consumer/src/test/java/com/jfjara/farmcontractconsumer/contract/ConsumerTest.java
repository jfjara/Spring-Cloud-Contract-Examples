package com.jfjara.farmcontractconsumer.contract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.jfjara:farm-reactive:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ConsumerTest {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void setup() {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    void verify_get_heart() throws Exception {
        webTestClient.get()
                .uri("/farm/animals")
                .exchange()
                .expectStatus().isEqualTo(200)
                .expectBody().json("[\"COW\", \"CHICKEN\", \"PIG\"]");
    }

}
