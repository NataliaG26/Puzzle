package exceptions;

import javax.swing.JOptionPane;

public class PlayerNotSelected extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PlayerNotSelected() {
		JOptionPane.showMessageDialog(null, "You haven't picked a player");
	}

}
