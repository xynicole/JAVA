package assignment01;

public class HighSchoolStudent {
	private HighSchool highSchool;
	private Person person;

public HighSchoolStudent(HighSchool hs, Person ps){
	highSchool = hs;
	person = ps;
	person.getHistory()[0] = this;
}

public UniversityStudent goToUniversity(University univ){
	UniversityStudent us = new UniversityStudent(univ, person);
	return us;

}

public HighSchool getHighschool(){
	return highSchool;
}



	
}