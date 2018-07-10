package servidor;

import java.util.UUID;

import interfaces.SubPart;

/**
 * Classe que implementa uma peça(Part) que faz parte de outras peças (Multpart)
 * *.
 */
public class SubPartImpl extends PartImpl implements SubPart{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**Referencia para a peça de origem */
	private MultPartImpl srcPart;
	
	/** Quantidade de subpeças que existem na peça de origem */
	private int qtd;
	
	/**
	 * Gera uma subpart com um código existente.
	 *
	 * @param partCod o código da parte 
	 * @param partNome o nome da parte
	 * @param partDesc a descrição da parte
	 * @param srcPart a peça de origem
	 * @param qtd quantidade de subpeças que exitem na peça original
	 */
	SubPartImpl(UUID partCod, String partNome, String partDesc, MultPartImpl srcPart, int qtd) {
		super(partCod, partNome, partDesc);
		this.srcPart = srcPart;
		this.qtd = qtd;
	}
	
	/**
	 * Gera uma subPart com um novo código.
	 *
	 * @param partNome o nome da parte
	 * @param partDesc a descrição da parte
	 * @param srcPart a peça de origem
	 * @param qtd quantidade de subpeças que exitem na peça original
	 */
	SubPartImpl(String partNome, String partDesc, MultPartImpl srcPart, int qtd) {
		super(partNome, partDesc);
		this.srcPart = srcPart;
		this.qtd = qtd;
	}

	@Override
	public MultPartImpl getSrcPart() {
		return srcPart;
	}


	@Override
	public void setSrcPart(MultPartImpl srcPart) {
		this.srcPart = srcPart;
	}
	
	@Override
	public int getQtd() {
		return qtd;
	}

	@Override
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


}
