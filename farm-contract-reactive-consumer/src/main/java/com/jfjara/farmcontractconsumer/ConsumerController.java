package com.jfjara.farmcontractconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ConsumerController {

    private final WebClient webClient;

    private final String server;

    private final String path;

    public ConsumerController(@Value("${api.farm.server}") final String server,
                              @Value("${api.farm.path.animals.type}") final String path) {
        this.webClient = WebClient.builder().baseUrl(server).build();
        this.server = server;
        this.path = path;
    }

    @GetMapping("/animals")
    public Mono<List> getFarmAnimals() {
        return webClient.get().uri(path).retrieve().bodyToMono(List.class);
    }

}
