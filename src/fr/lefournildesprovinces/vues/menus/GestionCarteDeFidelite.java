package fr.lefournildesprovinces.vues.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.FideliteNouvelleFicheClient;
import fr.lefournildesprovinces.vues.Login;
import fr.lefournildesprovinces.vues.SelectionNumeroCarteFidelite2;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class GestionCarteDeFidelite extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4113089650401818905L;
	private JComboBox<Object> comboBox;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_DeleteCarteFid;
	private JLabel label_ModCarteFid;
	private JLabel label_NewCarteFid;
	private JLabel label_SearchCarteFid;
	private JLabel label_UnsubscribeCarteFid;
	private JLabel lblFermer;
	private JLabel lblMenu;
	private JLabel lblMerciDeFaire;
	private JLabel lblNewLabel;
	private JLabel lblNouvelleFicheClientmise;
	private JLabel lblValider;
	private JLayeredPane layeredPane;
	private String privilege;
	private String selection;
	private final JFrame interfaceActuelle;
	private final JPanel contentPane;

	public GestionCarteDeFidelite() {

		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);
		this.interfaceActuelle = this;

		GestionCarteDeFidelite.this.lblMerciDeFaire.setVisible(false);
		GestionCarteDeFidelite.this.lblMerciDeFaire.setEnabled(false);
		GestionCarteDeFidelite.this.lblValider.setVisible(false);
		GestionCarteDeFidelite.this.lblValider.setEnabled(false);
		GestionCarteDeFidelite.this.comboBox.setVisible(false);
		GestionCarteDeFidelite.this.comboBox.setEnabled(false);
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {

			this.privilege = Login.getPrivilege();

			String[] choix = null;

			switch (this.privilege) {
			case "administrateur":
				choix = new String[] { "", "NOUVELLE carte de fidélité",
						"RECHERCHER une carte de fidelité",
						"MISE A JOUR d'une carte de fidélité",
						"SUPPRESSION d'une carte de fidélité",
						"DESINSCRIPTION Publicité Commerciale" };

				break;

			case "utilisateur":
				choix = new String[] { "", "NOUVELLE carte de fidélité",
						"RECHERCHER une carte de fidelité",
						"MISE A JOUR d'une carte de fidélité",
						"SUPPRESSION d'une carte de fidélité",
						"DESINSCRIPTION Publicité Commerciale" };

				break;

			case "invite":
				choix = new String[] { "", "NOUVELLE carte de fidélité",
						"MISE A JOUR d'une carte de fidélité" };

				break;

			}
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						GestionCarteDeFidelite.this.selection = GestionCarteDeFidelite.this.comboBox
								.getSelectedItem().toString();
						if (!selection.isEmpty()) {
							GestionCarteDeFidelite.this.lblValider
									.setVisible(true);

							GestionCarteDeFidelite.this.lblMerciDeFaire
									.setVisible(false);
						} else {
							GestionCarteDeFidelite.this.lblValider
							.setVisible(false);

					GestionCarteDeFidelite.this.lblMerciDeFaire
							.setVisible(true);
						}
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								GestionCarteDeFidelite.this.interfaceActuelle
									,message);
						fenetre.setVisible(true);
						GestionCarteDeFidelite.this.interfaceActuelle
								.setEnabled(false);
						GestionCarteDeFidelite.this.interfaceActuelle
								.setVisible(false);
						GestionCarteDeFidelite.this.lblValider
								.setVisible(false);

						GestionCarteDeFidelite.this.lblMerciDeFaire
								.setVisible(true);
					}
				}
			});
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setBorder(null);
			this.comboBox.setBounds(459, 658, 412, 22);
			this.comboBox.setFocusable(true);
			this.comboBox.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if ('\n' == e.getKeyChar()) {
						validateAction();
					}
				};
			});
		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(GestionCarteDeFidelite.class
						.getResource("/Images/menus-grises-fidelite.png")));
				this.label.setEnabled(false);
				this.label.setVisible(false);
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);

				break;

			case "invite":
				this.fond.setIcon(new ImageIcon(GestionCarteDeFidelite.class
						.getResource("/Images/menus-grises-fidelite.png")));
				this.label.setEnabled(false);
				this.label.setVisible(false);
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);

				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(GestionCarteDeFidelite.class
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
					GestionCarteDeFidelite.this.dispose();
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
					GestionCarteDeFidelite.this.dispose();
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
					GestionCarteDeFidelite.this.dispose();
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
					GestionCarteDeFidelite.this.dispose();
				}
			});
			this.label_3.setBounds(235, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenu());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblMerciDeFaire());
			this.layeredPane.add(this.getLabel_NewCarteFid());
			this.layeredPane.add(this.getLabel_SearchCarteFid());
			this.layeredPane.add(this.getLabel_ModCarteFid());
			this.layeredPane.add(this.getLabel_DeleteCarteFid());
			this.layeredPane.add(this.getLabel_UnsubscribeCarteFid());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblNouvelleFicheClientmise());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLabel_NewCarteFid() {
		if (this.label_NewCarteFid == null) {
			this.label_NewCarteFid = new JLabel("");
			this.label_NewCarteFid.setIcon(new ImageIcon(GestionCarteDeFidelite.class.getResource("/Images/menubutons/bouton-fidelite-nouvelle-carte.png")));
			this.label_NewCarteFid
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_NewCarteFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_NewCarteFid.setForeground(Color.GRAY);
			this.label_NewCarteFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionCarteDeFidelite.this.selection="NOUVELLE carte de fidélité";
					validateAction();
				}
			});
			this.label_NewCarteFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_NewCarteFid.setBounds(256, 318, 145, 225);
		}
		return this.label_NewCarteFid;
	}

	private JLabel getLabel_SearchCarteFid() {
		if (this.label_SearchCarteFid == null) {
			this.label_SearchCarteFid = new JLabel("");
			this.label_SearchCarteFid.setIcon(new ImageIcon(GestionCarteDeFidelite.class.getResource("/Images/menubutons/bouton-fidelite-recherche.png")));
			this.label_SearchCarteFid
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_SearchCarteFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_SearchCarteFid.setForeground(Color.GRAY);
			this.label_SearchCarteFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionCarteDeFidelite.this.selection="RECHERCHER une carte de fidelité";
					validateAction();
				}
			});
			this.label_SearchCarteFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_SearchCarteFid.setBounds(416, 318, 145, 225);
		}
		return this.label_SearchCarteFid;
	}

	private JLabel getLabel_ModCarteFid() {
		if (this.label_ModCarteFid == null) {
			this.label_ModCarteFid = new JLabel("");
			this.label_ModCarteFid.setIcon(new ImageIcon(GestionCarteDeFidelite.class.getResource("/Images/menubutons/bouton-fidelite-mise-jour.png")));
			this.label_ModCarteFid
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ModCarteFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ModCarteFid.setForeground(Color.GRAY);
			this.label_ModCarteFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionCarteDeFidelite.this.selection="MISE A JOUR d'une carte de fidélité";
					validateAction();
				}
			});
			this.label_ModCarteFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ModCarteFid.setBounds(571, 318, 145, 225);
		}
		return this.label_ModCarteFid;
	}

	private JLabel getLabel_DeleteCarteFid() {
		if (this.label_DeleteCarteFid == null) {
			this.label_DeleteCarteFid = new JLabel("");
			this.label_DeleteCarteFid.setIcon(new ImageIcon(GestionCarteDeFidelite.class.getResource("/Images/menubutons/bouton-fidelite-supression.png")));
			this.label_DeleteCarteFid
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_DeleteCarteFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_DeleteCarteFid.setForeground(Color.GRAY);
			this.label_DeleteCarteFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionCarteDeFidelite.this.selection="SUPPRESSION d'une carte de fidélité";
					validateAction();
				}
			});
			this.label_DeleteCarteFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_DeleteCarteFid.setBounds(726, 318, 145, 225);
		}
		return this.label_DeleteCarteFid;
	}

	private JLabel getLabel_UnsubscribeCarteFid() {
		if (this.label_UnsubscribeCarteFid == null) {
			this.label_UnsubscribeCarteFid = new JLabel("");
			this.label_UnsubscribeCarteFid.setIcon(new ImageIcon(GestionCarteDeFidelite.class.getResource("/Images/menubutons/bouton-fidelite-desinscription.png")));
			this.label_UnsubscribeCarteFid
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_UnsubscribeCarteFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_UnsubscribeCarteFid.setForeground(Color.GRAY);
			this.label_UnsubscribeCarteFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionCarteDeFidelite.this.selection="DESINSCRIPTION Publicité Commerciale";
					validateAction();
				}
			});
			this.label_UnsubscribeCarteFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_UnsubscribeCarteFid.setBounds(881, 318, 145, 225);
		}
		return this.label_UnsubscribeCarteFid;
	}



	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					GestionCarteDeFidelite.this.dispose();
				}
			});
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setBounds(878, 231, 175, 48);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenu() {
		if (this.lblMenu == null) {
			this.lblMenu = new JLabel(
					"Menu > Gestion Cartes de Fid\u00E9lit\u00E9");
			this.lblMenu.setVisible(false);
			this.lblMenu.setForeground(Color.GRAY);
			this.lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenu.setBounds(240, 325, 163, 14);
		}
		return this.lblMenu;
	}

	private JLabel getLblMerciDeFaire() {
		if (this.lblMerciDeFaire == null) {
			this.lblMerciDeFaire = new JLabel(
					"Merci de faire un choix");
			this.lblMerciDeFaire.setForeground(Color.GRAY);
			this.lblMerciDeFaire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeFaire.setBounds(903, 613, 150, 67);
		}
		return this.lblMerciDeFaire;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(GestionCarteDeFidelite.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNouvelleFicheClientmise() {
		if (this.lblNouvelleFicheClientmise == null) {
			this.lblNouvelleFicheClientmise = new JLabel(
					"Nouvelle carte de fidelite, Mise \u00E0 jour carte de fidelité, Suppression carte de fidelité, D\u00E9sinscription Client Newsletter");
			this.lblNouvelleFicheClientmise.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblNouvelleFicheClientmise.setForeground(Color.GRAY);
			this.lblNouvelleFicheClientmise.setBounds(240, 287, 797, 14);
		}
		return this.lblNouvelleFicheClientmise;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(GestionCarteDeFidelite.class
					.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					validateAction();
				}
			});
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(903, 627, 150, 67);
			this.lblValider.setVisible(false);

		}
		return this.lblValider;
	}

	private void validateAction() {
		System.out.print(GestionCarteDeFidelite.this.selection);
		switch (GestionCarteDeFidelite.this.selection) {
		case "NOUVELLE carte de fidélité":
			final String choix1 = "Menu > Gestion Carte de Fidélité > Nouvelle Fiche Client";
			final String numcarte = null;
			final int numoperation = 0;
			final int nummagasin = 0;

			final FideliteNouvelleFicheClient nouvelleFiche = new FideliteNouvelleFicheClient(
					numcarte, numoperation, nummagasin, choix1,GestionCarteDeFidelite.this.interfaceActuelle);
			nouvelleFiche.setVisible(true);
			GestionCarteDeFidelite.this.dispose();
			break;

		case "DESINSCRIPTION Publicité Commerciale":
			final String choix = "Menu > Gestion Carte de Fidélité > Désincription Pub";

			final SelectionNumeroCarteFidelite2 desinscription = new SelectionNumeroCarteFidelite2(
					GestionCarteDeFidelite.this.interfaceActuelle, choix);
			desinscription.setVisible(true);
			GestionCarteDeFidelite.this.dispose();
			break;

		case "SUPPRESSION d'une carte de fidélité":
			final String choix2 = "Menu > Gestion Carte de Fidélité > Suppression Fiche Client";
			final SelectionNumeroCarteFidelite2 suppressionFiche = new SelectionNumeroCarteFidelite2(
					GestionCarteDeFidelite.this.interfaceActuelle, choix2);
			suppressionFiche.setVisible(true);
			GestionCarteDeFidelite.this.dispose();
			break;

		case "MISE A JOUR d'une carte de fidélité":
			final String choix3 = "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client";
			final SelectionNumeroCarteFidelite2 updateFiche = new SelectionNumeroCarteFidelite2(
					GestionCarteDeFidelite.this.interfaceActuelle, choix3);
			updateFiche.setVisible(true);
			GestionCarteDeFidelite.this.dispose();
			break;

		case "RECHERCHER une carte de fidelité":
			final String choix4 = "Menu > Gestion Carte de Fidélité > Consulter Fiche Client";
			final SelectionNumeroCarteFidelite2 consultationfiche = new SelectionNumeroCarteFidelite2(
					GestionCarteDeFidelite.this.interfaceActuelle, choix4);
			consultationfiche.setVisible(true);
			GestionCarteDeFidelite.this.dispose();
			break;
		}
	}
}
