package com.brunocampregher.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brunocampregher.library.model.Book;
import com.brunocampregher.library.model.Loan;
import com.brunocampregher.library.model.Student;
import com.brunocampregher.library.repository.BookRepository;
import com.brunocampregher.library.repository.LoanRepository;
import com.brunocampregher.library.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class LoanService {
  private final LoanRepository loanRepository;
  private final StudentRepository studentRepository;
  private final BookRepository bookRepository;

  public LoanService(LoanRepository loanRepository, StudentRepository studentRepository, BookRepository bookRepository) {
    this.loanRepository = loanRepository;
    this.studentRepository = studentRepository;
    this.bookRepository = bookRepository;
  }

  @Transactional
  public Loan createLoan(Long studentId, Long bookId) {
    Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found."));

    if (book.getStock() <= 0) {
      throw new RuntimeException("Book not stock.");
    }

    Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found."));

    if (student.getLoanCount() >= 3) {
      throw new RuntimeException("Student reached max loans limit.");
    }

    book.setStock(book.getStock() - 1);

    student.setLoanCount(student.getLoanCount() + 1);

    bookRepository.save(book);

    studentRepository.save(student);

    Loan loan = new Loan();

    loan.setStudent(student);

    loan.setBook(book);

    loan.setActive(true);

    return loanRepository.save(loan);
  }

  public List<Loan> getLoans() {
    return loanRepository.findAll();
  }

  @Transactional
  public void deleteLoan(Long id) {
    Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found."));

    if (!loan.getActive()) {
      throw new RuntimeException("This loan is already returned.");
    }

    Book book = loan.getBook();

    Student student = loan.getStudent();

    book.setStock(book.getStock() + 1);

    student.setLoanCount(student.getLoanCount() - 1);

    loan.setActive(false);

    bookRepository.save(book);
    
    studentRepository.save(student);

    loanRepository.save(loan);

  }
}
