package view;

import java.util.concurrent.Semaphore;

import controller.Corredor;

public class ThreadPessoa {
	public static void main(String[] args) {
		int corredor = 1;
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread tPessoa = new Corredor(idPessoa, corredor, semaforo);
			tPessoa.start();
			corredor ++;
		}
	}
}
