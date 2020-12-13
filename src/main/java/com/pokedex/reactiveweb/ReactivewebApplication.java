package com.pokedex.reactiveweb;

import com.pokedex.reactiveweb.model.Pokemon;
import com.pokedex.reactiveweb.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactivewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivewebApplication.class, args); }

		@Bean
		CommandLineRunner init (ReactiveMongoOperations operations, PokemonRepository repository) {
			return args -> {
				Flux<Pokemon> pokemonFlux = Flux.just(
						new Pokemon(null, "Bulbassauro", "Semente", "OverGrow", 6.09, "Vermelho", 50.2),
						new Pokemon(null, "Charizard", "Fogo", "Blaze", 90.05, "Verde", 45.65),
						new Pokemon(null, "Caterpie", "Minhoca", "Poeira do Escudo", 2.09, "Amarelo", 96.45),
						new Pokemon(null, "Blastoise", "Marisco", "Torrente", 6.09, "Rosa", 75.96))
						.flatMap(repository::save);

				pokemonFlux
						.thenMany(repository.findAll())
						.subscribe(System.out::println);
			};
		}


}
