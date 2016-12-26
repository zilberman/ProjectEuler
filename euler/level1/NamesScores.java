package euler.level1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.TreeSet;

public class NamesScores {
	public static void main(String[] args) {
		BufferedReader reader = null;
		String line = null;
		
		int nameIndex = 1;
		long namesScores = 0;
		
		TreeSet<String> names = new TreeSet<>();
		
		try {
			reader = new BufferedReader(new FileReader("names.txt"));
			
			while((line = reader.readLine()) != null) {
				String[] namesAsArray = line.split(",");
				
				for(String name : namesAsArray) {
					names.add(name);	
				}
			}
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
		finally {
			try {
				if(reader != null) {
					reader.close();	
				}
			}
			catch(IOException exception) {
				exception.printStackTrace();	
			}
		}
		
		for(String name : names) {
			namesScores += nameIndex * NamesScores.computeAlphabeticalOrder(name);
			nameIndex++;
		}
		
		System.out.println("Names scores is: " + namesScores);
	}
	
	private static int getCodeOfLetter(char letter) {
		return letter == '"' ? 0 : Character.getNumericValue(letter) - 9;
	}
	
	private static int computeAlphabeticalOrder(final String name) {
		int result = 0;
		
		for(int i = 0; i < name.length(); i++) {
			result += NamesScores.getCodeOfLetter(name.charAt(i));	
		}
		
		return result;
	}
}
