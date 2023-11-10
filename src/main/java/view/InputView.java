package view;

import static constants.Constants.*;

import java.util.Map;

public class InputView {

	public int readDate() {
		System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
		
		return CREATE.valid().dateValidator(CREATE.input().inputDevice());
	}
	
	public Map<String, Integer> readOrder() {
		System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
		
		return CREATE.valid().orderValidator(CREATE.input().inputDevice());
	}
}
