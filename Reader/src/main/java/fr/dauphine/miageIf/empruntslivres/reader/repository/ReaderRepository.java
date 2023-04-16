package fr.dauphine.miageIf.empruntslivres.reader.repository;

import fr.dauphine.miageIf.empruntslivres.reader.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    List<Reader> findAll();

    Optional<Reader> findById(Long id);

    List<Reader> findByNom(String nom);

    List<Reader> findByPrenom(String prenom);

    List<Reader> findByDateNaissance(String date);

    List<Reader> findByAdresse(String adresse);

}
