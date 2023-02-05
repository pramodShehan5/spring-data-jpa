package com.pramod.springDataJpa.repository;

import com.pramod.springDataJpa.model.Author;
import com.pramod.springDataJpa.model.Book;
import com.pramod.springDataJpa.model.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBook() {
        Author author = Author.builder()
                .authorName("James")
                .emailAddress("james@gmail.com")
                .build();

        Library library = Library.builder()
                .libraryName("lib2")
                .location("USA")
                .build();

        Book book = Book.builder()
                .title("Sherlock Homes")
                .year(2022)
                .author(author)
                .library(library)
                .build();
       bookRepository.save(book);
    }

    @Test
    public void getBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }
}