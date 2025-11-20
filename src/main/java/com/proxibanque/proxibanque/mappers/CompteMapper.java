package com.proxibanque.proxibanque.mappers;

import com.proxibanque.proxibanque.dto.CompteDTO;
import com.proxibanque.proxibanque.entity.Compte;
import com.proxibanque.proxibanque.entity.CompteCourant;
import com.proxibanque.proxibanque.entity.CompteEpargne;

public class CompteMapper {

    public static CompteDTO toDTO(Compte compte) {
        CompteDTO dto = new CompteDTO();

        dto.setIdCompte(compte.getIdCompte());
        dto.setNumeroCompte(compte.getNumeroCompte());
        dto.setSoldeActuel(compte.getSoldeActuel());

        if (compte instanceof CompteCourant) {
            dto.setTypeCompte("courant");
        } else if (compte instanceof CompteEpargne) {
            dto.setTypeCompte("epargne");
        }

        return dto;
    }
}
