package impl;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import interfaces.Part;
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
	private PartRepositoryImpl repository;
		
		
	/**
	 * Referência ao RMI registery
	 * ***/
	private Registry reg;
	
	/**
	 * Cria um novo servidor com um repositório de peças.
	 * @param servidorNome o nome do servidor
	 * **/
	public ServidorImpl(String servidorNome)throws RemoteException {
		this.servidorNome = servidorNome;
		this.repository = new PartRepositoryImpl("repos_"+servidorNome);
		
		try {
			Servidor stub = (Servidor) UnicastRemoteObject.exportObject(this,0);
			reg = LocateRegistry.getRegistry();
			reg.bind(this.servidorNome, stub);
//			System.out.println("Servidor "+servidorNome+" iniciado.");
		
		} catch (AlreadyBoundException e) {
			System.out.println("Stub do servidor: "+servidorNome+" já registrado.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void shutdown() {
		try {
			reg = LocateRegistry.getRegistry();
			reg.unbind(this.servidorNome);
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
	public String getServidorNome() {
		return servidorNome;
	}

	@Override
	public void setServidorNome(String servidorNome) {
		this.servidorNome = servidorNome;
	}


	@Override
	public Part getPeca(String partCod) {
		return this.repository.getPeca(partCod);
	}
	
	@Override
	public List<Part> getListPecas(){	
		return new ArrayList<>(repository.getPartes().values());
	}

	
	@Override
	public void addPeca(Part peca) {
		this.repository.addPeca(peca);
	}
	
	

}
