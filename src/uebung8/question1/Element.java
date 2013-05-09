package uebung8.question1;

/** The class Element contains two features: a word and a frequency counter of
 * the word.
 * 
 * @author Andrii Dzhyrma */
public class Element {

	// Private Members ///////////////////////////////////////////////////////////

	// Fields --------------------------------------------------------------------
	private String word;
	private int frequency = 1;

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** Initializes the element with a word.
	 * 
	 * @param word - the word */
	public Element(String word) {
		this.word = word;
	}

	// Methods -------------------------------------------------------------------
	/** Returns the frequency of the current word.
	 * 
	 * @return - the current frequency */
	public int getFrequency() {
		return this.frequency;
	}

	/** Increases the frequency of the word by one. */
	public void increaseFrequency() {
		this.frequency++;
	}

	/** Returns the word from the current element
	 * 
	 * @return - the word */
	public String getWord() {
		return this.word;
	}
}
