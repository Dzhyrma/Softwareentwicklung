package uebung8.question1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/** The class Document accepts an input file in the constructor and handle the
 * processing of the corresponding text file.
 * 
 * @author Andrii Dzhyrma */
public class Document {

	// Private Members ///////////////////////////////////////////////////////////

	// Fields --------------------------------------------------------------------
	private Vector<Element> elements;
	private String fileName;

	// Methods -------------------------------------------------------------------
	/* Adds the word to the elements vector using a binary search algorithm. */
	private void binarySearchInsertion(String word) {
		if (elements.size() == 0) {
			this.elements.add(new Element(word));
			return;
		}

		int left = 0;
		int right = this.elements.size();
		while (left < right) {
			int index = (left + right) / 2;
			int comparsion = (this.elements.get(index).getWord()
			    .compareToIgnoreCase(word));
			if (comparsion == 0) {
				this.elements.get(index).increaseFrequency();
				return;
			} else if (comparsion > 0)
				right = index;
			else
				left = index + 1;
		}

		this.elements.add(left, new Element(word));
	}

	/* Sorts the elements using binary tree search algorithm. */
	private void ascendingBinaryTreeSort() {
		if (this.elements == null)
			return;
		for (int i = 1; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			int left = 0;
			int right = i;
			while (left < right) {
				int index = (left + right) / 2;
				int frequency1 = this.elements.get(index).getFrequency();
				int frequency2 = element.getFrequency();
				if (frequency1 == frequency2)
					left = right = index;
				else if (frequency1 > frequency2)
					right = index;
				else
					left = index + 1;
			}
			if (i != left) {
				this.elements.remove(i);
				this.elements.add(left, element);
			}
		}
	}

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** Initializes a Document object for the selected file.
	 * 
	 * @param fileName - the file path */
	public Document(String fileName) {
		this.fileName = fileName;
	}

	// Methods -------------------------------------------------------------------
	/** Analyzes the current file. */
	public void analyzeFile() {
		FileReader fileReader = null;
		try {
			// Open file and read contents
			fileReader = new FileReader(fileName);
			Scanner scanner = new Scanner(fileReader);
			this.elements = new Vector<Element>();
			while (scanner.hasNext())
				binarySearchInsertion(scanner.next());
			scanner.close();
			fileReader.close();
			ascendingBinaryTreeSort();
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} catch (IOException e) {
			System.err.println("File not closed.");
		}
	}

	/** Returns unique words sorted by an alphabet.
	 * 
	 * @return - the array of words if the list of elements is not equal to null.
	 *         Otherwise null */
	public String[] getWords() {
		if (this.elements == null)
			return null;
		String[] result = new String[this.elements.size()];
		for (int i = 0; i < this.elements.size(); i++)
			result[i] = this.elements.get(i).getWord();
		return result;
	}

	/** Returns unique words sorted by a frequency.
	 * 
	 * @param isAscending - the order.
	 * @return - the array of words if the list of elements is not equal to null.
	 *         Otherwise null */
	public String[] getWordList(boolean isAscending) {
		if (this.elements == null)
			return null;
		int size = this.elements.size();
		String[] result = new String[size];
		for (int i = 0; i < size; i++)
			result[isAscending ? i : (size - 1 - i)] = this.elements.get(i).getWord();
		return result;
	}

	/** Returns the sorted array of frequencies.
	 * 
	 * @param isAscending - the order.
	 * @return - the array of frequencies if the list of elements is not equal to
	 *         null. Otherwise null */
	public int[] getFrequencyList(boolean isAscending) {
		if (this.elements == null)
			return null;
		int size = this.elements.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++)
			result[isAscending ? i : (size - 1 - i)] = this.elements.get(i)
			    .getFrequency();
		return result;
	}

	/** Sets the file name to be processed
	 * 
	 * @param fileName - the file name */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
