package threads;

import java.io.IOException;
import java.util.Random;

import controller.GameController;
import model.Level;

public class CheckerThread extends Thread{
	
	private GameController gameController;
	
	public CheckerThread(GameController gameC) throws IOException {
		gameController = gameC;
	}
	
	public void run(){
		System.out.println("empezooo");
		boolean terminar = false;
		while(!gameController.verifiGame()) {
			
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("termino hilo");
	}
}
