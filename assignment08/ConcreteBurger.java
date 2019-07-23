package assignment08;

public class ConcreteBurger extends BurgerAbstraction{
	public ConcreteBurger(BurgerNaming name, BurgerAbstraction next) {
		super(name, next);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTotalCalories() {
		return getCalories();
		
	}
	
	@Override
	public double getTotalCost() {
		return getPrice();
	}

}
