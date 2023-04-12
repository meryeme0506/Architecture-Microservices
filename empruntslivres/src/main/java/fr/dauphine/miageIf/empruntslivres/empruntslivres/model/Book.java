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
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="isbn")
    private String isbn;
    @Column(name="auteur")
    private String auteur;
    @Column(name="titre")
    private String titre;
    @Column(name="editeur")
    private String editeur;
    @Column(name="edition")
    private int edition;

}
