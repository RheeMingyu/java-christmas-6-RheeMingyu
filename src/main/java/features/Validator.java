package features;

import static constants.Constants.*;

import java.util.HashMap;
import java.util.Map;

import constants.Menus.Appetizer;
import constants.Menus.Beverage;
import constants.Menus.Dessert;
import constants.Menus.MainMenu;

public class Validator {
	
	private static Map<String, Integer> orders;
	private static int duplicateChecker;

	public int dateValidator(String input) {
		return validDayOfDecember(isNumber(input,INVALID_DATE_OUTPUT));
	}
	
	private int isNumber(String input,String print) {
		try {
			return Integer.parseInt(input);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException(print);
		}
	}
	
	private int validDayOfDecember(int input) {
		if(input<1||input>31) {
			throw new IllegalArgumentException(INVALID_DATE_OUTPUT);
		}
		return input;
	}
	
	public Map<String, Integer> orderValidator(String input){
		String [] wholeOrdersSplitted=splitOrders(input);
		orders=new HashMap<String, Integer>();
		
		for(String individual:wholeOrdersSplitted) {
			finalOrderDetails(dishAndServings(individual));
		}
		conformToRegulations(wholeOrdersSplitted);

		return orders;
	}
	
	private void conformToRegulations(String [] wholeOrdersSplitted) {
		existentDish();
		noDuplicates(wholeOrdersSplitted);
		lessThanTwenty();
	}
	
	private void noDuplicates(String[] wholeOrders) {
		System.out.println("test!!!:"+wholeOrders.length+","+orders.size()+"!!!!!");
		if(wholeOrders.length!=orders.size()) {
			throw new IllegalArgumentException(INVALID_MENU_OUTPUT);
		}
	}
	
	private void lessThanTwenty() {
		if(orders.size()>20) {
			throw new IllegalArgumentException(INVALID_MENU_OUTPUT);
		}
	}
	
	private String[] splitOrders(String wholeOrder) {
		String [] ordersSplitted=wholeOrder.split(",");
		
		for(String individual:ordersSplitted) {
			checkEmpty(individual);
		}
		return ordersSplitted;
	}
	
	private void checkEmpty(String input) {
		if(input==null||input.equals("")) {
			throw new IllegalArgumentException(INVALID_MENU_OUTPUT);
		}
	}
	
	private String[] dishAndServings(String individual) {
		String [] dish_servings=individual.split("-");
		
		if(dish_servings.length!=2) {
			throw new IllegalArgumentException(INVALID_MENU_OUTPUT);
		}
		return dish_servings;
	}
	
	private void finalOrderDetails(String[] dish_servings){
		orders.put(dish_servings[0], moreThanOne(isNumber(dish_servings[1],INVALID_MENU_OUTPUT)));	
	}
	
	private int moreThanOne(int servings) {
		if(servings<1) {
			throw new IllegalArgumentException(INVALID_MENU_OUTPUT);
		}
		return servings;
	}
	
	private void existentDish() {
		duplicateChecker=orders.size();
		for(String dish:orders.keySet()) {
			menuChecker(dish);
		}
		if(duplicateChecker!=0) {
			throw new IllegalArgumentException(INVALID_MENU_OUTPUT);
		}
	}
	
	private void menuChecker(String dish) {		
		appetizerCheker(dish);
		mainMenuChecker(dish);
		dessertChecker(dish);
		beverageChecker(dish);
	}
	
	private void appetizerCheker(String dish) {
		for(Appetizer ap:Appetizer.values()) {
			if(ap.appetizer().equals(dish)) {
				duplicateChecker--;
			}
		}
	}
	
	private void mainMenuChecker(String dish) {
		for(MainMenu ma:MainMenu.values()) {
			if(ma.main().equals(dish)) {
				duplicateChecker--;
			}
		}
	}
	
	private void dessertChecker(String dish) {
		for(Dessert de:Dessert.values()) {
			if(de.dessert().equals(dish)) {
				duplicateChecker--;
			}
		}
	}
	
	private void beverageChecker(String dish) {
		for(Beverage be:Beverage.values()) {
			if(be.beverage().equals(dish)) {
				duplicateChecker--;
			}
		}
	}
}
