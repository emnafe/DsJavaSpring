package net.emnaoumaima.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.emnaoumaima.springboot.entities.Compose;
import net.emnaoumaima.springboot.repository.ComposeRepository;

@RestController
@RequestMapping("/api/")
public class ComposeController {

	@Autowired
	private ComposeRepository composeRepository;
	
	@GetMapping("compose")
	public List<Compose> getAllComposes()
	{
		return this.composeRepository.findAll();
	}
}
