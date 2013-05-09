package uebung7.question2;

import java.util.GregorianCalendar;

public class Main {
	private static final String GROUP_INSERTED_SUCCESFULLY_FORMAT_STRING = "Group \"%s\" has been inserted succesfully!%n";
	private static final String GROUP_INSERTION_FAILED_FORMAT_STRING = "Group \"%s\" insertion failed!%n";
	private static final String ITEM_INSERTED_SUCCESFULLY_FORMAT_STRING = "Item \"%s\" has been inserted succesfully!%n";
	private static final String ITEM_INSERTION_FAILED_FORMAT_STRING = "Item \"%s\" insertion failed!%n";

	private static void insertGroup(Group group, List list) {
		if (list.insertGroup(group))
			System.out.printf(GROUP_INSERTED_SUCCESFULLY_FORMAT_STRING,
			    (group == null) ? "with null value" : group.getName());
		else
			System.out.printf(GROUP_INSERTION_FAILED_FORMAT_STRING,
			    (group == null) ? "with null value" : group.getName());
	}

	private static void insertItem(Item item, Group group, List list) {
		if (list.insertItem(item, group))
			System.out.printf(ITEM_INSERTED_SUCCESFULLY_FORMAT_STRING,
			    (item == null) ? "with null value" : item.getDescription());
		else
			System.out.printf(ITEM_INSERTION_FAILED_FORMAT_STRING,
			    (item == null) ? "with null value" : item.getDescription());
	}

	/** @param args - no arguments will evaluate */
	public static void main(String[] args) {
		List list1 = new List();
		System.out.println("Printing an empty list (printAll):");
		list1.printAll();
		System.out.println("Printing an empty list (printInGroups):");
		list1.printInGroups();
		Group work = new Group("work", 1);
		System.out.println("Printing an empty group:");
		work.printAll();
		Group study = new Group("study", 2);
		Group shopping = new Group("shopping", 3);
		Item item1 = new Item("prepare exrcise",
		    new GregorianCalendar(2012, 10, 24));
		System.out.println("Printing an item:");
		item1.print();
		System.out.println();
		item1.finish();
		Item item2 = new Item("correct test", new GregorianCalendar(2012, 11, 01));
		Item item3 = new Item("read book JAVA 7", new GregorianCalendar(2012, 11,
		    24));
		Item item4 = new Item("buy milk", new GregorianCalendar(2012, 11, 24));
		Item item5 = new Item("fetch book", new GregorianCalendar(2012, 11, 24));
		item5.finish();
		insertGroup(work, list1);
		insertGroup(study, list1);
		insertGroup(shopping, list1);
		insertItem(item1, work, list1);
		insertItem(item2, work, list1);
		insertItem(item3, study, list1);
		insertItem(item4, shopping, list1);
		insertItem(item5, shopping, list1);

		List list2 = new List();
		Group group1 = new Group(null, -1);
		Group group2 = new Group("Group", 2);
		Group group3 = new Group("Group", 2);
		Group group4 = new Group("Group4", 3);
		Group group5 = new Group("Group5", 3);
		Item item6 = new Item(null, null);
		Item item7 = new Item("Item", null);
		Item item8 = new Item("Item", new GregorianCalendar(2012, 11, 24));
		Item item9 = new Item("Item", new GregorianCalendar(2012, 11, 24));
		Item item10 = new Item("Item10", new GregorianCalendar(2012, 12, 24));
		Item item11 = new Item("Item11", new GregorianCalendar(2013, 12, 24));
		Item item12 = new Item("Item12", new GregorianCalendar(2013, 12, 23));
		item8.start();
		item9.start();
		item9.finish();
		insertGroup(null, list2);
		insertGroup(group1, list2);
		insertGroup(group2, list2);
		insertGroup(group3, list2);
		insertGroup(group3, list2);
		insertGroup(work, list2);
		insertGroup(group4, list2);
		insertGroup(group5, list2);
		insertItem(null, null, list2);
		insertItem(null, group1, list2);
		insertItem(item6, null, list2);
		insertItem(item1, work, list2);
		insertItem(item6, work, list2);
		insertItem(item1, group1, list2);
		insertItem(item6, group1, list2);
		insertItem(item7, group1, list2);
		insertItem(item8, group1, list2);
		insertItem(item9, group1, list2);
		insertItem(item10, group1, list2);
		insertItem(item10, group2, list2);
		insertItem(item11, group2, list2);
		insertItem(item12, group2, list2);

		System.out.println("\nPrinting the list1 (printAll):");
		list1.printAll();
		System.out.println("\nPrinting the list1 (printInGroups):");
		list1.printInGroups();
		System.out.println("\nPrinting the list2 (printAll):");
		list2.printAll();
		System.out.println("\nPrinting the list2 (printInGroups):");
		list2.printInGroups();

		group1.sortByDueDate();
		System.out.println("\nPrinting the group sorted by dueDate:");
		group1.printAll();
		group1.sortByStatus();
		System.out.println("\nPrinting the group sorted by status:");
		group1.printAll();

	}

}
