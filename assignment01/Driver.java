package assignment01;

public class Driver {

	public static void main(String[] args) {
		Person person1 = new Person("Bob", 05, 04, 1998);
		Person person2 = new Person("Amy", 07, 03, 1999);
		Person person3 = new Person("John", 06, 05, 2000);
		Person person4 = new Person("Sunny", 04, 07, 19997);

		HighSchool highschool1 = new HighSchool("Maine-Endwell");
		HighSchool highschool2 = new HighSchool("Kearney");
		HighSchool highschool3 = new HighSchool("Midwood");

		HighSchoolStudent highschoolstudent1 = new HighSchoolStudent(highschool1, person1);
		HighSchoolStudent highschoolstudent2 = new HighSchoolStudent(highschool2, person2);
		HighSchoolStudent highschoolstudent3 = new HighSchoolStudent(highschool3, person3);

		University university1 = new University("Duke ", " Durham, NC");
		University university2 = new University("Binghamton ", " Binghamton, NY");

		UniversityStudent universitystudent1 = highschoolstudent1.goToUniversity(university1);
		UniversityStudent universitystudent2 = highschoolstudent2.goToUniversity(university2);

		Company company1 = new Company("Google", "CA");
		Employee employee = universitystudent1.getAJob(company1, 230000);

		person1.printHistory();
		System.out.println("---------------------");

		person2.printHistory();
		System.out.println("---------------------");

		person3.printHistory();
		System.out.println("---------------------");

		person4.printHistory();
		System.out.println("---------------------");

	}

}
