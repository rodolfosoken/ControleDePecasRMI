package test;

import org.junit.jupiter.api.Test;

import interfaces.Part;
import servidor.PartImpl;
import servidor.ServidorImpl;

class ServidorTest {

	/**
	 * Teste de registro
	 * **/
	@Test
	void testBind() {
		ServidorImpl server = new ServidorImpl("TesteBind");
		server.shutdown();
	}
	
	
	/**
	 * Testa a adição de uma peça
	 * ***/
	@Test
	void testAdd() {
		String  nome = "TesteAdd";
		ServidorImpl server = new ServidorImpl(nome);
		Part peca = new PartImpl("PecaTeste","Peça única");
		server.addPeca(peca);
		server.shutdown();
	}

}
