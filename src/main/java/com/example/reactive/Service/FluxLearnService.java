package com.example.reactive.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FluxLearnService {
    public void fluxTestingService(){
        System.out.println("flux testing started..."); 
    }
    public Flux <String> getflux(){
        return Flux.just("shakti","singh","xcelore");
    }

    public Flux <String> fruitList(){
        List<String> fruitNames = List.of("mango","apple");
        return Flux.fromIterable(fruitNames);
    }

    public Flux <String> mapExample(){
        Flux<String> capFlux = getflux().map(name -> name.toUpperCase());
        return capFlux;
    }
}
