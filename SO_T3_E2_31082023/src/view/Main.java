package view;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController os = new KillController();
		String SO = os.getOs();
		os.listaProcessos(SO);
	}

}
