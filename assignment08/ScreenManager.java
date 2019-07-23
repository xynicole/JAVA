package assignment08;

import static assignment08.BurgerNaming.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class ScreenManager {
	private static Font font = new Font("Dialog",Font.BOLD, 18);
	private static Font ital = new Font("SansSerif",Font.ITALIC|Font.BOLD, 18);
	private static Color background = Color.BLACK;
	private static Color basicButton = Color.LIGHT_GRAY;
	private ToppingView[][] toppingViews = new ToppingView[Language.values().length][BurgerNaming.toppings.size()];
	private JLabel[] calorieViews = new JLabel[Language.values().length];
	private JFormattedTextField[] priceViews = new JFormattedTextField[Language.values().length];

	private BurgerAbstraction burger = new ConcreteBurger(BASE_BURGER, null);

	final JFrame frame = new JFrame();

	public void initialize() {
		Container container = frame.getContentPane();
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel[] menus = new JPanel[Language.values().length];
		for(Language lang : Language.values()) {
			var i = lang.ordinal(); 
			menus[i] = new JPanel();
			tabbedPane.add(lang.get(LANGUAGE), menus[lang.ordinal()]);
			build(i, menus[i], lang);
		}
		container.setLayout(new BorderLayout(0,0));
		container.add(tabbedPane);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim);
		frame.setUndecorated(true);

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(
						frame,
						"Do you want to exit?", 
						"Confirm Exit",
						JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		System.out.println("SETUP " + burger);

		frame.setVisible(true);
	}
	
	public void build(int index, JPanel p, Language lang) {
		JPanel titles = new JPanel();
		JPanel buttonsEtc = new JPanel();
		JPanel buttonsEtcLeft = new JPanel();
		JPanel buttonsEtcRight = new JPanel();
		JPanel totals = new JPanel();
		p.setLayout(new BorderLayout(0,0));
		p.add(titles, BorderLayout.PAGE_START);
		p.add(totals, BorderLayout.PAGE_END);
		p.add(buttonsEtc); // added to CENTER
		makeTitleArea(titles, lang);
		makeButtonArea(buttonsEtc, buttonsEtcLeft, buttonsEtcRight, lang);
		int count = 0;
		int halfSize = BurgerNaming.toppings.size()/2;
		for (BurgerNaming bn : BurgerNaming.toppings) {
			if (count < halfSize) {
				//debugging: System.out.println("build loop 1 " + lang.ordinal() + " " + count);
				toppingViews[index][count] = new ToppingView(bn, lang, this);
				makeButtonLine(buttonsEtcLeft, toppingViews[lang.ordinal()][count++]);
			} else {
				//System.out.println("build loop 2 " + lang.ordinal() + " " + count);
				toppingViews[index][count] = new ToppingView(bn, lang, this);
				makeButtonLine(buttonsEtcRight, toppingViews[lang.ordinal()][count++]);
			}
		}
		makeTotalArea(index, totals, lang);
	}
	
	public void makeButtonArea (JPanel buttonsEtc, JPanel buttonsEtcLeft, JPanel buttonsEtcRight, Language lang) {
		buttonsEtc.setLayout(new GridLayout(1,2,0,0));
		buttonsEtcLeft.setLayout(new GridLayout(0,4,0,0));
		buttonsEtcRight.setLayout(new GridLayout(0,4,0,0));
		buttonsEtc.setOpaque(true);
		buttonsEtc.setBackground(Color.LIGHT_GRAY);
		buttonsEtcLeft.setBackground(Color.BLACK);
		buttonsEtcRight.setBackground(Color.BLACK);
		buttonsEtc.add(buttonsEtcLeft);
		buttonsEtc.add(buttonsEtcRight);
	}
	
	public void makeButtonLine (JPanel buttonsEtc, ToppingView topping) { 
		buttonsEtc.add(topping.getSelectorImageButton());
		buttonsEtc.add(topping.getSelectorButton());
		buttonsEtc.add(topping.getCaloriesLabel());
		buttonsEtc.add(topping.getCostLabel());
	}

	public void makeTotalArea (int index, JPanel totals, Language lang) {
		totals.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		totals.setBackground(background);
		totals.add(createItalLabel(TOTALS, lang, SwingConstants.RIGHT));
		totals.add(createItalLabel(CALORIES_TOTAL, lang, SwingConstants.RIGHT));
		calorieViews[index] = createYellowTextLabel("" + burger.getTotalCalories(), SwingConstants.CENTER);
		totals.add(calorieViews[index]);
		totals.add(createItalLabel(PRICE_TOTAL, lang, SwingConstants.RIGHT));
		priceViews[index] = createYellowTextField();
		priceViews[index].setValue(burger.getTotalCost()/100.0);
		totals.add(priceViews[index]);
		JButton print = new JButton(lang.get(PRINT));
		totals.add(print);
		print.addActionListener(e ->  {
			burger = burger.sort();
			String str = burger.toString();
			str = str.replace("->", "\n");
			str = str.replace("BASE_BURGER", "");
			JOptionPane.showMessageDialog(frame, "Burger with Toppings:\n" + str);
			});
		
	}

	public void makeTitleArea (JPanel titles, Language lang) {
		JPanel titleLeft = new JPanel();
		JPanel titleRight = new JPanel();
		JPanel titleLeftPart = new JPanel();
		JPanel titleRightPart = new JPanel();
		titleLeft.setBackground(background);
		titleRight.setBackground(background);
		titleLeftPart.setBackground(background);
		titleRightPart.setBackground(background);
		titles.setLayout(new GridLayout(0,2,0,0));
		titleLeft.setLayout(new GridLayout(0,2,0,0));
		titleRight.setLayout(new GridLayout(0,2,0,0));
		titleLeftPart.setLayout(new GridLayout(0,2,0,0));
		titleRightPart.setLayout(new GridLayout(0,2,0,0));
		titles.add(titleLeft, SwingConstants.CENTER);
		titles.add(titleRight, SwingConstants.CENTER);
		JLabel toppingTitle1 = createYellowNamingLabel(TOPPING, lang, SwingConstants.CENTER);
		JLabel caloriesTitle1 = createYellowNamingLabel(CALORIES_TITLE, lang, SwingConstants.CENTER);
		JLabel priceTitle1 = createYellowNamingLabel(PRICE_TITLE, lang, SwingConstants.CENTER);
		JLabel toppingTitle2 = createYellowNamingLabel(TOPPING, lang, SwingConstants.CENTER);
		JLabel caloriesTitle2 = createYellowNamingLabel(CALORIES_TITLE, lang, SwingConstants.CENTER);
		JLabel priceTitle2 = createYellowNamingLabel(PRICE_TITLE, lang, SwingConstants.CENTER);
		titleLeft.add(toppingTitle1);
		titleLeft.add(titleLeftPart);
		titleLeftPart.add(caloriesTitle1);
		titleLeftPart.add(priceTitle1);
		titleRight.add(toppingTitle2);
		titleRight.add(titleRightPart);
		titleRightPart.add(caloriesTitle2);
		titleRightPart.add(priceTitle2);
	}

	public JButton createTextButton(String label, ActionListener action) {
		JButton b = new JButton(label);
		//b.setOpaque(false);
		b.setBackground(basicButton);
		b.setForeground(Color.BLACK);		
		b.setFont(font);
		b.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		b.addActionListener(action);
		return b;		
	}

	public JButton createIconButton(Icon icon, ActionListener action) {
		JButton b = new JButton(icon);
		//b.setOpaque(false);
		b.setBackground(basicButton);
		b.setBorder(BorderFactory.createLineBorder(background));
		b.addActionListener(action);
		return b;
	}	
	public JLabel createYellowNamingLabel (BurgerNaming name, Language lang, int alignment) {
		JLabel lbl = new JLabel(lang.get(name), alignment);
		lbl.setForeground(Color.YELLOW);		
		lbl.setFont(font);	
		return lbl;	
	}
	public JLabel createYellowTextLabel (String name, int alignment) {
		JLabel lbl = new JLabel(name, alignment);
		lbl.setForeground(Color.YELLOW);		
		lbl.setFont(font);	
		return lbl;	
	}
	public JLabel createYellowTextLabel (int i, int alignment) {
		JLabel lbl = new JLabel("" + i, alignment);
		lbl.setForeground(Color.YELLOW);		
		lbl.setFont(font);	
		return lbl;	
	}
	public JLabel createItalLabel (BurgerNaming name, Language lang, int alignment) {
		JLabel lbl = new JLabel(lang.get(name), alignment);
		lbl.setForeground(Color.YELLOW);		
		lbl.setFont(ital);	
		return lbl;	
	}
	public JFormattedTextField createYellowTextField() {
		JFormattedTextField t = new JFormattedTextField(NumberFormat.getCurrencyInstance());
		t.setHorizontalAlignment(SwingConstants.CENTER);
		t.setColumns(6);
		t.setOpaque(false);
		t.setEditable(false);
		t.setBorder(BorderFactory.createLineBorder(background));
		t.setForeground(Color.YELLOW);		
		t.setFont(font);
		return t;
	}

	public void flipTopping(BurgerNaming name) {
		if (burger.hasTopping(name)) {
			burger = burger.removeTopping(name);
			for(int i = 0; i < Language.values().length; i++) {
				toppingViews[i][BurgerNaming.toppings.indexOf(name)].update(Color.LIGHT_GRAY);
				calorieViews[i].setText("" + burger.getTotalCalories());
				priceViews[i].setValue(burger.getTotalCost()/100.0);
			}
		} else {
			burger = new BurgerTopping(name, burger);
			for(int i = 0; i < Language.values().length; i++) {
				toppingViews[i][BurgerNaming.toppings.indexOf(name)].update(Color.CYAN);
				calorieViews[i].setText("" + burger.getTotalCalories());
				priceViews[i].setValue(burger.getTotalCost()/100.0);
			}
		}
		
	}	

	
	
	
}
