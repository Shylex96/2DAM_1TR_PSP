package es.studium.main;

import es.studium.controller.ApplicationController;
import es.studium.model.ProcessScanner;
import es.studium.view.MainMenu;

public class Main {

	public static void main(String[] args) {

		ProcessScanner processScanner = new ProcessScanner();
		MainMenu mainMenu = new MainMenu();
		new ApplicationController(processScanner, mainMenu);
	}
}

