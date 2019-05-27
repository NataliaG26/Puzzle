package threads;

import java.io.IOException;

import model.Scene;

public class PuzzleLoaderThread extends Thread {
	
	public PuzzleLoaderThread(Scene r) throws IOException {
		run(r);
	}
	
	public void run(Scene r) throws IOException {
		r.loadCategorys();
	}
	
}
