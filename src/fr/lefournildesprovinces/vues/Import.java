package fr.lefournildesprovinces.vues;

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

import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.admininstartaion.Selectionutilisateur;
import fr.lefournildesprovinces.vues.admininstartaion.newuser;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class Import extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3069321718174673362L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblGestionDesUtilisateurs;
	private JLabel lblMerciDeFaire;
	private JLabel lblNewLabel;
	private String selection;
	private JLabel valider;

	public Import() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.interfaceActuelle = this;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { null, " CREER un profil utilisateur",
					" METTRE A JOUR un mot de passe utilisateur",
					" SUPPRIMER un utilisateur",
					" METTRE A JOUR un privilege utilisateur",
					" CONSULTER une fiche utilisateur" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFocusable(false);
			this.comboBox.setBorder(null);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						Import.this.selection = Import.this.comboBox
								.getSelectedItem().toString().substring(1);
						Import.this.valider.setVisible(true);
						Import.this.lblMerciDeFaire.setVisible(false);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								Import.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						Import.this.interfaceActuelle.setEnabled(false);
						Import.this.interfaceActuelle.setVisible(false);
						Import.this.valider.setVisible(false);
						Import.this.valider.setEnabled(false);
						Import.this.lblMerciDeFaire.setVisible(true);

					}

				}
			});
			this.comboBox.setBounds(350, 416, 475, 22);
		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Import.class
					.getResource("/Images/menus_accueil-2.png")));
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
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					Import.this.dispose();
				}
			});
			this.label.setBounds(367, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					Import.this.dispose();
				}
			});
			this.label_1.setBounds(476, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					Import.this.dispose();
				}
			});
			this.label_2.setBounds(588, 231, 114, 44);
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
					Import.this.dispose();
				}
			});
			this.label_3.setBounds(702, 231, 114, 44);
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
					Import.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(876, 231, 179, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblGestionDesUtilisateurs());
			this.layeredPane.add(this.getLblMerciDeFaire());
			this.layeredPane.add(this.getValider());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblGestionDesUtilisateurs() {
		if (this.lblGestionDesUtilisateurs == null) {
			this.lblGestionDesUtilisateurs = new JLabel(
					"Import cartes fidelités (choisissez un fichier excel au format xls)");
			this.lblGestionDesUtilisateurs.setForeground(Color.GRAY);
			this.lblGestionDesUtilisateurs.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblGestionDesUtilisateurs.setBounds(242, 286, 596, 14);
		}
		return this.lblGestionDesUtilisateurs;
	}

	private JLabel getLblMerciDeFaire() {
		if (this.lblMerciDeFaire == null) {
			this.lblMerciDeFaire = new JLabel("Merci de faire un choix");
			this.lblMerciDeFaire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeFaire.setForeground(Color.GRAY);
			this.lblMerciDeFaire.setBounds(524, 420, 167, 14);
		}
		return this.lblMerciDeFaire;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(Import.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getValider() {
		if (this.valider == null) {
			this.valider = new JLabel("");
			this.valider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.valider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					System.out.print(Import.this.selection);
					switch (Import.this.selection)

					{
					case "METTRE A JOUR un mot de passe utilisateur":
						final Selectionutilisateur fenetre = new Selectionutilisateur(
								Import.this.selection);
						fenetre.setVisible(true);
						Import.this.dispose();
						break;

					case "CONSULTER une fiche utilisateur":
						final Selectionutilisateur fenetre1 = new Selectionutilisateur(
								Import.this.selection);
						fenetre1.setVisible(true);
						Import.this.dispose();
						break;

					case "CREER un profil utilisateur":
						final newuser fenetre2 = new newuser();
						fenetre2.setVisible(true);
						Import.this.dispose();

						break;

					case "SUPPRIMER un utilisateur":
						final Selectionutilisateur fenetre3 = new Selectionutilisateur(
								Import.this.selection);
						fenetre3.setVisible(true);
						Import.this.dispose();
						break;

					case "METTRE A JOUR un privilege utilisateur":
						final Selectionutilisateur fenetre4 = new Selectionutilisateur(
								Import.this.selection);
						fenetre4.setVisible(true);
						Import.this.dispose();
						break;

					}
				}
			});
			this.valider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.valider.setHorizontalAlignment(SwingConstants.CENTER);
			this.valider.setIcon(new ImageIcon(Import.class
					.getResource("/Images/valider.png")));
			this.valider.setBounds(887, 392, 150, 67);
		}
		return this.valider;
	}
}
