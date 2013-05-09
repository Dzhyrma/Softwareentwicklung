package uebung6.question2;

/**
 * Shop is a class, providing easy to use methods such as addProduct,
 * removeProduct, getProduct and printProducts.
 * 
 * @author Andrii Dzhyrma
 */
public class Shop {

	// All the important constants
	private static final int MAX_NUM_PRODUCTS = 100;
	private static final String NO_PRODUCTS_STRING = "There is no product in the shop.";
	private static final String PRODUCT_LIST_ITEM_FORMAT_STRING = "[%d] %s (#%d)%n";
	// The name of the shop
	private final String name;

	// The number of products in the shop
	private int productsSize = 0;
	// The array to store the products
	private Product[] products = new Product[MAX_NUM_PRODUCTS];

	/**
	 * Constructor of the class Shop.
	 * 
	 * @param name
	 *          - the name of the shop.
	 */
	public Shop(String name) {
		this.name = name;
	}

	/**
	 * Inserts new product to the shop's product list.
	 * 
	 * @param product
	 *          - product to be inserted.
	 * @return the result of insertion.
	 */
	public boolean addProduct(Product product) {
		if (productsSize >= MAX_NUM_PRODUCTS)
			return false;
		products[productsSize++] = product;
		return true;
	}

	/**
	 * Determines the <tt>String</tt> value of the shop's name.
	 * 
	 * @return the <tt>String</tt> value of the name property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Determines the <tt>Product</tt> value from the shop's list of products.
	 * 
	 * @param index
	 *          - the index of the product to be returned in the product list
	 * @return the <tt>Product</tt> value of the chosen product.
	 */
	public Product getProduct(int index) {
		if (index < 0 || index >= MAX_NUM_PRODUCTS)
			return null;
		return products[index];
	}

	/**
	 * Determines the <tt>Integer</tt> value of the amount of products in the
	 * list.
	 * 
	 * @return the amount of products in the list.
	 */
	public int getProductsSize() {
		return productsSize;
	}

	/**
	 * Prints the list of all products to <tt>String</tt> value.
	 * 
	 * @return the <tt>String</tt> which represents all products from the list.
	 */
	public String printProducts() {
		if (productsSize == 0)
			return NO_PRODUCTS_STRING;
		String result = "";
		for (int i = 0; i < productsSize; i++)
			result += String.format(PRODUCT_LIST_ITEM_FORMAT_STRING, i,
			    products[i].getName(), products[i].getId());
		return result;
	}

	/**
	 * Removes product from the given index in the list.
	 * 
	 * @param index
	 *          - the position of product to be removed in the list.
	 * @return the result of removal.
	 */
	public boolean removeProduct(int index) {
		if (index < 0 || index >= productsSize)
			return false;
		products[index] = null;
		// Shift all products after one removed to left
		for (int i = index + 1; i < productsSize; products[i - 1] = products[i++])
			;
		productsSize--;
		return true;
	}
}
