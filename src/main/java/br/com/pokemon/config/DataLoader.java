package br.com.pokemon.config;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
			
			JSONParser jsonParser = new JSONParser();
			JSONObject obj = (JSONObject) jsonParser.parse(new FileReader("pokedex.json"));
			JSONArray jsonArray = (JSONArray) obj.get("pokemon");
			
			Iterator<JSONObject> iterator = jsonArray.iterator();
			while(iterator.hasNext()) {
				
				obj = (JSONObject) iterator.next();
				
				
			}
			
		};
	}

}