package lab05;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Division{
	
	private ArrayList<Double> list = new ArrayList<Double>();

	public Division(double[] array){
		
		try{
			
			if(array.length>0){
                for(int i=0; i<array.length; i++){
				    list.add(array[i]);
			    }
                
            }else{
                throw new IllegalArgumentException("need to enter an array with at least one double");
            }
			
		}catch(NullPointerException e){
			throw new IllegalArgumentException("need to enter an array with at least one double");
		}
	}

	public void removeZeroes(){
		Iterator<Double> iter = list.iterator();
		
		while(iter.hasNext()) {
           Double i = iter.next();
           if(i == 0) iter.remove();
        }
	}

	public void divide(int divisor){

		if(divisor!=0){
            for(int i=0; i<list.size(); i++){
				list.set(i, list.get(i)/divisor);
			}
        }else{
            throw new IllegalArgumentException("cannot divide by zero");
        }
	}

	public String toString(){
		return list.toString();
	}
}
