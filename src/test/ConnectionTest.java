package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.jupiter.api.Test;

import interfaces.PartRepository;
import servidor.PartRepositoryImpl;

class ConnectionTest {


	@Test
	void test() {
		String  nome = "Repositório Teste1";
		
		PartRepositoryImpl repo = new PartRepositoryImpl(nome);
		try {
			PartRepository stub = (PartRepository) UnicastRemoteObject.exportObject(repo,0);
			Registry reg = LocateRegistry.getRegistry();
			reg.bind("repo", stub);
//			System.out.println("Servidor "+nome+" iniciado");
			reg.unbind("repo");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Erro de conexão");
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
			fail("Stub já registrado");
		} catch (NotBoundException e) {
			e.printStackTrace();
			fail("Stub não está mais registrado");
		}
	}

}
