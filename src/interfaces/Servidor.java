package interfaces;

import java.rmi.Remote;

import servidor.PartRepositoryImpl;

public interface Servidor extends Remote{
	
	/**
	 * @return servidorNome o nome do Servidor
	 * **/
	public String getServidorNome();

	/**
	 * @param servidorNome o nome do servidor.
	 * ***/
	public void setServidorNome(String servidorNome) ;

	/**
	 * @return repository o repositório de peças do servidor
	 * ***/
	public PartRepositoryImpl getRepository() ;

	/**
	 * @param repository repositório de peças 
	 * 
	 * ***/
	public void setRepository(PartRepositoryImpl repository);

}
