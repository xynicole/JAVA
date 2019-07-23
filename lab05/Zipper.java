package lab05;


public class Zipper{
	public static int[] zip(int[] arr1,int[] arr2){
		try{
			if(arr1.length==arr2.length){
				
				if(arr1.length==0){
                	int[] mix = new int[0];
                	return mix;
				}
    		
				int[] mix = new int[arr1.length *2];
				
	// position0=arr1,position1=arr2, position2=arr1, position3=arr3  position increased by 2
				
                int pos=0;
                for(int i=0; i<arr1.length; i++){
                    mix[pos] = arr1[i];
                    pos+=2;
                }
                pos=1;
                for(int i=0; i<arr2.length; i++){
                    mix[pos] = arr2[i];
                    pos+=2;
                }
                
				return mix ;
				
				
			}else{
				throw new IllegalArgumentException("bad input");
				
			}
			
		}catch(NullPointerException e){
			throw new IllegalArgumentException("bad input");
		}
	}
}