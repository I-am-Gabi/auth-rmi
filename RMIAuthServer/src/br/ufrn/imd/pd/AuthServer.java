package br.ufrn.imd.pd;

import java.rmi.Naming; 

public class AuthServer {
	public static void main(String[] args) {
		try {
			Auth auth = new Auth();
			Naming.rebind("rmi://localhost/auth", auth);
			System.out.println("Addition Server is ready.");
			
		} catch (Exception e) {
			System.out.println("Addition Server failed: " + e);
		} 
	}
}
