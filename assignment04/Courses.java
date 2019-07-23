package assignment04;
import java.util.Set;

public enum Courses {
	//DISCLAIMERS:
	//NOT ALL ELECTIVES ARE HERE
	//ALL MATH PREREQS ARE MISSING
	//CS301 PREREQS ARE MISSING A "C" GENED AND CS220 OR CS240
	//THE DESIGN OF THIS ENUM CANNOT HANDLE "corequisites" OR 
	//ALTERNATIVE PREREQS
	CS101(null), CS110(null), CS120(Set.of(CS110)), CS140(Set.of(CS110)), 
	CS220(Set.of(CS120,CS140)),	CS240(Set.of(CS120,CS140)), 
	CS301(Set.of(CS101)), CS320(Set.of(CS220)), 
	CS350(Set.of(CS220,CS240)), CS373(Set.of(CS140)), CS375(Set.of(CS240)), 
	CS471(Set.of(CS373,CS375)),	CS402(Set.of(CS220,CS240)), 
	CS426(Set.of(CS350)), CS428(Set.of(CS350)),	CS431(Set.of(CS428)), 
	CS432(Set.of(CS375)), CS435(Set.of(CS375)), CS436(Set.of(CS375)), 
	CS440(Set.of(CS240,CS350)),	CS442(Set.of(CS140,CS375)), 
	CS445(Set.of(CS375)),CS460(Set.of(CS375)), CS458(Set.of(CS350,CS375));
	
	
	private Set<Courses> prereqs;
	Courses(Set<Courses> set){
		prereqs = set;
	}
	public Set<Courses> getPrereqs() {
		return prereqs;
	}	
}