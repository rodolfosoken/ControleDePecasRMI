package impl;

import java.util.HashMap;
import java.util.Map;

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
	private Map<String,Part> partes;
	
	/**
	 * Nome do repositório.
	 * ***/
	private String nomeRepository;
	
	/**
	 * Cria um novo repositório de peças.
	 * **/
	public PartRepositoryImpl(String nomeRepository) {
		this.partes = new HashMap<String, Part>();
		this.nomeRepository = nomeRepository;
	}


	@Override
	public Map<String,Part> getPartes() {
		return partes;
	}

	@Override
	public void setPartes(Map<String,Part> partes) {
		this.partes = partes;
	}
	
	@Override
	public void addPeca(Part peca) {
		this.partes.put(peca.getPartCod(), peca);				
	}

	@Override
	public Part getPeca(String cod) {
		return partes.get(cod);
	}


	@Override
	public String getNomeRepository() {
		return this.nomeRepository;
	}


	@Override
	public void setNomeRepository(String nomeRepository) {
		this.nomeRepository = nomeRepository;
	}


}
