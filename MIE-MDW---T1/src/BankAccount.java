import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BankAccount {
	public static void main(String[] argv) {
		String input = "owner_surname: \"SURNAME\"\nowner_name: \"NAME\"\nbank_account: \"XXXX-XXXX/XXXX\"\nexpiration: \"JAN/2020\"";
		String [] result;
		String output;
		result = parseString(input);
		output = createXMLProfile(result);
		System.out.println(output);
	}
	
	private static String[] parseString(String s) {
		String [] result;
		result = new String[4];
		
		String lines[] = s.split("\\r?\\n");
		String line[];
		for(int i = 0; i < lines.length; i++) {
			line = lines[i].split(": ");
			line[1] = line[1].replace("\"", "");

			switch(line[0]) {
				case "owner_surname":
					result[2] = line[1];
					break;
				case "owner_name":
					result[2] = line[1] + " " + result[2];
					break;
				case "bank_account":
					result[0] = line[1].split("/")[0];
					result[1] = line[1].split("/")[1];
					break;
				case "expiration":
					Date parsedDate = new Date();
					DateFormat f = new SimpleDateFormat("MMM/yyyy", Locale.US);
					try {
						parsedDate = (Date)f.parse(line[1]);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					String formattedDate = new SimpleDateFormat("MM/yyyy").format(parsedDate);
					result[3] = formattedDate;
					break;
					
			}
		}
		
		return result;
	}
	
	private static String createXMLProfile(String[] input) {
		String s;
		
		s  = "<bankAccount>\n";
		s += "  <accountPrefix>" + input[0] + "</accountPrefix>\n";
		s += "  <accountSuffix>" + input[1] + "</accountSuffix>\n";
		s += "  <owner>" + input[2] + "</owner>\n";
		s += "  <exp>" + input[3] + "</exp>\n";
		s += "</bankAccount>";
		
		return s;
	}
}
