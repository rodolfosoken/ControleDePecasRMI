package interfaces;

import java.util.Map;

/**
 * Interface que especifica os métodos de um repositório
 * 
 * **/
public interface PartRepository  {
		
	/**
	 * 
	 * @return partes conjunto contendo todas as partes no servidor.
	 * **/
	public Map<String,Part> getPartes();

	/**
	 * @param partes conjunto com as partes presentes no servidor
	 * 
	 * ***/
	public void setPartes(Map<String,Part> partes);

	
	/**
	 * Adiciona uma nova peça no repositório.
	 * ***/
	public void addPeca(Part peca);
	
	/**
	 * Busca peca por código
	 * ***/
	public Part getPeca(String cod);
	
	
	/**
	 * @return nome do repositório
	 * **/
	public String getNomeRepository();
	
	/**
	 * @param nomeRepository novo nome do repositório
	 * ***/
	public void setNomeRepository(String nomeRepository);
	


}
