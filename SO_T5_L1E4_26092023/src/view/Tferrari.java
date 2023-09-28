package view;

import java.util.concurrent.Semaphore;

import controller.Pista;

public class Tferrari {

	public static void main(String[] args) {
		int permissoes = 5;
		Semaphore semaforo = new Semaphore(permissoes);
		int idCarro = 0;
		int escuderia = 0;
		int mt = 0;
		for (int i = 0; i < 7; i++) {
			escuderia++;
			idCarro++;
			Thread t1 = new Pista(idCarro, escuderia, mt, semaforo);
			idCarro++;
			Thread t2 = new Pista(idCarro, escuderia, mt, semaforo);
			t1.start();
			t2.start();
		}

	}
}