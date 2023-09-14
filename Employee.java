package MainPackage;

public abstract class Employee extends User {
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(String id, String name, String surname, String password, double salary) {
		super(id, name, surname,password);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + " " + ", salary =" + salary + "]";
	}

	
	
}
