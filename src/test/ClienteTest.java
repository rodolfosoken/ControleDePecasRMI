package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import impl.Cliente;
import impl.PartImpl;
import impl.Servidor;
import interfaces.Part;

class ClienteTest {

	String servidorNome = "ClienteServidorTeste";
	Servidor servidor0,servidor;

	@BeforeEach
	void setUp() throws Exception {
		try {
			servidor0 = new Servidor(servidorNome+"0");
			servidor = new Servidor(servidorNome);
		} catch (RemoteException e) {
			fail("Erro ao iniciar Servidor de teste para clientes: " + e.getMessage());
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		servidor.shutdown();
		servidor0.shutdown();
	}

	@Test
	void test() {
		try {
			Cliente cliente = new Cliente(servidorNome);
			Part peca = new PartImpl("Peça1", "Peça criada por um cliente");
			cliente.addPart(peca);
			cliente.showParts();
			cliente.getNomeServidor();
		} catch (RemoteException e) {
			fail("Falha ao criar cliente: " + e.getMessage());
		} catch (NotBoundException e) {
			fail("Servidor não listado no registro: " + e.getMessage());

		}

	}

}
