package br.ufrn.imd.pd; 

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 
 
public class AuthServer extends AuthService { 
	protected AuthServer() throws RemoteException {}

	public static void main(String[] args) {
		try { 
			String serviceName = "/AuthService"; 
			String hostname = "//0.0.0.0";
			String port = "1098";
	        String bindLocation = hostname + ":" + port + serviceName;
	        
			// Bind the remote object's stub in the registry
			AuthServiceInterface stub = (AuthServiceInterface) UnicastRemoteObject.exportObject(new AuthService(), 0); 
			LocateRegistry.createRegistry(1098); 
			Naming.bind(bindLocation, stub);
			System.out.println("Auth Server is ready."); 
		} catch (Exception e) {
			System.out.println("Auth Server failed: " + e); 
		} 
	}
}
