package webservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;

import javax.jws.WebService;

@WebService
public class SimpleService {
	public String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public String toUpperCase(String s) {
		return s.toUpperCase();
	}
	
	public double sqrt(double x) {
		return Math.sqrt(x);
	}
	
	public float operation(String operation, float a, float b) {
		switch(operation) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b;
		}
		
		return 0;
	}
}
