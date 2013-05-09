package uebung7.question2;

/** The class List allows to store and maintain groups and items.
 * 
 * @author Andrii Dzhyrma */
public class List {

	// Private Members ///////////////////////////////////////////////////////////

	// Constants -----------------------------------------------------------------
	private static final String PRINT_FORMAT_STRING = "%nList #%d";
	private static final String NO_ITEMS_ERRORS_STRING = "There are no items in this list.";
	private static final String NO_GROUPS_ERRORS_STRING = "There are no groups in this list.";
	private static final int MAX_GROUPS = 4;
	private static final int MAX_ITEMS = 6;

	// Static Fields -------------------------------------------------------------
	private static int currentId = 1;

	// Fields --------------------------------------------------------------------
	private final Group[] groups = new Group[MAX_GROUPS];
	private final Item[] items = new Item[MAX_ITEMS];
	private int groupsSize = 0;
	private int itemsSize = 0;
	private int id;

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** This constructor initializes and generates id for the object. */
	public List() {
		id = currentId++;
	}

	// Methods -------------------------------------------------------------------
	/** Inserts a group into the array named groups of a list if not already
	 * present in the list. Groups will be sorted according to their priority
	 * (starting with 1) and their name.
	 * 
	 * @param group - the group to be added
	 * @return In case no insertion can be made false should be returned,
	 *         otherwise true. */
	public boolean insertGroup(Group group) {
		// if a reference of the group is equal to null, or it has some items in the
		// array (means that this grouped already used in an other list), or the
		// size of the current array of groups is maximal, then return false.
		if (group == null || !group.isEmpty() || groupsSize == MAX_GROUPS)
			return false;
		// insert the group into the correspondent place in the array to keep it
		// sorted
		int index = 0;
		for (; index < groupsSize
		    && (groups[index].getPriority() < group.getPriority() || (groups[index]
		        .getPriority() == group.getPriority() && groups[index].getName()
		        .compareToIgnoreCase(group.getName()) <= 0)); index++)
			// return false if this group already exists
			if (groups[index] == group)
				return false;
		// shift groups from the right side by one
		for (int i = groupsSize++; i > index; i--)
			groups[i] = groups[i - 1];
		// insert the input group to the space created
		groups[index] = group;
		return true;
	}

	/** Inserts an item into the list and into the according existing group within
	 * the list if and only if the item is not yet contained within the list and
	 * the specified group exists. The items of a list will be ordered by due
	 * date, then status and then name.
	 * 
	 * @param item - the item to be added
	 * @param group - the group in which item should be inserted
	 * @return In case no insertion can be made false should be returned,
	 *         otherwise true. */
	public boolean insertItem(Item item, Group group) {
		// if a reference of the input item is equal to null, or the item already
		// belongs to some group, or a reference to the group is equal to null, or
		// the group is full, or the current array of items is full, than return
		// false
		if (item == null || item.getBelongTo() != null || group == null
		    || group.isFull() || itemsSize == MAX_ITEMS)
			return false;
		// find an index of the group to be inserted to
		int groupIndex = 0;
		for (; groupIndex < groupsSize && groups[groupIndex] != group; groupIndex++)
			;
		// if this group was not found in the list, return false
		if (groupIndex == groupsSize)
			return false;

		// find a corresponded place for the item due to order
		int index = 0;
		for (; index < itemsSize
		    && (items[index].getDueDate().before(item.getDueDate()) || (items[index]
		        .getDueDate().compareTo(item.getDueDate()) == 0 && (items[index]
		        .getStatus() < item.getStatus() || (items[index].getStatus() == item
		        .getStatus() && items[index].getDescription().compareToIgnoreCase(
		        item.getDescription()) <= 0)))); index++)
			// if this item already in the list, return false
			if (items[index] == item)
				return false;

		// insert the item into the group. Return false if it was not inserted
		if (!group.insert(item))
			return false;

		// shift all items from the right side by one and insert our input item
		for (int i = itemsSize++; i > index; i--)
			items[i] = items[i - 1];
		items[index] = item;
		return true;
	}

	/** Prints the items of the list according to the order of items. */
	public void printAll() {
		if (itemsSize == 0) {
			System.out.println(NO_ITEMS_ERRORS_STRING);
			return;
		}
		for (int i = 0; i < itemsSize; i++)
			items[i].print();
	}

	/** Prints the items of the list by group according to the order of groups and
	 * items therein. */
	public void printInGroups() {
		if (groupsSize == 0) {
			System.out.println(NO_GROUPS_ERRORS_STRING);
			return;
		}
		for (int i = 0; i < groupsSize; i++) {
			System.out.println();
			groups[i].printAll();
		}
	}

	/** Prints the list identification number and items of the list by group
	 * according to the order of groups and items therein. */
	public void print() {
		System.out.printf(PRINT_FORMAT_STRING, id);
		printInGroups();
	}
}
