package br.ufrn.imd.pd;
  
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry; 

public class AuthServer {
	public static void main(String[] args) {
		try { 
			String serviceName = "authservice";
			AuthServiceInterface stub = new AuthService();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(serviceName, stub);
			
			System.out.println("Auth Server is ready.");
			
		} catch (Exception e) {
			System.out.println("Addition Server failed: " + e);
		} 
	}
}
