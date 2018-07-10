package test;

import static org.junit.Assert.assertEquals;

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
		Part peca = new PartImpl("123","PecaTeste","Peça única");
		server.addPeca(peca);
//		System.out.println(server.getPartes().toString());
		assertEquals(1, server.getPartes().values().size());
		server.shutdown();
	}
	
	@Test
	void testEdicao() {
		String  nome = "TesteEdicao";
		ServidorImpl server = new ServidorImpl(nome);
		Part peca = new PartImpl("123","PecaTeste","Peça única");
		server.addPeca(peca);
		peca = new PartImpl("123","PecaTeste","Peça única Editada");
		server.addPeca(peca);
		peca = new PartImpl("124","PecaTeste","Peça única Nova");
		server.addPeca(peca);
//		System.out.println(server.getPartes().toString());
		assertEquals(2, server.getPartes().values().size());
		server.shutdown();
	}
	
	@Test
	void testBusca() {
		String  nome = "TesteBusca";
		ServidorImpl server = new ServidorImpl(nome);
		Part peca = new PartImpl("123","PecaTeste1","Peça única");
		server.addPeca(peca);
		peca = new PartImpl("124","PecaTeste2","Mais uma Peça única");
		server.addPeca(peca);
		peca = new PartImpl("125","PecaTeste3","E Mais outra Peça única Nova");
		server.addPeca(peca);
//		System.out.println("Peça encontrada: "+server.getPartes().get("124").toString());
		assertEquals("124",server.getPartes().get("124").getPartCod());
		server.shutdown();
	}

}
