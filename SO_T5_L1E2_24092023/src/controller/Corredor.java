package controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread {
	private int idPessoa;
	private static int chegou;
	private static int atravessou;
	private int corredor;
	private Semaphore semaforo;

	public Corredor(int idPessoa, int corredor, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.corredor = corredor;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		andando();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			terminou();

		}
	}

	private void andando() {
		System.out.println("#" + idPessoa + " começou a andar " + " pelo corredor: " + corredor);
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 6) + 4);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " Já andou " + distanciaPercorrida + "m.");
		}
		chegou++;
		System.out.println("#" + idPessoa + " Foi o " + chegou + " o. a chegar");
	}

	private void porta() {
		System.out.println("#" + idPessoa + " está PASSANDO PELA PORTA ");
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void terminou() {
		atravessou++;
		System.out.println("ATRAVESSOUUUUUUUUUUUU" + " #" + idPessoa + " foi o " + atravessou + " o. a chegar");
	}

}
