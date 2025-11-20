package com.proxibanque.proxibanque.mappers;

import com.proxibanque.proxibanque.dto.ClientDTO;
import com.proxibanque.proxibanque.dto.CompteDTO;
import com.proxibanque.proxibanque.entity.Client;

import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();

        dto.setIdClient(client.getIdClient());
        dto.setNomFamille(client.getNomFamille());
        dto.setPrenomClient(client.getPrenomClient());
        dto.setVilleClient(client.getVilleClient());

        dto.setComptes(
                client.getComptes().stream()
                        .map(CompteMapper::toDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
