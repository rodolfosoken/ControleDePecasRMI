package interfaces;

import java.io.Serializable;
import java.util.HashMap;

import servidor.SubPartImpl;

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
	 * Código da peça .
	 *
	 * @param partCod o novo código da peça
	 */
	public void setPartCod(String partCod);


	/**
	 * Nome da Peça
	 *
	 * @return o nome da peça
	 */
	public String getPartNome();


	/**
	 * Nome da Peça
	 *
	 * @param partNome o novo nome da peça
	 */
	public void setPartNome(String partNome) ;


	/**
	 * Descrição da Peça
	 *
	 * @return a descrição da peça
	 */
	public String getPartDesc() ;


	/**
	 * Descrição da Peça
	 *
	 * @param partDesc a nova descrição da peça
	 */
	public void setPartDesc(String partDesc);
	
	
	/**
	 * Componentes da peça
	 * @return componentes da peça
	 * **/
	public HashMap<SubPartImpl, Integer> getComponentes();

	
	/**
	 * @param componentes novos componentes da peça
	 * **/
	public void setComponentes(HashMap<SubPartImpl, Integer> componentes);

}
