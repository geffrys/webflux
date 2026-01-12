package com.project.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Ejemplo04 {
    public static void main(String[] args) {
        // un supplier
        Flux<String> flux = Flux.just("A", "B", "C");
        Flux<String> flux1 = Flux.fromArray(new String[]{"E", "F", "G"});

        flux.subscribe();
        flux.subscribe(System.out::println);
        flux1.doOnNext(System.out::println).subscribe();
    }
}
