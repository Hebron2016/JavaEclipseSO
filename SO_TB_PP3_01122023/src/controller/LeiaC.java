package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeiaC {

	public void readFile(String path, String nome) throws IOException {
		int cont = 0;
		File arq = new File(path,nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				String[] VetPalavras = linha.split(",");
				String Mostrador = null;
				String Mostra2 = null;
				for (int i = 0; i<VetPalavras.length;i++) {
					if(VetPalavras[i].contains("00")&& !VetPalavras[i].contains("views")){
						if (VetPalavras[i].contains("000")){
							String Charada = VetPalavras[i];
							String Char1 = Charada.substring(0,21);
							Mostrador = Char1;
							Mostrador = Mostrador.replaceAll("\"", "");		
							cont++;
							}
							else {
								String leia1 = VetPalavras[i];
								String[] VetMostra1 = leia1.split("00");
								Mostrador = VetMostra1[0];
								Mostrador = Mostrador.replaceAll("\"", "");		
								cont++;
						}
					}
					if(VetPalavras[i].contains("views")){
						 Mostra2 = VetPalavras[i];
						 Mostra2 = Mostra2.replaceAll("\"", "");	
						 Mostra2 = Mostra2.replaceAll("}", "");	
						 Mostra2 = Mostra2.replaceAll("]", "");	
						 cont++;
					}
					if(cont ==2) {
						System.out.println(Mostrador+"\t"+Mostra2);
						cont = 0;
					}
				}
				
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
				}else {
					throw new IOException ("Arquivo invalido");
			}		
	}
}

