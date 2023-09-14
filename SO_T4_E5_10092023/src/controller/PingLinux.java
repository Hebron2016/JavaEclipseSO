package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingLinux extends Thread {
	private static int op;
	public PingLinux (int op) {
		this.op = op;
	}
	
	@Override
	public void run() {
		Ping();

	}
	private void Ping () {
		String [] vetorPalavras = new String [8];
		String process = "";
		String site = "";
		switch (op) {

		case 0: 
			 process = "ping -4 -c 10 www.uol.com.br";
			 site = "UOL";
			break;	
		case 1:
			 process = "ping -4 -c 10 www.terra.com.br";
			 site = "Terra";
			break;
		case 2:
			 process = "ping -4 -c 10 www.google.com.br";
			 site = "Google";
			break;
		}
	
		op++;

		try {
			Process p =Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				vetorPalavras = linha.split("time=");
				System.out.println(site + "==>" + vetorPalavras[2]);
				linha = buffer.readLine();
				if(linha == "rtt") {
					vetorPalavras = linha.split("/");
					System.out.println("Operação finalizada"+site +"==>" + vetorPalavras[8]);

				}
				}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	}

