package assignment03;

public class HighSchoolStudent implements Occupation { 
	private HighSchool highSchool;
	private Person person;

	public HighSchoolStudent(HighSchool hs, Person ps){
		highSchool = hs;
		person = ps;
		person.addOccupation(this);
	}

	public UniversityStudent goToUniversity(University univ){
		UniversityStudent us = new UniversityStudent(univ, person);
		return us;

	}

	public HighSchool getHighschool(){
		return highSchool;
	}

	public void print() {
		System.out.println("\tHigh school: " + getHighschool().getName());		
	}
	
	public HighSchoolStudent changeHighSchool(HighSchool sch) {
		return new HighSchoolStudent(sch, this.person);
	}
	
}