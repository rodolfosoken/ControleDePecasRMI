package impl;

import java.util.HashMap;

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
	private String partCod;
	
	//Nome da peça
	private String partNome;
	
	//Descriçao da peça
	private String partDesc;
	
	//Componentes da peça
	private HashMap<PartImpl, Integer> componentes;
	
	//Flag
	private boolean isPrimitiva;
	
	//Faz a contagem de peças para criar o SKU
	private static int numSKU = 1;
	
	
	/**
	 * Gera uma nova peça com um código aleatório.
	 * @param nome o nome da peça
	 * @param descricao a descrição da peça
	 */
	 public PartImpl(String nome, String descricao){
		this.partCod = "P"+numSKU++;
		this.partNome = nome;
		this.partDesc = descricao;
		this.componentes = new HashMap<>();
		this.isPrimitiva();
	}
	
	/**
	 * Gera uma nova peça com um código especificado.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 */
	 public PartImpl(String partNome, String partDesc, 
			 HashMap<PartImpl, Integer> componentes) {
		 this.partCod = "P"+numSKU++;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = componentes;
		this.isPrimitiva();
	}
	 
	/**
	 * Gera uma nova peça com um código especificado.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 */
	 public PartImpl(String partCod, String partNome, String partDesc) {
		 numSKU++;
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = new HashMap<>();
		this.isPrimitiva();
	}
	 
	 

	/**
	 * Gera uma nova peça com um conjunto de componentes definido.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 */
	public PartImpl(String partCod, String partNome, 
			String partDesc, HashMap<PartImpl, Integer> componentes) {
		numSKU++;
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = componentes;
		this.isPrimitiva();
	}

	@Override
	public String toString() {
		if(isPrimitiva())
			return "\n[Cod.: "+this.partCod+
					", Nome: "+this.partNome+
					", Desc.: "+ this.partDesc+ "]";
		
		return"\n[Cod.: "+this.partCod+
				", Nome: "+this.partNome+
				", Desc.: "+ this.partDesc+
				", Compo.: "+this.componentes.toString() + "]";
	}
	
	@Override
	public String getPartCod() {
		return partCod;
	}


	@Override
	public void setPartCod(String partCod) {
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
	public HashMap<PartImpl, Integer> getComponentes() {
		return componentes;
	}

	@Override
	public void setComponentes(HashMap<PartImpl, Integer> componentes) {
		this.componentes = componentes;
		this.isPrimitiva();
	}
	
	
	@Override
	public boolean isPrimitiva() {
		if(this.componentes.isEmpty())
			this.isPrimitiva = true;
		else
			this.isPrimitiva = false;
		return isPrimitiva;
	}

	@Override
	public void setPrimitiva(boolean isPrimitiva) {
		this.isPrimitiva = isPrimitiva;
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
	
	@Override
	public int hashCode() {
		return (int) this.getPartCod().hashCode() 
				^ this.getPartNome().hashCode()
				^ this.getPartDesc().hashCode(); 
	}
	
	
	

		

}
