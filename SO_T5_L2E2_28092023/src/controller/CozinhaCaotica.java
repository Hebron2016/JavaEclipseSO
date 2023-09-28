package controller;

import java.util.concurrent.Semaphore;

public class CozinhaCaotica extends Thread {
	private int idComida;
	private Semaphore semaforo;
	private static String NomeComida;

	public CozinhaCaotica(int idComida, Semaphore semaforo) {
		this.idComida = idComida;
		this.semaforo = semaforo;
	}

	public void run() {
		comecou();
		cozimento();
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			terminou();
		}
	}

	private void comecou() {
		System.out.println("EI COZINHEIRO TEMOS UM NOVO PEDIDO #" + idComida);
	}

	private void cozimento() {
		int tempo = 0;
		int pausa = 100;
		if (idComida % 2 == 0) {
			NomeComida = "Lasanha a Bolonhesa";
			tempo = (int) ((Math.random() * 601) + 600);
			while (pausa <= tempo) {
				if ((int) pausa / 100 == (int) tempo / 100) {
					int aux = tempo - pausa;
					pausa += aux;
				}
				try {
					sleep(pausa);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("#" + idComida + " o prato: " + NomeComida + " está em PROGRESSO: "
						+ (100 * pausa) / tempo + "%");
				pausa += 100;
			}
		} else {
			NomeComida = "Sopa de Cebola";
			tempo = (int) ((Math.random() * 301) + 500);
			while (pausa <= tempo) {
				if ((int) pausa / 100 == (int) tempo / 100) {
					int aux = tempo - pausa;
					pausa += aux;
				}
				try {
					sleep(pausa);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("#" + idComida + " o prato: " + NomeComida + " está em PROGRESSO: "
						+ (100 * pausa) / tempo + "%");
				pausa += 100;
			}
		}
		System.out.println("#" + idComida + " O PRATO FICOU PRONTO 100%");

	}

	private void entrega() {
		System.out.println("#" + idComida + " o prato: " + NomeComida + " ESTÁ SENDO ENTREGUE");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void terminou() {
		System.out.println("#" + idComida + " o prato: " + NomeComida + " CONGRATULATIONS O PRATO FOI ENTREGUE");
	}
}
