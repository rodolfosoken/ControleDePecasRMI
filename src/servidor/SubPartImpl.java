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



}
