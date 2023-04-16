package fr.dauphine.miageIf.empruntslivres.loan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@Table(name="loan")
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="isbn")
    private String bookIsbn;
    @Column(name="readerId")
    private long readerId;
    @Column(name="datePret")
    private LocalDate datePret;
    @Column(name="dateRetour")
    private LocalDate dateRetour;
}

