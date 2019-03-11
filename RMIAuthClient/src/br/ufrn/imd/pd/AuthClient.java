package br.ufrn.imd.pd;
 
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays; 
public class AuthClient {

	public static void main(String[] args) { 
		try {
			String serviceName = "AuthService"; 
			
			// getting the registry 
			Registry registry = LocateRegistry.getRegistry(1098); 
			// looking up the registry for the remote object 
			AuthServiceInterface stub = (AuthServiceInterface) registry.lookup(serviceName); 
			
			boolean result = stub.register("gabi", "123", Arrays.asList("read"));
			if (result) System.out.println("usuario registrado com sucesso");
			else System.out.println("falha no registro");
			
			result = stub.register("ju", "123", Arrays.asList("read"));
			if (result) System.out.println("usuario registrado com sucesso");
			else System.out.println("falha no registro");
			
			String msg = stub.read("gabi");
			System.out.println(msg); 
			
			result = stub.login("ju", "123");
			if (result) System.out.println("usuario logado com sucesso");
			else System.out.println("falha no login");
			
			msg = stub.read("gabi");
			System.out.println(msg); 
			
		} catch (Exception e) {
			System.out.println("AuthClient exception: " + e);
		}
	}
}
