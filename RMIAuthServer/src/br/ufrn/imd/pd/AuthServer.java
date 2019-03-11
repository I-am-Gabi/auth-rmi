package br.ufrn.imd.pd; 

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger; 

 
public class AuthServer extends AuthService {
	private static final Logger logger = LogManager.getLogger(AuthServer.class);
	 
	protected AuthServer() throws RemoteException {}

	public static void main(String[] args) {
		try { 
			String serviceName = "AuthService"; 
			
			// Bind the remote object's stub in the registry
			AuthServiceInterface stub = (AuthServiceInterface) UnicastRemoteObject.exportObject(new AuthService(), 0); 
			Registry registry = LocateRegistry.createRegistry(1098);
			registry.rebind(serviceName, stub);
			
			logger.info("Auth Server is ready."); 
		} catch (Exception e) {
			logger.error("Auth Server failed: " + e); 
		} 
	}
}
