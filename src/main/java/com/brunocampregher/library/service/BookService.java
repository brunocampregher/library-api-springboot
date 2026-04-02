package com.brunocampregher.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brunocampregher.library.model.Author;
import com.brunocampregher.library.model.Book;
import com.brunocampregher.library.repository.AuthorRepository;
import com.brunocampregher.library.repository.BookRepository;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Book createBook(Book book, Long authorId) {
    Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));

    if (bookRepository.existsByTitle(book.getTitle())) {
      throw new RuntimeException("Book already exists.");
    }

    book.setAuthor(author);

    return bookRepository.save(book);
  }

  public List<Book> getBooks() {
    return bookRepository.findAll();
  }

  public void deleteBook(Long id) {
    if (!bookRepository.existsById(id)) {
      throw new RuntimeException("Book not found.");
    }

    bookRepository.deleteById(id);
  }
}
