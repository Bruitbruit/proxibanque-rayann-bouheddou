package com.proxibanque.proxibanque.init;

import com.proxibanque.proxibanque.entity.Client;
import com.proxibanque.proxibanque.entity.CompteCourant;
import com.proxibanque.proxibanque.entity.CompteEpargne;
import com.proxibanque.proxibanque.repository.ClientRepository;
import com.proxibanque.proxibanque.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartUpInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;

    public StartUpInitializer(ClientRepository clientRepository,
                              CompteRepository compteRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client();
        c1.setNomFamille("Bouheddou");
        c1.setPrenomClient("Rayann");
        c1.setAdresseComplete("60 boulevard caca");
        c1.setCodePostalClient("75015");
        c1.setVilleClient("Paris");
        c1.setNumeroTelephone("0645989722");
        clientRepository.save(c1);


        CompteCourant cc1 = new CompteCourant();
        cc1.setNumeroCompte("CC-1001");
        cc1.setSoldeActuel(500);
        cc1.setDateOuvertureCompte(LocalDate.now());
        cc1.setClient(c1);
        compteRepository.save(cc1);


        CompteEpargne ce1 = new CompteEpargne();
        ce1.setNumeroCompte("CE-1001");
        ce1.setSoldeActuel(2000);
        ce1.setDateOuvertureCompte(LocalDate.now());
        ce1.setClient(c1);
        compteRepository.save(ce1);


        Client c2 = new Client();
        c2.setNomFamille("David");
        c2.setPrenomClient("Good");
        c2.setAdresseComplete("12 rue du good ");
        c2.setCodePostalClient("75008");
        c2.setVilleClient("Paris");
        c2.setNumeroTelephone("0612345678");
        clientRepository.save(c2);


        CompteCourant cc2 = new CompteCourant();
        cc2.setNumeroCompte("CC-2001");
        cc2.setSoldeActuel(1500);
        cc2.setDateOuvertureCompte(LocalDate.now());
        cc2.setClient(c2);
        compteRepository.save(cc2);

        System.out.println("===== Données initiales chargées ! =====");
    }
}
