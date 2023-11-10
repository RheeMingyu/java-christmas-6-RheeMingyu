package creator;

import features.Input;
import features.Validator;
import view.InputView;

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
}
