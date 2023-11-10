package view;

import static constants.Constants.*;

public class OutputView {

	public void gameOpener() {
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
	}
	
	public void plannerOpener() {
		System.out.println("12월 "+CREATE.reader().readDate()+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
	}
}
