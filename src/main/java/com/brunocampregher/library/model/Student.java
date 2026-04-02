package com.brunocampregher.library.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  private Long id;

  private String name;
  private String surname;
  private String email;

  @OneToMany(mappedBy = "student")
  private List<Loan> loans = new ArrayList<>();

  private Integer loanCount;
}
