package com.pramod.springDataJpa.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "t_author",
        uniqueConstraints = @UniqueConstraint(
                name = "author_email_unique",
                columnNames = "email_address"
        )
)
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private long authorId;
    private String authorName;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailAddress;

    @OneToOne(
            mappedBy = "author"
    )
    private Book book;
}