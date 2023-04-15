package fr.dauphine.miageIf.empruntslivres.livres.controller;

import fr.dauphine.miageIf.empruntslivres.livres.model.Book;
import fr.dauphine.miageIf.empruntslivres.livres.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RequestMapping("/api")
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
    @PostMapping("books/add/{book}")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("books/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setIsbn(book.getIsbn());
            existingBook.setTitre(book.getTitre());
            existingBook.setEditeur(book.getEditeur());
            existingBook.setEdition(book.getEdition());
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    @DeleteMapping("books/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
