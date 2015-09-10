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

	/**
	 *
	 */

//	public Loading() { // faill resize gif animated... have to find something
//		this.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		this.setBounds(461, 384, 400, 300);
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File("/Images/ajax_loader_orange_512.gif"));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		Image dimg = img.getScaledInstance(getPreferredSize().width, getPreferredSize().height,
//		        Image.SCALE_FAST);
//		this.setIcon(new ImageIcon(dimg));
//		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//
//	}

	public Loading() {
		this.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.setBounds(461, 384, 64, 64);
		this.setIcon(new ImageIcon(Loading.class.getResource("/Images/loading.gif")));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}
}
