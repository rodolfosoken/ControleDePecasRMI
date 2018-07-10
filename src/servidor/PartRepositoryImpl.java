package servidor;

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
	 * Cria um novo repositório de peças.
	 * **/
	public PartRepositoryImpl() {
		this.partes = new HashMap();
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
				
	}

	@Override
	public Part getPeca(String cod) {
	
		return null;
	}


}
