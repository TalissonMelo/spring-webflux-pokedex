package com.talissonmelo.pokedex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.talissonmelo.pokedex.model.Pokemon;

public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String>{

}
