package controller;

public class vetorTempoGasto {

	public vetorTempoGasto() {
		super();
	}
	public void tempoGasto() {
	int vetor [] = new int [100000];
	for (int i = 0; i < 100000; i++) {
		vetor [i] = 0; 
	}
	double tempoInicial = System.nanoTime();

	for (int palavra : vetor) {
		System.out.println(palavra);
	}
	
	double tempoFinal = System.nanoTime();
	double tempoTotal = tempoFinal - tempoInicial;
	
	tempoTotal = tempoTotal / Math.pow(10, 9);
	System.out.println("String ==>" +tempoTotal+ " S.");
}
}