package servidor;

import java.util.UUID;

import interfaces.Part;

/**
 * Classe que Implementa a peça (Part)
 * Serve como implementação básica para as classes que a herdam
 * e também como uma peça única 
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
	
	
	/**
	 * Cria uma nova peça com um novo código.
	 * **/
	public PartImpl() {
		this.partCod = UUID.randomUUID();
	}
	
	/**
	 * Gera uma nova peça com os parâmetros.
	 * @param nome o nome da peça
	 * @param descricao a descrição da peça
	 */
	 PartImpl(String nome, String descricao){
		this.partCod = UUID.randomUUID();
		this.partNome = nome;
		this.partDesc = descricao;
	}
	
	/**
	 * Gera uma nova peça com os parâmetros.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 */
	 PartImpl(UUID partCod, String partNome, String partDesc) {
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
	}


	@Override
	public String toString() {
		return "[Código: "+this.partCod+", Nome: "+ this.partCod+ "]";
	}
	
	@Override
	public UUID getPartCod() {
		return partCod;
	}


	@Override
	public void setPartCod(UUID partCod) {
		this.partCod = partCod;
	}


	@Override
	public String getPartNome() {
		return partNome;
	}

	@Override
	public void setPartNome(String partNome) {
		this.partNome = partNome;
	}


	@Override
	public String getPartDesc() {
		return partDesc;
	}


	@Override
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
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
		return (int) this.getPartCod().hashCode(); //utiliza apenas o codigo
	}

		

}
