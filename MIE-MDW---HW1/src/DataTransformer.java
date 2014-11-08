import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DataTransformer {
	public static void main(String[] args) {
		if(args.length == 0) {
	        System.out.println("Usage: java program filename");
	        System.exit(0);
	    }
		String s = readFile(args[0], StandardCharsets.UTF_8);
		Transformer t = new Transformer();
		String j = t.getJsonFromString(s);
		System.out.println(j);
	}
	
	static String readFile(String path, Charset encoding) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		} catch(IOException e) {
			System.out.println("The " + path + " doesn't exist");
			return "";
		}
	}
}
