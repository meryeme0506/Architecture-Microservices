package fr.dauphine.miageIf.empruntslivres.loan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="isbn")
    private String isbn;
    @Column(name="lecteur")
    private Reader lecteur;
    @Column(name="date_pret")
    private LocalDate date_pret;
    @Column(name="date_retour")
    private LocalDate date_retour;
}

