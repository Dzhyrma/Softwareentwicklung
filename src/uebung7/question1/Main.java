package uebung7.question1;

public class Main {
	private static final String OUTPUT_FORMAT_STRING = "%s = \"%s\", length = %d%n";

	/** @param args - no arguments will evaluate */
	public static void main(String[] args) {
		System.out.println("\nCostructors----------------------------------------");
		String s = null;
		MyOwnString nullString = new MyOwnString(s);
		System.out.printf(OUTPUT_FORMAT_STRING, "nullString", nullString, nullString.length());
		MyOwnString empty1 = new MyOwnString();
		System.out.printf(OUTPUT_FORMAT_STRING, "empty1", empty1, empty1.length());
		MyOwnString empty2 = new MyOwnString("");
		System.out.printf(OUTPUT_FORMAT_STRING, "empty2", empty2, empty2.length());
		MyOwnString empty3 = new MyOwnString(new char[] {});
		System.out.printf(OUTPUT_FORMAT_STRING, "empty3", empty3, empty3.length());
		MyOwnString empty4 = new MyOwnString(empty1);
		System.out.printf(OUTPUT_FORMAT_STRING, "empty4", empty4, empty4.length());
		MyOwnString hello = new MyOwnString(new char[] { 'H', 'e', 'l', 'l', 'o' });
		System.out.printf(OUTPUT_FORMAT_STRING, "hello", hello, hello.length());
		MyOwnString world = new MyOwnString(" World!");
		System.out.printf(OUTPUT_FORMAT_STRING, "world", world, world.length());
		System.out.println("\nConcat---------------------------------------------");
		MyOwnString helloWorld = MyOwnString.concat(hello, world);
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld", helloWorld,
		    helloWorld.length());
		MyOwnString concat = new MyOwnString("Example");
		System.out.printf(OUTPUT_FORMAT_STRING, "concat", concat, concat.length());
		concat.concat(null);
		System.out.printf("Null concatenated:%n" + OUTPUT_FORMAT_STRING,
		    "concat", concat, concat.length());
		concat.concat(empty1);
		System.out.printf("Empty string concatenated:%n" + OUTPUT_FORMAT_STRING,
		    "concat", concat, concat.length());
		empty1.concat(concat);
		System.out.printf(
		    "To the empty string concatenated the string \"concat\":%n"
		        + OUTPUT_FORMAT_STRING, "empty1", empty1, empty1.length());
		MyOwnString whiteSpaces = new MyOwnString("    ");
		System.out.printf(OUTPUT_FORMAT_STRING, "whiteSpaces", whiteSpaces,
		    whiteSpaces.length());
		MyOwnString stringToTrim = MyOwnString.concat(whiteSpaces, concat);
		stringToTrim.concat(whiteSpaces);
		System.out.printf(OUTPUT_FORMAT_STRING, "stringToTrim", stringToTrim,
		    stringToTrim.length());
		System.out.println("\nTrim-----------------------------------------------");
		int trimmed = stringToTrim.trim();
		System.out.println("stringToTrim first trimming:");
		System.out.printf("trimmed = \"%d\", " + OUTPUT_FORMAT_STRING, trimmed,
		    "stringToTrim", stringToTrim, stringToTrim.length());
		trimmed = stringToTrim.trim();
		System.out.println("stringToTrim second trimming:");
		System.out.printf("trimmed = \"%d\", " + OUTPUT_FORMAT_STRING, trimmed,
		    "stringToTrim", stringToTrim, stringToTrim.length());
		trimmed = whiteSpaces.trim();
		System.out.println("whiteSpaces first trimming:");
		System.out.printf("trimmed = \"%d\", " + OUTPUT_FORMAT_STRING, trimmed,
		    "whiteSpaces", whiteSpaces, whiteSpaces.length());
		trimmed = whiteSpaces.trim();
		System.out.println("whiteSpaces second trimming:");
		System.out.printf("trimmed = \"%d\", " + OUTPUT_FORMAT_STRING, trimmed,
		    "whiteSpaces", whiteSpaces, whiteSpaces.length());
		System.out.println("\nSubstring------------------------------------------");
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld.substring(0, 12)",
		    helloWorld.substring(0, 12), helloWorld.substring(0, 12).length());
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld.substring(2, 10)",
		    helloWorld.substring(2, 10), helloWorld.substring(2, 10).length());
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld.substring(0, 0)",
		    helloWorld.substring(0, 0), helloWorld.substring(0, 0).length());
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld.substring(0, 20)",
		    helloWorld.substring(0, 20), 0); // returns null
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld.substring(-5, 12)",
		    helloWorld.substring(-5, 12), 0); // returns null
		System.out.printf(OUTPUT_FORMAT_STRING, "helloWorld.substring(12, 0)",
		    helloWorld.substring(12, 0), 0); // returns null
		System.out.println("\nCompareTo------------------------------------------");
		System.out
    .println("empty2.compareTo(null) = " + empty2.compareTo(null));
		System.out
		    .println("empty2.compareTo(empty2) = " + empty2.compareTo(empty2));
		System.out
		    .println("empty2.compareTo(empty3) = " + empty2.compareTo(empty3));
		System.out.println("hello.compareTo(hello) = " + hello.compareTo(hello));
		System.out.println("hello.compareTo(world) = " + hello.compareTo(world));
		System.out.println("world.compareTo(hello) = " + world.compareTo(hello));
		System.out.println("hello.compareTo(helloWorld) = "
		    + hello.compareTo(helloWorld));
		System.out
		    .println("MyOwnString.concat(new MyOwnString(\"   \"), hello).compareTo(hello) = "
		        + MyOwnString.concat(new MyOwnString("   "), hello)
		            .compareTo(hello));
		System.out
		    .println("MyOwnString.concat(hello, new MyOwnString(\"   \")).compareTo(hello)) = "
		        + MyOwnString.concat(hello, new MyOwnString("   "))
		            .compareTo(hello));
		System.out.println("\nIndexOf--------------------------------------------");
		System.out.println("helloWorld.indexOf(null) = "
		    + helloWorld.indexOf(null));
		System.out.println("helloWorld.indexOf(empty2) = "
		    + helloWorld.indexOf(empty2));
		System.out.println("helloWorld.indexOf(hello) = "
		    + helloWorld.indexOf(hello));
		System.out.println("helloWorld.indexOf(world) = "
		    + helloWorld.indexOf(world));
		System.out.println("helloWorld.indexOf(new MyOwnString(\"o\")) = "
		    + helloWorld.indexOf(new MyOwnString("o")));
		System.out.println("helloWorld.indexOf(new MyOwnString(\"a\")) = "
		    + helloWorld.indexOf(new MyOwnString("a")));
		System.out.println("empty2.indexOf(empty2) = " + empty2.indexOf(empty2));
		System.out.println("empty2.indexOf(helloWorld) = "
		    + empty2.indexOf(helloWorld));
	}

}
