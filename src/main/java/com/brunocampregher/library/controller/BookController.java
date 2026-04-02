package com.brunocampregher.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunocampregher.library.model.Book;
import com.brunocampregher.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("/author/{authorId}")
  public Book create(@RequestBody Book book, @PathVariable Long authorId) {
    return bookService.createBook(book, authorId);
  }

  @GetMapping
  public List<Book> get() {
    return bookService.getBooks();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    bookService.deleteBook(id);
  }
}
