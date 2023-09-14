package controller;

public class Corrida extends Thread {
	private int Dis= 1000;
	private int Salto;
	private static int P;
	public Corrida (int Dis,int Salto, int P) {
		this.Dis = Dis;
		this.Salto = Salto;
		this.P = P;
				}
	@Override
	public void run() {
		CorraSapo ();

	}
	private void CorraSapo () {

		int Soma = 0 ;
		for (int i = 1; Soma < Dis; i++) {
			Salto = (int) (Math.random()*100);
			Soma = Salto + Soma;
			System.out.println("TID#" + getId() + " ==> " + " Realizou o: " + i + " Salto e já percorreu " + Soma   );
			
		}
		if (Soma >= Dis) {
			System.out.println("TID#" + getId()+ " ==> " + " Terminou em "+ P + " Lugar");
			P++;
		}

	}
	}

