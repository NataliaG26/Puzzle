package exceptions;

import javax.swing.JOptionPane;

public class LevelNotUnlockedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public LevelNotUnlockedException() {
		JOptionPane.showMessageDialog(null, "This level hasen't been found or unlock");
	}
}
