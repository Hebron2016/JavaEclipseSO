package view;

import java.util.concurrent.Semaphore;

import controller.Transacao;

public class ThreadSD {

	public static void main(String[] args) {
		int Codconta = 0;
		int servico = 0;
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		Semaphore semaforo2 = new Semaphore(permissoes);
		int saldo =0;
		int valor =0;

		for (int idPessoa = 0; idPessoa < 20; idPessoa++) {
			Codconta = (int) ((Math.random()*100000)+10000);
			servico = (int) ((Math.random()*2)+1);
			saldo = (int) ((Math.random()*9501)+500);
			valor = (int) ((Math.random()*300)+100);
			Thread tsd = new Transacao(Codconta, servico, semaforo, semaforo2, saldo, valor);
			tsd.start();

		}
	}
}
