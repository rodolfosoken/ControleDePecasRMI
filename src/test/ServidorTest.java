package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import impl.PartImpl;
import impl.Servidor;
import interfaces.Part;

class ServidorTest {

	
	
	/**
	 * Testa a adição de uma peça
	 * ***/
	@Test
	void testAdd() {
		String  nome = "TesteAdd";
		Servidor server = null;
		try {
			server = new Servidor(nome);
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
		Servidor server = null;
		try {
			server = new Servidor(nome);
			Part part = new PartImpl("PecaTeste","Peça única",nome);
			server.getPartRepository().addPart(part);
			server.getPartRepository().getPart(part.getPartCod()).setPartDesc("Peça única editada");
			part = new PartImpl("PecaTeste","Peça única Nova",nome);
			server.getPartRepository().addPart(part);
			part = new PartImpl("PecaComposta", "Peça composta",nome);
			part.addComponent(new PartImpl("Componente1", "Este é um componente",nome), 1);
			part.addComponent(new PartImpl("Componente2", "Este é outro componente",nome), 3);
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
		Servidor server = null;
		try {
			server = new Servidor(nome);
			Part part = new PartImpl("123","PecaTeste1","Peça única",nome);
			server.getPartRepository().addPart(part);
			part = new PartImpl("124","PecaTeste2","Mais uma Peça única",nome);
			server.getPartRepository().addPart(part);
			part = new PartImpl("125","PecaTeste3","E Mais outra Peça única Nova",nome);
			server.getPartRepository().addPart(part);
		System.out.println("Peça encontrada: "+server.getPartRepository().getPart("124").toString());
			assertEquals("124",server.getPartRepository().getPart("124").getPartCod());
			server.shutdown();
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			fail("Erro ao conectar");
		}
	}

}
