package assignment03;

public class UniversityStudent implements Occupation {
	private University university;
	private Person person;

	public UniversityStudent(University univer, Person ps) {
		university = univer;
		person = ps;
		person.addOccupation(this);

	}

	public Employee getAJob(Company comp, double startingSalary) {
		Employee e = new Employee(comp, startingSalary, person);
		return e;

	}

	public University getUniversity() {
		return this.university;
	}
	public void print() {
		System.out.println("\tuniversity: " + getUniversity().getName() + "in " + getUniversity().getCity());		
	}
	public UniversityStudent transferUniversity(University uni) {
		return new UniversityStudent(uni, this.person);
	}
}