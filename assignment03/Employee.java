package assignment03;

public class Employee implements Occupation{
	private Company company;
	private double salary;
	private Person person;

	public void setSalary(double sala){
		salary = sala;
	}

	public Company getCompany(){
		return company;
	}

	public double getSalary(){
		return salary;
	}
	/*public Employee(Company com, Person ps) {
		company = com;
		person = ps;
		person.addOccupation(this);
	}*/
	
	public Employee(Company com, Double sal, Person ps){
		company = com;
		salary = sal;
		person = ps;
		person.addOccupation(this);
	}

	
	public void print() {
		
		System.out.format("\tJob at %s in %s, with a salary of %.2f\n",
				getCompany().getName(), getCompany().getCity(), getSalary());	
	}
	
	public Employee changeJob(Company emp, int sal) {
		return changeJob (emp,(double)sal);
	}
	
	public Employee changeJob(Company emp, Double sal) {
		return new Employee (emp,sal, this.person);
	}

}


