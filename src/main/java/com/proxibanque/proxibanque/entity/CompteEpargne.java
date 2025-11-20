package com.proxibanque.proxibanque.entity;

import jakarta.persistence.Entity;

@Entity
public class CompteEpargne extends Compte {


    private double tauxRemunerationAnnuel = 0.03;

    public double getTauxRemunerationAnnuel() {
        return tauxRemunerationAnnuel;
    }

    public void setTauxRemunerationAnnuel(double tauxRemunerationAnnuel) {
        this.tauxRemunerationAnnuel = tauxRemunerationAnnuel;
    }
}
