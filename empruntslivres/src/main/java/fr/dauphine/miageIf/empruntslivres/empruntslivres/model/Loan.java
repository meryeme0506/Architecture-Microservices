package fr.dauphine.miageIf.empruntslivres.empruntslivres.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="isbn")
    private String isbn;
    @Column(name="lecteur")
    private String lecteur;
    @Column(name="date_pret")
    private String date_pret;
    @Column(name="date_retour")
    private String date_retour;
}
