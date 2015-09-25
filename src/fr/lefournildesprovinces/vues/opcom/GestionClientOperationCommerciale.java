package fr.lefournildesprovinces.vues.opcom;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.apache.commons.validator.routines.EmailValidator;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class GestionClientOperationCommerciale extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -7357692923550332674L;
	private String adresse;
	private String age;
	private final String annee = null;
	private String civilite;
	private String codePostal;
	private JComboBox<Object> comboBoxCivilite;
	private final JPanel contentPane;
	private String dateComplete = null;
	private String email;
	private JLabel fond;
	// creation et instantiation d'un groupe de bouton
	ButtonGroup group = new ButtonGroup();
	private final int idmagasin;
	private final int IdOperationCommerciale;
	private int idville;
	private final JFrame interfaceActuelle;
	private final String jour = null;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblAbonnementNewsletter;
	private JLabel lblAdresse;
	private JLabel lblAge;
	private JLabel lblChampsObligatoires;
	private JLabel lblCivilit;
	private JLabel lblCodePostal;
	private JLabel lblEmail;
	private JLabel lblFermer;
	private JLabel lblMenuNouvelle;
	private JLabel lblNewLabel;
	private JLabel lblNom;
	private JLabel lblNouvelleParticipation;
	private JLabel lblPrnom;
	private JLabel lblTelephoneFixe;
	private JLabel lblTlphonePortable;
	private JLabel lblValider;
	private JLabel lblVille;
	private ComboBoxModel<Object> ListeVille;
	private final String mois = null;
	private String newsletter;
	private String nom;

	private String prenom;

	private String privilege;
	private JRadioButton rdbtnActif;
	private JRadioButton rdbtnDesinscrit;
	private JRadioButton rdbtnInactif;
	private String telephonefixe;
	private String telephoneportable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textFieldAdresse;
	private JTextField textFieldCodePostal;
	private JTextField textFieldEmail;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JComboBox<Object> textFieldVille;
	private String valeurCaseNewsletter;
	private String ville;

	public GestionClientOperationCommerciale(
			final int numeroOperationCommerciale, final int numeromagasin) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

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
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);
		this.interfaceActuelle = this;
		this.IdOperationCommerciale = numeroOperationCommerciale;
		this.idmagasin = numeromagasin;

	}

	private JComboBox<Object> getComboBoxCivilite() {
		if (this.comboBoxCivilite == null) {
			final String[] civiliteclient = { null, "Mr", "Mme", "NR" };
			this.comboBoxCivilite = new JComboBox<Object>(civiliteclient);
			this.comboBoxCivilite.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						GestionClientOperationCommerciale.this.civilite = GestionClientOperationCommerciale.this.comboBoxCivilite
								.getSelectedItem().toString().toUpperCase();

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								GestionClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						GestionClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.comboBoxCivilite.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxCivilite.setForeground(Color.GRAY);
			this.comboBoxCivilite.setBackground(Color.WHITE);
			this.comboBoxCivilite.setBorder(null);
			this.comboBoxCivilite.setBounds(302, 346, 86, 22);
		}
		return this.comboBoxCivilite;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								GestionClientOperationCommerciale.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
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

				this.fond
						.setIcon(new ImageIcon(
								GestionClientOperationCommerciale.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						GestionClientOperationCommerciale.class
								.getResource("/Images/fonds/menus_operation.png")));
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
					GestionClientOperationCommerciale.this.dispose();
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
					GestionClientOperationCommerciale.this.dispose();
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
					GestionClientOperationCommerciale.this.dispose();
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
					GestionClientOperationCommerciale.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(704, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenuNouvelle());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblNom());
			this.layeredPane.add(this.getLblPrnom());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getLblVille());
			this.layeredPane.add(this.getLblCodePostal());
			this.layeredPane.add(this.getLblEmail());
			this.layeredPane.add(this.getLblAbonnementNewsletter());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getTextFieldPrenom());
			this.layeredPane.add(this.getTextFieldNom());
			this.layeredPane.add(this.getTextFieldAdresse());
			this.layeredPane.add(this.getTextFieldVille());
			this.layeredPane.add(this.getTextFieldCodePostal());
			this.layeredPane.add(this.getTextFieldEmail());
			this.layeredPane.add(this.getRdbtnActif());
			this.layeredPane.add(this.getRdbtnInactif());
			this.layeredPane.add(this.getLblCivilit());
			this.layeredPane.add(this.getComboBoxCivilite());
			this.layeredPane.add(this.getRdbtnDesinscrit());
			this.layeredPane.add(this.getLblChampsObligatoires());
			this.layeredPane.add(this.getLblTelephoneFixe());
			this.layeredPane.add(this.getLblTlphonePortable());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNouvelleParticipation());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getTextField_2());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLblAbonnementNewsletter() {
		if (this.lblAbonnementNewsletter == null) {
			this.lblAbonnementNewsletter = new JLabel("Abonnement Newsletter ");
			this.lblAbonnementNewsletter.setForeground(Color.GRAY);
			this.lblAbonnementNewsletter.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblAbonnementNewsletter.setBounds(441, 476, 152, 14);
		}
		return this.lblAbonnementNewsletter;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse");
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setBounds(239, 381, 58, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblAge() {
		if (this.lblAge == null) {
			this.lblAge = new JLabel("Age *");
			this.lblAge.setForeground(Color.GRAY);
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAge.setBounds(741, 412, 43, 14);
		}
		return this.lblAge;
	}

	private JLabel getLblChampsObligatoires() {
		if (this.lblChampsObligatoires == null) {
			this.lblChampsObligatoires = new JLabel("* Champs Obligatoires");
			this.lblChampsObligatoires
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblChampsObligatoires.setForeground(Color.GRAY);
			this.lblChampsObligatoires.setBounds(232, 530, 172, 14);
		}
		return this.lblChampsObligatoires;
	}

	private JLabel getLblCivilit() {
		if (this.lblCivilit == null) {
			this.lblCivilit = new JLabel("Civilit\u00E9 *");
			this.lblCivilit.setForeground(Color.GRAY);
			this.lblCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCivilit.setBounds(237, 350, 60, 14);
		}
		return this.lblCivilit;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("Code Postal");
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCodePostal.setForeground(Color.GRAY);
			this.lblCodePostal.setBounds(582, 412, 81, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblEmail() {
		if (this.lblEmail == null) {
			this.lblEmail = new JLabel("Email");
			this.lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmail.setForeground(Color.GRAY);
			this.lblEmail.setBounds(436, 443, 45, 14);
		}
		return this.lblEmail;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					GestionClientOperationCommerciale.this.dispose();
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(872, 231, 183, 44);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuNouvelle() {
		if (this.lblMenuNouvelle == null) {
			this.lblMenuNouvelle = new JLabel(
					"Menu > Nouvelle Fiche Client Op\u00E9ration Commerciale");
			this.lblMenuNouvelle.setVisible(false);
			this.lblMenuNouvelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuNouvelle.setForeground(Color.GRAY);
			this.lblMenuNouvelle.setBounds(534, 286, 253, 14);
		}
		return this.lblMenuNouvelle;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					GestionClientOperationCommerciale.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNom() {
		if (this.lblNom == null) {
			this.lblNom = new JLabel("Nom *");
			this.lblNom.setForeground(Color.GRAY);
			this.lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNom.setBounds(405, 350, 46, 14);
		}
		return this.lblNom;
	}

	private JLabel getLblNouvelleParticipation() {
		if (this.lblNouvelleParticipation == null) {
			this.lblNouvelleParticipation = new JLabel("Saisir un bulletin");
			this.lblNouvelleParticipation.setForeground(Color.GRAY);
			this.lblNouvelleParticipation.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblNouvelleParticipation.setBounds(242, 286, 323, 14);
		}
		return this.lblNouvelleParticipation;
	}

	private JLabel getLblPrnom() {
		if (this.lblPrnom == null) {
			this.lblPrnom = new JLabel("Pr\u00E9nom *");
			this.lblPrnom.setForeground(Color.GRAY);
			this.lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrnom.setBounds(663, 350, 68, 14);
		}
		return this.lblPrnom;
	}

	private JLabel getLblTelephoneFixe() {
		if (this.lblTelephoneFixe == null) {
			this.lblTelephoneFixe = new JLabel("Mobile");
			this.lblTelephoneFixe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTelephoneFixe.setForeground(Color.GRAY);
			this.lblTelephoneFixe.setBounds(248, 476, 49, 14);
		}
		return this.lblTelephoneFixe;
	}

	private JLabel getLblTlphonePortable() {
		if (this.lblTlphonePortable == null) {
			this.lblTlphonePortable = new JLabel("T\u00E9l\u00E9phone");
			this.lblTlphonePortable.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTlphonePortable.setForeground(Color.GRAY);
			this.lblTlphonePortable.setBounds(226, 443, 71, 14);
		}
		return this.lblTlphonePortable;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(
					GestionClientOperationCommerciale.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					boolean verification = true;
					String message = null;

					GestionClientOperationCommerciale.this.telephonefixe = null;
					GestionClientOperationCommerciale.this.telephoneportable = null;
					GestionClientOperationCommerciale.this.email = null;
					GestionClientOperationCommerciale.this.codePostal = null;

					GestionClientOperationCommerciale.this.nom = GestionClientOperationCommerciale.this.textFieldNom
							.getText().toUpperCase();
					GestionClientOperationCommerciale.this.prenom = GestionClientOperationCommerciale.this.textFieldPrenom
							.getText().toUpperCase();
					GestionClientOperationCommerciale.this.newsletter = GestionClientOperationCommerciale.this.valeurCaseNewsletter;

					if (!GestionClientOperationCommerciale.this.textField
							.getText().isEmpty()) {
						GestionClientOperationCommerciale.this.telephonefixe = GestionClientOperationCommerciale.this.textField
								.getText().toString();
						if (GestionClientOperationCommerciale.this.telephonefixe
								.length() != 10) {
							verification = false;
							message = "le numero de téléphone doit contenir 10 chiffres";
						}
					}

					if (!GestionClientOperationCommerciale.this.textField_1
							.getText().isEmpty()) {
						GestionClientOperationCommerciale.this.telephoneportable = GestionClientOperationCommerciale.this.textField_1
								.getText().toString();
						if (GestionClientOperationCommerciale.this.telephoneportable
								.length() != 10) {
							verification = false;
							message = "le numero de téléphone portable doit contenir 10 chiffres";
						}
					}
					GestionClientOperationCommerciale.this.age = GestionClientOperationCommerciale.this.textField_2
							.getText().toUpperCase().toString();
					if (GestionClientOperationCommerciale.this.age.isEmpty()) {
						verification = false;
						message = "Merci de vérifier l'ége du client - Ce champ ne peut être vide";
					} else {

						final int agemini = Integer
								.parseInt(GestionClientOperationCommerciale.this.age);
						if (agemini < 18) {
							verification = false;
							message = "Merci de vérifier l'ége du client - 18 ans minimum";
						}
					}
					if (!GestionClientOperationCommerciale.this.textFieldEmail
							.getText().isEmpty()) {
						GestionClientOperationCommerciale.this.email = GestionClientOperationCommerciale.this.textFieldEmail
								.getText();

						if (!EmailValidator.getInstance().isValid(
								GestionClientOperationCommerciale.this.email)) {
							verification = false;
							message = "Merci de vérifier l'adresse mail saisie";

						}
					}

					if ((GestionClientOperationCommerciale.this.annee != null)
							&& (GestionClientOperationCommerciale.this.mois != null)
							&& (GestionClientOperationCommerciale.this.jour != null)) {

						GestionClientOperationCommerciale.this.dateComplete = GestionClientOperationCommerciale.this.jour
								+ "/"
								+ GestionClientOperationCommerciale.this.mois
								+ "/"
								+ GestionClientOperationCommerciale.this.annee;
					}

					if (!GestionClientOperationCommerciale.this.textFieldCodePostal
							.getText().isEmpty()) {
						GestionClientOperationCommerciale.this.codePostal = GestionClientOperationCommerciale.this.textFieldCodePostal
								.getText();
						if (GestionClientOperationCommerciale.this.codePostal
								.isEmpty()
								|| (GestionClientOperationCommerciale.this.codePostal
										.length() < 5)) {
							verification = false;
							message = "Merci de vérifier le Code Postal, pour infos il doit contenir 5 chiffres";

						}

						for (int i = 0; i < GestionClientOperationCommerciale.this.codePostal
								.length(); i++) {

							if (!Character
									.isDigit(GestionClientOperationCommerciale.this.codePostal
											.charAt(i)))

							{
								verification = false;
								message = "Merci de vérifier le code Postal, il ne doit 5 Chiffres et aucune lettre";
								break;
							}

						}
					}

					try {

						GestionClientOperationCommerciale.this.ville = GestionClientOperationCommerciale.this.textFieldVille
								.getSelectedItem().toString().toUpperCase();
						GestionClientOperationCommerciale.this.idville = ((Ville) GestionClientOperationCommerciale.this.textFieldVille
								.getSelectedItem()).getIdville();
					} catch (final Exception e4) {
						verification = false;
						message = "Merci de selectionner une ville dans la liste";
					}

					if (!GestionClientOperationCommerciale.this.textFieldAdresse
							.getText().isEmpty()) {
						GestionClientOperationCommerciale.this.adresse = GestionClientOperationCommerciale.this.textFieldAdresse
								.getText().toUpperCase();
						if (GestionClientOperationCommerciale.this.adresse
								.length() <= 4) {
							verification = false;
							message = "Merci de vérifier l'adresse saisie, ce champs doit contenir au moins 4 caractéres";

						}
					}

					if (GestionClientOperationCommerciale.this.prenom.isEmpty()) {
						verification = false;
						message = "Merci de vérifier le prénom du client, Ce champs ne peut être vide";

					}

					if (GestionClientOperationCommerciale.this.nom.isEmpty()) {
						verification = false;
						message = "Merci de vérifier le nom du client, Ce champs ne peut être vide";

					}

					try {
						GestionClientOperationCommerciale.this.civilite = GestionClientOperationCommerciale.this.comboBoxCivilite
								.getSelectedItem().toString().toUpperCase();
					} catch (final Exception e5) {
						verification = false;
						message = "Merci de selectionner une civilite";

					}

					if (verification == true)

					{

						final ConfirmationInsertionClientOC fenetre = new ConfirmationInsertionClientOC(
								GestionClientOperationCommerciale.this.interfaceActuelle,
								GestionClientOperationCommerciale.this.civilite,
								GestionClientOperationCommerciale.this.nom,
								GestionClientOperationCommerciale.this.prenom,
								GestionClientOperationCommerciale.this.adresse,
								GestionClientOperationCommerciale.this.ville,
								GestionClientOperationCommerciale.this.codePostal,
								GestionClientOperationCommerciale.this.email,
								GestionClientOperationCommerciale.this.newsletter,
								GestionClientOperationCommerciale.this.dateComplete,
								GestionClientOperationCommerciale.this.IdOperationCommerciale,
								GestionClientOperationCommerciale.this.idmagasin,
								GestionClientOperationCommerciale.this.idville,
								GestionClientOperationCommerciale.this.telephonefixe,
								GestionClientOperationCommerciale.this.telephoneportable,
								GestionClientOperationCommerciale.this.age);
						fenetre.setVisible(true);
						GestionClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						GestionClientOperationCommerciale.this.interfaceActuelle
								.setVisible(false);
					} else

					{
						System.out.print("impossible");

						final AlerteSelection fenetre = new AlerteSelection(
								GestionClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						GestionClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}

				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setBounds(926, 460, 99, 44);
			this.lblValider.setVisible(true);
		}
		return this.lblValider;
	}

	private JLabel getLblVille() {
		if (this.lblVille == null) {
			this.lblVille = new JLabel("Ville *");
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblVille.setForeground(Color.GRAY);
			this.lblVille.setBounds(252, 412, 45, 14);
		}
		return this.lblVille;
	}

	private JRadioButton getRdbtnActif() {
		if (this.rdbtnActif == null) {
			this.rdbtnActif = new JRadioButton("Oui");
			this.rdbtnActif.setSelected(true);
			if (this.rdbtnActif.isSelected()) {
				this.valeurCaseNewsletter = this.rdbtnActif.getText()
						.toString().toUpperCase();
			}
			this.rdbtnActif.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					if (GestionClientOperationCommerciale.this.rdbtnActif
							.isSelected()) {
						GestionClientOperationCommerciale.this.valeurCaseNewsletter = GestionClientOperationCommerciale.this.rdbtnActif
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnActif.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.rdbtnActif.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnActif.setForeground(Color.GRAY);
			this.rdbtnActif.setBounds(599, 472, 58, 23);
			// on ajoute le premier bouton au groupe

			this.group.add(this.rdbtnActif);

		}
		return this.rdbtnActif;
	}

	private JRadioButton getRdbtnDesinscrit() {
		if (this.rdbtnDesinscrit == null) {
			this.rdbtnDesinscrit = new JRadioButton("D\u00E9sinscrit");
			this.rdbtnDesinscrit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					if (GestionClientOperationCommerciale.this.rdbtnDesinscrit
							.isSelected()) {
						GestionClientOperationCommerciale.this.valeurCaseNewsletter = GestionClientOperationCommerciale.this.rdbtnDesinscrit
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnDesinscrit.setForeground(Color.GRAY);
			this.rdbtnDesinscrit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnDesinscrit.setBounds(730, 472, 89, 23);
			// on ajoute le troisieme bouton au groupe
			this.group.add(this.rdbtnDesinscrit);
		}
		return this.rdbtnDesinscrit;
	}

	private JRadioButton getRdbtnInactif() {
		if (this.rdbtnInactif == null) {
			this.rdbtnInactif = new JRadioButton("Non");
			this.rdbtnInactif.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					if (GestionClientOperationCommerciale.this.rdbtnInactif
							.isSelected()) {
						GestionClientOperationCommerciale.this.valeurCaseNewsletter = GestionClientOperationCommerciale.this.rdbtnInactif
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnInactif.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.rdbtnInactif.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnInactif.setForeground(Color.GRAY);
			this.rdbtnInactif.setBounds(666, 472, 54, 23);
			// on ajoute le second bouton au groupe
			this.group.add(this.rdbtnInactif);

		}
		return this.rdbtnInactif;

	}

	private JTextField getTextField() {
		if (this.textField == null) {
			this.textField = new JTextField();
			this.textField.setForeground(Color.GRAY);
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField.setBounds(302, 440, 124, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}

	private JTextField getTextField_1() {
		if (this.textField_1 == null) {
			this.textField_1 = new JTextField();
			this.textField_1.setForeground(Color.GRAY);
			this.textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_1
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_1.setBounds(302, 473, 124, 20);
			this.textField_1.setColumns(10);
		}
		return this.textField_1;
	}

	private JTextField getTextField_2() {
		if (this.textField_2 == null) {
			this.textField_2 = new JTextField();
			this.textField_2
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_2.setForeground(Color.GRAY);
			this.textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_2.setColumns(10);
			this.textField_2.setBounds(783, 409, 36, 20);
		}
		return this.textField_2;
	}

	private JTextField getTextFieldAdresse() {
		if (this.textFieldAdresse == null) {
			this.textFieldAdresse = new JTextField();
			this.textFieldAdresse.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {

				}
			});
			this.textFieldAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldAdresse.setForeground(Color.GRAY);
			this.textFieldAdresse.setBorder(new LineBorder(new Color(171, 173,
					179)));
			this.textFieldAdresse.setBounds(302, 378, 722, 20);
			this.textFieldAdresse.setColumns(10);
		}
		return this.textFieldAdresse;
	}

	private JTextField getTextFieldCodePostal() {
		if (this.textFieldCodePostal == null) {
			this.textFieldCodePostal = new JTextField();
			this.textFieldCodePostal.setFocusable(false);
			this.textFieldCodePostal.setEditable(false);
			this.textFieldCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldCodePostal.setForeground(Color.GRAY);
			this.textFieldCodePostal.setBorder(new LineBorder(new Color(171,
					173, 179)));
			this.textFieldCodePostal.setBounds(667, 409, 64, 20);
			this.textFieldCodePostal.setColumns(10);
		}
		return this.textFieldCodePostal;
	}

	private JTextField getTextFieldEmail() {
		if (this.textFieldEmail == null) {
			this.textFieldEmail = new JTextField();
			this.textFieldEmail.setForeground(Color.GRAY);
			this.textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldEmail.setBorder(new LineBorder(new Color(171, 173,
					179)));
			this.textFieldEmail.setBounds(481, 440, 338, 20);
			this.textFieldEmail.setColumns(10);
		}
		return this.textFieldEmail;
	}

	private JTextField getTextFieldNom() {
		if (this.textFieldNom == null) {
			this.textFieldNom = new JTextField();
			this.textFieldNom.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {

				}
			});
			this.textFieldNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldNom.setForeground(Color.GRAY);
			this.textFieldNom
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textFieldNom.setBounds(450, 347, 192, 20);
			this.textFieldNom.setColumns(10);

		}
		return this.textFieldNom;
	}

	private JTextField getTextFieldPrenom() {
		if (this.textFieldPrenom == null) {
			this.textFieldPrenom = new JTextField();
			this.textFieldPrenom.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {

				}
			});
			this.textFieldPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldPrenom.setForeground(Color.GRAY);
			this.textFieldPrenom.setBorder(new LineBorder(new Color(171, 173,
					179)));
			this.textFieldPrenom.setBounds(730, 347, 294, 20);
			this.textFieldPrenom.setColumns(10);
		}
		return this.textFieldPrenom;
	}

	private JComboBox<Object> getTextFieldVille() {
		if (this.textFieldVille == null) {
			this.textFieldVille = new JComboBox<Object>();
			this.textFieldVille.setEditable(true);
			this.textFieldVille.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					try {

						GestionClientOperationCommerciale.this.ville = GestionClientOperationCommerciale.this.textFieldVille
								.getSelectedItem().toString().toUpperCase();
						GestionClientOperationCommerciale.this.idville = ((Ville) GestionClientOperationCommerciale.this.textFieldVille
								.getSelectedItem()).getIdville();
						final String CP = ((Ville) GestionClientOperationCommerciale.this.textFieldVille
								.getSelectedItem()).getCodePostalVille();
						GestionClientOperationCommerciale.this.textFieldCodePostal
								.setText(CP);

					} catch (final Exception e3) {
						final String message = "Merci de selectionner une ville dans la liste";
						final AlerteSelection fenetre = new AlerteSelection(
								GestionClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						GestionClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.textFieldVille.setForeground(Color.GRAY);
			this.textFieldVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldVille.setBorder(null);
			this.textFieldVille.setBounds(302, 408, 270, 22);
			this.ListeVille = new DefaultComboBoxModel<Object>(
					Select.listeVille());
			this.textFieldVille.setModel(this.ListeVille);
			AutoCompletion.enable(this.textFieldVille);
		}
		return this.textFieldVille;
	}
}
