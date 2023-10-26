package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController implements IArquivosController {
	public ArquivosController() {
	}
	
	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path,nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				String[] VetPalavras = linha.split(",");
				String doisG = VetPalavras[2];
				if(doisG.contains("GROUP")){
					System.out.println(VetPalavras[0]+"\t"+VetPalavras[1]+"\t"+VetPalavras[3]);
				}
				if(doisG.contains("Fruits")) {
				System.out.println(VetPalavras[0]+"\t"+VetPalavras[1]+"\t"+VetPalavras[3]);
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

