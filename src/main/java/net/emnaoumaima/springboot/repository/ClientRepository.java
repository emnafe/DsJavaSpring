package net.emnaoumaima.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.emnaoumaima.springboot.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
