package br.ufrn.imd.pd;

import java.rmi.RemoteException;  
import java.util.List;

import br.ufrn.imd.pd.User; 
import br.ufrn.imd.pd.DB; 
 
public class AuthService implements AuthServiceInterface {
	DB database;
	User user;

	protected AuthService() throws RemoteException {  
		this.database = new DB(); 
	} 

	@Override
	public boolean register(String username, String password, List<String> permission) throws RemoteException { 
		System.out.println("* register " +  username + " " +  password + " " + permission.toString());
		this.database.insert(username, password, permission);
		System.out.println(">>> database: " + this.database.getData().toString());
		return true;
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		System.out.println("* login " +  username + " " +  password); 
		if (database.validate(username, password)) {
			user = database.getUser(username);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deslogar(String username, String password) throws RemoteException {
		System.out.println("* deslogar " +  username + " " +  password);
		if (database.validate(username, password)) {
			user = null;
			return true;
		}
		return false;
	}

	@Override
	public String read(String username) throws RemoteException {
		System.out.println("* read " +  username); 
		if (user == null) {
			System.out.println("Você precisa estar logado");
			return "Você precisa estar logado";
		}
		if (user.getPermission().contains("read")) {
			return this.database.getUser(username).getPermission().toString();
		}
		System.out.println("Você não tem permissão para realizar read");
		return "Você não tem permissão para realizar a leitura";
	}

	@Override
	public boolean update(String username, String password, List<String> permission) throws RemoteException {
		System.out.println("* update " +  username + " " +  password + " " + permission.toString());
		if (user == null) return false;
		if (user.getPermission().contains("update")) {
			boolean result = this.database.update(username, password, permission);
			System.out.println(">>> database: " + this.database.getData().toString());
			return result;
		}
		System.out.println("Você não tem permissão para realizar update");
		return false;
	}

	@Override
	public boolean delete(String username) throws RemoteException {
		System.out.println("* delete " +  username);
		if (user == null) return false;
		if (user.getPermission().contains("delete")) { 
			boolean result = this.database.delete(username);
			System.out.println(">>> database: " + this.database.getData().toString());
			return result;
		}
		System.out.println("Você não tem permissão para realizar delete");
		return false;
	} 
}
