package uebung6.question1;

/**
 * Shop is a class, providing easy to use methods to add and print information
 * about smartphones out from the shop database.
 * 
 * @author Andrii Dzhyrma
 */
public class Shop {

	// Output format string for the phones in array
	private static final String PHONE_OUTPUT_FORMAT_STRING = "Phone %d: %s [#%d]%n\t-CPU: %s%n\t-OS: %s%n\t-Resolution: %s%n\t-Storage: %s%n\t-Weight: %s%n";

	// The array to store the phones
	private Phone[] phones;

	/**
	 * Inserts the specified elements to the end of the existing list of phones
	 * 
	 * @param phones
	 *            - elements to be inserted
	 */
	public void addPhones(Phone[] phones) {
		// Check for existing of the array in the shop class
		if (this.phones == null)
			this.phones = phones;
		// Check for existing of the input array
		else if (phones == null)
			return;
		else {
			// Create new array with bigger size and copy all the elements to it
			Phone[] newPhones = new Phone[this.phones.length + phones.length];
			for (int i = 0; i < this.phones.length; i++)
				newPhones[i] = this.phones[i];
			for (int i = 0; i < phones.length; i++)
				newPhones[this.phones.length + i] = phones[i];
		}
	}

	/**
	 * Prints out all the phones from the array
	 */
	public void printPhones() {
		for (int i = 0; i < phones.length; i++)
			if (phones[i] != null)
				System.out.printf(PHONE_OUTPUT_FORMAT_STRING, i + 1,
						phones[i].getName(), phones[i].getId(),
						phones[i].getCpu(), phones[i].getOs(),
						phones[i].getResolution(), phones[i].getStorage(),
						phones[i].getWeight());
	}
}
