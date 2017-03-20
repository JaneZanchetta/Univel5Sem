package br.univel.cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.comum.Constantes;
import br.univel.comum.Plact;
import br.univel.servidor.Plunct;

public class Zoom extends Thread implements Runnable {
	
	
	public Zoom () throws Exception {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1818);
		Plact servico = (Plact) registry.lookup(Plact.NOME);
		Integer retorno = servico.calcule(Constantes.RA_DEZENA);
		System.out.println(retorno);
		
	}
	
	public static void main (String [] args) {
		try {
			new Zoom();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
