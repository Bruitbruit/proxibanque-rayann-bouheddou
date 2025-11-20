package com.proxibanque.proxibanque.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    @Column(unique = true)
    private String numeroCompte;

    private double soldeActuel;

    private LocalDate dateOuvertureCompte;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    // --- Getters & Setters ---

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeActuel() {
        return soldeActuel;
    }

    public void setSoldeActuel(double soldeActuel) {
        this.soldeActuel = soldeActuel;
    }

    public LocalDate getDateOuvertureCompte() {
        return dateOuvertureCompte;
    }

    public void setDateOuvertureCompte(LocalDate dateOuvertureCompte) {
        this.dateOuvertureCompte = dateOuvertureCompte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
