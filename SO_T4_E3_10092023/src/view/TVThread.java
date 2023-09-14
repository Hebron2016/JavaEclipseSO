package view;

import controller.ThreadVetor;

public class TVThread {
	public static void main(String[] args) {
		int vet[] = new int [1000];
		for (int i = 0; i<vet.length;i++) {
			vet[i]= (int) (Math.random()+1*101);

		}
		
		for (int n = 1 ; n<3; n++) {
			Thread Tid = new ThreadVetor (n,vet);
			Tid.start();
		}
	}
}