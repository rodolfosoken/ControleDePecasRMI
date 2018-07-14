package impl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.Part;
import interfaces.PartRepository;

/**
 * Classe que representa um cliente e terá a implementação
 * das ações (métodos) que o cliente poderá requisitar para o servidor no sistema.
 * **/
public class Cliente {
	
	/** Referência ao repositorio ao qual o cliente está conectado */
	PartRepository partRepository;
	
	/** Referência do registro RMI ***/
	Registry registry;
	
	/**
	 *Instância um novo cliente.
	 *
	 * @param servidor o servidor
	 * @throws RemoteException remote exception
	 * @throws NotBoundException 
	 */
	public Cliente(String servidorNome) throws RemoteException, NotBoundException {
		bind(servidorNome);
	}
	
	/**
	 * Conecta à um servidor
	 * @param servidorNome 
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * **/
	public void bind(String servidorNome) throws RemoteException, NotBoundException {
		registry = LocateRegistry.getRegistry();
		this.partRepository = (PartRepository) registry.lookup(servidorNome);
	}
	
	
	/**
	 * Adiciona uma nova Peça.
	 * 
	 * @param part a peça a ser adicionada
	 */
	public void addPart(Part part) {
		 try {
			partRepository.addPart(part);
			
		} catch (RemoteException e) {
			System.out.println("Erro ao adicionar peça: "+part.toString());
			System.out.println(e.getMessage());
		}		
		
	}
	
	public String getNomeServidor() throws RemoteException {
		return this.partRepository.getNomeServidor();
	}
	
	
	public String showParts() throws RemoteException {
		String parts = partRepository.getListParts().toString();
		System.out.println("Peças em "+partRepository.getNomeServidor()+": ");
		System.out.println(parts);
		return parts;
	}
	
	
	
	

}
