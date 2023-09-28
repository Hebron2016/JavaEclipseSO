package controller;

import java.util.concurrent.Semaphore;

public class BancoDeDados extends Thread {
	private int idOperacao;
	private int opera;
	private Semaphore semaforo;
	private int cont;
	private static int finish;

	public BancoDeDados(int idOperacao, int opera, Semaphore semaforo, int cont) {
		this.idOperacao = idOperacao;
		this.opera = opera;
		this.semaforo = semaforo;
		this.cont = cont;

	}

	@Override
	public void run() {
		comeca();
		while (cont != opera) {
			if(cont == 1) {
			calc();
			}
			try {
				semaforo.acquire();
				transacao();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				calc();
				cont++;
			}
		}
		terminou();
	}

	private void comeca() {
		System.out.println("#" + idOperacao + " COMEÇOU A FAZER AS OPERACOES NO BANCO DE DADOS");
	}

	private void calc() {
		int tempo = 0;
		if (idOperacao % 3 == 1) {
			tempo = (int) ((Math.random() * 801) + 200);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (idOperacao % 3 == 2) {
			tempo = (int) ((Math.random() * 1001) + 500);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (idOperacao % 3 == 0) {
			tempo = (int) ((Math.random() * 1001) + 1000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#" + idOperacao + " fez um calculo que demorou: " + (double) tempo / 1000 + "s.");
	}

	private void transacao() {
		int tempo = 0;
		if (idOperacao % 3 == 1) {
			tempo = 1000;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (idOperacao % 3 == 2) {
			tempo = 1500;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (idOperacao % 3 == 0) {
			tempo = 1500;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#" + idOperacao + " fez uma transação que demorou: " + (double) tempo / 1000 + "s.");
	}

	private void terminou() {
		finish++;
		System.out.println("#" + idOperacao + " terminou em: " + finish);
	}
}
