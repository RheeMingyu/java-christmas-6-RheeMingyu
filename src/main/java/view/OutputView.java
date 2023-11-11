package view;

import static constants.Constants.*;

import java.util.Map;

import data.EventData;
import features.Statistics;

public class OutputView {
	
	private static Map<String, Integer> orders;
	private static int visitDate;

	private EventData dto=CREATE.dto();
	private Statistics stat;

	public void viewPlayer() {
		gameOpener();
		infoReader();
		plannerOpener();
		feedback();
	}

	private void gameOpener() {
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
	}
	
	private void infoReader() {
		dateReader();
		orderReader();
	}
	
	private void dateReader() {
		dto.setVisitDate(CREATE.reader().readDate());
		visitDate=dto.getVisitDate();
	}
	
	private void orderReader() {
		dto.setOrders(CREATE.reader().readOrder());
		orders=dto.getOrders();
	}
	
	private void plannerOpener() {
		System.out.println("12월 "+visitDate+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
		stat=CREATE.stat(dto);
	}
	
	private void feedback() {
		menuOrderedFeedback();
		originalCostFeedback();
		presentationFeedback();
		discountDetailsFeedback();
		totalDiscountFeedback();
		resultCostFeedback();
		badgeFeedback();
	}
	
	private void menuOrderedFeedback() {
		System.out.println("<주문 메뉴>");
		
		for(Map.Entry<String, Integer> order:orders.entrySet()) {
			System.out.println(order.getKey()+" "+order.getValue()+"개");
		}
		System.out.println();
	}
	
	private void originalCostFeedback() {
		System.out.println("<할인 전 총주문 금액>");
		System.out.println(String.format("%,d원", stat.getTotalCostOrigin())+"\n");
	}
	
	private void presentationFeedback() {
		System.out.println("<증정 메뉴>");
		System.out.println(giftOrNone()+"\n");
	}
	
	private String giftOrNone() {
		if(stat.deserveGift()) {
			return "샴페인 1개";
		}
		return "없음";
	}
	
	private void discountDetailsFeedback() {
		int [] discountDetails=stat.getDiscountDetails();
		System.out.println("<혜택 내역>");
		
		if(discountAvailable(discountDetails)) {
			d_dayFeedback(discountDetails);
			weekFeedback(discountDetails);
			specialFeedback(discountDetails);
			giftFeedback(discountDetails);
		}
		if(!discountAvailable(discountDetails)) {
			System.out.println("없음\n");
		}
	}
	
	private boolean discountAvailable(int [] discountDetails) {
		for(int i=0;i<DISCOUNT_TYPES_CNT;i++) {
			if(discountDetails[i]!=0) {
				return true;
			}
		}
		return false;
	}
	
	private void d_dayFeedback(int [] discountDetails) {
		if(discountDetails[0]!=0) {
			System.out.println(String.format("크리스마스 디데이 할인: %,d원", discountDetails[0]));
		}
	}
	
	private void weekFeedback(int [] discountDetails) {

		if(discountDetails[1]!=0) {
			if(discountDetails[4]==1) {
				System.out.println(String.format("주말 할인: %,d원", discountDetails[1]));
			}
			if(discountDetails[4]==0) {
				System.out.println(String.format("평일 할인: %,d원", discountDetails[1]));
			}
		}
	}
	
	private void specialFeedback(int [] discountDetails) {
		if(discountDetails[2]!=0) {
			System.out.println(String.format("특별 할인: %,d원", discountDetails[2]));
		}
	}
	
	private void giftFeedback(int [] discountDetails) {
		if(discountDetails[3]!=0) {
			System.out.println(String.format("증정 이벤트: %,d원\n", discountDetails[3]));
		}
	}
	
	private void totalDiscountFeedback() {
		System.out.println("<총혜택 금액>");
		System.out.println(String.format("%,d원\n", stat.getTotalDiscount()));
	}
	
	private void resultCostFeedback() {
		System.out.println("<할인 후 예상 결제 금액>");
		System.out.println(String.format("%,d원\n", stat.getResultCost()));
	}
	
	private void badgeFeedback() {
		System.out.println("<12월 이벤트 배지>");
		System.out.println(stat.badgeReceivable());
	}
	
	public void warning(IllegalArgumentException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}
