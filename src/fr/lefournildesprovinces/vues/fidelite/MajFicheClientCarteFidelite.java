package fr.lefournildesprovinces.vues.fidelite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Clientcartedefidelite;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.Loading;

public class MajFicheClientCarteFidelite extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4892689214654247739L;

	private Loading lblLoading;
	ButtonGroup group = new ButtonGroup();
	private ComboBoxModel<Object> listeVille;
	private ComboBoxModel<Object> listemagasins;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBoxAnnee;
	private JComboBox<Object> comboBoxJour;
	private JComboBox<Object> comboBoxMois;
	private JComboBox<Object> comboBox_1;
	private JComboBox<Object> textField_3;
	private JFormattedTextField textField_CodePostal;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblAdresse;
	private JLabel lblAnne;
	private JLabel lblChampObligatoire;
	private JLabel lblCivilit;
	private JLabel lblCodePostal;
	private JLabel lblDateDeNaissance;
	private JLabel lblEmail;
	private JLabel lblFermer;
	private JLabel lblJour;
	private JLabel lblMagasinDeRfrence;
	private JLabel lblMenuGestion;
	private JLabel lblMois;
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
	private JTextField textField_NumCli;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_Adresse;
	private JTextField textField_Mail;
	private JTextField textField_TelFix;
	private JTextField textField_TelGSM;
	private JTextField textField_Age;
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
	private String valeurCaseNewsletter;
	private String villeClient;
	private final JFrame interfaceActuelle;
	private final JPanel contentPane;
	private final String numcarteherite;
	private final String operationprecedente;
	private final int magasinoperation;
	private final int numeroidcommerciale;
	private int identifiantclient;
	private int idmagasin;
	private int idville;

	public MajFicheClientCarteFidelite(final String numerocarteclient, final String provenance,
			final int IdOperationCommerciale, final int magasin) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				final Vector<Clientcartedefidelite> listeinfoscartefidelite = Select
						.infosclientcartefidelite(MajFicheClientCarteFidelite.this.numcarteherite);
				for (int i = 0; i < listeinfoscartefidelite.size(); i++) {
					MajFicheClientCarteFidelite.this.identifiantclient = listeinfoscartefidelite.get(i).getIdclient();
					MajFicheClientCarteFidelite.this.textField_Nom
							.setText(listeinfoscartefidelite.get(i).getNomIndividu());
					MajFicheClientCarteFidelite.this.textField_Prenom
							.setText(listeinfoscartefidelite.get(i).getPrenomIndividu());
					MajFicheClientCarteFidelite.this.textField_Adresse
							.setText(listeinfoscartefidelite.get(i).getAdresseIndividu());
					MajFicheClientCarteFidelite.this.textField_CodePostal
							.setText(listeinfoscartefidelite.get(i).getCodePostalIndividu());
					MajFicheClientCarteFidelite.this.textField_Mail.setText(listeinfoscartefidelite.get(i).getEmail());
					MajFicheClientCarteFidelite.this.textField_NumCli
							.setText(listeinfoscartefidelite.get(i).getNumerocarte());
					MajFicheClientCarteFidelite.this.textField_Age.setText(listeinfoscartefidelite.get(i).getAge());
					MajFicheClientCarteFidelite.this.textField_TelFix
							.setText(listeinfoscartefidelite.get(i).getTelfixe());
					MajFicheClientCarteFidelite.this.textField_TelGSM
							.setText(listeinfoscartefidelite.get(i).getMobile());

					final String boutonselectionne = listeinfoscartefidelite.get(i).getNewsletterIndividu().toString();
					switch (boutonselectionne) {
					case "OUI":
						MajFicheClientCarteFidelite.this.rdbtnOui.setSelected(true);
						break;
					case "NON":
						MajFicheClientCarteFidelite.this.rdbtnNon.setSelected(true);
						break;
					case "DéSINSCRIT":
						MajFicheClientCarteFidelite.this.rdbtnDesinscrit.setSelected(true);
						break;
					}
					for (int j = 1; j < MajFicheClientCarteFidelite.this.comboBox_1.getModel().getSize(); j++) {

						final String s1 = MajFicheClientCarteFidelite.this.comboBox_1.getItemAt(j).toString()
								.toUpperCase();
						final String civiliteclient = listeinfoscartefidelite.get(i).getCiviliteIndividu();

						if (s1.equals(civiliteclient)) {
							MajFicheClientCarteFidelite.this.comboBox_1.setSelectedIndex(j);
							break;
						}
					}

					for (int j = 1; j < MajFicheClientCarteFidelite.this.textField_3.getModel().getSize(); j++) {

						final String s1 = MajFicheClientCarteFidelite.this.textField_3.getItemAt(j).toString()
								.toUpperCase();

						final String ville = listeinfoscartefidelite.get(i).getVilleIndividu();

						if (s1.equals(ville)) {
							MajFicheClientCarteFidelite.this.textField_3.setSelectedIndex(j);
							break;
						}
					}

					if (listeinfoscartefidelite.get(i).getDateNaissanceIndividu() != null) {
						final String dateclient = listeinfoscartefidelite.get(i).getDateNaissanceIndividu();
						System.out.print("\n#######" + dateclient);
						final String eclatementDate[] = dateclient.split("-");
						final String year = eclatementDate[0];
						String month = eclatementDate[1];
						final String day = eclatementDate[2];

						switch (month) {
						case "01":
							month = "Janvier";
							break;
						case "02":
							month = "Février";
							break;
						case "03":
							month = "Mars";
							break;
						case "04":
							month = "Avril";
							break;
						case "05":
							month = "Mai";
							break;
						case "06":
							month = "Juin";
							break;
						case "07":
							month = "Juillet";
							break;
						case "08":
							month = "Août";
							break;
						case "09":
							month = "Septembre";
							break;
						case "10":
							month = "Octobre";
							break;
						case "11":
							month = "Novembre";
							break;
						case "12":
							month = "Décembre";
							break;
						}

						System.out.print(month);
						System.out.print(year);

						for (int j = 1; j < MajFicheClientCarteFidelite.this.comboBoxAnnee.getModel().getSize(); j++) {

							final String s1 = MajFicheClientCarteFidelite.this.comboBoxAnnee.getItemAt(j).toString();

							if (s1.equals(year)) {
								MajFicheClientCarteFidelite.this.comboBoxAnnee.setSelectedIndex(j);
								break;
							}
						}

						for (int j = 1; j < MajFicheClientCarteFidelite.this.comboBoxMois.getModel().getSize(); j++) {

							final String s1 = MajFicheClientCarteFidelite.this.comboBoxMois.getItemAt(j).toString()
									.substring(1);

							if (s1.equals(month)) {
								MajFicheClientCarteFidelite.this.comboBoxMois.setSelectedIndex(j);
								break;
							}
						}

						for (int j = 1; j < MajFicheClientCarteFidelite.this.comboBoxJour.getModel().getSize(); j++) {

							final String s1 = MajFicheClientCarteFidelite.this.comboBoxJour.getItemAt(j).toString()
									.substring(1);

							if (s1.equals(day)) {
								MajFicheClientCarteFidelite.this.comboBoxJour.setSelectedIndex(j);
								break;
							}
						}

					}
					for (int j = 1; j < MajFicheClientCarteFidelite.this.comboBox.getModel().getSize(); j++) {

						final String s1 = MajFicheClientCarteFidelite.this.comboBox.getItemAt(j).toString()
								.toUpperCase();
						final String magasin = listeinfoscartefidelite.get(i).getNommagasin().toUpperCase();

						if (s1.equals(magasin)) {
							MajFicheClientCarteFidelite.this.comboBox.setSelectedIndex(j);
							break;
						}
					}

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

		this.interfaceActuelle = this;
		this.numcarteherite = numerocarteclient;
		this.operationprecedente = provenance;
		this.numeroidcommerciale = IdOperationCommerciale;
		this.magasinoperation = magasin;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						MajFicheClientCarteFidelite.this.magasin = MajFicheClientCarteFidelite.this.comboBox
								.getSelectedItem().toString();

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setBorder(null);
			this.comboBox.setBounds(668, 334, 364, 22);
			this.listemagasins = new DefaultComboBoxModel<Object>(Select.listemagasins());
			this.comboBox.setModel(this.listemagasins);

		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			final String[] civiliteclient = { null, "Mr", "Mme", "NR" };
			this.comboBox_1 = new JComboBox<Object>(civiliteclient);
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						MajFicheClientCarteFidelite.this.civilite = MajFicheClientCarteFidelite.this.comboBox_1
								.getSelectedItem().toString();

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.setBounds(310, 366, 86, 22);
		}
		return this.comboBox_1;
	}

	private JComboBox<Object> getComboBoxAnnee() {
		if (this.comboBoxAnnee == null) {
			this.comboBoxAnnee = new JComboBox<Object>();
			this.comboBoxAnnee.setBackground(Color.WHITE);
			this.comboBoxAnnee.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					MajFicheClientCarteFidelite.this.lblAnne.setVisible(false);

					try {

						MajFicheClientCarteFidelite.this.annee = MajFicheClientCarteFidelite.this.comboBoxAnnee
								.getSelectedItem().toString();
						final Calendar calendrier = Calendar.getInstance();
						final int anneecourante = calendrier.get(Calendar.YEAR);
						final int age = anneecourante - Integer.parseInt(MajFicheClientCarteFidelite.this.annee);
						MajFicheClientCarteFidelite.this.textField_Age.setText(Integer.toString(age));

					} catch (final Exception e2) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBoxAnnee.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxAnnee.setForeground(Color.GRAY);
			this.comboBoxAnnee.setBorder(null);
			this.comboBoxAnnee.setBounds(933, 428, 99, 22);

			this.comboBoxAnnee.addItem(null);

			final int year = Calendar.getInstance().get(Calendar.YEAR);
			for (int anneemenu = year - 18; anneemenu >= 1900; anneemenu--) {
				this.comboBoxAnnee.addItem(anneemenu);

			}

		}
		return this.comboBoxAnnee;
	}

	private JComboBox<Object> getComboBoxJour() {
		if (this.comboBoxJour == null) {
			final String[] jour = { null, " 01", " 02", " 03", " 04", " 05", " 06", " 07", " 08", " 09", " 10", " 11",
					" 12", " 13", " 14", " 15", " 16", " 17", " 18", " 19", " 20", " 21", " 22", " 23", " 24", " 25",
					" 26", " 27", " 28", " 29", " 30", " 31" };
			this.comboBoxJour = new JComboBox<Object>(jour);
			this.comboBoxJour.setBackground(Color.WHITE);
			this.comboBoxJour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					MajFicheClientCarteFidelite.this.lblJour.setVisible(false);
					try {
						MajFicheClientCarteFidelite.this.jourdate = MajFicheClientCarteFidelite.this.comboBoxJour
								.getSelectedItem().toString().substring(1);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);
					}
				}
			});
			this.comboBoxJour.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxJour.setForeground(Color.GRAY);
			this.comboBoxJour.setBorder(null);
			this.comboBoxJour.setBounds(684, 428, 91, 22);

		}
		return this.comboBoxJour;
	}

	private JComboBox<Object> getComboBoxMois() {
		if (this.comboBoxMois == null) {
			final String[] mois = { null, " Janvier", " Février", " Mars", " Avril", " Mai", " Juin", " Juillet",
					" Août", " Septembre", " Octobre", " Novembre", " Décembre" };
			this.comboBoxMois = new JComboBox<Object>(mois);
			this.comboBoxMois.setBackground(Color.WHITE);
			this.comboBoxMois.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					MajFicheClientCarteFidelite.this.lblMois.setVisible(false);
					try {
						MajFicheClientCarteFidelite.this.moisdate = MajFicheClientCarteFidelite.this.comboBoxMois
								.getSelectedItem().toString().substring(1);
						System.out.print("mois=" + MajFicheClientCarteFidelite.this.moisdate + "\n");
						int Compteur = 0;
						for (int i = 0; i < MajFicheClientCarteFidelite.this.moisdate.length(); i++) {

							if (Character.isDigit(MajFicheClientCarteFidelite.this.moisdate.charAt(i))) {
								Compteur++;
							}
						}
						if (Compteur != 0) {

							final String message = "Choix Impossible - Merci de vérifier votre sélection";
							final AlerteSelection fenetre = new AlerteSelection(
									MajFicheClientCarteFidelite.this.interfaceActuelle, message);
							fenetre.setVisible(true);
							MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);
						}

						switch (MajFicheClientCarteFidelite.this.moisdate) {
						case "Janvier":
							MajFicheClientCarteFidelite.this.moisdate = "01";
							break;
						case "Février":
							MajFicheClientCarteFidelite.this.moisdate = "02";
							break;
						case "Mars":
							MajFicheClientCarteFidelite.this.moisdate = "03";
							break;
						case "Avril":
							MajFicheClientCarteFidelite.this.moisdate = "04";
							break;
						case "Mai":
							MajFicheClientCarteFidelite.this.moisdate = "05";
							break;
						case "Juin":
							MajFicheClientCarteFidelite.this.moisdate = "06";
							break;
						case "Juillet":
							MajFicheClientCarteFidelite.this.moisdate = "07";
							break;
						case "Août":
							MajFicheClientCarteFidelite.this.moisdate = "08";
							break;
						case "Septembre":
							MajFicheClientCarteFidelite.this.moisdate = "09";
							break;
						case "Octobre":
							MajFicheClientCarteFidelite.this.moisdate = "10";
							break;
						case "Novembre":
							MajFicheClientCarteFidelite.this.moisdate = "11";
							break;
						case "Décembre":
							MajFicheClientCarteFidelite.this.moisdate = "12";
							break;

						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.comboBoxMois.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMois.setForeground(Color.GRAY);
			this.comboBoxMois.setBorder(null);
			this.comboBoxMois.setBounds(785, 428, 140, 22);

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
						MajFicheClientCarteFidelite.class.getResource("/Images/menus-grises-fidelite.png")));
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
						MajFicheClientCarteFidelite.class.getResource("/Images/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(
						new ImageIcon(MajFicheClientCarteFidelite.class.getResource("/Images/menus_fidelite.png")));
				break;

			}
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JTextField getFormattedTextField() {
		if (this.textField_NumCli == null) {

			this.textField_NumCli = new JTextField();
			this.textField_NumCli.setForeground(Color.GRAY);
			this.textField_NumCli.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_NumCli.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_NumCli.setBounds(312, 334, 188, 20);
		}
		return this.textField_NumCli;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("T\u00E9l\u00E9phone");
			this.label.setForeground(Color.GRAY);
			this.label.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label.setBounds(232, 463, 80, 14);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("Mobile");
			this.label_1.setForeground(Color.GRAY);
			this.label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_1.setBounds(254, 496, 58, 14);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite fenetre = new GestionCartesDeFidelite();
					fenetre.setVisible(true);
					MajFicheClientCarteFidelite.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(238, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					MajFicheClientCarteFidelite.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(475, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					MajFicheClientCarteFidelite.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(592, 231, 114, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					MajFicheClientCarteFidelite.this.dispose();
				}
			});
			this.label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_5.setBounds(706, 231, 114, 44);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("Age *");
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setBounds(933, 463, 45, 14);
		}
		return this.label_6;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
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
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getTextField_2());
			this.layeredPane.add(this.getTextField_3());
			this.layeredPane.add(this.getTextField_4());
			this.layeredPane.add(this.getLblJour());
			this.layeredPane.add(this.getLblMois());
			this.layeredPane.add(this.getLblAnne());
			this.layeredPane.add(this.getComboBoxMois());
			this.layeredPane.add(this.getComboBoxAnnee());
			this.layeredPane.add(this.getComboBoxJour());
			this.layeredPane.add(this.getTextField_5());
			this.layeredPane.add(this.getRdbtnOui());
			this.layeredPane.add(this.getRdbtnNon());
			this.layeredPane.add(this.getRdbtnDesinscrit());
			this.layeredPane.add(this.getLblChampObligatoire());
			this.layeredPane.add(this.getLblCivilit());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getTextField_6());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getTextField_7());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getTextField_8());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse");
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setBounds(235, 401, 77, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblAnne() {
		if (this.lblAnne == null) {
			this.lblAnne = new JLabel("Ann\u00E9e");
			this.lblAnne.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAnne.setForeground(Color.GRAY);
			this.lblAnne.setBounds(958, 432, 49, 14);
		}
		return this.lblAnne;
	}

	private JLabel getLblChampObligatoire() {
		if (this.lblChampObligatoire == null) {
			this.lblChampObligatoire = new JLabel("* Champ obligatoire");
			this.lblChampObligatoire.setForeground(Color.GRAY);
			this.lblChampObligatoire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblChampObligatoire.setBounds(232, 530, 148, 14);
		}
		return this.lblChampObligatoire;
	}

	private JLabel getLblCivilit() {
		if (this.lblCivilit == null) {
			this.lblCivilit = new JLabel("Civilit\u00E9");
			this.lblCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCivilit.setForeground(Color.GRAY);
			this.lblCivilit.setBounds(243, 370, 69, 14);
		}
		return this.lblCivilit;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("Code Postal *");
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCodePostal.setForeground(Color.GRAY);
			this.lblCodePostal.setBounds(406, 432, 86, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblDateDeNaissance() {
		if (this.lblDateDeNaissance == null) {
			this.lblDateDeNaissance = new JLabel("Date de Naissance *");
			this.lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateDeNaissance.setForeground(Color.GRAY);
			this.lblDateDeNaissance.setBounds(563, 432, 124, 14);
		}
		return this.lblDateDeNaissance;
	}

	private JLabel getLblEmail() {
		if (this.lblEmail == null) {
			this.lblEmail = new JLabel("Email");
			this.lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmail.setForeground(Color.GRAY);
			this.lblEmail.setBounds(449, 463, 44, 14);
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
					final GestionCartesDeFidelite fenetre = new GestionCartesDeFidelite();
					fenetre.setVisible(true);
					MajFicheClientCarteFidelite.this.dispose();
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(870, 231, 172, 47);
		}
		return this.lblFermer;
	}

	private JLabel getLblJour() {
		if (this.lblJour == null) {
			this.lblJour = new JLabel("Jour");
			this.lblJour.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblJour.setForeground(Color.GRAY);
			this.lblJour.setBounds(707, 432, 45, 14);
		}
		return this.lblJour;
	}

	private JLabel getLblMagasinDeRfrence() {
		if (this.lblMagasinDeRfrence == null) {
			this.lblMagasinDeRfrence = new JLabel("Magasin de R\u00E9f\u00E9rence *");
			this.lblMagasinDeRfrence.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMagasinDeRfrence.setForeground(Color.GRAY);
			this.lblMagasinDeRfrence.setBounds(510, 337, 148, 14);
		}
		return this.lblMagasinDeRfrence;
	}

	private JLabel getLblMenuGestion() {
		if (this.lblMenuGestion == null) {
			this.lblMenuGestion = new JLabel("Menu > Gestion Carte de Fid\u00E9lit\u00E9 > Maj Fiche Client");
			this.lblMenuGestion.setVisible(false);
			this.lblMenuGestion.setForeground(Color.GRAY);
			this.lblMenuGestion.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuGestion.setBounds(481, 286, 271, 14);
		}
		return this.lblMenuGestion;
	}

	private JLabel getLblMois() {
		if (this.lblMois == null) {
			this.lblMois = new JLabel("Mois");
			this.lblMois.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMois.setForeground(Color.GRAY);
			this.lblMois.setBounds(837, 432, 48, 14);
		}
		return this.lblMois;
	}

	private JLabel getLblNCarte() {
		if (this.lblNCarte == null) {
			this.lblNCarte = new JLabel("N\u00B0 Client *");
			this.lblNCarte.setForeground(Color.GRAY);
			this.lblNCarte.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNCarte.setBounds(234, 337, 78, 14);
		}
		return this.lblNCarte;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Mise \u00E0 Jour Fiche Client");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 477, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1
					.setIcon(new ImageIcon(MajFicheClientCarteFidelite.class.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewslettert() {
		if (this.lblNewslettert == null) {
			this.lblNewslettert = new JLabel("Abonnement Newsletter");
			this.lblNewslettert.setForeground(Color.GRAY);
			this.lblNewslettert.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewslettert.setBounds(449, 496, 158, 14);
		}
		return this.lblNewslettert;
	}

	private JLabel getLblNom() {
		if (this.lblNom == null) {
			this.lblNom = new JLabel("Nom *");
			this.lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNom.setForeground(Color.GRAY);
			this.lblNom.setBounds(409, 370, 49, 14);
		}
		return this.lblNom;
	}

	private JLabel getLblPrnom() {
		if (this.lblPrnom == null) {
			this.lblPrnom = new JLabel("Pr\u00E9nom *");
			this.lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrnom.setForeground(Color.GRAY);
			this.lblPrnom.setBounds(668, 370, 69, 14);
		}
		return this.lblPrnom;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider
					.setIcon(new ImageIcon(MajFicheClientCarteFidelite.class.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					boolean verification = true;

					MajFicheClientCarteFidelite.this.numerocarte = MajFicheClientCarteFidelite.this.textField_NumCli
							.getText();

					if (MajFicheClientCarteFidelite.this.numerocarte.isEmpty()) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de vérifier votre numéro de client - Ce champ ne peut être vide";

					}
					// if (!numerocarte.isEmpty()) {
					// if (numerocarte.length() != 13) {
					// verification = false;
					// message =
					// "Merci de vérifier votre numéro de client - 13 caractéres
					// obligatoires";
					// }
					// }

					try {
						MajFicheClientCarteFidelite.this.magasin = MajFicheClientCarteFidelite.this.comboBox
								.getSelectedItem().toString().toUpperCase();
						MajFicheClientCarteFidelite.this.idmagasin = ((Magasin) MajFicheClientCarteFidelite.this.comboBox
								.getSelectedItem()).getIdMagasin();
					} catch (final Exception e5) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de selectionner un magasin";
					}

					try {
						MajFicheClientCarteFidelite.this.civilite = MajFicheClientCarteFidelite.this.comboBox_1
								.getSelectedItem().toString().toUpperCase();
					} catch (final Exception e5) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de selectionner une civilité";
					}

					MajFicheClientCarteFidelite.this.nomClient = MajFicheClientCarteFidelite.this.textField_Nom
							.getText().toUpperCase();

					if (MajFicheClientCarteFidelite.this.nomClient.isEmpty()) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de vérifier le nom du client - Ce champ ne peut être vide";
					}

					MajFicheClientCarteFidelite.this.prenomClient = MajFicheClientCarteFidelite.this.textField_Prenom
							.getText().toUpperCase();

					if (MajFicheClientCarteFidelite.this.prenomClient.isEmpty()) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de vérifier le prénom du client - Ce champ ne peut être vide";
					}

					MajFicheClientCarteFidelite.this.age = MajFicheClientCarteFidelite.this.textField_Age.getText()
							.toUpperCase().toString();
					if (MajFicheClientCarteFidelite.this.age.isEmpty()) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de vérifier l'ége du client - Ce champ ne peut être vide";
					}
					if (!MajFicheClientCarteFidelite.this.age.isEmpty()) {
						if (Integer.parseInt(MajFicheClientCarteFidelite.this.age) < 18) {
							verification = false;
							MajFicheClientCarteFidelite.this.message = "Merci de vérifier l'ége du client- 18 ans minimum - Ce champ ne peut être vide";
						}
					}

					MajFicheClientCarteFidelite.this.adresseClient = MajFicheClientCarteFidelite.this.textField_Adresse
							.getText().toUpperCase();

					if (MajFicheClientCarteFidelite.this.adresseClient.isEmpty()) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de vérifier l'adresse renseignée - Ce champ ne peut être vide";
					}

					try {
						MajFicheClientCarteFidelite.this.villeClient = MajFicheClientCarteFidelite.this.textField_3
								.getSelectedItem().toString().toUpperCase();
						MajFicheClientCarteFidelite.this.idville = ((Ville) MajFicheClientCarteFidelite.this.textField_3
								.getSelectedItem()).getIdville();
					} catch (final Exception e5) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de selectionner une ville";
					}

					MajFicheClientCarteFidelite.this.CodePostalClient = MajFicheClientCarteFidelite.this.textField_CodePostal
							.getText();

					if (MajFicheClientCarteFidelite.this.CodePostalClient.isEmpty()) {
						verification = false;
						MajFicheClientCarteFidelite.this.message = "Merci de vérifier le code postal renseigné - Ce champ ne peut être vide";
					}

					if (!MajFicheClientCarteFidelite.this.CodePostalClient.isEmpty()) {
						if (MajFicheClientCarteFidelite.this.CodePostalClient.length() != 5) {
							verification = false;
							MajFicheClientCarteFidelite.this.message = "Merci de vérifier le code postal renseigné - Ce champ doit comporter 5 chiffres";
						}
					}

					System.out.print("8888888" + MajFicheClientCarteFidelite.this.operationprecedente + "88888888");

					if (MajFicheClientCarteFidelite.this.operationprecedente != null) {
						if (!MajFicheClientCarteFidelite.this.operationprecedente.equals("operation_commerciale")) {
							if (MajFicheClientCarteFidelite.this.jourdate == null) {
								verification = false;
								MajFicheClientCarteFidelite.this.message = "Merci de vérifier le jour renseigné - Ce champ ne peut être vide";
							}

							if (MajFicheClientCarteFidelite.this.moisdate == null) {
								verification = false;
								MajFicheClientCarteFidelite.this.message = "Merci de vérifier le mois renseigné - Ce champ ne peut être vide";
							}

							if (MajFicheClientCarteFidelite.this.annee == null) {
								verification = false;
								MajFicheClientCarteFidelite.this.message = "Merci de vérifier l'année renseignée - Ce champ ne peut être vide";
							}
							MajFicheClientCarteFidelite.this.dateComplete = MajFicheClientCarteFidelite.this.jourdate
									+ "/" + MajFicheClientCarteFidelite.this.moisdate + "/"
									+ MajFicheClientCarteFidelite.this.annee;
							System.out.print(MajFicheClientCarteFidelite.this.dateComplete);
						}

					}

					if (!MajFicheClientCarteFidelite.this.textField_Mail.getText().isEmpty()) {
						MajFicheClientCarteFidelite.this.email = MajFicheClientCarteFidelite.this.textField_Mail
								.getText();

						if (!EmailValidator.getInstance().isValid(MajFicheClientCarteFidelite.this.email)) {
							verification = false;
							MajFicheClientCarteFidelite.this.message = "Merci de vérifier l'adresse mail saisie";

						}
					}

					MajFicheClientCarteFidelite.this.telephonefixe = null;
					MajFicheClientCarteFidelite.this.telephoneportable = null;
					if (!MajFicheClientCarteFidelite.this.textField_TelFix.getText().isEmpty()) {
						MajFicheClientCarteFidelite.this.telephonefixe = MajFicheClientCarteFidelite.this.textField_TelFix
								.getText();

						if (MajFicheClientCarteFidelite.this.telephonefixe.length() != 10) {
							verification = false;
							MajFicheClientCarteFidelite.this.message = "le numero de téléphone doit contenir 10 chiffres";
						}
					}

					if (!MajFicheClientCarteFidelite.this.textField_TelGSM.getText().isEmpty()) {
						MajFicheClientCarteFidelite.this.telephoneportable = MajFicheClientCarteFidelite.this.textField_TelGSM
								.getText();

						if (MajFicheClientCarteFidelite.this.telephoneportable.length() != 10) {
							verification = false;
							MajFicheClientCarteFidelite.this.message = "le numero de téléphone doit contenir 10 chiffres";
						}
					}

					MajFicheClientCarteFidelite.this.newsletter = MajFicheClientCarteFidelite.this.valeurCaseNewsletter;

					if (verification == true) {
						final ConfirmationMAJClientFidelite fenetre = new ConfirmationMAJClientFidelite(
								MajFicheClientCarteFidelite.this.interfaceActuelle,
								MajFicheClientCarteFidelite.this.numerocarte, MajFicheClientCarteFidelite.this.magasin,
								MajFicheClientCarteFidelite.this.idmagasin, MajFicheClientCarteFidelite.this.civilite,
								MajFicheClientCarteFidelite.this.nomClient,
								MajFicheClientCarteFidelite.this.prenomClient,
								MajFicheClientCarteFidelite.this.adresseClient,
								MajFicheClientCarteFidelite.this.idville, MajFicheClientCarteFidelite.this.villeClient,
								MajFicheClientCarteFidelite.this.CodePostalClient,
								MajFicheClientCarteFidelite.this.dateComplete, MajFicheClientCarteFidelite.this.email,
								MajFicheClientCarteFidelite.this.newsletter,
								MajFicheClientCarteFidelite.this.identifiantclient,
								MajFicheClientCarteFidelite.this.operationprecedente,
								MajFicheClientCarteFidelite.this.numeroidcommerciale,
								MajFicheClientCarteFidelite.this.telephonefixe,
								MajFicheClientCarteFidelite.this.telephoneportable,
								MajFicheClientCarteFidelite.this.age,
								MajFicheClientCarteFidelite.this.magasinoperation);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setVisible(false);
					} else {
						System.out.print("impossible");

						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle,
								MajFicheClientCarteFidelite.this.message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);
					}

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
			this.lblVille = new JLabel("Ville *");
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblVille.setForeground(Color.GRAY);
			this.lblVille.setBounds(258, 432, 54, 14);
		}
		return this.lblVille;
	}

	private JRadioButton getRdbtnDesinscrit() {
		if (this.rdbtnDesinscrit == null) {
			this.rdbtnDesinscrit = new JRadioButton("D\u00E9sinscrit");
			this.rdbtnDesinscrit.setBackground(new Color(225, 225, 225));
			this.rdbtnDesinscrit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					if (MajFicheClientCarteFidelite.this.rdbtnDesinscrit.isSelected()) {
						MajFicheClientCarteFidelite.this.valeurCaseNewsletter = MajFicheClientCarteFidelite.this.rdbtnDesinscrit
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnDesinscrit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnDesinscrit.setForeground(Color.GRAY);
			this.rdbtnDesinscrit.setBounds(746, 492, 91, 23);
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
					if (MajFicheClientCarteFidelite.this.rdbtnNon.isSelected()) {
						MajFicheClientCarteFidelite.this.valeurCaseNewsletter = MajFicheClientCarteFidelite.this.rdbtnNon
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnNon.setForeground(Color.GRAY);
			this.rdbtnNon.setBounds(674, 492, 63, 23);
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
					if (MajFicheClientCarteFidelite.this.rdbtnOui.isSelected()) {
						MajFicheClientCarteFidelite.this.valeurCaseNewsletter = MajFicheClientCarteFidelite.this.rdbtnOui
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnOui.setForeground(Color.GRAY);
			this.rdbtnOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnOui.setBounds(604, 492, 68, 23);
			this.rdbtnOui.setSelected(true);
			if (this.rdbtnOui.isSelected()) {
				this.valeurCaseNewsletter = this.rdbtnOui.getText().toString().toUpperCase();
			}
			this.group.add(this.rdbtnOui);

		}
		return this.rdbtnOui;
	}

	private JTextField getTextField() {
		if (this.textField_Nom == null) {
			this.textField_Nom = new JTextField();
			this.textField_Nom.setForeground(Color.GRAY);
			this.textField_Nom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Nom.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Nom.setBounds(468, 367, 182, 20);
			this.textField_Nom.setColumns(10);
		}
		return this.textField_Nom;
	}

	private JTextField getTextField_1() {
		if (this.textField_Prenom == null) {
			this.textField_Prenom = new JTextField();
			this.textField_Prenom.setForeground(Color.GRAY);
			this.textField_Prenom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Prenom.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Prenom.setBounds(738, 367, 294, 20);
			this.textField_Prenom.setColumns(10);
		}
		return this.textField_Prenom;
	}

	private JTextField getTextField_2() {
		if (this.textField_Adresse == null) {
			this.textField_Adresse = new JTextField();
			this.textField_Adresse.setForeground(Color.GRAY);
			this.textField_Adresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Adresse.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Adresse.setBounds(310, 398, 722, 20);
			this.textField_Adresse.setColumns(10);
		}
		return this.textField_Adresse;
	}

	private JComboBox<Object> getTextField_3() {
		if (this.textField_3 == null) {
			this.textField_3 = new JComboBox<Object>();
			this.textField_3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						MajFicheClientCarteFidelite.this.villeClient = MajFicheClientCarteFidelite.this.textField_3
								.getSelectedItem().toString().toUpperCase();
						MajFicheClientCarteFidelite.this.idville = ((Ville) MajFicheClientCarteFidelite.this.textField_3
								.getSelectedItem()).getIdville();
						final String CP = ((Ville) MajFicheClientCarteFidelite.this.textField_3.getSelectedItem())
								.getCodePostalVille();
						MajFicheClientCarteFidelite.this.textField_CodePostal.setText(CP);
					} catch (final Exception e5) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajFicheClientCarteFidelite.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajFicheClientCarteFidelite.this.interfaceActuelle.setEnabled(false);
					}

				}
			});
			this.textField_3.setEditable(true);
			this.textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_3.setForeground(Color.GRAY);
			this.textField_3.setBorder(null);
			this.textField_3.setBounds(310, 428, 86, 22);
			this.listeVille = new DefaultComboBoxModel<Object>(Select.listeVille());
			this.textField_3.setModel(this.listeVille);
			AutoCompletion.enable(this.textField_3);

		}
		return this.textField_3;
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
			this.textField_CodePostal.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_CodePostal.setBounds(489, 429, 64, 20);
			this.textField_CodePostal.setColumns(10);
		}
		return this.textField_CodePostal;
	}

	private JTextField getTextField_5() {
		if (this.textField_Mail == null) {
			this.textField_Mail = new JTextField();
			this.textField_Mail.setForeground(Color.GRAY);
			this.textField_Mail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Mail.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Mail.setBounds(489, 460, 348, 20);
			this.textField_Mail.setColumns(10);
		}
		return this.textField_Mail;
	}

	private JTextField getTextField_6() {
		if (this.textField_TelFix == null) {
			this.textField_TelFix = new JTextField();
			this.textField_TelFix.setForeground(Color.GRAY);
			this.textField_TelFix.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_TelFix.setColumns(10);
			this.textField_TelFix.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_TelFix.setBounds(310, 460, 124, 20);
		}
		return this.textField_TelFix;
	}

	private JTextField getTextField_7() {
		if (this.textField_TelGSM == null) {
			this.textField_TelGSM = new JTextField();
			this.textField_TelGSM.setForeground(Color.GRAY);
			this.textField_TelGSM.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_TelGSM.setColumns(10);
			this.textField_TelGSM.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_TelGSM.setBounds(310, 493, 124, 20);
		}
		return this.textField_TelGSM;
	}

	private JTextField getTextField_8() {
		if (this.textField_Age == null) {
			this.textField_Age = new JTextField();
			this.textField_Age.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_Age.setFocusable(false);
			this.textField_Age.setForeground(Color.GRAY);
			this.textField_Age.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_Age.setEditable(false);
			this.textField_Age.setColumns(10);
			this.textField_Age.setBounds(974, 460, 57, 20);
		}
		return this.textField_Age;
	}
}
