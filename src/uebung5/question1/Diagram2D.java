package uebung5.question1;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class Diagram2D {

	// All the important constants
	private static final int MAX_X = 20;
	private static final int MAX_Y = 15;
	private static final int GRID_STEP = 5;
	private static final int LEFT_MARGIN = 2;
	private static final char POINT_CHAR = '*';

	// Constant string with description of the program
	private static final String PROGRAM_DESCRIPTION_STRING = "This program will place a point on a plot.";
	// Constant requesting for coordinate string
	private static final String COORDINATE_REQUEST_FORMAT_STRING = "Enter the %c-coordinate:%n";
	// Error message for input coordinate being out of range
	private static final String INVALID_COORDINATE_RANGE_ERROR_STRING = "Coordinate should be in range [%d, %d]!%n";
	// Coordinate value format string
	private static final String COORDINATE_VALUE_FORMAT_STRING = "%%%dd";
	// Pseudo drawing format string
	private static final String DRAWING_FORMAT_STRING = "%%%dc";

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Print out the description of the program
		System.out.println(PROGRAM_DESCRIPTION_STRING);

		// Read coordinates x and y
		int x, y;
		System.out.printf(COORDINATE_REQUEST_FORMAT_STRING, 'x');
		x = Input.readInt();
		while (x < 0 || x > MAX_X) {
			System.out.printf(INVALID_COORDINATE_RANGE_ERROR_STRING, 0, MAX_X);
			System.out.printf(COORDINATE_REQUEST_FORMAT_STRING, 'x');
			x = Input.readInt();
		}
		System.out.printf(COORDINATE_REQUEST_FORMAT_STRING, 'y');
		y = Input.readInt();
		while (y < 0 || y > MAX_Y) {
			System.out.printf(INVALID_COORDINATE_RANGE_ERROR_STRING, 0, MAX_Y);
			System.out.printf(COORDINATE_REQUEST_FORMAT_STRING, 'y');
			y = Input.readInt();
		}

		// Print out the Y-axis
		System.out.println();
		System.out.printf(String.format(DRAWING_FORMAT_STRING, LEFT_MARGIN + 1), '^');
		System.out.println();
		for (int i = MAX_Y; i > 0; i--) {
			// Print out Y numbers for the grid
			if (i % GRID_STEP == 0)
				System.out.printf(String.format(COORDINATE_VALUE_FORMAT_STRING, LEFT_MARGIN), i);
			else
				System.out.printf(String.format(DRAWING_FORMAT_STRING, LEFT_MARGIN), ' ');
			// If our point is on axis, print out star symbol on it
			if (y == i && x == 0)
				System.out.println(POINT_CHAR);
			// In other case just draw an axis and point if it's y coordinate
			// equal to i
			else {
				if (i % GRID_STEP == 0)
					System.out.print('+');
				else
					System.out.print('|');
				if (y == i)
					System.out.printf(String.format(DRAWING_FORMAT_STRING, x), POINT_CHAR);
				System.out.println();
			}
		}
		// Print out the X-axis
		System.out.printf(String.format(DRAWING_FORMAT_STRING, LEFT_MARGIN), ' ');
		for (int i = 0; i <= MAX_X; i++) {
			// If our point is on axis X, print out start symbol on it
			if (y == 0 && x == i)
				System.out.print(POINT_CHAR);
			else if (i % GRID_STEP == 0)
				System.out.print('+');
			else
				System.out.print('-');
		}
		System.out.println('>');
		// Print out X numbers for the grid
		System.out.printf(String.format(DRAWING_FORMAT_STRING, LEFT_MARGIN), ' ');
		for (int i = 0; i <= MAX_X; i += GRID_STEP)
			System.out.printf(String.format(COORDINATE_VALUE_FORMAT_STRING, -GRID_STEP), i);
	}
}
