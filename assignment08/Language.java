package assignment08;
import java.util.EnumMap;
import java.util.Map;

public enum Language {
	/*
	BurgerNaming constants: 
	BACON, BASE_BURGER, CALORIES_TITLE, CALORIES_TOTAL, CHEESE, FREE, KETCHUP, 
	LANGUAGE, LETTUCE, MAYONNAISE, MONEY_UNIT, MUSTARD, ONIONS, PICKLES, 
	PRICE_TITLE, PRICE_TOTAL, PRINT, TOMATO, TOTALS, TOPPING;	 */
	//using http://weber.ucsd.edu/~dkjordan/resources/unicodemaker.html
	//http://translate.google.com/?tl=zh#auto/zh-CN/

	CHINESE ("\u57f9\u6839", null, "\u5361\u8def\u91cc", "\u5361\u8def\u91cc: ", "\u8d77\u53f8", "\u514d\u8d39", 
			   "\u756a\u8304\u9171", "\u4e2d\u6587", "\u751f\u83dc","\u86cb\u9ec4\u9171", "\u00a2", "\u82a5\u672b","\u6d0b\u8471",
			   "\u6ce1\u83dc", "\u4ef7\u94b1", "\u4ef7\u94b1: ", "\u6253\u5370", "\u5976\u916a: ", "\u756a\u8304","\u914d\u6599"), 
	ENGLISH ("bacon", null, "CALORIES", "calories: ", "cheese", "free",
			"ketchup", "ENGLISH", "lettuce", "mayonnaise", "\u00a2", "mustard", "onions",
			"pickles", "PRICE", "price: ", "PRINT", "tomato", "TOTALS", "TOPPINGS"),
	FRENCH ("bacon", null, "CALORIES", "calories: ", "fromage", "libre",
			"ketchup", "FRAN\u00c7AIS", "salade", "mayonnaise", "\u00a2", "moutarde", "oignons",
			"cornichons", "PRIX", "prix: ", "IMPRIMER", "tomate", "TOTAL", "GARNITURES"), 
	GERMAN ("Speck", null, "KALORIEN", "Kalorien: ", "K" + (char)228 + "se", "gratis",
			"Ketchup", "DEUTSCH", "Kopfsalat", "Mayonnaise", "\u00a2", "Senf", "Zwiebeln",
			"Gurken", "PREIS", "Preis: ", "ABDRUCKEN", "Tomate", "SUMME", "TOPPINGS"), 
	SPANISH ("tocino", null, "CALORIAS", "calorias: ", "queso", "gratis", 
			"ketchup", "ESPA\u00d1OL", "lechuga", "mayonesa", "\u00a2", "mostaza", "cebolla",
			"encurtidos", "PRECIO", "precio: ", "IMPRIMIR", "tomate", "TOTALES", "A\u00d1ADIDOS");
	private Map<BurgerNaming, String> translation = new EnumMap<>(BurgerNaming.class);
	Language(String... names) {
		for(BurgerNaming b : BurgerNaming.values()) {
			translation.put(b, names[b.ordinal()]);
			//For testing 
			//System.out.println(b + "=>" + b.ordinal());
		}
	}
	public String get(BurgerNaming b) {
		return translation.get(b);
	}
}
