package fr.dauphine.miageIf.empruntslivres.reader.repository;

import fr.dauphine.miageIf.empruntslivres.reader.medel.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    List<Reader> findAll();

    List<Reader> findById(Long id);

    List<Reader> findByNom(String nom);

    List<Reader> findByPrenom(String prenom);

    List<Reader> findByDate(String date);

    List<Reader> findByAdresse(String adresse);

}
