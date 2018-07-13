package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import impl.PartRepositoryImpl;

public interface Servidor extends Remote{
	
	/**
	 * @return servidorNome o nome do Servidor
	 * **/
	public String getServidorNome() throws RemoteException;

	/**
	 * @param servidorNome o nome do servidor.
	 * ***/
	public void setServidorNome(String servidorNome) throws RemoteException;

	/**
	 * @return repository o repositório de peças do servidor
	 * ***/
	public PartRepository getRepository() throws RemoteException;

	/**
	 * @param repository repositório de peças 
	 * 
	 * ***/
	public void setRepository(PartRepositoryImpl repository)throws RemoteException;
	
	/**
	 * @return peca 
	 * **/
	public Part getPeca() throws RemoteException;

	/**
	 * @param peca a nova peça 
	 * **/
	public void setPeca(Part peca)throws RemoteException ;

}
