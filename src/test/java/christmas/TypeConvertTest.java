package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.Constants.CREATE;

public class TypeConvertTest {

	@DisplayName("날짜 입력 시 Integer형식으로 변환 가능.")
	@Test
	void dateConverter() {
		assertEquals(12, CREATE.valid().dateValidator("12"));
	}
	
	@DisplayName("메뉴 입력 시 Map형식으로 변환 가능.")
	@Test
	void orderConverter() {
		Map<String, Integer> testorders=CREATE.valid().orderValidator(
											"티본스테이크-1,레드와인-2,아이스크림-3"
										);
		assertTrue(
				testorders.containsKey("티본스테이크")&&
				testorders.containsKey("레드와인")&&
				testorders.containsKey("아이스크림")&&
				(testorders.get("티본스테이크")==1)&&
				(testorders.get("레드와인")==2)&&
				(testorders.get("아이스크림")==3)
		);
	}
}
