package view;

import static constants.Constants.*;

import java.util.Map;

public class OutputView {
	
	Map<String, Integer> orders;

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
		System.out.println(String.format("%,d원", CREATE.stat().getTotalCostOrigin(orders)));
	}
}
