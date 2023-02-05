package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepository extends JpaRepository<Book, Long> {
}