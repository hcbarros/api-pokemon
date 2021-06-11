package br.com.pokemon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PreEvolution {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String num;
	
	private String name;

	
	public PreEvolution() {
		
	}

	public PreEvolution(Long id, String num, String name) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
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
	
}
