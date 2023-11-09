package features;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public String inputDate() {
		return flexibleAcceptance(Console.readLine());
	}
	
	private String flexibleAcceptance(String input) {
		return input.replace(" ", "");
	}
}
