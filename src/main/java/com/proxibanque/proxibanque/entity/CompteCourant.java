package com.proxibanque.proxibanque.entity;

import jakarta.persistence.Entity;

@Entity
public class CompteCourant extends Compte {


    private double montantDecouvertAutorise = 1000.0;

    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }
}
