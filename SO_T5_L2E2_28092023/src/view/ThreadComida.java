package view;

import java.util.concurrent.Semaphore;

import controller.CozinhaCaotica;

public class ThreadComida {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int idComida = 1; idComida <= 5; idComida++) {
			Thread tPrato = new CozinhaCaotica(idComida, semaforo);
			tPrato.start();

		}
	}

}
