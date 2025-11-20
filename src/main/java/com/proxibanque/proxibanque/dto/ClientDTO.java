package com.proxibanque.proxibanque.dto;

import java.util.List;

public class ClientDTO {

    private Long idClient;
    private String nomFamille;
    private String prenomClient;
    private String villeClient;

    private List<CompteDTO> comptes;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomNomFamille) {
        this.nomFamille = nomNomFamille;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public List<CompteDTO> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteDTO> comptes) {
        this.comptes = comptes;
    }
}
