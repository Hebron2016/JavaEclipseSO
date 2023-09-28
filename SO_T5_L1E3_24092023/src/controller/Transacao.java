package controller;

import java.util.concurrent.Semaphore;

public class Transacao extends Thread {
	private int Codconta;
	private int servico;
	private Semaphore semaforo;
	private Semaphore semaforo2;
	private static int posicao = 0;
	private int saldo;
	private int valor;
	private static int finish = 0;

	public Transacao(int Codconta, int servico, Semaphore semaforo,Semaphore semaforo2 , int saldo, int valor) {
		this.Codconta = Codconta;
		this.servico = servico;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
		this.saldo = saldo;
		this.valor = valor;
	}

	@Override
	public void run() {
		narrarServico();
		if (servico == 1) {
			try {
				semaforo.acquire();
				CalcS();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
		if (servico == 2) {
			try {
				semaforo2.acquire();
				CalcD();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}
		}
		terminou();
	}

	private void narrarServico() {
		String descricaoS = null;
		if (servico == 1) {
			descricaoS = "Saque";
		}
		if (servico == 2) {
			descricaoS = "Desposito";
		}
		System.out.println("A CONTA #" + Codconta + " quer realizar o servico " + descricaoS + "|| o saldo da conta é: "
				+ saldo + "R$|| manipule usando o valor:" + valor);
	}

	private void CalcS() {
		posicao++;
		System.out.println("#" + Codconta + " É O " + posicao + " a chegar");
			System.out.println("#" + Codconta + " VAI SACAR " + valor + "R$" + " - " + saldo + "R$");
			saldo -= valor;
			System.out.println("#" + Codconta + "Saldo pós servico de Saque :" + saldo);
	}

	private void CalcD() {
		posicao++;
		System.out.println("#" + Codconta + " É O " + posicao + " a chegar");
			System.out.println("#" + Codconta + " VAI DEPOSITAR " + valor + "R$" + " + " + saldo + "R$");
			saldo += valor;
			System.out.println("#" + Codconta + "Saldo pós servico de deposito :" + saldo);
	}

	private void terminou() {
		finish++;
		System.out.println("#" + Codconta + " É O " + finish + " a TERMINAR");
	}

}
