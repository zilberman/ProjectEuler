package euler.level1;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class NonAbundantSums {
	private static int upperLimit = 28124;
	public static void main(String[] args) {
		int result = 0;
		
		Set<Integer> abundantNumbers = new TreeSet<>();
		Set<Integer> sumsOfTwoAbundantNumbers = new HashSet<>();
		
		for (int i = 1; i < NonAbundantSums.upperLimit; i++) {
			if (NonAbundantSums.isAbundantNumber(i)) {
				abundantNumbers.add(i);
			}
		}
		
		for (int abundantNumber : abundantNumbers) {
			int number = abundantNumber;
			int nextNumber = 0;
			
			Iterator<Integer> iterator = abundantNumbers.iterator();
			while (iterator.hasNext()) {
				nextNumber = iterator.next();
				
				if (nextNumber == number) {
					break;
				}
			}
			
			if (number + nextNumber < NonAbundantSums.upperLimit) {
					sumsOfTwoAbundantNumbers.add(number + nextNumber);
			}
			
			while (iterator.hasNext()) {
				nextNumber = iterator.next();
				
				if (number + nextNumber < NonAbundantSums.upperLimit) {
					sumsOfTwoAbundantNumbers.add(number + nextNumber);
				}
			}
		}
		
		for (int i = 1; i < upperLimit; i++) {
			if (!NonAbundantSums.isSumOfTwoAbundantNumbers(i, sumsOfTwoAbundantNumbers)) {
				result += i;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean isAbundantNumber(int number) {
		int sum = 0;
		
		for (int i = 1; i <= number/2; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}

		return sum > number;
	}
	
	private static boolean isSumOfTwoAbundantNumbers(int number, Set<Integer> sumsOfTwoAbundantNumbers) {
		if (number < 24) {
			return false;
		}
		
		return sumsOfTwoAbundantNumbers.contains(number);
	}
}
