package com.proxibanque.proxibanque.repository;

import com.proxibanque.proxibanque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
