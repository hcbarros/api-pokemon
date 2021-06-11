package br.com.pokemon.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pokemon.model.Pokemon;


@Repository
public interface PokemonRepositorio extends JpaRepository<Pokemon, Long>, 
				 							PagingAndSortingRepository<Pokemon, Long> {
	
	
	boolean existsByNum(String num);
	
}
