package com.example.reactive.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FluxTestService {
    public void fluxTestingService(){
        System.out.println("flux testing service");
    }
    
    public Flux<String> getflux(){
        return Flux.just("shakti","singh","xcelore");
    }

    //list
    public Flux<String> fruitFlux(){
        List<String> fruitsName= List.of("mango", "apple");
        return Flux.fromIterable(fruitsName);
    }

    //empty
    public Flux<String> emptyFlux(){
        return Flux.empty();
    }

    //map
    public Flux<String> mapExampleFlux(){
        Flux<String> capFlux = getflux().map(name -> name.toUpperCase());
        return capFlux;
    }

    //filter
    public Flux<String>filterExampleFlux(){
        return getflux().filter(name -> name.length() > 4);
    }

}
