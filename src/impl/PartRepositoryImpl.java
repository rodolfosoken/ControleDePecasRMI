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
	
	/**
	 * Servidor que hospeda o repositorio 
	 * **/
	private Servidor servidor;
	
	
	//Faz a contagem de peças para criar o SKU
	private static int numSKU = 1;
	
	/**
	 * Cria um novo repositório de peças.
	 * **/
	public PartRepositoryImpl(Servidor servidor) {
		this.servidor = servidor;
		this.parts = new HashMap<String, Part>();
		this.nomeRepository = "R"+numSKU++;
	}

	@Override
	public List<Part> getListParts(){	
		return new ArrayList<>(this.parts.values());
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
	public Servidor getServidor() {
		return servidor;
	}

	@Override
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	@Override
	public String toString() {
		return "Serv.: "+ this.servidor.getServidorNome()+" Rep.:"+this.nomeRepository;
	}
	
	@Override
	public String getNomeServidor() {
		return this.servidor.getServidorNome();
	}



}
