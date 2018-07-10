package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
	public String getServidorNome()throws RemoteException;
	
	/**
	 * Define o nome do servidor
	 * 
	 * @param servidorNome nome do servidor.
	 * **/
	public void setServidorNome(String servidorNome)throws RemoteException;
	
	/**
	 * 
	 * @return partes conjunto contendo todas as partes no servidor.
	 * **/
	public Set<PartImpl> getPartes() throws RemoteException;

	/**
	 * @param partes conjunto com as partes presentes no servidor
	 * 
	 * ***/
	public void setPartes(Set<PartImpl> partes) throws RemoteException;

	/**
	 *Conjunto contendo as representações dos objetos
	 * @return stubs conjunto com os stubs de cada objeto criado no servidor
	 * ***/
	public Set<Part> getStubs() throws RemoteException;

	/**
	 * @param stubs conjunto contendo os stubs criados no servidor
	 * 
	 * ***/
	public void setStubs(Set<Part> stubs) throws RemoteException;



}
