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
	 * Conjunto de partes presentes no servidor
	 * 
	 * **/
	private Set<PartImpl> partes;
	
	/**
	 * Cria um novo repositório de peças.
	 * **/
	public PartRepositoryImpl() {
		this.partes = new HashSet<>();
	}


	@Override
	public Set<PartImpl> getPartes() {
		return partes;
	}

	@Override
	public void setPartes(Set<PartImpl> partes) {
		this.partes = partes;
	}


}
