package com.thiago.starwars.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.starwars.domain.Films;
import com.thiago.starwars.domain.Planeta;
import com.thiago.starwars.repository.FilmsService;
import com.thiago.starwars.services.PlanetaService;

@RestController
@RequestMapping(value = "/planetas")
public class PlanetaResource {

	@Autowired
	private PlanetaService planetaService;

	@Autowired
	private FilmsService filmsService;

	@GetMapping
	public ResponseEntity<List<Planeta>> findAll() {
		List<Planeta> list = planetaService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Planeta>> findById(@PathVariable String id) {
		Optional<Planeta> planeta = planetaService.findById(id);
		return ResponseEntity.ok().body(planeta);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Iterable<Planeta>> findByNome(@PathVariable String nome) {
		Iterable<Planeta> planeta = planetaService.findByNome(nome);
		return ResponseEntity.ok().body(planeta);
	}

	@GetMapping("/filmes/{nome}")
	public ResponseEntity<Films> getFilms(@PathVariable String nome) {
		Films films = filmsService.buscarFilmes(nome);
		return films != null ? ResponseEntity.ok().body(films) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Planeta> insert(@RequestBody Planeta planeta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(planetaService.insert(planeta));
	}

	@PutMapping
	public ResponseEntity<Planeta> update(@RequestBody Planeta planeta) {
		return ResponseEntity.ok().body(planetaService.insert(planeta));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		planetaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
