package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;

public class SuccesOperationClientCarteFidelite extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2383762713781352517L;
	private final String choixprecedent;
	private final JPanel contentPane;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLayeredPane layeredPane;
	private JLabel lblMessage;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private final String numeroCarteFidelite;
	private String privilege;

	public SuccesOperationClientCarteFidelite(final String numero,
			final String choix, final String text) {

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				switch (SuccesOperationClientCarteFidelite.this.choixprecedent) {
				case "Menu > Gestion Carte de Fidélité > Désincription Newslettter":
					SuccesOperationClientCarteFidelite.this.lblMessage
							.setText("Client n° "
									+ SuccesOperationClientCarteFidelite.this.numeroCarteFidelite
									+ " est désabonné de la newsletter");
					SuccesOperationClientCarteFidelite.this.lblNewLabel
							.setText(text);
					break;
				case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
					SuccesOperationClientCarteFidelite.this.lblMessage
							.setText("Carte n° "
									+ SuccesOperationClientCarteFidelite.this.numeroCarteFidelite
									+ " supprimée avec succès");
					break;
				case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
					SuccesOperationClientCarteFidelite.this.lblMessage
							.setText("Carte n° "
									+ SuccesOperationClientCarteFidelite.this.numeroCarteFidelite
									+ " mise à jour avec succès");
					break;
				case "Menu > Gestion Carte de Fidélité > Nouvelle Fiche Client":
					SuccesOperationClientCarteFidelite.this.lblMessage
							.setText("Carte n° "
									+ SuccesOperationClientCarteFidelite.this.numeroCarteFidelite
									+ " à été créée avec succès");
					break;
				}

			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.contentPane.setForeground(Color.GRAY);
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.numeroCarteFidelite = numero;
		this.choixprecedent = choix;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								SuccesOperationClientCarteFidelite.class
										.getResource("/Images/menus-grises-fidelite.png")));
				this.label.setEnabled(false);
				this.label.setVisible(false);
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);

				break;

			case "invite":
				this.label.setEnabled(false);
				this.label.setVisible(false);
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);

				this.fond
						.setIcon(new ImageIcon(
								SuccesOperationClientCarteFidelite.class
										.getResource("/Images/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						SuccesOperationClientCarteFidelite.class
								.getResource("/Images/menus_fidelite.png")));
				break;

			}
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					SuccesOperationClientCarteFidelite.this.dispose();
				}
			});
			this.label.setBounds(472, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					SuccesOperationClientCarteFidelite.this.dispose();
				}
			});
			this.label_1.setBounds(589, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					SuccesOperationClientCarteFidelite.this.dispose();
				}
			});
			this.label_2.setBounds(703, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesOperationClientCarteFidelite.this.dispose();
				}
			});
			this.label_3.setBounds(235, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesOperationClientCarteFidelite.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(877, 231, 162, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.setIcon(new ImageIcon(
					SuccesOperationClientCarteFidelite.class
							.getResource("/Images/continuer.png")));
			this.label_5.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesOperationClientCarteFidelite.this.dispose();
				}
			});
			this.label_5.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_5.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setBounds(484, 458, 313, 44);
		}
		return this.label_5;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMessage());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblMessage() {
		if (this.lblMessage == null) {
			this.lblMessage = new JLabel("");
			this.lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMessage.setForeground(Color.GRAY);
			this.lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblMessage.setBounds(242, 415, 797, 14);
		}
		return this.lblMessage;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(242, 286, 434, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					SuccesOperationClientCarteFidelite.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}
}
