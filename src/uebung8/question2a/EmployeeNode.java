package uebung8.question2a;

/** The class EmployeeNode represents a node for the double linked list with
 * references for the next and the previous nodes and the data variable.
 * 
 * @author Andrii Dzhyrma */
public class EmployeeNode {
	final Employee employee;
	EmployeeNode next, prev;

	/** Initializes a EmployeeNode with the given Employee object.
	 * 
	 * @param employee - the employee */
	public EmployeeNode(Employee employee) {
		this.employee = employee;
	}
}