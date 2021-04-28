package net.emnaoumaima.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.emnaoumaima.springboot.entities.TableClient;

public interface TableclientRepository extends JpaRepository<TableClient, Long>{
	
}
