package uebung8.question2;

import java.util.Random;

public class Employee {
	private static final double EPSILON = 0.005;
	private long employeeNum;
	private String firstName;
	private String lastName;
	private double salary;
	Employee next = null;
	Employee prev = null;

	public Employee(String firstName, String lastName, double salary) {
		this.employeeNum = (long) (new Random().nextDouble() * 8999999999d) + 1000000000;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public final String getFirstName() {
		return this.firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return this.lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final double getSalary() {
		return this.salary;
	}

	public final void setSalary(int salary) {
		this.salary = salary;
	}

	public final long getEmployeeNum() {
		return this.employeeNum;
	}

	@Override
	public String toString() {
		return "#" + this.employeeNum + ", " + this.firstName + " " + this.lastName
		    + " [salary=" + this.salary + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Employee employee = (Employee) obj;
		if (employee == null || employee.employeeNum != this.employeeNum
		    || !employee.firstName.equals(this.firstName)
		    || !employee.lastName.equals(this.lastName)
		    || Math.abs(employee.salary - this.salary) > EPSILON)
			return false;
		return true;
	}

	@Override
	protected Employee clone() {
		Employee clone = new Employee(this.firstName, this.lastName, this.salary);
		clone.employeeNum = this.employeeNum;
		return clone;
	}
}
