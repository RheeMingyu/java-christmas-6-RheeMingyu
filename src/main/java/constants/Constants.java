package constants;

import creator.ObjectCreator;

public class Constants {

	//input 오류
	public final static String INVALID_DATE_OUTPUT=ErrorMessages.INVALID_DATE_OUTPUT.detected();
	public final static String INVALID_MENU_OUTPUT=ErrorMessages.INVALID_MENU_OUTPUT.detected();
	
	//메뉴 가격
	public final static int MUSHROOM_SOUP_PRICE=Menus.Appetizer.BUTTON_MUSHROOM_SOUP.price();
	public final static int TAPAS_PRICE=Menus.Appetizer.TAPAS.price();
	public final static int CAESAR_SALAD_PRICE=Menus.Appetizer.CAESAR_SALAD.price();
	public final static int TBONE_STEAK_PRICE=Menus.MainMenu.TBONE_STEAK.price();
	public final static int BARBECUE_RIP_PRICE=Menus.MainMenu.BARBECUE_RIP.price();
	public final static int SEAFOOD_PASTA_PRICE=Menus.MainMenu.SEAFOOD_PASTA.price();
	public final static int CHRISTRMAS_PASTA_PRICE=Menus.MainMenu.CHRISTRMAS_PASTA.price();
	public final static int CHOCOLATE_CAKE_PRICE=Menus.Dessert.CHOCOLATE_CAKE.price();
	public final static int ICECREAM_PRICE=Menus.Dessert.ICECREAM.price();
	public final static int ZERO_COLA_PRICE=Menus.Beverage.ZERO_COLA.price();
	public final static int RED_WINE_PRICE=Menus.Beverage.RED_WINE.price();
	public final static int CHAMPAGNE_PRICE=Menus.Beverage.CHAMPAGNE.price();
	
	//메뉴명 enum메서드로 직접 비교
	/*public final static String MUSHROOM_SOUP=Menus.Appetizer.BUTTON_MUSHROOM_SOUP.dish();
	public final static String TAPAS=Menus.Appetizer.TAPAS.dish();
	public final static String CAESAR_SALAD=Menus.Appetizer.CAESAR_SALAD.dish();
	public final static String TBONE_STEAK=Menus.MainMenu.TBONE_STEAK.dish();
	public final static String BARBECUE_RIP=Menus.MainMenu.BARBECUE_RIP.dish();
	public final static String SEAFOOD_PASTA=Menus.MainMenu.SEAFOOD_PASTA.dish();
	public final static String CHRISTRMAS_PASTA=Menus.MainMenu.CHRISTRMAS_PASTA.dish();
	public final static String CHOCOLATE_CAKE=Menus.Dessert.CHOCOLATE_CAKE.dish();
	public final static String ICECREAM=Menus.Dessert.ICECREAM.dish();
	public final static String ZERO_COLA=Menus.Beverage.ZERO_COLA.dish();
	public final static String RED_WINE=Menus.Beverage.RED_WINE.dish();
	public final static String CHAMPAGNE=Menus.Beverage.CHAMPAGNE.dish();*/
	public final static ObjectCreator CREATE=new ObjectCreator();
}
