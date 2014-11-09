package server;

import java.rmi.RemoteException;

import rmi.MathInterface;

public class MathServer implements MathInterface  {
	private static final long serialVersionUID = 1L;

	public MathServer() throws RemoteException {
		super();
	}

	public int add(int a, int b) throws RemoteException {
		System.out.println("Server: " + a + " + " + b + " = " + (a + b));
		return a + b;
	}
	
	public int subtract(int a, int b) throws RemoteException {
		System.out.println("Server: " + a + " - " + b + " = " + (a - b));
		return a - b;
	}
	
	public int multiply(int a, int b) throws RemoteException {
		System.out.println("Server: " + a + " * " + b + " = " + (a * b));
		return a * b;
	}
	
	public int divide(int a, int b) throws RemoteException {
		System.out.println("Server: " + a + " / " + b + " = " + (a / b));
		return a / b;
	}
}