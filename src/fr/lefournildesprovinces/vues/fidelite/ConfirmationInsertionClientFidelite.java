package fr.lefournildesprovinces.vues.fidelite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.ressources.models.infostemporaire;
import fr.lefournildesprovinces.vues.SuccesInsertionClientFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.SuccesMagasinOperation;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;

public class ConfirmationInsertionClientFidelite extends JFrame {

	private static Connection c;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = -1441799905319467945L;
	private static PreparedStatement stm;
	private final String adresseClient;
	private final String ageClient;
	private final String choixetprovenance;
	private final String civiliteClient;
	private final String codePostalClient;
	private final int compteurprecedent;
	private final JPanel contentPane;
	private final String dateNaissanceClient;
	private String dateNaissanceClientfinale = null;
	private final String emailClient;
	private JLabel fond;
	private final int idmagasinClient;
	private final int idmagasinclientparticipant;
	private final int idoperationclientparticipant;
	private final int idvilleClient;
	private final JFrame InterfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLayeredPane layeredPane;
	private JLabel lblAdresse;
	private JLabel lbladresseClient;
	private JLabel lblAge;
	private JLabel lblCivilite;
	private JLabel lblCiviliteNomPrenom;
	private JLabel lblcodePostal;
	private JLabel lblCodePostal;
	private JLabel lblConfirmezVousLinsertion;
	private JLabel lblDateDeNaissance;
	private JLabel lbldateNaissance;
	private JLabel lblInscriptionNewsletter;
	private JLabel lblMail;
	private JLabel lblMerciDeVerifier;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblnewsletter;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblville;
	private JLabel lblVille;
	private String messageInsertion;
	private final String messageinsertion2 = null;
	private final String newsletterClient;
	private final String nomClient;
	private final String numcarte;
	private final String numerofixe;
	private final String numeroportable;
	private final String prenomClient;
	private String privilege;
	private final Vector<infostemporaire> requeteprecedente;
	private String text;
	private final String villeClient;

