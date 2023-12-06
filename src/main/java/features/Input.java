package features;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public String inputDevice() {
		return flexibleAcceptance(Console.readLine());
	}
	
	private String flexibleAcceptance(String input) {
		return input.replace(" ", "");
	}
}
