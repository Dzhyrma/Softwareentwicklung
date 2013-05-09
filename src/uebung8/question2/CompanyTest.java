package uebung8.question2;


public class CompanyTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee a = new Employee("Lili", "Chuba", 300);
    Employee b = new Employee("Anda", "Monti", 400);
    Employee c = new Employee("Andrii", "Dzhyrma", 500);
    Employee d = new Employee("bla", "blala", -5);
    Employee e = new Employee("aaa", "aaaaaa", 10000);
    Company company = new Company();
		System.out.println(company);
    company.addEmployee(a);
    company.addEmployee(d);
    company.addEmployee(a);
    company.addEmployee(e);
    company.addEmployee(b);
    company.addEmployee(c);
    
    System.out.println(company.getEmployeeListWithSalaryGreaterThan(350, true));
    System.out.println(company.getEmployeeListWithSalaryGreaterThan(350, false));
       
    System.out.println(company);
    company.removeEmployee(a);
    System.out.println(company);
    
    
	}
}
