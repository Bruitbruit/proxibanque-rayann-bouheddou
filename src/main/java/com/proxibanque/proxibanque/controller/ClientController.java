package com.proxibanque.proxibanque.controller;

import com.proxibanque.proxibanque.dto.ClientDTO;
import com.proxibanque.proxibanque.mappers.ClientMapper;
import com.proxibanque.proxibanque.entity.Client;
import com.proxibanque.proxibanque.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .toList();
    }


    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
