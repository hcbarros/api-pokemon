package br.com.pokemon.config;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.pokemon.repositorio.PokemonRepositorio;
import br.com.pokemon.model.Pokemon;
import br.com.pokemon.model.PreEvolution;
import br.com.pokemon.model.NextEvolution;


@Configuration
@Profile("prod")
public class DataLoader {
	
	
	@Bean
	CommandLineRunner baseLoad(PokemonRepositorio repo) {
		 
		
		return args -> {
			
			
			List<Pokemon> pokemons = new ArrayList<>();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject obj = (JSONObject) jsonParser.parse(new FileReader("pokedex.json"));
			JSONArray jsonArray = (JSONArray) obj.get("pokemon");
			
			Iterator<JSONObject> iterator = jsonArray.iterator();
			while(iterator.hasNext()) {
				
				JSONObject next = (JSONObject) iterator.next();
				
				String num = (String) next.get("num");
				String name = (String) next.get("name");
				List<String> type = (List<String>) next.get("type");
				
				
//__________________________________LISTA - PRE_EVOLUTION_____________________________				
				
				
				List<PreEvolution> listPrev = null;
				if(next.containsKey("prev_evolution")) {
				
					listPrev = new ArrayList<>();
					JSONArray arrayPrev = (JSONArray) next.get("prev_evolution");
					Iterator<JSONObject> iteratorPrev = arrayPrev.iterator();
					while(iteratorPrev.hasNext()) {
						
						JSONObject nextPrev = (JSONObject) iteratorPrev.next();
						String numPrev = (String) nextPrev.get("num");
						String namePrev = (String) nextPrev.get("name");
						listPrev.add(new PreEvolution(numPrev, namePrev));
					}
				}

//__________________________________LISTA - NEXT_EVOLUTION_____________________________				
				
				
				List<NextEvolution> listNext = null;
				if(next.containsKey("next_evolution")) {
				
					listNext = new ArrayList<>();
					JSONArray arrayNext = (JSONArray) next.get("next_evolution");
					Iterator<JSONObject> iteratorNext = arrayNext.iterator();
					while(iteratorNext.hasNext()) {
						
						JSONObject nextNext = (JSONObject) iteratorNext.next();
						String numNext = (String) nextNext.get("num");
						String nameNext = (String) nextNext.get("name");
						listNext.add(new NextEvolution(numNext, nameNext));
					}
				}
				
//___________________________________________________________________________________________				
				
				
				Pokemon pokemon = new Pokemon(num, name, type, listPrev, listNext);
				
				pokemons.add(pokemon);
				
			}
			
			repo.saveAll(pokemons);
		};
	}

}