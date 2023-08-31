package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class main {

	public static void main (String[] args) {
		int opc=0;
		RedesController os = new RedesController();
		String SO = os.getOs();
		while(opc != 9){
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu \n 1- Descubra o nome do seu Sistema operacional \n 2- Descubra seu IP \n 3- Faça um ping para o google \n 9-fim"));
		switch (opc) {
		case 1:
			System.out.print(os.getOs());
			JOptionPane.showMessageDialog(null, "Consulta disponível no console");
			break;
			
		
		case 2:
			System.out.println(  os.ip(SO));
			JOptionPane.showMessageDialog(null, "Consulta disponível no console");
			break;
		
		case 3:
			String process = "PING -4 -n 10 www.google.com.br";
			os.readProcess(process);	
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "fim");
			break;
			default:JOptionPane.showMessageDialog(null, "Não há essa opção");
			
	}

}
	}
}
