package com.alexeyanufriev.monosinkbug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

    @GetMapping("/mono")
    public Mono<String> getSingleString() {
        return Mono.create(emitter -> emitter.onRequest(value -> {
            emitter.success("mono-result");
        }));
    }

    @GetMapping("/flux")
    public Flux<String> getMultipleStrings() {
        return Flux.create(emitter -> emitter.onRequest(value -> {
            emitter.next("flux-result");
            emitter.complete();
        }));
    }

}
