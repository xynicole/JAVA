package assignment04;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;



public class Student{
	 
	private String name;
	private Set<Courses> taken = new HashSet<>();
	
	
	public Student(String n) {
		name =n;
		
	}
	
	public String getName(){
		return name;
	}
	
	public Set<Courses> getTaken(){
		return taken;
	}
	
	public void addCourse(Courses crs) {
		taken.add(crs);
	}
	
	
	// gives a list of all the CS courses the student needs to take before taking courses crs
	public Set<Courses> needToTakeBefore(Courses crs) {
		Set<Courses> needed = new HashSet<>();// make a Set called needed (declated and instantiated the same as taken)
		needed.add(crs); // add crs to needed
		// this is like "bubble sort"
		
		boolean changed = true;// declare a boolean changed set to true
		while(changed) {
			changed =false;//set changed to false
			int temint = needed.size();//make a temporary int with the value needed.size();
			Set<Courses> temp = new HashSet<>();//make another Set called temp (just line needed)
			for(Courses d : needed) { //if the getPrereqs of d are not null, call
				if(d.getPrereqs() != null){
				temp.addAll(d.getPrereqs());
				}
			}
			needed.addAll(temp);//addAll of temp to needed
			if(needed.size() > temint) { //if the size if needed is now bigger than the values stored earlier
				changed = true;
			} //set changes to true;
		}
		
		//for each of the Courses in taken remove it using needed.remove(...);
		Iterator<Courses> iter=needed.iterator(); //You could alternatively use an iterator here, create an Iterator<Courses> iter of needed
		while(iter.hasNext()){//use a while loop, where the condition is iter.hasNext()
			if(taken.contains(iter.next())) {
				iter.remove();
				}
			
		}
		//and if taken.contains() a Courses gotten from iter.next(), then call remove on the iterator in such a case.
		
	    needed.remove(crs);
		//remove crs form needed
		return needed;
	}	
	
	public static void main(String[] args) {
		
		Student student = new Student("student");
		student.addCourse(Courses.CS140);
		Courses.CS140.getPrereqs();
		System.out.println(student.needToTakeBefore(Courses.CS140));



	}
}
