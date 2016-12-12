package euler.level1;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LargeSum {
	public static void main(String[] args) {
		BufferedReader reader = null;
		String line = null;
		
		List<List<Integer>> allNumbers = new LinkedList<>();
		
		List<Integer> result = new LinkedList<>();
		
		try {
			reader = new BufferedReader(new FileReader("large_sum.txt"));
					
			while((line = reader.readLine()) != null) {
				List<Integer> singleNumber = new LinkedList<>();
				
				for (int i = line.length() - 1; i > -1; i--) {
					singleNumber.add(Character.getNumericValue(line.charAt(i)));	
				}
				
				allNumbers.add(singleNumber);
			}
			
			for (List<Integer> aNumber : allNumbers) {
				result = LargeSum.addTwoNumbers(result, aNumber);
			}
			
			ListIterator<Integer> listIterator = result.listIterator(result.size());
			while(listIterator.hasPrevious()) {
				System.out.print(listIterator.previous());
			}
			
			System.out.println();
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
	}
	
	private static List<Integer> addTwoNumbers(List<Integer> number1, List<Integer> number2) {
		List<Integer> result = new LinkedList<>();
		
		Integer buffer = 0;
		Integer digit1 = 0;
		Integer digit2 = 0;
		Integer sum = 0;
		
		Iterator<Integer> iterator1 = number1.iterator();
		
		Iterator<Integer> iterator2 = number2.iterator();
		
		while(iterator1.hasNext() || iterator2.hasNext()) {
			if(iterator1.hasNext()) {
				digit1 = iterator1.next();
			}
			
			if(iterator2.hasNext()) {
				digit2 = iterator2.next();
			}
			
			sum = digit1 + digit2 + buffer;
			
			buffer = (sum > 9) ? 1 : 0;
			
			result.add(sum % 10);
			
			digit1 = 0;
			digit2 = 0;
			sum = 0;
		}
		
		if(buffer == 1) {
			result.add(buffer);	
		}
		
		return result;
	}
}
