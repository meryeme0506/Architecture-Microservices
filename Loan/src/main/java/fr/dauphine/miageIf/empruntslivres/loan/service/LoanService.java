package fr.dauphine.miageIf.empruntslivres.loan.service;
;
import fr.dauphine.miageIf.empruntslivres.loan.model.Loan;
import fr.dauphine.miageIf.empruntslivres.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Object getBookByIsbn(String isbn) {
        String url = "http://localhost:8000/books/isbn/" + isbn;
        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class, isbn);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Handle the case when the book is not found
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with ISBN " + isbn + " not found");
            } else {
                // Handle other HTTP errors
                throw e;
            }
        }
    }

    public Object getReaderById(long readerId) {
        String url = "http://localhost:8001/readers/id/" + readerId;
        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class, readerId);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Handle the case when the user is not found
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + readerId + " not found");
            } else {
                // Handle other HTTP errors
                throw e;
            }
        }
    }

    public Loan createLoan(String bookIsbn, long reader) {

        Object livre = getBookByIsbn(bookIsbn);
        Object user = getReaderById(reader);

        if (livre != null && user != null) {
            Loan loan = new Loan();
            loan.setBookIsbn(bookIsbn);
            loan.setReaderId(reader);
            loan.setDatePret(LocalDate.now());
            loan.setDateRetour(null);

            return loanRepository.save(loan);
        }
        return null;
    }
}


