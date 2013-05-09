package uebung6.question2;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class Main {

	// The constant options to choose
	private static final String[] FEATURE_EDIT_OPTIONS = new String[] {
			"Delete an existing feature", "Add a new feature", "Return" };
	private static final String[] PRODUCT_EDIT_OPTIONS = new String[] {
			"Change product name", "Change product price",
			"Change product features", "Return" };
	private static final String[] SHOP_MAIN_OPTIONS = new String[] {
			"Print product list", "Add product", "Delete product",
			"Show product details", "Exit program" };

	// All the important string constants
	private static final String NAME_STRING = "name";
	private static final String PRICE_STRING = "price";
	private static final String SHOP_NAME_STRING = "My TestShop";
	private static final String SELECT_OPTION_STRING = "\nPlease select option:";
	private static final String PRODUCT_SELECTED_FEATURES_STRING = "The selected product has the following features:";
	private static final String ITEM_ADDED_ERROR_STRING = "The insertion of the new item failed! Probably you reached the maximum number...";
	private static final String ITEM_ADDED_STRING = "Item added successfully!";
	private static final String ITEM_REMOVED_STRING = "Item removed successfully!";
	private static final String ITEM_REMOVED_ERROR_STRING = "The removal of the item failed!";
	private static final String INVALID_INPUT_ERROR_STRING = "Invalid input. Please try again: ";

	private static final String PRODUCT_DELETE_FEATURE_REQUEST_STRING = "Please enter the index of the feature to be deleted: ";
	private static final String PRODUCT_FEATURE_REQUEST_STRING = "Please enter a feature (name=description) or hit enter to return: ";
	private static final String PRODUCT_NAME_REQUEST_STRING = "Please enter the product's name: ";
	private static final String PRODUCT_PRICE_REQUEST_STRING = "Please enter the product's price: ";
	private static final String SHOP_DELETE_PRODUCT_REQUEST_STRING = "Please select the index of the product to delete: ";
	private static final String SHOP_PRODUCT_REQUEST_STRING = "Please select the index of the product: ";

	private static final String SHOP_DESCRIPTION_FORMAT_STRING = "========================================%n  %s%n========================================%n";
	private static final String OPTION_FORMAT_STRING = "[%d] %s%n";
	private static final String PRICE_FORMAT_STRING = "%.2f";
	private static final String PRODUCT_ATTRIBUTE_CHANGED_FORMAT_STRING = "Product %s changed successfully!%n";
	private static final String PRODUCT_CHANGE_ATTRIBUTE_FORMAT_STRING = "Current %s is: %s%nEnter new %s: ";

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		Shop shop = new Shop(SHOP_NAME_STRING);
		Product pc = new Product("PC", 1199);
		pc.addFeature(new Feature("Brand", "Asus"));
		pc.addFeature(new Feature("USB", "4"));
		pc.addFeature(new Feature("Resolution", "1280x1024 pixels"));
		pc.addFeature(new Feature("Weight", "2.5 kg"));
		shop.addProduct(pc);
		Product tablet = new Product("Tablet", 549);
		tablet.addFeature(new Feature("Brand", "Asus"));
		tablet.addFeature(new Feature("USB", "1"));
		tablet.addFeature(new Feature("Resolution", "1280x800 pixels"));
		tablet.addFeature(new Feature("Weight", "635 g"));
		shop.addProduct(tablet);

		// Print out description of the current shop
		System.out.printf(SHOP_DESCRIPTION_FORMAT_STRING, shop.getName());
		// Make infinite cycle to ask user choose an option until he will choose
		// "Exit program"
		int choice;
		do {
			// Print out shop main options
			System.out.println(SELECT_OPTION_STRING);
			for (int i = 0; i < SHOP_MAIN_OPTIONS.length; i++)
				System.out.printf(OPTION_FORMAT_STRING, i + 1,
						SHOP_MAIN_OPTIONS[i]);
			// Read the user's choice
			choice = readInt(1, SHOP_MAIN_OPTIONS.length,
					INVALID_INPUT_ERROR_STRING);

			// Use switch statement to call correspondent methods
			switch (choice) {
			case 1: // Print product list
				System.out.println(shop.printProducts());
				break;
			case 2: // Add product
				printAddProductDialog(shop);
				break;
			case 3: // Delete product
				printDeleteProductDialog(shop);
				break;
			case 4: // Show product details
				printProductDetailsDialog(shop);
				break;
			case 5: // Exit program
				return;
			default:
				break;
			}
		} while (true);
	}

	// Prints dialog to add new feature into the chosen product
	private static boolean printAddFeatureDialog(Product product,
			boolean isSuccessOutput) {
		// Initialize variables for the new feature creation
		String featureName;
		String featureDescription;
		Feature feature;

		// Print out request to write name and description for the new feature
		System.out.print(PRODUCT_FEATURE_REQUEST_STRING);
		// Read new feature represented as string
		String newFeatureString = Input.readString();
		// Initialize integer variable with the index of equal character
		if (newFeatureString.length() == 0)
			return false;
		// While the name or the description is empty, print out an error
		int equalIndex = newFeatureString.indexOf('=');
		while (equalIndex < 1 || equalIndex == newFeatureString.length() - 1) {
			System.out.println(INVALID_INPUT_ERROR_STRING);
			newFeatureString = Input.readString();
			equalIndex = newFeatureString.indexOf('=');
		}
		// Otherwise separate name and description values and make the new
		// feature
		featureName = newFeatureString.substring(0, equalIndex);
		featureDescription = newFeatureString.substring(equalIndex + 1);
		feature = new Feature(featureName, featureDescription);
		// Check for successful feature adding and print correspondent output
		if (!product.addFeature(feature))
			System.out.println(ITEM_ADDED_ERROR_STRING);
		else if (isSuccessOutput)
			System.out.println(ITEM_ADDED_STRING);
		return true;
	}

	// Prints dialog to add new product into the shop
	private static void printAddProductDialog(Shop shop) {
		// Initialize variables for the new product creation
		String name;
		Double price;
		Product product;

		// Print out request for the name of the new product
		System.out.print(PRODUCT_NAME_REQUEST_STRING);
		// Read the name
		name = Input.readString();
		while (name.length() == 0) {
			System.out.print(INVALID_INPUT_ERROR_STRING);
			name = Input.readString();
		}
		// Print out request for the price of the new product
		System.out.print(PRODUCT_PRICE_REQUEST_STRING);
		// Read the price
		price = Input.readDouble();
		while (price < 0) {
			System.out.print(INVALID_INPUT_ERROR_STRING);
			price = Input.readDouble();
		}
		// Convert price value to double value with only 2 digits after the dot
		price = Math.round(price * 100) / 100d;
		// Make the new product
		product = new Product(name, price);
		// Next loop will read and add new features to the new product until
		// user will input anything except enter
		while (printAddFeatureDialog(product, false))
			;

		// Check for successful product adding and print correspondent output
		if (shop.addProduct(product))
			System.out.println(ITEM_ADDED_STRING);
		else
			System.out.println(ITEM_ADDED_ERROR_STRING);
	}

	// Prints dialog to delete a feature from the product
	private static void printDeleteFeatureDialog(Product product) {
		// Print out all features from the product
		System.out.println(product.printFeatures());
		// If there is no feature, make return
		if (product.getFeaturesSize() == 0)
			return;
		// Print out request for the index of the feature to be removed
		System.out.print(PRODUCT_DELETE_FEATURE_REQUEST_STRING);
		// Read the index
		int removeFeatureIndex = readInt(0, product.getFeaturesSize() - 1,
				INVALID_INPUT_ERROR_STRING);

		// Check for successful feature removal and print correspondent output
		if (product.removeFeature(removeFeatureIndex))
			System.out.println(ITEM_REMOVED_STRING);
		else
			System.out.println(ITEM_REMOVED_ERROR_STRING);
	}

	// Prints dialog to delete a product from the shop
	private static void printDeleteProductDialog(Shop shop) {
		// Print out all products from the shop
		System.out.println(shop.printProducts());
		// If there is no product, make return
		if (shop.getProductsSize() == 0)
			return;
		// Print out request for the index of the product to be removed
		System.out.print(SHOP_DELETE_PRODUCT_REQUEST_STRING);
		int removeIndex = readInt(0, shop.getProductsSize() - 1,
				INVALID_INPUT_ERROR_STRING);

		// Check for successful product removal and print correspondent output
		if (shop.removeProduct(removeIndex))
			System.out.println(ITEM_REMOVED_STRING);
		else
			System.out.println(ITEM_REMOVED_ERROR_STRING);
	}

	// Prints dialog to delete a feature, add, or go to the previous dialog
	private static void printProductChangeFeaturesDialog(Product product) {
		// Print out all features from the product
		System.out.println(PRODUCT_SELECTED_FEATURES_STRING);
		System.out.println(product.printFeatures());

		// Make loop to ask for the users choice until he/she will choose
		// "Return"
		int choice;
		do {
			// Print out feature options
			System.out.println(SELECT_OPTION_STRING);
			for (int i = 0; i < FEATURE_EDIT_OPTIONS.length; i++)
				System.out.printf(OPTION_FORMAT_STRING, i + 1,
						FEATURE_EDIT_OPTIONS[i]);
			// Read the user's choice
			choice = readInt(1, FEATURE_EDIT_OPTIONS.length,
					INVALID_INPUT_ERROR_STRING);

			// Use switch statement to call correspondent methods
			switch (choice) {
			case 1: // Delete an existing feature
				printDeleteFeatureDialog(product);
				break;
			case 2: // Add a new feature
				printAddFeatureDialog(product, true);
				break;
			default: // "Return" or any other options
				break;
			}
		} while (choice != FEATURE_EDIT_OPTIONS.length);
	}

	// Prints dialog to change the product name
	private static void printProductChangeNameDialog(Product product) {
		// Print out request for a new name of the product
		System.out.printf(PRODUCT_CHANGE_ATTRIBUTE_FORMAT_STRING, NAME_STRING,
				'"' + product.getName() + '"', NAME_STRING);
		// Read the new name until its size will be greater than zero
		String newName = Input.readString();
		while (newName.length() == 0) {
			System.out.print(INVALID_INPUT_ERROR_STRING);
			newName = Input.readString();
		}
		// Change the name of the product and print out confirmation message
		product.setName(newName);
		System.out.printf(PRODUCT_ATTRIBUTE_CHANGED_FORMAT_STRING, NAME_STRING);
	}

	// Prints dialog to change the product price
	private static void printProductChangePriceDialog(Product product) {
		// Print out request for a new price of the product
		System.out.printf(PRODUCT_CHANGE_ATTRIBUTE_FORMAT_STRING, PRICE_STRING,
				String.format(PRICE_FORMAT_STRING, product.getPrice()),
				PRICE_STRING);
		// Read the new price until it will be equal or greater than zero
		double newPrice = Input.readDouble();
		while (newPrice < 0) {
			System.out.print(INVALID_INPUT_ERROR_STRING);
			newPrice = Input.readDouble();
		}
		// Convert price value to double value with only 2 digits after the dot
		newPrice = Math.round(newPrice * 100) / 100d;
		// Change the price of the product and print out confirmation message
		product.setPrice(newPrice);
		System.out
				.printf(PRODUCT_ATTRIBUTE_CHANGED_FORMAT_STRING, PRICE_STRING);
	}

	// Prints dialog to show details of the product and gives possibility to
	// change them
	private static void printProductDetailsDialog(Shop shop) {
		// Print out all products from the shop
		System.out.println(shop.printProducts());
		// If there is no product, make return
		if (shop.getProductsSize() == 0)
			return;

		// Print out request for an index of product to be shown
		System.out.print(SHOP_PRODUCT_REQUEST_STRING);
		// Read the index of chosen product
		int index = readInt(0, shop.getProductsSize() - 1,
				INVALID_INPUT_ERROR_STRING);

		// Print out information about the product
		Product product = shop.getProduct(index);
		System.out.println(product);
		
		// Print out product editing options
		System.out.println(SELECT_OPTION_STRING);
		for (int i = 0; i < PRODUCT_EDIT_OPTIONS.length; i++)
			System.out.printf(OPTION_FORMAT_STRING, i + 1,
					PRODUCT_EDIT_OPTIONS[i]);
		// Read a user choice
		int choice = readInt(1, PRODUCT_EDIT_OPTIONS.length,
				INVALID_INPUT_ERROR_STRING);

		// Use switch statement to call correspondent methods
		switch (choice) {
		case 1: // Change product name
			printProductChangeNameDialog(product);
			break;
		case 2: // Change product price
			printProductChangePriceDialog(product);
			break;
		case 3: // Change product features
			printProductChangeFeaturesDialog(product);
			break;
		default: // "Return" or other options
			break;
		}
	}

	// Easy to use method for reading choice between min and max values. It will
	// raise an error if value is not in the input range.
	private static int readInt(int min, int max, String error) {
		int result = Input.readInt();
		while (result < min || result > max) {
			System.out.print(error);
			result = Input.readInt();
		}
		return result;
	}

}
