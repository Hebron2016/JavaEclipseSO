package controller;

public class ThreadVetor extends Thread {
	private int n = 0;
	private int vet[] = new int [1000];
	
	public ThreadVetor (int n, int[]vet) {
		this.n=n;
		this.vet=vet;			
	}
	
	@Override
	public void run() {
		ParOrImpar ();
	
		
	}
	
	private void ParOrImpar () {
		if (n % 2 == 0) {
			double tempoInicial = System.nanoTime();
			for (int i = 0; i< vet.length; i++) {
				
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println ("TID#" + getId() +" É PAR "+"==>" + tempoTotal);
		}
		else {
			double tempoInicial = System.nanoTime();
			for (int i : vet) {
				
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println ("TID#" + getId() +" É IMPAR "+"==>" + tempoTotal);
		}
	}
}
