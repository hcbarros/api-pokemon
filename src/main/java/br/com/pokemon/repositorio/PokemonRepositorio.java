package br.com.pokemon.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pokemon.model.Pokemon;

@Repository
public interface PokemonRepositorio extends JpaRepository<Pokemon, Long>, 
				 							PagingAndSortingRepository<Pokemon, Long> {
	
	
	boolean existsByNum(String num);
	
	Pokemon	findByNum(String num);
	
	@Query(value = "select * from POKEMON where id in (select pokemon_id "
			+ "from pokemon_type where type = ?1)", nativeQuery = true)
	List<Pokemon> listByType(String type);
}
