package assignment08;

public abstract class BurgerAbstraction {
	private BurgerNaming name;
	private BurgerAbstraction next;
	
	public BurgerAbstraction(BurgerNaming name, BurgerAbstraction next) {
		super();
		this.name = name;
		this.next = next;
	}

	public BurgerAbstraction getNext() {
		return next;
	}

	public void setNext(BurgerAbstraction next) {
		this.next = next;
	}

	public BurgerNaming getName() {
		return name;
	}
	public BurgerAbstraction removeTopping(BurgerNaming name) {
		return this;
	}
	
	public BurgerAbstraction sort() {
		return this;
	}
	
	public double getPrice() {
		return BurgerNaming.costInCents.get(name)==null?0:BurgerNaming.costInCents.get(name);
}
	
	public int getCalories() {
		return BurgerNaming.calories.get(name);
	}

	public abstract int getTotalCalories();
	public abstract double getTotalCost();
	
	protected int toppingsCount() {
		return 0;
	}
	
	protected boolean hasTopping(BurgerNaming name) {
		return false;
		
	}
	
	public String toString() {
		if(next !=null) {
			//return  "->" + next.toString();
			return name.name() + "->" + next.toString();
		}
		
		return name.name();
	}
	
	
	
	
}
