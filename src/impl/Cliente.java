package impl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	
	/**Lista temporária para selecionar peças**/
	Map <String, Entry<PartImpl,Integer>> listaAtual;
	
	PartImpl part;
	
	/**
	 *Instância um novo cliente.
	 *
	 * @param servidor o servidor
	 * @throws RemoteException remote exception
	 * @throws NotBoundException 
	 */
	public Cliente(String servidorNome) throws RemoteException, NotBoundException {
		listaAtual = new HashMap<String, Map.Entry<PartImpl,Integer>>();
		bind(servidorNome);
	}
	
	/**
	 * Instacia um novo cliente.
	 */
	public Cliente() {
		listaAtual = new HashMap<String, Map.Entry<PartImpl,Integer>>();
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
	
	
	public String getNomeServidor() throws RemoteException {
		return this.partRepository.getNomeServidor();
	}
	
	
	public String showParts() throws RemoteException {
		String parts = partRepository.getListParts().toString();
		System.out.println(parts);
		return parts;
	}
		
	public PartImpl getPart() {
		return part;
	}

	public void setPart(PartImpl part) {
		this.part = part;
	}

	public PartRepository getPartrepository() {
		return this.partRepository;
	}
	
	

}
