package net.emnaoumaima.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.emnaoumaima.springboot.entities.Client;
import net.emnaoumaima.springboot.exception.ResourceNotFoundException;
import net.emnaoumaima.springboot.repository.ClientRepository;


@RestController
@RequestMapping("/api/")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("client")
	public List<Client> getAllClients()
	{
		return this.clientRepository.findAll();
	}
	
	@GetMapping("client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping("client")
	public Client createClient(@Validated @RequestBody Client client) {
		return clientRepository.save(client);
	}

	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientId,
			@Validated @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientId));

		client.setNom(clientDetails.getNom());
		client.setPrenom(clientDetails.getPrenom());
		client.setDateDeNaissance(clientDetails.getDateDeNaissance());
		client.setCourriel(clientDetails.getCourriel());
		client.setTelephone(clientDetails.getTelephone());
		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	
	}
	
	@DeleteMapping("/client/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
