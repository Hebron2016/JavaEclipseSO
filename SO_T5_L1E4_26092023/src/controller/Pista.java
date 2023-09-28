package controller;

import java.util.concurrent.Semaphore;

public class Pista extends Thread {
	private int idCarro;
	private int escuderia;
	private int mt;
	private static int grid[] = new int [14];
	private Semaphore semaforo;
	private static Semaphore scud1 = new Semaphore (1);
	private static Semaphore scud2 = new Semaphore (1);
	private static Semaphore scud3 = new Semaphore (1);
	private static Semaphore scud4 = new Semaphore (1);
	private static Semaphore scud5 = new Semaphore (1);
	private static Semaphore scud6 = new Semaphore (1);
	private static Semaphore scud7 = new Semaphore (1);
	private static int posicao;
	private static int finish = 0;

	public Pista(int idCarro, int escuderia, int mt, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.escuderia = escuderia;
		this.mt = mt;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		comecou();
		try {
			semaforo.acquire();
			voltas();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		terminou();
	}

	private void comecou() {
		if (escuderia == 1) {
			try {
				scud1.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();

			} finally {
				scud1.release();
			}
		}
		if (escuderia == 2) {
			try {
				scud2.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				scud2.release();
			}
		}
		if (escuderia == 3) {
			try {
				scud3.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				scud3.release();
			}
		}
		if (escuderia == 4) {
			try {
				scud4.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				scud4.release();
			}
		}
		if (escuderia == 5) {
			try {
				scud5.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				scud5.release();
			}
		}
		if (escuderia == 6) {
			try {
				scud6.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				scud6.release();
			}
		}
		if (escuderia == 7) {
			try {
				scud7.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				scud7.release();
			}
		}
		System.out.println("#" + idCarro + "da escuderia: " + escuderia + " foi o " + posicao + "o. a sair do pitstop");
	}

	private void voltas() {
		int volta = 1;
		System.out.println("#" + idCarro + "da escuderia: " + escuderia + "ENTROU NA PISTA ");
		for (int i = 0; i < 3; i++) {
			int tempo = (int) ((Math.random() * 6000) + 4000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if ( mt == 0) {
				mt = tempo;
			}else {
				if (tempo < mt) {
					mt = tempo;
				}
			}
			System.out.println("#" + idCarro + "da escuderia: " + escuderia + "realizou a volta: " + volta + " Tempo: "
					+ tempo);
			volta++;
		}
	}

	private void terminou() {
		System.out.println("#" + idCarro + " da escuderia: " + escuderia + " TERMINOU AS VOLTAS");
		grid[finish] = mt;
		finish++;
		if (finish == 14) {
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 13; j++) {
					if (grid[j] > grid[j + 1]) {
						int aux = grid[j];
						grid[j] = grid[j + 1];
						grid[j + 1] = aux;
					}
				}
			}
			System.out.println("------------GRID DE LARGADA------------");
			for (int i = 0; i < 14; i++ ) {
				System.out.println("TEMPO : "+ grid [i]+"\n ++++++++++++++");
			}
		}
	}
}
