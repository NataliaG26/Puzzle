package exceptions;

import javax.swing.JOptionPane;

public class PLayerNotFoundException extends Exception {
	
	private static final long serialVersionUID = 2L;

	public PLayerNotFoundException(String r) {
		JOptionPane.showMessageDialog(null,"The player"+r+"Does not exist in the list of players", "PLAYER NOT FOUND", JOptionPane.ERROR_MESSAGE);
	}
}
