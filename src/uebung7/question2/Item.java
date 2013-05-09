package uebung7.question2;

import java.util.Calendar;

/** The class Item allows for items to consist a textual description, a due date
 * and a status. Can be added only into an one group.
 * 
 * @author Andrii Dzhyrma */
public class Item {

	// Private Members ///////////////////////////////////////////////////////////

	// Constants -----------------------------------------------------------------
	private static final String NO_GROUP_BELONG_TO_MESSAGE = "<no group>";
	private static final String PRINT_FORMAT_STRING = "#%d, %s, %s, %d.%02d.%02d, %s%n";
	private static final String[] STATUS_ARRAY = { "open", "started", "finished" };

	// Static Fields -------------------------------------------------------------
	private static int currentId = 1;

	// Fields --------------------------------------------------------------------
	private Group belongTo;
	private String description;
	private Calendar dueDate;
	private int id;
	private int status;

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** This constructor initializes and generates id for the object.
	 * 
	 * @param description - the description of the item
	 * @param dueDate - the date of the item event */
	public Item(String description, Calendar dueDate) {
		id = currentId++;
		this.description = (description != null) ? description : "";
		// a status of the item
		this.status = 0;
		// if a dueDate value is null, generate current the current time instead
		if (dueDate == null)
			this.dueDate = Calendar.getInstance();
		else
			this.dueDate = (Calendar) dueDate.clone();
	}

	/** Finish the current event */
	public void finish() {
		status = 2;
	}

	/** Returns the group to what this item belongs to
	 * 
	 * @return - the parent group */
	public Group getBelongTo() {
		return belongTo;
	}

	/** Returns the description of the current item
	 * 
	 * @return - the description value */
	public String getDescription() {
		return description;
	}

	/** Returns the date of the item event to be expired
	 * 
	 * @return - the dueDate value */
	public Calendar getDueDate() {
		return dueDate;
	}

	/** Returns the status of the item interpreted as an integer value
	 * 
	 * @return - the status value */
	public int getStatus() {
		return status;
	}

	/** Prints the item and the information about the group it belongs to. */
	public void print() {
		System.out.printf(PRINT_FORMAT_STRING, id, description,
		    (belongTo == null) ? NO_GROUP_BELONG_TO_MESSAGE : belongTo.getName(),
		    dueDate.get(Calendar.YEAR), dueDate.get(Calendar.MONTH) + 1,
		    dueDate.get(Calendar.DAY_OF_MONTH), STATUS_ARRAY[status]);
	}

	/** Sets the parent group of the item
	 * 
	 * @param belongTo - the group value */
	public void setBelongTo(Group belongTo) {
		this.belongTo = belongTo;
	}

	/** Starts the item event */
	public void start() {
		status = 1;
	}
}
