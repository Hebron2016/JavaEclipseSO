package controller;

import java.util.concurrent.Semaphore;

public class carroSemaforo extends Thread {
	
	private int idCarro;
	private int sentido;
	private static int chegadaCruise;
	private static int crusou;
	private Semaphore semaforo;
	private String vemDe;

	public carroSemaforo(int idCarro, int sentido, Semaphore semaforo, String vemDe) {
		this.idCarro = idCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
		this.vemDe = vemDe;
	}
    @Override
	public void run() {
		direcao();
		chegando();
		try {
			semaforo.acquire();
			crusar();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			termino();
		}
	}

	private void direcao() {
		System.out.println("#"+idCarro+" ele vem da "+vemDe);
	}

	private void chegando() {
		int distanciaTotal = (int) ((Math.random() * 1001) + 0);
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCarro + " Já andou " + distanciaPercorrida + "m.");
		}
		chegadaCruise++;
		System.out.println("#" + idCarro + " Foi o " + chegadaCruise + " o. a chegar");
	}

	private void crusar() {
		int para = (int) ((Math.random()*5)+0.99);
		String vai = null;
		while (para == sentido) {
			para = (int) ((Math.random()*5)+1);
		}
		sentido = para;
		if(sentido == 1) {
			 vai =("Direita");
		}
		if(sentido == 2) {
			 vai =("Esquerda");
		}
		if(sentido == 3) {
			 vai =("Cima");
		}
		if(sentido == 4) {
			 vai =("Baixo");
		}

		System.out.println("#"+idCarro+" QUE PODE CRUSAR ele vem "+vemDe+ " e ele vai crusar para "+ vai);
		
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void termino() {
		crusou++;
		System.out.println("CRUSOUUUUUUUUUUUUUUU"+"#"+idCarro+ "Foi o " + crusou+ "o. a crusar");
	}

}
