package fr.lefournildesprovinces.vues.menus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.Loading;

public class MenuPrincipal extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -6634457681738095157L;
	private JComboBox<Object> comboBoxMenu;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLabel label_ADM;
	private JLabel label_Import;
	private JLabel label_CartesFid;
	private JLabel label_OpCom;
	private JLabel label_Magasins;
	private JLabel label_Extraction;
	private JLayeredPane layeredPane;
	private JLabel lblAccueilPour;
	private JLabel lblFermer;
	private JLabel lblMerciDeSelectionner;
	private JLabel Cadre;
	private JLabel lblValider;
	private JLabel lienextraction;
	private JLabel lienfidelite;
	private JLabel lienmagasin;
	private JLabel lienoperation;
	private String privilege;
	private String selection;
	private Loading lblLoading;
	private JLabel navBar;

	public MenuPrincipal() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.YELLOW);
		this.contentPane.setBorder(null);
		this.setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 1280, 0 };
		gbl_contentPane.rowHeights = new int[] { 800, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 0;
		gbc_layeredPane.gridy = 0;
		this.contentPane.add(this.getLayeredPane_1(), gbc_layeredPane);
		this.setLocationRelativeTo(null);

		this.setResizable(false);
		this.interfaceActuelle = this;

		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

		MenuPrincipal.this.lblMerciDeSelectionner.setVisible(false);
		MenuPrincipal.this.lblMerciDeSelectionner.setEnabled(false);
		MenuPrincipal.this.lblValider.setVisible(false);
		MenuPrincipal.this.lblValider.setEnabled(false);
		MenuPrincipal.this.comboBoxMenu.setVisible(false);
		MenuPrincipal.this.comboBoxMenu.setEnabled(false);
	}

	private JComboBox<Object> getComboBoxMenu() {
		if (this.comboBoxMenu == null) {

			this.privilege = Login.getPrivilege();

			String[] choix = null;

			switch (this.privilege) {
			case "administrateur":
				choix = new String[] { "",
						"CARTES DE FIDELITE (Création, Mise à jour ou suppression d'une carte de fidelité)",
						"OPERATION COMMERCIALE (Participation Jeux-Concours, Gestion des opérations commerciales)",
						"MAGASIN (Création, Mise à jour ou suppression d'un magasin)", "EXTRACTION des informations" };
				break;
			case "utilisateur":
				choix = new String[] { "",
						"CARTES DE FIDELITE (Création, Mise à jour ou suppression d'une carte de fidelité)",
						"OPERATION COMMERCIALE (Participation Jeux-Concours, Gestion des opérations commerciales)" };
				break;
			case "invite":
				choix = new String[] { "",
						"CARTES DE FIDELITE (Création, Mise à jour ou suppression d'une carte de fidelité)",
						"OPERATION COMMERCIALE (Participation Jeux-Concours, Gestion des opérations commerciales)" };
				break;
			}
			this.comboBoxMenu = new JComboBox<Object>(choix);

			this.comboBoxMenu.setFocusable(true);
			this.comboBoxMenu.setEditable(false);
			this.comboBoxMenu.setVisible(true);

			this.comboBoxMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						MenuPrincipal.this.selection = MenuPrincipal.this.comboBoxMenu.getSelectedItem().toString();
						if (!selection.isEmpty()) {
							MenuPrincipal.this.lblValider.setVisible(true);
							MenuPrincipal.this.lblMerciDeSelectionner.setVisible(false);
						} else {
							MenuPrincipal.this.lblValider.setVisible(false);
							MenuPrincipal.this.lblMerciDeSelectionner.setVisible(true);
						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(MenuPrincipal.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MenuPrincipal.this.interfaceActuelle.setEnabled(false);
						MenuPrincipal.this.interfaceActuelle.setVisible(false);
						MenuPrincipal.this.lblValider.setVisible(false);
						MenuPrincipal.this.lblValider.setEnabled(false);
						MenuPrincipal.this.lblMerciDeSelectionner.setVisible(true);

					}

				}
			});
			this.comboBoxMenu.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if ('\n' == e.getKeyChar()) {
						validateAction();
					}
				};
			});

			this.comboBoxMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxMenu.setForeground(Color.GRAY);
			this.comboBoxMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMenu.setBackground(Color.WHITE);
			this.comboBoxMenu.setBorder(null);
			this.comboBoxMenu.setBounds(255, 617, 560, 22);
		}
		return this.comboBoxMenu;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			fond.setBackground(Color.WHITE);
			this.privilege = Login.getPrivilege();
			setUIPrivilege();
			this.fond.setHorizontalAlignment(SwingConstants.CENTER);
			this.fond.setBounds(216, 231, 850, 338);
