package br.com.pokemon.config;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.pokemon.repositorio.PokemonRepositorio;


@Configuration
@Profile("prod")
public class DataLoader {
	
	
	@Bean
	CommandLineRunner baseLoad(PokemonRepositorio repo) {
		 
		
		return args -> {
			
			
			
		};
	}

}