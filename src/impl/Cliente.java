package impl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	/**Lista temporária para selecionar peças**/
	Map <String, Entry<Part,Integer>> listaAtual;
	
	Part part;
	
	/**
	 *Instância um novo cliente.
	 *
	 * @param servidor o servidor
	 * @throws RemoteException remote exception
	 * @throws NotBoundException 
	 */
	public Cliente(String servidorNome) throws RemoteException, NotBoundException {
		listaAtual = new HashMap<String, Map.Entry<Part,Integer>>();
		bind(servidorNome);
	}
	
	/**
	 * Instacia um novo cliente.
	 */
	public Cliente() {
		listaAtual = new HashMap<String, Map.Entry<Part,Integer>>();
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
	 * Conecta à um servidor usando endereço e porta.
	 *
	 * @param servidorNome nome do servidor
	 * @param endereco o endereco
	 * @param port  a porta
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public void bind(String servidorNome, String endereco, int port) throws RemoteException, NotBoundException {
		registry = LocateRegistry.getRegistry(endereco,port);
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
		
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public PartRepository getPartrepository() {
		return this.partRepository;
	}

	public Map<String, Entry<Part, Integer>> getListaAtual() {
		return listaAtual;
	}

	public void setListaAtual(Map<String, Entry<Part, Integer>> listaAtual) {
		this.listaAtual = listaAtual;
	}
	
	public void add2ListaAtual(Part part, int qtd) {
		getListaAtual().put(part.getPartCod(), new AbstractMap.SimpleEntry<Part,Integer>(part, qtd));
	}
	
	public List<Part> getListListaAtual() {
		List<Part> l = new ArrayList<>();
		for (Entry<Part,Integer> entry : listaAtual.values()) {
			l.add(entry.getKey());
		}
		return l;
	}
	
	public void limpaListaAtual() {
		listaAtual = new HashMap<String, Map.Entry<Part,Integer>>();
	}
	

}
