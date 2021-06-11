
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
@RequestMapping("/pokemon")
public class PokemonController  {

	@Autowired
	private PokemonService service;
	
	
	@GetMapping(value = "{id}")
	public Pokemon buscarPokemon(@PathVariable Long id) {
		return service.buscarPorId(id);		
	}
	
	@GetMapping
	public List<Pokemon> buscarPokemons() {
		return service.buscarPokemons();		
	}
	
	@GetMapping(value = "/PAGINA/QUANTIDADE/{page}/{quantidade}")
	public List<Pokemon> buscarPokemons(@PathVariable int page, 
										@PathVariable int quantidade) {
		return service.buscarPokemonsPage(page, quantidade);
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pokemon salvar(@RequestBody @Valid Pokemon pokemon) {
		return service.salvar(pokemon);
	}
	
	@PutMapping(value = "{id}")
	public Pokemon editarEstudante(@PathVariable Long id, 
								   @RequestBody @Valid Pokemon pokemon) {
		return service.editar(id, pokemon);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}
	
}

