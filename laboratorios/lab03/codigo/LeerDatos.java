package lab03;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerDatos {

	public static void main(String[] args) throws IOException {
		
		 System.out.println(readData());

	}
	
	public static List<String[]> readData() throws IOException { 
	    int count = 0;
	    String file = "C:\\Users\\samue\\eclipse-workspace\\lab03\\src\\lab03\\NOTAS ST0242.csv";
	    List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    }
	    return content;
	}

}
