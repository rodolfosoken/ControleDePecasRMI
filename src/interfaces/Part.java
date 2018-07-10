package interfaces;

import java.io.Serializable;

/**
 * Interface que especifica os métodos de uma peça (Part)
 * 
 * **/
public interface Part extends Serializable{
	
	/**
	 *  
	 * Código da peça .
	 *
	 * @return o código da peça
	 */
	public String getPartCod();

	/**
	 *  
	 * Código da peça .
	 *
	 * @param partCod o novo código da peça
	 */
	public void setPartCod(String partCod);


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



}
