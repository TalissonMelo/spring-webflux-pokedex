package com.talissonmelo.pokedex.mono;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class TestMono {

	@Test
	public void MonoTestInitial() {
		Mono<String> mono = Mono.empty();
	}
	
	@Test
	public void MonoReturnPokemon() {
		Mono<String> mono = Mono.just("Pokemon");
		mono.subscribe(System.out::println);
	}
	
	@Test
	public void MonoFindByInteger() {
		Mono<Integer> mono = Mono.just(10);
		mono.subscribe(System.out::println);
	}
	
	@Test
	public void MonoHandlerException() {
		Mono<String> mono = Mono.error(new RuntimeException("Ocorreu uma exceção."));
		//mono.subscribe(System.out::println);
	}
}
