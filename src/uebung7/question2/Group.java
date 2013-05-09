package uebung7.question2;

/** The class Group holds a list of its items and provide methods, which allow
 * inserting, sorting, and printing of its items.
 * 
 * @author Andrii Dzhyrma */
public class Group {

	// Private Members ///////////////////////////////////////////////////////////

	// Constants -----------------------------------------------------------------
	private static final int MAX_ITEMS = 4;
	private static final String PRINT_FORMAT_STRING = "#%d, %s, %d%n--------%n";
	private static final String GROUP_STRING = "Group #";

	// Static Fields -------------------------------------------------------------
	private static int currentId = 1;

	// Fields --------------------------------------------------------------------
	private final Item[] items = new Item[MAX_ITEMS];
	private int itemsSize = 0;
	private int sortOrder = 0;
	private int id;
	private int priority;
	private String name;

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** This constructor initializes and generates id for the object.
	 * 
	 * @param name - the name of the group
	 * @param priority - the priority of the group (affects on order in the list) */
	public Group(String name, int priority) {
		id = currentId++;
		this.name = (name != null) ? name : GROUP_STRING + id;
		this.priority = (priority > 0) ? priority : 0;
	}

	// Methods -------------------------------------------------------------------
	/** Returns the name value of the current group.
	 * 
	 * @return the name value */
	public String getName() {
		return name;
	}

	/** Returns the priority value of the current group.
	 * 
	 * @return the priority value */
	public int getPriority() {
		return priority;
	}

	/** Inserts an item into the group storing the item in the group's items-array.
	 * The items within a group will be resorted according to the last applied
	 * order. <br>
	 * <b>Note: it is intended that this method is called by List.insertItem()
	 * only! Otherwise some inconsistencies may occur.</b>
	 * 
	 * @param item - the item to be inserted
	 * @return In case no insertion can be made false should be returned,
	 *         otherwise true. */
	public boolean insert(Item item) {
		// if the current array of items is full, or reference to the item is equal
		// to null, or the item is already belongs to another group, return false
		if (itemsSize == MAX_ITEMS || item == null || item.getBelongTo() != null)
			return false;
		// if the input item is already in the list, return false
		for (int i = 0; i < itemsSize; i++)
			if (items[i] == item)
				return false;
		// otherwise add this item into the array and call setBelongTo() method
		items[itemsSize++] = item;
		item.setBelongTo(this);
		// sort the array again
		switch (sortOrder) {
		case 0:
			sortByStatus();
			break;
		case 1:
			sortByDueDate();
		default:
			break;
		}
		return true;
	}

	/** Checks whether the list of items is empty
	 * 
	 * @return */
	public boolean isEmpty() {
		return itemsSize == 0;
	}

	/** Checks whether the list of items is full
	 * 
	 * @return */
	public boolean isFull() {
		return itemsSize == MAX_ITEMS;
	}

	/** Prints the items of the group according to the order of items. */
	public void printAll() {
		System.out.printf(PRINT_FORMAT_STRING, id, name, priority);
		for (int i = 0; i < itemsSize; i++)
			items[i].print();
	}

	/** Resorts a group's items to order by 1) due-date, 2) status, and 3)
	 * description. */
	public void sortByDueDate() {
		// store the order number in the variable
		sortOrder = 1;
		// using algorithm of a minimal element sort the array
		for (int i = 0; i < itemsSize - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < itemsSize; j++) {
				int dueDateComparsion = items[j].getDueDate().compareTo(
				    items[minIndex].getDueDate());
				if (dueDateComparsion < 0)
					minIndex = j;
				else if (dueDateComparsion == 0
				    && (items[j].getStatus() < items[minIndex].getStatus() || (items[j]
				        .getStatus() == items[minIndex].getStatus() && items[j]
				        .getDescription().compareToIgnoreCase(
				            items[minIndex].getDescription()) < 0)))
					minIndex = j;
			}
			if (minIndex != i) {
				Item temp = items[minIndex];
				items[minIndex] = items[i];
				items[i] = temp;
			}
		}
	}

	/** Resorts a group's items to order by 1) status, 2) due date and 3)
	 * description. */
	public void sortByStatus() {
		// store the order number in the variable
		sortOrder = 0;
		// using algorithm of a minimal element sort the array
		for (int i = 0; i < itemsSize - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < itemsSize; j++) {
				if (items[j].getStatus() < items[minIndex].getStatus())
					minIndex = j;
				else if (items[j].getStatus() == items[minIndex].getStatus()) {
					int dueDateComparsion = items[j].getDueDate().compareTo(
					    items[minIndex].getDueDate());
					if (dueDateComparsion < 0
					    || (dueDateComparsion == 0 && items[j].getDescription()
					        .compareToIgnoreCase(items[minIndex].getDescription()) < 0))
						minIndex = j;
				}
			}
			if (minIndex != i) {
				Item temp = items[minIndex];
				items[minIndex] = items[i];
				items[i] = temp;
			}
		}
	}
}
