package fr.lefournildesprovinces.vues.opcom;

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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.SuccesOperation;

public class ConfirmationInsertionClientOC extends JFrame {

	private static Connection c;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = -2522219577130834723L;
	private static PreparedStatement stm;
	private final String adresseClient;
	private final String ageClient;
	private final String civiliteClient;
	private final String codePostalClient;
	private final JPanel contentPane;
	private final String dateNaissanceClient;
	private String dateNaissanceClientfinale = null;
	private final String emailClient;
	private JLabel fond;
	private final int identifiantville;
	private final int idmagasin;
	private final int IdOperationCommerciale;
	private final JFrame InterfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
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
	private JLabel lblMobile;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblnewsletter;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblSaisirUnBulletin;
	private JLabel lblTelephone;
	private JLabel lblville;
	private JLabel lblVille;
	private String messageInsertion2 = null;
	private final String newsletterClient;
	private final String nomClient;
	private int numclient;
	private final String prenomClient;
	private String privilege;
	private final String telephonefixe;
	private final String telephoneportable;
	private String text;
	private final String villeClient;

	public ConfirmationInsertionClientOC(final JFrame interfaceActuelle,
			final String civilite, final String nom, final String prenom,
			final String adresse, final String ville, final String codePostal,
			final String email, final String newsletter,
			final String dateComplete, final int numeroOperationCommerciale,
			final int numeromagasin, final int idville, final String numfixe,
			final String numpor, final String age) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				ConfirmationInsertionClientOC.this.lblCiviliteNomPrenom
						.setText(ConfirmationInsertionClientOC.this.civiliteClient
								+ " "
								+ ConfirmationInsertionClientOC.this.nomClient
								+ " "
								+ ConfirmationInsertionClientOC.this.prenomClient);
				ConfirmationInsertionClientOC.this.lbladresseClient
						.setText(ConfirmationInsertionClientOC.this.adresseClient);
				ConfirmationInsertionClientOC.this.lblville
						.setText(ConfirmationInsertionClientOC.this.villeClient);
				ConfirmationInsertionClientOC.this.lblnewsletter
						.setText(ConfirmationInsertionClientOC.this.newsletterClient);
				ConfirmationInsertionClientOC.this.lbldateNaissance
						.setText(ConfirmationInsertionClientOC.this.dateNaissanceClient);
				ConfirmationInsertionClientOC.this.lblcodePostal
						.setText(ConfirmationInsertionClientOC.this.codePostalClient);
				ConfirmationInsertionClientOC.this.lblNewLabel
						.setText(ConfirmationInsertionClientOC.this.telephonefixe);
				ConfirmationInsertionClientOC.this.lblNewLabel_1
						.setText(ConfirmationInsertionClientOC.this.telephoneportable);
				ConfirmationInsertionClientOC.this.lblNewLabel_2
						.setText(ConfirmationInsertionClientOC.this.ageClient);
				ConfirmationInsertionClientOC.this.lblNewLabel_3
						.setText(ConfirmationInsertionClientOC.this.emailClient);

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
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setLocationRelativeTo(null);
		this.InterfacePrecedente = interfaceActuelle;
		this.civiliteClient = civilite;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.adresseClient = adresse;
		this.villeClient = ville;
		this.codePostalClient = codePostal;
		this.emailClient = email;
		this.dateNaissanceClient = dateComplete;
		this.newsletterClient = newsletter;
		this.IdOperationCommerciale = numeroOperationCommerciale;
		this.idmagasin = numeromagasin;
		this.identifiantville = idville;
		this.telephonefixe = numfixe;
		this.telephoneportable = numpor;
		this.ageClient = age;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								ConfirmationInsertionClientOC.class
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
								ConfirmationInsertionClientOC.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						ConfirmationInsertionClientOC.class
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
					ConfirmationInsertionClientOC.this.dispose();
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
					ConfirmationInsertionClientOC.this.dispose();
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
					ConfirmationInsertionClientOC.this.dispose();
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
					ConfirmationInsertionClientOC.this.dispose();
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
					ConfirmationInsertionClientOC.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(862, 234, 187, 44);
		}
		return this.label_4;
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
			this.layeredPane.add(this.getLblTelephone());
			this.layeredPane.add(this.getLblMobile());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblSaisirUnBulletin());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblMail());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_4());
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
			this.lblAge.setForeground(Color.GRAY);
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAge.setBounds(633, 434, 42, 14);
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
			this.lblCodePostal.setBounds(589, 410, 86, 14);
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
			this.lblConfirmezVousLinsertion.setBounds(380, 524, 358, 14);
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
			this.lblMail.setForeground(Color.GRAY);
			this.lblMail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMail.setBounds(632, 484, 43, 14);
		}
		return this.lblMail;
	}

	private JLabel getLblMerciDeVerifier() {
		if (this.lblMerciDeVerifier == null) {
			this.lblMerciDeVerifier = new JLabel(
					"Merci de v\u00E9rifier votre saisie avant de confirmer :");
			this.lblMerciDeVerifier.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeVerifier.setForeground(Color.GRAY);
			this.lblMerciDeVerifier.setBounds(501, 321, 316, 14);
		}
		return this.lblMerciDeVerifier;
	}

	private JLabel getLblMobile() {
		if (this.lblMobile == null) {
			this.lblMobile = new JLabel("Mobile :");
			this.lblMobile.setForeground(Color.GRAY);
			this.lblMobile.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMobile.setBounds(618, 459, 57, 14);
		}
		return this.lblMobile;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(469, 459, 89, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(671, 459, 104, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(671, 434, 175, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_3.setForeground(Color.GRAY);
			this.lblNewLabel_3.setBounds(671, 484, 251, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setIcon(new ImageIcon(
					ConfirmationInsertionClientOC.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_4.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_4;
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
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setIcon(new ImageIcon(
					ConfirmationInsertionClientOC.class
							.getResource("/Images/actionbutons/annuler.png")));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					ConfirmationInsertionClientOC.this.dispose();
					ConfirmationInsertionClientOC.this.InterfacePrecedente
							.setVisible(true);
					ConfirmationInsertionClientOC.this.InterfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(747, 520, 99, 23);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(new ImageIcon(
					ConfirmationInsertionClientOC.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					boolean etat = true;
					if (ConfirmationInsertionClientOC.this.dateNaissanceClient != null) {
						final String[] tab = ConfirmationInsertionClientOC.this.dateNaissanceClient
								.split("/");
						final String day = tab[0];
						final String month = tab[1];
						final String year = tab[2];
						ConfirmationInsertionClientOC.this.dateNaissanceClientfinale = year
								+ "/" + month + "/" + day;
					}
					try {
						c = Connexion.getCon();
						c.setAutoCommit(false);

						final String sql = "INSERT INTO CLIENT (CIVILITECLIENT,NOMCLIENT,PRENOMCLIENT,ADRESSECLIENT,IDVILLE,DATENAISSANCECLIENT,MAILCLIENT,ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT, AGECLIENT) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
						stm = c.prepareStatement(sql);

						stm.setString(
								1,
								ConfirmationInsertionClientOC.this.civiliteClient);
						stm.setString(2,
								ConfirmationInsertionClientOC.this.nomClient);
						stm.setString(3,
								ConfirmationInsertionClientOC.this.prenomClient);
						stm.setString(
								4,
								ConfirmationInsertionClientOC.this.adresseClient);
						stm.setInt(
								5,
								ConfirmationInsertionClientOC.this.identifiantville);
						stm.setString(
								6,
								ConfirmationInsertionClientOC.this.dateNaissanceClientfinale);
						stm.setString(7,
								ConfirmationInsertionClientOC.this.emailClient);
						stm.setString(
								8,
								ConfirmationInsertionClientOC.this.newsletterClient);
						stm.setString(
								9,
								ConfirmationInsertionClientOC.this.telephonefixe);
						stm.setString(
								10,
								ConfirmationInsertionClientOC.this.telephoneportable);
						stm.setString(11,
								ConfirmationInsertionClientOC.this.ageClient);

						stm.executeUpdate();

						final String dernierincrementclient = "SELECT MAX( LAST_INSERT_ID(IDCLIENT)) FROM CLIENT";
						stm = c.prepareStatement(dernierincrementclient);
						rs = stm.executeQuery();
						int lastidclient = 0;
						while (rs.next())

						{
							lastidclient = rs.getInt(1);
						}

						final String table_frequenter = "INSERT INTO FREQUENTER (IDCLIENT, IDMAGASIN) VALUES (?,?)";
						stm = c.prepareStatement(table_frequenter);

						stm.setInt(1, lastidclient);
						stm.setInt(2,
								ConfirmationInsertionClientOC.this.idmagasin);

						stm.executeUpdate();

						final String table_participer = "INSERT INTO PARTICIPER(IDOPERATIONCOMMERCIALE,IDCLIENT,IDMAGASIN) VALUES (?,?,?)";
						stm = c.prepareStatement(table_participer);

						stm.setInt(
								1,
								ConfirmationInsertionClientOC.this.IdOperationCommerciale);
						stm.setInt(2, lastidclient);
						stm.setInt(3,
								ConfirmationInsertionClientOC.this.idmagasin);

						stm.executeUpdate();

						c.commit();
						c.setAutoCommit(true);

						final SuccesInsertionClientOC fenetre = new SuccesInsertionClientOC(
								ConfirmationInsertionClientOC.this.civiliteClient,
								ConfirmationInsertionClientOC.this.nomClient,
								ConfirmationInsertionClientOC.this.prenomClient,
								ConfirmationInsertionClientOC.this.dateNaissanceClient,
								ConfirmationInsertionClientOC.this.IdOperationCommerciale,
								ConfirmationInsertionClientOC.this.idmagasin,
								ConfirmationInsertionClientOC.this.ageClient);
						fenetre.setVisible(true);
						ConfirmationInsertionClientOC.this.InterfacePrecedente
								.dispose();
						ConfirmationInsertionClientOC.this.dispose();

					} catch (final Exception e1)

					{
						final String erreur = e1.getMessage();
						System.out.print("####" + erreur + "####");

						try {
							c.rollback();
							String messageInsertion;

							final String erreurtype = "Duplicate entry '"
									+ ConfirmationInsertionClientOC.this.nomClient
									+ "-"
									+ ConfirmationInsertionClientOC.this.prenomClient
									+ "-"
									+ ConfirmationInsertionClientOC.this.ageClient
									+ "-"
									+ ConfirmationInsertionClientOC.this.identifiantville
									+ "' for key 'NOMCLIENT'";
							System.out.print("@@@@" + erreurtype + "@@@@");

							if (erreur.equals(erreurtype)) {

								// test porteur carte si oui message different
								final String sql10 = "SELECT IDCLIENT FROM CLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND AGECLIENT=? AND IDVILLE=?";
								stm = c.prepareStatement(sql10);

								stm.setString(
										1,
										ConfirmationInsertionClientOC.this.nomClient);
								stm.setString(
										2,
										ConfirmationInsertionClientOC.this.prenomClient);
								stm.setString(
										3,
										ConfirmationInsertionClientOC.this.ageClient);
								stm.setInt(
										4,
										ConfirmationInsertionClientOC.this.identifiantville);
								rs = stm.executeQuery();
								while (rs.next())

								{
									ConfirmationInsertionClientOC.this.numclient = rs
											.getInt(1);
								}

								stm.close();
								rs.close();

								int compteur = 0;
								final String sql20 = "SELECT COUNT(IDCLIENT) FROM CARTE_DE_FIDELITE WHERE IDCLIENT=?";
								stm = c.prepareStatement(sql20);

								stm.setInt(
										1,
										ConfirmationInsertionClientOC.this.numclient);

								rs = stm.executeQuery();
								while (rs.next())

								{
									compteur = rs.getInt(1);
								}

								stm.close();
								rs.close();

								if (compteur != 0) {
									messageInsertion = ConfirmationInsertionClientOC.this.civiliteClient
											+ " "
											+ ConfirmationInsertionClientOC.this.nomClient
											+ " "
											+ ConfirmationInsertionClientOC.this.prenomClient
											+ " est déjà porteur d'une carte de fidelité";
									ConfirmationInsertionClientOC.this.messageInsertion2 = "Seule la participation sera prise en compte";
								} else {

									messageInsertion = ConfirmationInsertionClientOC.this.civiliteClient
											+ " "
											+ ConfirmationInsertionClientOC.this.nomClient
											+ " "
											+ ConfirmationInsertionClientOC.this.prenomClient
											+ " n'est pas encore porteur d'une de carte de fidelité mais existe déjà dans le fichier client";
									ConfirmationInsertionClientOC.this.messageInsertion2 = "seule la participation sera prise en compte";
								}
								try {

									final String sql2 = "SELECT IDCLIENT FROM CLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND AGECLIENT=?";
									stm = c.prepareStatement(sql2);

									stm.setString(
											1,
											ConfirmationInsertionClientOC.this.nomClient);
									stm.setString(
											2,
											ConfirmationInsertionClientOC.this.prenomClient);
									stm.setString(
											3,
											ConfirmationInsertionClientOC.this.ageClient);
									rs = stm.executeQuery();
									while (rs.next())

									{
										ConfirmationInsertionClientOC.this.numclient = rs
												.getInt(1);
									}

									stm.close();
									rs.close();

									final String table_participer = "INSERT INTO PARTICIPER(IDOPERATIONCOMMERCIALE,IDCLIENT,IDMAGASIN) VALUES (?,?,?)";
									stm = c.prepareStatement(table_participer);

									stm.setInt(
											1,
											ConfirmationInsertionClientOC.this.IdOperationCommerciale);
									stm.setInt(
											2,
											ConfirmationInsertionClientOC.this.numclient);
									stm.setInt(
											3,
											ConfirmationInsertionClientOC.this.idmagasin);

									stm.executeUpdate();

									stm.close();
									rs.close();
									c.commit();
								} catch (final SQLException e6) {
									c.rollback();
									e6.getMessage();
									messageInsertion = "Ce client à déja participé à cette opération dans ce magasin";
									ConfirmationInsertionClientOC.this.messageInsertion2 = "nous ne pouvons pas prendre en compte cette partcipation";
								}
							} else {
								messageInsertion = "Impossible d'insérer le Client "
										+ ConfirmationInsertionClientOC.this.civiliteClient
										+ " "
										+ ConfirmationInsertionClientOC.this.nomClient
										+ " "
										+ ConfirmationInsertionClientOC.this.prenomClient
										+ "";

							}

							System.out.print(messageInsertion);
							etat = false;
							ConfirmationInsertionClientOC.this.text = "Nouvelle participation";
							Message.setMessageaffichagefond(ConfirmationInsertionClientOC.this.text);
							final String provenance = "operationcommerciale";
							final SuccesOperation fenetre = new SuccesOperation(
									messageInsertion,
									etat,
									ConfirmationInsertionClientOC.this.text,
									ConfirmationInsertionClientOC.this.messageInsertion2,
									provenance,
									ConfirmationInsertionClientOC.this.IdOperationCommerciale,
									ConfirmationInsertionClientOC.this.idmagasin);
							fenetre.setVisible(true);

							fenetre.setAlwaysOnTop(true);
							ConfirmationInsertionClientOC.this.dispose();

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
			this.lblOui.setBounds(888, 520, 99, 23);
		}
		return this.lblOui;
	}

	private JLabel getLblSaisirUnBulletin() {
		if (this.lblSaisirUnBulletin == null) {
			this.lblSaisirUnBulletin = new JLabel("Saisir un bulletin");
			this.lblSaisirUnBulletin.setForeground(Color.GRAY);
			this.lblSaisirUnBulletin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblSaisirUnBulletin.setBounds(242, 286, 323, 14);
		}
		return this.lblSaisirUnBulletin;
	}

	private JLabel getLblTelephone() {
		if (this.lblTelephone == null) {
			this.lblTelephone = new JLabel("Telephone :");
			this.lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTelephone.setForeground(Color.GRAY);
			this.lblTelephone.setBounds(397, 459, 79, 14);
		}
		return this.lblTelephone;
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
