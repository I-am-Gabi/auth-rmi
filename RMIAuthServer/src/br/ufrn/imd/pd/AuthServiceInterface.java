package br.ufrn.imd.pd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthServiceInterface extends Remote {
	public String hello(String name) throws RemoteException;
}
