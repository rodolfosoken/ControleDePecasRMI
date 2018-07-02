package servidor;

import java.util.Set;
import java.util.UUID;

import interfaces.Part;

/**
 * Classe que Implementa a peça (Part)
 * **/
public class PartImpl implements Part {
	
	/** 
	 * Código da peça 
	 * */
	private UUID partCod;
	/**
	 * Nome da Peça
	 * **/
	private String partNome;
	/**
	 * Descrição da Peça
	 * **/
	private String partDesc;
	/***
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 * **/
	private Set<Part> subParts;
	
	/**
	 * Gera uma nova peça com os parâmetros.
	 * @param nome o nome da peça
	 * @param descricao a descrição da peça
	 * @param subParts as subparts da peça
	 */
	public void Part(String nome, String descricao, Set<Part> subParts){
		this.partCod = UUID.randomUUID();
		this.partNome = nome;
		this.partDesc = descricao;
		this.subParts = subParts;
	}
	
	
	@Override
	public String toString() {
		
		return "[Código: "+this.partCod+", Nome: "+ this.partCod + "]";
	}
	
	
		

}
