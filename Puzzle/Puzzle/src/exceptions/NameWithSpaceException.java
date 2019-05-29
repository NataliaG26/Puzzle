package exceptions;

import javax.swing.JOptionPane;

public class NameWithSpaceException extends Exception{
	
	private static final long serialVersionUID = 6L;

	public NameWithSpaceException() {
		JOptionPane.showMessageDialog(null,"enter a valid name");
	}
}
