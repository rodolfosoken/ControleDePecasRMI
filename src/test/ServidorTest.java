package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import impl.PartImpl;
import impl.ServidorImpl;
import impl.SubPartImpl;
import interfaces.Part;

class ServidorTest {

	
	
	/**
	 * Testa a adição de uma peça
	 * ***/
	@Test
	void testAdd() {
		String  nome = "TesteAdd";
		ServidorImpl server = null;
		try {
			server = new ServidorImpl(nome);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
		Part peca = new PartImpl("123","PecaTeste","Peça única");
		server.addPeca(peca);
//		System.out.println(server.getPartes().toString());
		assertEquals(1, server.getListPecas().size());
		server.shutdown();
	}
	
	@Test
	void testEdicao() {
		String  nome = "TesteEdicao";
		ServidorImpl server = null;
		try {
			server = new ServidorImpl(nome);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
		Part peca = new PartImpl("PecaTeste","Peça única");
		server.addPeca(peca);
		server.getPeca(peca.getPartCod()).setPartDesc("Peça única editada");
		peca = new PartImpl("PecaTeste","Peça única Nova");
		server.addPeca(peca);
		peca = new PartImpl("PecaComposta", "Peça composta");
		peca.getComponentes().put(new SubPartImpl("Componente1", "Este é um componente"), 1);
		peca.getComponentes().put(new SubPartImpl("Componente2", "Este é outro componente"), 3);
		System.out.println(peca.getComponentes().get(new SubPartImpl("SP1", "Componente2", "Este é outro componente")).toString());
		server.addPeca(peca);
		System.out.println(server.getListPecas().toString());
		assertEquals(3, server.getListPecas().size());
		server.shutdown();
	}
	
	@Test
	void testBusca() {
		String  nome = "TesteBusca";
		ServidorImpl server = null;
		try {
			server = new ServidorImpl(nome);
			Part peca = new PartImpl("123","PecaTeste1","Peça única");
			server.addPeca(peca);
			peca = new PartImpl("124","PecaTeste2","Mais uma Peça única");
			server.addPeca(peca);
			peca = new PartImpl("125","PecaTeste3","E Mais outra Peça única Nova");
			server.addPeca(peca);
//		System.out.println("Peça encontrada: "+server.getPartes().get("124").toString());
			assertEquals("124",server.getPeca("124").getPartCod());
			server.shutdown();
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
	}

}
