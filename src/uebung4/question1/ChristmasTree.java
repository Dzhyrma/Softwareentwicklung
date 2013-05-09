package uebung4.question1;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class ChristmasTree {

	// Bounds for input height
	private static final int MIN = 2;
	private static final int MAX = 15;
	// Constant string with description of the program
	private static final String PROGRAM_DESCRIPTION_STRING = "Christmas Tree Printing Service\n-------------------------------\n";
	// Constant request string for height
	private static final String HEIGHT_REQUEST_FORMAT_STRING = "Height of Base Pyramid: ";
	// Constant error format string
	private static final String OUT_OF_BOUNDS_ERROR_FORMAT_STRING = "Height of Base should be in range [%d, %d]. Please try again: ";

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Printing out the description
		System.out.println(PROGRAM_DESCRIPTION_STRING);
		
		// Requesting the height of Base Pyramid
		System.out.print(HEIGHT_REQUEST_FORMAT_STRING);
		int height = Input.readInt();
		while (height < MIN || height > MAX) {
			System.out.printf(OUT_OF_BOUNDS_ERROR_FORMAT_STRING, MIN, MAX);
			height = Input.readInt();
		}
		System.out.println();

		// Calculation of the offset and power of 2 array initialization
		int offset = String.valueOf((int) Math.pow(2, height)).length() + 1;
		int[] powerOf2 = new int[height];
		powerOf2[0] = 2;

		for (int i = 2; i <= height; i++) {
			// Store calculated numbers into the array
			powerOf2[i - 1] = (int) Math.pow(2, i);
			// Print out rows of the tree
			for (int j = 0; j < i; j++) {
				System.out.printf("%" + (height - j) * offset + "d", 2);
				for (int k = 1; k <= j; k++)
					System.out.printf("%" + offset + "d", powerOf2[k]);
				for (int k = j - 1; k >= 0; k--)
					System.out.printf("%" + offset + "d", powerOf2[k]);
				System.out.println();
			}
		}
	}
}
