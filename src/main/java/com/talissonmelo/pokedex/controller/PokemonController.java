package com.talissonmelo.pokedex.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.pokedex.model.Pokemon;
import com.talissonmelo.pokedex.repository.PokemonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {

	@Autowired
	private PokemonRepository pokemonRepository;

	@GetMapping
	public Flux<Pokemon> findAllPokemons() {
		return pokemonRepository.findAll();
	}

	@GetMapping(value = "/{pokemonId}")
	public Mono<ResponseEntity<Pokemon>> findByPokemon(@PathVariable String pokemonId) {
		return pokemonRepository.findById(pokemonId).map(pokemon -> ResponseEntity.ok().body(pokemon))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Pokemon> insertPokemon(@RequestBody Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}

	@PutMapping(value = "/{pokemonId}")
	public Mono<ResponseEntity<Pokemon>> updatePokemon(@PathVariable String pokemonId, @RequestBody Pokemon pokemon) {

		return pokemonRepository.findById(pokemonId).flatMap(existingPokemon -> {
			existingPokemon.setName(pokemon.getName());
			existingPokemon.setCategory(pokemon.getCategory());
			existingPokemon.setSkil(pokemon.getSkil());
			existingPokemon.setWeight(pokemon.getWeight());
			return pokemonRepository.save(existingPokemon);

		}).map(updatePokemon -> ResponseEntity.ok().body(updatePokemon))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/{pokemonId}")
	public Mono<ResponseEntity<Void>> deletePokemon(@PathVariable String pokemonId) {
		return pokemonRepository.findById(pokemonId)
        .flatMap(existingPokemon ->
        	pokemonRepository.delete(existingPokemon)
                        .then(Mono.just(ResponseEntity.ok().<Void>build()))
        )
        .defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping
	public Mono<Void> deleteAllPokemons() {
		return pokemonRepository.deleteAll();
	}
}
