package com.proxibanque.proxibanque.controller;

import com.proxibanque.proxibanque.entity.Client;
import com.proxibanque.proxibanque.entity.Compte;
import com.proxibanque.proxibanque.entity.CompteCourant;
import com.proxibanque.proxibanque.entity.CompteEpargne;
import com.proxibanque.proxibanque.repository.ClientRepository;
import com.proxibanque.proxibanque.repository.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    private final CompteRepository compteRepository;
    private final ClientRepository clientRepository;

    public CompteController(CompteRepository compteRepository,
                            ClientRepository clientRepository) {
        this.compteRepository = compteRepository;
        this.clientRepository = clientRepository;
    }


    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }


    @GetMapping("/client/{idClient}")
    public List<Compte> getComptesByClient(@PathVariable Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        return client.getComptes();
    }

    @PostMapping("/courant/{idClient}")
    public CompteCourant creerCompteCourant(@PathVariable Long idClient,
                                            @RequestParam String numeroCompte,
                                            @RequestParam double soldeInitial) {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        CompteCourant compte = new CompteCourant();
        compte.setNumeroCompte(numeroCompte);
        compte.setSoldeActuel(soldeInitial);
        compte.setDateOuvertureCompte(LocalDate.now());
        compte.setClient(client);

        return compteRepository.save(compte);
    }


    @PostMapping("/epargne/{idClient}")
    public CompteEpargne creerCompteEpargne(@PathVariable Long idClient,
                                            @RequestParam String numeroCompte,
                                            @RequestParam double soldeInitial) {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        CompteEpargne compte = new CompteEpargne();
        compte.setNumeroCompte(numeroCompte);
        compte.setSoldeActuel(soldeInitial);
        compte.setDateOuvertureCompte(LocalDate.now());
        compte.setClient(client);

        return compteRepository.save(compte);
    }


    @PostMapping("/{idCompte}/depot")
    public Compte depot(@PathVariable Long idCompte,
                        @RequestParam double montant) {

        if (montant <= 0) {
            throw new RuntimeException("Montant invalide");
        }

        Compte compte = compteRepository.findById(idCompte)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        compte.setSoldeActuel(compte.getSoldeActuel() + montant);

        return compteRepository.save(compte);
    }


    @PostMapping("/{idCompte}/retrait")
    public Compte retrait(@PathVariable Long idCompte,
                          @RequestParam double montant) {

        if (montant <= 0) {
            throw new RuntimeException("Montant invalide");
        }

        Compte compte = compteRepository.findById(idCompte)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        double nouveauSolde = compte.getSoldeActuel() - montant;


        if (compte instanceof CompteCourant cc) {
            if (nouveauSolde < -cc.getMontantDecouvertAutorise()) {
                throw new RuntimeException("Dépasse le découvert autorisé");
            }
        } else if (compte instanceof CompteEpargne) {
            if (nouveauSolde < 0) {
                throw new RuntimeException("Solde insuffisant");
            }
        }

        compte.setSoldeActuel(nouveauSolde);
        return compteRepository.save(compte);
    }
}
