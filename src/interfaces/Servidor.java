package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

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
	 * Remove o servidor do registro RMI
	 * @throws RemoteException 
	 * ***/
	public void shutdown() throws RemoteException;
	
	/**
	 * @return repository o repositório de peças do servidor
	 * @throws RemoteException
	 * ***/
	public PartRepository getPartRepository() throws RemoteException;

	/**
	 * @param repository repositório de peças 
	 * @throws RemoteException
	 * ***/
	public void setPartRepository(PartRepository partRepository)throws RemoteException;
}
