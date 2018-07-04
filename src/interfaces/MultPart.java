package interfaces;

import java.util.Set;


/**
 * Interface que especifica os métodos das multi-parts
 * **/
public interface MultPart extends Part{
	
	/**
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 *
	 * @return the sub parts
	 */
	public Set<SubPart> getSubParts();

	/**
	 * *
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 * *
	 *
	 * @param subParts the new sub parts
	 */
	public void setSubParts(Set<SubPart> subParts);
	

}
