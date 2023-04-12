package fr.dauphine.miageIf.empruntslivres.empruntslivres.controller;

import fr.dauphine.miageIf.empruntslivres.empruntslivres.model.Book;
import fr.dauphine.miageIf.empruntslivres.empruntslivres.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/{isbn}")
    public List<Book> getBooks(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
