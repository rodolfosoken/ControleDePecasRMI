package interfaces;

import servidor.MultPartImpl;

/**
 * Interface que especifica os métodos das subParts
 * 
 * ***/
public interface SubPart extends Part {
	
	/**
	 * Recupera a peça de origem
	 * @return a peça de origem
	 */
	public MultPartImpl getSrcPart() ;

	
	/**
	 * Atribui uma nova peça de origem
	 *
	 * @param srcPart a nova peça de origem
	 */
	public void setSrcPart(MultPartImpl srcPart) ;

}
