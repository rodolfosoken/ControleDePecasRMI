package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Interface que especifica os métodos de um repositório
 * 
 * **/
public interface PartRepository extends Remote {
		
	/**
	 * @return partes conjunto contendo todas as partes no servidor.
	 * @throws RemoteException
	 * **/
	public Map<String,Part> getParts() throws RemoteException;

	/**
	 * @param parts conjunto com as partes presentes no servidor
	 * @throws RemoteException
	 **/
	public void setParts(Map<String,Part> parts) throws RemoteException;

	
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
	
	

}
