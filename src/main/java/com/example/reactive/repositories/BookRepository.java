package com.example.reactive.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.reactive.entities.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Repository
public interface BookRepository extends ReactiveCrudRepository <Book , Integer>{ 
    Mono<Book> findByName(String name);
    Mono<Book> findByAuthor(String author);
    Mono<Book> findByPublisher(String publisher);
    Mono<Book> findByNameAndAuthor(String name, String author);

    @Query("select * from book_details where name LIKE :name")
    Flux<Book> searchBookByName(String name);

}
