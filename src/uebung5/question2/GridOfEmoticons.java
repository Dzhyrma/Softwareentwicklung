package uebung5.question2;

import io.Input;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Andrii Dzhyrma
 */
public class GridOfEmoticons {

	// All the important constants
	static final char[][] EMOTICONS = { { 'n', '_', 'n' }, { '$', 'v', '$' },
			{ '8', '(', '>', '_', '<', ')', '8' },
			{ 'W', '(', '^', 'o', '^', ')', 'W' }, { '(', '=', '_', '=', ')' },
			{ '(', '/', '_', '\\', ')' }, { '>', '^', '.', '.', '^', '<' },
			{ '(', '~', '-', '^', ')' }, { '(', '*', '-', '*', ')' },
			{ '<', '*', ')', ')', ')', '-', '{' } };
	static final int NUMBER_OF_MAX_ITERATIONS = 100000;
	static final int NUMBER_OF_CHOSEN_EMOTICONS = 5;
	static final String GRID_DESCRIPTION_STRING = "This is the generated grid:";
	static final String NUMBER_OF_EMOTICON_OUT_OF_RANGE_ERROR_STRING = "Chosen emoticon does not exist. Chose one from the list above:";
	static final String PLACE_EMOTICONS_ERROR_STRING = "Not all emoticons could be placed!";
	static final String SELECT_EMOTICONS_DESCRIPTION_STRING_FORMAT = "Please select %d emoticons from the following list:%n";
	static final String SELECT_EMOTICONS_STRING_FORMAT = "Select emoticon # %d%n";
	static final String NUMERATION_STRING_FORMAT = "%d: ";

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Initialize the variables
		Random rand = new Random();
		char[][] jaggedWorkingArray = new char[10][];
		char[][] jaggedResultArray = new char[10][];
		int[] chosenEmoticons = new int[NUMBER_OF_CHOSEN_EMOTICONS];
		// Initialize the jagged array grid
		for (int i = 0; i < jaggedWorkingArray.length; i++)
			jaggedWorkingArray[i] = new char[rand.nextInt(9) + 2];

		// Print out all the emoticons
		System.out.printf(SELECT_EMOTICONS_DESCRIPTION_STRING_FORMAT,
				NUMBER_OF_CHOSEN_EMOTICONS);
		for (int i = 0; i < EMOTICONS.length; i++) {
			System.out.printf(NUMERATION_STRING_FORMAT, i + 1);
			for (int j = 0; j < EMOTICONS[i].length; j++)
				System.out.print(EMOTICONS[i][j]);
			System.out.println();
		}

		// Read 5 emoticons chosen by user
		for (int i = 0; i < NUMBER_OF_CHOSEN_EMOTICONS; i++) {
			System.out.printf(SELECT_EMOTICONS_STRING_FORMAT, i + 1);
			chosenEmoticons[i] = Input.readInt() - 1;
			while (chosenEmoticons[i] < 0
					|| chosenEmoticons[i] >= EMOTICONS.length) {
				System.out
						.println(NUMBER_OF_EMOTICON_OUT_OF_RANGE_ERROR_STRING);
				chosenEmoticons[i] = Input.readInt() - 1;
			}
		}
		System.out.println();

		// Initialize 'fail' variable to know are all emoticons placed in the
		// grid
		boolean fail = true;
		// Initialize 'maxPlacedEmoticons' variable to save better result at the
		// end
		int maxPlacedEmoticons = 0;
		// This loop is for trying to put emoticons randomly to the grid
		for (int i = 0; fail && i < NUMBER_OF_MAX_ITERATIONS; i++) {
			// Assume that this time we will put emoticons correctly
			fail = false;
			// Fill the grid array with dashes
			for (int j = 0; j < jaggedWorkingArray.length; j++)
				Arrays.fill(jaggedWorkingArray[j], '-');

			int j;
			// For each chosen emoticon try to find random position
			for (j = 0; !fail && j < NUMBER_OF_CHOSEN_EMOTICONS; j++) {
				// Calculate possible places for emoticon corresponding to the
				// size of each row in the grid
				int possibleCoordinates = 0;
				for (int k = 0; k < jaggedWorkingArray.length; k++) {
					if (EMOTICONS[chosenEmoticons[j]].length <= jaggedWorkingArray[k].length)
						possibleCoordinates += jaggedWorkingArray[k].length
								- EMOTICONS[chosenEmoticons[j]].length + 1;
				}
				// If we did not find any place for emoticon, we should start
				// again
				if (possibleCoordinates == 0)
					fail = true;
				else {
					// Get random available position for the emoticon
					int column = rand.nextInt(possibleCoordinates);
					int row = 0;
					// Calculation of the row and column where should we put
					// first symbol of the emoticon
					for (row = 0; column > jaggedWorkingArray[row].length
							- EMOTICONS[chosenEmoticons[j]].length
							&& row < jaggedWorkingArray.length; row++)
						if (EMOTICONS[chosenEmoticons[j]].length <= jaggedWorkingArray[row].length)
							column -= jaggedWorkingArray[row].length
									- EMOTICONS[chosenEmoticons[j]].length + 1;
					// Check if there is already another emoticon written
					for (int k = 0; !fail
							&& k < EMOTICONS[chosenEmoticons[j]].length; k++)
						if (jaggedWorkingArray[row][column + k] != '-')
							fail = true;
					// Write current emoticon to the grid
					for (int k = 0; !fail
							&& k < EMOTICONS[chosenEmoticons[j]].length; k++)
						jaggedWorkingArray[row][column + k] = EMOTICONS[chosenEmoticons[j]][k];
				}
			}

			// If the result is better then previous, copying jaggedWorkingArray
			// to the jaggedResultArray
			if (j > maxPlacedEmoticons || !fail) {
				maxPlacedEmoticons = j;
				for (int k = 0; k < jaggedWorkingArray.length; k++)
					jaggedResultArray[k] = Arrays.copyOf(jaggedWorkingArray[k],
							jaggedWorkingArray[k].length);
			}
		}

		// Print out the result grid
		System.out.println(GRID_DESCRIPTION_STRING);
		for (int i = 0; i < jaggedResultArray.length; i++) {
			for (int j = 0; j < jaggedResultArray[i].length; j++)
				System.out.print(jaggedResultArray[i][j]);
			System.out.println();
		}
		System.out.println();

		// Print out an error if not all the emoticons were displayed
		if (fail)
			System.out.println(PLACE_EMOTICONS_ERROR_STRING);
	}
}
