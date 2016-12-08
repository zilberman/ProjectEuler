package euler;

import java.util.TreeSet;

public class SmallestMultiple {
	public static void main(String[] args) {
		Integer upperBound = Integer.parseInt(args[0]);
		int targetNumber = SmallestMultiple.findTheSmallestMultiple(upperBound);
		
		System.out.println("The target number is " + targetNumber);
		
		//System.out.println(findAllDividersForNumber(upperBound));
	}
	
	private static int findTheSmallestMultiple(final int upperBound) {
		int targetNumber = 1;
		
		if (upperBound == 1) {
			return 1;	
		}
		
		TreeSet<Integer> dividers = new TreeSet<>();
		
		for (int number = upperBound; number > 1; number--) {
			if (targetNumber % number == 0) {
				continue;
			}
			
			TreeSet<Integer> allDividersForNumber = SmallestMultiple.findAllDividersForNumber(number);
			
			if(dividers.isEmpty()) {
				targetNumber *= number;
				
				dividers.addAll(allDividersForNumber);
				continue;
			}
			
			TreeSet<Integer> dividersToAdd = difference(dividers, allDividersForNumber);
			if (dividersToAdd.size() == allDividersForNumber.size()) {
				targetNumber *= number;
				
				dividers.addAll(allDividersForNumber);
			}
			else {
				TreeSet<Integer> temp = (TreeSet)dividers.clone();
				temp.retainAll(allDividersForNumber);
				
				System.out.println("The number is " + number + ". After retain: " + temp);
				
				Integer biggestDivider = temp.last();
				
				targetNumber *= (number / biggestDivider);
				dividers.addAll(dividersToAdd);
			}
		}
		
		System.out.println(dividers);
		
		return targetNumber;
	}
	
	private static TreeSet<Integer> findAllDividersForNumber(int number) {
		TreeSet<Integer> allDividersForNumber = new TreeSet<>();
		
		for (int i = 2; i < number / 2 + 1; i++) {
			if (number % i == 0) {
				allDividersForNumber.add(new Integer(i));	
			}
		}
		
		allDividersForNumber.add(new Integer(number));
		
		return allDividersForNumber;	
	}
	
	private static TreeSet<Integer> difference(TreeSet<Integer> a, TreeSet<Integer> b) {
		TreeSet difference = (TreeSet)b.clone();
		difference.removeAll(a);
		
		return difference;
	}
}
