package lab08;

public class Bonus {
	
	public static void main(String[] args) {
		printPascalsTriangle(5);
	}
	
	public static void printPascalsTriangle(int limit) {
		printPascalsHelper(limit, 0, 0);
	
	}
	
	private static void printPascalsHelper(int limit, int n, int k) {
		

		if(n<= limit) {
			if (n==k) {
				System.out.print(Recursion.binomialCoefficient(n, k) + "\n");
				printPascalsHelper(limit,n+1,0);
			}
			if(k<n) {
				System.out.print(Recursion.binomialCoefficient(n, k) + " ");
				printPascalsHelper(limit,n,k+1);
			}
		
		}
		
		
	}
}
	
	
	
		/*for(n =0; n <= limit; n++) {
			for(k = n; k > -1; k--)
				System.out.print(Recursion.binomialCoefficient(n, k) + " ");
				System.out.print("\n");
			}
		}
		
	}*/
		
	
		
	


