package fr.lefournildesprovinces.vues.fidelite;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import org.apache.commons.validator.routines.EmailValidator;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.models.infostemporaire;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.deplacementdatas;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.Loading;

import javax.swing.JCheckBox;

public class FideliteNouvelleFicheClient extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	private Loading lblLoading;
	/**
	 *
	 */
	private static final long serialVersionUID = -7191493576702107874L;

	ButtonGroup group = new ButtonGroup();
	private ComboBoxModel<Object> listeVille;
	private ComboBoxModel<Object> listemagasins;
	private JComboBox<Object> comboBoxAnnee;
	private JComboBox<Object> comboBoxCivilite;
	private JComboBox<Object> comboBoxJour;
	private JComboBox<Object> comboBoxMagasins;
	private JComboBox<Object> comboBoxMois;
	private JComboBox<Object> comboBoxVilles;
	private JFormattedTextField textField_CodePostal;
	private JLabel fond;
	private JLabel labelMobile;
	private JLabel labelTelephone;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblAdresse;
	private JLabel lblAge;
	private JLabel lblChampObligatoire;
	private JLabel lblCivilit;
	private JLabel lblCodePostal;
	private JLabel lblDateDeNaissance;
	private JLabel lblEmail;
	private JLabel lblFermer;
	private JLabel lblMagasinDeRfrence;
	private JLabel lblMenuGestion;
	private JLabel lblNCarte;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewslettert;
	private JLabel lblNom;
	private JLabel lblPrnom;
	private JLabel lblValider;
	private JLabel lblVille;
	private JLayeredPane layeredPane;
	private JRadioButton rdbtnDesinscrit;
	private JRadioButton rdbtnNon;
	private JRadioButton rdbtnOui;
	private MaskFormatter mask;
	private String CodePostalClient;
	private String adresseClient;
	private String age;
	private String annee;
	private String civilite;
	private String dateComplete;
	private String email;
	private String jourdate;
	private String magasin;
	private String message;
	private String moisdate;
	private String newsletter;
	private String nomClient;
	private String numerocarte;
	private String prenomClient;
	private String privilege;
	private String telephonefixe;
	private String telephoneportable;
	private Boolean vip;
	private TextField formattedTextFieldNumCli;
	private TextField textField_Adresse;
	private TextField textField_Age;
	private TextField textField_Mail;
	private TextField textField_Nom;
	private TextField textField_Prenom;
	private TextField textField_TelFix;
	private TextField textField_TelMob;
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private final JPanel contentPane;
	private final String choixmenuprecedent;
	private final int idmagasinparticipation;
	private final int idoperationcommercialeparticipation;
	private int compteur2 = 0;
	private int idmagasin;
	private int idville;
	private JCheckBox checkBoxVIP;

	private class TextField extends JTextField {

		/**
		 *
		 */
		private static final long serialVersionUID = -2729405542981121442L;

		public TextField() {
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					super.keyTyped(e);
					if ('\n' == e.getKeyChar()) {
						validateAction();
					}
				}
			});
		}
	}

	private String valeurCaseNewsletter;

	private String villeClient;

	public FideliteNouvelleFicheClient(final String numcarte, final int numoperation, final int nummagasin,
			final String choix, final JFrame interfacePrecedente) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				System.out.println(" last choice was " + FideliteNouvelleFicheClient.this.choixmenuprecedent);
				if (FideliteNouvelleFicheClient.this.choixmenuprecedent.equals("creationcarteparoperation")) {
					FideliteNouvelleFicheClient.this.textField_Age.setEditable(true);
					FideliteNouvelleFicheClient.this.textField_Age.setEnabled(true);
					FideliteNouvelleFicheClient.this.textField_Age.setFocusable(true);
					FideliteNouvelleFicheClient.this.formattedTextFieldNumCli.setText(numcarte);
					FideliteNouvelleFicheClient.this.comboBoxJour.setEnabled(false);
					FideliteNouvelleFicheClient.this.comboBoxJour.setFocusable(false);
					FideliteNouvelleFicheClient.this.comboBoxMois.setEnabled(false);
					FideliteNouvelleFicheClient.this.comboBoxMois.setFocusable(false);
					FideliteNouvelleFicheClient.this.comboBoxAnnee.setEnabled(false);
					FideliteNouvelleFicheClient.this.comboBoxAnnee.setFocusable(false);
					FideliteNouvelleFicheClient.this.comboBoxAnnee.requestFocus();
				} else {
					FideliteNouvelleFicheClient.this.textField_Age.setEditable(false);
					FideliteNouvelleFicheClient.this.textField_Age.setFocusable(false);
					FideliteNouvelleFicheClient.this.formattedTextFieldNumCli.requestFocus();
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
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.choixmenuprecedent = choix;
		this.interfacePrecedente = interfacePrecedente;
		this.interfaceActuelle = this;
		this.idoperationcommercialeparticipation = numoperation;
		this.idmagasinparticipation = nummagasin;
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				if ('\n' == e.getKeyChar()) {
					System.out.println("OK");
				}
			}
		});
	}

	private JCheckBox getCheckVip() {
		if (this.checkBoxVIP == null) {
			this.checkBoxVIP = new JCheckBox("VIP");
			this.checkBoxVIP.setBounds(829, 492, 97, 23);
			FideliteNouvelleFicheClient.this.vip = false;
			this.checkBoxVIP.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					FideliteNouvelleFicheClient.this.vip = FideliteNouvelleFicheClient.this.checkBoxVIP.isSelected();

					System.out.println("vip change to : " + FideliteNouvelleFicheClient.this.vip);

				}
			});
		}
		return this.checkBoxVIP;

	}

	private JComboBox<Object> getComboBoxMagasins() {
		if (this.comboBoxMagasins == null) {
			this.comboBoxMagasins = new JComboBox<Object>();
			this.comboBoxMagasins.setForeground(Color.GRAY);
			this.comboBoxMagasins.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						FideliteNouvelleFicheClient.this.magasin = FideliteNouvelleFicheClient.this.comboBoxMagasins
								.getSelectedItem().toString();
						FideliteNouvelleFicheClient.this.comboBoxCivilite.setEnabled(true);
					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								FideliteNouvelleFicheClient.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBoxMagasins.setBackground(Color.WHITE);
			this.comboBoxMagasins.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMagasins.setBorder(null);
			this.comboBoxMagasins.setBounds(668, 333, 364, 22);
			this.listemagasins = new DefaultComboBoxModel<Object>(Select.listemagasins());
			this.comboBoxMagasins.setModel(this.listemagasins);

		}
		return this.comboBoxMagasins;
	}

	private JComboBox<Object> getComboBoxCivilite() {
		if (this.comboBoxCivilite == null) {
			final String[] civiliteclient = { "", "Mr", "Mme", "NR" };
			this.comboBoxCivilite = new JComboBox<Object>(civiliteclient);

			this.comboBoxCivilite.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						FideliteNouvelleFicheClient.this.civilite = FideliteNouvelleFicheClient.this.comboBoxCivilite
								.getSelectedItem().toString();
						System.out.println("civ :" + FideliteNouvelleFicheClient.this.civilite);
						FideliteNouvelleFicheClient.this.textField_Nom.setEnabled(true);
					} catch (final Exception e1) {
						final String message = "Choix Civilité Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								FideliteNouvelleFicheClient.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBoxCivilite.setBackground(Color.WHITE);
			this.comboBoxCivilite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxCivilite.setBorder(null);
			this.comboBoxCivilite.setForeground(Color.GRAY);
			this.comboBoxCivilite.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxCivilite.setBounds(310, 366, 93, 22);
		}
		return this.comboBoxCivilite;
	}

	private JComboBox<Object> getComboBoxAnnee() {
		if (this.comboBoxAnnee == null) {
			this.comboBoxAnnee = new JComboBox<Object>();
			this.comboBoxAnnee.setBackground(Color.WHITE);

			this.comboBoxAnnee.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// FideliteNouvelleFicheClient.this.lblAnne.setVisible(false);

					try {

						FideliteNouvelleFicheClient.this.annee = FideliteNouvelleFicheClient.this.comboBoxAnnee
								.getSelectedItem().toString();
						if (!" --Année--".equals(annee)) {
							System.out.println("year : " + FideliteNouvelleFicheClient.this.annee);
							FideliteNouvelleFicheClient.this.textField_Mail.setEnabled(true);
							FideliteNouvelleFicheClient.this.rdbtnOui.setEnabled(true);
							FideliteNouvelleFicheClient.this.rdbtnNon.setEnabled(true);
							FideliteNouvelleFicheClient.this.rdbtnDesinscrit.setEnabled(true);

							final Calendar calendrier = Calendar.getInstance();
							final int anneecourante = calendrier.get(Calendar.YEAR);
							final int age = anneecourante - Integer.parseInt(FideliteNouvelleFicheClient.this.annee);
							FideliteNouvelleFicheClient.this.textField_Age.setText(Integer.toString(age));
						}
					} catch (final Exception e2) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								FideliteNouvelleFicheClient.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBoxAnnee.setFont(new Font("Tahoma", Font.BOLD, 11));

			this.comboBoxAnnee.setForeground(Color.GRAY);
			this.comboBoxAnnee.setBorder(null);
			this.comboBoxAnnee.setBounds(929, 428, 103, 22);
			this.comboBoxAnnee.addItem(" --Année--");

			final int year = Calendar.getInstance().get(Calendar.YEAR);
			for (int anneemenu = year - 18; anneemenu >= 1900; anneemenu--) {
				this.comboBoxAnnee.addItem(anneemenu);
			}

		}
		return this.comboBoxAnnee;
	}

	private JComboBox<Object> getComboBoxJour() {
		if (this.comboBoxJour == null) {
			final String[] jour = { " --Jour--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
					"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
					"29", "30", "31" };
			this.comboBoxJour = new JComboBox<Object>(jour);
			this.comboBoxJour.setBackground(Color.WHITE);
			this.comboBoxJour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						FideliteNouvelleFicheClient.this.jourdate = FideliteNouvelleFicheClient.this.comboBoxJour
								.getSelectedItem().toString();
						if (!" --Jour--".equals(jourdate)) {
							System.out.println("jour : " + FideliteNouvelleFicheClient.this.jourdate);
							FideliteNouvelleFicheClient.this.comboBoxMois.setEnabled(true);
						}
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								FideliteNouvelleFicheClient.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);
					}
				}
			});
			this.comboBoxJour.setFont(new Font("Tahoma", Font.BOLD, 11));

			this.comboBoxJour.setForeground(Color.GRAY);
			this.comboBoxJour.setBorder(null);
			this.comboBoxJour.setBounds(684, 428, 96, 22);

		}
		return this.comboBoxJour;
	}

	private JComboBox<Object> getComboBoxMois() {
		if (this.comboBoxMois == null) {
			final String[] mois = { "--Mois--", "01 - Janvier", "02 - Février", "03 - Mars", "04 - Avril", "05 - Mai",
					"06 - Juin", "07 - Juillet", "08 - Août", "09 - Septembre", "10 - Octobre", "11 - Novembre",
					"12 - Décembre" };
			this.comboBoxMois = new JComboBox<Object>(mois);
			this.comboBoxMois.setBackground(Color.WHITE);
			this.comboBoxMois.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						FideliteNouvelleFicheClient.this.moisdate = FideliteNouvelleFicheClient.this.comboBoxMois
								.getSelectedItem().toString();

						if (!"--Mois--".equals(moisdate)) {
							System.out.print("mois = " + FideliteNouvelleFicheClient.this.moisdate);
							FideliteNouvelleFicheClient.this.comboBoxAnnee.setEnabled(true);

							switch (FideliteNouvelleFicheClient.this.moisdate) {
							case "01 - Janvier":
								FideliteNouvelleFicheClient.this.moisdate = "01";
								break;
							case "02 - Février":
								FideliteNouvelleFicheClient.this.moisdate = "02";
								break;
							case "03 - Mars":
								FideliteNouvelleFicheClient.this.moisdate = "03";
								break;
							case "04 - Avril":
								FideliteNouvelleFicheClient.this.moisdate = "04";
								break;
							case "05 - Mai":
								FideliteNouvelleFicheClient.this.moisdate = "05";
								break;
							case "06 - Juin":
								FideliteNouvelleFicheClient.this.moisdate = "06";
								break;
							case "07 - Juillet":
								FideliteNouvelleFicheClient.this.moisdate = "07";
								break;
							case "08 - Août":
								FideliteNouvelleFicheClient.this.moisdate = "08";
								break;
							case "09 - Septembre":
								FideliteNouvelleFicheClient.this.moisdate = "09";
								break;
							case "10 - Octobre":
								FideliteNouvelleFicheClient.this.moisdate = "10";
								break;
							case "11 - Novembre":
								FideliteNouvelleFicheClient.this.moisdate = "11";
								break;
							case "12 - Décembre":
								FideliteNouvelleFicheClient.this.moisdate = "12";
								break;

							}
							System.out.println((moisdate.equals("--Mois--")) ? "\"\"" : " -> " + moisdate);
						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								FideliteNouvelleFicheClient.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBoxMois.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMois.setForeground(Color.GRAY);
			this.comboBoxMois.setBorder(null);
			this.comboBoxMois.setBounds(790, 428, 129, 22);

		}
		return this.comboBoxMois;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(
						FideliteNouvelleFicheClient.class.getResource("/Images/menus-grises-fidelite.png")));
				this.label_5.setEnabled(false);
				this.label_5.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				break;

			case "invite":
				this.label_5.setEnabled(false);
				this.label_5.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				this.fond.setIcon(new ImageIcon(
						FideliteNouvelleFicheClient.class.getResource("/Images/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(
						new ImageIcon(FideliteNouvelleFicheClient.class.getResource("/Images/menus_fidelite.png")));
				break;

			}
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private TextField getFormattedTextField() {
		if (this.formattedTextFieldNumCli == null) {

			this.formattedTextFieldNumCli = new TextField();
			this.formattedTextFieldNumCli.setForeground(Color.GRAY);
			this.formattedTextFieldNumCli.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.formattedTextFieldNumCli.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					FideliteNouvelleFicheClient.this.comboBoxMagasins.setEnabled(true);
				}
			});
			this.formattedTextFieldNumCli.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.formattedTextFieldNumCli.setBounds(310, 334, 188, 20);
		}
		return this.formattedTextFieldNumCli;
	}

	private JLabel getLabelTelephone() {
		if (this.labelTelephone == null) {
			this.labelTelephone = new JLabel("Tél. Mobile");
			this.labelTelephone.setForeground(Color.GRAY);
			this.labelTelephone.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.labelTelephone.setBounds(232, 463, 71, 14);
		}
		return this.labelTelephone;
	}

	private JLabel getLabelMobile() {
		if (this.labelMobile == null) {
			this.labelMobile = new JLabel("Tél. fixe");
			this.labelMobile.setForeground(Color.GRAY);
			this.labelMobile.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.labelMobile.setBounds(254, 496, 49, 14);
		}
		return this.labelMobile;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					FideliteNouvelleFicheClient.this.dispose();

				}
			});
			this.label_2.setBounds(226, 231, 129, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					FideliteNouvelleFicheClient.this.dispose();
				}
			});
			this.label_3.setBounds(478, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					FideliteNouvelleFicheClient.this.dispose();
				}
			});
			this.label_4.setBounds(595, 231, 114, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					FideliteNouvelleFicheClient.this.dispose();
				}
			});
			this.label_5.setBounds(709, 231, 114, 44);
		}
		return this.label_5;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLoading());
			this.layeredPane.add(this.getLblMenuGestion());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblNCarte());
			this.layeredPane.add(this.getLblMagasinDeRfrence());
			this.layeredPane.add(this.getLblNom());
			this.layeredPane.add(this.getLblPrnom());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getLblVille());
			this.layeredPane.add(this.getLblCodePostal());
			this.layeredPane.add(this.getLblEmail());
			this.layeredPane.add(this.getLblDateDeNaissance());
			this.layeredPane.add(this.getLblNewslettert());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getFormattedTextField());
			this.layeredPane.add(this.getComboBoxMagasins());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getTextField_2());
			this.layeredPane.add(this.getComboxBoxVilles());
			this.layeredPane.add(this.getTextField_4());
			this.layeredPane.add(this.getComboBoxMois());
			this.layeredPane.add(this.getComboBoxAnnee());
			this.layeredPane.add(this.getComboBoxJour());
			this.layeredPane.add(this.getTextField_5());
			this.layeredPane.add(this.getRdbtnOui());
			this.layeredPane.add(this.getRdbtnNon());
			this.layeredPane.add(this.getRdbtnDesinscrit());
			this.layeredPane.add(this.getLblChampObligatoire());
			this.layeredPane.add(this.getLblCivilit());
			this.layeredPane.add(this.getComboBoxCivilite());
			this.layeredPane.add(this.getLabelTelephone());
			this.layeredPane.add(this.getTextField_6());
			this.layeredPane.add(this.getLabelMobile());
			this.layeredPane.add(this.getTextField_7());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getTextField_8());
			this.layeredPane.add(this.getCheckVip());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private Loading getLoading() {
		if (this.lblLoading == null) {
			this.lblLoading = new Loading();
		}
		this.lblLoading.setVisible(false);
		return this.lblLoading;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse");
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setBounds(235, 401, 68, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblAge() {
		if (this.lblAge == null) {
			this.lblAge = new JLabel("Age");
			this.lblAge.setForeground(Color.GRAY);
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAge.setBounds(934, 463, 45, 14);
		}
		return this.lblAge;
	}

	private JLabel getLblChampObligatoire() {
		if (this.lblChampObligatoire == null) {
			this.lblChampObligatoire = new JLabel("* Champ obligatoire");
			this.lblChampObligatoire.setForeground(Color.GRAY);
			this.lblChampObligatoire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblChampObligatoire.setBounds(232, 530, 150, 14);
		}
		return this.lblChampObligatoire;
	}

	private JLabel getLblCivilit() {
		if (this.lblCivilit == null) {
			this.lblCivilit = new JLabel("Civilité *");
			this.lblCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCivilit.setForeground(Color.GRAY);
			this.lblCivilit.setBounds(243, 370, 60, 14);
		}
		return this.lblCivilit;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("Code Postal");
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCodePostal.setForeground(Color.GRAY);
			this.lblCodePostal.setBounds(406, 432, 92, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblDateDeNaissance() {
		if (this.lblDateDeNaissance == null) {
			this.lblDateDeNaissance = new JLabel("Date de Naissance *");
			this.lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateDeNaissance.setForeground(Color.GRAY);
			this.lblDateDeNaissance.setBounds(563, 432, 119, 14);
		}
		return this.lblDateDeNaissance;
	}

	private JLabel getLblEmail() {
		if (this.lblEmail == null) {
			this.lblEmail = new JLabel("Email");
			this.lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmail.setForeground(Color.GRAY);
			this.lblEmail.setBounds(449, 463, 49, 14);
		}
		return this.lblEmail;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					// final GestionCarteDeFidelite fenetre = new
					// GestionCarteDeFidelite();
					// fenetre.setVisible(true);
					FideliteNouvelleFicheClient.this.interfacePrecedente.setEnabled(true);
					FideliteNouvelleFicheClient.this.interfacePrecedente.setVisible(true);
					FideliteNouvelleFicheClient.this.dispose();
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(880, 231, 173, 48);
		}
		return this.lblFermer;
	}

	private JLabel getLblMagasinDeRfrence() {
		if (this.lblMagasinDeRfrence == null) {
			this.lblMagasinDeRfrence = new JLabel("Magasin de Référence *");
			this.lblMagasinDeRfrence.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMagasinDeRfrence.setForeground(Color.GRAY);
			this.lblMagasinDeRfrence.setBounds(509, 337, 149, 14);
		}
		return this.lblMagasinDeRfrence;
	}

	private JLabel getLblMenuGestion() {
		if (this.lblMenuGestion == null) {
			this.lblMenuGestion = new JLabel("Menu > Gestion Carte de Fidélité > Nouvelle Fiche Client");
			this.lblMenuGestion.setVisible(false);
			this.lblMenuGestion.setForeground(Color.GRAY);
			this.lblMenuGestion.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuGestion.setBounds(509, 286, 271, 14);
		}
		return this.lblMenuGestion;
	}

	private JLabel getLblNCarte() {
		if (this.lblNCarte == null) {
			this.lblNCarte = new JLabel("N° Client *");
			this.lblNCarte.setForeground(Color.GRAY);
			this.lblNCarte.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNCarte.setBounds(234, 337, 69, 14);
		}
		return this.lblNCarte;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Nouvelle carte de fidélité");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 169, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1
					.setIcon(new ImageIcon(FideliteNouvelleFicheClient.class.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewslettert() {
		if (this.lblNewslettert == null) {
			this.lblNewslettert = new JLabel("Abonnement Newsletter");
			this.lblNewslettert.setForeground(Color.GRAY);
			this.lblNewslettert.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewslettert.setBounds(449, 496, 159, 14);
		}
		return this.lblNewslettert;
	}

	private JLabel getLblNom() {
		if (this.lblNom == null) {
			this.lblNom = new JLabel("Nom *");
			this.lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNom.setForeground(Color.GRAY);
			this.lblNom.setBounds(413, 370, 49, 14);
		}
		return this.lblNom;
	}

	private JLabel getLblPrnom() {
		if (this.lblPrnom == null) {
			this.lblPrnom = new JLabel("Prénom *");
			this.lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrnom.setForeground(Color.GRAY);
			this.lblPrnom.setBounds(668, 370, 69, 14);
		}
		return this.lblPrnom;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider
					.setIcon(new ImageIcon(FideliteNouvelleFicheClient.class.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					validateAction();
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setBounds(933, 492, 99, 23);
		}
		return this.lblValider;
	}

	private JLabel getLblVille() {
		if (this.lblVille == null) {
			this.lblVille = new JLabel("Ville");
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblVille.setForeground(Color.GRAY);
			this.lblVille.setBounds(258, 432, 45, 14);
		}
		return this.lblVille;
	}

	private JRadioButton getRdbtnDesinscrit() {
		if (this.rdbtnDesinscrit == null) {
			this.rdbtnDesinscrit = new JRadioButton("Désinscrit");
			this.rdbtnDesinscrit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					if (FideliteNouvelleFicheClient.this.rdbtnDesinscrit.isSelected()) {
						FideliteNouvelleFicheClient.this.valeurCaseNewsletter = FideliteNouvelleFicheClient.this.rdbtnDesinscrit
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnDesinscrit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnDesinscrit.setForeground(Color.GRAY);
			this.rdbtnDesinscrit.setBounds(742, 492, 85, 23);
			this.group.add(this.rdbtnDesinscrit);
		}
		return this.rdbtnDesinscrit;
	}

	private JRadioButton getRdbtnNon() {
		if (this.rdbtnNon == null) {
			this.rdbtnNon = new JRadioButton("Non");
			this.rdbtnNon.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					if (FideliteNouvelleFicheClient.this.rdbtnNon.isSelected()) {
						FideliteNouvelleFicheClient.this.valeurCaseNewsletter = FideliteNouvelleFicheClient.this.rdbtnNon
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnNon.setForeground(Color.GRAY);
			this.rdbtnNon.setBounds(668, 492, 69, 23);
			this.group.add(this.rdbtnNon);
		}
		return this.rdbtnNon;
	}

	private JRadioButton getRdbtnOui() {
		if (this.rdbtnOui == null) {
			this.rdbtnOui = new JRadioButton("Oui");
			this.rdbtnOui.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					if (FideliteNouvelleFicheClient.this.rdbtnOui.isSelected()) {
						FideliteNouvelleFicheClient.this.valeurCaseNewsletter = FideliteNouvelleFicheClient.this.rdbtnOui
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnOui.setForeground(Color.GRAY);
			this.rdbtnOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnOui.setBounds(614, 492, 54, 23);
			this.rdbtnOui.setSelected(true);
			if (this.rdbtnOui.isSelected()) {
				this.valeurCaseNewsletter = this.rdbtnOui.getText().toString().toUpperCase();
			}
			this.group.add(this.rdbtnOui);

		}
		return this.rdbtnOui;
	}

	private TextField getTextField() {
		if (this.textField_Nom == null) {
			this.textField_Nom = new TextField();
			this.textField_Nom.setForeground(Color.GRAY);
			this.textField_Nom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Nom.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					FideliteNouvelleFicheClient.this.textField_Prenom.setEnabled(true);
				}
			});
			this.textField_Nom.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Nom.setBounds(462, 367, 188, 20);
			this.textField_Nom.setColumns(10);
		}
		return this.textField_Nom;
	}

	private TextField getTextField_1() {
		if (this.textField_Prenom == null) {
			this.textField_Prenom = new TextField();
			this.textField_Prenom.setForeground(Color.GRAY);
			this.textField_Prenom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Prenom.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					FideliteNouvelleFicheClient.this.textField_Adresse.setEnabled(true);
				}
			});
			this.textField_Prenom.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Prenom.setBounds(738, 367, 294, 20);
			this.textField_Prenom.setColumns(10);
		}
		return this.textField_Prenom;
	}

	private TextField getTextField_2() {
		if (this.textField_Adresse == null) {
			this.textField_Adresse = new TextField();
			this.textField_Adresse.setForeground(Color.GRAY);
			this.textField_Adresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Adresse.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					FideliteNouvelleFicheClient.this.comboBoxVilles.setEnabled(true);
				}
			});
			this.textField_Adresse.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Adresse.setBounds(310, 398, 722, 20);
			this.textField_Adresse.setColumns(10);
		}
		return this.textField_Adresse;
	}

	private JComboBox<Object> getComboxBoxVilles() {
		if (this.comboBoxVilles == null) {
			this.comboBoxVilles = new JComboBox<Object>();
			this.comboBoxVilles.setEditable(true);
			this.comboBoxVilles.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						FideliteNouvelleFicheClient.this.villeClient = FideliteNouvelleFicheClient.this.comboBoxVilles
								.getSelectedItem().toString().toUpperCase();
						FideliteNouvelleFicheClient.this.idville = ((Ville) FideliteNouvelleFicheClient.this.comboBoxVilles
								.getSelectedItem()).getIdville();
						final String CP = ((Ville) FideliteNouvelleFicheClient.this.comboBoxVilles.getSelectedItem())
								.getCodePostalVille();
						FideliteNouvelleFicheClient.this.textField_CodePostal.setText(CP);
						FideliteNouvelleFicheClient.this.textField_CodePostal.setEnabled(true);

					} catch (final Exception e5) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								FideliteNouvelleFicheClient.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);
					}

				}
			});
			this.comboBoxVilles.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxVilles.setForeground(Color.GRAY);
			this.comboBoxVilles.setBorder(null);
			this.comboBoxVilles.setBounds(310, 428, 86, 22);
			this.listeVille = new DefaultComboBoxModel<Object>(Select.listeVille());
			this.comboBoxVilles.setModel(this.listeVille);
			AutoCompletion.enable(this.comboBoxVilles);

		}
		return this.comboBoxVilles;
	}

	private JFormattedTextField getTextField_4() {
		if (this.textField_CodePostal == null) {
			try {
				this.mask = new MaskFormatter("#####");
			} catch (final ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.mask.setValidCharacters("0123456789");
			this.textField_CodePostal = new JFormattedTextField(this.mask);
			this.textField_CodePostal.setFocusable(false);
			this.textField_CodePostal.setForeground(Color.GRAY);
			this.textField_CodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_CodePostal.setEnabled(false);
			this.textField_CodePostal.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_CodePostal.setBounds(489, 429, 64, 20);
			this.textField_CodePostal.setColumns(10);
		}
		return this.textField_CodePostal;
	}

	private TextField getTextField_5() {
		if (this.textField_Mail == null) {
			this.textField_Mail = new TextField();
			this.textField_Mail.setForeground(Color.GRAY);
			this.textField_Mail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Mail.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Mail.setBounds(489, 460, 338, 20);
			this.textField_Mail.setColumns(10);
		}
		return this.textField_Mail;
	}

	private TextField getTextField_6() {
		if (this.textField_TelFix == null) {
			this.textField_TelFix = new TextField();
			this.textField_TelFix.setForeground(Color.GRAY);
			this.textField_TelFix.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_TelFix.setColumns(10);
			this.textField_TelFix.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_TelFix.setBounds(310, 493, 124, 20);
		}
		return this.textField_TelFix;
	}

	private TextField getTextField_7() {
		if (this.textField_TelMob == null) {
			this.textField_TelMob = new TextField();
			this.textField_TelMob.setForeground(Color.GRAY);
			this.textField_TelMob.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_TelMob.setColumns(10);
			this.textField_TelMob.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_TelMob.setBounds(310, 460, 124, 20);
		}
		return this.textField_TelMob;
	}

	private TextField getTextField_8() {
		if (this.textField_Age == null) {
			this.textField_Age = new TextField();
			this.textField_Age.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Age.setFocusable(false);
			this.textField_Age.setForeground(Color.GRAY);
			this.textField_Age.setFont(new Font("Tahoma", Font.BOLD, 11));

			this.textField_Age.setBounds(975, 460, 57, 20);
			this.textField_Age.setColumns(10);
		}
		return this.textField_Age;
	}

	/**
	 * this methode will validate filled datas by calling severals methods for each fields<br>
	 * on error a warning message will be displayed to help the correction
	 */
	private void validateAction() {
		this.lblLoading.setVisible(true);

		Thread longThread = new Thread(new Runnable() {
			@Override
			public void run() {

				boolean verification = true;

				// Vérification de l'existence du numéro de client ++
				verification = (FideliteNouvelleFicheClient.this.numCliIsNew() == false) ? false : verification;
				// Vérification de l'existence du numéro de client --

				// Vérification de la saisie du numéro de client ++
				verification = (FideliteNouvelleFicheClient.this.numCliIsSet() == false) ? false : verification;
				// Vérification de la saisie du numéro de client --

				// Vérification de la saisie du magasin ++
				verification = (FideliteNouvelleFicheClient.this.magasinIsSet() == false) ? false : verification;
				// Vérification de la saisie du magasin --

				// Vérification de la saisie du magasin ++
				verification = (FideliteNouvelleFicheClient.this.civiliteIsSet() == false) ? false : verification;
				// Vérification de la saisie du magasin --

				// Vérification de la saisie du NOM ++
				verification = (FideliteNouvelleFicheClient.this.nomIsSet() == false) ? false : verification;
				// Vérification de la saisie du NOM --

				// Vérification de la saisie du PRENOM ++
				verification = (FideliteNouvelleFicheClient.this.prenomIsSet() == false) ? false : verification;
				// Vérification de la saisie du PRENOM --

				// Vérification de la saisie du mail ++
				verification = (FideliteNouvelleFicheClient.this.mailIsValid() == false) ? false : verification;
				// Vérification de la saisie du mail --

				// Vérification de la saisie du telephone fix ++
				verification = (FideliteNouvelleFicheClient.this.telFixIsValid() == false) ? false : verification;
				// Vérification de la saisie du telephone fix --

				// Vérification de la saisie du telephone gsm ++
				verification = (FideliteNouvelleFicheClient.this.telGSMIsValid() == false) ? false : verification;
				// Vérification de la saisie du telephone gsm --

				// Vérification de l'age du client ++
				verification = (FideliteNouvelleFicheClient.this.ageIsValid() == false) ? false : verification;
				// Vérification de l'age du client --

				// Vérification de l'adresse du client ++
				verification = (FideliteNouvelleFicheClient.this.adressIsValid() == false) ? false : verification;
				// Vérification de l'adresse du client --

				// Vérification du code postal du client ++
				verification = (FideliteNouvelleFicheClient.this.cpIsValid() == false) ? false : verification;
				// Vérification du code postal du client --

				// Traitement spécifiques à la creation apres participation
				// operation commerciale ++
				if (!FideliteNouvelleFicheClient.this.choixmenuprecedent.equals("creationcarteparoperation")) {

					// récuperation de la date à partir des combobox ++
					if (FideliteNouvelleFicheClient.this.jourdate != null
							&& FideliteNouvelleFicheClient.this.moisdate != null
							&& FideliteNouvelleFicheClient.this.annee != null) {
						FideliteNouvelleFicheClient.this.dateComplete = FideliteNouvelleFicheClient.this.jourdate + "/"
								+ FideliteNouvelleFicheClient.this.moisdate + "/"
								+ FideliteNouvelleFicheClient.this.annee;
						System.out.println("date : " + FideliteNouvelleFicheClient.this.dateComplete);
					}
					// récuperation de la date à partir des combobox --
				}
				// Traitement spécifiques à la creation apres participation
				// operation commerciale --
				FideliteNouvelleFicheClient.this.newsletter = FideliteNouvelleFicheClient.this.valeurCaseNewsletter;

				System.out.println("vérif saisie :::::::::" + verification + ":::::::::");
				if (verification == true) {
					try {
						c = Connexion.getCon();
						c.setAutoCommit(false);

						final String sql = "SELECT COUNT(IDCLIENT) FROM CLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND AGECLIENT=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE)";
						preStm = c.prepareStatement(sql);
						preStm.setString(1, FideliteNouvelleFicheClient.this.nomClient);
						preStm.setString(2, FideliteNouvelleFicheClient.this.prenomClient);
						preStm.setString(3, FideliteNouvelleFicheClient.this.age);
						rs = preStm.executeQuery();

						while (rs.next()) {
							FideliteNouvelleFicheClient.this.compteur2 = rs.getInt(1);
						}

						preStm.close();
						rs.close();
						System.out.println("checkNumCliEXIST :::::::::" + FideliteNouvelleFicheClient.this.compteur2
								+ ":::::::::");

					} catch (final SQLException e10) {
						e10.getMessage();
					}

					if (FideliteNouvelleFicheClient.this.compteur2 == 0) {
						final Vector<infostemporaire> requete = new Vector<infostemporaire>();
						final ConfirmationInsertionClientFidelite fenetre = new ConfirmationInsertionClientFidelite(
								FideliteNouvelleFicheClient.this.interfaceActuelle,
								FideliteNouvelleFicheClient.this.numerocarte, FideliteNouvelleFicheClient.this.magasin,
								FideliteNouvelleFicheClient.this.idmagasin, FideliteNouvelleFicheClient.this.civilite,
								FideliteNouvelleFicheClient.this.nomClient,
								FideliteNouvelleFicheClient.this.prenomClient,
								FideliteNouvelleFicheClient.this.adresseClient,
								FideliteNouvelleFicheClient.this.idville, FideliteNouvelleFicheClient.this.villeClient,
								FideliteNouvelleFicheClient.this.CodePostalClient,
								FideliteNouvelleFicheClient.this.dateComplete, FideliteNouvelleFicheClient.this.email,
								FideliteNouvelleFicheClient.this.newsletter,
								FideliteNouvelleFicheClient.this.telephonefixe,
								FideliteNouvelleFicheClient.this.telephoneportable,
								FideliteNouvelleFicheClient.this.age, FideliteNouvelleFicheClient.this.vip,
								FideliteNouvelleFicheClient.this.idoperationcommercialeparticipation,
								FideliteNouvelleFicheClient.this.idmagasinparticipation,
								FideliteNouvelleFicheClient.this.choixmenuprecedent,
								FideliteNouvelleFicheClient.this.compteur2, requete);
						fenetre.setVisible(true);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);
						FideliteNouvelleFicheClient.this.interfaceActuelle.setVisible(false);

					} else {

						final deplacementdatas fenetre1 = new deplacementdatas(
								FideliteNouvelleFicheClient.this.interfaceActuelle,
								FideliteNouvelleFicheClient.this.numerocarte, FideliteNouvelleFicheClient.this.magasin,
								FideliteNouvelleFicheClient.this.idmagasin, FideliteNouvelleFicheClient.this.civilite,
								FideliteNouvelleFicheClient.this.nomClient,
								FideliteNouvelleFicheClient.this.prenomClient,
								FideliteNouvelleFicheClient.this.adresseClient,
								FideliteNouvelleFicheClient.this.idville, FideliteNouvelleFicheClient.this.villeClient,
								FideliteNouvelleFicheClient.this.CodePostalClient,
								FideliteNouvelleFicheClient.this.dateComplete, FideliteNouvelleFicheClient.this.email,
								FideliteNouvelleFicheClient.this.newsletter,
								FideliteNouvelleFicheClient.this.telephonefixe,
								FideliteNouvelleFicheClient.this.telephoneportable,
								FideliteNouvelleFicheClient.this.age, FideliteNouvelleFicheClient.this.vip,
								FideliteNouvelleFicheClient.this.idoperationcommercialeparticipation,
								FideliteNouvelleFicheClient.this.idmagasinparticipation,
								FideliteNouvelleFicheClient.this.choixmenuprecedent,
								FideliteNouvelleFicheClient.this.compteur2);
						fenetre1.setVisible(true);
						FideliteNouvelleFicheClient.this.dispose();

					}

				} else {
					System.out.println("impossible");

					final AlerteSelection fenetre = new AlerteSelection(
							FideliteNouvelleFicheClient.this.interfaceActuelle,
							FideliteNouvelleFicheClient.this.message);
					fenetre.setVisible(true);
					FideliteNouvelleFicheClient.this.interfaceActuelle.setEnabled(false);
				}

				FideliteNouvelleFicheClient.this.lblLoading.setVisible(false);
			}

		});
		longThread.start();
	}

	/**
	 * check the PostCode validity
	 *
	 * @return <strong>true</strong> if postcode is valid <br>
	 *         <Strong>false</strong> if postcode is not valid
	 */
	protected boolean cpIsValid() {
		Boolean verification = true;
		FideliteNouvelleFicheClient.this.CodePostalClient = FideliteNouvelleFicheClient.this.textField_CodePostal
				.getText();

		if (!FideliteNouvelleFicheClient.this.CodePostalClient.isEmpty()) {
			if (FideliteNouvelleFicheClient.this.CodePostalClient.length() != 5) {
				verification = false;
				FideliteNouvelleFicheClient.this.message = "Merci de vérifier le code postal renseigné - Ce champ doit comporter 5 chiffres";
			}
		}
		return verification;
	}

	/**
	 * check the adrress validity
	 *
	 * @return <strong>true</strong> if adress is valid <br>
	 *         <Strong>false</strong> if adress is not valid
	 */
	protected boolean adressIsValid() {
		Boolean verification = true;
		// Vérification de l'adresse du client ++
		FideliteNouvelleFicheClient.this.adresseClient = FideliteNouvelleFicheClient.this.textField_Adresse.getText()
				.toUpperCase();
		try {
			if (FideliteNouvelleFicheClient.this.comboBoxVilles.getSelectedIndex() > 0) {
				FideliteNouvelleFicheClient.this.villeClient = FideliteNouvelleFicheClient.this.comboBoxVilles
						.getSelectedItem().toString().toUpperCase();
				FideliteNouvelleFicheClient.this.idville = ((Ville) FideliteNouvelleFicheClient.this.comboBoxVilles
						.getSelectedItem()).getIdville();
			}
		} catch (final Exception e5) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Merci de selectionner une Ville";
		}
		// Vérification de l'addresse --
		return verification;
	}

	/**
	 * check the age validity
	 *
	 * @return <strong>true</strong> if age is valid <br>
	 *         <Strong>false</strong> if age is not valid
	 */
	protected boolean ageIsValid() {
		Boolean verification = true;
		// Vérification de l'age du client ++
		FideliteNouvelleFicheClient.this.age = FideliteNouvelleFicheClient.this.textField_Age.getText().toUpperCase()
				.toString();
		if (!FideliteNouvelleFicheClient.this.age.isEmpty()) {
			if (Integer.parseInt(FideliteNouvelleFicheClient.this.age) < 18) {
				verification = false;
				FideliteNouvelleFicheClient.this.message = "Merci de vérifier l'àge du client : 18 ans minimum";
			}
		}
		// Vérification de l'age du client --
		return verification;
	}

	/**
	 * check the GSM phone validity
	 *
	 * @return <strong>true</strong> if phone number is valid <br>
	 *         <Strong>false</strong> if phone number is not valid
	 */
	protected boolean telGSMIsValid() {
		Boolean verification = true;
		// Vérification de la saisie du telephone gsm ++
		FideliteNouvelleFicheClient.this.telephoneportable = null;
		if (!FideliteNouvelleFicheClient.this.textField_TelMob.getText().isEmpty()) {
			FideliteNouvelleFicheClient.this.telephoneportable = FideliteNouvelleFicheClient.this.textField_TelMob
					.getText();

			if (FideliteNouvelleFicheClient.this.telephoneportable.length() != 10) {
				verification = false;
				FideliteNouvelleFicheClient.this.message = "le numero de téléphone doit contenir 10 chiffres";
			}
		}
		// Vérification de la saisie du telephone gsm --
		return verification;
	}

	/**
	 * check the home phone validity
	 *
	 * @return <strong>true</strong> if phone number is valid <br>
	 *         <Strong>false</strong> if phone number is not valid
	 */
	protected boolean telFixIsValid() {
		Boolean verification = true;
		// Vérification de la saisie du telephone fix ++
		FideliteNouvelleFicheClient.this.telephonefixe = null;
		if (!FideliteNouvelleFicheClient.this.textField_TelFix.getText().isEmpty()) {
			FideliteNouvelleFicheClient.this.telephonefixe = FideliteNouvelleFicheClient.this.textField_TelFix
					.getText();
			if (FideliteNouvelleFicheClient.this.telephonefixe.length() != 10) {
				verification = false;
				FideliteNouvelleFicheClient.this.message = "le numero de téléphone doit contenir 10 chiffres";
			}
		}
		// Vérification de la saisie du telephone fix --
		return verification;
	}

	/**
	 * check if mail is valid
	 *
	 * @return <strong>true</strong> if mail is valid <br>
	 *         <Strong>false</strong> if mail is not valid
	 */
	protected boolean mailIsValid() {
		Boolean verification = true;
		// Vérification de la saisie du mail ++
		FideliteNouvelleFicheClient.this.email = null;

		if (!FideliteNouvelleFicheClient.this.textField_Mail.getText().isEmpty()) {
			FideliteNouvelleFicheClient.this.email = FideliteNouvelleFicheClient.this.textField_Mail.getText();

			if (!EmailValidator.getInstance().isValid(FideliteNouvelleFicheClient.this.email)) {
				verification = false;
				FideliteNouvelleFicheClient.this.message = "Merci de vérifier l'adresse mail saisie";

			}
		}
		// Vérification de la saisie du mail --
		return verification;
	}

	/**
	 * check if a lastname is filled
	 *
	 * @return <strong>true</strong> if lastname have been filled <br>
	 *         <Strong>false</strong> if lastname havent been filled
	 */
	protected boolean prenomIsSet() {
		Boolean verification = true;
		// Vérification de la saisie du PRENOM ++
		FideliteNouvelleFicheClient.this.prenomClient = FideliteNouvelleFicheClient.this.textField_Prenom.getText()
				.toUpperCase();

		if (FideliteNouvelleFicheClient.this.prenomClient.isEmpty()) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Merci de vérifier le prénom du client - Ce champ ne peut être vide";
		}
		// Vérification de la saisie du PRENOM --
		return verification;
	}

	/**
	 * check if a firstname is filled
	 *
	 * @return <strong>true</strong> if firstname have been filled <br>
	 *         <Strong>false</strong> if firstname havent been filled
	 */
	protected boolean nomIsSet() {
		// Vérification de la saisie du NOM ++
		Boolean verification = true;
		FideliteNouvelleFicheClient.this.nomClient = FideliteNouvelleFicheClient.this.textField_Nom.getText()
				.toUpperCase();

		if (FideliteNouvelleFicheClient.this.nomClient.isEmpty()) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Merci de vérifier le nom du client - Ce champ ne peut être vide";
		}
		// Vérification de la saisie du NOM --
		return verification;
	}

	/**
	 * check if a civilite is filled
	 *
	 * @return <strong>true</strong> if civilite have been filled <br>
	 *         <Strong>false</strong> if civilite havent been filled
	 */
	protected boolean civiliteIsSet() {
		// Vérification de la saisie du magasin ++
		Boolean verification = true;
		try {
			FideliteNouvelleFicheClient.this.civilite = FideliteNouvelleFicheClient.this.comboBoxCivilite
					.getSelectedItem().toString().toUpperCase();
			if (civilite.isEmpty()) {
				verification = false;
				FideliteNouvelleFicheClient.this.message = "Merci de selectionner une civilité";
			}
		} catch (final Exception e5) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Merci de selectionner une civilité";
		}
		// Vérification de la saisie du magasin --
		return verification;
	}

	/**
	 * check if a mall have been selected
	 *
	 * @return <strong>true</strong> if mall have been sellected <br>
	 *         <Strong>false</strong> if mall havent been selected
	 */
	protected boolean magasinIsSet() {
		// Vérification de la saisie du magasin ++
		Boolean verification = true;
		try {
			FideliteNouvelleFicheClient.this.magasin = FideliteNouvelleFicheClient.this.comboBoxMagasins
					.getSelectedItem().toString().toUpperCase();
			FideliteNouvelleFicheClient.this.idmagasin = ((Magasin) FideliteNouvelleFicheClient.this.comboBoxMagasins
					.getSelectedItem()).getIdMagasin();
		} catch (final Exception e5) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Merci de selectionner un magasin";
		}
		// Vérification de la saisie du magasin --
		return verification;
	}

	/**
	 * check if this is a new customer number
	 *
	 * @return <strong>true</strong> if card number is new<br>
	 *         <Strong>false</strong> if card number is already registered
	 */
	protected boolean numCliIsNew() {
		// Vérification de l'existence du numéro de client ++
		FideliteNouvelleFicheClient.this.numerocarte = FideliteNouvelleFicheClient.this.formattedTextFieldNumCli
				.getText();

		Boolean verification = true;
		int Compteur = 0;
		try {

			c = Connexion.getCon();

			final String SQL = "SELECT COUNT(NUMEROCARTEDEFIDELITE) FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";
			preStm = c.prepareStatement(SQL);
			preStm.setString(1, FideliteNouvelleFicheClient.this.numerocarte);
			rs = preStm.executeQuery();
		} catch (final Exception e8) {
			System.out.println("erreur " + e8.getMessage());
		}

		try {
			while (rs.next()) {
				Compteur = (rs.getInt(1));
			}
			rs.close();
			preStm.close();
		} catch (final Exception e5) {
			System.out.println("erreur " + e5.getMessage());
		}

		if (Compteur != 0) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Ce numéro de carte est deja utilisé";
		}
		// Vérification de l'existence du numéro de client --
		return verification;
	}

	/**
	 * check if numCli is filled
	 *
	 * @return <strong>true</strong> if numCli is filled <br>
	 *         <Strong>false</strong> if numCli is not filled
	 */
	protected Boolean numCliIsSet() {
		// Vérification de la saisie du numéro de carte ++
		Boolean verification = true;
		if (FideliteNouvelleFicheClient.this.numerocarte.isEmpty()) {
			verification = false;
			FideliteNouvelleFicheClient.this.message = "Merci de vérifier votre numéro de client - Ce champ ne peut être vide";

		}
		// Vérification de la saisie du numéro de carte --
		return verification;

	}
}
