package exam01;

public class Pagination {
	private int numPages;
    private int numChapters;
    private int[] chapStarts; //page # starts
    private int[] chapAssigned; //0 ,1
    
    public Pagination(int np, int nc){
        numPages= np;
        numChapters =nc;
        chapStarts = new int[numChapters + 1];
        chapAssigned = new int[numChapters + 1];
    }
    
    public void setChapStartPage(int n, int p){
        chapStarts[n] = p;
    }

    public void assign(int n){
        chapAssigned[n] = 1;
    }
    
    public int totalRead(){
        int totalPg = 0;
        for (int i = 1; i < numChapters; i++){
            if (chapAssigned[i] == 1){
                totalPg += (chapStarts[i + 1] - chapStarts[i]);
            }
        }

        if (chapAssigned[numChapters] == 1){
            totalPg += (numPages - chapStarts[numChapters] + 1);
        }

        return totalPg;
    }
    
    public static void main(String[] args){
        Pagination pagination = new Pagination(158, 4);

        pagination.setChapStartPage(1, 1);
        pagination.setChapStartPage(2, 55);
        pagination.setChapStartPage(3, 89);
        pagination.setChapStartPage(4, 128);
        pagination.assign(2);
        pagination.assign(4);
        System.out.println("expecting: 65");
        System.out.println("received: "+pagination.totalRead());
    }

    
    
}
