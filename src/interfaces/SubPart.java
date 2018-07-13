package interfaces;

import java.io.Serializable;

/**
 * Interface que especifica os métodos dos subcomponente
 * 
 * ***/
public interface SubPart extends Serializable {
	
	/**
	 * Código do subcomponente .
	 *
	 * @return o código da subcomponente
	 */
	public String getSubPartCod();

	/**
	 * Código do subcomponente
	 *
	 * @param subPartCod o novo código da subcomponente
	 */
	public void setSubPartCod(String subPartCod);


	/**
	 * Nome do subcomponente
	 *
	 * @return o nome do subcomponente
	 */
	public String getSubPartNome();


	/**
	 * Nome do subcomponente
	 *
	 * @param partNome o novo nome do subcomponente
	 */
	public void setSubPartNome(String subPartNome) ;


	/**
	 * Descrição do subcomponente
	 *
	 * @return a descrição do subcomponente
	 */
	public String getSubPartDesc() ;


	/**
	 * Descrição do subcomponente
	 *
	 * @param partDesc a descrição do subcomponente
	 */
	public void setSubPartDesc(String partDesc);


}
