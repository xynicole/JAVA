package assignment02;

public class OneChange1{
	private int[] array;
	
	public OneChange1(int[] array1) {
		array = array1;
	}
	
	public int largestAfter(int start) {
		int index = start;
		
		for (int i=start; i< array.length; i++) {
			if (array[i]> array[index]) {
				
				index = i;
				
			}
		}
		return index; 
	}
	
	public int[] modify(int start) {
		int[] temp = new int[array.length];
		var k = largestAfter(start);
		
		for(int j=0; j< start; j++) {
			temp[j]= array[j];
		}
		
		temp[start] = array[k];
		
		for(int j = start;j<k;j++) {
			temp[j+1] = array[j];
		}
		
		for(int j = k+1;j<array.length;j++) {
            temp[j] = array[j];
		}  
		
		return temp;
	}
}
