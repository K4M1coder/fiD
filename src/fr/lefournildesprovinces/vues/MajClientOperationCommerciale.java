package fr.lefournildesprovinces.vues;

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
import java.util.Vector;

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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.apache.commons.validator.routines.EmailValidator;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.ClientOperationCommerciale;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.OperationCommerciale;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class MajClientOperationCommerciale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1158064770865088784L;
	private String adresse;
	private String age;
	private String annee;
	private String civilite;
	private String codePostal;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private JComboBox<Object> comboBoxCivilite;
	private final JPanel contentPane;
	private String dateComplete;
	private String email;
	private JLabel fond;
	// creation et instantiation d'un groupe de bouton
	ButtonGroup group = new ButtonGroup();
	private int identifiantclient;
	private int idmagasin;
	private int IdOperationCommerciale;
	private int idville;
	private final JFrame interfaceActuelle;
	private String jour;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblAbonnementNewsletter;
	private JLabel lblAdresse;
	private JLabel lblAge;
	private JLabel lblCivilit;
	private JLabel lblCodePostal;
	private JLabel lblEmail;
	private JLabel lblFermer;
	private JLabel lblMagasin;
	private JLabel lblMenuNouvelle;
	private JLabel lblMiseJour;
	private JLabel lblMobile;
	private JLabel lblNewLabel;
	private JLabel lblNom;
	private JLabel lblOpration;
	private JLabel lblPrnom;
	private JLabel lblTlphone;
	private JLabel lblValider;
	private JLabel lblVille;
	private ComboBoxModel<Object> ListeVille;
	private ComboBoxModel<Object> magasin;
	private String mois;
	private String newsletter;

	private String nom;

	private final String nomClient;
	private ComboBoxModel<Object> operation;
	private String prenom;
	private final String prenomClient;
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

	public MajClientOperationCommerciale(final String nom, final String prenom,
			final String ageclient) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				final Vector<ClientOperationCommerciale> infosclient = Select
						.infosclient(
								MajClientOperationCommerciale.this.nomClient,
								MajClientOperationCommerciale.this.prenomClient,
								MajClientOperationCommerciale.this.age);

				for (int i = 0; i < infosclient.size(); i++) {

					MajClientOperationCommerciale.this.identifiantclient = infosclient
							.get(i).getIdclient();
					MajClientOperationCommerciale.this.textFieldNom
							.setText(infosclient.get(i).getNomIndividu());
					MajClientOperationCommerciale.this.textFieldPrenom
							.setText(infosclient.get(i).getPrenomIndividu());
					MajClientOperationCommerciale.this.textFieldAdresse
							.setText(infosclient.get(i).getAdresseIndividu());
					MajClientOperationCommerciale.this.textFieldCodePostal
							.setText(infosclient.get(i).getCodePostalIndividu());
					MajClientOperationCommerciale.this.textFieldEmail
							.setText(infosclient.get(i).getEmail());
					MajClientOperationCommerciale.this.textField
							.setText(infosclient.get(i).getNumerofixe());
					MajClientOperationCommerciale.this.textField_1
							.setText(infosclient.get(i).getNumeroportable());
					MajClientOperationCommerciale.this.textField_2
							.setText(infosclient.get(i).getAge());

					final String boutonselectionne = infosclient.get(i)
							.getNewsletterIndividu().toString();

					switch (boutonselectionne) {
					case "OUI":
						MajClientOperationCommerciale.this.rdbtnActif
								.setSelected(true);
						break;
					case "NON":
						MajClientOperationCommerciale.this.rdbtnInactif
								.setSelected(true);
						break;
					case "DéSINSCRIT":
						MajClientOperationCommerciale.this.rdbtnDesinscrit
								.setSelected(true);
						break;

					}

					for (int j = 1; j < MajClientOperationCommerciale.this.comboBoxCivilite
							.getModel().getSize(); j++) {

						final String s1 = MajClientOperationCommerciale.this.comboBoxCivilite
								.getItemAt(j).toString().toUpperCase();
						final String civiliteclient = infosclient.get(i)
								.getCiviliteIndividu();

						if (s1.equals(civiliteclient)) {
							MajClientOperationCommerciale.this.comboBoxCivilite
									.setSelectedIndex(j);
							break;
						}
					}

					for (int j = 1; j < MajClientOperationCommerciale.this.textFieldVille
							.getModel().getSize(); j++) {

						final String s1 = MajClientOperationCommerciale.this.textFieldVille
								.getItemAt(j).toString().toUpperCase();

						final String ville = infosclient.get(i)
								.getVilleIndividu();

						if (s1.equals(ville)) {
							MajClientOperationCommerciale.this.textFieldVille
									.setSelectedIndex(j);
							break;
						}
					}

					for (int j = 1; j < MajClientOperationCommerciale.this.comboBox
							.getModel().getSize(); j++) {

						final String s1 = MajClientOperationCommerciale.this.comboBox
								.getItemAt(j).toString().toUpperCase();
						final String magasin = infosclient.get(i)
								.getNommagasin().toUpperCase();

						if (s1.equals(magasin)) {
							MajClientOperationCommerciale.this.comboBox
									.setSelectedIndex(j);
							break;
						}
					}

					for (int j = 1; j < MajClientOperationCommerciale.this.comboBox_1
							.getModel().getSize(); j++) {

						final String s1 = MajClientOperationCommerciale.this.comboBox_1
								.getItemAt(j).toString().toUpperCase();
						final String operation = infosclient.get(i)
								.getLibelleoperationcommerciale().toUpperCase();

						if (s1.equals(operation)) {
							MajClientOperationCommerciale.this.comboBox_1
									.setSelectedIndex(j);
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
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);
		this.interfaceActuelle = this;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.age = ageclient;

	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					MajClientOperationCommerciale.this.comboBox_1
							.setEnabled(true);

					try {
						MajClientOperationCommerciale.this.idmagasin = ((Magasin) MajClientOperationCommerciale.this.comboBox
								.getSelectedItem()).getIdMagasin();

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}
				}
			});
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setBounds(303, 485, 206, 22);
			this.magasin = new DefaultComboBoxModel<Object>(
					Select.listemagasins());
			this.comboBox.setModel(this.magasin);

		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			this.comboBox_1 = new JComboBox<Object>();
			this.comboBox_1.setVisible(false);
			this.comboBox_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					MajClientOperationCommerciale.this.lblValider
							.setVisible(true);

					try {
						MajClientOperationCommerciale.this.IdOperationCommerciale = ((OperationCommerciale) MajClientOperationCommerciale.this.comboBox_1
								.getSelectedItem()).getIdOperationCommerciale();

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}
				}
			});
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setBounds(596, 485, 224, 22);
			this.operation = new DefaultComboBoxModel<Object>(
					Select.listeOperationCommerciale());
			this.comboBox_1.setModel(this.operation);
		}
		return this.comboBox_1;
	}

	private JComboBox<Object> getComboBoxCivilite() {
		if (this.comboBoxCivilite == null) {
			final String[] civiliteliste = { null, "Mr", "Mme", "NR" };
			this.comboBoxCivilite = new JComboBox<Object>(civiliteliste);
			this.comboBoxCivilite.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxCivilite.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						MajClientOperationCommerciale.this.civilite = MajClientOperationCommerciale.this.comboBoxCivilite
								.getSelectedItem().toString().toUpperCase();

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vÃ©rifier votre sÃ©lection";
						final AlerteSelection fenetre = new AlerteSelection(
								MajClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}
				}
			});

			this.comboBoxCivilite.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxCivilite.setForeground(Color.GRAY);
			this.comboBoxCivilite.setBackground(Color.WHITE);
			this.comboBoxCivilite.setBorder(null);
			this.comboBoxCivilite.setBounds(303, 326, 86, 22);
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
								MajClientOperationCommerciale.class
										.getResource("/Images/menus-grises-operation.png")));
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
								MajClientOperationCommerciale.class
										.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						MajClientOperationCommerciale.class
								.getResource("/Images/menus_operation.png")));
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
					MajClientOperationCommerciale.this.dispose();
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
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					MajClientOperationCommerciale.this.dispose();
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
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					MajClientOperationCommerciale.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(461, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					MajClientOperationCommerciale.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(703, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("* Champs Obligatoires");
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(232, 530, 150, 14);
		}
		return this.label_4;
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
			this.layeredPane.add(this.getLblMagasin());
			this.layeredPane.add(this.getLblOpration());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getLblTlphone());
			this.layeredPane.add(this.getLblMobile());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblMiseJour());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getTextField_2());
			this.layeredPane.add(this.getLabel_4());
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
			this.lblAbonnementNewsletter.setBounds(445, 456, 149, 14);
		}
		return this.lblAbonnementNewsletter;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse");
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setBounds(245, 361, 59, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblAge() {
		if (this.lblAge == null) {
			this.lblAge = new JLabel("Age *");
			this.lblAge.setForeground(Color.GRAY);
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAge.setBounds(733, 392, 50, 14);
		}
		return this.lblAge;
	}

	private JLabel getLblCivilit() {
		if (this.lblCivilit == null) {
			this.lblCivilit = new JLabel("Civilit\u00E9 *");
			this.lblCivilit.setForeground(Color.GRAY);
			this.lblCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCivilit.setBounds(243, 330, 61, 14);
		}
		return this.lblCivilit;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("Code Postal");
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCodePostal.setForeground(Color.GRAY);
			this.lblCodePostal.setBounds(583, 392, 74, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblEmail() {
		if (this.lblEmail == null) {
			this.lblEmail = new JLabel("Email");
			this.lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmail.setForeground(Color.GRAY);
			this.lblEmail.setBounds(431, 423, 49, 14);
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

					MajClientOperationCommerciale.this.dispose();
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(864, 232, 189, 46);
		}
		return this.lblFermer;
	}

	private JLabel getLblMagasin() {
		if (this.lblMagasin == null) {
			this.lblMagasin = new JLabel("Magasin *");
			this.lblMagasin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMagasin.setForeground(Color.GRAY);
			this.lblMagasin.setBounds(234, 489, 70, 14);
		}
		return this.lblMagasin;
	}

	private JLabel getLblMenuNouvelle() {
		if (this.lblMenuNouvelle == null) {
			this.lblMenuNouvelle = new JLabel(
					"Menu > Modification Fiche Client Op\u00E9ration Commerciale");
			this.lblMenuNouvelle.setVisible(false);
			this.lblMenuNouvelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuNouvelle.setForeground(Color.GRAY);
			this.lblMenuNouvelle.setBounds(518, 286, 269, 14);
		}
		return this.lblMenuNouvelle;
	}

	private JLabel getLblMiseJour() {
		if (this.lblMiseJour == null) {
			this.lblMiseJour = new JLabel("Mettre \u00E0 jour un bulletin");
			this.lblMiseJour.setForeground(Color.GRAY);
			this.lblMiseJour.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMiseJour.setBounds(242, 286, 281, 14);
		}
		return this.lblMiseJour;
	}

	private JLabel getLblMobile() {
		if (this.lblMobile == null) {
			this.lblMobile = new JLabel("Mobile");
			this.lblMobile.setForeground(Color.GRAY);
			this.lblMobile.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMobile.setBounds(254, 456, 50, 14);
		}
		return this.lblMobile;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					MajClientOperationCommerciale.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 1, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNom() {
		if (this.lblNom == null) {
			this.lblNom = new JLabel("Nom *");
			this.lblNom.setForeground(Color.GRAY);
			this.lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNom.setBounds(406, 330, 46, 14);
		}
		return this.lblNom;
	}

	private JLabel getLblOpration() {
		if (this.lblOpration == null) {
			this.lblOpration = new JLabel("Op\u00E9ration *");
			this.lblOpration.setVisible(false);
			this.lblOpration.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOpration.setForeground(Color.GRAY);
			this.lblOpration.setBounds(519, 489, 75, 14);
		}
		return this.lblOpration;
	}

	private JLabel getLblPrnom() {
		if (this.lblPrnom == null) {
			this.lblPrnom = new JLabel("Pr\u00E9nom *");
			this.lblPrnom.setForeground(Color.GRAY);
			this.lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrnom.setBounds(669, 330, 68, 14);
		}
		return this.lblPrnom;
	}

	private JLabel getLblTlphone() {
		if (this.lblTlphone == null) {
			this.lblTlphone = new JLabel("T\u00E9l\u00E9phone");
			this.lblTlphone.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTlphone.setForeground(Color.GRAY);
			this.lblTlphone.setBounds(232, 423, 72, 14);
		}
		return this.lblTlphone;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(
					MajClientOperationCommerciale.class
							.getResource("/Images/valider.png")));

			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					boolean verification = true;
					String message = null;

					MajClientOperationCommerciale.this.telephonefixe = null;
					MajClientOperationCommerciale.this.telephoneportable = null;
					MajClientOperationCommerciale.this.email = null;
					MajClientOperationCommerciale.this.codePostal = null;

					MajClientOperationCommerciale.this.nom = MajClientOperationCommerciale.this.textFieldNom
							.getText().toUpperCase();
					MajClientOperationCommerciale.this.prenom = MajClientOperationCommerciale.this.textFieldPrenom
							.getText().toUpperCase();
					MajClientOperationCommerciale.this.newsletter = MajClientOperationCommerciale.this.valeurCaseNewsletter;

					if (!MajClientOperationCommerciale.this.textField.getText()
							.isEmpty()) {
						MajClientOperationCommerciale.this.telephonefixe = MajClientOperationCommerciale.this.textField
								.getText().toString();
						if (MajClientOperationCommerciale.this.telephonefixe
								.length() != 10) {
							verification = false;
							message = "le numero de téléphone doit contenir 10 chiffres";
						}
					}

					if (!MajClientOperationCommerciale.this.textField_1
							.getText().isEmpty()) {
						MajClientOperationCommerciale.this.telephoneportable = MajClientOperationCommerciale.this.textField_1
								.getText().toString();
						if (MajClientOperationCommerciale.this.telephoneportable
								.length() != 10) {
							verification = false;
							message = "le numero de téléphone portable doit contenir 10 chiffres";
						}
					}
					MajClientOperationCommerciale.this.age = MajClientOperationCommerciale.this.textField_2
							.getText().toUpperCase().toString();
					if (MajClientOperationCommerciale.this.age.isEmpty()) {
						verification = false;
						message = "Merci de vérifier l'ége du client - Ce champ ne peut être vide";
					} else {

						final int agemini = Integer
								.parseInt(MajClientOperationCommerciale.this.age);
						if (agemini < 18) {
							verification = false;
							message = "Merci de vérifier l'ége du client - 18 ans minimum";
						}
					}
					if (!MajClientOperationCommerciale.this.textFieldEmail
							.getText().isEmpty()) {
						MajClientOperationCommerciale.this.email = MajClientOperationCommerciale.this.textFieldEmail
								.getText();

						if (!EmailValidator.getInstance().isValid(
								MajClientOperationCommerciale.this.email)) {
							verification = false;
							message = "Merci de vérifier l'adresse mail saisie";

						}
					}

					if ((MajClientOperationCommerciale.this.annee != null)
							&& (MajClientOperationCommerciale.this.mois != null)
							&& (MajClientOperationCommerciale.this.jour != null)) {

						MajClientOperationCommerciale.this.dateComplete = MajClientOperationCommerciale.this.jour
								+ "/"
								+ MajClientOperationCommerciale.this.mois
								+ "/"
								+ MajClientOperationCommerciale.this.annee;
					}

					if (!MajClientOperationCommerciale.this.textFieldCodePostal
							.getText().isEmpty()) {
						MajClientOperationCommerciale.this.codePostal = MajClientOperationCommerciale.this.textFieldCodePostal
								.getText();
						if (MajClientOperationCommerciale.this.codePostal
								.isEmpty()
								|| (MajClientOperationCommerciale.this.codePostal
										.length() < 5)) {
							verification = false;
							message = "Merci de vérifier le Code Postal, pour infos il doit contenir 5 chiffres";

						}

						for (int i = 0; i < MajClientOperationCommerciale.this.codePostal
								.length(); i++) {

							if (!Character
									.isDigit(MajClientOperationCommerciale.this.codePostal
											.charAt(i)))

							{
								verification = false;
								message = "Merci de vérifier le code Postal, il ne doit 5 Chiffres et aucune lettre";
								break;
							}

						}
					}

					try {

						MajClientOperationCommerciale.this.ville = MajClientOperationCommerciale.this.textFieldVille
								.getSelectedItem().toString().toUpperCase();
						MajClientOperationCommerciale.this.idville = ((Ville) MajClientOperationCommerciale.this.textFieldVille
								.getSelectedItem()).getIdville();
					} catch (final Exception e4) {
						verification = false;
						message = "Merci de selectionner une ville dans la liste";
					}

					if (!MajClientOperationCommerciale.this.textFieldAdresse
							.getText().isEmpty()) {
						MajClientOperationCommerciale.this.adresse = MajClientOperationCommerciale.this.textFieldAdresse
								.getText().toUpperCase();
						if (MajClientOperationCommerciale.this.adresse.length() <= 4) {
							verification = false;
							message = "Merci de vérifier l'adresse saisie, ce champs doit contenir au moins 4 caractéres";

						}
					}

					if (MajClientOperationCommerciale.this.prenom.isEmpty()) {
						verification = false;
						message = "Merci de vérifier le prénom du client, Ce champs ne peut être vide";

					}

					if (MajClientOperationCommerciale.this.nom.isEmpty()) {
						verification = false;
						message = "Merci de vérifier le nom du client, Ce champs ne peut être vide";

					}

					try {
						MajClientOperationCommerciale.this.civilite = MajClientOperationCommerciale.this.comboBoxCivilite
								.getSelectedItem().toString().toUpperCase();
					} catch (final Exception e5) {
						verification = false;
						message = "Merci de selectionner une civilite";

					}

					if (verification == true)

					{

						final ConfirmationMAJClientOC fenetre = new ConfirmationMAJClientOC(
								MajClientOperationCommerciale.this.identifiantclient,
								MajClientOperationCommerciale.this.interfaceActuelle,
								MajClientOperationCommerciale.this.civilite,
								MajClientOperationCommerciale.this.nom,
								MajClientOperationCommerciale.this.prenom,
								MajClientOperationCommerciale.this.adresse,
								MajClientOperationCommerciale.this.ville,
								MajClientOperationCommerciale.this.codePostal,
								MajClientOperationCommerciale.this.email,
								MajClientOperationCommerciale.this.newsletter,
								MajClientOperationCommerciale.this.dateComplete,
								MajClientOperationCommerciale.this.IdOperationCommerciale,
								MajClientOperationCommerciale.this.idmagasin,
								MajClientOperationCommerciale.this.idville,
								MajClientOperationCommerciale.this.telephonefixe,
								MajClientOperationCommerciale.this.telephoneportable,
								MajClientOperationCommerciale.this.age);
						fenetre.setVisible(true);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setVisible(false);
					} else

					{
						System.out.print("impossible");

						final AlerteSelection fenetre = new AlerteSelection(
								MajClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setBounds(911, 475, 142, 44);
		}
		return this.lblValider;
	}

	private JLabel getLblVille() {
		if (this.lblVille == null) {
			this.lblVille = new JLabel("Ville *");
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblVille.setForeground(Color.GRAY);
			this.lblVille.setBounds(258, 392, 46, 14);
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
					if (MajClientOperationCommerciale.this.rdbtnActif
							.isSelected()) {
						MajClientOperationCommerciale.this.valeurCaseNewsletter = MajClientOperationCommerciale.this.rdbtnActif
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnActif.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.rdbtnActif.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnActif.setForeground(Color.GRAY);
			this.rdbtnActif.setBounds(600, 452, 65, 23);
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
					if (MajClientOperationCommerciale.this.rdbtnDesinscrit
							.isSelected()) {
						MajClientOperationCommerciale.this.valeurCaseNewsletter = MajClientOperationCommerciale.this.rdbtnDesinscrit
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnDesinscrit.setForeground(Color.GRAY);
			this.rdbtnDesinscrit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnDesinscrit.setBounds(739, 452, 95, 23);
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
					if (MajClientOperationCommerciale.this.rdbtnInactif
							.isSelected()) {
						MajClientOperationCommerciale.this.valeurCaseNewsletter = MajClientOperationCommerciale.this.rdbtnInactif
								.getText().toString().toUpperCase();
					}
				}
			});
			this.rdbtnInactif.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.rdbtnInactif.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnInactif.setForeground(Color.GRAY);
			this.rdbtnInactif.setBounds(667, 452, 70, 23);
			// on ajoute le second bouton au groupe
			this.group.add(this.rdbtnInactif);

		}
		return this.rdbtnInactif;

	}

	private JTextField getTextField() {
		if (this.textField == null) {
			this.textField = new JTextField();
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setBounds(303, 420, 124, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}

	private JTextField getTextField_1() {
		if (this.textField_1 == null) {
			this.textField_1 = new JTextField();
			this.textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_1.setBounds(303, 453, 124, 20);
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
			this.textField_2.setBounds(786, 389, 34, 20);
		}
		return this.textField_2;
	}

	private JTextField getTextFieldAdresse() {
		if (this.textFieldAdresse == null) {
			this.textFieldAdresse = new JTextField();
			this.textFieldAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldAdresse.setForeground(Color.GRAY);
			this.textFieldAdresse.setBorder(new LineBorder(new Color(171, 173,
					179)));
			this.textFieldAdresse.setBounds(303, 358, 722, 20);
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
			this.textFieldCodePostal.setBounds(659, 389, 64, 20);
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
			this.textFieldEmail.setBounds(482, 420, 338, 20);
			this.textFieldEmail.setColumns(10);
		}
		return this.textFieldEmail;
	}

	private JTextField getTextFieldNom() {
		if (this.textFieldNom == null) {
			this.textFieldNom = new JTextField();
			this.textFieldNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldNom.setForeground(Color.GRAY);
			this.textFieldNom
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textFieldNom.setBounds(454, 327, 189, 20);
			this.textFieldNom.setColumns(10);
		}
		return this.textFieldNom;
	}

	private JTextField getTextFieldPrenom() {
		if (this.textFieldPrenom == null) {
			this.textFieldPrenom = new JTextField();
			this.textFieldPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldPrenom.setForeground(Color.GRAY);
			this.textFieldPrenom.setBorder(new LineBorder(new Color(171, 173,
					179)));
			this.textFieldPrenom.setBounds(739, 327, 286, 20);
			this.textFieldPrenom.setColumns(10);
		}
		return this.textFieldPrenom;
	}

	private JComboBox<Object> getTextFieldVille() {
		if (this.textFieldVille == null) {
			this.textFieldVille = new JComboBox<Object>();
			this.textFieldVille.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {

						MajClientOperationCommerciale.this.ville = MajClientOperationCommerciale.this.textFieldVille
								.getSelectedItem().toString().toUpperCase();
						MajClientOperationCommerciale.this.idville = ((Ville) MajClientOperationCommerciale.this.textFieldVille
								.getSelectedItem()).getIdville();
						final String CP = ((Ville) MajClientOperationCommerciale.this.textFieldVille
								.getSelectedItem()).getCodePostalVille();
						MajClientOperationCommerciale.this.textFieldCodePostal
								.setText(CP);

					} catch (final Exception e3) {
						final String message = "Merci de selectionner une ville dans la liste";
						final AlerteSelection fenetre = new AlerteSelection(
								MajClientOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MajClientOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.textFieldVille.setEditable(true);
			this.textFieldVille.setBackground(Color.WHITE);
			this.textFieldVille.setForeground(Color.GRAY);
			this.textFieldVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldVille.setBorder(null);
			this.textFieldVille.setBounds(303, 388, 270, 22);
			this.ListeVille = new DefaultComboBoxModel<Object>(
					Select.listeVille());
			this.textFieldVille.setModel(this.ListeVille);
			AutoCompletion.enable(this.textFieldVille);
		}
		return this.textFieldVille;
	}
}
