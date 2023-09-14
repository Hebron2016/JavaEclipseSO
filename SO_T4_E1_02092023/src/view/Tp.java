package view;

import controller.Tidgid;

public class Tp {

	public static void main(String[] args) {

		
		for (int idThread = 0 ; idThread<5; idThread++) {
			Thread Tid = new Tidgid (idThread);
			Tid.start();
	}

}
}
