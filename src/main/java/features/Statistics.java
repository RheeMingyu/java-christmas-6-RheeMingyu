package features;

import java.util.Map;

import constants.Menus.Appetizer;
import constants.Menus.Beverage;
import constants.Menus.Dessert;
import constants.Menus.MainMenu;
import data.EventData;

import static constants.Constants.*;

public class Statistics {//dto빨리
	
	public Statistics(EventData dto) {
		this.visitDate=dto.getVisitDate();
		this.orders=dto.getOrders();
	}
	
	private Map<String, Integer> orders;
	private int visitDate;
	
	//처리요구 데이터
	private int totalCostOrigin;
	private int totalDiscount;
	private int[] discountDetails=new int[5];
	
	private int dessertOrderedCnt;
	private int mainMenuOrderedCnt;
	
	//증정메뉴
	public boolean deserveGift() {
		if(totalCostOrigin>=120000) {
			return true;
		}
		return false;
	}

	//할인전 총주문금액
	public int getTotalCostOrigin() {		
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
				mainMenuOrderedCnt+=servings;
			}
		}
	}
	
	private void dessertCost(String dish,int servings) {
		for(Dessert de:Dessert.values()) {
			if(de.dessert().equals(dish)) {
				totalCostOrigin+=servings*de.price();
				dessertOrderedCnt+=servings;
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
	
	//혜택내역
	public int[] getDiscountDetails() {
		discountDetails[0]=d_dayDiscount();
		discountDetails[1]=weekDiscount();
		discountDetails[2]=specialDiscount();
		discountDetails[3]=giftDiscount();

		return discountDetails;
	}
	
	private int d_dayDiscount() {
		if(visitDate<=25) {
			return D_DAY_DISCOUNT_BASIC+(visitDate-1)*D_DAY_DISCOUNT_PER_DAY;
		}
		return 0;
	}
	
	private int weekDiscount() {
		if(isWeekend()) {
			discountDetails[4]=1;
			return mainMenuOrderedCnt*WEEK_DISCOUNT;
		}
		discountDetails[4]=0;
		return dessertOrderedCnt*WEEK_DISCOUNT;
	}
	
	private boolean isWeekend() {
		if(visitDate%DAYS_OF_A_WEEK==1||visitDate%DAYS_OF_A_WEEK==2) {
			return true;
		}
		return false;
	}
	
	private int specialDiscount() {
		if(visitDate%DAYS_OF_A_WEEK==3||visitDate==25) {
			return SPECIAL_DISCOUNT;
		}
		return 0;
	}
	
	private int giftDiscount() {
		if(deserveGift()) {
			return -Beverage.CHAMPAGNE.price();
		}
		return 0;
	}
	
	//총혜택금액
	public int getTotalDiscount() {		
		for(int i=0;i<DISCOUNT_TYPES_CNT;i++) {
			totalDiscount+=discountDetails[i];
		}
		return totalDiscount;
	}
	
	//할인후 예상결제금액
	public int getResultCost() {
		return totalCostOrigin+totalDiscount;
	}
	
	//이벤트 배지
	public String badgeReceivable() {
		if(-totalDiscount>=5000&&-totalDiscount<10000) {
			return "별";
		}
		if(-totalDiscount>=10000&&-totalDiscount<20000) {
			return "트리";
		}
		if(-totalDiscount>=20000) {
			return "산타";
		}
		return "없음";
	}
}
