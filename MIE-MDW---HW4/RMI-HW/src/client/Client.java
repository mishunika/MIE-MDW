package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.CurrencyConverterInterface;;

public class Client {
	public static void main(String args[]) {
		try {
			CurrencyConverterInterface c;

			Registry registry = LocateRegistry.getRegistry("localhost", 2014);
			c = (CurrencyConverterInterface)registry.lookup("MathServer");

			System.out.println("Client: 100 USD = " + c.convert("USD", "EUR", 100.0) + " EUR.");
			System.out.println("Client: 100 EUR = " + c.convert("EUR", "USD", 100.0) + " USD.");
			System.out.println("Client: 100 EUR = " + c.convert("EUR", "GBP", 100.0) + " GBP.");
		}
		catch (Exception e) {
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}