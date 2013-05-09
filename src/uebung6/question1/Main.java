package uebung6.question1;

public class Main {

	// Initialize the maximum value of phones
	static final int MAX_NUM_PHONES = 3;

	/**
	 * @param args
	 *          - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Initialize the shop
		Shop shop = new Shop();

		// Initialize the array as container for numerous smrartphones.
		// Use a constant for the array length
		Phone[] phones = new Phone[MAX_NUM_PHONES];

		// Create a new phone and set its features and attributes
		Phone apple = new Phone("Apple iPhone 5");
		apple.setCpu("1.3 GHz dual core Apple A6");
		apple.setOs("iOS 6.0.1");
		apple.setResolution("640x1136");
		apple.setStorage("64 GB");
		apple.setWeight("112 g");

		Phone samsung = new Phone("Samsung Galaxy S III");
		samsung.setCpu("1.4 GHz quad-core Cortex-A9");
		samsung.setOs("Android 4.0 (Ice Cream Sandwich)");
		samsung.setResolution("720x1280");
		samsung.setStorage("32 GB");
		samsung.setWeight("133 g");

		Phone nokia = new Phone("Nokia Lumia 800");
		nokia.setCpu("1.4 GHz Scorpion");
		nokia.setOs("Microsoft Windows Phone 7.5 Mango");
		nokia.setResolution("480 x 800");
		nokia.setStorage("16 GB");
		nokia.setWeight("142 g");

		// Add the phone to the shop's phone array
		phones[0] = apple;
		phones[1] = samsung;
		phones[2] = nokia;

		// Add and print the phones to the screen
		shop.addPhones(phones);
		shop.printPhones();
	}

}
