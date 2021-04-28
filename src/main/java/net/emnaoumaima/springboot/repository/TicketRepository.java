package net.emnaoumaima.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import net.emnaoumaima.springboot.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{


}
