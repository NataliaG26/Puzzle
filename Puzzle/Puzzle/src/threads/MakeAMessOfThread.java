package threads;

import java.io.IOException;
import java.util.Random;

import controller.GameController;

public class MakeAMessOfThread extends Thread{
	
	private GameController gameController;
	private int n;
	
	public MakeAMessOfThread(GameController gameC, int n) throws IOException {
		gameController = gameC;
		this.n = n*n;
	}
	
	public void run(){
		Random aleatorio = new Random(System.currentTimeMillis());
		int num = aleatorio.nextInt(4)+1;
		for(int i = 0; i < n; i++){
			num = aleatorio.nextInt(4)+1;
			gameController.makeAMessOf(num);
			aleatorio.setSeed(aleatorio.nextLong());
		}
	}
}
