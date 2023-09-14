package view;

import controller.Corrida;

public class Sapos {
	public static void main(String[] args) {

		int Dis = 1000;
		int Salto = 0;
		int P=1;
		for (int n = 1 ; n<6; n++) {
			Thread Tid = new Corrida (Dis,Salto,P);
			Tid.start();		
			}
		}
	}

