package com.project.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo01 {
    public static void main(String[] args) {
        List<Integer> elementosFromMono = new ArrayList<Integer>();
        List<Integer> elementosFromFlux = new ArrayList<Integer>();
        // publishers
        Mono<Integer> mono = Mono.just(7); // just sirve para agregar elementos
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6);
        // Como mostrar los datos.
        // subscribimos elementos a los publishers
        mono.subscribe(elementosFromMono::add);
        flux.subscribe(elementosFromFlux::add);

        System.out.println(elementosFromFlux);
        System.out.println(elementosFromMono);
    }
}
