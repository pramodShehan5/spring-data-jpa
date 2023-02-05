package com.pramod.springDataJpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long bookId;
    private String title;
    private long year;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "authorId",
            referencedColumnName = "authorId"
    )
    private Author author;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "libraryId",
            referencedColumnName = "libraryId"
    )
    private Library library;
}