import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transformer {
	public Transformer() {
		
	}
	
	public String getJsonFromString(String s) {
		String lines[] = s.split("\\r?\\n");
		String splittedWhere[] = new String[0];
		String what = "", when = "", where = "";
		Date whenDate = new Date();
		for(int i = 0; i < lines.length; i++) {
			switch(lines[i]) {
				case "--name":
					what = lines[++i];
					break;
					
				case "--start":
					when = lines[++i].replaceAll("(th|nd|st)", "");
					DateFormat f = new SimpleDateFormat("dd MMM yyyy", Locale.US);
					try {
						whenDate = (Date)f.parse(when);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
					
				case "--location":
					where = lines[++i];
					splittedWhere = where.split(", ");
					break;
					
				case "--sumary":
					what += " - " + lines[++i];
					break;
			}
		}
		
		return buildJson(what, whenDate, splittedWhere);
	}	
	
	private String buildJson(String what, Date when, String[] where) {
		String s;
		String formattedDate = new SimpleDateFormat("d.M.yyyy").format(when);
		
		s =  "{\n";
		s += "  \"what\": \"" + what + "\",\n";
		s += "  \"when\": \"" + formattedDate + "\",\n";
		s += "  \"where\": {\n";
		s += "    \"street\": \"" + where[0] + "\",\n";
		s += "    \"city\": \"" + where[2] + "\",\n";
		s += "    \"zip\": \"" + where[1] + "\"\n";
		s += "  }\n";
		s += "}";
		
		return s;
	}
}
