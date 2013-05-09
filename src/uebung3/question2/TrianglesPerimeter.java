package uebung3.question2;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class TrianglesPerimeter {

	// Left range of input coordinate
	private static final int MINIMUM_COORDINATE = 1;
	// Right range of input coordinate 
	private static final int MAXIMUM_COORDINATE = 40;
	// Constant array with the names of coordinate axis
	private static final char[] COORDINATE_NAMES = { 'x', 'y' };
	// Constant string with description of the program
	private static final String PROGRAM_DESCRIPTION_STRING = "This program calculates the perimeter of a Triangle.";
	// Constant requesting for coordinate string
	private static final String COORDINATE_REQUEST_FORMAT_STRING = "Please enter the %c-coordinate of point%d: ";
	// Error message for input coordinate being out of range
	private static final String INVALID_COORDINATE_RANGE_ERROR_STRING = "Coordinate should be in range [%d, %d]!%n";
	// Result format string
	private static final String OUTPUT_FORMAT_STRING = "The perimeter of a Triangle with point1 (%d, %d), point2 (%d, %d) and point3 (%d, %d)%nis %f%n%nWould you like to repeat the program? (Enter 1 for yes): ";
	// Command for repeating the program
	private static final String REPEAT_STRING = "1";

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Printing out the description
		System.out.println(PROGRAM_DESCRIPTION_STRING);
		
		// Do-While loop with checking command to be equal REPEAT_STRING constant
		do {
			// Extra line break
			System.out.println();
			// Initializing array with 3 point and 2 coordinates for each
			int[][] coordinates = new int[3][2];
			// Using For loop to read all the coordinates
			for (int i = 0; i < coordinates.length; i++)
				for (int j = 0; j < coordinates[i].length; j++) {
					System.out.printf(COORDINATE_REQUEST_FORMAT_STRING, COORDINATE_NAMES[j], i + 1);
					coordinates[i][j] = Input.readInt();
					// While coordinate is out of range, asking to input it again
					while (coordinates[i][j] < MINIMUM_COORDINATE || coordinates[i][j] > MAXIMUM_COORDINATE) {
						System.out.printf(INVALID_COORDINATE_RANGE_ERROR_STRING, MINIMUM_COORDINATE, MAXIMUM_COORDINATE);
						System.out.printf(COORDINATE_REQUEST_FORMAT_STRING, COORDINATE_NAMES[j], i + 1);
						coordinates[i][j] = Input.readInt();
					}
				}
			
			// Calculating the perimeter of our triangle
			double perimeter = Math.sqrt(Math.pow(coordinates[0][0] - coordinates[1][0], 2) + Math.pow(coordinates[0][1] - coordinates[1][1], 2))
					+ Math.sqrt(Math.pow(coordinates[1][0] - coordinates[2][0], 2) + Math.pow(coordinates[1][1] - coordinates[2][1], 2))
					+ Math.sqrt(Math.pow(coordinates[2][0] - coordinates[0][0], 2) + Math.pow(coordinates[2][1] - coordinates[0][1], 2));
			
			// Printing out the result
			System.out.printf(OUTPUT_FORMAT_STRING, coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1], coordinates[2][0],
					coordinates[2][1], perimeter);
		} while (Input.readString().equals(REPEAT_STRING));
	}

}
