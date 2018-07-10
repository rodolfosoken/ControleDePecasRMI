package interfaces;

import java.util.Set;

import servidor.PartImpl;

/**
 * Interface que especifica os métodos de um repositório
 * 
 * **/
public interface PartRepository  {
		
	/**
	 * 
	 * @return partes conjunto contendo todas as partes no servidor.
	 * **/
	public Set<PartImpl> getPartes();

	/**
	 * @param partes conjunto com as partes presentes no servidor
	 * 
	 * ***/
	public void setPartes(Set<PartImpl> partes);



}
