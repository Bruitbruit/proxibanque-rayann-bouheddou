package com.proxibanque.proxibanque.repository;

import com.proxibanque.proxibanque.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
