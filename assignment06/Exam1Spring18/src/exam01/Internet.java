package exam01;
import java.util.List;
import java.util.ArrayList;

public class Internet {
	private List<Website> sites;
	
	public Internet(List<Website> s){
        sites = s;
    }

	public void addSite(Website website){
        sites.add(website);
    }

	public List<Website> getSites() {
		return sites;
	}
	
	public boolean incPop(String urlstr, double fact){
        for (Website s : sites){
            if (s.getUrl().equals(urlstr)){
                s.incrPop(fact);
                return true;
            }
        }

        return false;
    }

    public int[] profile(){
        int[] array = new int[11];
        int idx =0;
        for (Website s : sites){
            idx = (int)s.getPop();
            array[idx]++;
        }

        return array;


    }

    protected void remSite(Website w){
        sites.remove(w);
    }
	
	
	
}
