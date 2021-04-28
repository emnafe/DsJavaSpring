package net.emnaoumaima.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.emnaoumaima.springboot.entities.Met;


public interface MetRepository extends JpaRepository<Met, Long>{
	Met findByNom(String nom);
}
