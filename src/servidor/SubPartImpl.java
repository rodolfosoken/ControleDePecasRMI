package servidor;

import java.util.UUID;

import interfaces.SubPart;

/**
 * Classe que implementa uma peça(Part) que faz parte de outras (subpart)
 * *.
 */
public class SubPartImpl extends PartImpl implements SubPart{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	//Referencia para a peça de origem 
	/** The src part. */
	//a qual esta subpart pertence
	private MultPartImpl srcPart;
	
	/**
	 * Gera uma subpart com um código existente.
	 *
	 * @param partCod o código da parte 
	 * @param partNome o nome da parte
	 * @param partDesc a descrição da parte
	 * @param srcPart a peça de origem
	 */
	SubPartImpl(UUID partCod, String partNome, String partDesc, MultPartImpl srcPart) {
		super(partCod, partNome, partDesc);
		this.srcPart = srcPart;
	}
	
	/**
	 * Gera uma subPart com um novo código.
	 *
	 * @param partNome o nome da parte
	 * @param partDesc a descrição da parte
	 * @param srcPart a peça de origem
	 */
	SubPartImpl(String partNome, String partDesc, MultPartImpl srcPart) {
		super(partNome, partDesc);
		this.srcPart = srcPart;
	}

	@Override
	public MultPartImpl getSrcPart() {
		return srcPart;
	}


	@Override
	public void setSrcPart(MultPartImpl srcPart) {
		this.srcPart = srcPart;
	}
	


}
