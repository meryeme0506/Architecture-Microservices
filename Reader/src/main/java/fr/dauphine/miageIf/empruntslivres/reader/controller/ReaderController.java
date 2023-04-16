package fr.dauphine.miageIf.empruntslivres.reader.controller;

import fr.dauphine.miageIf.empruntslivres.reader.model.Reader;
import fr.dauphine.miageIf.empruntslivres.reader.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("/readers")
    public List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    @GetMapping("/readers/id/{id}")
    public Optional<Reader> getReadersById(@PathVariable long id) {
        return readerRepository.findById(id);
    }

    @GetMapping("/readers/nom/{nom}")
    public List<Reader> getReadersByNom(@PathVariable String nom) {
        return readerRepository.findByNom(nom);
    }

    @GetMapping("/readers/prenom/{prenom}")
    public List<Reader> getReadersByPrenom(@PathVariable String prenom) {
        return readerRepository.findByPrenom(prenom);
    }

    @GetMapping("/readers/date/{dateNaissance}")
    public List<Reader> getReadersByDate(@PathVariable String dateNaissance) {
        return readerRepository.findByDateNaissance(dateNaissance);
    }

    @GetMapping("/readers/adresse/{adresse}")
    public List<Reader> getReadersByAdresse(@PathVariable String adresse) {
        return readerRepository.findByAdresse(adresse);
    }

    @PostMapping("/readers/create")
    public Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }

    @PutMapping("/readers/update/{id}")
    public Reader updateReader(@PathVariable long id, @RequestBody Reader reader) {
        Reader exitingReader = readerRepository.findById(id).orElse(null);;
        if(exitingReader!=null) {
            exitingReader.setNom(reader.getNom());
            exitingReader.setPrenom(reader.getPrenom());
            exitingReader.setDateNaissance(reader.getDateNaissance());
            exitingReader.setAdresse(reader.getAdresse());
            exitingReader.setGenre(reader.getGenre());
            return readerRepository.save(exitingReader);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reader with ID " + id + " not found");
        }

    }

    @DeleteMapping("/readers/delete/{id}")
    public void deleteReader(@PathVariable long id) {
        Reader reader = readerRepository.findById(id).orElse(null);
        if (reader != null) {
            readerRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan with ID " + id + " not found");
        }
    }
}
