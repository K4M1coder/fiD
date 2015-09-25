package fr.lefournildesprovinces.vues.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LoginDenied extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -135559737903356969L;
	private final JPanel contentPane;
	private JLayeredPane layeredPane;
	private JLabel lblCliquerPourContinuer;
	private JLabel lblConnexionRefuseMerci;
	private JLabel lblNewLabel;

	public LoginDenied() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				LoginDenied.this.dispose();
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 621, 213);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.YELLOW);
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
//		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final Login fenetre = new Login();
					fenetre.setVisible(true);
					LoginDenied.this.dispose();

				}
			});
			this.layeredPane.add(this.getLblConnexionRefuseMerci());
			this.layeredPane.add(this.getLblCliquerPourContinuer());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblCliquerPourContinuer() {
		if (this.lblCliquerPourContinuer == null) {
			this.lblCliquerPourContinuer = new JLabel("");
			this.lblCliquerPourContinuer.setIcon(new ImageIcon(
					LoginDenied.class.getResource("/Images/actionbutons/annuler.png")));
			this.lblCliquerPourContinuer.setBounds(264, 140, 99, 23);
		}
		return this.lblCliquerPourContinuer;
	}

	private JLabel getLblConnexionRefuseMerci() {
		if (this.lblConnexionRefuseMerci == null) {
			this.lblConnexionRefuseMerci = new JLabel(
					"Connexion refus\u00E9e, Merci de v\u00E9rifier votre identifiant et votre mot de passe");
			this.lblConnexionRefuseMerci.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblConnexionRefuseMerci.setForeground(Color.GRAY);
			this.lblConnexionRefuseMerci.setBounds(94, 105, 464, 14);
		}
		return this.lblConnexionRefuseMerci;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(LoginDenied.class
					.getResource("/Images/fonds/avertissements.png")));
			this.lblNewLabel.setBounds(0, 0, 628, 215);
		}
		return this.lblNewLabel;
	}
}
