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

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{isbn}")
    public List<Book> getBooksByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @GetMapping("/books/{titre}")
    public List<Book> getBooksByTitre(@PathVariable String titre) {
        return bookRepository.findByTitre(titre);
    }

    @GetMapping("/books/{editeur}")
    public List<Book> getBooksByEditeur(@PathVariable String editeur) {
        return bookRepository.findByEditeur(editeur);
    }

    @GetMapping("/books/{edition}")
    public List<Book> getBooksByEdition(@PathVariable Long edition) {
        return bookRepository.findByEdition(edition);
    }
}
