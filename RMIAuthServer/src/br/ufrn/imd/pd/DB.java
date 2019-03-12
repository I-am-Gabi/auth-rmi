package br.ufrn.imd.pd;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DB {  
	Map<String, User> data;
	
	public DB() { 
		this.data = new HashMap<String, User>();
	}
	
	public boolean insert(String username, String password, List<String> permission) { 
		if (contains(username)) return false; 
		this.data.put(username, new User(password, permission)); 
		return true;
	}
	
	public boolean delete(String username) {
		if (!contains(username)) return false;
		
		this.data.remove(username);
		return true;
	}
	
	public boolean update(String username, String password, List<String> permission) {
		if (!contains(username)) return false;
		
		this.data.replace(username, new User(password, permission));
		return true;
	}
	
	public boolean contains(String username) {  
		boolean result = this.data.containsKey(username); 
		return result;
	}
	
	public boolean validate(String username, String password) {
		User user = this.data.get(username); 
		if (user != null) {
			String pw = user.getPassword(); 
			if (pw.equals(password)) return true;
		}
		return false;
	} 
	
	public User getUser(String username) {
		return this.data.get(username); 
	}
	
	public Map<String, User> getData() {
		return this.data;
	}
}