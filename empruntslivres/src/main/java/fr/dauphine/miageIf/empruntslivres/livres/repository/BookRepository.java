package fr.dauphine.miageIf.empruntslivres.livres.repository;

import fr.dauphine.miageIf.empruntslivres.livres.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findByIsbn(String isbn);

    List<Book> findByAuteur(String auteur);

    List<Book> findByTitre(String titre);

    List<Book> findByEditeur(String editeur);

    List<Book> findByEdition(int edition);

}
