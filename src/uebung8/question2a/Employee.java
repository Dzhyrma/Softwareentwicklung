package uebung8.question2a;

import java.util.Random;

/** The class Employee stores and manages the data about an employee.
 * 
 * @author Andrii Dzhyrma */
public class Employee {

	// Private Members ///////////////////////////////////////////////////////////

	// Fields --------------------------------------------------------------------
	private long employeeNum;
	private String firstName;
	private String lastName;
	private double salary;

	// Public Members ////////////////////////////////////////////////////////////

	// Constructors --------------------------------------------------------------
	/** Initializes a Employee using his first name, last name and the salary.
	 * Generates a random employee number.
	 * 
	 * @param firstName - the first name
	 * @param lastName - the last name
	 * @param salary - the salary */
	public Employee(String firstName, String lastName, double salary) {
		this.employeeNum = (long) (new Random().nextDouble() * 8999999999d) + 1000000000;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = Math.round(salary * 100) / 100d;
	}

	// Methods -------------------------------------------------------------------
	/** @return the employee number */
	public final long getEmployeeNum() {
		return this.employeeNum;
	}

	/** @return the first name of the employee */
	public final String getFirstName() {
		return this.firstName;
	}

	/** @return the last name of the employee */
	public final String getLastName() {
		return this.lastName;
	}

	/** @return the salary of the employee */
	public final double getSalary() {
		return this.salary;
	}

	/** Sets a new first name for the employee.
	 * 
	 * @param firstName - the new first name */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Sets a new last name for the employee.
	 * 
	 * @param lastName - the new last name */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Sets a new salary for the employee.
	 * 
	 * @param salary - the new salary */
	public final void setSalary(int salary) {
		this.salary = salary;
	}

	/* Returns the string representation of the employee. */
	@Override
	public String toString() {
		return "#" + this.employeeNum + ", " + this.firstName + " " + this.lastName
		    + " [salary=" + this.salary + "]";
	}
}
