package uebung10.question2;

public class Main {
	private static final String[] TEXTS = { null, "", "", "", "abc", "abc",
	    "abc", "abcd", "abc", "abc", "", "123", "123", "123", "123", "123.",
	    "!Hugo12344!", "!Hugo12344!", "aaaaaaaaaaaaaaaaaaaaabababababa",
	    "43(699)108-934-62", "43(699)108-934-6", "office@pervasive.jku.at",
	    "office@" };
	private static final String[] PATTERNS = { null, "", "abc", "***", "", "abc",
	    "abcd", "abc", "*", "+", "+", "*#", "+#", "$", ".$", "$.", ".Hugo###$?!",
	    "!Hugo###$?!", "*b*b*b*b*b*", "43(###)###-###-##", "43(###)###-###-##",
	    "+@+", "+@+" };

	/** @param args - no arguments will evaluate */
	public static void main(String[] args) {
		for (int i = 0; i < TEXTS.length; i++)
			System.out.println("isMatching (\"" + TEXTS[i] + "\", \"" + PATTERNS[i]
			    + "\"); => " + isMatching(TEXTS[i], PATTERNS[i]));
	}

	/** Checks whether the text matches to the pattern
	 * 
	 * @param text - the text to check
	 * @param pattern - the pattern to check
	 * @return - true if the pattern matches */
	public static boolean isMatching(String text, String pattern) {
		// check whether the input is correct
		if (text == null || pattern == null)
			return false;
		if (pattern.length() == 0) {
			// if both Strings are empty, return true
			if (text.length() == 0)
				return true;
			return false;
		}
		// the text can be empty only if pattern is empty or contains star symbols
		// only
		if (text.length() == 0 && pattern.charAt(0) != '*')
			return false;
		String patternSubstring = pattern.substring(1);
		// for every described symbol do a correspondent action
		switch (pattern.charAt(0)) {
		case '?':
			return isMatching(text.substring(1), patternSubstring);
		case '.':
			char c = text.charAt(0);
			if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
				return false;
			return isMatching(text.substring(1), patternSubstring);
		case '#':
			if (text.charAt(0) < '0' || text.charAt(0) > '9')
				return false;
			return isMatching(text.substring(1), patternSubstring);
		case '*':
			if (isMatching(text, pattern.substring(1)))
				return true;
		case '+':
			for (int i = 1; i <= text.length(); i++)
				if (isMatching(text.substring(i), patternSubstring))
					return true;
			return false;
		case '$':
			char digit = text.charAt(0);
			for (int i = 1; i <= text.length() && digit >= '0' && digit <= '9'; digit = text
			    .charAt(i++))
				if (isMatching(text.substring(i), patternSubstring))
					return true;
			return false;
		default:
			if (text.charAt(0) != pattern.charAt(0))
				return false;
			return isMatching(text.substring(1), patternSubstring);
		}
	}
}
