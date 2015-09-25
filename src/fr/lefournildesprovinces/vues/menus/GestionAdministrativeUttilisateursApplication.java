package fr.lefournildesprovinces.vues.menus;

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

import fr.lefournildesprovinces.vues.admininstartaion.Selectionutilisateur;
import fr.lefournildesprovinces.vues.admininstartaion.newuser;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class GestionAdministrativeUttilisateursApplication extends JFrame {

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
	private JLabel label_ADMNewProfil;
	private JLabel label_ADMModPassword;
	private JLabel label_ADMDelUser;
	private JLabel label_ADMMajPrivilege;
	private JLabel label_ADMShowUser;

	public GestionAdministrativeUttilisateursApplication() {
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

		GestionAdministrativeUttilisateursApplication.this.lblMerciDeFaire.setVisible(false);
		GestionAdministrativeUttilisateursApplication.this.lblMerciDeFaire.setEnabled(false);
		GestionAdministrativeUttilisateursApplication.this.valider.setVisible(false);
		GestionAdministrativeUttilisateursApplication.this.valider.setEnabled(false);
		GestionAdministrativeUttilisateursApplication.this.comboBox.setVisible(false);
		GestionAdministrativeUttilisateursApplication.this.comboBox.setEnabled(false);
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
						GestionAdministrativeUttilisateursApplication.this.selection = GestionAdministrativeUttilisateursApplication.this.comboBox
								.getSelectedItem().toString().substring(1);
						GestionAdministrativeUttilisateursApplication.this.valider.setVisible(true);
						GestionAdministrativeUttilisateursApplication.this.lblMerciDeFaire.setVisible(false);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								GestionAdministrativeUttilisateursApplication.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						GestionAdministrativeUttilisateursApplication.this.interfaceActuelle.setEnabled(false);
						GestionAdministrativeUttilisateursApplication.this.interfaceActuelle.setVisible(false);
						GestionAdministrativeUttilisateursApplication.this.valider.setVisible(false);
						GestionAdministrativeUttilisateursApplication.this.valider.setEnabled(false);
						GestionAdministrativeUttilisateursApplication.this.lblMerciDeFaire.setVisible(true);

					}

				}
			});
			this.comboBox.setBounds(350, 521, 475, 22);
		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class
					.getResource("/Images/fonds/menus_accueil-2.png")));
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
					GestionAdministrativeUttilisateursApplication.this.dispose();
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
					GestionAdministrativeUttilisateursApplication.this.dispose();
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
					GestionAdministrativeUttilisateursApplication.this.dispose();
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
					GestionAdministrativeUttilisateursApplication.this.dispose();
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
					GestionAdministrativeUttilisateursApplication.this.dispose();
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
			this.layeredPane.add(this.getLabel_ADMNewProfil());
			this.layeredPane.add(this.getLabel_ADMModPassword());
			this.layeredPane.add(this.getLabel_ADMDelUser());
			this.layeredPane.add(this.getLabel_ADMMajPrivilege());
			this.layeredPane.add(this.getLabel_ADMShowUser());
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

	private JLabel getLabel_ADMNewProfil() {
		if (this.label_ADMNewProfil == null) {
			this.label_ADMNewProfil = new JLabel("");
			this.label_ADMNewProfil.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class.getResource("/Images/menubutons/bouton-admin-creer-profil.png")));
			this.label_ADMNewProfil
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ADMNewProfil.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ADMNewProfil.setForeground(Color.GRAY);
			this.label_ADMNewProfil.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionAdministrativeUttilisateursApplication.this.selection="CREER un profil utilisateur";
					validateAction();
				}
			});
			this.label_ADMNewProfil.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ADMNewProfil.setBounds(256, 318, 145, 225);
		}
		return this.label_ADMNewProfil;
	}

	private JLabel getLabel_ADMModPassword() {
		if (this.label_ADMModPassword == null) {
			this.label_ADMModPassword = new JLabel("");
			this.label_ADMModPassword.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class.getResource("/Images/menubutons/bouton-admin-maj-mot-pass.png")));
			this.label_ADMModPassword
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ADMModPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ADMModPassword.setForeground(Color.GRAY);
			this.label_ADMModPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionAdministrativeUttilisateursApplication.this.selection="METTRE A JOUR un mot de passe utilisateur";
					validateAction();
				}
			});
			this.label_ADMModPassword.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ADMModPassword.setBounds(416, 318, 145, 225);
		}
		return this.label_ADMModPassword;
	}

	private JLabel getLabel_ADMDelUser() {
		if (this.label_ADMDelUser == null) {
			this.label_ADMDelUser = new JLabel("");
			this.label_ADMDelUser.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class.getResource("/Images/menubutons/bouton-admin-supp-profil.png")));
			this.label_ADMDelUser
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ADMDelUser.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ADMDelUser.setForeground(Color.GRAY);
			this.label_ADMDelUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionAdministrativeUttilisateursApplication.this.selection="SUPPRIMER un utilisateur";
					validateAction();
				}
			});
			this.label_ADMDelUser.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ADMDelUser.setBounds(571, 318, 145, 225);
		}
		return this.label_ADMDelUser;
	}

	private JLabel getLabel_ADMMajPrivilege() {
		if (this.label_ADMMajPrivilege == null) {
			this.label_ADMMajPrivilege = new JLabel("");
			this.label_ADMMajPrivilege.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class.getResource("/Images/menubutons/bouton-admin-maj-privileges.png")));
			this.label_ADMMajPrivilege
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ADMMajPrivilege.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ADMMajPrivilege.setForeground(Color.GRAY);
			this.label_ADMMajPrivilege.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionAdministrativeUttilisateursApplication.this.selection="METTRE A JOUR un privilege utilisateur";
					validateAction();
				}
			});
			this.label_ADMMajPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ADMMajPrivilege.setBounds(726, 318, 145, 225);
		}
		return this.label_ADMMajPrivilege;
	}

	private JLabel getLabel_ADMShowUser() {
		if (this.label_ADMShowUser == null) {
			this.label_ADMShowUser = new JLabel("");
			this.label_ADMShowUser.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class.getResource("/Images/menubutons/bouton-admin-consulte-fiche.png")));
			this.label_ADMShowUser
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ADMShowUser.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ADMShowUser.setForeground(Color.GRAY);
			this.label_ADMShowUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionAdministrativeUttilisateursApplication.this.selection="CONSULTER une fiche utilisateur";
					validateAction();
				}
			});
			this.label_ADMShowUser.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ADMShowUser.setBounds(881, 318, 145, 225);
		}
		return this.label_ADMShowUser;
	}

	private JLabel getLblGestionDesUtilisateurs() {
		if (this.lblGestionDesUtilisateurs == null) {
			this.lblGestionDesUtilisateurs = new JLabel(
					"Gestion des utilisateurs (Mettre \u00E0 jour un mot de passe utilisateur, Consulter une fiche utilisateur)");
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
			this.lblMerciDeFaire.setBounds(508, 525, 167, 14);
		}
		return this.lblMerciDeFaire;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class
					.getResource("/Images/fonds/fond-logiciel.png")));
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

					validateAction();
				}

			});
			this.valider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.valider.setHorizontalAlignment(SwingConstants.CENTER);
			this.valider.setIcon(new ImageIcon(GestionAdministrativeUttilisateursApplication.class
					.getResource("/Images/actionbutons/valider.png")));
			this.valider.setBounds(891, 493, 150, 67);
		}
		return this.valider;
	}

	private void validateAction() {

		System.out.print(GestionAdministrativeUttilisateursApplication.this.selection);
		switch (GestionAdministrativeUttilisateursApplication.this.selection){
		case "METTRE A JOUR un mot de passe utilisateur":
			final Selectionutilisateur fenetre = new Selectionutilisateur(
					GestionAdministrativeUttilisateursApplication.this.selection);
			fenetre.setVisible(true);
			GestionAdministrativeUttilisateursApplication.this.dispose();
			break;

		case "CONSULTER une fiche utilisateur":
			final Selectionutilisateur fenetre1 = new Selectionutilisateur(
					GestionAdministrativeUttilisateursApplication.this.selection);
			fenetre1.setVisible(true);
			GestionAdministrativeUttilisateursApplication.this.dispose();
			break;

		case "CREER un profil utilisateur":
			final newuser fenetre2 = new newuser();
			fenetre2.setVisible(true);
			GestionAdministrativeUttilisateursApplication.this.dispose();

			break;

		case "SUPPRIMER un utilisateur":
			final Selectionutilisateur fenetre3 = new Selectionutilisateur(
					GestionAdministrativeUttilisateursApplication.this.selection);
			fenetre3.setVisible(true);
			GestionAdministrativeUttilisateursApplication.this.dispose();
			break;

		case "METTRE A JOUR un privilege utilisateur":
			final Selectionutilisateur fenetre4 = new Selectionutilisateur(
					GestionAdministrativeUttilisateursApplication.this.selection);
			fenetre4.setVisible(true);
			GestionAdministrativeUttilisateursApplication.this.dispose();
			break;

		}
	}
}
