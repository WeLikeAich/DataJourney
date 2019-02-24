package Utilities;

import java.util.Scanner;

public class InputValidator {
	
	public static int readMenuChoice(int inputRange) {
		Scanner scan = new Scanner(System.in);
		boolean validMenuChoice = false;
		int choiceInt = -1;
		do {
			String choice = scan.next();
			if(tryParseInt(choice)) {
				choiceInt = Integer.parseInt(choice);
				validMenuChoice = validMenuChoice(choiceInt, inputRange);
			}
			if(!validMenuChoice) {
				System.out.println("Please enter a valid choice");
			}
		}while(!validMenuChoice);
		return choiceInt;
	}
	
	private static boolean tryParseInt(String choiceString) {
		try {
			Integer.parseInt(choiceString);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	protected static boolean validMenuChoice(int choice, int inputRange) {
		if (choice > 0 && choice <= inputRange)
			return true;
		else
			return false;
	}
}
