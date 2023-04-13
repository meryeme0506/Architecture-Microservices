package fr.dauphine.miageIf.empruntslivres.empruntslivres.repository;

import fr.dauphine.miageIf.empruntslivres.empruntslivres.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findAll();

    List<Loan> findById(Long id);

    List<Loan> findByISBN(String isbn);

    List<Loan> findByLecteur(String lecteur);

    List<Loan> findByDatePret(String date);

    List<Loan> findByDateRetour(String date);

}
