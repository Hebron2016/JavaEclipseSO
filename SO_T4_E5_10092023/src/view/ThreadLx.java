package view;

import controller.PingLinux;

public class ThreadLx {
	public static void main(String[] args) {
		int op = 0;
		for (int n = 0 ; n<3; n++) {
			Thread Tid = new PingLinux (op);
			Tid.start();		
		}
	}
}
