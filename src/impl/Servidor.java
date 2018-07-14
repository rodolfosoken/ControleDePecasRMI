package impl;

import java.rmi.AccessException;
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
	 * **/
	public Servidor(String servidorNome)throws RemoteException {
		this.servidorNome = servidorNome;
		this.partRepository = new PartRepositoryImpl(this);
		
		try {
			PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(partRepository,0);
			registry = LocateRegistry.getRegistry();
			registry.bind(this.servidorNome, stub);
			System.out.println("Servidor "+servidorNome+" iniciado.");
		
		} catch (AlreadyBoundException e) {
			System.out.println("Stub do servidor: "+servidorNome+" já registrado.");
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		try {
			registry = LocateRegistry.getRegistry();
			registry.unbind(this.servidorNome);
		} catch (AccessException e) {
			System.out.println("Erro ao finalizar o servidor: "+this.servidorNome);
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("Erro ao finalizar o servidor: "+this.servidorNome);
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Erro ao finalizar o servidor: "+this.servidorNome);
			e.printStackTrace();
		}
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
