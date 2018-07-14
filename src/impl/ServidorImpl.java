package impl;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.PartRepository;
import interfaces.Servidor;


/**
 * Classe que implementa o servidor.
 * <p> Composta por um PartRepository com os conjuntos de partes.
 * **/
public class ServidorImpl implements Servidor{


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
	public ServidorImpl(String servidorNome)throws RemoteException {
		this.servidorNome = servidorNome;
		this.partRepository = new PartRepositoryImpl();
		
		try {
			Servidor stub = (Servidor) UnicastRemoteObject.exportObject(this,0);
			registry = LocateRegistry.getRegistry();
			registry.bind(this.servidorNome, stub);
//			System.out.println("Servidor "+servidorNome+" iniciado.");
		
		} catch (AlreadyBoundException e) {
			System.out.println("Stub do servidor: "+servidorNome+" já registrado.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void shutdown()throws RemoteException {
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


	@Override
	public String getServidorNome() throws RemoteException {
		return servidorNome;
	}

	@Override
	public void setServidorNome(String servidorNome) throws RemoteException{
		this.servidorNome = servidorNome;
	}

	
	@Override
	public PartRepository getPartRepository() throws RemoteException{
		return this.partRepository;
	}
	
	@Override
	public void setPartRepository(PartRepository partRepository) throws RemoteException {
		this.partRepository = new PartRepositoryImpl(partRepository.getParts());
	}

	

}
