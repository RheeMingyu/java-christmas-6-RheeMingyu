package creator;

import features.Input;
import features.Statistics;
import features.Validator;
import view.InputView;
import view.OutputView;

public class ObjectCreator {

	public Input input() {
		return new Input();
	}
	
	public Validator valid() {
		return new Validator();
	}
	
	public InputView reader() {
		return new InputView();
	}
	
	public OutputView announcer() {
		return new OutputView();
	}
	
	public Statistics stat() {
		return new Statistics();
	}
}
