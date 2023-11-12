package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class InputErrorTest extends NsTest {

	@DisplayName("입력값 수용의 유연성 테스트")
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

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
