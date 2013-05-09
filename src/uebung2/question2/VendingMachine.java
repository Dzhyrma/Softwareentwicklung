package uebung2.question2;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class VendingMachine {

	/**
	 * Constant string that represents separating symbol between options
	 */
	private static final String SEPARATOR = ", ";
	/**
	 * Constant empty string
	 */
	private static final String EMPTY_STRING = "";
	/**
	 * Constant char for the first item symbol in UPPERCASE
	 */
	private static final char A = 'A';
	/**
	 * Constant difference between upper case and lower case
	 */
	private static final int CASE_DIFFERENCE = 'A' - 'a';
	/**
	 * Constant amount of cents in 1 ˆ
	 */
	private static final int CENTS_IN_EURO = 100;
	/**
	 * Constant float value that defines epsilon for float comparison
	 */
	private static final float EPSILON = 0.005f;

	/**
	 * Constant array with the names of items in the vending machine
	 */
	private static final String[] ITEMS = { "MARS", "TWIX", "M & M's", "CHIPS", "MINTS" };
	/**
	 * Constant array with the prices of items in the vending machine
	 */
	private static final float[] PRICES = { .9f, .9f, .9f, 1.2f, .6f };
	/**
	 * Constant array with the equity of coins in the vending machine
	 */
	private static final int[] COINS = { 200, 100, 50, 20, 10 };

	/**
	 * Initialization error string
	 */
	private static final String INITIALIZATION_ERROR = "Amount of the items in vending machine is not the same as amount of their prices. Call administrator for a help!";
	/**
	 * Request constant format string for selecting an item
	 */
	private static final String REQUEST_SELECT_ITEM_FORMAT_STRING = "Please select an item (%s):%n";
	/**
	 * Request constant format string for the amount of money left, if first
	 * input money was not enough
	 */
	private static final String REQUEST_LEFT_AMOUNT_FORMAT_STRING = "Input:%.2f%nEnter another: %.2f%n";
	/**
	 * Output format string for the amount of money left
	 */
	private static final String REQUEST_AMOUNT_FORMAT_STRING = "Amount due: %.2fˆ%n";
	/**
	 * Output format string for the result (first part)
	 */
	private static final String RESULT1_FORMAT_STRING = "Total Change due: %.2fˆ%nChange: ";
	/**
	 * Output format string for the result (last part)
	 */
	private static final String RESULT2_FORMAT_STRING = "%nOutput: %s%n";
	/**
	 * Output format string for the amount of coins in change
	 */
	private static final String CHANGE_FORMAT_STRING = "%d ";
	/**
	 * Output format string for the ˆ value
	 */
	private static final String EURO_FORMAT_STRING = "%dˆ";
	/**
	 * Output format string for the cents value
	 */
	private static final String CENT_FORMAT_STRING = "%dc";

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Initialization checking
		if (ITEMS.length != PRICES.length) {
			System.out.println(INITIALIZATION_ERROR);
			return;
		}

		// Making string for possible options
		String options = EMPTY_STRING;
		for (char symbol = A; symbol - A < ITEMS.length; symbol++)
			options += ((symbol == A) ? EMPTY_STRING : SEPARATOR) + symbol;

		// Reading input char for an item while it will be in the range from 'a'
		// to 'e' or from 'A' to 'E'
		char itemChar;
		do {
			System.out.printf(REQUEST_SELECT_ITEM_FORMAT_STRING, options);
			itemChar = Input.readChar();
		} while (((itemChar - A < 0) || (itemChar - A > ITEMS.length))
				&& ((itemChar - A + CASE_DIFFERENCE < 0) || (itemChar - A + CASE_DIFFERENCE > ITEMS.length)));
		// Getting normal integer index for the item
		int itemIndex = ((itemChar - A < 0) || (itemChar - A > ITEMS.length)) ? itemChar - A + CASE_DIFFERENCE : itemChar - A;
		// Printing price for that item
		float moneyLeft = PRICES[itemIndex];
		System.out.printf(REQUEST_AMOUNT_FORMAT_STRING, moneyLeft);

		// Reading input amount of money. No checking for input with minus
		// because of the requirements
		float input = Input.readFloat();
		moneyLeft -= input;
		// Continue asking for more money, until it will be enough
		while (moneyLeft > EPSILON) {
			System.out.printf(REQUEST_LEFT_AMOUNT_FORMAT_STRING, input, moneyLeft);
			input = Input.readFloat();
			moneyLeft -= input;
		}

		// Printing the result and calculating the change
		System.out.printf(RESULT1_FORMAT_STRING, Math.abs(moneyLeft));
		int change = Math.abs(Math.round(moneyLeft * 100));
		int[] changeCoinsCounter = new int[COINS.length];
		for (int i = 0; i < COINS.length; i++) {
			changeCoinsCounter[i] = change / COINS[i];
			change %= COINS[i];
			System.out.printf(CHANGE_FORMAT_STRING, changeCoinsCounter[i]);
			if (COINS[i] >= CENTS_IN_EURO)
				System.out.printf(EURO_FORMAT_STRING, COINS[i] / CENTS_IN_EURO);
			if (COINS[i] % CENTS_IN_EURO > 0)
				System.out.printf(CENT_FORMAT_STRING, COINS[i] % CENTS_IN_EURO);
			if (i < COINS.length - 1)
				System.out.print(SEPARATOR);
		}
		System.out.printf(RESULT2_FORMAT_STRING, ITEMS[itemIndex]);
	}
}
