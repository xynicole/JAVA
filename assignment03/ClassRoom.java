package assignment03;
import java.util.List;
import java.util.ArrayList;


public class ClassRoom{
	private  List<Student> roster = new ArrayList<>();

	public List<Student> getRoster(){
		return roster; 
	}

	public void addStudent(Student s) {
		roster.add(s);
	}

	public void dropStudent(String bnum){
		for (int k =roster.size()-1; k>=0; k--){
			if (roster.get(k).getBnumber().equals(bnum)){
				roster.remove(k);
			}
		}
	}

	public String toString(){
		return roster.toString();
	}

	public void sortById(){
		Student s = null;
		for (int i = 0; i<roster.size(); i++){
			for (int j=i+1; j<roster.size(); j++){
				if (Student.compareBnum(roster.get(j-1), roster.get(j)) > 0){
					s =roster.get(i);
					roster.set(i,roster.get(j));
					roster.set(j,s);
				}	
			}
		}


	}
	
	public void sortByName(){
		Student s = null;
		for (int i = 0; i<roster.size(); i++){
			for (int j=i+1; j<roster.size(); j++){
				if (Student.compareName(roster.get(j-1), roster.get(j)) > 0){
					s =roster.get(i);
					roster.set(i,roster.get(j));
					roster.set(j,s);
				}	
			}
		}


	}
}