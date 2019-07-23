package assignment02;

public class OneChangeBook{
	private Book[] array;
	
	public OneChangeBook(Book[] array1) {
		array = array1;
	}
	
	public int smallestAfter(int start) {
		int index = start;
		
		for (int i=start; i< array.length; i++) {
			if (array[i].getNumPages()< array[index].getNumPages()) {
				
				index = i;
				
			}
		}
		return index; 
	}
	public Book[] modify(int start) {
		Book[] temp = new Book[array.length];
		var k = smallestAfter(start);
		
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