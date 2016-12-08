package euler.level1;

public class HighlyDivisibleTriangularNumber {
	public static void main(String[] args) {
		long currentNumber = 0;
		long index = 1;
		
		for(;;) {
			currentNumber += index;
			
			if(HighlyDivisibleTriangularNumber.obtainNumberOfFactors(currentNumber) > 1000) {
				System.out.println("Target number is: " + currentNumber);
				
				break;
			}
			
			index++;
		}
	}
	
	private static int obtainNumberOfFactors(long triangleNumber) {
		int numberOfFactors = 0;
		
		long bound = (long)Math.sqrt(triangleNumber);
		
		for(long i = 1; i < bound + 1; i++) {
			if(triangleNumber % i == 0) {
				numberOfFactors++;	
			}
		}
		
		return 2 * numberOfFactors;
	}
}
