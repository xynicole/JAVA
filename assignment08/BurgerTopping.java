package assignment08;

public class BurgerTopping extends BurgerAbstraction {

	public BurgerTopping(BurgerNaming name, BurgerAbstraction next) {
		super(name, next);
		
	}
	
	@Override
	public int getTotalCalories() {
		
		return getCalories() + getNext().getTotalCalories();
	}
	
	@Override
	public double getTotalCost() {
		return getPrice() + getNext().getTotalCost();
		
	}

	@Override
	protected int toppingsCount() {
		return getNext().toppingsCount()+1;
	}
	
	@Override
	public BurgerAbstraction removeTopping(BurgerNaming aName) {
		if(aName ==getName()) {
			return getNext();
		}
		setNext(getNext().removeTopping(aName));
		return this;
	}
	
	@Override
	protected boolean hasTopping(BurgerNaming aName) {
			
		if(aName ==getName()) {
			return true;
		}
		return getNext().hasTopping(aName);
		
	}
	
	@Override
	public BurgerAbstraction sort() {
		
		
		if (toppingsCount() > 1){
			var b = getNext();
			b=b.sort();
			this.setNext(b);
			if (getName().compareTo(((BurgerTopping)b).getName()) > 0) {
		  		setNext(b.getNext());
		  		b.setNext(this);
		  		b.setNext(b.getNext().sort());
		  		return b;
			}
			
			
		}
		return this;
	}
	  	
	  	
	  

	
	
	
	
	
	
	
	public static void main(String[] args) {
		  BurgerAbstraction test = new ConcreteBurger(BurgerNaming.BASE_BURGER, null);
		  System.out.println(test);
		  test = new BurgerTopping(BurgerNaming.BACON, test);
		  test = new BurgerTopping(BurgerNaming.KETCHUP, test);
		  test = new BurgerTopping(BurgerNaming.LETTUCE, test);
		  test = new BurgerTopping(BurgerNaming.TOMATO, test);
		  System.out.println(test);
		  test = test.sort();
		  System.out.println(test);
		 }


	
}
