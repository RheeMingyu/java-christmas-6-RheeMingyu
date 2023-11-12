package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;

import static constants.Constants.CREATE;

public class InputErrorTest extends NsTest {

	@DisplayName("입력값 수용의 유연성 테스트.")
	@Test
	void flexibility() {
		 assertSimpleTest(() -> {
			 run(" 2 5 ", "티본 스테이크 - 1, 해산물 파스타 - 1, 레드 와인 - 1");
	            assertThat(output()).contains(
	            	"12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
	            	"티본스테이크 1개",
	            	"해산물파스타 1개",
	            	"레드와인 1개"
	            );
	     });
	}
	
	@DisplayName("12월에 없는 날짜 입력 시 오류 발생.")
	@ValueSource(strings = {"0","32","","date"})
	@ParameterizedTest
	void noneOfDecember(String input) {
		assertThatThrownBy(() -> CREATE.valid().dateValidator(input))
	    						.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("메뉴 입력조건에 부합하지 않는 형식 입력 시 오류 발생.")
	@ValueSource(strings = {
		"새우버거-2", //부존재 메뉴
		"타파스-0", //0개 이하의 메뉴
		"제로콜라:3", //형식 파괴("-"이외의 기호사용)
		"티본스테이크-1.샴페인-1", //형식파괴(","이외의 기호사용)
		"", //형식파괴(메뉴 미입력)
		"티본스테이크-1,,샴페인-1", //형식파괴(무의미한 입력)
		"타파스-one", //형식파괴(입력 인분 수 오류)
		"타파스-1,제로콜라-1,타파스-1" //중복 메뉴
	})
	@ParameterizedTest
	void unfittedFormat(String input) {
		assertThatThrownBy(() -> CREATE.valid().orderValidator(input))
								.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("예외 처리 후 반복 입력 가능.")
	@Test
	void repeatable() {
		 assertSimpleTest(() -> {
			 run("a","1","티본스테이크-a","1","티본스테이크-1");
	            assertThat(output()).contains(
	            	"[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.",
	            	"[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.",
	            	"12월 1일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
	            	"티본스테이크 1개"
	            );
	     });
	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
