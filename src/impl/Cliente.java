package impl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.Part;
import interfaces.Servidor;

/**
 * Classe que representa um cliente e terá a implementação
 * das ações (métodos) que o cliente poderá requisitar para o servidor no sistema.
 * **/
public class Cliente {
	
	/** Referência ao servidor  ao qual o cliente está conectado */
	Servidor servidor;
	
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
		this.servidor = (Servidor) registry.lookup(servidorNome);
	}
	
	
	/**
	 * Adiciona uma nova Peça.
	 * 
	 * @param peca a peça a ser adicionada
	 */
	public void addPeca(Part peca) {
		 try {
			servidor.addPeca(peca);
		} catch (RemoteException e) {
			System.out.println("Erro ao adicionar peça: "+peca.toString());
			System.out.println(e.getMessage());
		}		
		
	}
	
	public String getNomeServidor() throws RemoteException {
		return this.servidor.getServidorNome();
	}
	
	public String showPecas() throws RemoteException {
		return this.servidor.getListPecas().toString();
	}
	
	
	
	

}
