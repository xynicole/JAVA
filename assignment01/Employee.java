package assignment01;

public class Employee {
	private Company company;
	private double salary;
	private Person person;

public void setSalary(double sala){
     salary = sala;

}

public Employee(Company com, Double sal, Person ps){
	company = com;
	salary = sal;
	person = ps;
	person.getHistory()[2] = this;
}

public Company getCompany(){
	return company;
}

public double getSalary(){
	return salary;
}


}


