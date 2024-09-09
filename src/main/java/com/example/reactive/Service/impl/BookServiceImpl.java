package com.example.reactive.Service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactive.Service.BookService;
import com.example.reactive.entities.Book;
import com.example.reactive.repositories.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> createdBook = bookRepository.save(book);
        return createdBook;
    }

    @Override
    public Flux<Book> getall() {
        return bookRepository.findAll().delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Mono<Book> get(int bookID) {
        Mono<Book> item = bookRepository.findById(bookID);
        return item;
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono <Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setPublisher(book.getPublisher());
            book1.setDescription(book.getDescription());
            book1.setAuthor(book.getAuthor());
            return bookRepository.save(book1);
        });
    }

    @Override
    public Mono<Void> delete(int bookID) {
       return bookRepository.findById(bookID).flatMap(book -> bookRepository.delete(book));
    }

    @Override
    public Flux<Book> searchBooks(String name){
        return this.bookRepository.searchBookByName("%" + name + "%");
    }


    @Override
    public Flux<Book> search(String query) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
}
