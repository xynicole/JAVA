package lab02;

public class Library{

	public static void main(String[] args) {
		Book[] library = new Book[3];
		library[0] = new Book("The Hunger Games",5000);
		library[1] = new Book("Pride and Prejudice",2475);
		library[2] = new Book("Lord of the Flies",1500);

		for (int i=0; i<library.length; i++){
			 System.out.println(library[i].getTitle());
		}


		for (Book oneBook: library) {
	   		 System.out.println(oneBook.getNumPages());
		}


		System.out.println("I expect to get 8975 pages as the total pages");
		System.out.println ("Result: " + numPagesInLibrary(library));
		System.out.println("I expect to get 5000 pages as the most pages");
		System.out.println("Result: " + mostPages(library));
	}


	public static int numPagesInLibrary(Book[] books){
		int totalpage=0;
		for (Book oneBook : books){
			totalpage +=  oneBook.getNumPages();
		}
		return totalpage;
	}


	public static int mostPages(Book[] books){
		int mostPage=0;
		for (Book oneBook : books){
		 	if (oneBook.getNumPages() > mostPage){
				mostPage = oneBook.getNumPages();
			}
		}
		return mostPage;
	}

}
