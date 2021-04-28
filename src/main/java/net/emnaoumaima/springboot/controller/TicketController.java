package net.emnaoumaima.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.emnaoumaima.springboot.entities.Client;
import net.emnaoumaima.springboot.entities.Ticket;
import net.emnaoumaima.springboot.exception.ResourceNotFoundException;
import net.emnaoumaima.springboot.repository.ClientRepository;
import net.emnaoumaima.springboot.repository.MetRepository;
import net.emnaoumaima.springboot.repository.TableclientRepository;
import net.emnaoumaima.springboot.repository.TicketRepository;

@RestController
@RequestMapping("/api/")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private MetRepository metRepository;
	
	@Autowired
	private TableclientRepository tableclientRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@GetMapping("ticket")
	public List<Ticket> getAllTickets()
	{
		return this.ticketRepository.findAll();
	}
	
	@GetMapping("ticket/findfidele")
	public List<Ticket> getAllTicket(Ticket c)
	{
		List<Ticket> ticketclient= ticketRepository.findAll();
		return this.ticketRepository.findAll(Sort.by("client").descending());
	}
	
	
	
	@GetMapping("ticket/{id}")
	public ResponseEntity<Ticket> getClientById(@PathVariable(value = "id") Long ticketId)
			throws ResourceNotFoundException {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("ticket not found for this id :: " + ticketId));
		return ResponseEntity.ok().body(ticket);
	}
	
	@PostMapping("ticket")
	public Ticket createTicket(@Validated @RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	
	
	
}
