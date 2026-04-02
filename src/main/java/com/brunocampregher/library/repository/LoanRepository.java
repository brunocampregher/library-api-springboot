package com.brunocampregher.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunocampregher.library.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
