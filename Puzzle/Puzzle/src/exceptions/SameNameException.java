
package exceptions;

import javax.swing.JOptionPane;

public class SameNameException extends Exception {
	
	private static final long serialVersionUID = 4L;
	
	public SameNameException(String r) {
		JOptionPane.showMessageDialog(null, r+" Already exist in the index");
		
	}
}
