package validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.jws.WebService;

@WebService
public class Validator { 
	private Pattern pattern;
	private Matcher matcher;
	private static final String USERNAME_PATTERN = "^[a-zA-Z]{6}[0-9]?$";
	private static final String EMAIL_PATTERN = "^[a-zA-Z]{6}[0-9]?@fit.cvut.cz$";
	private static final String CARD_PATTERN = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
	
	public boolean username(String u) {
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(u);
		return matcher.matches();
	}
	
	public boolean email(String e) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(e);
		return matcher.matches();
	}
	
	public boolean card(String c) {
		pattern = Pattern.compile(CARD_PATTERN);
		matcher = pattern.matcher(c);
		return matcher.matches();
	}
}
