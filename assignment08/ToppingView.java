package assignment08;
import static assignment08.BurgerNaming.*;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ToppingView   {
	private BurgerNaming name;
	private String screenName;
	private Language language;
	private ScreenManager screen;
	private JLabel caloriesLabel;
	private JLabel costLabel;
	private JButton lineSelectorImage;
	private JButton lineSelectorText;

	public ToppingView(BurgerNaming nam,  
			Language lang, ScreenManager scrn) {
		name = nam;
		language = lang;
		screenName = language.get(name);
		screen = scrn;
		caloriesLabel = screen.createYellowTextLabel(""+BurgerNaming.calories.get(name), SwingConstants.CENTER);
		String costString = BurgerNaming.costInCents.get(name)==null?language.get(FREE): 
			""+BurgerNaming.costInCents.get(name) + language.get(MONEY_UNIT);
		costLabel = screen.createYellowTextLabel(costString, SwingConstants.CENTER);
		lineSelectorImage = screen.createIconButton(
				BurgerNaming.images.get(name), 
				e -> doAction());	
		lineSelectorText = screen.createTextButton(screenName, 
				e -> doAction());
	}

	public void doAction() {
		screen.flipTopping(name);
	}

	public JLabel getCaloriesLabel() {
		return caloriesLabel;
	}
	public JLabel getCostLabel() {
		return costLabel;
	}
	public JButton getSelectorImageButton () {
		return lineSelectorImage;
	}
	public JButton getSelectorButton () {
		return lineSelectorText;
	}
	public void update(java.awt.Color color) {
		lineSelectorImage.setBackground(color);
		lineSelectorText.setBackground(color);
	}
	public String getScreenName() {
		return screenName;
	}
	public String getName() {
		return language.get(name);
	}
}
