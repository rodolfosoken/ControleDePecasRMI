package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import interfaces.Part;
import interfaces.SubPart;
import servidor.PartImpl;
import servidor.ServidorImpl;
import servidor.SubPartImpl;

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
		server.getRepository().addPeca(peca);
//		System.out.println(server.getPartes().toString());
		assertEquals(1, server.getRepository().getPartes().values().size());
		server.shutdown();
	}
	
	@Test
	void testEdicao() {
		String  nome = "TesteEdicao";
		ServidorImpl server = new ServidorImpl(nome);
		Part peca = new PartImpl("123","PecaTeste","Peça única");
		server.getRepository().addPeca(peca);
		peca = new PartImpl("123","PecaTeste","Peça única Editada");
		server.getRepository().addPeca(peca);
		peca = new PartImpl("124","PecaTeste","Peça única Nova");
		server.getRepository().addPeca(peca);
		peca = new PartImpl("125", "PecaComposta", "Peça composta");
		peca.getComponentes().put(new SubPartImpl("1", "Componente1", "Este é um componente"), 1);
		server.getRepository().addPeca(peca);
		System.out.println(server.getRepository().getPartes().toString());
		assertEquals(3, server.getRepository().getPartes().values().size());
		server.shutdown();
	}
	
	@Test
	void testBusca() {
		String  nome = "TesteBusca";
		ServidorImpl server = new ServidorImpl(nome);
		Part peca = new PartImpl("123","PecaTeste1","Peça única");
		server.getRepository().addPeca(peca);
		peca = new PartImpl("124","PecaTeste2","Mais uma Peça única");
		server.getRepository().addPeca(peca);
		peca = new PartImpl("125","PecaTeste3","E Mais outra Peça única Nova");
		server.getRepository().addPeca(peca);
//		System.out.println("Peça encontrada: "+server.getPartes().get("124").toString());
		assertEquals("124",server.getRepository().getPartes().get("124").getPartCod());
		server.shutdown();
	}

}
