package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

interface LibraryRepository extends JpaRepository<Library, Long> {
}