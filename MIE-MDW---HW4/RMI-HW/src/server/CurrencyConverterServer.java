package server;

import java.rmi.RemoteException;

import rmi.CurrencyConverterInterface;

public class CurrencyConverterServer implements CurrencyConverterInterface {
	private Double eurUsd = 1.25;
	private Double eurGbp = 0.80;
	private Double usdGbp = 0.64;
	
	private static final long serialVersionUID = 1L;

	public CurrencyConverterServer() throws RemoteException {
		super();
	}
	
	public Double convert(String from, String to, Double amount) throws RemoteException {
		if (from.equals("EUR")) {
			if (to.equals("USD")) {
				return amount * eurUsd;
			} else if (to.equals("GBP")) {
				return amount * eurGbp;
			}
		} else if (from.equals("USD")) {
			if (to.equals("EUR")) {
				return amount * (1/eurUsd);
			} else if (to.equals("GBP")) {
				return amount * usdGbp;
			}
		} else if (from.equals("GBP")) {
			if (to.equals("EUR")) {
				return amount * 1/eurGbp;
			} else if (to.equals("USD")) {
				return amount * 1/usdGbp;
			}
		}
		
		throw new RemoteException("There is no currency converter defined for the combination: from " + 
									from + " to " + to);
	}
}
