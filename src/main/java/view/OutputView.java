package view;

import static constants.Constants.*;

import java.util.Map;

import data.EventData;
import features.Statistics;

public class OutputView {
	
	private Map<String, Integer> orders;
	
	private Statistics stat=CREATE.stat();
	
	//private EventData dto;
	
	/*public OutputView(EventData dto) {
		this.dto=dto;
	}*/

	public void gameOpener() {
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
	}
	
	public void plannerOpener() {
		System.out.println("12월 "+CREATE.reader().readDate()+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
	}
	
	public void warning(IllegalArgumentException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
	public void menuOrderedFeedback() {
		System.out.println("<주문 메뉴>");
		orders=CREATE.reader().readOrder();
		
		for(Map.Entry<String, Integer> order:orders.entrySet()) {
			System.out.println(order.getKey()+" "+order.getValue()+"개");
		}
		System.out.println();
	}
	
	public void originalCostFeedback() {
		System.out.println("<할인 전 총주문 금액>");
		System.out.println(String.format("%,d원", stat.getTotalCostOrigin(orders))+"\n");
	}
	
	public void presentationFeedback() {
		System.out.println("<증정 메뉴>");
		System.out.println(giftOrNone());
	}
	
	private String giftOrNone() {
		if(CREATE.stat().deserveGift(orders)) {
			return "샴페인 1개";
		}
		return "없음";
	}
	
	public void discountDetailsFeedback() {
		int [] discountDetails=stat.getDiscountDetails();
		
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
			System.out.println("크리스마스 디데이 할인: "+discountDetails[0]+"원");
		}
	}
	
	private void weekFeedback(int [] discountDetails) {
		if(discountDetails[1]!=0) {
			if(discountDetails[4]==1) {
				System.out.println("주말 할인: "+discountDetails[1]+"원");
			}
			if(discountDetails[4]==0) {
				System.out.println("평일 할인: "+discountDetails[1]+"원");
			}
		}
	}
	
	private void specialFeedback(int [] discountDetails) {
		if(discountDetails[2]!=0) {
			System.out.println("특별 할인: "+discountDetails[2]+"원");
		}
	}
	
	private void giftFeedback(int [] discountDetails) {
		if(discountDetails[3]!=0) {
			System.out.println("증정 이벤트: "+discountDetails[3]+"원\n");
		}
	}
	
	public void totalDiscountFeedback() {
		System.out.println("<총혜택 금액>");
		System.out.println(stat.getTotalDiscount()+"원\n");
	}
	
	public void resultCostFeedback() {
		System.out.println("<할인 후 예상 결제 금액>");
		System.out.println(stat.getResultCost()+"원\n");
	}
	
	public void badgeFeedback() {
		System.out.println("<12월 이벤트 배지>");
		System.out.println(stat.badgeReceivable());
	}
}
