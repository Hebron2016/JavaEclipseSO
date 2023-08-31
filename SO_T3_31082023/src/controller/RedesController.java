package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController(){
		super();
		
	}
	private String os() {
		 String os = System.getProperty("os.name");
		return os;
		}
	
	public String getOs() {
		return this.os();
	}
	
	public String ip (String SO) {
		String process = "";
		if (SO.contains("Windows")) {
			 process = "IPCONFIG";

				try {
					Process p =Runtime.getRuntime().exec(process);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						if (linha.contains("IPv4")) {
							String[] fraseHack = linha.split(" ");
							for (String palavra : fraseHack) {
								if (palavra =="IPv4") {
									System.out.println(palavra);
								}
							String [] NumeroIp = linha.split(":");
								for (int i=0; i<=1;i++) {
									if (i==1) {
										System.out.println(NumeroIp[i]);
									}
								}
							}
						}
						if (linha.contains("Adaptador")) {
							System.out.println(linha);
						}
						
					
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		else{
			 process = "ifconfig";
			 try {
					Process p =Runtime.getRuntime().exec(process);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						if (linha.contains("inet")) {
							String[] fraseHack = linha.split(" ");
							for (String palavra : fraseHack) {
								if (palavra =="end.:") {
									System.out.println(palavra);
								}
							String [] NumeroIp = linha.split("Bcast");
								for (int i=0; i<1;i++) {
									if (i==0) {
										System.out.println(NumeroIp[i]);
									}
								}
							}
						}
						if (linha.contains("encap")) {
							String [] NumeroIp = linha.split(" ");
							for (int i=0; i<1;i++) {
								if (i==0) {
									System.out.println(NumeroIp[i]);
						}
						
					
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} 
					}
			 }
				catch (IOException e) {
					e.printStackTrace();
				}
		
		}
		return SO;
	}
	public void readProcess(String process) {
		if (process == "IPCONFIG") {
			String Pingado = "ping -4 -n 10 www.google.com.br";
	
		try {
			Process p =Runtime.getRuntime().exec(Pingado);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
		if (process == "IPCONFIG") {
			String Pingado = "ping -4 -c 10 www.google.com.br";
	
		try {
			Process p =Runtime.getRuntime().exec(Pingado);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}	
}
	
	
