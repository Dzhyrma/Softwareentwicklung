package uebung8.question2a;

import java.util.Vector;

/** The class CompanyTest tests the class Company for errors.
 * 
 * @author Andrii Dzhyrma */
public class CompanyTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee1 = new Employee(null, null, 0);
		Employee employee2 = new Employee("John", "Smith", -100);
		Employee employee3 = new Employee("Michael", "Smith", 500);
		Employee employee4 = new Employee("Andrii", "Dzhyrma", 3000);
		Employee employee5 = new Employee("Sarah", "Connor", 19999.99999);
		Employee employee6 = new Employee("John", "Connor", 1999.49999);
		Employee employee7 = new Employee("Anonymous", "Incognito", 999999999);
		Company company = new Company();
		System.out.println("==============company.toString()=======================================");
		System.out.println(company);
		System.out.println("==============company.toDescendingString()=============================");
		System.out.println(company.toDescendingString());
		System.out.println("==============company.addEmployee()====================================");
		addEmployee(company, null);
		addEmployee(company, employee1);
		addEmployee(company, employee2);
		addEmployee(company, employee3);
		addEmployee(company, employee4);
		addEmployee(company, employee5);
		addEmployee(company, employee6);
		System.out.println("==============employee2.getEmployeeNum()===============================");
		System.out.println(employee2.getEmployeeNum());
		System.out.println("==============employee2.getFirstName()=================================");
		System.out.println(employee2.getFirstName());
		System.out.println("==============employee2.getLastName()==================================");
		System.out.println(employee2.getLastName());
		System.out.println("==============employee2.getSalary()====================================");
		System.out.println(employee2.getSalary());
		System.out.println("==============employee2.setSalary(100);company.addEmployee(employee2)==");
		employee2.setSalary(100);
		addEmployee(company, employee2);
		System.out.println("==============company.toString()=======================================");
		System.out.println(company);
		System.out.println("==============company.toDescendingString()=============================");
		System.out.println(company.toDescendingString());
		System.out.println("==============company.getEmployeeListWithSalaryGreaterThan(1000, true)=");
		getEmployeeListWithSalaryGreaterThan(company, 1000, true);
		System.out.println("==============company.getEmployeeListWithSalaryGreaterThan(1000, false)");
		getEmployeeListWithSalaryGreaterThan(company, 1000, false);
		System.out.println("==============company.getEmployeeListWithSalaryGreaterThan(-100, true)=");
		getEmployeeListWithSalaryGreaterThan(company, -100, true);
		System.out.println("==============company.getEmployees()===================================");
		getEmployees(company, "Dzhyrma");
		getEmployees(company, "Connor");
		getEmployees(company, "");
		getEmployees(company, null);
		System.out.println("==============company.removeEmployee()=================================");
		removeEmployee(company, employee7);
		removeEmployee(company, employee1);
		removeEmployee(company, employee3);
		removeEmployee(company, employee3);
		removeEmployee(company, null);
	}

	private static void addEmployee(Company company, Employee employee) {
		if (company != null && company.addEmployee(employee))
			System.out.println("Employee [" + employee
			    + "] was successfully added to the company!");
		else
			System.out.println("Employee [" + employee
			    + "] was not added to the company!");
	}

	private static void getEmployeeListWithSalaryGreaterThan(Company company, double minSalary, boolean isAscendingOrder) {
		if (company != null) {
			Vector<Employee> result = company.getEmployeeListWithSalaryGreaterThan(minSalary, isAscendingOrder);
			System.out.println(result);
		}
	}
	
	private static void getEmployees(Company company, String lastName) {
		if (company != null) {
			Vector<Employee> result = company.getEmployees(lastName);
			System.out.println("getEmployees for the last name '" + lastName + "' returned the next result:");
			System.out.println(result);
		}
	}
	
	private static void removeEmployee(Company company, Employee employee) {
		if (company != null && company.removeEmployee(employee))
			System.out.println("Employee [" + employee
			    + "] was successfully removed from the company!");
		else
			System.out.println("Employee [" + employee
			    + "] was not removed from the company!");
	}
}
