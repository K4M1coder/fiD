package fr.lefournildesprovinces.vues.fidelite;

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
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.InterrogationClientPorteurdeCarte;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;

public class SuccesMajClientFidelite extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 6243037195155185329L;
	private final String civiliteClient;
	private final JPanel contentPane;
	private JLabel fond;
	private final int identifiantmagasin;
	private final int identifiantoperation;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblClientInsreAvec;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblQuitterLaSaisie;
	private final String nomClient;
	private final String prenomClient;
	private String privilege;
	private final String provenanceprecedente;

	public SuccesMajClientFidelite(final String civilite, final String nom,
			final String prenom, final String dateNaissance, final String age,
			final String provenance, final int idoperation, final int idmagasin) {

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				SuccesMajClientFidelite.this.lblClientInsreAvec
						.setText("Client "
								+ SuccesMajClientFidelite.this.civiliteClient
								+ " " + SuccesMajClientFidelite.this.nomClient
								+ " "
								+ SuccesMajClientFidelite.this.prenomClient
								+ " mis a jour avec avec succès");
				if (SuccesMajClientFidelite.this.provenanceprecedente
						.equals("operation_commerciale")) {
					SuccesMajClientFidelite.this.lblQuitterLaSaisie
							.setVisible(true);
					SuccesMajClientFidelite.this.lblNewLabel_1.setBounds(401,
							458, 313, 44);
				}

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
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.provenanceprecedente = provenance;
		this.identifiantoperation = idoperation;
		this.identifiantmagasin = idmagasin;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(SuccesMajClientFidelite.class
						.getResource("/Images/fonds/menus-grises-fidelite.png")));
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

				this.fond.setIcon(new ImageIcon(SuccesMajClientFidelite.class
						.getResource("/Images/fonds/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(SuccesMajClientFidelite.class
						.getResource("/Images/fonds/menus_fidelite.png")));
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
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					SuccesMajClientFidelite.this.dispose();
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
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					SuccesMajClientFidelite.this.dispose();
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
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					SuccesMajClientFidelite.this.dispose();
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
					SuccesMajClientFidelite.this.dispose();
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
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMajClientFidelite.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(878, 232, 167, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblClientInsreAvec());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblQuitterLaSaisie());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_2());
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
			this.lblClientInsreAvec.setBounds(260, 390, 759, 14);
		}
		return this.lblClientInsreAvec;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Mise à jour Fiche Client");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 570, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					SuccesMajClientFidelite.class
							.getResource("/Images/actionbutons/continuer.png")));
			this.lblNewLabel_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (SuccesMajClientFidelite.this.provenanceprecedente
							.equals("operation_commerciale")) {
						final InterrogationClientPorteurdeCarte fenetre = new InterrogationClientPorteurdeCarte(
								SuccesMajClientFidelite.this.identifiantoperation,
								SuccesMajClientFidelite.this.identifiantmagasin);
						fenetre.setVisible(true);
						SuccesMajClientFidelite.this.dispose();

					}

					else {
						final MenuPrincipal fenetre = new MenuPrincipal();
						fenetre.setVisible(true);
						SuccesMajClientFidelite.this.dispose();
					}
				}
			});
			this.lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setBounds(484, 458, 313, 44);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setIcon(new ImageIcon(
					SuccesMajClientFidelite.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_2.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblQuitterLaSaisie() {
		if (this.lblQuitterLaSaisie == null) {
			this.lblQuitterLaSaisie = new JLabel("");
			this.lblQuitterLaSaisie.setIcon(new ImageIcon(
					SuccesMajClientFidelite.class
							.getResource("/Images/actionbutons/quitter-saisie.png")));
			this.lblQuitterLaSaisie
					.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblQuitterLaSaisie
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblQuitterLaSaisie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMajClientFidelite.this.dispose();
				}
			});
			this.lblQuitterLaSaisie.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblQuitterLaSaisie.setForeground(Color.GRAY);
			this.lblQuitterLaSaisie.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblQuitterLaSaisie.setVisible(false);
			this.lblQuitterLaSaisie.setBounds(715, 442, 142, 79);
		}
		return this.lblQuitterLaSaisie;
	}
}
