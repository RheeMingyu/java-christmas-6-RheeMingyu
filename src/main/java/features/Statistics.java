package features;

import java.util.Map;

import constants.Menus.Appetizer;
import constants.Menus.Beverage;
import constants.Menus.Dessert;
import constants.Menus.MainMenu;

public class Statistics {
	
	private int totalCostOrigin;

	public int getTotalCostOrigin(Map<String, Integer> orders) {		
		for(Map.Entry<String, Integer> order:orders.entrySet()) {			
			getSum(order.getKey(), order.getValue());
		}
		return totalCostOrigin;
	}
	
	private void getSum(String dish,int servings) {
		appetizerCost(dish, servings);
		mainMenuCost(dish, servings);
		dessertCost(dish, servings);
		beverageCost(dish, servings);
	}
	
	private void appetizerCost(String dish,int servings) {
		for(Appetizer ap:Appetizer.values()) {
			if(ap.appetizer().equals(dish)) {
				totalCostOrigin+=servings*ap.price();
			}
		}
	}
	
	private void mainMenuCost(String dish,int servings) {
		for(MainMenu ma:MainMenu.values()) {
			if(ma.main().equals(dish)) {
				totalCostOrigin+=servings*ma.price();
			}
		}
	}
	
	private void dessertCost(String dish,int servings) {
		for(Dessert de:Dessert.values()) {
			if(de.dessert().equals(dish)) {
				totalCostOrigin+=servings*de.price();
			}
		}
	}
	
	private void beverageCost(String dish,int servings) {
		for(Beverage be:Beverage.values()) {
			if(be.beverage().equals(dish)) {
				totalCostOrigin+=servings*be.price();
			}
		}
	}
}
