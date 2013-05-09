package uebung6.question2;

/**
 * Feature is a class, providing easy to use methods for creating and editing
 * features with two properties "name" and "description".
 * 
 * @author Andrii Dzhyrma
 */
public class Feature {

	// All the important constants
	private static final String TO_STRING_FORMAT_STRING = "[%s=%s]";

	// The name and the description properties
	private String name, description;

	/**
	 * Constructor of the class Feature
	 * 
	 * @param name
	 *          - the name of the feature.
	 * @param description
	 *          - the description feature.
	 */
	public Feature(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Determines the <tt>String</tt> value of the feature property
	 * <i>Description</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Determines the <tt>String</tt> value of the feature property <i>Name</i>.
	 * 
	 * @return the <tt>String</tt> value of the property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the feature property <i>Description</i>.
	 * 
	 * @param description
	 *          - the new description value.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the feature property <i>Name</i>.
	 * 
	 * @param name
	 *          - the new name value.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT_STRING, name, description);
	}

}
