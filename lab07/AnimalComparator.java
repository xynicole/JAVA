package lab07;
import java.util.Comparator;
import java.util.ArrayList;

public class AnimalComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal a, Animal b){
		String aPrey = "";
		String bPrey = "";
		
		if(a instanceof Carnivore) aPrey = ((Carnivore)a).getPrey();
		if(b instanceof Carnivore) bPrey = ((Carnivore)b).getPrey();
		
		if(aPrey.length()==0 && bPrey.length()==0 ) {
			return ((Herbivore)a).getAgressionLevel() - ((Herbivore)b).getAgressionLevel();
		}
		
		if(a.getAnimalName().equals(bPrey)) {
			return -1;
		}
		if(b.getAnimalName().equals(aPrey)) {
			return 1;
		}
		 
		if(aPrey.length() !=0 && bPrey.length() !=0) {
			 return ((Carnivore)a).getPredatoryLevel() - ((Carnivore)b).getPredatoryLevel();
		 }
		
		return aPrey.length() - bPrey.length();
	}
	
	
	public void sortAnimals(ArrayList<Animal> list) {
		Animal temp;
        for (int i = 1; i < list.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(compare(list.get(j),list.get(j-1))<0){
                    temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                }
            }
        }
	}
	
	
	
	public static int staticCompare(Animal a, Animal b){
		return new AnimalComparator().compare(a, b);
	}
	
	public static void staticSortAnimals(ArrayList<Animal> list){
		new AnimalComparator().sortAnimals(list);
	}
	
	
	
	
	
	
	
}
