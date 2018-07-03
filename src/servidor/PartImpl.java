package servidor;

import java.util.Set;
import java.util.UUID;

import interfaces.Part;

// TODO: Auto-generated Javadoc
/**
 * Classe que Implementa a peça (Part)
 * *.
 */
public class PartImpl implements Part {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	//Código da peça 
	private UUID partCod;
	
	//Nome da peça
	private String partNome;
	
	//Descriçao da peça
	private String partDesc;
	
	//Conjunto de subpeças
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
	
	/**
	 * Gera uma nova peça com os parâmetros.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 * @param subParts as subparts da peça
	 */
	public PartImpl(UUID partCod, String partNome, String partDesc, Set<interfaces.Part> subParts) {
		super();
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.subParts = subParts;
	}


	@Override
	public String toString() {
		return "[Código: "+this.partCod+", Nome: "+ this.partCod+", qtd. subpart: " +this.subParts.size()+ "]";
	}
	
	/**
	 *  
	 * Código da peça .
	 *
	 * @return the part cod
	 */
	public UUID getPartCod() {
		return partCod;
	}


	/**
	 *  
	 * Código da peça .
	 *
	 * @param partCod the new part cod
	 */
	public void setPartCod(UUID partCod) {
		this.partCod = partCod;
	}


	/**
	 * Nome da Peça
	 * *.
	 *
	 * @return the part nome
	 */
	public String getPartNome() {
		return partNome;
	}


	/**
	 * Nome da Peça
	 * *.
	 *
	 * @param partNome the new part nome
	 */
	public void setPartNome(String partNome) {
		this.partNome = partNome;
	}


	/**
	 * Descrição da Peça
	 * *.
	 *
	 * @return the part desc
	 */
	public String getPartDesc() {
		return partDesc;
	}


	/**
	 * Descrição da Peça
	 * *.
	 *
	 * @param partDesc the new part desc
	 */
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}


	/**
	 * *
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 * *
	 *
	 * @return the sub parts
	 */
	public Set<Part> getSubParts() {
		return subParts;
	}


	/**
	 * *
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 * *
	 *
	 * @param subParts the new sub parts
	 */
	public void setSubParts(Set<Part> subParts) {
		this.subParts = subParts;
	}


	@Override
	public boolean equals(Object other){
		// se ambos possuem o mesmo endereço, então são iguais
		if(this == other) return true;
		// se não pertencem a mesma classe então são diferentes
		if(!(other instanceof PartImpl)) return false; 
		//agora podemos converter para a classe
		PartImpl otherObj = (PartImpl)other; 
		// se possuem o mesmo código, então são iguais
		return this.partCod.equals(otherObj.getPartCod());
	}
	
	//este método será utilizado em conjunto com o 
	//equals para localizar os objs em uma coleção 
	@Override
	public int hashCode() {
		return (int) this.getPartCod().hashCode();
	}

		

}
