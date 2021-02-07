package com.thiago.starwars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.starwars.domain.Planeta;
import com.thiago.starwars.repository.PlanetaRepository;
import com.thiago.starwars.services.exception.ObjectNotFoundException;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

	public List<Planeta> findAll() {
		return planetaRepository.findAll();
	}

	public Optional<Planeta> findById(String id) {
		Optional<Planeta> planeta = planetaRepository.findById(id);
		if (planeta.isPresent()) {
			return planeta;
		}
		throw new ObjectNotFoundException("Planeta não Encontrado");
	}

	public Iterable<Planeta> findByNome(String nome) {
		Iterable<Planeta> nomePlaneta = planetaRepository.findByNomeContainingIgnoreCase(nome);
		return nomePlaneta;
	}

	public Planeta insert(Planeta planeta) {
		return planetaRepository.save(planeta);
	}

	public void delete(String id) {
		findById(id);
		planetaRepository.deleteById(id);
	}
}
