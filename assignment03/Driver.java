package assignment03;

public class Driver {

	public static void main(String[] args) {
		Person person1 = new Person("Bob", 05, 04, 1998);
		Person person2 = new Person("Amy", 07, 03, 1999);
		Person person3 = new Person("John", 06, 05, 2000);
		Person person4 = new Person("Sunny", 04, 07, 1997);
		Person person5 = new Person("Jack", 01, 02, 2001);

		HighSchool highschool1 = new HighSchool("Maine-Endwell");
		HighSchool highschool2 = new HighSchool("Kearney");
		HighSchool highschool3 = new HighSchool("Midwood");

		HighSchoolStudent highschoolstudent1 = new HighSchoolStudent(highschool1, person1);
		HighSchoolStudent highschoolstudent2 = new HighSchoolStudent(highschool2, person2);
		HighSchoolStudent highschoolstudent3 = new HighSchoolStudent(highschool3, person3);
		HighSchoolStudent highschoolstudent4 = new HighSchoolStudent(highschool2, person5);
		highschoolstudent4.changeHighSchool(highschool3);
		
		University university1 = new University("Duke ", " Durham, NC");
		University university2 = new University("Binghamton ", " Binghamton, NY");

		UniversityStudent universitystudent1 = highschoolstudent1.goToUniversity(university1);
		UniversityStudent universitystudent2 = highschoolstudent2.goToUniversity(university2);
		UniversityStudent universitystudent4 = highschoolstudent4.goToUniversity(university2);
		universitystudent4.transferUniversity(university1);
		
		Company company1 = new Company("Google", "CA");
		Company company2 = new Company("Apple", "CA");
		Employee employee1 = universitystudent1.getAJob(company1, 230000);
		Employee employee4 = universitystudent4.getAJob(company2, 200000);
		employee4.changeJob(company1, 230000);
		
		person1.printHistory();
		System.out.println("---------------------");

		person2.printHistory();
		System.out.println("---------------------");

		person3.printHistory();
		System.out.println("---------------------");

		person4.printHistory();
		System.out.println("---------------------");

		person5.printHistory();
		System.out.println("---------------------");
		
	}

}
