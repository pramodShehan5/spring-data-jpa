package com.pramod.springDataJpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_library")
public class Library {
    @Id
    @SequenceGenerator(
            name = "library_sequence",
            sequenceName = "library_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long libraryId;
    private String libraryName;
    private String location;

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "libraryId",
//            referencedColumnName = "libraryId"
//    )
//    private List<Book> books;
}