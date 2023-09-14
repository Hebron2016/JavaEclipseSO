package view;

import controller.VetTid;

public class CallThread {

	public static void main(String[] args) {
		int matriz[][]= new int[3][5];
		
			for (int i = 0; i < 3; i++ ) {
				for (int j = 0; j < 5; j++) {
					 matriz[i][j] = (int) (Math.random()*10);		
		
				}
		}

					for (int t = 0 ; t<3; t++) {
						Thread Tid = new VetTid (matriz,t);
						Tid.start();
					}
				}	
			}
	

