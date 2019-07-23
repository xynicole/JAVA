package lab07;

public abstract class Herbivore extends Animal {
	private String foliage;
	private int agressionLevel;
	abstract void graze();
	
	public Herbivore(String foliage, int agressionLevel) {
		super();
		this.foliage = foliage;
		this.agressionLevel = agressionLevel;
	}
	
	@Override
	public String toString() {
		return "A herbivore only eats plants. It can additionally perform the action graze, and has a foliage it eats.";
		
	}

	public String getFoliage() {
		return foliage;
	}

	public int getAgressionLevel() {
		return agressionLevel;
	}
	
	
			



}
