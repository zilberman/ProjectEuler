package euler.level1;

import java.util.Map;
import java.util.HashMap;

public class NumberLetterCounts {
	private static Map<Integer, String> oneDigitNumbers = new HashMap<>();
	private static Map<Integer, String> twoDigitNumbers = new HashMap<>();
	
	private static Map<Integer, String> oneHundred = new HashMap<>();
	private static Map<Integer, String> oneThousand = new HashMap<>();
	
	static {
		oneDigitNumbers.put(1, "one");
		oneDigitNumbers.put(2, "two");
		oneDigitNumbers.put(3, "three");
		oneDigitNumbers.put(4, "four");
		oneDigitNumbers.put(5, "five");
		oneDigitNumbers.put(6, "six");
		oneDigitNumbers.put(7, "seven");
		oneDigitNumbers.put(8, "eight");
		oneDigitNumbers.put(9, "nine");
		
		twoDigitNumbers.put(10, "ten");
		twoDigitNumbers.put(11, "eleven");
		twoDigitNumbers.put(12, "twelve");
		twoDigitNumbers.put(13, "thirteen");
		twoDigitNumbers.put(14, "fourteen");
		twoDigitNumbers.put(15, "fifteen");
		twoDigitNumbers.put(16, "fifteen");
		twoDigitNumbers.put(17, "seventeen");
		twoDigitNumbers.put(18, "eighteen");
		twoDigitNumbers.put(19, "nineteen");
		twoDigitNumbers.put(20, "twenty");
		twoDigitNumbers.put(30, "thirty");
		twoDigitNumbers.put(40, "forty");
		twoDigitNumbers.put(50, "fifty");
		twoDigitNumbers.put(60, "sixty");
		twoDigitNumbers.put(70, "seventy");
		twoDigitNumbers.put(80, "eighty");
		twoDigitNumbers.put(90, "ninety");
		
		oneHundred.put(100, "one hundred");		
		oneThousand.put(1000, "one thousand");
	}
	
	public static void main(String[] args) {
		int numberOfLetters = 0;
		
		String numberAsString = null;
		for (int i = 1; i < 1001; i++) {
			numberAsString = NumberLetterCounts.converNumberToString(i);
			
			numberOfLetters += NumberLetterCounts.calculateLengthOfString(numberAsString);
		}
		
		System.out.println(numberOfLetters);
	}
	
	private static int calculateLengthOfString(final String numberAsString) {
		return numberAsString.replaceAll(" ", "").length();
	}
	
	private static String converNumberToString(final int number) {
		if (number < 10) {
			return NumberLetterCounts.convertOneDigitNumberToString(number);
		}
		
		if (number < 100) {
			return NumberLetterCounts.convertTwoDigitNumberToString(number);
		}
		
		if (number < 1000) {
			return NumberLetterCounts.convertThreeDigitNumberToString(number);
		}
		
		return NumberLetterCounts.convertOneThousandToString(number);
	}
	
	private static String convertOneDigitNumberToString(final int oneDigitNumber) {
		return NumberLetterCounts.oneDigitNumbers.get(oneDigitNumber);
	}
	
	private static String convertTwoDigitNumberToString(final int twoDigitNumber) {
		int remainder = twoDigitNumber % 10;
		if ((remainder == 0)  || (twoDigitNumber < 20)) {
			return NumberLetterCounts.twoDigitNumbers.get(twoDigitNumber);
		}
		
		StringBuilder result = new StringBuilder();
		
		result.append(NumberLetterCounts.convertTwoDigitNumberToString(twoDigitNumber - remainder));
		result.append(" ");
		result.append(NumberLetterCounts.convertOneDigitNumberToString(remainder));
		
		return  result.toString();
	}
	
	private static String convertThreeDigitNumberToString(final int threeDigitNumber) {
		int remainder = threeDigitNumber % 100;
		int numberOfHundreds = threeDigitNumber / 100;
		
		StringBuilder result = new StringBuilder();
		
		result.append(NumberLetterCounts.convertOneDigitNumberToString(numberOfHundreds));
		result.append(" hundred");
		
		if (remainder > 0) {
			result.append(" and ");
			
			result.append(NumberLetterCounts.convertTwoDigitNumberToString(remainder));
		}
		
		return  result.toString();
	}
	
	private static String convertOneThousandToString(final int oneThousand) {
		return "one thousand";	
	}
}
