package br.ufrn.imd.pd;

import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
import java.util.List;

import br.ufrn.imd.pd.User; 
import br.ufrn.imd.pd.DB; 

@SuppressWarnings("serial")
public class AuthService extends UnicastRemoteObject implements AuthServiceInterface {
	DB database;
	User user;

	protected AuthService() throws RemoteException { 
		this.database = new DB(); 
	} 

	@Override
	public boolean register(String username, String password, List<String> permission) throws RemoteException { 
		this.database.insert(username, password, permission);
		return true;
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		if (database.validate(username, password)) {
			user = database.getUser(username);
			return true;
		}
	
		return false;
	}

	@Override
	public String read(String username) throws RemoteException {
		if (user.getPermission().contains("read")) {
			return this.database.getUser(username).getPermission().toString();
		}
		return "-";
	}

	@Override
	public boolean update(String username, String password, List<String> permission) throws RemoteException {
		if (user.getPermission().contains("update")) {
			return this.database.update(username, password, permission);
		}
		return false;
	}

	@Override
	public boolean delete(String username) throws RemoteException {
		if (user.getPermission().contains("delete")) {
			return this.database.delete(username);
		}
		return false;
	} 
}
