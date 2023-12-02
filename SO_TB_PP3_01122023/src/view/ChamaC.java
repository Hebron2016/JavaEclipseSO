package view;

import controller.LeiaC;

import java.io.IOException;

public class ChamaC {

	public static void main(String[] args) throws IOException {
		LeiaC lendo= new LeiaC();
		String path = null;
		String os = System.getProperty("os.name");
		if(os.contains("Windows")){
			path = "C:\\TEMP\\";
		}else {
			path = "cd /tmp/";
		}
		String nome = "wiki.json";
		lendo.readFile(path,nome);
	}

}
