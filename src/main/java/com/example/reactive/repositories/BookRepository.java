package com.example.reactive.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.reactive.entities.Book;

@Repository
public interface BookRepository extends ReactiveCrudRepository <Book , Integer>{ 

}
