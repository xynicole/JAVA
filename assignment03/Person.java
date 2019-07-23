package assignment03;

import java.time.LocalDate;
import java.util.*; 
import java.util.List; 
import java.util.Arrays;
import java.util.LinkedList;

public class Person{
	private String name;
	private LocalDate birthdate;
	private List<Occupation> history = new LinkedList<>();
	//private Object[]history = new Object[3];

	public Person(String aName, int day, int month, int year) {
		name = aName;
		birthdate = LocalDate.of(year, month, day);
	}
	public LocalDate getBirthdate( ) {
    	return birthdate;
	}

	/*
public void printHistory() {
	System.out.println("History of " + name);
	if(history[0] != null) {
		// in the next line we "cast" history[0] to a HighSchoolStudent object
		HighSchoolStudent hss = (HighSchoolStudent)history[0];
		// in the next line the char '\t' provides a tab indent
		System.out.println("\tHigh school: " + hss.getHighschool().getName());
	}
	if(history[1] != null) {
		UniversityStudent us =(UniversityStudent)history[1];

		System.out.println("\tuniversity: " + us.getUniversity().getName() + "in" + us.getUniversity().getCity());


		//Use the similar approach to "cast" history[1] to a UniversityStudent object.
		//From that object, the getUniversity method gives you the university and from that
		//the getter methods will give the name and city of the university.
		//In the System.out.println, start with "\tUniversity: " + followed by the name of the university
		//next comes + " in " + followed by the city where the university is located.
		//Example: 	University: Duke in Durham, NC
		}
	if(history[2] != null) {
		Employee e = (Employee)history[2];
		//we have not explained the format or printf methods that were in Lab 1, so
		//this is provided:
		System.out.format("\tJob at %s in %s, with a salary of %.2f\n",
			e.getCompany().getName(), e.getCompany().getCity(), e.getSalary());
	}

}
*/
	
	public void printHistory() {
		System.out.println("History of " + name);
		for(Occupation oc : history) {
			oc.print();			
		}		
	}
	public void addOccupation(Occupation occ) {
		history.add(occ);
	}



}
