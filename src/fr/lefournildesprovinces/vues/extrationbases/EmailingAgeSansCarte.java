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
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.util.ExcelExporter;
import fr.lefournildesprovinces.vues.MessageExport;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class EmailingAgeSansCarte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1396355761524848072L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
	private JCheckBox chckbxAge;
	private JCheckBox chckbxCivilit;
	private JCheckBox chckbxCodepostal;
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
	private JComboBox<Object> comboBox_1;
	private final JPanel contentPane;
	private String desktopPath;
	private Object[][] donnees;
	private String[] entetes;
	private boolean etat;
	private boolean etatbouton = true;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLayeredPane layeredPane;
	private JLabel lblAgeMaximum;
	private JLabel lblAgeMinimum;
	private JLabel lblEmailingParMagasin;

	private JLabel lblExportCvs;
	private JLabel lblExportxls;
	private JLabel lblFermer;
	private JLabel lblMerciDeSlectionner;
	private JLabel lblMerciDeSlectionner_1;
	private JLabel lblNewLabel;
	private JLabel lblSelectionnerLesInformations;
	private JLabel lblValider;
	private ComboBoxModel<Object> listemagasins;
	private Vector<ResultatRecherche> membres;
	private String Message;
	private DefaultTableModel model;
	private JScrollPane scrollPane_1;
	private int selectionIDMagasin;
	private JSlider slider;
	private JSlider slider_1;
	private JTable table_3;
	private int valuemax;
	private int valuemin;

	public EmailingAgeSansCarte(final JFrame interfacepre) {
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
		this.interfaceActuelle = this;
		this.interfacePrecedente = interfacepre;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JCheckBox getChckbxAbonnementNewsletter() {
		if (this.chckbxAbonnementNewsletter == null) {
			this.chckbxAbonnementNewsletter = new JCheckBox(
					"Abonnement Newsletter");
			this.chckbxAbonnementNewsletter
					.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(final MouseEvent e) {
							EmailingAgeSansCarte.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingAgeSansCarte.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(558, 340, 195, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(347, 340, 95, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAge.setForeground(Color.GRAY);
			this.chckbxAge.setBounds(459, 340, 75, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(242, 314, 89, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(877, 340, 116, 23);
			this.chckbxCodepostal.setSelected(true);
		}
		return this.chckbxCodepostal;
	}

	private JCheckBox getChckbxEmail() {
		if (this.chckbxEmail == null) {
			this.chckbxEmail = new JCheckBox("eMail");
			this.chckbxEmail.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(877, 314, 116, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(558, 314, 180, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(242, 340, 89, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(347, 314, 95, 23);
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

							if (EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingAgeSansCarte.this.table_3.selectAll();
								EmailingAgeSansCarte.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(242, 658, 266, 23);
		}
		return this.chckbxSelectionnerLensembleDes;
	}

	private JCheckBox getChckbxSurLensembleDes() {
		if (this.chckbxSurLensembleDes == null) {
			this.chckbxSurLensembleDes = new JCheckBox(
					"Sur l'ensemble des magasins");

			this.chckbxSurLensembleDes.setVisible(false);

			this.chckbxSurLensembleDes
					.setFont(new Font("Tahoma", Font.BOLD, 11));

			this.chckbxSurLensembleDes.setForeground(Color.GRAY);
			this.chckbxSurLensembleDes.setBounds(242, 234, 200, 23);
			this.chckbxSurLensembleDes.setSelected(false);
			this.chckbxSurLensembleDes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (EmailingAgeSansCarte.this.chckbxSurLensembleDes
							.isSelected() != true) {

						EmailingAgeSansCarte.this.comboBox_1.setVisible(true);
						EmailingAgeSansCarte.this.comboBox_1.setEnabled(true);
						// lblMerciDeSlectionner_1.setVisible(true);
						EmailingAgeSansCarte.this.lblValider.setVisible(false);
						EmailingAgeSansCarte.this.etatbouton = false;
						EmailingAgeSansCarte.this.label_4.setVisible(true);

					} else

					{
						EmailingAgeSansCarte.this.comboBox_1.setVisible(false);
						EmailingAgeSansCarte.this.comboBox_1.setEnabled(false);
						EmailingAgeSansCarte.this.label_4.setVisible(false);
						EmailingAgeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setVisible(true);
						EmailingAgeSansCarte.this.etatbouton = true;

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

					EmailingAgeSansCarte.this.chckbxNom.setSelected(false);
					EmailingAgeSansCarte.this.chckbxPrnom.setSelected(false);
					EmailingAgeSansCarte.this.chckbxCivilit.setSelected(false);
					EmailingAgeSansCarte.this.chckbxAdresse.setSelected(false);
					EmailingAgeSansCarte.this.chckbxCodepostal
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxVille.setSelected(false);
					EmailingAgeSansCarte.this.chckbxEmail.setSelected(false);
					EmailingAgeSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingAgeSansCarte.this.checkBox.setSelected(false);
					EmailingAgeSansCarte.this.checkBox_1.setSelected(false);

					EmailingAgeSansCarte.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxAge.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(242, 412, 165, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAgeSansCarte.this.chckbxNom.setSelected(true);
					EmailingAgeSansCarte.this.chckbxPrnom.setSelected(true);
					EmailingAgeSansCarte.this.chckbxCivilit.setSelected(true);
					EmailingAgeSansCarte.this.chckbxAdresse.setSelected(true);
					EmailingAgeSansCarte.this.chckbxCodepostal
							.setSelected(true);
					EmailingAgeSansCarte.this.chckbxVille.setSelected(true);
					EmailingAgeSansCarte.this.chckbxEmail.setSelected(true);
					EmailingAgeSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingAgeSansCarte.this.checkBox.setSelected(true);
					EmailingAgeSansCarte.this.checkBox_1.setSelected(true);

					EmailingAgeSansCarte.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxAge.setSelected(true);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(409, 412, 164, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(459, 314, 75, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(755, 340, 104, 23);
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
					EmailingAgeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingAgeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(755, 314, 104, 23);
			this.checkBox_1.setSelected(true);
		}
		return this.checkBox_1;
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
						EmailingAgeSansCarte.this.selectionIDMagasin = ((Magasin) EmailingAgeSansCarte.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						EmailingAgeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAgeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setEnabled(false);
						EmailingAgeSansCarte.this.chckbxAge.setSelected(true);
						EmailingAgeSansCarte.this.chckbxNom.setSelected(true);
						EmailingAgeSansCarte.this.chckbxPrnom.setSelected(true);
						EmailingAgeSansCarte.this.chckbxCivilit
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxAdresse
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxCodepostal
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxVille.setSelected(true);
						EmailingAgeSansCarte.this.chckbxEmail.setSelected(true);
						EmailingAgeSansCarte.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingAgeSansCarte.this.checkBox.setSelected(true);
						EmailingAgeSansCarte.this.checkBox_1.setSelected(true);

						EmailingAgeSansCarte.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAgeSansCarte.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingAgeSansCarte.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingAgeSansCarte.this.lblExportxls
								.setVisible(false);
						EmailingAgeSansCarte.this.lblExportCvs
								.setVisible(false);
						if ((EmailingAgeSansCarte.this.table_3.getRowCount() != 0)
								&& (EmailingAgeSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingAgeSansCarte.this.model.setColumnCount(0);
							EmailingAgeSansCarte.this.model.setRowCount(0);
							EmailingAgeSansCarte.this.table_3
									.setModel(EmailingAgeSansCarte.this.model);
							EmailingAgeSansCarte.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox_1.setVisible(false);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(496, 234, 534, 22);
			this.comboBox_1.setEnabled(false);
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
			this.fond.setIcon(new ImageIcon(EmailingAgeSansCarte.class
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
					EmailingAgeSansCarte.this.dispose();
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
					EmailingAgeSansCarte.this.dispose();
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
					EmailingAgeSansCarte.this.dispose();
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
					EmailingAgeSansCarte.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(573, 55, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("Ou");
			this.label_4.setVisible(false);
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(457, 238, 22, 14);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel(
					"(CTRL+C ou Pomme+C pour copier les donn\u00E9es)");
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setBounds(242, 690, 315, 14);
		}
		return this.label_5;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblAgeMinimum());
			this.layeredPane.add(this.getLblAgeMaximum());
			this.layeredPane.add(this.getLblMerciDeSlectionner());
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
			this.layeredPane.add(this.getSlider_1());
			this.layeredPane.add(this.getSlider_1_1());
			this.layeredPane.add(this.getChckbxAge());
			this.layeredPane.add(this.getCheckBox());
			this.layeredPane.add(this.getCheckBox_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLblAgeMaximum() {
		if (this.lblAgeMaximum == null) {
			this.lblAgeMaximum = new JLabel("Age Maximum : 18");
			this.lblAgeMaximum.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAgeMaximum.setForeground(Color.GRAY);
			this.lblAgeMaximum.setBounds(586, 194, 129, 14);

		}
		return this.lblAgeMaximum;
	}

	private JLabel getLblAgeMinimum() {
		if (this.lblAgeMinimum == null) {
			this.lblAgeMinimum = new JLabel("Age Minimum : 18");
			this.lblAgeMinimum.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAgeMinimum.setForeground(Color.GRAY);
			this.lblAgeMinimum.setBounds(292, 194, 124, 14);

		}
		return this.lblAgeMinimum;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"Tri Par tranche d'\u00E2ge (Clients non titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 109, 389, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(EmailingAgeSansCarte.class
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
							EmailingAgeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingAgeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingAgeSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par age (non titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingAgeSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EmailingAgeSansCarte.this.entetes.length - 1); i++) {
								if (EmailingAgeSansCarte.this.donnees[j][i] != null) {
									writer.append(EmailingAgeSansCarte.this.donnees[j][i]
											.toString());
									if (i == (EmailingAgeSansCarte.this.entetes.length - 1)) {
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

						EmailingAgeSansCarte.this.Message = "Exportation du fichier Extraction par age (non titulaire carte).csv réalisée avec succès";
						EmailingAgeSansCarte.this.etat = true;
						EmailingAgeSansCarte.this.choixformat = "CSV1";
						final MessageExport fenetre = new MessageExport(
								EmailingAgeSansCarte.this.Message,
								EmailingAgeSansCarte.this.interfaceActuelle,
								EmailingAgeSansCarte.this.etat,
								EmailingAgeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingAgeSansCarte.this.Message = "Impossible de générer le fichier CSV";
						EmailingAgeSansCarte.this.etat = false;
						EmailingAgeSansCarte.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingAgeSansCarte.this.Message,
								EmailingAgeSansCarte.this.interfaceActuelle,
								EmailingAgeSansCarte.this.etat,
								EmailingAgeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(894, 670, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(EmailingAgeSansCarte.class
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
							EmailingAgeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingAgeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingAgeSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par age (non titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(EmailingAgeSansCarte.this.table_3, file);
						EmailingAgeSansCarte.this.etat = true;
						EmailingAgeSansCarte.this.Message = "Exportation du fichier Extraction par age (non titulaire carte).xls réalisée avec succès";
						EmailingAgeSansCarte.this.choixformat = "XLS1";
						final MessageExport fenetre = new MessageExport(
								EmailingAgeSansCarte.this.Message,
								EmailingAgeSansCarte.this.interfaceActuelle,
								EmailingAgeSansCarte.this.etat,
								EmailingAgeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingAgeSansCarte.this.etat = false;
						EmailingAgeSansCarte.this.choixformat = "XLS";
						EmailingAgeSansCarte.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingAgeSansCarte.this.Message,
								EmailingAgeSansCarte.this.interfaceActuelle,
								EmailingAgeSansCarte.this.etat,
								EmailingAgeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(726, 676, 133, 28);
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
					EmailingAgeSansCarte.this.dispose();
					EmailingAgeSansCarte.this.interfacePrecedente
							.setVisible(true);
					EmailingAgeSansCarte.this.interfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(874, 55, 163, 43);
		}
		return this.lblFermer;
	}

	private JLabel getLblMerciDeSlectionner() {
		if (this.lblMerciDeSlectionner == null) {
			this.lblMerciDeSlectionner = new JLabel(
					"Merci de s\u00E9lectionner une tranche d'\u00E2ge");
			this.lblMerciDeSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSlectionner.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner.setBounds(242, 146, 237, 14);
		}
		return this.lblMerciDeSlectionner;
	}

	private JLabel getLblMerciDeSlectionner_1() {
		if (this.lblMerciDeSlectionner_1 == null) {
			this.lblMerciDeSlectionner_1 = new JLabel(
					"Merci de s\u00E9lectionner un magasin");
			this.lblMerciDeSlectionner_1.setVisible(false);
			this.lblMerciDeSlectionner_1.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner_1.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblMerciDeSlectionner_1.setBounds(650, 238, 209, 14);
			this.lblMerciDeSlectionner_1.setEnabled(true);

		}
		return this.lblMerciDeSlectionner_1;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(EmailingAgeSansCarte.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblSelectionnerLesInformations() {
		if (this.lblSelectionnerLesInformations == null) {
			this.lblSelectionnerLesInformations = new JLabel(
					"Selectionner les informations souhait\u00E9es");
			this.lblSelectionnerLesInformations.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblSelectionnerLesInformations.setForeground(Color.GRAY);
			this.lblSelectionnerLesInformations.setBounds(242, 279, 266, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(EmailingAgeSansCarte.class
					.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;

					if (EmailingAgeSansCarte.this.checkBox.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.checkBox_1.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxCivilit.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxNom.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxPrnom.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxAdresse.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxVille.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxCodepostal.isSelected() == true) {

						compteur++;
					}

					if (EmailingAgeSansCarte.this.chckbxEmail.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}

					if (EmailingAgeSansCarte.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAgeSansCarte.this.chckbxAge.isSelected() == true) {

						compteur++;
					}

					if (compteur > 4) {
						EmailingAgeSansCarte.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingAgeSansCarte.this.membres = Select
							.eMailingTrancheAgeSansCarte(
									EmailingAgeSansCarte.this.valuemin,
									EmailingAgeSansCarte.this.valuemax,
									EmailingAgeSansCarte.this.selectionIDMagasin,
									EmailingAgeSansCarte.this.etatbouton);

					if (EmailingAgeSansCarte.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAgeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAgeSansCarte.this.lblValider.setVisible(false);

						if ((EmailingAgeSansCarte.this.table_3.getRowCount() != 0)
								|| (EmailingAgeSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingAgeSansCarte.this.model.setColumnCount(0);
							EmailingAgeSansCarte.this.model.setRowCount(0);
							EmailingAgeSansCarte.this.table_3
									.setModel(EmailingAgeSansCarte.this.model);
							EmailingAgeSansCarte.this.table_3.repaint();
						}
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAgeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setVisible(false);

						EmailingAgeSansCarte.this.lblMerciDeSlectionner
								.setVisible(true);

					} else

					{

						EmailingAgeSansCarte.this.entetes = new String[compteur];

						EmailingAgeSansCarte.this.donnees = new Object[EmailingAgeSansCarte.this.membres
								.size()][EmailingAgeSansCarte.this.entetes.length];

						for (int j = 0; j < EmailingAgeSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i < (EmailingAgeSansCarte.this.entetes.length - 1); i++) {

								if (EmailingAgeSansCarte.this.chckbxCivilit
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Civilité";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingAgeSansCarte.this.chckbxNom
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Nom";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getNomIndividu();
									i++;

								}
								if (EmailingAgeSansCarte.this.chckbxPrnom
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Prénom";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getPrenomIndividu();
									i++;

								}
								if (EmailingAgeSansCarte.this.chckbxAdresse
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Adresse";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingAgeSansCarte.this.chckbxVille
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Ville";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingAgeSansCarte.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Code Postal";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}

								if (EmailingAgeSansCarte.this.chckbxAge
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Age";
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
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EmailingAgeSansCarte.this.chckbxEmail
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Adresse Mail";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingAgeSansCarte.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Newsletter";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}

								if (EmailingAgeSansCarte.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingAgeSansCarte.this.entetes[i] = "Magasin";
									EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingAgeSansCarte.this.checkBox
										.isSelected() == true) {
									if (EmailingAgeSansCarte.this.membres
											.get(j).getTelephonefixe() != null) {
										EmailingAgeSansCarte.this.entetes[i] = "Téléphone";
										EmailingAgeSansCarte.this.donnees[j][i] = "'"
												+ EmailingAgeSansCarte.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EmailingAgeSansCarte.this.entetes[i] = "Téléphone";
										EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
												.get(j).getTelephonefixe();
										i++;
									}
								}
								if (EmailingAgeSansCarte.this.checkBox_1
										.isSelected() == true) {
									if (EmailingAgeSansCarte.this.membres
											.get(j).getTelephonemobile() != null) {
										EmailingAgeSansCarte.this.entetes[i] = "Mobile";
										EmailingAgeSansCarte.this.donnees[j][i] = "'"
												+ EmailingAgeSansCarte.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EmailingAgeSansCarte.this.entetes[i] = "Mobile";
										EmailingAgeSansCarte.this.donnees[j][i] = EmailingAgeSansCarte.this.membres
												.get(j).getTelephonemobile();
										i++;

									}

								}

							}

						}

						if (EmailingAgeSansCarte.this.membres.size() != 0) {

							EmailingAgeSansCarte.this.model = new DefaultTableModel(
									EmailingAgeSansCarte.this.donnees,
									EmailingAgeSansCarte.this.entetes);

							EmailingAgeSansCarte.this.table_3
									.setModel(EmailingAgeSansCarte.this.model);

						}

					}

					EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingAgeSansCarte.this.lblExportxls.setVisible(true);
					EmailingAgeSansCarte.this.lblExportCvs.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(888, 412, 142, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(242, 456, 790, 195);
			this.scrollPane_1.setViewportView(this.getTable_3());
		}
		return this.scrollPane_1;
	}

	private JSlider getSlider_1() {
		if (this.slider == null) {
			this.slider = new JSlider(SwingConstants.HORIZONTAL, 18, 100, 18);
			this.slider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {

					EmailingAgeSansCarte.this.valuemin = EmailingAgeSansCarte.this.slider
							.getValue();
					EmailingAgeSansCarte.this.slider_1
							.setValue(EmailingAgeSansCarte.this.valuemin);
					EmailingAgeSansCarte.this.lblAgeMinimum
							.setText("Age Minimum : "
									+ EmailingAgeSansCarte.this.valuemin);

				}

			});

			this.slider.setBounds(242, 171, 200, 23);
		}
		return this.slider;
	}

	private JSlider getSlider_1_1() {
		if (this.slider_1 == null) {
			this.slider_1 = new JSlider(SwingConstants.HORIZONTAL, 18, 100, 18);
			this.slider_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.slider_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(final MouseEvent arg0) {
					if (EmailingAgeSansCarte.this.valuemax >= EmailingAgeSansCarte.this.valuemin) {
						EmailingAgeSansCarte.this.lblValider.setVisible(true);
						EmailingAgeSansCarte.this.chckbxSurLensembleDes
								.setVisible(true);

						EmailingAgeSansCarte.this.label_4.setVisible(true);
						EmailingAgeSansCarte.this.comboBox_1.setVisible(true);
						EmailingAgeSansCarte.this.comboBox_1.setEnabled(true);

						EmailingAgeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(true);
						EmailingAgeSansCarte.this.lblValider.setVisible(false);
						EmailingAgeSansCarte.this.etatbouton = false;

					} else {
						final String message = "Age maximum < Age Minimum";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAgeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingAgeSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setVisible(false);
						EmailingAgeSansCarte.this.lblValider.setEnabled(false);
						EmailingAgeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAgeSansCarte.this.chckbxSurLensembleDes
								.setVisible(false);
						EmailingAgeSansCarte.this.comboBox_1.setVisible(false);

						EmailingAgeSansCarte.this.chckbxNom.setSelected(true);
						EmailingAgeSansCarte.this.chckbxPrnom.setSelected(true);
						EmailingAgeSansCarte.this.chckbxCivilit
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxAdresse
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxCodepostal
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxVille.setSelected(true);
						EmailingAgeSansCarte.this.chckbxEmail.setSelected(true);
						EmailingAgeSansCarte.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingAgeSansCarte.this.checkBox.setSelected(true);
						EmailingAgeSansCarte.this.checkBox_1.setSelected(true);

						EmailingAgeSansCarte.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingAgeSansCarte.this.chckbxAge.setSelected(true);

						EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAgeSansCarte.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingAgeSansCarte.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingAgeSansCarte.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingAgeSansCarte.this.lblExportxls
								.setVisible(false);
						EmailingAgeSansCarte.this.lblExportCvs
								.setVisible(false);
						if ((EmailingAgeSansCarte.this.table_3.getRowCount() != 0)
								&& (EmailingAgeSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingAgeSansCarte.this.model.setColumnCount(0);
							EmailingAgeSansCarte.this.model.setRowCount(0);
							EmailingAgeSansCarte.this.table_3
									.setModel(EmailingAgeSansCarte.this.model);
							EmailingAgeSansCarte.this.table_3.repaint();
						}
					}
				}
			});
			this.slider_1.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent e) {

					EmailingAgeSansCarte.this.valuemax = EmailingAgeSansCarte.this.slider_1
							.getValue();
					EmailingAgeSansCarte.this.lblAgeMaximum
							.setText("Age Maximum : "
									+ EmailingAgeSansCarte.this.valuemax);

				}
			});
			this.slider_1.setBounds(538, 171, 200, 23);

		}
		return this.slider_1;
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
