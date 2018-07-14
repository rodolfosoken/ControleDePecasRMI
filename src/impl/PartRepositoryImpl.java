package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private Map<String,Part> parts;
	
	/**
	 * Nome do repositório.
	 * ***/
	private String nomeRepository;
	
	
	//Faz a contagem de peças para criar o SKU
	private static int numSKU = 1;
	
	/**
	 * Cria um novo repositório de peças.
	 * **/
	public PartRepositoryImpl(String nomeServidor) {
		this.parts = new HashMap<String, Part>();
		this.nomeRepository = nomeServidor+"_R"+numSKU++;
	}
	
	/**
	 * Cria um novo repositório de peças.
	 * **/
	public PartRepositoryImpl(String nomeServidor,Map<String,Part> parts) {
		this.parts =new HashMap<>(parts);
		this.nomeRepository = nomeServidor+"_R"+numSKU++;
	}


	@Override
	public Map<String,Part> getParts() {
		return parts;
	}

	@Override
	public void setParts(Map<String,Part> parts) {
		this.parts = parts;
	}
	
	@Override
	public void addPart(Part part) {
		this.parts.put(part.getPartCod(), part);
	}

	@Override
	public Part getPart(String partCod) {
		return parts.get(partCod);
	}


	@Override
	public String getNomeRepository() {
		return this.nomeRepository;
	}


	@Override
	public void setNomeRepository(String nomeRepository) {
		this.nomeRepository = nomeRepository;
	}


	@Override
	public List<Part> getListParts(){	
		return new ArrayList<>(this.parts.values());
	}


}
