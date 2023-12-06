package constants;

public class Menus {

	public enum Appetizer {
		
		BUTTON_MUSHROOM_SOUP("양송이수프",6000),
		TAPAS("타파스",5500),
		CAESAR_SALAD("시저샐러드",8000);
		
		private final String dish;
		private final int price;

		Appetizer(String dish,int price) {
			this.dish=dish;
			this.price=price;
		}
		
		public String appetizer() {
			return dish;
		}
		public int price() {
			return price;
		}
	}
	
	public enum MainMenu {
		
		TBONE_STEAK("티본스테이크",55000),
		BARBECUE_RIP("바비큐립",54000),
		SEAFOOD_PASTA("해산물파스타",35000),
		CHRISTRMAS_PASTA("크리스마스파스타",25000);
		
		private final String dish;
		private final int price;

		MainMenu(String dish,int price) {
			this.dish=dish;
			this.price=price;
		}
		
		public String main() {
			return dish;
		}
		public int price() {
			return price;
		}
	}
	
	public enum Dessert {
		
		CHOCOLATE_CAKE("초코케이크",15000),
		ICECREAM("아이스크림",5000);
		
		private final String dish;
		private final int price;

		Dessert(String dish,int price) {
			this.dish=dish;
			this.price=price;
		}
		
		public String dessert() {
			return dish;
		}
		public int price() {
			return price;
		}
	}
	
	public enum Beverage {
		
		ZERO_COLA("제로콜라",3000),
		RED_WINE("레드와인",60000),
		CHAMPAGNE("샴페인",25000);
		
		private final String dish;
		private final int price;
		
		Beverage(String dish,int price) {
			this.dish=dish;
			this.price=price;
		}
		
		public String beverage() {
			return dish;
		}
		public int price() {
			return price;
		}
	}
}
