package com.camspot.sysarach.service;

import com.camspot.sysarach.Repository.BookRepository;
import com.camspot.sysarach.api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> addBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

//    public ResponseEntity<Book> getBookById(String id) {
//        Optional<Book> book = bookRepository.findById(id);
//        if (book.isPresent()) {
//            return new ResponseEntity<>(book.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    public ResponseEntity<List<Book>> getBookByIds(List<String> ids) {
        Iterable<Book> personsIterable = bookRepository.findAllById(ids);
        List<Book> book = new ArrayList<>();
        personsIterable.forEach(book::add);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
