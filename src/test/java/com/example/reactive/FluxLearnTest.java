package com.example.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.reactive.Service.FluxLearnService;


@SpringBootTest
public class FluxLearnTest {
    @Autowired
    private FluxLearnService fluxLearnService;
    @Test
    void fluxTestingService(){
        this.fluxLearnService.fluxTestingService();
    }
    @Test
    void simpleTestService(){
        fluxLearnService.getflux().subscribe(data -> {
            System.out.println(data);
        });
    }
@Test
    void simpleFruit(){
        fluxLearnService.fruitList().subscribe(data ->{
            System.out.println(data);
        });
    }
    @Test 
    void mapExample(){
        fluxLearnService.mapExample().subscribe(data -> {
            System.out.println(data);
        });
    }
}
