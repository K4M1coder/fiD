package fr.lefournildesprovinces.applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.lefournildesprovinces.start;

public class Accueil extends JApplet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPane;
	private JLayeredPane layeredPane;
	private JLabel lblWelcome;
	private JLabel lblValidate;

	public Accueil() {
		System.out.println("Applet launch");
		this.setForeground(Color.YELLOW);
		this.setBounds(100, 100, 450, 143);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.YELLOW);
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.contentPane.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ('\n' == e.getKeyChar()) {
					initLoginScreen();
				}
			};
		});
		this.contentPane.setFocusable(true);
	}


	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblWelcome());
			this.layeredPane.add(this.getLblValidate());
		}
		return this.layeredPane;
	}

	private JLabel getLblWelcome() {
		if (this.lblWelcome == null) {
			this.lblWelcome = new JLabel(
					"Bienvenue dans le logiciel de gestion Marketing");
			this.lblWelcome.setForeground(Color.GRAY);
			this.lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblWelcome.setBounds(91, 36, 267, 14);
		}
		return this.lblWelcome;
	}

	/**
	 * Initialize the login screen.
	 */
	private void initLoginScreen() {
		start.lookNFeel();
	}

	private JLabel getLblValidate() {
		if (this.lblValidate == null) {
			this.lblValidate = new JLabel("");
			this.lblValidate.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValidate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					initLoginScreen();
				}
			});
			this.lblValidate.setIcon(new ImageIcon(Accueil.class
					.getResource("/Images/actionbutons/valider.png")));
			this.lblValidate.setBounds(175, 85, 99, 23);
		}
		return this.lblValidate;
	}

}
