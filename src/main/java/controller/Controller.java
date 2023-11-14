package controller;

import static constants.Constants.CREATE;

import view.OutputView;

public class Controller {
	
	private final OutputView player=CREATE.announcer();

	public void viewPlayer() {
		player.gameOpener();
		player.infoReader();
		player.plannerOpener();
		player.feedback();
	}
}
