package com.brunocampregher.library.repository;

import com.brunocampregher.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  boolean existsByName(String name);
}
