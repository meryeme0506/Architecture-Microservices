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


    public Object getBookByIsbn(String isbn) {
        String url = "http://localhost:8000/api/books/isbn/" + isbn;
        try {
            RestTemplate restTemplate= new RestTemplate();
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class, isbn);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with ISBN " + isbn + " not found");
            } else {
                throw e;
            }
        }
    }

    public Object getReaderById(long readerId) {
        String url = "http://localhost:8001/api/readers/id/" + readerId;
        try {
            RestTemplate restTemplate= new RestTemplate();
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class, readerId);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + readerId + " not found");
            } else {
                throw e;
            }
        }
    }

}


