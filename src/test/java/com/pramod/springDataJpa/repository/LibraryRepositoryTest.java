package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void saveLibrary() {
        Library library = new Library(1, "lib1", "Singapore");
    }
}