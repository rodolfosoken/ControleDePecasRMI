package interfaces;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * Interface que especifica os métodos de uma peça (Part)
 * 
 * **/
public interface Part extends Serializable{
	
	/**
	 *  
	 * Código da peça .
	 *
	 * @return the part cod
	 */
	public UUID getPartCod();

	/**
	 *  
	 * Código da peça .
	 *
	 * @param partCod the new part cod
	 */
	public void setPartCod(UUID partCod);


	/**
	 * Nome da Peça
	 * *.
	 *
	 * @return the part nome
	 */
	public String getPartNome();


	/**
	 * Nome da Peça
	 * *.
	 *
	 * @param partNome the new part nome
	 */
	public void setPartNome(String partNome) ;


	/**
	 * Descrição da Peça
	 * *.
	 *
	 * @return the part desc
	 */
	public String getPartDesc() ;


	/**
	 * Descrição da Peça
	 * *.
	 *
	 * @param partDesc the new part desc
	 */
	public void setPartDesc(String partDesc);

	/**
	 * *
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 * *
	 *
	 * @return the sub parts
	 */
	public Set<Part> getSubParts() ;


	/**
	 * *
	 * Conjuntos de peças que compõem esta peça,
	 * o tipo Set não aceita repetição nem mais de um objeto null.
	 * *
	 *
	 * @param subParts the new sub parts
	 */
	public void setSubParts(Set<Part> subParts) ;

}
