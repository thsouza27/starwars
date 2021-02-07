package com.thiago.starwars.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.thiago.starwars.domain.Films;

@FeignClient(url = "https://swapi.dev/api/planets/", name = "swapi")
public interface FilmsService {

	@GetMapping("/?search={nome}")
	Films buscarFilmes(@PathVariable("nome") String nome);
}
