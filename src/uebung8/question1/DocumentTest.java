package uebung8.question1;

/** The DocumentTest class tests an existed class Document
 * 
 * @author Andrii Dzhyrma */
public class DocumentTest {	
	public static void main(String[] args) {
		System.out.println("Test #1");
		Document document1 = new Document("some_file.txt");
		test(document1);
		System.out.println("\nTest #2");
		Document document2 = new Document("alltitles.txt");
		test(document2);
	}

	public static void test(Document document) {
		document.analyzeFile();
		System.out.println("printWords()");
		printWords(document);
		System.out.println("printWordList(true)");
		printWordList(document,true);
		System.out.println("printWordList(false)");
		printWordList(document,false);
	}

	public static void printWords(Document document) {
		String[] words = document.getWords();
		if (words != null)
			for (String word : words)
				System.out.println(word);
		else
			System.out.println("printWords error!");
	}

	public static void printWordList(Document document, boolean isAscending) {
		String[] words = document.getWordList(isAscending);
		int[] frequencies = document.getFrequencyList(isAscending);
		if (words != null || frequencies != null)
			for (int i = 0; i < words.length; i++)
				System.out.println(words[i] + " " + frequencies[i]);
		else
			System.out.println("printWordList error!");
	}
}
