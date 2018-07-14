package interfaces;

import java.io.Serializable;
import java.util.List;

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
	 * Retorna os componentes da peça.
	 * @return the list componentes
	 */
	public List<Part> getListComponentes();
		
	/**
	 * @param partCod 
	 * @return o componente
	 */
	public PartImpl getComponente(String partCod);
	
	/**
	 * Quantidade de peças
	 * @return componentes da peça
	 * **/
	public int getQtdComponente(String partCod);
	
	/**
	 * Adiciona um novo componente
	 * @param part a peca
	 * @param qtd a quantidade
	 */
	public void addComponent(Part part, Integer qtd);
	
	/**
	 * @return repositorio da peça
	 * **/
	public String getNomeServidor();
	
	/**
	 * @param partRepository o novo repositório de peças
	 * **/
	public void setNomeServidor(String nomeServidor);
	
	
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
