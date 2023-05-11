import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {

	
	public void writeText(String filename, String text) {
		
		try {
			
			FileWriter fw = new FileWriter(filename);
			fw.write(text);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String readText(String filename) {
		String out = "";
		
		try {
			
			FileReader fr = new FileReader(filename);
			Scanner scan = new Scanner(fr);
			
			
			while(scan.hasNextLine()) {
				out += scan.nextLine() + "\n";
			}
			
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}
	
	
}
