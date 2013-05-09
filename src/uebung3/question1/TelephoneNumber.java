package uebung3.question1;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class TelephoneNumber {

	// Length of the input word
	private static final int WORD_LENGTH = 7;
	// Error message for a wrong input word
	private static final String WRONG_SIZE_INPUT_ERROR = "Input word should contain only 7 alphabet characters. Try again:";
	
	// Method which checks input word for correctness
	private static boolean isCorrect(String word) {
		if (word.length() != 7)
			return false;
		for (int i = 0; i < WORD_LENGTH; i++)
			if(word.charAt(i) < 'A' || word.charAt(i) > 'Z')
				return false;
		return true;
	}

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Reading input string until it size will be equal to WORD_LENGTH
		String word = Input.readString().toUpperCase();
		while (!isCorrect(word)) {
			System.out.println(WRONG_SIZE_INPUT_ERROR);
			word = Input.readString().toUpperCase();
		}

		// In the loop checking with switch all characters and printing corresponding digit
		for (int i = 0; i < WORD_LENGTH; i++) {
			switch (word.charAt(i)) {
			case 'A': case 'B': case 'C':
				System.out.print(2);
				break;
			case 'D': case 'E': case 'F':
				System.out.print(3);
				break;
			case 'G': case 'H': case 'I':
				System.out.print(4);
				break;
			case 'J': case 'K': case 'L':
				System.out.print(5);
				break;
			case 'M': case 'N': case 'O':
				System.out.print(6);
				break;
			case 'P': case 'Q': case 'R': case 'S':
				System.out.print(7);
				break;
			case 'T': case 'U': case 'V':
				System.out.print(8);
				break;
			case 'W': case 'X': case 'Y': case 'Z':
				System.out.print(9);
				break;
			default:
				break;
			}
		}

	}

}
