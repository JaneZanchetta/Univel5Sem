package br.univel.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Plact extends Remote {
	public static final String NOME = "PlunctPlact";
	
	public Integer calcule(Integer vlr) throws RemoteException;

}
