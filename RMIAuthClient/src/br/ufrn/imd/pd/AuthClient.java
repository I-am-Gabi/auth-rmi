package br.ufrn.imd.pd;

import java.rmi.Naming;

public class AuthClient {

	public static void main(String[] args) {
		AuthServiceInterface auth;
		try {
			auth = (AuthServiceInterface)Naming.lookup("rmi://localhost/auth");
			String msg = auth.hello("Gabriela");
			System.out.println(msg);
			msg = auth.hello("Juliana");
			System.out.println(msg);
			msg = auth.hello("Carla");
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("AuthClient exception: " + e);
		}
	}
}
