package br.univel.servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.comum.Plact;

public class Plunct extends Thread implements Runnable, Plact {
	private static final int PORTA_TCPIP = 1818;
	private Integer vlr = null;

	public void run() {
		Plact servico;
		try {
			servico = (Plact) UnicastRemoteObject.exportObject(Plunct.this, 0);
			Registry registry = LocateRegistry.createRegistry(PORTA_TCPIP);
			registry.rebind(Plact.NOME, servico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer calcule(Integer rec) throws RemoteException {
		if (this.vlr == null) {
			this.vlr = rec;
		} else {
			this.vlr = +rec;
		}
		System.out.println(vlr + 11);
		if (vlr >= 0 && vlr < 30) {
			vlr += 1;
			return vlr;
		} else {
			if (vlr >= 30 && vlr < 70) {
				vlr = +2;
				return vlr;
			} else {
				vlr += 3;
				return vlr;
			}

		}
	}

	public static void main(String[] args) {
		new Plunct().start();
	}
}
