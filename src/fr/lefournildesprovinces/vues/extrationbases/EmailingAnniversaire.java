package fr.lefournildesprovinces.vues.extrationbases;

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

public class EmailingAnniversaire extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -7169564489625204733L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
	private JCheckBox chckbxAge;
	private JCheckBox chckbxCivilit;
	private JCheckBox chckbxCodepostal;
	private JCheckBox chckbxDateDeNaissance;
	private JCheckBox chckbxEmail;
	private JCheckBox chckbxMagasinDeReference;
	private JCheckBox chckbxNCarteDe;
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
	private String desktopPath;
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
	private JLabel label_8;
	private JLayeredPane layeredPane;
	private JLabel lblEmailingParMagasin;

	private JLabel lblExportCvs;
	private JLabel lblExportxls;
	private JLabel lblFermer;
	private JLabel lblMerciDeChoisir;
	private JLabel lblMerciDeSlectionner_1;
	private JLabel lblNewLabel;
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

	public EmailingAnniversaire(final JFrame interfacepre) {
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
							EmailingAnniversaire.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingAnniversaire.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(871, 312, 181, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(336, 312, 116, 23);
			this.chckbxAdresse.setSelected(true);
		}
		return this.chckbxAdresse;
	}

	private JCheckBox getChckbxAge() {
		if (this.chckbxAge == null) {
			this.chckbxAge = new JCheckBox("Age");
			this.chckbxAge.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAge.setForeground(Color.GRAY);
			this.chckbxAge.setBounds(597, 338, 156, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(238, 312, 96, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(336, 364, 116, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxDateDeNaissance.setForeground(Color.GRAY);
			this.chckbxDateDeNaissance
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxDateDeNaissance.setBounds(454, 312, 143, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(454, 338, 143, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(871, 338, 181, 23);
			this.chckbxMagasinDeReference.setSelected(true);
		}
		return this.chckbxMagasinDeReference;
	}

	private JCheckBox getChckbxNCarteDe() {
		if (this.chckbxNCarteDe == null) {
			this.chckbxNCarteDe = new JCheckBox(
					"N\u00B0 Carte de Fid\u00E9lit\u00E9");
			this.chckbxNCarteDe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNCarteDe.setForeground(Color.GRAY);
			this.chckbxNCarteDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNCarteDe.setBounds(597, 312, 156, 23);
			this.chckbxNCarteDe.setSelected(true);
		}
		return this.chckbxNCarteDe;
	}

	private JCheckBox getChckbxNom() {
		if (this.chckbxNom == null) {
			this.chckbxNom = new JCheckBox("Nom");
			this.chckbxNom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(238, 338, 96, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(238, 364, 96, 23);
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

							if (EmailingAnniversaire.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingAnniversaire.this.table_3.selectAll();
								EmailingAnniversaire.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(238, 658, 256, 23);
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
			this.chckbxSurLensembleDes.setBounds(238, 237, 200, 23);
			this.chckbxSurLensembleDes.setSelected(false);
			this.chckbxSurLensembleDes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (EmailingAnniversaire.this.chckbxSurLensembleDes
							.isSelected() != true) {

						EmailingAnniversaire.this.comboBox_1.setVisible(true);
						EmailingAnniversaire.this.comboBox_1.setEnabled(true);
						// lblMerciDeSlectionner_1.setVisible(true);
						EmailingAnniversaire.this.lblValider.setVisible(false);
						EmailingAnniversaire.this.etatbouton = false;
						EmailingAnniversaire.this.lblOu.setVisible(true);
					} else

					{
						EmailingAnniversaire.this.comboBox_1.setVisible(false);
						EmailingAnniversaire.this.comboBox_1.setEnabled(false);

						EmailingAnniversaire.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAnniversaire.this.lblValider.setVisible(true);
						EmailingAnniversaire.this.etatbouton = true;
						EmailingAnniversaire.this.lblOu.setVisible(false);

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

					EmailingAnniversaire.this.chckbxNom.setSelected(false);
					EmailingAnniversaire.this.chckbxPrnom.setSelected(false);
					EmailingAnniversaire.this.chckbxCivilit.setSelected(false);
					EmailingAnniversaire.this.chckbxAdresse.setSelected(false);
					EmailingAnniversaire.this.chckbxCodepostal
							.setSelected(false);
					EmailingAnniversaire.this.chckbxVille.setSelected(false);
					EmailingAnniversaire.this.chckbxEmail.setSelected(false);
					EmailingAnniversaire.this.checkBox.setSelected(false);
					EmailingAnniversaire.this.checkBox_1.setSelected(false);
					EmailingAnniversaire.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingAnniversaire.this.chckbxNCarteDe.setSelected(false);
					EmailingAnniversaire.this.chckbxDateDeNaissance
							.setSelected(false);
					EmailingAnniversaire.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxAge.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(238, 408, 156, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAnniversaire.this.chckbxNom.setSelected(true);
					EmailingAnniversaire.this.chckbxPrnom.setSelected(true);
					EmailingAnniversaire.this.chckbxCivilit.setSelected(true);
					EmailingAnniversaire.this.chckbxAdresse.setSelected(true);
					EmailingAnniversaire.this.chckbxCodepostal
							.setSelected(true);
					EmailingAnniversaire.this.chckbxVille.setSelected(true);
					EmailingAnniversaire.this.checkBox.setSelected(true);
					EmailingAnniversaire.this.checkBox_1.setSelected(true);
					EmailingAnniversaire.this.chckbxEmail.setSelected(true);
					EmailingAnniversaire.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingAnniversaire.this.chckbxNCarteDe.setSelected(true);
					EmailingAnniversaire.this.chckbxDateDeNaissance
							.setSelected(true);
					EmailingAnniversaire.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxAge.setSelected(true);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(413, 408, 160, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(336, 338, 116, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(755, 338, 103, 23);
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
					EmailingAnniversaire.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAnniversaire.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(755, 312, 103, 23);
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
					EmailingAnniversaire.this.selectioncomboBox = EmailingAnniversaire.this.comboBox
							.getSelectedItem().toString().substring(1);

					switch (EmailingAnniversaire.this.selectioncomboBox) {
					case "Janvier":
						EmailingAnniversaire.this.valeurCasechoix = "01";
						break;
					case "Fevrier":
						EmailingAnniversaire.this.valeurCasechoix = "02";
						break;
					case "Mars":
						EmailingAnniversaire.this.valeurCasechoix = "03";
						break;
					case "Avril":
						EmailingAnniversaire.this.valeurCasechoix = "04";
						break;
					case "Mai":
						EmailingAnniversaire.this.valeurCasechoix = "05";
						break;
					case "Juin":
						EmailingAnniversaire.this.valeurCasechoix = "06";
						break;
					case "Juillet":
						EmailingAnniversaire.this.valeurCasechoix = "07";
						break;
					case "Août":
						EmailingAnniversaire.this.valeurCasechoix = "08";
						break;
					case "Septembre":
						EmailingAnniversaire.this.valeurCasechoix = "09";
						break;
					case "Octobre":
						EmailingAnniversaire.this.valeurCasechoix = "10";
						break;
					case "Novembre":
						EmailingAnniversaire.this.valeurCasechoix = "11";
						break;
					case "Décembre":
						EmailingAnniversaire.this.valeurCasechoix = "12";
						break;
					}
					System.out.print("mois "
							+ EmailingAnniversaire.this.valeurCasechoix + "\n");
				}
			});
			this.comboBox.setBounds(618, 185, 181, 22);
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
						EmailingAnniversaire.this.selectionIDMagasin = ((Magasin) EmailingAnniversaire.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						EmailingAnniversaire.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAnniversaire.this.lblValider.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAnniversaire.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);
						EmailingAnniversaire.this.interfaceActuelle
								.setVisible(false);
						EmailingAnniversaire.this.lblValider.setVisible(false);
						EmailingAnniversaire.this.lblValider.setEnabled(false);
						EmailingAnniversaire.this.chckbxAge.setSelected(true);
						EmailingAnniversaire.this.chckbxNom.setSelected(true);
						EmailingAnniversaire.this.chckbxPrnom.setSelected(true);
						EmailingAnniversaire.this.chckbxCivilit
								.setSelected(true);
						EmailingAnniversaire.this.chckbxAdresse
								.setSelected(true);
						EmailingAnniversaire.this.chckbxCodepostal
								.setSelected(true);
						EmailingAnniversaire.this.chckbxVille.setSelected(true);
						EmailingAnniversaire.this.chckbxEmail.setSelected(true);
						EmailingAnniversaire.this.checkBox.setSelected(true);
						EmailingAnniversaire.this.checkBox_1.setSelected(true);
						EmailingAnniversaire.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingAnniversaire.this.chckbxNCarteDe
								.setSelected(true);
						EmailingAnniversaire.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingAnniversaire.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingAnniversaire.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAnniversaire.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingAnniversaire.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingAnniversaire.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingAnniversaire.this.lblExportxls
								.setVisible(false);
						EmailingAnniversaire.this.lblExportCvs
								.setVisible(false);
						if ((EmailingAnniversaire.this.table_3.getRowCount() != 0)
								&& (EmailingAnniversaire.this.table_3
										.getColumnCount() != 0)) {
							EmailingAnniversaire.this.model.setColumnCount(0);
							EmailingAnniversaire.this.model.setRowCount(0);
							EmailingAnniversaire.this.table_3
									.setModel(EmailingAnniversaire.this.model);
							EmailingAnniversaire.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox_1.setVisible(true);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(518, 237, 516, 22);
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
			this.fond.setIcon(new ImageIcon(EmailingAnniversaire.class
					.getResource("/Images/menus-extraction-long.png")));
			this.fond.setBounds(216, 55, 850, 690);
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
					EmailingAnniversaire.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(238, 55, 114, 44);
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
					EmailingAnniversaire.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(347, 55, 114, 44);
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
					EmailingAnniversaire.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(459, 55, 114, 44);
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
					EmailingAnniversaire.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(573, 55, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_8() {
		if (this.label_8 == null) {
			this.label_8 = new JLabel(
					"(CTRL+C ou Pomme+C pour copier les donn\u00E9es)");
			this.label_8.setForeground(Color.GRAY);
			this.label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_8.setBounds(238, 689, 313, 14);
		}
		return this.label_8;
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
			this.layeredPane.add(this.getChckbxNCarteDe());
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
			this.layeredPane.add(this.getLabel_8());

			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"Tri Par tranche date d'anniversaire (Clients  titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(238, 109, 449, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(EmailingAnniversaire.class
					.getResource("/Images/export-csv.png")));
			this.lblExportCvs.setVisible(false);
			this.lblExportCvs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					try {
						final String os = System.getProperty("os.name")
								.toLowerCase();
						;
						if (os.contains("mac")) {
							EmailingAnniversaire.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingAnniversaire.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingAnniversaire.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par anniversaire (titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingAnniversaire.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EmailingAnniversaire.this.entetes.length - 1); i++) {
								if (EmailingAnniversaire.this.donnees[j][i] != null) {
									writer.append(EmailingAnniversaire.this.donnees[j][i]
											.toString());
									if (i == (EmailingAnniversaire.this.entetes.length - 1)) {
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

						EmailingAnniversaire.this.Message = "Exportation du fichier Extraction par anniversaire (titulaire carte).csv réalisée avec succès";
						EmailingAnniversaire.this.etat = true;
						EmailingAnniversaire.this.choixformat = "CSV2";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaire.this.Message,
								EmailingAnniversaire.this.interfaceActuelle,
								EmailingAnniversaire.this.etat,
								EmailingAnniversaire.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingAnniversaire.this.Message = "Impossible de générer le fichier CSV";
						EmailingAnniversaire.this.etat = false;
						EmailingAnniversaire.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaire.this.Message,
								EmailingAnniversaire.this.interfaceActuelle,
								EmailingAnniversaire.this.etat,
								EmailingAnniversaire.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(901, 680, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(EmailingAnniversaire.class
					.getResource("/Images/export-excel.png")));
			this.lblExportxls.setVisible(false);
			this.lblExportxls.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportxls.setForeground(Color.GRAY);
			this.lblExportxls.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					try {

						final String os = System.getProperty("os.name")
								.toLowerCase();
						;
						if (os.contains("mac")) {
							EmailingAnniversaire.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingAnniversaire.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingAnniversaire.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par anniversaire (titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(EmailingAnniversaire.this.table_3, file);
						EmailingAnniversaire.this.etat = true;
						EmailingAnniversaire.this.Message = "Exportation du fichier Extraction par anniversaire (titulaire carte).xls réalisée avec succès";
						EmailingAnniversaire.this.choixformat = "XLS2";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaire.this.Message,
								EmailingAnniversaire.this.interfaceActuelle,
								EmailingAnniversaire.this.etat,
								EmailingAnniversaire.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingAnniversaire.this.etat = false;
						EmailingAnniversaire.this.choixformat = "XLS";
						EmailingAnniversaire.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingAnniversaire.this.Message,
								EmailingAnniversaire.this.interfaceActuelle,
								EmailingAnniversaire.this.etat,
								EmailingAnniversaire.this.choixformat);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(742, 686, 133, 28);
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
					EmailingAnniversaire.this.dispose();
					EmailingAnniversaire.this.interfacePrecedente
							.setVisible(true);
					EmailingAnniversaire.this.interfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(874, 55, 178, 43);
		}
		return this.lblFermer;
	}

	private JLabel getLblMerciDeChoisir() {
		if (this.lblMerciDeChoisir == null) {
			this.lblMerciDeChoisir = new JLabel(
					"Extraire les dates anniversaires pour :");
			this.lblMerciDeChoisir.setForeground(Color.GRAY);
			this.lblMerciDeChoisir.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeChoisir.setBounds(238, 151, 256, 14);
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
			this.lblMerciDeSlectionner_1.setBounds(684, 241, 191, 14);
			this.lblMerciDeSlectionner_1.setEnabled(true);

		}
		return this.lblMerciDeSlectionner_1;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(EmailingAnniversaire.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblOu() {
		if (this.lblOu == null) {
			this.lblOu = new JLabel("Ou");
			this.lblOu.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOu.setForeground(Color.GRAY);
			this.lblOu.setBounds(459, 241, 35, 14);
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
			this.lblSelectionnerLesInformations.setBounds(238, 291, 256, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(EmailingAnniversaire.class
					.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingAnniversaire.this.checkBox.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.checkBox_1.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxCivilit.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxNom.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxPrnom.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxAdresse.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxVille.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxCodepostal.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxDateDeNaissance
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxEmail.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxNCarteDe.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAnniversaire.this.chckbxAge.isSelected() == true) {

						compteur++;
					}

					if (compteur > 4) {
						EmailingAnniversaire.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingAnniversaire.this.membres = Select
							.eMailinganniversaire(
									EmailingAnniversaire.this.valeurCasechoix,
									EmailingAnniversaire.this.selectionIDMagasin,
									EmailingAnniversaire.this.etatbouton);

					if (EmailingAnniversaire.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAnniversaire.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);
						EmailingAnniversaire.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAnniversaire.this.lblValider.setVisible(false);

						if ((EmailingAnniversaire.this.table_3.getRowCount() != 0)
								|| (EmailingAnniversaire.this.table_3
										.getColumnCount() != 0)) {
							EmailingAnniversaire.this.model.setColumnCount(0);
							EmailingAnniversaire.this.model.setRowCount(0);
							EmailingAnniversaire.this.table_3
									.setModel(EmailingAnniversaire.this.model);
							EmailingAnniversaire.this.table_3.repaint();
						}
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAnniversaire.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAnniversaire.this.interfaceActuelle
								.setEnabled(false);
						EmailingAnniversaire.this.interfaceActuelle
								.setVisible(false);
						EmailingAnniversaire.this.lblValider.setVisible(false);

					} else

					{

						EmailingAnniversaire.this.entetes = new String[compteur];

						EmailingAnniversaire.this.donnees = new Object[EmailingAnniversaire.this.membres
								.size()][EmailingAnniversaire.this.entetes.length];

						for (int j = 0; j < EmailingAnniversaire.this.membres
								.size(); j++) {

							for (int i = 0; i < (EmailingAnniversaire.this.entetes.length - 1); i++) {

								if (EmailingAnniversaire.this.chckbxCivilit
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Civilité";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingAnniversaire.this.chckbxNom
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Nom";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getNomIndividu().toUpperCase();
									i++;

								}
								if (EmailingAnniversaire.this.chckbxPrnom
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Prénom";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getPrenomIndividu().toLowerCase();
									i++;

								}
								if (EmailingAnniversaire.this.chckbxAdresse
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Adresse";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingAnniversaire.this.chckbxVille
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Ville";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingAnniversaire.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Code Postal";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}
								if (EmailingAnniversaire.this.chckbxDateDeNaissance
										.isSelected() == true) {
									if (EmailingAnniversaire.this.membres
											.get(j).getDateNaissanceIndividu() != null) {
										EmailingAnniversaire.this.entetes[i] = "Date de Naissance";
										EmailingAnniversaire.this.donnees[j][i] = ""
												+ EmailingAnniversaire.this.membres
														.get(j)
														.getDateNaissanceIndividu();
										i++;
									} else {
										EmailingAnniversaire.this.entetes[i] = "Date de Naissance";
										EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
												.get(j)
												.getDateNaissanceIndividu();
										i++;
									}
								}
								if (EmailingAnniversaire.this.chckbxAge
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Age";
									/*
									 * Calendar now = Calendar.getInstance();
									 * int year=now.get(Calendar.YEAR);
									 * System.out.print("/////"+year+"\n");
									 * String datenai=
									 * membres.get(j).getDateNaissanceIndividu
									 * ();
									 *
									 *
									 * System.out.print("/////"+datenai+"\n");
									 *
									 * String[] str=datenai.split("/"); String
									 * year2=str[2]; int
									 * AnneeNaissance=Integer.valueOf(year2);
									 * System
									 * .out.print("/////"+AnneeNaissance+"\n");
									 * int ageclient=year-AnneeNaissance;
									 */
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EmailingAnniversaire.this.chckbxEmail
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Adresse Mail";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingAnniversaire.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Newsletter";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}
								if (EmailingAnniversaire.this.chckbxNCarteDe
										.isSelected() == true) {
									if (EmailingAnniversaire.this.membres
											.get(j).getNumerocarte() != null) {
										EmailingAnniversaire.this.entetes[i] = "N°Client";
										EmailingAnniversaire.this.donnees[j][i] = ""
												+ EmailingAnniversaire.this.membres
														.get(j)
														.getNumerocarte();
										i++;
									} else {
										EmailingAnniversaire.this.entetes[i] = "N°Client";
										EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
												.get(j).getNumerocarte();
										i++;

									}
								}
								if (EmailingAnniversaire.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingAnniversaire.this.entetes[i] = "Magasin";
									EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingAnniversaire.this.checkBox
										.isSelected() == true) {
									if (EmailingAnniversaire.this.membres
											.get(j).getTelephonefixe() != null) {
										EmailingAnniversaire.this.entetes[i] = "Téléphone";
										EmailingAnniversaire.this.donnees[j][i] = ""
												+ EmailingAnniversaire.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EmailingAnniversaire.this.entetes[i] = "Téléphone";
										EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
												.get(j).getTelephonefixe();
										i++;
									}

								}
								if (EmailingAnniversaire.this.checkBox_1
										.isSelected() == true) {
									if (EmailingAnniversaire.this.membres
											.get(j).getTelephonemobile() != null) {
										EmailingAnniversaire.this.entetes[i] = "Mobile";
										EmailingAnniversaire.this.donnees[j][i] = ""
												+ EmailingAnniversaire.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EmailingAnniversaire.this.entetes[i] = "Mobile";
										EmailingAnniversaire.this.donnees[j][i] = EmailingAnniversaire.this.membres
												.get(j).getTelephonemobile();
										i++;
									}

								}

							}

						}

						if (EmailingAnniversaire.this.membres.size() != 0) {

							EmailingAnniversaire.this.model = new DefaultTableModel(
									EmailingAnniversaire.this.donnees,
									EmailingAnniversaire.this.entetes);

							EmailingAnniversaire.this.table_3
									.setModel(EmailingAnniversaire.this.model);

						}

					}

					EmailingAnniversaire.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingAnniversaire.this.lblExportxls.setVisible(true);
					EmailingAnniversaire.this.lblExportCvs.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(935, 408, 99, 23);
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

							if (EmailingAnniversaire.this.rdbtnAnniversaireAujourdhui
									.isSelected()) {
								EmailingAnniversaire.this.comboBox
										.setEnabled(false);
								final String format = "MM/dd";

								final SimpleDateFormat formater = new java.text.SimpleDateFormat(
										format);
								final Date date = new java.util.Date();
								EmailingAnniversaire.this.valeurCasechoix = formater
										.format(date);
								System.out
										.print(EmailingAnniversaire.this.valeurCasechoix);
							}
						}
					});
			this.rdbtnAnniversaireAujourdhui.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.rdbtnAnniversaireAujourdhui.setForeground(Color.GRAY);
			this.rdbtnAnniversaireAujourdhui.setBounds(238, 185, 114, 23);
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
							if (EmailingAnniversaire.this.rdbtnAnniversaireCeMois
									.isSelected()) {
								EmailingAnniversaire.this.comboBox
										.setEnabled(false);
								final Calendar now = Calendar.getInstance();
								final int mois = now.get(Calendar.MONTH) + 1;

								switch (mois) {
								case 1:
									EmailingAnniversaire.this.valeurCasechoix = "01";
									break;
								case 2:
									EmailingAnniversaire.this.valeurCasechoix = "02";
									break;
								case 3:
									EmailingAnniversaire.this.valeurCasechoix = "03";
									break;
								case 4:
									EmailingAnniversaire.this.valeurCasechoix = "04";
									break;
								case 5:
									EmailingAnniversaire.this.valeurCasechoix = "05";
									break;
								case 6:
									EmailingAnniversaire.this.valeurCasechoix = "06";
									break;
								case 7:
									EmailingAnniversaire.this.valeurCasechoix = "07";
									break;
								case 8:
									EmailingAnniversaire.this.valeurCasechoix = "08";
									break;
								case 9:
									EmailingAnniversaire.this.valeurCasechoix = "09";
									break;
								case 10:
									EmailingAnniversaire.this.valeurCasechoix = "10";
									break;
								case 11:
									EmailingAnniversaire.this.valeurCasechoix = "11";
									break;
								case 12:
									EmailingAnniversaire.this.valeurCasechoix = "12";
									break;
								}
								System.out
										.print("mois "
												+ EmailingAnniversaire.this.valeurCasechoix
												+ "\n");

							}
						}
					});
			this.rdbtnAnniversaireCeMois.setForeground(Color.GRAY);
			this.rdbtnAnniversaireCeMois.setBounds(365, 185, 121, 23);
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
					EmailingAnniversaire.this.comboBox.setEnabled(true);

				}
			});
			this.rdbtnPersonnalis.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnPersonnalis.setForeground(Color.GRAY);
			this.rdbtnPersonnalis.setBounds(488, 185, 121, 23);
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

							if (EmailingAnniversaire.this.rdbtnTousLesAnniversaire
									.isSelected()) {
								EmailingAnniversaire.this.comboBox
										.setEnabled(false);
								EmailingAnniversaire.this.valeurCasechoix = EmailingAnniversaire.this.rdbtnTousLesAnniversaire
										.getText().toUpperCase();
							}

						}
					});
			this.rdbtnTousLesAnniversaire.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.rdbtnTousLesAnniversaire.setForeground(Color.GRAY);
			this.rdbtnTousLesAnniversaire.setBounds(831, 185, 71, 23);
			this.group.add(this.rdbtnTousLesAnniversaire);
		}
		return this.rdbtnTousLesAnniversaire;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(238, 458, 796, 193);
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
