package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

interface AuthorRepository extends JpaRepository<Author, Long> {
}