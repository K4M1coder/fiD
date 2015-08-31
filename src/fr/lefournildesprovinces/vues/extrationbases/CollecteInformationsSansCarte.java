package fr.lefournildesprovinces.vues.extrationbases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.selectionClientOC;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class CollecteInformationsSansCarte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8991791660553355526L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblCollecteDonformations;
	private JLabel lblExtractionDesInformations;
	private JLabel lblMerciDeSelectionner;
	private JLabel lblNewLabel;
	private JLabel lblRetour;
	private JLabel lblValider;
	private String selection;

	public CollecteInformationsSansCarte(final String choix) {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { null, " TOUS les participants",
					" RECHERCHER un participant", " Tranche d'AGE",
					" Participant d'un MAGASIN",
					" Participants OPERATION commerciale",
					" VILLE de résidence" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFocusable(false);

			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						CollecteInformationsSansCarte.this.lblMerciDeSelectionner
								.setVisible(false);
						CollecteInformationsSansCarte.this.selection = CollecteInformationsSansCarte.this.comboBox
								.getSelectedItem().toString().substring(1);
						CollecteInformationsSansCarte.this.lblValider
								.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								CollecteInformationsSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.lblValider
								.setVisible(false);
						CollecteInformationsSansCarte.this.lblMerciDeSelectionner
								.setVisible(true);
					}

				}
			});
			this.comboBox.setBounds(422, 414, 437, 22);

		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(CollecteInformationsSansCarte.class
					.getResource("/Images/menus_extraction.png")));
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
					CollecteInformationsSansCarte.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(238, 231, 114, 44);
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
					CollecteInformationsSansCarte.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(347, 231, 114, 44);
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
					CollecteInformationsSansCarte.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(459, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					CollecteInformationsSansCarte.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(573, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMerciDeSelectionner());
			this.layeredPane.add(this.getLblCollecteDonformations());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblExtractionDesInformations());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblCollecteDonformations() {
		if (this.lblCollecteDonformations == null) {
			this.lblCollecteDonformations = new JLabel(
					"Collecte d'informations Emailing");
			this.lblCollecteDonformations.setVisible(false);
			this.lblCollecteDonformations.setForeground(Color.GRAY);
			this.lblCollecteDonformations.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblCollecteDonformations.setBounds(245, 343, 216, 14);
		}
		return this.lblCollecteDonformations;
	}

	private JLabel getLblExtractionDesInformations() {
		if (this.lblExtractionDesInformations == null) {
			this.lblExtractionDesInformations = new JLabel(
					"Extraction des informations Client non titulaire d'une carte de fid\u00E9lit\u00E9");
			this.lblExtractionDesInformations.setForeground(Color.GRAY);
			this.lblExtractionDesInformations.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblExtractionDesInformations.setBounds(238, 286, 426, 14);
		}
		return this.lblExtractionDesInformations;
	}

	private JLabel getLblMerciDeSelectionner() {
		if (this.lblMerciDeSelectionner == null) {
			this.lblMerciDeSelectionner = new JLabel(
					"Merci de choisir le mode de TRI");
			this.lblMerciDeSelectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblMerciDeSelectionner.setForeground(Color.GRAY);
			this.lblMerciDeSelectionner.setBounds(491, 418, 299, 14);
		}
		return this.lblMerciDeSelectionner;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					CollecteInformationsSansCarte.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblRetour() {
		if (this.lblRetour == null) {
			this.lblRetour = new JLabel("");
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					CollecteInformationsSansCarte.this.dispose();
				}
			});
			this.lblRetour.setBounds(876, 231, 167, 46);
		}
		return this.lblRetour;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(
					CollecteInformationsSansCarte.class
							.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					switch (CollecteInformationsSansCarte.this.selection) {
					case "Tranche d'AGE":
						final EmailingAgeSansCarte age = new EmailingAgeSansCarte(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						age.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);

						break;

					case "Tri par date anniversaire":
						final EmailingAnniversaireSansCarte anniversaire = new EmailingAnniversaireSansCarte(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						anniversaire.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						break;

					case "Client d'un MAGASIN":
						final EmailingMagasinSansCarte triparmagasin = new EmailingMagasinSansCarte(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						triparmagasin.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						break;

					case "Participants OPERATION commerciale":
						final EmailingOperationCommercialeSansCarte trioperation = new EmailingOperationCommercialeSansCarte(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						trioperation.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						break;

					case "VILLE de résidence":
						final EmailingVilleSansCarte triville = new EmailingVilleSansCarte(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						triville.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						break;

					case "TOUTES les participants":
						final EnsembleSansCarte tous = new EnsembleSansCarte(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						tous.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						break;

					case "RECHERCHER un participant":
						final selectionClientOC infos = new selectionClientOC(
								CollecteInformationsSansCarte.this.interfaceActuelle);
						infos.setVisible(true);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setVisible(false);
						CollecteInformationsSansCarte.this.interfaceActuelle
								.setEnabled(false);
						break;

					}

				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setBounds(887, 392, 150, 67);
			this.lblValider.setVisible(false);
		}
		return this.lblValider;
	}
}
