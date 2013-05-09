package uebung7.question1;

import java.util.Arrays;

/** The class MyOwnString represents a small copy of the already created class
 * String and implements some methods
 * 
 * @author Andrii Dzhyrma */
public class MyOwnString {

	// Static Members ------------------------------------------------------------

	/** Adds the string s2 to the end of s1 and returns the result as MyOwnString
	 * 
	 * @param s1 - the MyOwnString to work with
	 * @param s2 - the MyOwnString to be concatenated
	 * @return a result of concatenation */
	public static MyOwnString concat(MyOwnString s1, MyOwnString s2) {
		MyOwnString result = new MyOwnString(s1);
		result.concat(s2);
		return result;
	}

	// Fields --------------------------------------------------------------------

	private char[] data;
	private int length;

	// Private Methods -----------------------------------------------------------

	/* Creates an empty string */
	private void createEmptyString() {
		data = null;
		length = 0;
	}

	// Constructors --------------------------------------------------------------

	/** This constructor creates an empty string */
	public MyOwnString() {
		createEmptyString();
	}

	/** This constructor copies the content of rawData and sets the length
	 * depending on the number of characters in the existing array */
	public MyOwnString(char[] rawData) {
		if (rawData == null || rawData.length == 0) {
			createEmptyString();
			return;
		}
		// copy an input data using Arrays class2
		data = Arrays.copyOf(rawData, rawData.length);
		length = data.length;
	}

	/** This constructor creates a new string initialized with the content of
	 * MyOwnString s */
	public MyOwnString(MyOwnString s) {
		if (s == null || s.length == 0 || s.data == null) {
			createEmptyString();
			return;
		}
		data = Arrays.copyOf(s.data, s.data.length);
		length = s.length;
	}

	/** This constructor initializes the instance with characters of the string s */
	public MyOwnString(String s) {
		if (s == null || s.length() == 0) {
			createEmptyString();
			return;
		}
		data = s.toCharArray();
		length = data.length;
	}

	// Public Methods ------------------------------------------------------------

	/** Compares the string to s lexicographically and returns a negative integer
	 * if this string object lexicographically precedes the argument s, a positive
	 * integer if this string object lexicographically follows the argument s, and
	 * zero if the two given strings are equal <br>
	 * <b>Note: thereby only letter character A-Z and a-z shall be considered for
	 * the comparison; any other character will be ignored</b>
	 * 
	 * @param s - the MyOwnString to compare with
	 * @return <b>-1</b> - if this string object lexicographically precedes the
	 *         argument s<br>
	 *         <b>0</b> - if the two given strings are equal<br>
	 *         <b>1</b> - if this string object lexicographically follows the
	 *         argument s */
	public int compareTo(MyOwnString s) {
		// if an input string is null, return 1
		if (s == null) return 1;
		int result = 0;
		// create two strings without any additional symbols except letter
		// characters and make them lower case
		String s1 = "", s2 = "";
		if (length != 0 && data != null) {
			for (int i = 0; i < length; i++)
				if ((data[i] >= 'A' && data[i] <= 'Z')
				    || (data[i] >= 'a' && data[i] <= 'z'))
				  s1 += Character.toLowerCase(data[i]);
		}
		if (s.length != 0 && s.data != null) {
			for (int i = 0; i < s.length; i++)
				if ((s.data[i] >= 'A' && s.data[i] <= 'Z')
				    || (s.data[i] >= 'a' && s.data[i] <= 'z'))
				  s2 += Character.toLowerCase(s.data[i]);
		}
		// calculate a minimal length
		int minLength = (s1.length() < s2.length()) ? s1.length() : s2.length();
		int i = 0;
		// continue while symbols are equal and we did not reach the minimal length
		while (result == 0 && i < minLength) {
			char currentValue = s1.charAt(i);
			char paraValue = s2.charAt(i);
			// compare them
			if (currentValue != paraValue)
			  result = (currentValue < paraValue) ? -1 : 1;

			i++;
		}
		// if the result is still equal to 0, than compare lengths of strings
		if (result == 0)
		  if (s1.length() != s2.length())
		    result = (s1.length() < s2.length()) ? -1 : 1;
		return result;
	}

	/** Adds the string s to the end of the existing string
	 * 
	 * @param s - the MyOwnString to be added */
	public void concat(MyOwnString s) {
		// if an input data is and empty string or null, than do nothing
		if (s == null || s.length == 0 || s.data == null) return;
		// if the current string is empty, than copy the input string
		if (length == 0) {
			data = Arrays.copyOf(s.data, s.data.length);
			length = s.length;
			return;
		}
		// otherwise making a new array and concatenate two arrays in it
		char[] newData = Arrays.copyOf(data, length + s.length);
		for (int i = 0; i < s.length; i++)
			newData[length + i] = s.data[i];
		data = newData;
		length += s.length;
	}

	/** Returns the index within this string of the first occurrence of the
	 * specified string argument s, returns a negative value if the substring was
	 * not found
	 * 
	 * @param s - specified MyOwnString argument
	 * @return a negative value if the substring was not found or a position of
	 *         the first occurrence */
	public int indexOf(MyOwnString s) {
		// if an input string is null, than return -1
		if (s == null) return -1;
		// if the input string is empty, than return 0
		if (s.length == 0 || s.data == null) return 0;
		// otherwise try to find a fist occurrence and return its position if found
		for (int i = 0; i < length - s.length + 1; i++) {
			int index = 0;
			for (; index < s.length && data[index + i] == s.data[index]; index++)
				;
			if (index == s.length) return i;
		}
		// return -1 if we did not find any position
		return -1;
	}

	/** Returns the length of the string */
	public int length() {
		return length;
	}

	/** Returns the string starting at the character with index start (inclusive)
	 * to the character with index end (exclusive); returns null if any of the
	 * indexes given is not valid for the string
	 * 
	 * @param start - the start index
	 * @param end - the end index
	 * @return a substring from the start index to the end index */
	public MyOwnString substring(int start, int end) {
		// if an input data is incorrect, return null
		if (start > end || start < 0 || end > length) return null;
		// if the start index is equal to the end index, return a new empty
		// MyOwnString
		if (start == end) return new MyOwnString();
		// otherwise it is a range between the start and the end indices
		char[] substring = Arrays.copyOfRange(data, start, end);
		return new MyOwnString(substring);
	}

	@Override
	/** Returns the saved string as an instance of java.lang.String */
	public String toString() {
		return (data == null) ? "" : String.copyValueOf(data);
	}

	/** Eliminate all leading and tailing white-spaces of the string
	 * 
	 * @return a number of white-spaces eliminated */
	public int trim() {
		// if the current string is empty, than nothing to trim
		if (length == 0 || data == null) return 0;
		// calculate a number of white spaces at the beginning
		int startIndex = 0;
		while (startIndex < length && data[startIndex] == ' ')
			startIndex++;
		// if this number is equal to the length, make an empty string
		if (startIndex == length) {
			createEmptyString();
			return startIndex;
		}
		// calculate a number of white spaces at the end
		int endIndex = length - 1;
		while (data[endIndex] == ' ')
			endIndex--;
		// calculate a new length and return 0 if there is nothing to trim
		int newLength = endIndex - startIndex + 1;
		if (newLength == length) return 0;
		// copy a reference of the trimmed range of data
		int result = length - newLength;
		data = Arrays.copyOfRange(data, startIndex, endIndex + 1);
		length = newLength;
		return result;
	}
}
