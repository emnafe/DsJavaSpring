package net.emnaoumaima.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.emnaoumaima.springboot.entities.Compose;

public interface ComposeRepository extends JpaRepository<Compose, Long>{

}
