package lab03;
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

	public void dropStudent(int id){
		for (int i =0; i<roster.size(); i++){
			if (id == roster.get(i).getId()){
				roster.remove(i);
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
				if (roster.get(i).getId() > roster.get(j).getId()){
					s =roster.get(i);
					roster.set(i,roster.get(j));
					roster.set(j,s);
				}	
			}
		}


	}
}