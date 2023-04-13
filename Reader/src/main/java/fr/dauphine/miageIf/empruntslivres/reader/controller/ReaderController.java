package fr.dauphine.miageIf.empruntslivres.reader.controller;

import fr.dauphine.miageIf.empruntslivres.reader.medel.Reader;
import fr.dauphine.miageIf.empruntslivres.reader.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("/readers")
    public List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    @GetMapping("/readers/{id}")
    public List<Reader> getReadersById(@PathVariable long id) {
        return readerRepository.findById(id);
    }

    @GetMapping("/readers/{nom}")
    public List<Reader> getReadersByNom(@PathVariable String nom) {
        return readerRepository.findByNom(nom);
    }

    @GetMapping("/readers/{prenom}")
    public List<Reader> getReadersByPrenom(@PathVariable String prenom) {
        return readerRepository.findByPrenom(prenom);
    }

    @GetMapping("/readers/{date_naissance}")
    public List<Reader> getReadersByDate(@PathVariable String date) {
        return readerRepository.findByDate(date);
    }

    @GetMapping("/readers/{adresse}")
    public List<Reader> getReadersByAdresse(@PathVariable String adresse) {
        return readerRepository.findByAdresse(adresse);
    }
}
