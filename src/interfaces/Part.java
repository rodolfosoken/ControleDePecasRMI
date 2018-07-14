package interfaces;

import java.io.Serializable;
import java.util.HashMap;

import impl.PartImpl;

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
	public HashMap<PartImpl, Integer> getComponentes();

	
	/**
	 * @param componentes novos componentes da peça
	 * **/
	public void setComponentes(HashMap<PartImpl, Integer> componentes);
	
	
	/**
	 * @return repositorio da peça
	 * **/
	public PartRepository getPartRepository();
	
	/**
	 * @param partRepository o novo repositório de peças
	 * **/
	public void setPartRepository(PartRepository partRepository);
	
	
	/**
	 * Indica se a peça é primitiva, 
	 * verificando se componentes está vazio
	 * @return se a peça é ou não primitiva
	 * **/
	public boolean isPrimitiva();
	
	/**
	 * @param isPrimitiva flag que indica se a peça é primitiva
	 * **/
	public void setPrimitiva(boolean isPrimitiva);

}
