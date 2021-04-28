package net.emnaoumaima.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.emnaoumaima.springboot.entities.TableClient;
import net.emnaoumaima.springboot.exception.ResourceNotFoundException;
import net.emnaoumaima.springboot.repository.TableclientRepository;

@RestController
@RequestMapping("/api/")
public class TableclientController {

	@Autowired
	private TableclientRepository tableclientRepository;

	@GetMapping("tableclient")
	public List<TableClient> getAllClients() {
		return this.tableclientRepository.findAll();
	}
	
	@GetMapping("tableclient/{id}")
	public ResponseEntity<TableClient> getClientById(@PathVariable(value = "id") Long tableclientId)
			throws ResourceNotFoundException {
		TableClient tableClient = tableclientRepository.findById(tableclientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + tableclientId));
		return ResponseEntity.ok().body(tableClient);
	}
	
	@PostMapping("tableclient")
	public TableClient createTableClient(@Validated @RequestBody TableClient tableClient) {
		return tableclientRepository.save(tableClient);
	}
}
