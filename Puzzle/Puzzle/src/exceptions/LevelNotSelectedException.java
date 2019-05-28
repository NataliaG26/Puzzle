package exceptions;

import javax.swing.JOptionPane;

public class LevelNotSelectedException extends Exception{
	private static final long serialVersionUID = 5L;

	public LevelNotSelectedException(String r) {
		JOptionPane.showMessageDialog(null,"You haven't picked a Level");
	}
}
