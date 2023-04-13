package fr.dauphine.miageIf.empruntslivres.emprunts.medel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprunt {
    private int id;
    private Lecteur lecteur;
    private Book livre;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
}
