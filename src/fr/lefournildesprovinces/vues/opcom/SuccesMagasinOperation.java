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

import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.InterrogationClientPorteurdeCarte;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;

public class SuccesMagasinOperation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6743634670741063180L;
	private final JPanel contentPane;
	boolean etatprecedent;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLayeredPane layeredPane;
	private JLabel lblCliquerPourContinuer;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblQuitterLaSaisie;
	private JLabel lblSu;
	private final String MessageInsertion;
	private final String provenance;

	public SuccesMagasinOperation(final String message, final boolean etat,
			final String text, final String message2, final String pro,
			final int operation, final int magasin) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				SuccesMagasinOperation.this.lblSu.setText(text);
				SuccesMagasinOperation.this.lblNewLabel
						.setText(SuccesMagasinOperation.this.MessageInsertion);
				SuccesMagasinOperation.this.lblNewLabel_1.setText(message2);

				if (SuccesMagasinOperation.this.provenance
						.equals("operationcommerciale")) {
					SuccesMagasinOperation.this.lblQuitterLaSaisie
							.setVisible(true);
					SuccesMagasinOperation.this.lblCliquerPourContinuer
							.setBounds(401, 458, 313, 44);
					SuccesMagasinOperation.this.lblCliquerPourContinuer
							.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(final MouseEvent arg0) {
									final InterrogationClientPorteurdeCarte fenetre = new InterrogationClientPorteurdeCarte(
											operation, magasin);
									fenetre.setVisible(true);
									SuccesMagasinOperation.this.dispose();
								}
							});

				} else {

					SuccesMagasinOperation.this.lblCliquerPourContinuer
							.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(final MouseEvent arg0) {
									final MenuPrincipal fenetre = new MenuPrincipal();
									fenetre.setVisible(true);
									SuccesMagasinOperation.this.dispose();
								}
							});

				}
			}
		});

		this.setUndecorated(true);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();

		this.contentPane.setBorder(null);

		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.MessageInsertion = message;
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.provenance = pro;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setBounds(216, 231, 850, 338);

			final String texte = Message.getMessageaffichagefond();

			switch (texte) {
			case "Désincription Newslettter":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_fidelite.png")));
				break;
			case "Mise à jour d'une carte de fidélité":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_fidelite.png")));
				break;
			case "Suppression d'une carte de fidélité":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_fidelite.png")));
				break;
			case "Nouvelle carte de fidélité":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_fidelite.png")));
				break;
			case "Nouvelle Opération Commerciale":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_operation.png")));
				break;
			case "Mise à Jour d'une Opération Commerciale":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_operation.png")));
				break;
			case "Suppression d'une Opération Commerciale":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_operation.png")));
				break;
			case "Supprimer un bulletin":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_operation.png")));
				break;
			case "Mettre à jour un bulletin":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_operation.png")));
				break;
			case "Saisir un bulletin":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_operation.png")));
				break;
			case "Mettre à jour un mot de passe utilisateur":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_accueil.png")));
				break;
			case "Créer un profil utilisateur":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_accueil.png")));
				break;
			case "Supprimer un utilisateur":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_accueil.png")));
				break;
			case "Mettre a jour un privilege utilisateur":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_accueil.png")));
				break;
			case "Mise à jour d'un magasin":
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_magasin.png")));
				break;
			default:
				this.fond.setIcon(new ImageIcon(SuccesMagasinOperation.class
						.getResource("/Images/menus_magasin.png")));
				break;
			}

			// fond.setIcon(new
			// ImageIcon(SuccesMagasinOperation.class.getResource("/Images/menus_magasin.png")));

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
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.label.setBounds(236, 231, 114, 44);
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
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.label_1.setBounds(349, 231, 114, 44);
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
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.label_2.setBounds(590, 231, 114, 44);
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
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.label_3.setBounds(704, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.label_4.setBounds(869, 231, 184, 46);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.label_5.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_5.setBounds(466, 231, 114, 44);
		}
		return this.label_5;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblSu());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblCliquerPourContinuer());
			this.layeredPane.add(this.getLblQuitterLaSaisie());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_2());
		}
		return this.layeredPane;
	}

	private JLabel getLblCliquerPourContinuer() {
		if (this.lblCliquerPourContinuer == null) {
			this.lblCliquerPourContinuer = new JLabel("");
			this.lblCliquerPourContinuer.setIcon(new ImageIcon(
					SuccesMagasinOperation.class
							.getResource("/Images/continuer.png")));

			this.lblCliquerPourContinuer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblCliquerPourContinuer
					.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblCliquerPourContinuer
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblCliquerPourContinuer.setForeground(Color.GRAY);
			this.lblCliquerPourContinuer.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblCliquerPourContinuer.setBounds(484, 458, 221, 44);
		}
		return this.lblCliquerPourContinuer;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(242, 391, 791, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(320, 416, 640, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setIcon(new ImageIcon(
					SuccesMagasinOperation.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_2.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblQuitterLaSaisie() {
		if (this.lblQuitterLaSaisie == null) {
			this.lblQuitterLaSaisie = new JLabel("");
			this.lblQuitterLaSaisie.setIcon(new ImageIcon(
					SuccesMagasinOperation.class
							.getResource("/Images/quitter-saisie.png")));
			this.lblQuitterLaSaisie.setVisible(false);
			this.lblQuitterLaSaisie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SuccesMagasinOperation.this.dispose();
				}
			});
			this.lblQuitterLaSaisie.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblQuitterLaSaisie
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblQuitterLaSaisie.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblQuitterLaSaisie.setForeground(Color.GRAY);
			this.lblQuitterLaSaisie.setBounds(683, 467, 136, 26);
		}
		return this.lblQuitterLaSaisie;
	}

	private JLabel getLblSu() {
		if (this.lblSu == null) {
			this.lblSu = new JLabel("");
			this.lblSu.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblSu.setForeground(Color.GRAY);
			this.lblSu.setBounds(242, 286, 598, 14);
		}
		return this.lblSu;
	}
}
