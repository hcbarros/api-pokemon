
package br.com.pokemon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemon.model.Pokemon;
import br.com.pokemon.service.PokemonService;


@RestController
@Validated
@RequestMapping("/api")
public class PokemonController  {

	@Autowired
	private PokemonService service;
	
	
	@GetMapping(value = "/pokemon/{num}")
	public Pokemon buscarPokemon(@PathVariable String num) {
		return service.buscarPorNum(num);		
	}
	
	@GetMapping(value = "/pokemons")
	public List<Pokemon> buscarPokemons() {
		return service.buscarPokemons();		
	}
	
	@GetMapping(value = "/pokemons/{page}/{quantidade}")
	public List<Pokemon> buscarPokemons(@PathVariable int page, 
										@PathVariable int quantidade) {
		return service.buscarPokemonsPage(page, quantidade);
	}
	
	@GetMapping(value = "/pokemons/{type}")
	public List<Pokemon> buscarPokemonsTipo(@PathVariable String type) {
		return service.buscarPokemonsTipo(type);
	}
	

	@PostMapping(value = "/pokemon")
	@ResponseStatus(HttpStatus.CREATED)
	public Pokemon salvar(@RequestBody @Valid Pokemon pokemon) {
		return service.salvar(pokemon);
	}
	
	@PutMapping(value = "/pokemon/{num}")
	public Pokemon editarEstudante(@PathVariable String num, 
								   @RequestBody @Valid Pokemon pokemon) {
		return service.editar(num, pokemon);
	}
	
	@DeleteMapping(value = "/pokemon/{num}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable String num) {
		service.delete(num);
	}
	
}

