package servidor;

import interfaces.SubPart;

/**
 * Classe que implementa um subcomponente que faz parte de outra peça
 */
public class SubPartImpl implements SubPart{
	
	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	//Código do componente
	private String subPartCod;
	//Nome do subcomponente
	private String subPartNome;
	//Descrição do subcomponente
	private String subPartDesc; 
	
	/**
	 * Cria um novo componente
	 * **/
	public SubPartImpl(String subPartCod, String subPartNome, String subPartDesc) {
		this.subPartCod = subPartCod;
		this.subPartNome = subPartNome;
		this.subPartDesc = subPartDesc;
	}

	@Override
	public String getSubPartCod() {
		return this.subPartCod;
	}

	@Override
	public void setSubPartCod(String subPartCod) {
		this.subPartCod = subPartCod;
	}

	@Override
	public String getSubPartNome() {
		return this.subPartNome;
	}

	@Override
	public void setSubPartNome(String subPartNome) {
		this.subPartNome = subPartNome;
	}

	@Override
	public String getSubPartDesc() {
		return this.subPartDesc;
	}

	@Override
	public void setSubPartDesc(String partDesc) {
		this.subPartDesc = partDesc;
	}
	
	
	@Override
	public String toString() {
		return "[Cod.Comp.: "+this.subPartCod+
				", Nome Comp.: "+this.subPartNome+
				", Desc.Comp.: "+ this.subPartDesc+ "]";
	}
	
	
	@Override
	public boolean equals(Object other){
		// se ambos possuem o mesmo endereço, então são iguais
		if(this == other) return true;
		// se não pertencem a mesma classe então são diferentes
		if(!(other instanceof SubPartImpl)) return false; 
		//agora podemos converter para a classe
		SubPartImpl otherObj = (SubPartImpl)other; 
		// se possuem o mesmo código, então são iguais
		return this.subPartCod.equals(otherObj.getSubPartCod());
	}
	
	@Override
	public int hashCode() {
		return (int) this.getSubPartCod().hashCode() 
				^ this.getSubPartNome().hashCode()
				^ this.getSubPartDesc().hashCode(); 
	}


}
