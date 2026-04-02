package com.brunocampregher.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunocampregher.library.model.Author;
import com.brunocampregher.library.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @PostMapping
  public Author create(@RequestBody Author author) {
    return authorService.createAuthor(author);
  }

  @GetMapping
  public List<Author> get() {
    return authorService.getAuthors();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    authorService.deleteAuthor(id);
  }
}
