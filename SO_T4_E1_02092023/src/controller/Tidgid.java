package controller;

public class Tidgid extends Thread{
	long id;
	private int idThread;
	
	
	public Tidgid(int idThread) {
		this.idThread = idThread;
	}
	
	@Override
	public void run() {
		super.run();
		
	
		 id = getId();
		 System.out.println(id);
	}

	public int getIdThread() {
		return idThread;
	}

}



