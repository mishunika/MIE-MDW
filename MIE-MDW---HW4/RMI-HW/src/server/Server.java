package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.CurrencyConverterInterface;;


public class Server {
	public static void main(String[] args) {
		try {
			CurrencyConverterInterface msi = new CurrencyConverterServer();
			
			CurrencyConverterInterface stub = (CurrencyConverterInterface) UnicastRemoteObject.exportObject(msi, 50000);

			Registry registry = LocateRegistry.createRegistry(2014);
			registry.rebind("MathServer", stub);
			System.out.println("Server started...");
		}
		catch (Exception e) {
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}