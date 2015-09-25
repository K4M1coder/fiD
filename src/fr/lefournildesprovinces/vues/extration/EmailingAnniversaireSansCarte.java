package fr.lefournildesprovinces.vues.extration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.util.ExcelExporter;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.MessageExport;

public class EmailingAnniversaireSansCarte extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 3368686024287846135L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
	private JCheckBox chckbxAge;
	private JCheckBox chckbxCivilit;
	private JCheckBox chckbxCodepostal;
	private JCheckBox chckbxDateDeNaissance;
	private JCheckBox chckbxEmail;
	private JCheckBox chckbxMagasinDeReference;
	private JCheckBox chckbxNom;
	private JCheckBox chckbxPrnom;
	private JCheckBox chckbxSelectionnerLensembleDes;
	private JCheckBox chckbxSurLensembleDes;
	private JCheckBox chckbxToutDselectionner;
	private JCheckBox chckbxToutSlectionner;
	private JCheckBox chckbxVille;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private String choixformat;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private final JPanel contentPane;
	private Object[][] donnees;
	private String[] entetes;
	private boolean etat;
	private boolean etatbouton = true;
	private JLabel fond;
	ButtonGroup group = new ButtonGroup();
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblEmailingParMagasin;
	private JLabel lblExportCvs;
	private JLabel lblExportxls;

	private JLabel lblFermer;
	private JLabel lblMerciDeChoisir;
	private JLabel lblMerciDeSlectionner_1;
	private JLabel lblOu;
	private JLabel lblSelectionnerLesInformations;
	private JLabel lblValider;
	private ComboBoxModel<Object> listemagasins;
	private Vector<ResultatRecherche> membres;

	private String Message;

	private DefaultTableModel model;
	private JRadioButton rdbtnAnniversaireAujourdhui;
	private JRadioButton rdbtnAnniversaireCeMois;
	private JRadioButton rdbtnPersonnalis;
	private JRadioButton rdbtnTousLesAnniversaire;
	private JScrollPane scrollPane_1;
	private String selectioncomboBox;
	private int selectionIDMagasin;
	private JTable table_3;
	private String valeurCasechoix;

	public EmailingAnniversaireSansCarte(final JFrame interfacepre) {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 848, 687);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;
		this.interfacePrecedente = interfacepre;
	}

	private JCheckBox getChckbxAbonnementNewsletter() {
		if (this.chckbxAbonnementNewsletter == null) {
			this.chckbxAbonnementNewsletter = new JCheckBox(
					"Abonnement Newsletter");
			this.chckbxAbonnementNewsletter
					.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(final MouseEvent e) {
							EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(659, 260, 163, 23);
			this.chckbxAbonnementNewsletter.setSelected(true);
		}
		return this.chckbxAbonnementNewsletter;
	}

	private JCheckBox getChckbxAdresse() {
		if (this.chckbxAdresse == null) {
			this.chckbxAdresse = new JCheckBox("Adresse");
			this.chckbxAdresse.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(118, 260, 71, 23);
			this.chckbxAdresse.setSelected(true);
		}
		return this.chckbxAdresse;
	}

	private JCheckBox getChckbxAge() {
		if (this.chckbxAge == null) {
			this.chckbxAge = new JCheckBox("Age");
			this.chckbxAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAge.setForeground(Color.GRAY);
			this.chckbxAge.setBounds(389, 286, 47, 23);
			this.chckbxAge.setSelected(true);
		}
		return this.chckbxAge;
	}

	private JCheckBox getChckbxCivilit() {
		if (this.chckbxCivilit == null) {
			this.chckbxCivilit = new JCheckBox("Civilit\u00E9");
			this.chckbxCivilit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(22, 260, 63, 23);
			this.chckbxCivilit.setSelected(true);

		}
		return this.chckbxCivilit;
	}

	private JCheckBox getChckbxCodepostal() {
		if (this.chckbxCodepostal == null) {
			this.chckbxCodepostal = new JCheckBox("CodePostal");
			this.chckbxCodepostal.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(118, 312, 89, 23);
			this.chckbxCodepostal.setSelected(true);
		}
		return this.chckbxCodepostal;
	}

	private JCheckBox getChckbxDateDeNaissance() {
		if (this.chckbxDateDeNaissance == null) {
			this.chckbxDateDeNaissance = new JCheckBox("Date de Naissance");
			this.chckbxDateDeNaissance.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxDateDeNaissance.setForeground(Color.GRAY);
			this.chckbxDateDeNaissance
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxDateDeNaissance.setBounds(243, 260, 129, 23);
			this.chckbxDateDeNaissance.setSelected(true);
		}
		return this.chckbxDateDeNaissance;
	}

	private JCheckBox getChckbxEmail() {
		if (this.chckbxEmail == null) {
			this.chckbxEmail = new JCheckBox("eMail");
			this.chckbxEmail.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(243, 286, 55, 23);
			this.chckbxEmail.setSelected(true);
		}
		return this.chckbxEmail;
	}

	private JCheckBox getChckbxMagasinDeReference() {
		if (this.chckbxMagasinDeReference == null) {
			this.chckbxMagasinDeReference = new JCheckBox(
					"Magasin de reference");
			this.chckbxMagasinDeReference.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(389, 260, 147, 23);
			this.chckbxMagasinDeReference.setSelected(true);
		}
		return this.chckbxMagasinDeReference;
	}

	private JCheckBox getChckbxNom() {
		if (this.chckbxNom == null) {
			this.chckbxNom = new JCheckBox("Nom");
			this.chckbxNom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(22, 286, 51, 23);
			this.chckbxNom.setSelected(true);
		}
		return this.chckbxNom;
	}

	private JCheckBox getChckbxPrnom() {
		if (this.chckbxPrnom == null) {
			this.chckbxPrnom = new JCheckBox("Pr\u00E9nom");
			this.chckbxPrnom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(22, 312, 69, 23);
			this.chckbxPrnom.setSelected(true);

		}
		return this.chckbxPrnom;
	}

	private JCheckBox getChckbxSelectionnerLensembleDes() {
		if (this.chckbxSelectionnerLensembleDes == null) {
			this.chckbxSelectionnerLensembleDes = new JCheckBox(
					"Selectionner l'ensemble des resultats");
			this.chckbxSelectionnerLensembleDes.setVisible(false);
			this.chckbxSelectionnerLensembleDes
					.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(final MouseEvent e) {

							if (EmailingAnniversaireSansCarte.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingAnniversaireSansCarte.this.table_3
										.selectAll();
								EmailingAnniversaireSansCarte.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(22, 607, 237, 23);
		}
		return this.chckbxSelectionnerLensembleDes;
	}

	private JCheckBox getChckbxSurLensembleDes() {
		if (this.chckbxSurLensembleDes == null) {
			this.chckbxSurLensembleDes = new JCheckBox(
					"Sur l'ensemble des magasins");

			this.chckbxSurLensembleDes.setVisible(true);

			this.chckbxSurLensembleDes
					.setFont(new Font("Tahoma", Font.BOLD, 11));

			this.chckbxSurLensembleDes.setForeground(Color.GRAY);
			this.chckbxSurLensembleDes.setBounds(22, 183, 189, 23);
			this.chckbxSurLensembleDes.setSelected(false);
			this.chckbxSurLensembleDes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (EmailingAnniversaireSansCarte.this.chckbxSurLensembleDes
							.isSelected() != true) {

						EmailingAnniversaireSansCarte.this.comboBox_1
								.setVisible(true);
						EmailingAnniversaireSansCarte.this.comboBox_1
								.setEnabled(true);
						EmailingAnniversaireSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(true);
						EmailingAnniversaireSansCarte.this.lblValider
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.etatbouton = false;
						EmailingAnniversaireSansCarte.this.lblOu
								.setVisible(true);
					} else

					{
						EmailingAnniversaireSansCarte.this.comboBox_1
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.comboBox_1
								.setEnabled(false);
						EmailingAnniversaireSansCarte.this.lblOu
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblValider
								.setVisible(true);
						EmailingAnniversaireSansCarte.this.etatbouton = true;

					}

				}
			});

		}
		return this.chckbxSurLensembleDes;
	}

	private JCheckBox getChckbxToutDselectionner() {
		if (this.chckbxToutDselectionner == null) {
			this.chckbxToutDselectionner = new JCheckBox(
					"Tout d\u00E9selectionner");
			this.chckbxToutDselectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					EmailingAnniversaireSansCarte.this.chckbxNom
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxPrnom
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxCivilit
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxAdresse
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxCodepostal
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxVille
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxEmail
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.checkBox
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.checkBox_1
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxDateDeNaissance
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxAge
							.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(22, 354, 139, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxNom
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxPrnom
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxCivilit
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxAdresse
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxCodepostal
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxVille
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxEmail
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.checkBox
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.checkBox_1
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxDateDeNaissance
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxAge
							.setSelected(true);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(190, 354, 125, 23);
			this.chckbxToutSlectionner.setSelected(true);
		}
		return this.chckbxToutSlectionner;
	}

	private JCheckBox getChckbxVille() {
		if (this.chckbxVille == null) {
			this.chckbxVille = new JCheckBox("Ville");
			this.chckbxVille.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(118, 286, 49, 23);
			this.chckbxVille.setSelected(true);
		}
		return this.chckbxVille;
	}

	private JCheckBox getCheckBox() {
		if (this.checkBox == null) {
			this.checkBox = new JCheckBox("Telephone");
			this.checkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(544, 286, 85, 23);
			this.checkBox.setSelected(true);
		}
		return this.checkBox;
	}

	private JCheckBox getCheckBox_1() {
		if (this.checkBox_1 == null) {
			this.checkBox_1 = new JCheckBox("Mobile");
			this.checkBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(544, 260, 63, 23);
			this.checkBox_1.setSelected(true);
		}
		return this.checkBox_1;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] mois = { null, " Janvier", " Fevrier", " Mars",
					" Avril", " Mai", " Juin", " Juillet", " Août",
					" Septembre", " Octobre", " Novembre", " Décembre" };
			this.comboBox = new JComboBox<Object>(mois);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setBorder(null);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					EmailingAnniversaireSansCarte.this.selectioncomboBox = EmailingAnniversaireSansCarte.this.comboBox
							.getSelectedItem().toString().substring(1);

					switch (EmailingAnniversaireSansCarte.this.selectioncomboBox) {
					case "Janvier":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "01";
						break;
					case "Fevrier":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "02";
						break;
					case "Mars":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "03";
						break;
					case "Avril":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "04";
						break;
					case "Mai":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "05";
						break;
					case "Juin":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "06";
						break;
					case "Juillet":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "07";
						break;
					case "Août":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "08";
						break;
					case "Septembre":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "09";
						break;
					case "Octobre":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "10";
						break;
					case "Novembre":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "11";
						break;
					case "Décembre":
						EmailingAnniversaireSansCarte.this.valeurCasechoix = "12";
						break;
					}
					System.out
							.print("mois "
									+ EmailingAnniversaireSansCarte.this.valeurCasechoix
									+ "\n");
				}
			});
			this.comboBox.setBounds(353, 133, 89, 18);
			this.comboBox.setFocusCycleRoot(false);
			this.comboBox.setEnabled(false);
		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			this.comboBox_1 = new JComboBox<Object>();
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						EmailingAnniversaireSansCarte.this.selectionIDMagasin = ((Magasin) EmailingAnniversaireSansCarte.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						EmailingAnniversaireSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblValider
								.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection - Cliquer pour continuer";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblValider
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblValider
								.setEnabled(false);
						EmailingAnniversaireSansCarte.this.chckbxAge
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxNom
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxPrnom
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxCivilit
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxAdresse
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxCodepostal
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxVille
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxEmail
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.checkBox
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.checkBox_1
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingAnniversaireSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAnniversaireSansCarte.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingAnniversaireSansCarte.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingAnniversaireSansCarte.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblExportxls
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblExportCvs
								.setVisible(false);
						if ((EmailingAnniversaireSansCarte.this.table_3
								.getRowCount() != 0)
								&& (EmailingAnniversaireSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingAnniversaireSansCarte.this.model
									.setColumnCount(0);
							EmailingAnniversaireSansCarte.this.model
									.setRowCount(0);
							EmailingAnniversaireSansCarte.this.table_3
									.setModel(EmailingAnniversaireSansCarte.this.model);
							EmailingAnniversaireSansCarte.this.table_3
									.repaint();
						}
					}

				}
			});
			this.comboBox_1.setVisible(true);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(303, 185, 514, 18);
			this.comboBox_1.setEnabled(true);
			this.listemagasins = new DefaultComboBoxModel<Object>(
					Select.listemagasins());
			this.comboBox_1.setModel(this.listemagasins);
			this.comboBox_1.setFocusable(false);

		}
		return this.comboBox_1;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.fond.setIcon(new ImageIcon(EmailingAnniversaireSansCarte.class
					.getResource("/Images/menus-extraction-long.png")));
			this.fond.setBounds(0, 0, 850, 690);
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
					EmailingAnniversaireSansCarte.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(22, 0, 114, 44);
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
					EmailingAnniversaireSansCarte.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(131, 0, 114, 44);
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
					EmailingAnniversaireSansCarte.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(243, 0, 114, 44);
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
					EmailingAnniversaireSansCarte.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(357, 0, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblEmailingParMagasin());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblExportCvs());
			this.layeredPane.add(this.getChckbxNom());
			this.layeredPane.add(this.getChckbxPrnom());
			this.layeredPane.add(this.getChckbxCivilit());
			this.layeredPane.add(this.getChckbxAdresse());
			this.layeredPane.add(this.getChckbxCodepostal());
			this.layeredPane.add(this.getChckbxVille());
			this.layeredPane.add(this.getChckbxEmail());
			this.layeredPane.add(this.getChckbxAbonnementNewsletter());
			this.layeredPane.add(this.getChckbxDateDeNaissance());
			this.layeredPane.add(this.getChckbxMagasinDeReference());
			this.layeredPane.add(this.getScrollPane_1());
			this.layeredPane.add(this.getLblSelectionnerLesInformations());
			this.layeredPane.add(this.getChckbxToutDselectionner());
			this.layeredPane.add(this.getChckbxToutSlectionner());
			this.layeredPane.add(this.getChckbxSelectionnerLensembleDes());
			this.layeredPane.add(this.getLblExportxls());
			this.layeredPane.add(this.getLblMerciDeSlectionner_1());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getChckbxSurLensembleDes());
			this.layeredPane.add(this.getChckbxAge());
			this.layeredPane.add(this.getLblMerciDeChoisir());
			this.layeredPane.add(this.getRdbtnAnniversaireCeMois());
			this.layeredPane.add(this.getRdbtnAnniversaireAujourdhui());
			this.layeredPane.add(this.getRdbtnPersonnalis());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getRdbtnTousLesAnniversaire());
			this.layeredPane.add(this.getLblOu());
			this.layeredPane.add(this.getCheckBox());
			this.layeredPane.add(this.getCheckBox_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getFond());

		}
		return this.layeredPane;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"Tri Par tranche date d'anniversaire (Clients non titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(22, 54, 425, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(
					EmailingAnniversaireSansCarte.class
							.getResource("/Images/export-csv.png")));
			this.lblExportCvs.setVisible(false);
			this.lblExportCvs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					try {
						final FileWriter writer = new FileWriter(
								"Resultats.csv");

						for (int j = 0; j < EmailingAnniversaireSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EmailingAnniversaireSansCarte.this.entetes.length - 1); i++) {
								if (EmailingAnniversaireSansCarte.this.donnees[j][i] != null) {
									writer.append(EmailingAnniversaireSansCarte.this.donnees[j][i]
											.toString());
									if (i == (EmailingAnniversaireSansCarte.this.entetes.length - 1)) {
										writer.append("\n");
									} else {
										writer.append(",");
									}

								}

								else {
									writer.append(",");
								}

							}
						}

						EmailingAnniversaireSansCarte.this.Message = "Exportation du fichier CSV réalisé avec succès";
						EmailingAnniversaireSansCarte.this.etat = true;
						EmailingAnniversaireSansCarte.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaireSansCarte.this.Message,
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								EmailingAnniversaireSansCarte.this.etat,
								EmailingAnniversaireSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingAnniversaireSansCarte.this.Message = "Impossible de générer le fichier CSV - Cliquer pour continuer";
						EmailingAnniversaireSansCarte.this.etat = false;
						EmailingAnniversaireSansCarte.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaireSansCarte.this.Message,
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								EmailingAnniversaireSansCarte.this.etat,
								EmailingAnniversaireSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(684, 616, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(
					EmailingAnniversaireSansCarte.class
							.getResource("/Images/export-excel.png")));
			this.lblExportxls.setVisible(false);
			this.lblExportxls.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportxls.setForeground(Color.GRAY);
			this.lblExportxls.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					try {
						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(
								EmailingAnniversaireSansCarte.this.table_3,
								new File("Resultats.xls"));
						EmailingAnniversaireSansCarte.this.etat = true;
						EmailingAnniversaireSansCarte.this.Message = "Exportation du fichier XLS réalisé avec succès";
						EmailingAnniversaireSansCarte.this.choixformat = "XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaireSansCarte.this.Message,
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								EmailingAnniversaireSansCarte.this.etat,
								EmailingAnniversaireSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingAnniversaireSansCarte.this.etat = false;
						EmailingAnniversaireSansCarte.this.choixformat = "XLS";
						EmailingAnniversaireSansCarte.this.Message = "Impossible de générer le fichier XLS - Cliquer pour continuer";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaireSansCarte.this.Message,
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								EmailingAnniversaireSansCarte.this.etat,
								EmailingAnniversaireSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(525, 622, 133, 28);
		}
		return this.lblExportxls;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					EmailingAnniversaireSansCarte.this.dispose();
					EmailingAnniversaireSansCarte.this.interfacePrecedente
							.setVisible(true);
					EmailingAnniversaireSansCarte.this.interfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(659, 0, 179, 47);
		}
		return this.lblFermer;
	}

	private JLabel getLblMerciDeChoisir() {
		if (this.lblMerciDeChoisir == null) {
			this.lblMerciDeChoisir = new JLabel(
					"Extraire les dates anniversaires pour :");
			this.lblMerciDeChoisir.setForeground(Color.GRAY);
			this.lblMerciDeChoisir.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeChoisir.setBounds(22, 98, 214, 14);
		}
		return this.lblMerciDeChoisir;

	}

	private JLabel getLblMerciDeSlectionner_1() {
		if (this.lblMerciDeSlectionner_1 == null) {
			this.lblMerciDeSlectionner_1 = new JLabel(
					"S\u00E9lectionner un magasin pr\u00E9cis");
			this.lblMerciDeSlectionner_1.setVisible(true);
			this.lblMerciDeSlectionner_1.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner_1.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblMerciDeSlectionner_1.setBounds(472, 187, 176, 14);
			this.lblMerciDeSlectionner_1.setEnabled(true);

		}
		return this.lblMerciDeSlectionner_1;
	}

	private JLabel getLblOu() {
		if (this.lblOu == null) {
			this.lblOu = new JLabel("Ou");
			this.lblOu.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOu.setForeground(Color.GRAY);
			this.lblOu.setBounds(244, 187, 16, 14);
		}
		return this.lblOu;
	}

	private JLabel getLblSelectionnerLesInformations() {
		if (this.lblSelectionnerLesInformations == null) {
			this.lblSelectionnerLesInformations = new JLabel(
					"Selectionner les informations souhait\u00E9es");
			this.lblSelectionnerLesInformations.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblSelectionnerLesInformations.setForeground(Color.GRAY);
			this.lblSelectionnerLesInformations.setBounds(22, 239, 230, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(
					EmailingAnniversaireSansCarte.class
							.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingAnniversaireSansCarte.this.checkBox
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.checkBox_1
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxCivilit
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxNom
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxPrnom
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxAdresse
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxVille
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxCodepostal
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxDateDeNaissance
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxEmail
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}

					if (EmailingAnniversaireSansCarte.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaireSansCarte.this.chckbxAge
							.isSelected() == true) {

						compteur++;
					}

					if (compteur > 4) {
						EmailingAnniversaireSansCarte.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingAnniversaireSansCarte.this.membres = Select
							.eMailinganniversaireSansCarte(
									EmailingAnniversaireSansCarte.this.valeurCasechoix,
									EmailingAnniversaireSansCarte.this.selectionIDMagasin,
									EmailingAnniversaireSansCarte.this.etatbouton);

					if (EmailingAnniversaireSansCarte.this.membres.size() == 0) {
						final String message = "Aucun Résultat - Cliquer pour continuer";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAnniversaireSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAnniversaireSansCarte.this.lblValider
								.setVisible(false);

						if ((EmailingAnniversaireSansCarte.this.table_3
								.getRowCount() != 0)
								|| (EmailingAnniversaireSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingAnniversaireSansCarte.this.model
									.setColumnCount(0);
							EmailingAnniversaireSansCarte.this.model
									.setRowCount(0);
							EmailingAnniversaireSansCarte.this.table_3
									.setModel(EmailingAnniversaireSansCarte.this.model);
							EmailingAnniversaireSansCarte.this.table_3
									.repaint();
						}
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum - Cliquer pour continuer";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAnniversaireSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAnniversaireSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingAnniversaireSansCarte.this.lblValider
								.setVisible(false);

					} else

					{

						EmailingAnniversaireSansCarte.this.entetes = new String[compteur];

						EmailingAnniversaireSansCarte.this.donnees = new Object[EmailingAnniversaireSansCarte.this.membres
								.size()][EmailingAnniversaireSansCarte.this.entetes.length];

						for (int j = 0; j < EmailingAnniversaireSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i < (EmailingAnniversaireSansCarte.this.entetes.length - 1); i++) {

								if (EmailingAnniversaireSansCarte.this.chckbxCivilit
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Civilité";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingAnniversaireSansCarte.this.chckbxNom
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Nom";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getNomIndividu().toUpperCase();
									i++;

								}
								if (EmailingAnniversaireSansCarte.this.chckbxPrnom
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Prénom";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getPrenomIndividu().toLowerCase();
									i++;

								}
								if (EmailingAnniversaireSansCarte.this.chckbxAdresse
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Adresse";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.chckbxVille
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Ville";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Code Postal";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.chckbxDateDeNaissance
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Date de Naissance";

									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getDateNaissanceIndividu();
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.chckbxAge
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Age";
									final Calendar now = Calendar.getInstance();
									final int year = now.get(Calendar.YEAR);
									System.out.print("/////" + year + "\n");
									final String datenai = EmailingAnniversaireSansCarte.this.membres
											.get(j).getDateNaissanceIndividu();

									System.out.print("/////" + datenai + "\n");

									final String[] str = datenai.split("/");
									final String year2 = str[2];
									final int AnneeNaissance = Integer
											.valueOf(year2);
									System.out.print("/////" + AnneeNaissance
											+ "\n");
									final int ageclient = year - AnneeNaissance;
									EmailingAnniversaireSansCarte.this.donnees[j][i] = ageclient
											+ " ans";
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.chckbxEmail
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Adresse Mail";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Newsletter";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}

								if (EmailingAnniversaireSansCarte.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Magasin";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingAnniversaireSansCarte.this.checkBox
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Téléphone";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getTelephonefixe();
									i++;

								}
								if (EmailingAnniversaireSansCarte.this.checkBox_1
										.isSelected() == true) {
									EmailingAnniversaireSansCarte.this.entetes[i] = "Mobile";
									EmailingAnniversaireSansCarte.this.donnees[j][i] = EmailingAnniversaireSansCarte.this.membres
											.get(j).getTelephonemobile();
									i++;

								}

							}

						}

						if (EmailingAnniversaireSansCarte.this.membres.size() != 0) {

							EmailingAnniversaireSansCarte.this.model = new DefaultTableModel(
									EmailingAnniversaireSansCarte.this.donnees,
									EmailingAnniversaireSansCarte.this.entetes);

							EmailingAnniversaireSansCarte.this.table_3
									.setModel(EmailingAnniversaireSansCarte.this.model);

						}

					}

					EmailingAnniversaireSansCarte.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingAnniversaireSansCarte.this.lblExportxls
							.setVisible(true);
					EmailingAnniversaireSansCarte.this.lblExportCvs
							.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(718, 354, 99, 23);
		}
		return this.lblValider;
	}

	private JRadioButton getRdbtnAnniversaireAujourdhui() {
		if (this.rdbtnAnniversaireAujourdhui == null) {
			this.rdbtnAnniversaireAujourdhui = new JRadioButton("Aujourd'hui");
			this.rdbtnAnniversaireAujourdhui
					.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(final ActionEvent e) {

							if (EmailingAnniversaireSansCarte.this.rdbtnAnniversaireAujourdhui
									.isSelected()) {
								EmailingAnniversaireSansCarte.this.comboBox
										.setEnabled(false);
								final String format = "MM/dd";

								final SimpleDateFormat formater = new java.text.SimpleDateFormat(
										format);
								final Date date = new java.util.Date();
								EmailingAnniversaireSansCarte.this.valeurCasechoix = formater
										.format(date);
								System.out
										.print(EmailingAnniversaireSansCarte.this.valeurCasechoix);
							}
						}
					});
			this.rdbtnAnniversaireAujourdhui.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.rdbtnAnniversaireAujourdhui.setForeground(Color.GRAY);
			this.rdbtnAnniversaireAujourdhui.setBounds(22, 131, 91, 23);
			this.group.add(this.rdbtnAnniversaireAujourdhui);
		}
		return this.rdbtnAnniversaireAujourdhui;
	}

	private JRadioButton getRdbtnAnniversaireCeMois() {
		if (this.rdbtnAnniversaireCeMois == null) {
			this.rdbtnAnniversaireCeMois = new JRadioButton("Mois en cours");
			this.rdbtnAnniversaireCeMois.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.rdbtnAnniversaireCeMois
					.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(final ActionEvent arg0) {
							if (EmailingAnniversaireSansCarte.this.rdbtnAnniversaireCeMois
									.isSelected()) {
								EmailingAnniversaireSansCarte.this.comboBox
										.setEnabled(false);
								final Calendar now = Calendar.getInstance();
								final int mois = now.get(Calendar.MONTH) + 1;

								switch (mois) {
								case 1:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "01";
									break;
								case 2:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "02";
									break;
								case 3:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "03";
									break;
								case 4:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "04";
									break;
								case 5:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "05";
									break;
								case 6:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "06";
									break;
								case 7:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "07";
									break;
								case 8:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "08";
									break;
								case 9:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "09";
									break;
								case 10:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "10";
									break;
								case 11:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "11";
									break;
								case 12:
									EmailingAnniversaireSansCarte.this.valeurCasechoix = "12";
									break;
								}
								System.out
										.print("mois "
												+ EmailingAnniversaireSansCarte.this.valeurCasechoix
												+ "\n");

							}
						}
					});
			this.rdbtnAnniversaireCeMois.setForeground(Color.GRAY);
			this.rdbtnAnniversaireCeMois.setBounds(117, 131, 103, 23);
			this.rdbtnAnniversaireCeMois.setSelected(true);
			this.group.add(this.rdbtnAnniversaireCeMois);

			if (this.rdbtnAnniversaireCeMois.isSelected()) {

				final Calendar now = Calendar.getInstance();
				final int mois = now.get(Calendar.MONTH) + 1;
				switch (mois) {
				case 1:
					this.valeurCasechoix = "01";
					break;
				case 2:
					this.valeurCasechoix = "02";
					break;
				case 3:
					this.valeurCasechoix = "03";
					break;
				case 4:
					this.valeurCasechoix = "04";
					break;
				case 5:
					this.valeurCasechoix = "05";
					break;
				case 6:
					this.valeurCasechoix = "06";
					break;
				case 7:
					this.valeurCasechoix = "07";
					break;
				case 8:
					this.valeurCasechoix = "08";
					break;
				case 9:
					this.valeurCasechoix = "09";
					break;
				case 10:
					this.valeurCasechoix = "10";
					break;
				case 11:
					this.valeurCasechoix = "11";
					break;
				case 12:
					this.valeurCasechoix = "12";
					break;
				}
				System.out.print("mois " + this.valeurCasechoix + "\n");
			}
		}
		return this.rdbtnAnniversaireCeMois;
	}

	private JRadioButton getRdbtnPersonnalis() {
		if (this.rdbtnPersonnalis == null) {
			this.rdbtnPersonnalis = new JRadioButton(" Un Mois Pr\u00E9cis");
			this.rdbtnPersonnalis.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					EmailingAnniversaireSansCarte.this.comboBox
							.setEnabled(true);

				}
			});
			this.rdbtnPersonnalis.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnPersonnalis.setForeground(Color.GRAY);
			this.rdbtnPersonnalis.setBounds(222, 131, 109, 23);
			this.group.add(this.rdbtnPersonnalis);
		}
		return this.rdbtnPersonnalis;
	}

	private JRadioButton getRdbtnTousLesAnniversaire() {
		if (this.rdbtnTousLesAnniversaire == null) {
			this.rdbtnTousLesAnniversaire = new JRadioButton("Tous");
			this.rdbtnTousLesAnniversaire
					.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(final ActionEvent e) {

							if (EmailingAnniversaireSansCarte.this.rdbtnTousLesAnniversaire
									.isSelected()) {
								EmailingAnniversaireSansCarte.this.comboBox
										.setEnabled(false);
								EmailingAnniversaireSansCarte.this.valeurCasechoix = EmailingAnniversaireSansCarte.this.rdbtnTousLesAnniversaire
										.getText().toUpperCase();
							}

						}
					});
			this.rdbtnTousLesAnniversaire.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.rdbtnTousLesAnniversaire.setForeground(Color.GRAY);
			this.rdbtnTousLesAnniversaire.setBounds(468, 131, 53, 23);
			this.group.add(this.rdbtnTousLesAnniversaire);
		}
		return this.rdbtnTousLesAnniversaire;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(22, 401, 795, 194);
			this.scrollPane_1.setViewportView(this.getTable_3());
		}
		return this.scrollPane_1;
	}

	private JTable getTable_3() {
		if (this.table_3 == null) {
			this.table_3 = new JTable();
			this.table_3.setColumnSelectionAllowed(true);
			this.table_3.setCellSelectionEnabled(true);
		}
		return this.table_3;
	}
}
