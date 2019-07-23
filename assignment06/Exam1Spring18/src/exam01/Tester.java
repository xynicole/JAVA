package exam01;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args){
		System.out.println (" ======test website======");
        Website website = new Website("google.com", 1.0);
        website.incrPop(2.0);

        System.out.println("Expecting: 2.0");
        System.out.println("Received: " + website.getPop());

        System.out.println("toString : " + website);
        
        
        System.out.println (" ======test internet======");
        Website w1 = new Website("google.com", 2.0);
        Website w2 = new Website("facebook.com", 1.0);
        
        ArrayList<Website> websites = new ArrayList<>();
        websites.add(w1);
        websites.add(w2);
    
        Internet internet = new Internet(websites);

        for (Website w : internet.getSites()){
            System.out.println(w);
        }
        int[] IP = internet.profile();

        for (int netP : IP){
            System.out.print(netP+ " ");
        }
        System.out.println();
        
        internet.incPop("google.com", 2.0);

        
        for (Website w : internet.getSites()){
            System.out.println(w);
        }
        
        IP = internet.profile();

        for (int internetProfile : IP){
            System.out.print(internetProfile +" ");
        }
        System.out.println();
       
        
        System.out.println (" ======test snobby======");
        SnobbyInternet net = new SnobbyInternet(websites, 6.0);
        net.Trim();

        for (Website w : net.getSites()){
            System.out.println(w);
        }

        IP = net.profile();
        for (int internetProfile : IP){
        	System.out.print(internetProfile +" ");
        }
        System.out.println();
	
	
	
	
	}
        
        
   


}
