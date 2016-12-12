package euler.level1;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class FibonacciNumber {
	public static void main(String[] args) {
		List<Integer> fibonacci1 = new LinkedList<>();
		fibonacci1.add(1);
		
		List<Integer> fibonacci2 = new LinkedList<>();
		fibonacci2.add(1);
		
		List<Integer> currentFibonacci = new LinkedList<>();
		currentFibonacci = FibonacciNumber.addTwoNumbers(fibonacci1, fibonacci2);
		
		int currentFibonacciIndex = 3;
		
		while(currentFibonacci.size() < 1000) {
			fibonacci1 = fibonacci2;
			fibonacci2 = currentFibonacci;
			
			currentFibonacci = FibonacciNumber.addTwoNumbers(fibonacci1, fibonacci2);
			currentFibonacciIndex++;
		}
		
		//System.out.println(currentFibonacci);
		System.out.println("The index is: " + currentFibonacciIndex);
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
