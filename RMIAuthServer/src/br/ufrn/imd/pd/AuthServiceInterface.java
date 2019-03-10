package br.ufrn.imd.pd;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AuthServiceInterface extends Remote { 
	
	public boolean register(String username, String password, List<String> permission) throws RemoteException;
	
	public boolean login(String username, String password) throws RemoteException;
	
	public String read(String username) throws RemoteException;
	
	public boolean update(String username, String password, List<String> permission) throws RemoteException;
	
	public boolean delete(String username) throws RemoteException; 
}
