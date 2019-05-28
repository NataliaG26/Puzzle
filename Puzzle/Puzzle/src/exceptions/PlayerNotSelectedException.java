package exceptions;

import javax.swing.JOptionPane;

public class PlayerNotSelectedException extends Exception {

	private static final long serialVersionUID = 3L;
	
	public PlayerNotSelectedException() {
		JOptionPane.showMessageDialog(null, "You haven't picked a player");
	}

}
