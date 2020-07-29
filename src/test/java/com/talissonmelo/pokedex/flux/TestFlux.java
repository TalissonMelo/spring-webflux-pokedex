package com.talissonmelo.pokedex.flux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestFlux {

	@Test
	public void FluxTestInitial() {
		Flux.empty();
	}

	@Test
	public void FluxReturnPokemon() {
		Flux<String> flux = Flux.just("Pokedex");
		flux.subscribe(System.out::println);
	}

	@Test
	public void FluxFindByInteger() {
		Mono<Integer> mono = Mono.just(10);
		mono.subscribe(System.out::println);
	}

	@Test
	public void FluxPokemon() {
		Flux<String> flux = Flux.just("Bulbassauro", "Charizard", "Caterpie", "Blastoise");
		flux.subscribe(System.out::println);
	}
}
