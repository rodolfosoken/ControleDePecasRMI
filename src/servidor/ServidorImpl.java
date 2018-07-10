package servidor;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Set;
import java.util.UUID;

import interfaces.Part;
import interfaces.PartRepository;


/**
 * Classe que implementa o servidor.
 * <p> Composta por um PartRepository com os conjuntos de partes.
 * **/
public class ServidorImpl implements PartRepository, Part{
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
		this.repository = new PartRepositoryImpl();
		this.peca = new PartImpl();

	}
	
	
	public void shutdown() {
		try {
			reg.unbind(this.servidorNome);
		} catch (AccessException e) {
			System.out.println("Erro ao finalizar o servidor: "+this.servidorNome);
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @return servidorNome o nome do Servidor
	 * **/
	public String getServidorNome() {
		return servidorNome;
	}

	/**
	 * @param servidorNome o nome do servidor.
	 * ***/
	public void setServidorNome(String servidorNome) {
		this.servidorNome = servidorNome;
	}

	/**
	 * @return repository o repositório de peças do servidor
	 * ***/
	public PartRepositoryImpl getRepository() {
		return repository;
	}

	/**
	 * @param repository repositório de peças 
	 * 
	 * ***/
	public void setRepository(PartRepositoryImpl repository) {
		this.repository = repository;
	}

	//============== Repositório =========
	@Override
	public Set<PartImpl> getPartes() {
		return this.repository.getPartes();
	}


	@Override
	public void setPartes(Set<PartImpl> partes) {
		this.repository.setPartes(partes);		
	}

	//============== Part ===============
	@Override
	public UUID getPartCod() {
		return peca.getPartCod();
	}


	@Override
	public void setPartCod(UUID partCod) {
		peca.setPartCod(partCod);
		
	}


	@Override
	public String getPartNome() {
		return peca.getPartNome();
	}


	@Override
	public void setPartNome(String partNome) {
		peca.setPartNome(partNome);
	}


	@Override
	public String getPartDesc() {
		return peca.getPartDesc();
	}


	@Override
	public void setPartDesc(String partDesc) {
		peca.setPartDesc(partDesc);
	}
	
	
	

}
