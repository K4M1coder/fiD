package fr.lefournildesprovinces.vues.popups;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *  this class extends JLabel from swing to display a Loading animation from gif
 *
 * @author admin
 *
 */
public class Loading extends JLabel {

	/**
	 *
	 */
	private static final long serialVersionUID = -3808389872407870152L;

	public Loading() {
		this.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.setBounds(461, 384, 400, 300);
		this.setIcon(new ImageIcon(Loading.class.getResource("/Images/ajax-loader.gif")));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}
}
