package com.example.reactive.Service;

import com.example.reactive.entities.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    public Mono<Book> create(Book Book);

    public Flux<Book> getall();

    public Mono<Book> get(int bookID);

    public Mono<Book> update(Book book, int bookId);

    public Mono<Void> delete (int bookID);

    public Flux<Book> search(String query);

    public Flux<Book> searchBooks(String name);
}
