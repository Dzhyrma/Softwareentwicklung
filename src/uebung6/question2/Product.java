package uebung6.question2;

import java.util.Random;

/**
 * Product is a class, providing easy to use methods for creating and editing
 * products with an any type of features.
 * 
 * @author Andrii Dzhyrma
 */
public class Product {

	// All the important constants
	private static final int MAX_NUM_FEATURES = 10;
	private static final String TO_STRING_FORMAT_STRING = "Product %s (#%d) selected: [Price=%.2f]%s%n";
	private static final String DELIMITER_STRING = ", ";
	private static final String NO_FEATURES_STRING = "There is no feature in this product.";
	private static final String FEATURE_LIST_ITEM_FORMAT_STRING = "[%d] %s%n";
	// The identification number of the product
	private final long id;

	// The number of features in the product
	private int featuresSize = 0;
	// The array to store the features
	private Feature[] features = new Feature[MAX_NUM_FEATURES];
	// The name of the product
	private String name;
	// The price of the product
	private double price;

	/**
	 * Constructor of the class Product.
	 * 
	 * @param name
	 *          - the name of the product.
	 * @param price
	 *          - the price of the product.
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		// Generate 10 digit random id
		id = (long) (new Random().nextDouble() * 8999999999d) + 1000000000;
	}

	/**
	 * Inserts the specified element to the end of the existing list of features.
	 * 
	 * @param feature
	 *          - element to be inserted.
	 * @return the result of insertion.
	 */
	public boolean addFeature(Feature feature) {
		if (featuresSize >= MAX_NUM_FEATURES)
			return false;
		features[featuresSize++] = feature;
		return true;
	}

	/**
	 * Determines the <tt>Integer</tt> value of the amount of features in the
	 * product.
	 * 
	 * @return the <tt>Integer</tt> value of the property.
	 */
	public int getFeaturesSize() {
		return featuresSize;
	}

	/**
	 * Determines the 10-digit <tt>long</tt> value of the product property
	 * <i>ID</i>.
	 * 
	 * @return the <tt>long</tt> value of the property.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Determines the <tt>String</tt> value of the product property <i>Name</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Determines the <tt>double</tt> value of the product property <i>Price</i>.
	 * 
	 * @return the <tt>double</tt> value of the property.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Prints the list of all features to <tt>String</tt> value.
	 * 
	 * @return the <tt>String</tt> which represents all features from the list.
	 */
	public String printFeatures() {
		if (featuresSize == 0)
			return NO_FEATURES_STRING;
		String result = "";
		for (int i = 0; i < featuresSize; i++)
			result += String.format(FEATURE_LIST_ITEM_FORMAT_STRING, i, features[i]);
		return result;
	}

	/**
	 * Removes feature from the given index in the list.
	 * 
	 * @param index
	 *          - the position of feature to be removed in the list.
	 * @return the result of removal.
	 */
	public boolean removeFeature(int index) {
		if (index < 0 || index >= featuresSize)
			return false;
		features[index] = null;
		for (int i = index + 1; i < featuresSize; features[i - 1] = features[i++])
			;
		featuresSize--;
		return true;
	}

	/**
	 * Sets the product property <i>Name</i>.
	 * 
	 * @param name
	 *          - the new name value.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the product property <i>Price</i>.
	 * 
	 * @param price
	 *          - the new price value
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String featuresString = "";
		for (int i = 0; i < featuresSize; i++)
			featuresString += DELIMITER_STRING + features[i].toString();
		return String.format(TO_STRING_FORMAT_STRING, name, id, price,
		    featuresString);
	}
}
