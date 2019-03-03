package br.ufrn.imd.pd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthInterface extends Remote {
	public String hello(String name) throws RemoteException;
}
