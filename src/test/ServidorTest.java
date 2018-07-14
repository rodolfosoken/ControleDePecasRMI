package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import impl.PartImpl;
import impl.ServidorImpl;
import interfaces.Part;
import interfaces.Servidor;

class ServidorTest {

	
	
	/**
	 * Testa a adição de uma peça
	 * ***/
	@Test
	void testAdd() {
		String  nome = "TesteAdd";
		Servidor server = null;
		try {
			server = new ServidorImpl(nome);
			Part part = new PartImpl("123","PecaTeste","Peça única");
			server.getPartRepository().addPart(part);
//		System.out.println(server.getPartes().toString());
			assertEquals(1, server.getPartRepository().getListParts().size());
			server.shutdown();
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
	}
	
	@Test
	void testEdicao() {
		String  nome = "TesteEdicao";
		ServidorImpl server = null;
		try {
			server = new ServidorImpl(nome);
			Part part = new PartImpl("PecaTeste","Peça única");
			server.getPartRepository().addPart(part);
			server.getPartRepository().getPart(part.getPartCod()).setPartDesc("Peça única editada");
			part = new PartImpl("PecaTeste","Peça única Nova");
			server.getPartRepository().addPart(part);
			part = new PartImpl("PecaComposta", "Peça composta");
			part.getComponentes().put(new PartImpl("Componente1", "Este é um componente"), 1);
			part.getComponentes().put(new PartImpl("Componente2", "Este é outro componente"), 3);
//		System.out.println(peca.getComponentes().get(new PartImpl("P8", "Componente2", "Este é outro componente")).toString());
			server.getPartRepository().addPart(part);
			System.out.println(server.getPartRepository().getListParts().toString());
			assertEquals(3, server.getPartRepository().getListParts().size());
			server.shutdown();
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
	}
	
	@Test
	void testBusca() {
		String  nome = "TesteBusca";
		ServidorImpl server = null;
		try {
			server = new ServidorImpl(nome);
			Part part = new PartImpl("123","PecaTeste1","Peça única");
			server.getPartRepository().addPart(part);
			part = new PartImpl("124","PecaTeste2","Mais uma Peça única");
			server.getPartRepository().addPart(part);
			part = new PartImpl("125","PecaTeste3","E Mais outra Peça única Nova");
			server.getPartRepository().addPart(part);
//		System.out.println("Peça encontrada: "+server.getPartes().get("124").toString());
			assertEquals("124",server.getPartRepository().getPart("124").getPartCod());
			server.shutdown();
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
	}

}
