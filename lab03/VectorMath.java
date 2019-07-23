package lab03;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VectorMath{

	//returns the magnitude of vector
	public static Optional<Double> magnitude(List<Double> vect){
		 
		if(vect == null){
			return Optional.empty();
		}
		
		int size = vect.size();
		double sum = 0;
		double result = 0;
		if(size == 0){
			return Optional.of(0.0);
		}
		else{
			for(int j = 0; j < size; j++){
				sum = sum + vect.get(j)*vect.get(j);
			}
			result = Math.sqrt(sum);
			return Optional.of(result);
		}
	}

	//multiplies vect by some scalar value
	//actually modifies the vector, does not return a separate one
	public static void scalarProduct(List<Double> vect, double scale){
		 
		if(vect == null){
			return;
		}
		
		int size = vect.size();
		if(vect != null){
			if(size != 0){
				for(int j = 0; j < size; j++){
					double value = vect.get(j)*scale;
					vect.set(j , value);
				}
			}
		}
	}

	//returns the dotProduct between two vectors
	public static Optional<Double> dotProduct(List<Double> vect1, List<Double> vect2){
		
		if(vect1 == null || vect2 == null){
			return Optional.empty();
		}
		
	
		int size1 = vect1.size();
		int size2 = vect2.size();
		double result = 0.0;
		
		if(size1 == 0 || size2 == 0){
			return Optional.of(0.0);
		}
		else{
			for(int j = 0; j < Math.min(size1, size2); j++){
				result += vect1.get(j)*vect2.get(j);
			}
		}
		return Optional.of(result);
	}

	//returns whether two vectors are orthogonal
	public static boolean isOrthogonal(List<Double> vect1, List<Double> vect2){
		
		if(vect1 == null || vect2 == null){
			return false;
		}
		
		if(dotProduct(vect1, vect2).get() != 0){
				return false;
		}else{
			return true;
		}
	}

	//performs vector addition, returning a new vector
	public static Optional<List<Double>> vectorAddition(List<Double> vect1, List<Double> vect2){
		
		if(vect1 == null || vect2 == null){
			return Optional.empty();
		}
		
		
		int size1 = vect1.size();
		int size2 = vect2.size();
		
		List<Double> returnCopy = new ArrayList<>();
		
		
		
		if(size1 == 0){
			
			for(int j = 0; j < size2; j++){
				returnCopy.add(vect2.get(j));
			}
			return Optional.of(returnCopy);
		}
		if(size2 == 0){
			
			for(int j = 0; j < size1; j++){
				returnCopy.add(vect1.get(j));
			}
			return Optional.of(returnCopy);
		}
		
		
		
		
		if(size1 >= size2){
			for(int j = 0; j <= size2-1; j++){
				returnCopy.add(vect1.get(j) + vect2.get(j));
			}
			for(int j = size2; j <= size1-1; j++){
				returnCopy.add(vect1.get(j));
			}
		}
		
		
		if(size1 < size2){
			for(int j = 0; j < size1; j++){
				returnCopy.add(vect1.get(j) + vect2.get(j));
			}
			for(int j = size1; j < size2; j++){
				returnCopy.add(vect2.get(j));
			}
		}
		
		
		return Optional.of(returnCopy);
	}
}