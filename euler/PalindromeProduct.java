package euler;

public class PalindromeProduct {
	public static void main(String[] args) {
		PalindromeProduct palindromeProduct = new PalindromeProduct();
		
		long maximumPalindrom = 0;
		
		boolean palindromeFound = false;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				long numberToCheck = i * j;
				
				if (palindromeProduct.isPalindrome(numberToCheck)) {
					if (numberToCheck > maximumPalindrom) {
						maximumPalindrom = numberToCheck;
					}
				}
			}
			
		}
		
		System.out.println(maximumPalindrom);
	}
	
	private boolean isPalindrome(final Long number) {
		boolean isPalindrome = true;
		String numberAsString = number.toString();
		//System.out.println(numberAsString);
		
		int length = numberAsString.length();
		for (int i = 0; i < length / 2; i++) {
			if (numberAsString.charAt(i) != numberAsString.charAt(length - i - 1)) {
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
}
