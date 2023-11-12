package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.EventData;
import features.Statistics;

import static constants.Constants.CREATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class StatTest {
	
	private int testdate=25; //디데이 3400 평일 8092 특별 1000 증정 25000 총 37492
	private Map<String, Integer> testorders=new HashMap<>() {
		{
			put("타파스",1); //애피타이저 5500
			put("티본스테이크",2); //메인 110000
			put("레드와인",3); //음료 180000
			put("아이스크림",4); //디저트 20000 총합 315500
		}
	};
	private EventData testdto=CREATE.dto();
	
	private Statistics teststat() {
		testdto.setVisitDate(testdate);
		testdto.setOrders(testorders);
		return CREATE.stat(testdto);
	}

	@DisplayName("할인 전 총주문 금액 계산 가능.")
	@Test
	void originalCost() {
		assertEquals(315500, teststat().getTotalCostOrigin());
	}
	
	@DisplayName("증정 이벤트 당첨 여부 계산 가능.")
	@Test
	void presentation() {
		Statistics teststat=teststat();
		teststat.getTotalCostOrigin();
		
		assertTrue(teststat.deserveGift());
	}
	
	@DisplayName("입력 데이터를 처리해 세부 할인 내역을 출력할 수 있다.")
	@Test
	void dicountList() {
		
	}
}
