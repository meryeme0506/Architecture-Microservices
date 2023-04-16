package fr.dauphine.miageIf.empruntslivres.loan.controller;

import fr.dauphine.miageIf.empruntslivres.loan.model.Loan;
import fr.dauphine.miageIf.empruntslivres.loan.repository.LoanRepository;
import fr.dauphine.miageIf.empruntslivres.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanService loanService;

    @GetMapping("/loans")
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/loans/id/{id}")
    public Optional<Loan> getLoansById(@PathVariable long id) {
        return loanRepository.findById(id);
    }

    @GetMapping("/loans/isbn/{isbn}")
    public List<Loan> getLoansByBookISBN(@PathVariable String isbn) {
        return loanRepository.findByBookIsbn(isbn);
    }

    @GetMapping("/loans/reader/{redearId}")
    public List<Loan> getLoansByLecteur(@PathVariable Long redearId) {
        return loanRepository.findByReaderId(redearId);
    }

    @GetMapping("/loans/datePret/{datePret}")
    public List<Loan> getLoansByDatePret(@PathVariable LocalDate datePret) {
        return loanRepository.findByDatePret(datePret);
    }

    @GetMapping("/loans/dateRetour/{dateRetour}")
    public List<Loan> getLoansByDateRetour(@PathVariable String dateRetour) {
        return loanRepository.findByDateRetour(dateRetour);
    }

    @PostMapping("loans/create/{bookIsbn}/{readerId}")
    public Loan createLoan(@PathVariable String bookIsbn, @PathVariable long readerId) {

        Object book = loanService.getBookByIsbn(bookIsbn);
        Object reader = loanService.getReaderById(readerId);

        if (book != null && reader != null) {

            Loan loan = new Loan();
            loan.setBookIsbn(bookIsbn);
            loan.setReaderId(readerId);
            loan.setDatePret(LocalDate.now());
            loan.setDateRetour(null);
            return loanRepository.save(loan);
        }
        return null;
    }

    @PutMapping("/loans/returnToday/{id}")
    public Loan returnLoanToday(@PathVariable Long id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            if (loan.getDateRetour() == null) {
                loan.setDateRetour(LocalDate.now());
                return loanRepository.save(loan);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan with ID " + id + " not found");
        }
        return null;
    }

    @PutMapping("/loans/return/{id}/{dateRetour}")
    public Loan returnLoan(@PathVariable Long id, @PathVariable LocalDate dateRetour) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            if (loan.getDateRetour() == null) {
                loan.setDateRetour(dateRetour);
                return loanRepository.save(loan);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan with ID " + id + " not found");
        }
        return null;
    }

    @PutMapping("/loans/update/{id}")
    public Loan updateLoan(@PathVariable Long id, @RequestBody Loan updatedLoan) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            loan.setBookIsbn(updatedLoan.getBookIsbn());
            loan.setReaderId(updatedLoan.getReaderId());
            loan.setDatePret(updatedLoan.getDatePret());
            loan.setDateRetour(updatedLoan.getDateRetour());
            return loanRepository.save(loan);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan with ID " + id + " not found");
        }
    }

    @DeleteMapping("/loans/delete/{id}")
    public void deleteLoan(@PathVariable Long id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            loanRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan with ID " + id + " not found");
        }
    }
}
