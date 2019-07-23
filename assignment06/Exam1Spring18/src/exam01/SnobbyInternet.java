package exam01;

import java.util.List;
import java.util.ArrayList;

public class SnobbyInternet extends Internet {
	private double threshold;

	public SnobbyInternet(List<Website> s, double aThreshold) {
		super(s);
		threshold = aThreshold;
		
	}
	public void Trim(){
        List<Website> removeS = new ArrayList<>();
        for (Website web : super.getSites()){
            if (web.getPop() < threshold){
                removeS.add(web);
            }
        }

        for (Website w : removeS){
            super.remSite(w);
        }
    }
	
}
