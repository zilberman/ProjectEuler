package euler.level1;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

public class PowerDigitSum {
	public static void main(String[] args) {
		List<Integer> result = new LinkedList<>();
		
		Integer sum = 0;
		
		result.add(1);
		
		for (int i = 1; i < 1001; i++) {
			result = PowerDigitSum.multiplyByTwo(result);
		}
		
		for(Integer digit : result) {
			sum += digit;
		}
		
		System.out.println(sum);
	}
	
	private static List<Integer> multiplyByTwo(List<Integer> number) {
		List<Integer> result = new LinkedList<>();
		
		Integer buffer = 0;
		Integer digit = 0;
		Integer multiplication = 0;
		
		Iterator<Integer> iterator = number.iterator();
		
		while(iterator.hasNext()) {
			digit = iterator.next();
			
			multiplication = 2 * digit + buffer;
			
			buffer = (multiplication > 9) ? 1 : 0;
			
			result.add(multiplication % 10);
			
			digit = 0;
			multiplication = 0;
		}
		
		if(buffer == 1) {
			result.add(buffer);	
		}
		
		return result;
	}
}
