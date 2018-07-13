package servidor;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.Part;
import interfaces.Servidor;


/**
 * Classe que implementa o servidor.
 * <p> Composta por um PartRepository com os conjuntos de partes.
 * **/
public class ServidorImpl implements Servidor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Nome do Servidor
	 * **/
	private String servidorNome;
	
	
	/**
	 * Repositório de peças do servidor
	 * **/
	private PartRepositoryImpl repository;
	
	/**
	 * Objeto peça
	 * **/
	private Part peca;
	
		
	/**
	 * Referência ao RMI registery
	 * ***/
	private Registry reg;
	
	/**
	 * Cria um novo servidor com um repositório de peças.
	 * @param servidorNome o nome do servidor
	 * **/
	public ServidorImpl(String servidorNome) {
		this.servidorNome = servidorNome;
		this.repository = new PartRepositoryImpl("repos_"+servidorNome);
		
		try {
			Servidor stub = (Servidor) UnicastRemoteObject.exportObject(this,0);
			reg = LocateRegistry.getRegistry();
			reg.bind(this.servidorNome, stub);
//			System.out.println("Servidor "+servidorNome+" iniciado.");
		} catch (RemoteException e) {
			System.out.println("Erro ao iniciar servidor: "+servidorNome+" verifique o rmiregistry.");
			reg = null;
			System.out.println(e.getLocalizedMessage());;
		} catch (AlreadyBoundException e) {
			System.out.println("Stub do servidor: "+servidorNome+" já registrado.");
			e.printStackTrace();
		}
	}
	
	
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
	public PartRepositoryImpl getRepository() {
		return repository;
	}

	@Override
	public void setRepository(PartRepositoryImpl repository) {
		this.repository = repository;
	}

	

}
