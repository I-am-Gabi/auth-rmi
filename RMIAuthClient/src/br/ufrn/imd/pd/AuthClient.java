package br.ufrn.imd.pd;    

import java.rmi.Naming; 
import java.util.Arrays; 
public class AuthClient {
	
	public static void main(String[] args) { 
		try { 
			String serviceName = "/AuthService"; 
			String hostname = "//0.0.0.0";
			String port = "1098";
	        String connectLocation = hostname + ":" + port + serviceName;

			AuthServiceInterface stub = (AuthServiceInterface) Naming.lookup(connectLocation); 
			
			// register gabi
			boolean result = stub.register("gabi", "123", Arrays.asList("read", "delete")); 
			if (result) System.out.println("Usuario registrado com sucesso");
			else System.out.println("Falha no registro"); 
			
			// register ju
			result = stub.register("juliana", "123", Arrays.asList("read", "update"));
			if (result) System.out.println("Usuario registrado com sucesso");
			else System.out.println("Falha no registro");
			
			// read gabi
			String msg = stub.read("gabi");
			System.out.println(msg); 
			
			// login ju
			result = stub.login("juliana", "123");
			if (result) System.out.println("Usuario logado com sucesso");
			else System.out.println("Falha no login");
			
			msg = stub.read("gabi");
			System.out.println(msg); 
			
			result = stub.update("gabi", "12345", Arrays.asList("read", "delete"));
			if (result) System.out.println("Usuario editado com sucesso");
			else System.out.println("Falha na edição");
			
			result = stub.delete("gabi");
			if (result) System.out.println("Usuario deletado com sucesso");
			else System.out.println("Falha para deletar");
			
			result = stub.deslogar("juliana", "123");
			if (result) System.out.println("Usuario deslogado com sucesso");
			else System.out.println("Falha para deslogar");
			
			result = stub.login("gabi", "12345");
			if (result) System.out.println("Usuario logado com sucesso");
			else System.out.println("Falha no login");
			
			result = stub.delete("juliana");
			if (result) System.out.println("Usuario deletado com sucesso");
			else System.out.println("Falha para deletar");
		} catch (Exception e) {
			System.out.println("AuthClient exception: " + e);
		}
	}
}
