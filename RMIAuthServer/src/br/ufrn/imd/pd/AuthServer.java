package br.ufrn.imd.pd; 

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject; 
 
public class AuthServer extends AuthService { 
	protected AuthServer() throws RemoteException {}

	public static void main(String[] args) {
		try { 
			String serviceName = "AuthService"; 
			
			// Bind the remote object's stub in the registry
			AuthServiceInterface stub = (AuthServiceInterface) UnicastRemoteObject.exportObject(new AuthService(), 0); 
			Registry registry = LocateRegistry.createRegistry(1098);
			registry.rebind(serviceName, stub);
			
			System.out.println("Auth Server is ready."); 
		} catch (Exception e) {
			System.out.println("Auth Server failed: " + e); 
		} 
	}
}
