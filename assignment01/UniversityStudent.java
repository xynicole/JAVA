package assignment01;

public class UniversityStudent {
	private University university;
	private Person person;

	public UniversityStudent(University univer, Person ps) {
		university = univer;
		person = ps;
		person.getHistory()[1] = this;

	}

	public Employee getAJob(Company comp, double startingSalary) {
		Employee e = new Employee(comp, startingSalary, person);
		return e;

	}

	public University getUniversity() {
		return this.university;
	}
}