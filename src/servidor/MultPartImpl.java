package servidor;

import java.util.Set;

import interfaces.MultPart;
import interfaces.SubPart;

/**
 * Classe que representa uma peça formada por múltiplas peças
 * 
 */
public class MultPartImpl extends PartImpl implements MultPart{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Conjunto de subpeças que formam esta multi peça*/
	private Set<SubPart> subParts;
	
	
	/**
	 * Instantiates a new mult part impl.
	 *
	 * @param partNome the part nome
	 * @param partDesc the part desc
	 * @param subParts the sub parts
	 */
	MultPartImpl(String partNome, String partDesc, Set<SubPart> subParts ) {
		super(partNome, partDesc);
		this.subParts = subParts;
	}
	
	/**
	 * Instantiates a new mult part impl.
	 *
	 * @param partCod the part cod
	 * @param partNome the part nome
	 * @param partDesc the part desc
	 * @param subParts the sub parts
	 */
	MultPartImpl(String partCod, String partNome, String partDesc, Set<SubPart> subParts) {
		super(partCod, partNome, partDesc);
		this.subParts = subParts;
	}

	@Override
	public Set<SubPart> getSubParts() {
		return subParts;
	}

	@Override
	public void setSubParts(Set<SubPart> subParts) {
		this.subParts = subParts;
	}


}
