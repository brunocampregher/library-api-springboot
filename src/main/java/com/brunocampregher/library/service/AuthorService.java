package com.brunocampregher.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brunocampregher.library.model.Author;
import com.brunocampregher.library.repository.AuthorRepository;

@Service
public class AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author createAuthor(Author author) {
    if (author.getName() == null || author.getName().isEmpty()) {
      throw new RuntimeException("Author name cannot be empty");
    }

    if (authorRepository.existsByName(author.getName())) {
      throw new RuntimeException("Author already exists.");
    }

    return authorRepository.save(author);
  }

  public List<Author> getAuthor() {
    return authorRepository.findAll();
  }

  public void deleteAuthor(Author author) {
    if (!authorRepository.existsById(author.getId())) {
      throw new RuntimeException("Author not found.");
    }

    authorRepository.deleteById(author.getId());
  }
}
