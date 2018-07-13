package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import impl.PartRepositoryImpl;

public interface Servidor extends Remote{
	
	/**
	 * @return servidorNome o nome do Servidor
	 * @throws RemoteException
	 * **/
	public String getServidorNome() throws RemoteException;

	/**
	 * @param servidorNome o nome do servidor.
	 * @throws RemoteException
	 * ***/
	public void setServidorNome(String servidorNome) throws RemoteException;
	
	/**
	 * Busca uma peça pelo código
	 * @param partCod
	 * @return peca 
	 * @throws RemoteException
	 * **/
	public Part getPeca(String partCod) throws RemoteException;
	
	
	/**
	 * Retorna a lista de pecas.
	 *
	 * @return a lista de pecas
	 * @throws RemoteException the remote exception
	 */
	public List<Part> getListPecas() throws RemoteException;
	

	/**
	 * Adiciona uma nova peça ao repositório
	 * @param peca a nova peça 
	 * @throws RemoteException
	 * **/	
	public void addPeca(Part peca) throws RemoteException;
	
	/**
	 * Remove o servidor do registro RMI
	 * @throws RemoteException 
	 * ***/
	public void shutdown() throws RemoteException;

}
