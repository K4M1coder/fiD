package fr.lefournildesprovinces.vues.opcom;

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

import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class SuccesMAJClientOC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5671883931760381452L;
	private final String civiliteClient;
	private final JPanel contentPane;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_6;
	private JLayeredPane layeredPane;
	private JLabel lblClientInsreAvec;
	private JLabel lblMiseJour;
	private JLabel lblNewLabel;
	private final String nomClient;
	private final String prenomClient;
	private String privilege;

	public SuccesMAJClientOC(final String civilite, final String nom,
			final String prenom, final String dateNaissance,
			final int numeroOperationCommerciale, final int numeromagasin,
			final String age) {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				SuccesMAJClientOC.this.dispose();
				final MenuPrincipal fenetre = new MenuPrincipal();
				fenetre.setVisible(true);
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				SuccesMAJClientOC.this.lblClientInsreAvec.setText("Client "
						+ SuccesMAJClientOC.this.civiliteClient + " "
						+ SuccesMAJClientOC.this.nomClient + " "
						+ SuccesMAJClientOC.this.prenomClient
						+ " Mis à jour avec succès");

			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);

		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(249, 254, 30));
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.civiliteClient = civilite;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.nomClient = nom;
		this.prenomClient = prenom;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(SuccesMAJClientOC.class
						.getResource("/Images/menus-grises-operation.png")));
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				break;

			case "invite":
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				this.fond.setIcon(new ImageIcon(SuccesMAJClientOC.class
						.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(SuccesMAJClientOC.class
						.getResource("/Images/menus_operation.png")));
				break;

			}
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMAJClientOC.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(239, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					SuccesMAJClientOC.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(348, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					SuccesMAJClientOC.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(462, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					SuccesMAJClientOC.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(704, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMAJClientOC.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(862, 232, 189, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("");
			this.label_6.setIcon(new ImageIcon(SuccesMAJClientOC.class
					.getResource("/Images/continuer.png")));
			this.label_6.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMAJClientOC.this.dispose();
				}
			});
			this.label_6.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_6.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setBounds(484, 458, 313, 44);
		}
		return this.label_6;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblClientInsreAvec());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblMiseJour());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblClientInsreAvec() {
		if (this.lblClientInsreAvec == null) {
			this.lblClientInsreAvec = new JLabel("");
			this.lblClientInsreAvec
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblClientInsreAvec
					.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblClientInsreAvec.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblClientInsreAvec.setForeground(Color.GRAY);
			this.lblClientInsreAvec.setBounds(285, 413, 708, 14);
		}
		return this.lblClientInsreAvec;
	}

	private JLabel getLblMiseJour() {
		if (this.lblMiseJour == null) {
			this.lblMiseJour = new JLabel("Mettre \u00E0 jour un bulletin");
			this.lblMiseJour.setForeground(Color.GRAY);
			this.lblMiseJour.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMiseJour.setBounds(242, 286, 281, 14);
		}
		return this.lblMiseJour;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(SuccesMAJClientOC.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}
}
