package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.MathInterface;

public class Client {
	public static void main(String args[]) {
		try {
			MathInterface mth;

			Registry registry = LocateRegistry.getRegistry("localhost", 2014);
			mth = (MathInterface)registry.lookup("MathServer");

			int a = Integer.valueOf(args[0]).intValue();
			int b = Integer.valueOf(args[1]).intValue();

			System.out.println("Client: " + a + " + " + b + " = " + mth.add(a, b));
			System.out.println("Client: " + a + " - " + b + " = " + mth.subtract(a, b));
			System.out.println("Client: " + a + " * " + b + " = " + mth.multiply(a, b));
			System.out.println("Client: " + a + " / " + b + " = " + mth.divide(a, b));
		}
		catch (Exception e) {
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}