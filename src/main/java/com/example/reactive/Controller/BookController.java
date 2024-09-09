package com.example.reactive.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactive.Service.BookService;
import com.example.reactive.entities.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    // create
    @PostMapping
    public Mono<Book> create (@RequestBody Book book){
        return bookService.create(book);
    }
    
    // get all book
    @GetMapping
    public Flux<Book> getAll(){
        return bookService.getall();
    }

    // get single book 
    @GetMapping("/{bid}")
    public Mono<Book> get(@PathVariable ("bid") int bookID){
        return bookService.get(bookID);
    }

    // update book
    @PutMapping("/{bookID}")
    public Mono<Book> update (@RequestBody Book book, @PathVariable int bookID){
        return bookService.update(book, bookID);
    }

    // delete book
    @DeleteMapping("/{bookID}")
    public Mono<Void> delete(@PathVariable int bookID){
        return bookService.delete(bookID);
    }
}
