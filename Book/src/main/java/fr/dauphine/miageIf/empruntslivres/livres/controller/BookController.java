package fr.dauphine.miageIf.empruntslivres.livres.controller;

import fr.dauphine.miageIf.empruntslivres.livres.model.Book;
import fr.dauphine.miageIf.empruntslivres.livres.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/id/{id}")
    public Optional<Book> getBooksById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/books/isbn/{isbn}")
    public List<Book> getBooksByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @GetMapping("/books/titre/{titre}")
    public List<Book> getBooksByTitre(@PathVariable String titre) {
        return bookRepository.findByTitre(titre);
    }

    @GetMapping("/books/auteur/{auteur}")
    public List<Book> getBooksByAuteur(@PathVariable String auteur) {
        return bookRepository.findByAuteur(auteur);
    }

    @GetMapping("/books/editeur/{editeur}")
    public List<Book> getBooksByEditeur(@PathVariable String editeur) {
        return bookRepository.findByEditeur(editeur);
    }

    @GetMapping("/books/edition/{edition}")
    public List<Book> getBooksByEdition(@PathVariable Long edition) {
        return bookRepository.findByEdition(edition);
    }

    @PostMapping("books/add")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("books/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setIsbn(book.getIsbn());
            existingBook.setTitre(book.getTitre());
            existingBook.setAuteur(book.getAuteur());
            existingBook.setEditeur(book.getEditeur());
            existingBook.setEdition(book.getEdition());
            return bookRepository.save(existingBook);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with ID " + id + " not found");
        }
    }

    @DeleteMapping("books/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan with ID " + id + " not found");
        }
    }
}
