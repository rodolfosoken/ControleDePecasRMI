package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import impl.Servidor;

/**
 * Interface que especifica os métodos de um repositório
 * 
 * **/
public interface PartRepository extends Remote {
		
	
	/**
	 * Adiciona uma nova peça ao repositório
	 * @param part a nova peça 
	 * @throws RemoteException
	 * **/	
	public void addPart(Part part) throws RemoteException;
	
	/**
	 * Busca uma peça pelo código
	 * @param partCod
	 * @return peca 
	 * @throws RemoteException
	 * **/
	public Part getPart(String partCod) throws RemoteException;
	
	
	/**
	 * @return nome do repositório
	 * @throws RemoteException
	 * **/
	public String getNomeRepository() throws RemoteException;
	
	/**
	 * @param nomeRepository novo nome do repositório
	 * @throws RemoteException
	 * ***/
	public void setNomeRepository(String nomeRepository) throws RemoteException;
	
	
	/**
	 * Retorna uma lista das pecas.
	 *
	 * @return a lista de pecas
	 * @throws RemoteException the remote exception
	 */
	public List<Part> getListParts() throws RemoteException;
	
	/**
	 * Retorna uma referencia ao servidor que implementa o repositório.
	 *
	 * @return servidor
	 * @throws RemoteException the remote exception
	 */
	public Servidor getServidor()throws RemoteException ;
	
	/**
	 *@param servidor o novo servidor
	 * @throws RemoteException the remote exception
	 */
	public void setServidor(Servidor servidor)throws RemoteException;
	public String getNomeServidor() throws RemoteException;

}
