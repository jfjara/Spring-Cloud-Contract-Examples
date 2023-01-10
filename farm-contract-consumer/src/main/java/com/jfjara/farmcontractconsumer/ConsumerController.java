package com.jfjara.farmcontractconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    private final String server;

    private final String path;

    public ConsumerController(final RestTemplateBuilder restTemplateBuilder,
                              @Value("${api.farm.server}") final String server,
                              @Value("${api.farm.path.animals.type}") final String path) {
        this.restTemplate = restTemplateBuilder.build();
        this.server = server;
        this.path = path;
    }

    @GetMapping("/animals")
    public ResponseEntity<List<String>> getFarmAnimals() {

        StringBuilder url = new StringBuilder(server);
        url.append(path);

        var response = restTemplate.getForObject(url.toString(), List.class);
        return ResponseEntity.ok(response);
    }

}
