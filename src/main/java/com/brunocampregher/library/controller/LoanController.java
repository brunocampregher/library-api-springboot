package com.brunocampregher.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunocampregher.library.model.Loan;
import com.brunocampregher.library.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
  private final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @PostMapping("/student/{studentId}/book/{bookId}")
  public Loan create(@PathVariable Long studentId, @PathVariable Long bookId) {
    return loanService.createLoan(studentId, bookId);
  }

  @GetMapping
  public List<Loan> get() {
    return loanService.getLoans();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    loanService.deleteLoan(id);
  }
}
