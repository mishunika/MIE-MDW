package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.MathInterface;


public class Server {
	public static void main(String[] args) {
		try {
			MathInterface msi = new MathServer();
			
			MathInterface stub = (MathInterface) UnicastRemoteObject.exportObject(msi, 50000);

			Registry registry = LocateRegistry.createRegistry(2014);
			registry.rebind("MathServer", stub);
			System.out.println("Server started...");
		}
		catch (Exception e) {
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}