package interfaces;

import java.rmi.Remote;
import java.util.Set;

import servidor.PartImpl;

/**
 * Interface que especifica os métodos de um repositório
 * 
 * **/
public interface PartRepository extends Remote {
	
	/**
	 * @return servidorNome nome do servidor.
	 * **/
	public String getServidorNome();
	
	/**
	 * Define o nome do servidor
	 * 
	 * @param servidorNome nome do servidor.
	 * **/
	public void setServidorNome(String servidorNome);
	
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

	/**
	 *Conjunto contendo as representações dos objetos
	 * @return stubs conjunto com os stubs de cada objeto criado no servidor
	 * ***/
	public Set<Part> getStubs() ;

	/**
	 * @param stubs conjunto contendo os stubs criados no servidor
	 * 
	 * ***/
	public void setStubs(Set<Part> stubs);



}
