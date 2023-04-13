package fr.dauphine.miageIf.empruntslivres.empruntslivres.controller;

import fr.dauphine.miageIf.empruntslivres.empruntslivres.model.Loan;
import fr.dauphine.miageIf.empruntslivres.empruntslivres.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/loans/{id}")
    public List<Loan> getLoansById(@PathVariable long id) {
        return loanRepository.findById(id);
    }

    @GetMapping("/loans/{isbn}")
    public List<Loan> getLoansByISBN(@PathVariable String isbn) {
        return loanRepository.findByISBN(isbn);
    }

    @GetMapping("/loans/{lecteur}")
    public List<Loan> getLoansByLecteur(@PathVariable String lecteur) {
        return loanRepository.findByLecteur(lecteur);
    }

    @GetMapping("/loans/{date_pret}")
    public List<Loan> getLoansByDatePret(@PathVariable String date) {
        return loanRepository.findByDatePret(date);
    }

    @GetMapping("/loans/{date_retour}")
    public List<Loan> getLoansByDateRetour(@PathVariable String date) {
        return loanRepository.findByDateRetour(date);
    }
}
