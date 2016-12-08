package euler;

public class PrimeNumbersGenerator {
	public static void main(String[] args) {
		int numberOfPrimes = Integer.parseInt(args[0]);
		
		long targetNumber = 1;
		
		int primeNumberIndex = 0;
		
		for (;;) {
			if (primeNumberIndex == numberOfPrimes) {
				break;	
			}
			
			targetNumber++;
			
			if (PrimeNumbersGenerator.isPrime(targetNumber)) {
				primeNumberIndex++;
			}
			
		}
		
		System.out.println(targetNumber);
	}
	
	private static boolean isPrime(final long number) {
		long bound = (long)Math.sqrt(number);
		
		for (long i = 2; i < bound + 1; i++) {
			if (number % i == 0) {
				return false;	
			}
		}
		
		return true;
	}
}
