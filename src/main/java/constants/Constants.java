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
	
	//할인가정보
	public final static int D_DAY_DISCOUNT_BASIC=-1000;
	public final static int D_DAY_DISCOUNT_PER_DAY=-100;
	public final static int WEEK_DISCOUNT=-2023;
	public final static int SPECIAL_DISCOUNT=-1000;
	public final static int DISCOUNT_TYPES_CNT=4;
	
	public final static int DAY_OF_A_WEEK=7;

	public final static ObjectCreator CREATE=new ObjectCreator();
}
