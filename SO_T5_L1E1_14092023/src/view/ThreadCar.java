package view;

import java.util.concurrent.Semaphore;

import controller.carroSemaforo;

public class ThreadCar {

	public static void main(String[] args) {
		int permissoes = 1;
		int sentido = 0;
		Semaphore semaforo = new Semaphore(permissoes);
		String vemDe = null;

		for ( int idCarro = 0; idCarro < 10; idCarro++) {
			sentido = (int) ((Math.random()*5)+1);
			if(sentido == 1) {
				 vemDe =("da Direita");
			}
			if(sentido == 2) {
				 vemDe =("da Esquerda");
			}
			if(sentido == 3) {
				 vemDe =("de Cima");
			}
			if(sentido == 4) {
				 vemDe =("de Baixo");
			}
			Thread tCarro = new carroSemaforo (idCarro, sentido ,semaforo, vemDe);
			tCarro.start();
		}
	}

}
