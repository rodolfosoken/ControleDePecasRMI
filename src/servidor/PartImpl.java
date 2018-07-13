package servidor;

import java.util.HashMap;
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
	private String partCod;
	
	//Nome da peça
	private String partNome;
	
	//Descriçao da peça
	private String partDesc;
	
	//Componentes da peça
	private HashMap<SubPartImpl, Integer> componentes;
	
	
	/**
	 * Gera uma nova peça com um código aleatório.
	 * @param nome o nome da peça
	 * @param descricao a descrição da peça
	 */
	 public PartImpl(String nome, String descricao){
		this.partCod = UUID.randomUUID().toString();
		this.partNome = nome;
		this.partDesc = descricao;
		this.componentes = new HashMap<>();
	}
	
	/**
	 * Gera uma nova peça com um código especificado.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 */
	 public PartImpl(String partCod, String partNome, String partDesc) {
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = new HashMap<>();
	}
	 
	 

	/**
	 * Gera uma nova peça com um conjunto de componentes definido.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 */
	public PartImpl(String partCod, String partNome, String partDesc, HashMap<SubPartImpl, Integer> subComponentes) {
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = subComponentes;
	}

	@Override
	public String toString() {
		return "[Cod.: "+this.partCod+", Nome: "+this.partNome+", Desc.: "+ this.partDesc+ "]";
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
	public HashMap<SubPartImpl, Integer> getComponentes() {
		return componentes;
	}

	@Override
	public void setComponentes(HashMap<SubPartImpl, Integer> componentes) {
		this.componentes = componentes;
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
		return (int) this.getPartCod().hashCode() ^ this.getPartNome().hashCode(); 
	}
	
	
	

		

}