//			this.fond.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/menus_accueil.png")));
		}
		return this.fond;
	}

	private void setUIPrivilege() {
		switch (this.privilege) {

		case "utilisateur":

			this.fond.setIcon(
					new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/menus-grises-acceuil-1.png")));
			this.lienmagasin.setEnabled(false);
			this.lienmagasin.setVisible(false);
			this.lienextraction.setEnabled(true);
			this.lienextraction.setVisible(true);
			this.label_ADM.setEnabled(false);
			this.label_ADM.setVisible(false);
			this.label_Import.setEnabled(false);
			this.label_Import.setVisible(false);
			this.label_Extraction.setEnabled(true);
			this.label_Extraction.setVisible(true);
			this.label_Magasins.setEnabled(false);
			this.label_Magasins.setVisible(false);
			this.navBar.setEnabled(true);
			this.navBar.setVisible(true);

			break;

		case "invite":
			this.lienmagasin.setEnabled(false);
			this.lienmagasin.setVisible(false);
			this.lienextraction.setEnabled(false);
			this.lienextraction.setVisible(false);
			this.label_ADM.setEnabled(false);
			this.label_ADM.setVisible(false);
			this.label_Import.setEnabled(false);
			this.label_Import.setVisible(false);
			this.label_Extraction.setEnabled(false);
			this.label_Extraction.setVisible(false);
			this.label_Magasins.setEnabled(false);
			this.label_Magasins.setVisible(false);
			this.fond.setIcon(
					new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/menus-grises-acceuil-1.png")));
			break;

		case "administrateur":

			break;

		}

	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMerciDeSelectionner());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLoading());
			this.layeredPane.add(this.getComboBoxMenu());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblAccueilPour());
			this.layeredPane.add(this.getLienextraction());
			this.layeredPane.add(this.getLienoperation());
			this.layeredPane.add(this.getLienfidelite());
			this.layeredPane.add(this.getLienmagasin());
			this.layeredPane.add(this.getLabel_ADM());
			this.layeredPane.add(this.getLabel_Import());
			this.layeredPane.add(this.getLabel_CartesFid());
			this.layeredPane.add(this.getLabel_OpCom());
			this.layeredPane.add(this.getLabel_Magasins());
			this.layeredPane.add(this.getLabel_Extraction());
			this.layeredPane.add(this.getNavBar());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getCadre());
		}

		return this.layeredPane;
	}

	private JLabel getNavBar() {
		if (this.navBar == null) {
			this.navBar = new JLabel("");
			this.navBar.setBackground(Color.WHITE);
			this.navBar.setHorizontalAlignment(SwingConstants.CENTER);
			this.navBar.setBounds(214, 230, 850, 77);
			this.navBar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/navbar/nav_grise_accueil.png")));
			this.navBar.setVisible(false);
			this.navBar.setEnabled(false);
		}
		return this.navBar;
	}

	private Loading getLoading() {
		if (this.lblLoading == null) {
			this.lblLoading = new Loading();
		}
		this.lblLoading.setVisible(false);
		return this.lblLoading;
	}

	private JLabel getLabel_ADM() {
		if (this.label_ADM == null) {
			this.label_ADM = new JLabel("");
			this.label_ADM
					.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/menubutons/bouton-admin.png")));
			this.label_ADM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ADM.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ADM.setForeground(Color.GRAY);
			this.label_ADM.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					MenuPrincipal.this.selection = "5";
					validateAction();
				}
			});
			this.label_ADM.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ADM.setBounds(881, 318, 145, 183);
		}
		return this.label_ADM;
	}

	private JLabel getLabel_Import() {
		if (this.label_Import == null) {
			this.label_Import = new JLabel("");
			this.label_Import
					.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/actionbutons/import-excel.png")));
			this.label_Import.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_Import.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_Import.setForeground(Color.GRAY);
			// this.label_Import.addMouseListener(new MouseAdapter() {
			// @Override
			// public void mouseClicked(final MouseEvent e) {
			// final GestionAdministrativeUttilisateursApplication fenetre = new
			// GestionAdministrativeUttilisateursApplication();
			// fenetre.setVisible(true);
			// MenuPrincipal.this.dispose();
			// }
			// });
			this.label_Import.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_Import.setBounds(891, 503, 127, 44);
		}
		return this.label_Import;
	}

	private JLabel getLabel_CartesFid() {
		if (this.label_CartesFid == null) {
			this.label_CartesFid = new JLabel("");
			this.label_CartesFid
					.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/menubutons/menus-carte-fid.png")));
			this.label_CartesFid.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_CartesFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_CartesFid.setForeground(Color.GRAY);
			this.label_CartesFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					MenuPrincipal.this.selection = "1";
					validateAction();
				}
			});
			this.label_CartesFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_CartesFid.setBounds(256, 318, 145, 225);
		}
		return this.label_CartesFid;
	}

	private JLabel getLabel_OpCom() {
		if (this.label_OpCom == null) {
			this.label_OpCom = new JLabel("");
			this.label_OpCom
					.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/menubutons/menus-operations.png")));
			this.label_OpCom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_OpCom.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_OpCom.setForeground(Color.GRAY);
			this.label_OpCom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					MenuPrincipal.this.selection = "3";
					validateAction();
				}
			});
			this.label_OpCom.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_OpCom.setBounds(411, 318, 145, 225);
		}
		return this.label_OpCom;
	}

	private JLabel getLabel_Magasins() {
		if (this.label_Magasins == null) {
			this.label_Magasins = new JLabel("");
			this.label_Magasins
					.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/menubutons/menus-magasins.png")));
			this.label_Magasins.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_Magasins.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_Magasins.setForeground(Color.GRAY);
			this.label_Magasins.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					MenuPrincipal.this.selection = "2";
					validateAction();
				}
			});
			this.label_Magasins.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_Magasins.setBounds(571, 318, 145, 225);
		}
		return this.label_Magasins;
	}

	private JLabel getLabel_Extraction() {
		if (this.label_Extraction == null) {
			this.label_Extraction = new JLabel("");
			this.label_Extraction
					.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/menubutons/menus-extraction.png")));
			this.label_Extraction.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_Extraction.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_Extraction.setForeground(Color.GRAY);
			this.label_Extraction.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					MenuPrincipal.this.selection = "4";
					validateAction();
				}
			});
			this.label_Extraction.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_Extraction.setBounds(726, 318, 145, 225);
		}
		return this.label_Extraction;
	}

	private JLabel getLblAccueilPour() {
		if (this.lblAccueilPour == null) {
			this.lblAccueilPour = new JLabel(
					"ACCUEIL : Pour naviguer cliquer sur les onglets ci-dessus ou les menus ci-dessous");
			this.lblAccueilPour.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAccueilPour.setForeground(Color.GRAY);
			this.lblAccueilPour.setBounds(246, 285, 681, 14);
		}
		return this.lblAccueilPour;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final Login fenetre = new Login();
					fenetre.setVisible(true);
					MenuPrincipal.this.dispose();
				}
			});
			this.lblFermer.setBounds(840, 231, 226, 44);
		}
		return this.lblFermer;
	}

	private JLabel getLblMerciDeSelectionner() {
		if (this.lblMerciDeSelectionner == null) {
			this.lblMerciDeSelectionner = new JLabel("Merci de faire un choix");
			this.lblMerciDeSelectionner.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSelectionner.setForeground(Color.GRAY);
			this.lblMerciDeSelectionner.setBounds(840, 595, 150, 67);
			this.lblMerciDeSelectionner.setVisible(true);

		}
		return this.lblMerciDeSelectionner;
	}

	private JLabel getCadre() {
		if (this.Cadre == null) {
			this.Cadre = new JLabel("");
			Cadre.setHorizontalAlignment(SwingConstants.CENTER);
			this.Cadre.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/fond-logiciel.png")));
			this.Cadre.setBounds(0, 0, 1280, 800);
		}
		return this.Cadre;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setVisible(false);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					validateAction();
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(840, 595, 150, 67);

		}
		return this.lblValider;
	}

	private void validateAction() {
		if (selection != null) {
			this.lblLoading.setVisible(true);
			switch (MenuPrincipal.this.selection) {
			case "1":
			case "CARTES DE FIDELITE (Création, Mise à jour ou suppression d'une carte de fidelité)":
				final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
				gestionclientcarte.setVisible(true);
				MenuPrincipal.this.dispose();
				break;

			case "2":
			case "MAGASIN (Création, Mise à jour ou suppression d'un magasin)":
				final GestionMagasins gestionMagasin = new GestionMagasins();
				gestionMagasin.setVisible(true);
				MenuPrincipal.this.dispose();
				break;

			case "3":
			case "OPERATION COMMERCIALE (Participation Jeux-Concours, Gestion des opérations commerciales)":
				final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
				operation.setVisible(true);
				MenuPrincipal.this.dispose();
				break;

			case "4":
			case "EXTRACTION des informations":
				final GestionExtractionBases collecte = new GestionExtractionBases();
				collecte.setVisible(true);
				MenuPrincipal.this.dispose();
				break;

			case "5":
				final GestionAdministrativeUttilisateursApplication fenetre = new GestionAdministrativeUttilisateursApplication();
				fenetre.setVisible(true);
				MenuPrincipal.this.dispose();
				break;
			}
		}
	}

	private JLabel getLienextraction() {
		if (this.lienextraction == null) {
			this.lienextraction = new JLabel("");
			this.lienextraction.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienextraction.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					MenuPrincipal.this.dispose();
				}
			});
			this.lienextraction.setBounds(701, 231, 114, 44);
		}
		return this.lienextraction;
	}

	private JLabel getLienfidelite() {
		if (this.lienfidelite == null) {
			this.lienfidelite = new JLabel("");
			this.lienfidelite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienfidelite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					MenuPrincipal.this.dispose();
				}
			});
			this.lienfidelite.setBounds(366, 231, 114, 44);
		}
		return this.lienfidelite;
	}

	private JLabel getLienmagasin() {
		if (this.lienmagasin == null) {
			this.lienmagasin = new JLabel("");
			this.lienmagasin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienmagasin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					MenuPrincipal.this.dispose();
				}
			});
			this.lienmagasin.setBounds(475, 231, 114, 44);
		}
		return this.lienmagasin;
	}

	private JLabel getLienoperation() {
		if (this.lienoperation == null) {
			this.lienoperation = new JLabel("");
			this.lienoperation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienoperation.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					MenuPrincipal.this.dispose();
				}
			});
			this.lienoperation.setBounds(587, 231, 114, 44);
		}
		return this.lienoperation;
	}
}
