package uebung8.question2;

public class Company {
	private Employee head = null;
	private Employee tail = null;

	public void addEmployee(Employee employee) {
		if (employee == null || employee.getSalary() < 0
		    || containsEmployee(employee))
			return;
		Employee clone = employee.clone();
		if (head == null) {
			this.head = tail = clone;
			clone.next = clone.prev = null;
			return;
		}
		Employee currentEmployee = this.head;
		while (currentEmployee != null
		    && currentEmployee.getEmployeeNum() < clone.getEmployeeNum())
			currentEmployee = currentEmployee.next;
		if (currentEmployee == null) {
			this.tail.next = clone;
			clone.next = null;
			clone.prev = this.tail;
			this.tail = clone;
		} else if (currentEmployee.prev == null) {
			this.head = clone;
			clone.next = currentEmployee;
			clone.prev = null;
			currentEmployee.prev = clone;
		} else {
			clone.prev = currentEmployee.prev;
			clone.next = currentEmployee;
			currentEmployee.prev = currentEmployee.prev.next = clone;
		}
	}

	public Employee getEmployee(String lastName) {
		Employee currentEmployee = this.head;
		while (currentEmployee != null
		    && currentEmployee.getLastName().compareToIgnoreCase(lastName) != 0)
			currentEmployee = currentEmployee.next;
		return currentEmployee.clone();
	}

	public boolean containsEmployee(Employee employee) {
		if (employee == null)
			return false;
		Employee currentEmployee = this.head;
		while (currentEmployee != null && !currentEmployee.equals(employee))
			currentEmployee = currentEmployee.next;
		return currentEmployee != null;
	}

	public void removeEmployee(Employee employee) {
		if (employee == null)
			return;
		Employee currentEmployee = this.head;
		while (currentEmployee != null && !currentEmployee.equals(employee))
			currentEmployee = currentEmployee.next;
		if (currentEmployee == null)
			return;
		if (currentEmployee.prev == null) {
			this.head = currentEmployee.next;
			this.head.prev = null;
			return;
		}
		if (currentEmployee.next == null) {
			this.tail = currentEmployee.prev;
			this.tail.next = null;
			return;
		}
		currentEmployee.prev.next = currentEmployee.next;
		currentEmployee.next.prev = currentEmployee.prev;
	}

	public String toDescendingString(boolean isAscending) {
		StringBuilder result = new StringBuilder();
		Employee currentEmployee = this.tail;
		while (currentEmployee != null) {
			result.append(currentEmployee.toString());
			result.append("\n");
			currentEmployee = currentEmployee.prev;
		}
		return result.toString();
	}

	public String getEmployeeListWithSalaryGreaterThan(double salary,
	    boolean isAscendingOrder) {
		StringBuilder result = new StringBuilder();
		Employee currentEmployee = isAscendingOrder ? this.head : this.tail;
		while (currentEmployee != null) {
			if (currentEmployee.getSalary() > salary) {
				result.append(currentEmployee.toString());
				result.append("\n");
			}
			currentEmployee = isAscendingOrder ? currentEmployee.next
			    : currentEmployee.prev;
		}
		return result.toString();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Employee currentEmployee = this.head;
		while (currentEmployee != null) {
			result.append(currentEmployee.toString());
			result.append("\n");
			currentEmployee = currentEmployee.next;
		}
		return result.toString();
	}
}
