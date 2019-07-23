package exam01;

public class Website {

	private String url;
    private double pop;
    
    public Website(String aUrl, double aPop){        
        url = aUrl;
        pop = aPop;
    }

	public String getUrl() {
		return url;
	}

	public double getPop() {
		return pop;
	}
    
	@Override
	public String toString(){
		return url + "(" + pop + ")";
	}
    
	public void incrPop(double factor) throws IllegalArgumentException{
        if (factor < 0){
            throw new IllegalArgumentException("positive only");
        }

        pop *= factor;

        if (pop > 10){
            pop = 10;
        }
    }
}
