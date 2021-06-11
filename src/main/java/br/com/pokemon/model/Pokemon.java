package br.com.pokemon.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="POKEMON")
public class Pokemon {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String num;
	
	private String name;
	
	@ElementCollection
	private List<String> type;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pokemon_pre_id")
    private List<PreEvolution> pre_evolution;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pokemon_pos_id")
    private List<NextEvolution> next_evolution;

	
	public Pokemon() {
		
	}
	
	public Pokemon(String num, String name, List<String> type, List<PreEvolution> pre_evolution,
			List<NextEvolution> next_evolution) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.type = type;
		this.pre_evolution = pre_evolution;
		this.next_evolution = next_evolution;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<PreEvolution> getPre_evolution() {
		return pre_evolution;
	}

	public void setPre_evolution(List<PreEvolution> pre_evolution) {
		this.pre_evolution = pre_evolution;
	}

	public List<NextEvolution> getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(List<NextEvolution> next_evolution) {
		this.next_evolution = next_evolution;
	}
		
	
}
