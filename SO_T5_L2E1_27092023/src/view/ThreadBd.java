package view;

import java.util.concurrent.Semaphore;

import controller.BancoDeDados;

public class ThreadBd {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		int opera = 0;
		int cont = 1;
		
		for (int idOperacao = 1; idOperacao < 22; idOperacao++) {
			if (idOperacao % 3 == 1) {
				opera = 2;
			}
			if (idOperacao % 3 == 2) {
				opera = 3;
			}
			if (idOperacao % 3 == 0) {
				opera = 3;
			}
			Thread tBD = new BancoDeDados(idOperacao, opera, semaforo, cont);
			tBD.start();
		}

	}

}
