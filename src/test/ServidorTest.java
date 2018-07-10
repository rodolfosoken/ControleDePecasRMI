package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.jupiter.api.Test;

import interfaces.Part;
import interfaces.Servidor;
import servidor.PartImpl;
import servidor.ServidorImpl;

class ServidorTest {

	/**
	 * Teste de registro
	 * **/
	@Test
	void testBind() {
		String  nome = "TesteBind";
		
		ServidorImpl server = new ServidorImpl(nome);
		try {
			Servidor stub = (Servidor) UnicastRemoteObject.exportObject(server,0);
			Registry reg = LocateRegistry.getRegistry();
			reg.bind(nome, stub);
//			System.out.println("Servidor "+nome+" iniciado");
			reg.unbind(nome);
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
	
	
	/**
	 * Testa a adição de uma peça
	 * ***/
	@Test
	void testAdd() {
		String  nome = "TesteAdd";
		
		ServidorImpl server = new ServidorImpl(nome);
		try {
			Servidor stub = (Servidor) UnicastRemoteObject.exportObject(server,0);
			Registry reg = LocateRegistry.getRegistry();
			reg.bind(nome, stub);
//			System.out.println("Servidor "+nome+" iniciado");
			Part peca = new PartImpl("PecaTeste","Peça única");
			server.addPeca(peca);
			reg.unbind(nome);
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
