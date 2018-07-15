package impl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	private Map<String, Entry<PartImpl,Integer>> componentes;
	
	//Repositório à qual a peça pertence
	private String nomeServidor;
	
	//Flag
	private boolean isPrimitiva;
	
	//Faz a contagem de peças para criar o SKU
	private static int numSKU = 1;
	
	/**
	 * Gera uma nova peça com um código aleatório.
	 */
	 public PartImpl(String nomeServidor){
		this.partCod = "P"+numSKU++;
		this.partNome = "";
		this.partDesc = "";
		this.componentes = new HashMap<>();
		this.isPrimitiva();
		this.nomeServidor = nomeServidor;
	}
	
	/**
	 * Gera uma nova peça com um código aleatório.
	 * @param nome o nome da peça
	 * @param descricao a descrição da peça
	 */
	 public PartImpl(String nome, String descricao, String nomeServidor){
		this.partCod = "P"+numSKU++;
		this.partNome = nome;
		this.partDesc = descricao;
		this.componentes = new HashMap<>();
		this.isPrimitiva();
		this.nomeServidor = nomeServidor;
	}
	 
	/**
	 * Gera uma nova peça com um código especificado.
	 * @param partCod
	 * @param partNome o nome da peça
	 * @param partDesc a descrição da peça
	 * @param nomeServidor nome do servidor
	 */
	 public PartImpl(String partCod, String partNome, 
			 String partDesc, String nomeServidor) {
		 numSKU++;
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = new HashMap<>();
		this.isPrimitiva();
		this.nomeServidor = nomeServidor;
	}
	 
	
	 /**
	 * Cria uma nova peça com todos os atributos definidos
 	 * @param partCod the part cod
 	 * @param partNome the part nome
 	 * @param partDesc the part desc
 	 * @param componentes the componentes
 	 * @param nomeServidor the nome servidor
 	 */
	public PartImpl(String partCod, String partNome, String partDesc, 
			Map<String, Entry<PartImpl, Integer>> componentes,
			String nomeServidor) {
		super();
		this.partCod = partCod;
		this.partNome = partNome;
		this.partDesc = partDesc;
		this.componentes = componentes;
		this.nomeServidor = nomeServidor;
		this.isPrimitiva();
	}

	@Override
	public String toString() {
		if(isPrimitiva())
			return "\n[Cod.: "+this.partCod+
					", Nome: "+this.partNome+
					", Desc.: "+this.partDesc+
					", Serv.: "+this.nomeServidor+"]";
		
		return "\n[Cod.: "+partCod+
				", Nome: "+partNome+
				", Desc.: "+partDesc+
				", Serv.: "+nomeServidor+
				", Compo.: "+componentes.toString() + "]";
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
	public int getQtdComponente(String partCod) {
		return componentes.get(partCod).getValue();
	}

	@Override
	public void addComponent(Part part, Integer qtd) {
		componentes.put(part.getPartCod(), new AbstractMap.SimpleEntry<PartImpl,Integer>((PartImpl)part, qtd));
		
	}
	
	@Override
	public PartImpl getComponente(String partCod) {
		return componentes.get(partCod).getKey();
	}
	
	@Override
	public List<Part> getListComponentes() {
		List<Part> l = new ArrayList<>();
		for (Entry<PartImpl,Integer> entry : componentes.values()) {
			l.add(entry.getKey());
		}
		return l;
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
		return this.partCod.equals(otherObj.getPartCod()) && 
				this.nomeServidor.equals(otherObj.nomeServidor);
	}
	
	@Override
	public int hashCode() {
		return (int) this.getPartCod().hashCode() 
				^ this.getNomeServidor().hashCode(); 
	}

	@Override
	public String getNomeServidor() {
		return this.nomeServidor;
	}
	
	@Override
	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
		
	}

	@Override
	public Map<String, Entry<PartImpl, Integer>> getComponentes() {
		return componentes;
	}
	
	@Override
	public void setComponentes(Map<String, Entry<PartImpl, Integer>> componentes) {
		this.componentes = componentes;
	}
	
	
	

}
