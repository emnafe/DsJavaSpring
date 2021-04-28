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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.emnaoumaima.springboot.entities.Met;
import net.emnaoumaima.springboot.exception.ResourceNotFoundException;
import net.emnaoumaima.springboot.repository.MetRepository;

@RestController
@RequestMapping("/api/")
public class MetController {

	@Autowired
	private MetRepository metRepository;

	@GetMapping("met")
	public List<Met> getAllMets() {
		return this.metRepository.findAll();
	}

	@GetMapping("met/{id}")
	public ResponseEntity<Met> getClientById(@PathVariable(value = "id") String metId)
			throws ResourceNotFoundException {
		Met met = metRepository.findByNom(metId);
		// .orElseThrow(() -> new ResourceNotFoundException("Met not found for this
		// id :: " + metId));
		return ResponseEntity.ok().body(met);
	}

	@PostMapping("met")
	public Met createMet(@Validated @RequestBody Met met) {
		return metRepository.save(met);
	}
	
	@DeleteMapping("/met/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") String metId)
			throws ResourceNotFoundException {
		Met met = metRepository.findByNom(metId);
				//.orElseThrow(() -> new ResourceNotFoundException("Met not found for this id :: " + clientId));

		metRepository.delete(met);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
