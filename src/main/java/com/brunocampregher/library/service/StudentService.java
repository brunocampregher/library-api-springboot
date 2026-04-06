package com.brunocampregher.library.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.brunocampregher.library.model.Student;
import com.brunocampregher.library.repository.StudentRepository;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student createStudent(Student student) {
    if (student.getDni() == null || student.getDni().isEmpty()) {
      throw new RuntimeException("Student DNI cannot be empty");
    }
    
    if (student.getName() == null || student.getName().isEmpty()) {
      throw new RuntimeException("Student name cannot be empty");
    }

    if (studentRepository.existsByDni(student.getDni())) {
      throw new RuntimeException("A student with this DNI already exists.");
    }

    student.setLoanCount(0);

    return studentRepository.save(student);
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public void deleteStudent(Long id) {
    if (!studentRepository.existsById(id)) {
      throw new RuntimeException("Student not found.");
    }
    studentRepository.deleteById(id);
  }
}