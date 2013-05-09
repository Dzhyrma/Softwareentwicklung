package uebung4.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrii Dzhyrma
 */
public class MiniCalc {

	// Constant string with description of the program
	private static final String PROGRAM_DESCRIPTION_STRING = "MiniCalc\n========\n";
	// Error message for incorrect integer input
	private static final String NUMBER_FORMAT_ERROR_STRING = "Incorrect integer input";
	// Error message for incorrect operator input
	private static final String OPERATOR_EXISING_ERROR_STRING = "Only +, -, x operators are allowed";
	// Error message for incorrect equation format
	private static final String WRONG_EQUATION_FORMAT_ERROR_STRING = "Incorrect equation format";

	/**
	 * Print out equation in given by assignment format
	 * 
	 * @param equation
	 *            - equation to print
	 */
	private static void printEquation(List<String> equation) {
		for (String string : equation) {
			System.out.print(' ');
			System.out.print(string);
		}
		System.out.println();
	}

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Printing out the description
		System.out.println(PROGRAM_DESCRIPTION_STRING);

		// Checking for valid numbers
		try {
			for (int i = 0; i < args.length; i += 2)
				Integer.parseInt(args[i]);
		} catch (NumberFormatException e) {
			System.out.println(NUMBER_FORMAT_ERROR_STRING);
			System.out.println(e.getMessage());
			return;
		}

		// Checking for valid operators
		for (int i = 1; i < args.length; i += 2)
			if (args[i].length() != 1 || (args[i].charAt(0) != 'x' && args[i].charAt(0) != '+' && args[i].charAt(0) != '-')) {
				System.out.println(OPERATOR_EXISING_ERROR_STRING);
				return;
			}

		// Checking for valid equation (can't be a situation with operator only
		// at the end)
		if (args.length % 2 == 0) {
			System.out.println(WRONG_EQUATION_FORMAT_ERROR_STRING);
			return;
		}

		// Making a list with all numbers and operators
		List<String> argsList = new ArrayList<String>(Arrays.asList(args));
		// Printing out all the equation
		printEquation(argsList);

		// While there is more then one element, means there are still some
		// operators inside
		while (argsList.size() > 1) {
			// Finding positions of the operators in equation 
			int plusPos = argsList.size();
			int minusPos = argsList.size();
			int signPos;
			for (signPos = 1; signPos < argsList.size() && argsList.get(signPos).charAt(0) != 'x'; signPos += 2)
				if (signPos < plusPos && argsList.get(signPos).charAt(0) == '+')
					plusPos = signPos;
				else if (signPos < minusPos && argsList.get(signPos).charAt(0) == '-')
					minusPos = signPos;
			// Choosing more important operator
			if (signPos >= argsList.size())
				signPos = (minusPos == argsList.size()) ? plusPos : minusPos;
			
			// Calculating result of chosen sign operator and neighbor numbers
			String result;
			switch (argsList.get(signPos).charAt(0)) {
			case 'x':
				result = String.valueOf(Integer.parseInt(argsList.get(signPos - 1)) * Integer.parseInt(argsList.get(signPos + 1)));
				break;
			case '+':
				result = String.valueOf(Integer.parseInt(argsList.get(signPos - 1)) + Integer.parseInt(argsList.get(signPos + 1)));
				break;
			case '-':
				result = String.valueOf(Integer.parseInt(argsList.get(signPos - 1)) - Integer.parseInt(argsList.get(signPos + 1)));
				break;
			default:
				result = "";
				break;
			}
			
			//Replacing previous number with the new one
			argsList.set(signPos - 1, result);
			// Deleting calculated sign and number after it
			argsList.remove(signPos);
			argsList.remove(signPos);
			
			// Printing out new equation
			printEquation(argsList);
		}
	}
}
