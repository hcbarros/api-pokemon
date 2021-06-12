package br.com.pokemon.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pokemon.exception.EntidadeExistenteException;
import br.com.pokemon.model.Pokemon;
import br.com.pokemon.repositorio.PokemonRepositorio;


@Service
public class PokemonService {

	
	@Autowired
	private PokemonRepositorio repo;
	
	
	public Pokemon salvar(Pokemon pokemon) {
		
		if(repo.existsByNum(pokemon.getNum())) {
			throw new EntidadeExistenteException();
		}
		
		return repo.save(pokemon);
	}	
	
	
	public Pokemon editar(String num, Pokemon pokemon) {		
		
		Pokemon p = buscarPorNum(num);
		
		if(!p.getNum().equals(pokemon.getNum())) {
			if(repo.existsByNum(pokemon.getNum())) {
				throw new EntidadeExistenteException();
			}
		}
		p.setNum(pokemon.getNum());
		p.setName(pokemon.getName());
		p.setType(pokemon.getType());
		p.setPre_evolution(pokemon.getPre_evolution());
		p.setNext_evolution(pokemon.getNext_evolution());
		
		return repo.save(p);
	}	
	
	
	public List<Pokemon> buscarPokemons() {
		return repo.findAll();
	}
	
	public List<Pokemon> buscarPokemonsPage(int pageNum, int quantidade) {
		
		Pageable paging = PageRequest.of(pageNum - 1, quantidade);
        Page<Pokemon> pagedResult = repo.findAll(paging);

		return pagedResult.toList();
	}
	
	public List<Pokemon> buscarPokemonsTipo(String tipo) {

		return repo.listByType(tipo);
	}
	
	public Pokemon buscarPorNum(String num) {
		Pokemon p = repo.findByNum(num);
		if(p == null) throw new EntityNotFoundException();
		return p;
	}

	public void delete(String num) {
		Pokemon p = buscarPorNum(num);
		repo.deleteById(p.getId());
	}
	
	
	
}
