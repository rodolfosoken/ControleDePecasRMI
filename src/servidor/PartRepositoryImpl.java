package servidor;

import java.util.HashSet;
import java.util.Set;

import interfaces.Part;
import interfaces.PartRepository;

/***
 * Classe que implementa um repositório no servidor
 * **/
public class PartRepositoryImpl implements PartRepository {
	
	/**
	 * Nome do Servidor
	 * **/
	private String servidorNome;
	
	/**
	 * Conjunto de partes presentes no servidor
	 * 
	 * **/
	private Set<PartImpl> partes;
	
	/**
	 * Conjunto de stubs presentes no servidor
	 * 
	 * **/
	private Set<Part> stubs;
	
	public PartRepositoryImpl(String servidorNome) {
		this.servidorNome = servidorNome;
		this.partes = new HashSet<>();
		this.stubs = new HashSet<>();
	}


	@Override
	public Set<PartImpl> getPartes() {
		return partes;
	}

	@Override
	public void setPartes(Set<PartImpl> partes) {
		this.partes = partes;
	}

	@Override
	public Set<Part> getStubs() {
		return stubs;
	}

	@Override
	public void setStubs(Set<Part> stubs) {
		this.stubs = stubs;
	}

	@Override
	public void setServidorNome(String servidorNome) {
		this.servidorNome = servidorNome;
	}


	@Override
	public String getServidorNome() {
		return this.servidorNome;
	}

}
