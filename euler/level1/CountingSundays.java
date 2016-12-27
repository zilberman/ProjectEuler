package euler.level1;

import java.util.Map;
import java.util.HashMap;

public class CountingSundays {
	public static void main(String[] args) {
		int currentYear = 1900;
		int dayOfMonth = 1;
		int currentMonth = 1;
		
		int numberOfSundays = 0;
		
		while(currentYear < 2001) {
			for(int dayOfWeek = 1; dayOfWeek < 8; dayOfWeek++) {
				if (CountingSundays.sundayIsTheBeginningOfMonth(dayOfWeek, dayOfMonth)) {
					if (currentYear > 1900) {
						numberOfSundays++;
					}
				}
				
				if (CountingSundays.isTheEndOfYear(dayOfMonth, currentMonth)) {
					dayOfMonth = 1;
					currentMonth = 1;
					
					currentYear++;
					
					if (currentYear == 2001) {
						break;
					}
					else {
						continue;
					}
				}
				
				if (CountingSundays.isTheEndOfMonth(dayOfMonth, currentMonth, currentYear)) {
					currentMonth++;
					dayOfMonth = 1;
					
					continue;
				}
				
				dayOfMonth++;
			}
		}
		
		System.out.println("Number of sundays is: " + numberOfSundays);
	}
	
	private static boolean sundayIsTheBeginningOfMonth(final int dayOfWeek, final int dayOfMonth) {
		return dayOfWeek == 7 && dayOfMonth == 1;
	}
	
	private static boolean isTheEndOfMonth(final int dayOfMonth, final int currentMonth, final int currentYear) {
		if (dayOfMonth == 30 && (currentMonth == 11 || currentMonth == 9 || currentMonth == 4 || currentMonth == 6)) {
			return true;
		}
		
		if ((dayOfMonth == 29) && (currentMonth == 2) && CountingSundays.isLeapYear(currentYear)) {
			return true;
		}
		
		if ((dayOfMonth == 28) && (currentMonth == 2) && !CountingSundays.isLeapYear(currentYear)) {
			return true;
		}
		
		if (dayOfMonth == 31) {
			return true;
		}
		
		return false;
	}

	private static final boolean isLeapYear(final int currentYear) {
		if (currentYear % 400 == 0) {
			return true;	
		}
		
		if ((currentYear % 4 == 0) && (currentYear % 100 != 0)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isTheEndOfYear(final int dayOfMonth, final int currentMonth) {
		return dayOfMonth == 31 && currentMonth == 12;
	}
}
