package com.thiago.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiago.starwars.domain.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	public Iterable<Planeta> findByNomeContainingIgnoreCase(String nome);
}
