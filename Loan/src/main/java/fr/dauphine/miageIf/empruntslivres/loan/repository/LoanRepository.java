package fr.dauphine.miageIf.empruntslivres.loan.repository;

import fr.dauphine.miageIf.empruntslivres.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long>  {

    List<Loan> findAll();

    Optional<Loan> findById(Long id);

    List<Loan> findByISBN(String isbn);

    List<Loan> findByLecteur(String lecteur);

    List<Loan> findByDatePret(String date);

    List<Loan> findByDateRetour(String date);

}
