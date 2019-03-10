package br.ufrn.imd.pd;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DB {  
	Map<String, User> database;
	
	public DB() { 
		this.database = new HashMap<String, User>();
	}
	
	public boolean insert(String username, String password, List<String> permission) {
		if (contains(username)) return false;
		
		this.database.put(username, new User(password, permission));
		return true;
	}
	
	public boolean delete(String username) {
		if (!contains(username)) return false;
		
		this.database.remove(username);
		return true;
	}
	
	public boolean update(String username, String password, List<String> permission) {
		if (!contains(username)) return false;
		
		this.database.replace(username, new User(password, permission));
		return true;
	}
	
	public boolean contains(String username) {
		return this.database.containsKey(username);
	}
	
	public boolean validate(String username, String password) {
		User user = this.database.get(username);
		if (user != null) {
			String pw = user.getPassword();
			if (pw == password) return true;
		}
		return false;
	} 
	
	public User getUser(String username) {
		return this.database.get(username); 
	}
}