package uebung6.question1;

import java.util.Random;

/**
 * Phone is a class, providing easy to use methods to edit and read an important
 * parameters of the any smartphone.
 * 
 * @author Andrii Dzhyrma
 */
public class Phone {

	// Initialize the empty string constant
	private static final String EMPTY_STRING = "";

	// Initialize the parameters of the phone
	private String cpu = EMPTY_STRING;
	private final long id;

	// Initialize the name and id variables as final
	private final String name;
	private String os = EMPTY_STRING;
	private String resolution = EMPTY_STRING;
	private String storage = EMPTY_STRING;
	private String weight = EMPTY_STRING;

	/**
	 * Constructor of the class Phone.
	 * 
	 * @param name
	 *            - name of the phone.
	 */
	public Phone(String name) {
		this.name = name;
		// Generate 10 digit random id
		id = (long) (new Random().nextDouble() * 8999999999d) + 1000000000;
	}

	/**
	 * Determines the <tt>String</tt> value of the phone property <i>CPU</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getCpu() {
		return cpu;
	}

	/**
	 * Determines the 10-digit <tt>long</tt> value of the phone property
	 * <i>ID</i>.
	 * 
	 * @return the <tt>long</tt> value of the property.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Determines the <tt>String</tt> value of the phone property <i>Name</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Determines the <tt>String</tt> value of the phone property <i>OS</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getOs() {
		return os;
	}

	/**
	 * Determines the <tt>String</tt> value of the phone property
	 * <i>Resolution</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * Determines the <tt>String</tt> value of the phone property
	 * <i>Storage</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getStorage() {
		return storage;
	}

	/**
	 * Determines the <tt>String</tt> value of the phone property <i>Weight</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * Sets the phone property <i>CPU</i>.
	 * 
	 * @param cpu
	 *            - the new CPU value.
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * Sets the phone property <i>OS</i>.
	 * 
	 * @param os
	 *            - the new OS value.
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * Sets the phone property <i>Resolution</i>.
	 * 
	 * @param resolution
	 *            - the new resolution value.
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * Sets the phone property <i>Storage</i>.
	 * 
	 * @param storage
	 *            - the new storage size value.
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}

	/**
	 * Sets the phone property <i>Weight</i>.
	 * 
	 * @param weight
	 *            - the new weight value.
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
}
