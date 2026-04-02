package com.brunocampregher.library.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String isbn;

  private Integer stock;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @OneToMany(mappedBy = "book")
  private List<Loan> loans = new ArrayList<>();

  @Version
  private Long version;
}
