package com.example.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.reactive.Service.FluxTestService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class fluxTest {

    @Autowired
    private FluxTestService fluxTestService;
    
    @Test
    public void testing(){
        // fluxTestService.getflux().subscribe(data ->{
        //     System.out.println(data);
        //     System.out.println("done with flux data ");
        // });
        fluxTestService.fruitFlux().subscribe(System.out::println);
    }

    @Test
    public void mapExampleTesting(){
        fluxTestService.mapExampleFlux().subscribe(data -> {
            System.out.println(data);
        });
    }

    @Test
    public void filterExampleTesting(){
        Flux <String> filterFlux = fluxTestService.filterExampleFlux();
        StepVerifier.create(filterFlux)
        .expectNextCount(3)
        .verifyComplete();
    }
}
