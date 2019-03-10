package br.ufrn.imd.pd;

import java.rmi.Naming; 

public class AuthServer {
	public static void main(String[] args) {
		try {
			AuthService auth = new AuthService(); 
			Naming.rebind("rmi://localhost/auth", auth);
			System.out.println("Auth Server is ready.");
			
		} catch (Exception e) {
			System.out.println("Addition Server failed: " + e);
		} 
	}
}
