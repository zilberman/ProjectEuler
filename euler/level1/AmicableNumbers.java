package euler.level1;

import java.util.Map;
import java.util.HashMap;

public class AmicableNumbers {
	public static void main(String[] args) {
		Map<Integer, Integer> allNumbers = new HashMap<>();
		
		int finalSum = 0;
		
		for (int number = 2; number < 10000; number++) {
			Integer sum = 0;
			
			for (int i = 1; i < 1 + number / 2; i++) {
				if(number % i == 0) {
					sum += i;	
				}
			}
			
			allNumbers.put(number, sum);
		}
		
		for (int number = 2; number < 10000; number++) {
			Integer firstNumber = new Integer(number);
			Integer secondNumber = allNumbers.get(firstNumber);
			
			if (firstNumber.equals(secondNumber) || secondNumber.compareTo(firstNumber) < 0) {
				continue;
			}
			
			if (allNumbers.containsKey(secondNumber) && allNumbers.get(secondNumber).equals(firstNumber)) {
				finalSum += firstNumber + secondNumber;
			}
		}
		
		System.out.println("Final sum is: " + finalSum);
	}
}
