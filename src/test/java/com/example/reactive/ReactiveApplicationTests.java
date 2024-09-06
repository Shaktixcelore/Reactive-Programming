package com.example.reactive;

import static org.mockito.Answers.values;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void monoTest(){
		// System.out.println("Testing start");
		// Mono : it is publisher that have 0 or 1  items

		// Creating mono 

		// Mono<String> m1= Mono.just("Lets start....");

		// // consume the mono by subscribing

		// m1.subscribe(System.out::println);

		Mono<String> m1 = Mono.just("hello");
		Mono<String> m2 = Mono.just("shakti singh");
		Mono<Integer> m3 = Mono.just(135);

		// Mono<Tuple3 <String, String , Integer>> combinedMono = Mono.zip(m1, m2, m3);
		// combinedMono.subscribe(data -> {
		// 	// System.out.println(data); // (This print all data)
		// 	// this print single - single element 
		// 	System.out.println(data.getT1());
		// 	System.out.println(data.getT2());
		// 	System.out.println(data.getT3());
		// });

		// using map
		Mono<String> resultMapMono = m1.map(value -> value.toUpperCase());
		resultMapMono.subscribe(System.out::println);

		System.out.println("-------------------");

		// using flatmap

		Mono<String []> resultFlatExample = m2.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
		resultFlatExample.subscribe(data -> {
			for(String s : data ){
				System.out.println(s);
			}
		});

		System.out.println("-------------------");

		// using flatMapMany
		Flux<String> stringFlux = m2.flatMapMany(valueM1 -> Flux.just(valueM1.split(" ")));
		stringFlux.subscribe(data -> {
			System.out.println(data);
		});
	}

}
