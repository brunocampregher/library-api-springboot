package com.brunocampregher.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunocampregher.library.model.Student;
import com.brunocampregher.library.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping
  public Student create(@RequestBody Student student) {
    return studentService.createStudent(student);
  }

  @GetMapping
  public List<Student> get() {
    return studentService.getStudents();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    studentService.deleteStudent(id);
  }
}
