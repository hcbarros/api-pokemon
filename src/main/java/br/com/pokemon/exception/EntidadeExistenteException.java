package br.com.pokemon.exception;

public class EntidadeExistenteException extends RuntimeException {

	public EntidadeExistenteException() {
		super("Já existe um pokemon com o número informado");
	}
}
