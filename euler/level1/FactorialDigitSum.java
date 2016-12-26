package euler.level1;

import java.math.BigInteger;

public class FactorialDigitSum {
	public static void main(String[] args) {
		BigInteger result = BigInteger.valueOf(1);
		
		for (int i = 1; i < 101; i++) {
			if (i % 10 == 0) {
				result = result.multiply(BigInteger.valueOf(i / 10));
			}
			else {
				result = result.multiply(BigInteger.valueOf(i));
			}
			
			if (result.remainder(BigInteger.TEN).equals(BigInteger.ZERO)) {
				result = result.divide(BigInteger.TEN);
			}
		}
		
		System.out.println("The result is: " + FactorialDigitSum.calculateSumOfDigits(result));
	}
	
	private static int calculateSumOfDigits(BigInteger number) {
		int sum = 0;
		
		while(number.compareTo(BigInteger.ZERO) > 0) {
			sum += number.remainder(BigInteger.TEN).intValue();
			
			number = number.divide(BigInteger.TEN);
		}
		
		return sum;
	}
}
