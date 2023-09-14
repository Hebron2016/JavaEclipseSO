package controller;

public class VetTid extends Thread{
	
	private int matriz[][]= new int[3][5];
	private int t;
	public VetTid (int[][] matriz, int t) {
		this.matriz=matriz;	
		this.t=t;
				}

	@Override
	public void run() {
		MatToVet();	
	}
	

	private void  MatToVet() {
		int vet []= new int[5];
		int soma = 0;
		for (int i=t; i == t ; i ++) {
			for (int j = 0; j < 5; j++ ) {
				vet[j] = matriz [i][j];
			}
		}
		for (int i = 0; i < 5; i++) {
			soma = soma + vet[i];  
		}
		System.out.println ("TID#" + getId() + "==>" + soma);
	}

	
	
}


