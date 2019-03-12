package br.ufrn.imd.pd;

import java.util.ArrayList;
import java.util.List; 

class User {
	public String password;
	public List<String> permissions;
	
	public User(String password, List<String> permissions) {   
		this.password = password; 
		this.permissions = new ArrayList<String>();
		this.permissions.addAll(permissions); 
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<String> getPermission() {
		return permissions;
	}
	
	@Override
	public String toString() {
        return this.password + ":" + this.permissions.toString();
    } 
}

