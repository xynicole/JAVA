package assignment08;

import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

public enum BurgerNaming {
	BACON, BASE_BURGER, CALORIES_TITLE, CALORIES_TOTAL, CHEESE, FREE, KETCHUP, 
	LANGUAGE, LETTUCE, MAYONNAISE, MONEY_UNIT, MUSTARD, ONIONS, PICKLES, 
	PRICE_TITLE, PRICE_TOTAL, PRINT, TOMATO, TOTALS, TOPPING;
	public static List<BurgerNaming> toppings =
			List.of(BACON, CHEESE, KETCHUP, LETTUCE, MAYONNAISE,
					MUSTARD, ONIONS, PICKLES, TOMATO);
	public static Map<BurgerNaming, Integer> costInCents =
			Map.of(BACON, 5, CHEESE, 3, LETTUCE, 2, ONIONS, 2, PICKLES, 3, TOMATO, 3,
					BASE_BURGER, 450);
	public static Map<BurgerNaming, Integer> calories =
			Map.of(BACON, 50, CHEESE, 50, KETCHUP, 10, LETTUCE, 2, MAYONNAISE, 10, 
					MUSTARD, 10, ONIONS, 10, PICKLES, 20, TOMATO, 25, BASE_BURGER, 300);
	public static Map<BurgerNaming, ImageIcon> images =
			Map.of(BACON, new ImageIcon("bacon.jpg"), CHEESE, new ImageIcon("cheese.jpg"), 
					KETCHUP, new ImageIcon("ketchup.jpg"), LETTUCE, new ImageIcon("lettuce.jpg"), 
					MAYONNAISE, new ImageIcon("mayonnaise.jpg"), MUSTARD, new ImageIcon("mustard.jpg"), 
					ONIONS, new ImageIcon("onions.jpg"), PICKLES, new ImageIcon("pickles.jpg"), 
					TOMATO, new ImageIcon("tomato.jpg"));
}
