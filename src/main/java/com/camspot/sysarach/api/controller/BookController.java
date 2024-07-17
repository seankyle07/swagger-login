package com.camspot.sysarach.api.controller;


import com.camspot.sysarach.api.model.Book;
import com.camspot.sysarach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin=(origins="*")
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

//    @PostMapping("/getById")
//    public ResponseEntity<Book> getBookById(@RequestBody String id) {
//        return bookService.getBookById(id);
//    }

    @PostMapping("/getByIds")
    public ResponseEntity<List<Book>> getBookByIds(@RequestBody List<String> ids) {
        return bookService.getBookByIds(ids);
    }
}
