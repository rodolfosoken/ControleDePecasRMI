package impl;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.PartRepository;


/**
 * Classe que implementa o servidor.
 * <p> Composta por um PartRepository com os conjuntos de partes.
 * **/
public class Servidor {


	/**
	 * Nome do Servidor
	 * **/
	private String servidorNome;
	
	
	/**
	 * Repositório de peças do servidor
	 * **/
	private PartRepositoryImpl partRepository;
		
		
	/**
	 * Referência ao RMI registery
	 * ***/
	private Registry registry;
	
	/**
	 * Cria um novo servidor com um repositório de peças.
	 * @param servidorNome o nome do servidor
	 * @throws AlreadyBoundException 
	 * **/
	public Servidor(String servidorNome)throws RemoteException, AlreadyBoundException {
		this.servidorNome = servidorNome;
		this.partRepository = new PartRepositoryImpl(this);

		PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(partRepository,0);
		registry = LocateRegistry.getRegistry();
		registry.bind(this.servidorNome, stub);
		System.out.println("Servidor "+servidorNome+" iniciado.");
		

	}
	
	/**
	 * Cria um novo servidor com um repositório de peças.
	 * @param servidorNome o nome do servidor	
	 * @param endereco o endereco
	 * @param port  a porta
	 * @throws AlreadyBoundException 
	 * **/
	public Servidor(String servidorNome, String endereco, int port)throws RemoteException, AlreadyBoundException {
		this.servidorNome = servidorNome;
		this.partRepository = new PartRepositoryImpl(this);

		PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(partRepository,0);
		registry = LocateRegistry.getRegistry(endereco,port);
		registry.bind(this.servidorNome, stub);
		System.out.println("Servidor "+servidorNome+" iniciado.");
		

	}
	
	public void shutdown() throws RemoteException, NotBoundException {
			registry = LocateRegistry.getRegistry();
			registry.unbind(this.servidorNome);
			System.out.println("Servidor "+this.servidorNome+" finalizado.");

	}

	public static void shutdown(String servidorNome, String endereco, int porta) throws RemoteException, NotBoundException {
		Registry registry;
		if(endereco!=null)
			registry = LocateRegistry.getRegistry(endereco,porta);
		else
			registry = LocateRegistry.getRegistry();
		registry.unbind(servidorNome);
		System.out.println("Servidor "+servidorNome+" finalizado.");
	}

	public String getServidorNome()  {
		return servidorNome;
	}

	public void setServidorNome(String servidorNome) {
		this.servidorNome = servidorNome;
	}
	
	public PartRepository getPartRepository(){
		return this.partRepository;
	}
	
	public void setPartRepository(PartRepository partRepository) {
		this.partRepository = (PartRepositoryImpl) partRepository;
	}

	

}
