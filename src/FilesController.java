import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FilesController {

	// Variables
	private static String filePath;
	
	// Constructor
	public FilesController(String filePath) {
		setFileName(filePath);
	}

	/* 
	 * ================
	 * 	  Functions 
	 * ================
	 */
	
//	// Read Data From file
//	public ArrayList<String> readData() {
//		ArrayList<String> inputFile = new ArrayList<String>();
//		BufferedReader reader;
//		try {
//			reader = new BufferedReader(new FileReader(filePath));
//			String line = reader.readLine();
//			while (line != null) {
//				inputFile.add(line);
//				line = reader.readLine();
//			}
//			reader.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return inputFile;
//	}
	
	  public static String readInput(){

	        String stream = "";
	        BufferedReader code = null;
	        try
	        {
	        	code = new BufferedReader(new FileReader(filePath));

	            String code_line;
	            while ((code_line = code.readLine()) != null)
	            {
	                stream += code_line;
	                stream += '\n';
	            }

	        } catch (Exception e) { }
	        
	        return stream;
	    }
	
	// Read mapping table from files
	public ArrayList<Token> getTable() {
		ArrayList<Token> mappingTable = new ArrayList<Token>();
		BufferedReader namesReader, tokensReader , regexReader;
		try {
			namesReader = new BufferedReader(new FileReader("names.txt"));
			tokensReader = new BufferedReader(new FileReader("tokens.txt"));
			regexReader = new BufferedReader(new FileReader("regex.txt"));
			String namesLine = namesReader.readLine();
			String tokensLine = tokensReader.readLine();
			String regexLine = regexReader.readLine();
			while (namesLine != null && tokensLine != null && regexLine != null  ) {
				Token token = new Token(namesLine , tokensLine , regexLine);
				mappingTable.add(token);
				namesLine = namesReader.readLine();
				tokensLine = tokensReader.readLine();
				regexLine = regexReader.readLine();
			}
			namesReader.close();
			tokensReader.close();
			regexReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mappingTable;
	}
	
	// Write program output to the file
	public void writeOutput() {
		
	}
	
	// Write program error to the file
	public void writeError() {
		
	}
	
	// Setter and Getters
	public String getFileName() {
		return filePath;
	}

	public void setFileName(String filePath) {
		this.filePath = filePath;
	}
}