	public ConfirmationInsertionClientFidelite(final JFrame interfaceActuelle,
			final String numerocarte, final String magasin,
			final int idmagasin, final String civilite, final String nom,
			final String prenom, final String adresse, final int idville,
			final String ville, final String CodePostal,
			final String dateComplete, final String email,
			final String newsletter, final String numfixe, final String numpor,
			final String age, final Boolean vip, final int idoperationcommercialeparticipation,
			final int idmagasinparticipation, final String choixmenuprecedent,
			final int compteur2, final Vector<infostemporaire> requete) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				ConfirmationInsertionClientFidelite.this.lblCiviliteNomPrenom
						.setText(ConfirmationInsertionClientFidelite.this.civiliteClient
								+ " "
								+ ConfirmationInsertionClientFidelite.this.nomClient
								+ " "
								+ ConfirmationInsertionClientFidelite.this.prenomClient);
				ConfirmationInsertionClientFidelite.this.lbladresseClient
						.setText(ConfirmationInsertionClientFidelite.this.adresseClient);
				ConfirmationInsertionClientFidelite.this.lblville
						.setText(ConfirmationInsertionClientFidelite.this.villeClient);
				ConfirmationInsertionClientFidelite.this.lblnewsletter
						.setText(ConfirmationInsertionClientFidelite.this.newsletterClient);
				ConfirmationInsertionClientFidelite.this.lbldateNaissance
						.setText(ConfirmationInsertionClientFidelite.this.dateNaissanceClient);
				ConfirmationInsertionClientFidelite.this.lblcodePostal
						.setText(ConfirmationInsertionClientFidelite.this.codePostalClient);
				ConfirmationInsertionClientFidelite.this.label_1
						.setText(ConfirmationInsertionClientFidelite.this.numerofixe);
				ConfirmationInsertionClientFidelite.this.label_3
						.setText(ConfirmationInsertionClientFidelite.this.numeroportable);
				ConfirmationInsertionClientFidelite.this.lblNewLabel_1
						.setText(ConfirmationInsertionClientFidelite.this.ageClient);
				ConfirmationInsertionClientFidelite.this.lblNewLabel_2
						.setText(ConfirmationInsertionClientFidelite.this.emailClient);

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
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.InterfacePrecedente = interfaceActuelle;
		this.numcarte = numerocarte;
		this.idmagasinClient = idmagasin;
		this.civiliteClient = civilite;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.adresseClient = adresse;
		this.idvilleClient = idville;
		this.villeClient = ville;
		this.codePostalClient = CodePostal;
		this.dateNaissanceClient = dateComplete;
		this.emailClient = email;
		this.newsletterClient = newsletter;
		this.numerofixe = numfixe;
		this.numeroportable = numpor;
		this.ageClient = age;
		this.idoperationclientparticipant = idoperationcommercialeparticipation;
		this.idmagasinclientparticipant = idmagasinparticipation;
		this.choixetprovenance = choixmenuprecedent;
		this.compteurprecedent = compteur2;
		this.requeteprecedente = requete;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								ConfirmationInsertionClientFidelite.class
										.getResource("/Images/menus-grises-fidelite.png")));
				this.label_5.setEnabled(false);
				this.label_5.setVisible(false);
				this.label_7.setEnabled(false);
				this.label_7.setVisible(false);
				break;

			case "invite":
				this.label_5.setEnabled(false);
				this.label_5.setVisible(false);
				this.label_7.setEnabled(false);
				this.label_7.setVisible(false);
				this.fond
						.setIcon(new ImageIcon(
								ConfirmationInsertionClientFidelite.class
										.getResource("/Images/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						ConfirmationInsertionClientFidelite.class
								.getResource("/Images/menus_fidelite.png")));
				break;

			}
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("T\u00E9l\u00E9phone :");
			this.label.setForeground(Color.GRAY);
			this.label.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label.setBounds(397, 459, 79, 14);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.setForeground(Color.GRAY);
			this.label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_1.setBounds(469, 459, 89, 14);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("Mobile :");
			this.label_2.setForeground(Color.GRAY);
			this.label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_2.setBounds(618, 459, 62, 14);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setForeground(Color.GRAY);
			this.label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_3.setBounds(671, 459, 104, 14);
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
					ConfirmationInsertionClientFidelite.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(235, 231, 114, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					ConfirmationInsertionClientFidelite.this.dispose();
				}
			});
			this.label_5.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_5.setBounds(472, 231, 114, 44);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("");
			this.label_6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					ConfirmationInsertionClientFidelite.this.dispose();
				}
			});
			this.label_6.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_6.setBounds(589, 231, 114, 44);
		}
		return this.label_6;
	}

	private JLabel getLabel_7() {
		if (this.label_7 == null) {
			this.label_7 = new JLabel("");
			this.label_7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					ConfirmationInsertionClientFidelite.this.dispose();
				}
			});
			this.label_7.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_7.setBounds(703, 231, 114, 44);
		}
		return this.label_7;
	}

	private JLabel getLabel_8() {
		if (this.label_8 == null) {
			this.label_8 = new JLabel("");
			this.label_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					ConfirmationInsertionClientFidelite.this.dispose();
				}
			});
			this.label_8.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_8.setForeground(Color.GRAY);
			this.label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.label_8.setBounds(878, 231, 175, 48);
		}
		return this.label_8;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblConfirmezVousLinsertion());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getLblVille());
			this.layeredPane.add(this.getLblCodePostal());
			this.layeredPane.add(this.getLblCiviliteNomPrenom());
			this.layeredPane.add(this.getLblDateDeNaissance());
			this.layeredPane.add(this.getLblInscriptionNewsletter());
			this.layeredPane.add(this.getLbladresseClient());
			this.layeredPane.add(this.getLblville());
			this.layeredPane.add(this.getLblnewsletter());
			this.layeredPane.add(this.getLbldateNaissance());
			this.layeredPane.add(this.getLblcodePostal());
			this.layeredPane.add(this.getLblMerciDeVerifier());
			this.layeredPane.add(this.getLblCivilite());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getLabel_7());
			this.layeredPane.add(this.getLabel_8());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblMail());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_3());
		}
		return this.layeredPane;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse :");
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setBounds(410, 381, 66, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLbladresseClient() {
		if (this.lbladresseClient == null) {
			this.lbladresseClient = new JLabel("");
			this.lbladresseClient.setForeground(Color.GRAY);
			this.lbladresseClient.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lbladresseClient.setBounds(469, 381, 348, 14);
		}
		return this.lbladresseClient;
	}

	private JLabel getLblAge() {
		if (this.lblAge == null) {
			this.lblAge = new JLabel("Age :");
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAge.setForeground(Color.GRAY);
			this.lblAge.setBounds(633, 434, 47, 14);
		}
		return this.lblAge;
	}

	private JLabel getLblCivilite() {
		if (this.lblCivilite == null) {
			this.lblCivilite = new JLabel("Client :");
			this.lblCivilite.setForeground(Color.GRAY);
			this.lblCivilite.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCivilite.setBounds(424, 356, 52, 14);
		}
		return this.lblCivilite;
	}

	private JLabel getLblCiviliteNomPrenom() {
		if (this.lblCiviliteNomPrenom == null) {
			this.lblCiviliteNomPrenom = new JLabel("");
			this.lblCiviliteNomPrenom
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCiviliteNomPrenom.setForeground(Color.GRAY);
			this.lblCiviliteNomPrenom.setBounds(469, 356, 348, 14);
		}
		return this.lblCiviliteNomPrenom;
	}

	private JLabel getLblcodePostal() {
		if (this.lblcodePostal == null) {
			this.lblcodePostal = new JLabel("");
			this.lblcodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblcodePostal.setForeground(Color.GRAY);
			this.lblcodePostal.setBounds(671, 410, 104, 14);
		}
		return this.lblcodePostal;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("Code Postal :");
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCodePostal.setForeground(Color.GRAY);
			this.lblCodePostal.setBounds(589, 410, 91, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblConfirmezVousLinsertion() {
		if (this.lblConfirmezVousLinsertion == null) {
			this.lblConfirmezVousLinsertion = new JLabel(
					"Confirmez vous l'insertion de cette nouvelle Fiche Client ?");
			this.lblConfirmezVousLinsertion.setForeground(Color.GRAY);
			this.lblConfirmezVousLinsertion.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblConfirmezVousLinsertion.setBounds(380, 524, 348, 14);
		}
		return this.lblConfirmezVousLinsertion;
	}

	private JLabel getLblDateDeNaissance() {
		if (this.lblDateDeNaissance == null) {
			this.lblDateDeNaissance = new JLabel("Date de Naissance :");
			this.lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateDeNaissance.setForeground(Color.GRAY);
			this.lblDateDeNaissance.setBounds(353, 434, 123, 14);
		}
		return this.lblDateDeNaissance;
	}

	private JLabel getLbldateNaissance() {
		if (this.lbldateNaissance == null) {
			this.lbldateNaissance = new JLabel("");
			this.lbldateNaissance.setForeground(Color.GRAY);
			this.lbldateNaissance.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lbldateNaissance.setBounds(469, 434, 89, 14);
		}
		return this.lbldateNaissance;
	}

	private JLabel getLblInscriptionNewsletter() {
		if (this.lblInscriptionNewsletter == null) {
			this.lblInscriptionNewsletter = new JLabel("Newsletter :");
			this.lblInscriptionNewsletter.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblInscriptionNewsletter.setForeground(Color.GRAY);
			this.lblInscriptionNewsletter.setBounds(395, 484, 81, 14);
		}
		return this.lblInscriptionNewsletter;
	}

	private JLabel getLblMail() {
		if (this.lblMail == null) {
			this.lblMail = new JLabel("Mail :");
			this.lblMail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMail.setForeground(Color.GRAY);
			this.lblMail.setBounds(632, 484, 48, 14);
		}
		return this.lblMail;
	}

	private JLabel getLblMerciDeVerifier() {
		if (this.lblMerciDeVerifier == null) {
			this.lblMerciDeVerifier = new JLabel(
					"Merci de v\u00E9rifier votre saisie avant de confirmer :");
			this.lblMerciDeVerifier.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeVerifier.setForeground(Color.GRAY);
			this.lblMerciDeVerifier.setBounds(501, 321, 302, 14);
		}
		return this.lblMerciDeVerifier;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Nouvelle carte de fid\u00E9lit\u00E9");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 438, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(671, 434, 175, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(671, 484, 251, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setIcon(new ImageIcon(
					ConfirmationInsertionClientFidelite.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_3.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblnewsletter() {
		if (this.lblnewsletter == null) {
			this.lblnewsletter = new JLabel("");
			this.lblnewsletter.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblnewsletter.setForeground(Color.GRAY);
			this.lblnewsletter.setBounds(469, 484, 104, 14);
		}
		return this.lblnewsletter;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setIcon(new ImageIcon(
					ConfirmationInsertionClientFidelite.class
							.getResource("/Images/annuler.png")));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					ConfirmationInsertionClientFidelite.this.dispose();
					ConfirmationInsertionClientFidelite.this.InterfacePrecedente
							.setVisible(true);
					ConfirmationInsertionClientFidelite.this.InterfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(738, 520, 99, 23);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(new ImageIcon(
					ConfirmationInsertionClientFidelite.class
							.getResource("/Images/valider.png")));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					boolean etat = true;

					if (ConfirmationInsertionClientFidelite.this.dateNaissanceClient != null) {
						final String[] tab = ConfirmationInsertionClientFidelite.this.dateNaissanceClient
								.split("/");
						final String day = tab[0];
						final String month = tab[1];
						final String year = tab[2];
						ConfirmationInsertionClientFidelite.this.dateNaissanceClientfinale = year
								+ "/" + month + "/" + day;
					}

					try {
						c = Connexion.getCon();
						c.setAutoCommit(false);

						final String sql = "INSERT INTO CLIENT (CIVILITECLIENT,NOMCLIENT,PRENOMCLIENT,ADRESSECLIENT,IDVILLE,DATENAISSANCECLIENT,MAILCLIENT,ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
						stm = c.prepareStatement(sql);

						stm.setString(
								1,
								ConfirmationInsertionClientFidelite.this.civiliteClient);
						stm.setString(
								2,
								ConfirmationInsertionClientFidelite.this.nomClient);
						stm.setString(
								3,
								ConfirmationInsertionClientFidelite.this.prenomClient);
						stm.setString(
								4,
								ConfirmationInsertionClientFidelite.this.adresseClient);
						if (idvilleClient == 0) {
							stm.setNull(5, Types.INTEGER);
						} else {
							stm.setInt(5, idvilleClient);
						}
						stm.setString(
								6,
								ConfirmationInsertionClientFidelite.this.dateNaissanceClientfinale);
						stm.setString(
								7,
								ConfirmationInsertionClientFidelite.this.emailClient);
						stm.setString(
								8,
								ConfirmationInsertionClientFidelite.this.newsletterClient);
						stm.setString(
								9,
								ConfirmationInsertionClientFidelite.this.numerofixe);
						stm.setString(
								10,
								ConfirmationInsertionClientFidelite.this.numeroportable);
						stm.setString(
								11,
								ConfirmationInsertionClientFidelite.this.ageClient);

						stm.executeUpdate();

						stm.close();

						final String dernierincrementclient = "SELECT MAX( LAST_INSERT_ID(IDCLIENT)) FROM CLIENT";
						stm = c.prepareStatement(dernierincrementclient);
						rs = stm.executeQuery();
						int lastidclient = 0;
						while (rs.next()) {
							lastidclient = rs.getInt(1);
						}

						rs.close();
						stm.close();

						if (idmagasinClient != 0) {
							final String table_frequenter = "INSERT INTO FREQUENTER (IDCLIENT, IDMAGASIN) VALUES (?,?)";
							stm = c.prepareStatement(table_frequenter);

							stm.setInt(1, lastidclient);
							stm.setInt(
									2,
									ConfirmationInsertionClientFidelite.this.idmagasinClient);

							stm.executeUpdate();
							stm.close();
						}

						final String table_carte_de_fidelite = "INSERT INTO CARTE_DE_FIDELITE (IDCLIENT,NUMEROCARTEDEFIDELITE) VALUES (?,?)";
						stm = c.prepareStatement(table_carte_de_fidelite);

						stm.setInt(1, lastidclient);
						stm.setString(
								2,
								ConfirmationInsertionClientFidelite.this.numcarte);

						stm.executeUpdate();
						stm.close();

						final String dernierincrementcartefidelite = "SELECT MAX( LAST_INSERT_ID(IDCARTEDEFIDELITE)) FROM CARTE_DE_FIDELITE";
						stm = c.prepareStatement(dernierincrementcartefidelite);
						rs = stm.executeQuery();
						int lastidcarte = 0;
						while (rs.next())

						{
							lastidcarte = rs.getInt(1);
						}

						rs.close();
						stm.close();

						if (idmagasinClient != 0) {
							final String table_delivrer = "INSERT INTO DELIVRER (IDCARTEDEFIDELITE, IDMAGASIN) VALUES (?,?)";
							stm = c.prepareStatement(table_delivrer);

							stm.setInt(1, lastidcarte);
							stm.setInt(
									2,
									ConfirmationInsertionClientFidelite.this.idmagasinClient);

							stm.executeUpdate();
							stm.close();
						}
						if (ConfirmationInsertionClientFidelite.this.compteurprecedent == 1) {

							for (int i = 0; i < ConfirmationInsertionClientFidelite.this.requeteprecedente
									.size(); i++) {

								final String majcopyparticiper = "INSERT INTO PARTICIPER (IDOPERATIONCOMMERCIALE,IDCLIENT,IDMAGASIN) VALUES (?,?,?)";
								stm = c.prepareStatement(majcopyparticiper);

								stm.setInt(
										1,
										ConfirmationInsertionClientFidelite.this.requeteprecedente
												.get(i)
												.getIdoperationTemporaire());
								stm.setInt(2, lastidclient);
								stm.setInt(
										3,
										ConfirmationInsertionClientFidelite.this.requeteprecedente
												.get(i)
												.getIdMagasinTemporaire());

								stm.executeUpdate();

								stm.close();

							}
						}

						if (ConfirmationInsertionClientFidelite.this.choixetprovenance
								.equals("creationcarteparoperation"))

						{

							final String majcopyparticiper = "INSERT INTO PARTICIPER(IDOPERATIONCOMMERCIALE,IDCLIENT,IDMAGASIN) VALUES (?,?,?)";
							stm = c.prepareStatement(majcopyparticiper);

							stm.setInt(
									1,
									ConfirmationInsertionClientFidelite.this.idoperationclientparticipant);
							stm.setInt(2, lastidclient);
							stm.setInt(
									3,
									ConfirmationInsertionClientFidelite.this.idmagasinclientparticipant);

							stm.executeUpdate();

							stm.close();

						}

						c.commit();
						c.setAutoCommit(true);

						final SuccesInsertionClientFidelite fenetre = new SuccesInsertionClientFidelite(
								ConfirmationInsertionClientFidelite.this.civiliteClient,
								ConfirmationInsertionClientFidelite.this.nomClient,
								ConfirmationInsertionClientFidelite.this.prenomClient,
								ConfirmationInsertionClientFidelite.this.dateNaissanceClient,
								ConfirmationInsertionClientFidelite.this.numcarte,
								ConfirmationInsertionClientFidelite.this.ageClient,
								ConfirmationInsertionClientFidelite.this.choixetprovenance,
								ConfirmationInsertionClientFidelite.this.idoperationclientparticipant,
								ConfirmationInsertionClientFidelite.this.idmagasinclientparticipant);
						fenetre.setVisible(true);
						ConfirmationInsertionClientFidelite.this.InterfacePrecedente
								.dispose();
						ConfirmationInsertionClientFidelite.this.dispose();

					} catch (final Exception e1)

					{
						System.out.print("erreur" + e1.getMessage());
						try {
							c.rollback();
							final String erreur = e1.getMessage();
							/*
							 * String [] tab =dateNaissanceClient.split("/");
							 * String day=tab[0]; String month=tab[1]; String
							 * year=tab[2];
							 */
							final String erreurtype = "Duplicate entry '"
									+ ConfirmationInsertionClientFidelite.this.nomClient
									+ "-"
									+ ConfirmationInsertionClientFidelite.this.prenomClient
									+ "-"
									+ ConfirmationInsertionClientFidelite.this.ageClient
									+ "-"
									+ ConfirmationInsertionClientFidelite.this.idvilleClient
									+ "' for key 'NOMCLIENT'";

							if (erreur.equals(erreurtype)) {
								ConfirmationInsertionClientFidelite.this.messageInsertion = "le Client "
										+ ConfirmationInsertionClientFidelite.this.civiliteClient
										+ " "
										+ ConfirmationInsertionClientFidelite.this.nomClient
										+ " "
										+ ConfirmationInsertionClientFidelite.this.prenomClient
										+ " possède deja une carte";

							} else {
								ConfirmationInsertionClientFidelite.this.messageInsertion = "Impossible d'insérer le Client "
										+ ConfirmationInsertionClientFidelite.this.civiliteClient
										+ " "
										+ ConfirmationInsertionClientFidelite.this.nomClient
										+ " "
										+ ConfirmationInsertionClientFidelite.this.prenomClient
										+ "";
							}
							System.out
									.print(ConfirmationInsertionClientFidelite.this.messageInsertion);
							etat = false;
							ConfirmationInsertionClientFidelite.this.text = "Nouvelle Fiche Client";
							Message.setMessageaffichagefond(ConfirmationInsertionClientFidelite.this.text);
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									ConfirmationInsertionClientFidelite.this.messageInsertion,
									etat,
									ConfirmationInsertionClientFidelite.this.text,
									ConfirmationInsertionClientFidelite.this.messageinsertion2,
									ConfirmationInsertionClientFidelite.this.choixetprovenance,
									ConfirmationInsertionClientFidelite.this.idoperationclientparticipant,
									ConfirmationInsertionClientFidelite.this.idmagasinclientparticipant);
							fenetre.setVisible(true);

							fenetre.setAlwaysOnTop(true);
							ConfirmationInsertionClientFidelite.this.dispose();

						} catch (final SQLException e2) {

							e2.printStackTrace();
						}
					}
					try {

						if (stm != null) {
							stm.close();
						}

					} catch (final Exception e3) {
						e3.printStackTrace();
					}

				}
			});
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setBounds(878, 520, 99, 23);
		}
		return this.lblOui;
	}

	private JLabel getLblville() {
		if (this.lblville == null) {
			this.lblville = new JLabel("");
			this.lblville.setForeground(Color.GRAY);
			this.lblville.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblville.setBounds(469, 410, 89, 14);
		}
		return this.lblville;
	}

	private JLabel getLblVille() {
		if (this.lblVille == null) {
			this.lblVille = new JLabel("Ville :");
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblVille.setForeground(Color.GRAY);
			this.lblVille.setBounds(433, 410, 43, 14);
		}
		return this.lblVille;
	}
}
