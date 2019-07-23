package assignment03;

public class Student{
	private String bnumber;
	private String lastname;
	private String firstname;
	
	
	
	private String normalize(String input) {
		input = input.toLowerCase();
		input = Character.toUpperCase(input.charAt(0))+ 
				 input.substring(1);
		return input;
		
	}
	


	//Value constructor used to create a Student object
	public Student(String bnumber, String lastname, String firstname){
		this.lastname = normalize(lastname);
		this.firstname = normalize(firstname);
		this.bnumber = normalize(bnumber);
		
	}

	//returns id of the student
	public String getBnumber(){
		return this.bnumber;
	}

	//returns name of the student
	public String getName(){
		String name = lastname + "," + firstname;
		return name;
		
	}
	public static int compareBnum(Student s1, Student s2) {
		return s1.bnumber.compareTo(s2.bnumber);
	}
	
	public static int compareName(Student s1, Student s2) {
		//compare lastname then firstname then bnumber
		int revalue;
		revalue = s1.lastname.compareTo(s2.lastname);
		
		if(!(revalue ==0)) {
			return revalue;
		}else{
			revalue = s1.firstname.compareTo(s2.firstname);
			if(!(revalue ==0)) {
				return revalue;
			}else{
					
				return  s1.bnumber.compareTo(s2.bnumber);
			}
		}	
	}
	//printing a Student object, print's their name
	public String toString(){
		String name = lastname + "," + firstname;
		return name;
	}
}