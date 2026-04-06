package com.brunocampregher.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunocampregher.library.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  boolean existsByDni(String dni);
}
