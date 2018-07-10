package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.PartRepository;
import servidor.PartRepositoryImpl;

class PartRepositoryTest {
	
	String  nome = "Teste2";	
	PartRepositoryImpl repo = new PartRepositoryImpl(nome);
	PartRepository stub;
	Registry reg;
	@BeforeEach
	void setUp() throws Exception {
		
		try {
			stub = (PartRepository) UnicastRemoteObject.exportObject(repo,0);
			reg = LocateRegistry.getRegistry();
			reg.bind(nome, stub);
			System.out.println("Servidor "+repo.getServidorNome()+" iniciado");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Erro de conexão");
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
			fail("Stub já registrado");
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			reg.unbind(nome);
		} catch (NotBoundException e) {
			e.printStackTrace();
			fail("Stub não está mais registrado");
		}
	}

	@Test
	void test() {
		
	}

}
