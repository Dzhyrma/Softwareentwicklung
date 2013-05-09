package uebung8.question2a;

import java.util.Vector;

/** The class Company gives methods to add, remove and to search employees or to
 * print list of added employees.
 * 
 * @author Andrii Dzhyrma */
public class Company {

	// Private Members ///////////////////////////////////////////////////////////

	// Fields --------------------------------------------------------------------
	// double linked list of the employees
	private final EmployeeList list;

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** Initializes a Company object. */
	public Company() {
		list = new EmployeeList();
	}

	// Methods -------------------------------------------------------------------
	/** Adds a new employee to the list of employees in the company.
	 * 
	 * @param employee - the employee to be added
	 * @return true if the employee was added successfully */
	public boolean addEmployee(Employee employee) {
		// check whether the new employee is correct and not consists in the list of
		// all employees
		if (employee == null || employee.getSalary() < 0
		    || employee.getFirstName() == null || employee.getLastName() == null
		    || containsEmployee(employee))
			return false;
		// create a new employee node for the list
		EmployeeNode employeeNode = new EmployeeNode(employee);
		// if the list is empty
		if (this.list.head == null) {
			this.list.head = this.list.tail = employeeNode;
			return true;
		}
		// search for the right place in the list
		EmployeeNode currentEmployeeNode = this.list.head;
		while (currentEmployeeNode != null
		    && currentEmployeeNode.employee.getEmployeeNum() < employee
		        .getEmployeeNum())
			currentEmployeeNode = currentEmployeeNode.next;
		// we reached the tail position
		if (currentEmployeeNode == null) {
			this.list.tail.next = employeeNode;
			employeeNode.next = null;
			employeeNode.prev = this.list.tail;
			this.list.tail = employeeNode;
			// we stopped on the head position
		} else if (currentEmployeeNode.prev == null) {
			this.list.head = employeeNode;
			employeeNode.next = currentEmployeeNode;
			employeeNode.prev = null;
			currentEmployeeNode.prev = employeeNode;
			// somewhere in the middle of the list
		} else {
			employeeNode.prev = currentEmployeeNode.prev;
			employeeNode.next = currentEmployeeNode;
			currentEmployeeNode.prev = currentEmployeeNode.prev.next = employeeNode;
		}
		return true;
	}

	/** Checks if the given employee is in the list.
	 * 
	 * @param employee - the employee
	 * @return true if the list contains the given employee */
	public boolean containsEmployee(Employee employee) {
		// check for the correct employee
		if (employee == null)
			return false;
		// search for it
		EmployeeNode currentEmployeeNode = this.list.head;
		while (currentEmployeeNode != null
		    && currentEmployeeNode.employee != employee)
			currentEmployeeNode = currentEmployeeNode.next;
		// return true if we did not reach the tail
		return currentEmployeeNode != null;
	}

	/** Returns a list of employees with the salary greater than given in the
	 * represented order.
	 * 
	 * @param salary - the minimal salary
	 * @param isAscendingOrder - the given order (true for an ascending, false for
	 *          a descending)
	 * @return the vector of employees found in the given order */
	public Vector<Employee> getEmployeeListWithSalaryGreaterThan(double salary,
	    boolean isAscendingOrder) {
		// create the resulted variable
		Vector<Employee> employees = new Vector<Employee>();
		// search for the employees
		EmployeeNode currentEmployeeNode = isAscendingOrder ? this.list.head
		    : this.list.tail;
		while (currentEmployeeNode != null) {
			if (currentEmployeeNode.employee.getSalary() > salary)
				// add a found employee to the resulted vector
				employees.add(currentEmployeeNode.employee);
			currentEmployeeNode = isAscendingOrder ? currentEmployeeNode.next
			    : currentEmployeeNode.prev;
		}
		return employees;
	}

	/** Returns a list of employees with the given last name..
	 * 
	 * @param lastName - the last name to search for
	 * @return the vector of employees found */
	public Vector<Employee> getEmployees(String lastName) {
		// create the resulted variable
		Vector<Employee> employees = new Vector<Employee>();
		// check for the correct last name
		if (lastName == null)
			return employees;
		// search for the all employees with the given last name
		EmployeeNode currentEmployeeNode = this.list.head;
		while (currentEmployeeNode != null) {
			String employeeLastName = currentEmployeeNode.employee.getLastName();
			if (employeeLastName != null
			    && employeeLastName.compareToIgnoreCase(lastName) == 0)
				// add the found employee to the vector
				employees.add(currentEmployeeNode.employee);
			currentEmployeeNode = currentEmployeeNode.next;
		}
		return employees;
	}

	/** Removes the given employee from the list.
	 * 
	 * @param employee - the employee
	 * @return true if the employee was successfully removed */
	public boolean removeEmployee(Employee employee) {
		// check for the correct employee
		if (employee == null)
			return false;
		// search for it in the list
		EmployeeNode currentEmployeeNode = this.list.head;
		while (currentEmployeeNode != null
		    && currentEmployeeNode.employee != employee)
			currentEmployeeNode = currentEmployeeNode.next;
		// did not find it
		if (currentEmployeeNode == null)
			return false;
		// found it in the head
		if (currentEmployeeNode.prev == null) {
			this.list.head = currentEmployeeNode.next;
			this.list.head.prev = null;
			return true;
		}
		// found it in the tail
		if (currentEmployeeNode.next == null) {
			this.list.tail = currentEmployeeNode.prev;
			this.list.tail.next = null;
			return true;
		}
		// found it somewhere in the list
		currentEmployeeNode.prev.next = currentEmployeeNode.next;
		currentEmployeeNode.next.prev = currentEmployeeNode.prev;
		return true;
	}

	/** Returns the list of employees sorted by the descending order.
	 * 
	 * @return the sorted list represented as a String variable */
	public String toDescendingString() {
		// create the resulted string
		StringBuilder result = new StringBuilder();
		// go through the list and add their toString() result to the our resulted
		// string
		EmployeeNode currentEmployeeNode = this.list.tail;
		while (currentEmployeeNode != null) {
			result.append(currentEmployeeNode.employee);
			result.append("\n");
			currentEmployeeNode = currentEmployeeNode.prev;
		}
		if (result.length() == 0)
			return "The list with employees is empty.";
		return result.toString();
	}

	/* Returns the list of employees sorted by the ascending order. */
	@Override
	public String toString() {
		// create the resulted string
		StringBuilder result = new StringBuilder();
		// go through the list and add their toString() result to the our resulted
		// string
		EmployeeNode currentEmployeeNode = this.list.head;
		while (currentEmployeeNode != null) {
			result.append(currentEmployeeNode.employee);
			result.append("\n");
			currentEmployeeNode = currentEmployeeNode.next;
		}
		if (result.length() == 0)
			return "The list with employees is empty.";
		return result.toString();
	}
}
