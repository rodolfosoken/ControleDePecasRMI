package servidor;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Map;

import interfaces.Part;
import interfaces.PartRepository;
import interfaces.Servidor;


/**
 * Classe que implementa o servidor.
 * <p> Composta por um PartRepository com os conjuntos de partes.
 * **/
public class ServidorImpl implements Servidor, PartRepository, Part{
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

	//============== Repositório =========
	@Override
	public Map<String, Part> getPartes() {
		return this.repository.getPartes();
	}


	@Override
	public void setPartes(Map<String, Part> partes) {
		this.repository.setPartes(partes);		
	}

	//============== Part ===============
	@Override
	public String getPartCod() {
		return peca.getPartCod();
	}


	@Override
	public void setPartCod(String partCod) {
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


	@Override
	public void addPeca(Part peca) {
		repository.addPeca(peca);		
	}


	@Override
	public Part getPeca(String cod) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	

}
