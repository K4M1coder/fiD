package fr.lefournildesprovinces.vues.popups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ErrorPassword extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -2418567475278589984L;
	private final JPanel contentPane;
	private final JFrame interfaceprecedente;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public ErrorPassword(final JFrame interfaceactuelle) {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				ErrorPassword.this.dispose();
				ErrorPassword.this.interfaceprecedente.setVisible(true);
				ErrorPassword.this.interfaceprecedente.setEnabled(true);

			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 622, 211);
		this.contentPane = new JPanel();

		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.interfaceprecedente = interfaceactuelle;
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Mot de passe inconnu - merci de v\u00E9rifier votre saisie");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(162, 100, 329, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("New label");
			this.lblNewLabel_1.setIcon(new ImageIcon(ErrorPassword.class
					.getResource("/Images/fonds/avertissements.png")));
			this.lblNewLabel_1.setBounds(0, 0, 622, 211);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setIcon(new ImageIcon(ErrorPassword.class
					.getResource("/Images/actionbutons/annuler.png")));
			this.lblNewLabel_2.setBounds(264, 136, 99, 23);
		}
		return this.lblNewLabel_2;
	}
}
