package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController(){
		super();
		
	}
	private String os() {
		 String os = System.getProperty("os.name");
		return os;
}
	public String getOs() {
		return this.os();
	}
	
	public void listaProcessos (String SO) {
	
	if (SO == "Windows") {
		try {
			String process = "TASK/FO TABLE";
			Process p =Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
	}
		if (SO == "Linux") {
			try {
				String process = "ps -ef";
				Process p =Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
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
	public void mataPid (String SO) {
		
		if (SO == "Windows") {
			try {
				String process = "TASKKILL/ PID pid_do_processo";
				Process p =Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
		}
			if (SO == "Linux") {
				try {
					String process = "kill -9 pid_do_processo";
					Process p =Runtime.getRuntime().exec(process);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						System.out.println(linha);
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
		public void mataNome (String SO) {
			
			if (SO == "Windows") {
				try {
					String process = "TASKKILL/ IM nome_do_processo";
					Process p =Runtime.getRuntime().exec(process);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						System.out.println(linha);
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (IOException e) {
					e.printStackTrace();
			}
				if (SO == "Linux") {
					try {
						String process = "pkill -f nome_do_processo";
						Process p =Runtime.getRuntime().exec(process);
						InputStream fluxo = p.getInputStream();
						InputStreamReader leitor = new InputStreamReader(fluxo);
						BufferedReader buffer = new BufferedReader(leitor);
						String linha = buffer.readLine();
						while (linha != null) {
							System.out.println(linha);
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
}