package com.project.reactor;

import reactor.core.publisher.Mono;

public class Ejemplo03 {

    public static void main(String[] args) {
        // un supplier
        Mono<String> mono = Mono.fromSupplier(() -> {
            throw new RuntimeException("Excepcion ocurrida");
        });

        mono.subscribe(
                data -> System.out.println(data), // onNext
                err -> System.out.println(err), // onError
                () -> System.out.println("Completado") // onComplete
        );
    }
}
