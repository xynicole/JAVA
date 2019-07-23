package lab05;
import java.util.List;

public class FunWithStrings{
	public static void swapMaxes(List<String> list1, List<String> list2){
	
		try{
			if(list1.size() > 0 && list2.size() > 0) {
				int ind1=0;
				int ind2=0;
				String lst1=null;
				String lst2 =null;
				
				for(int i=0; i<list1.size(); i++){
					if(list1.get(i)!=null) {
						if(list1.get(ind1).length() < list1.get(i).length()) {
							ind1 =i;
							
						}
						
					}
				}
				
				for(int i=0 ; i<list2.size() ; i++){
					if(list2.get(i)!=null) {
				
						if(list2.get(ind2).length() < list2.get(i).length()){
							ind2 =i;
						
						}
					}
				}
				lst1 = list1.get(ind1);
				lst2 = list2.get(ind2);
				list1.set(ind1, lst2);
				list2.set(ind2, lst1);
			
			
	            
	        }else{
	            throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");
	        }
	        
			
		}catch(NullPointerException e){
			throw new IllegalArgumentException("cannot swap maxes of empty lists, null lists, or lists with all null elements");
		}
		}
		
}