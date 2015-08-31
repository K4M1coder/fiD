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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.ressources.util.ExcelExporter;
import fr.lefournildesprovinces.vues.MessageExport;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class EmailingVille extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 3693514439799046063L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
	private JCheckBox chckbxCivilit;
	private JCheckBox chckbxCodepostal;
	private JCheckBox chckbxDateDeNaissance;
	private JCheckBox chckbxEmail;
	private JCheckBox chckbxMagasinDeReference;
	private JCheckBox chckbxNCarteDe;
	private JCheckBox chckbxNom;
	private JCheckBox chckbxPrnom;
	private JCheckBox chckbxSelectionnerLensembleDes;
	private JCheckBox chckbxToutDselectionner;
	private JCheckBox chckbxToutSlectionner;
	private JCheckBox chckbxVille;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private String choixformat;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private String desktopPath;
	private Object[][] donnees;
	private String[] entetes;
	private boolean etat;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblEmailingParMagasin;
	private JLabel lblExportCvs;
	private JLabel lblExportxls;
	private JLabel lblFermer;
	private JLabel lblMerciDeSlectionner;
	private JLabel lblNewLabel;
	private JLabel lblSelectionnerLesInformations;
	private JLabel lblValider;
	private ComboBoxModel<Object> listeville;
	private Vector<ResultatRecherche> membres;
	private String Message;
	private DefaultTableModel model;
	private JScrollPane scrollPane_1;
	private int selectionIDville;
	private JTable table_3;

	public EmailingVille(final JFrame interfacepre) {
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
							EmailingVille.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingVille.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(853, 263, 199, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(343, 263, 102, 23);
			this.chckbxAdresse.setSelected(true);
		}
		return this.chckbxAdresse;
	}

	private JCheckBox getChckbxCivilit() {
		if (this.chckbxCivilit == null) {
			this.chckbxCivilit = new JCheckBox("Civilit\u00E9");
			this.chckbxCivilit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(242, 263, 99, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(343, 315, 102, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxDateDeNaissance.setForeground(Color.GRAY);
			this.chckbxDateDeNaissance
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxDateDeNaissance.setBounds(447, 263, 150, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(853, 289, 199, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(585, 289, 160, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxNCarteDe.setForeground(Color.GRAY);
			this.chckbxNCarteDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNCarteDe.setBounds(585, 263, 160, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(242, 289, 51, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(242, 315, 99, 23);
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

							if (EmailingVille.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingVille.this.table_3.selectAll();
								EmailingVille.this.table_3.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(242, 655, 270, 23);
		}
		return this.chckbxSelectionnerLensembleDes;
	}

	private JCheckBox getChckbxToutDselectionner() {
		if (this.chckbxToutDselectionner == null) {
			this.chckbxToutDselectionner = new JCheckBox(
					"Tout d\u00E9selectionner");
			this.chckbxToutDselectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					EmailingVille.this.chckbxNom.setSelected(false);
					EmailingVille.this.chckbxPrnom.setSelected(false);
					EmailingVille.this.chckbxCivilit.setSelected(false);
					EmailingVille.this.chckbxAdresse.setSelected(false);
					EmailingVille.this.chckbxCodepostal.setSelected(false);
					EmailingVille.this.chckbxVille.setSelected(false);
					EmailingVille.this.chckbxEmail.setSelected(false);
					EmailingVille.this.checkBox.setSelected(false);
					EmailingVille.this.checkBox_2.setSelected(false);
					EmailingVille.this.checkBox_1.setSelected(false);
					EmailingVille.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingVille.this.chckbxNCarteDe.setSelected(false);
					EmailingVille.this.chckbxDateDeNaissance.setSelected(false);
					EmailingVille.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(242, 365, 165, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingVille.this.chckbxNom.setSelected(true);
					EmailingVille.this.chckbxPrnom.setSelected(true);
					EmailingVille.this.chckbxCivilit.setSelected(true);
					EmailingVille.this.chckbxAdresse.setSelected(true);
					EmailingVille.this.chckbxCodepostal.setSelected(true);
					EmailingVille.this.chckbxVille.setSelected(true);
					EmailingVille.this.chckbxEmail.setSelected(true);
					EmailingVille.this.checkBox.setSelected(true);
					EmailingVille.this.checkBox_2.setSelected(true);
					EmailingVille.this.checkBox_1.setSelected(true);
					EmailingVille.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingVille.this.chckbxNCarteDe.setSelected(true);
					EmailingVille.this.chckbxDateDeNaissance.setSelected(true);
					EmailingVille.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(409, 365, 164, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(343, 289, 102, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(752, 263, 103, 23);
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
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(752, 289, 103, 23);
			this.checkBox_1.setSelected(true);
		}
		return this.checkBox_1;
	}

	private JCheckBox getCheckBox_2() {
		if (this.checkBox_2 == null) {
			this.checkBox_2 = new JCheckBox("Age");
			this.checkBox_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingVille.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVille.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.checkBox_2.setSelected(true);
			this.checkBox_2.setForeground(Color.GRAY);
			this.checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox_2.setBounds(447, 289, 150, 23);
		}
		return this.checkBox_2;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setEditable(false);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setBorder(null);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						EmailingVille.this.selectionIDville = ((Ville) EmailingVille.this.comboBox
								.getSelectedItem()).getIdville();
						System.out.print(EmailingVille.this.selectionIDville);
						EmailingVille.this.lblMerciDeSlectionner
								.setVisible(false);
						EmailingVille.this.lblValider.setVisible(true);
					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingVille.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);
						EmailingVille.this.interfaceActuelle.setVisible(false);
						EmailingVille.this.lblValider.setVisible(false);
						EmailingVille.this.lblValider.setEnabled(false);
						EmailingVille.this.lblMerciDeSlectionner
								.setVisible(true);
						EmailingVille.this.chckbxNom.setSelected(true);
						EmailingVille.this.chckbxPrnom.setSelected(true);
						EmailingVille.this.chckbxCivilit.setSelected(true);
						EmailingVille.this.chckbxAdresse.setSelected(true);
						EmailingVille.this.chckbxCodepostal.setSelected(true);
						EmailingVille.this.chckbxVille.setSelected(true);
						EmailingVille.this.checkBox.setSelected(true);
						EmailingVille.this.checkBox_2.setSelected(true);
						EmailingVille.this.checkBox_1.setSelected(true);
						EmailingVille.this.chckbxEmail.setSelected(true);
						EmailingVille.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingVille.this.chckbxNCarteDe.setSelected(true);
						EmailingVille.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingVille.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingVille.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingVille.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingVille.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingVille.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingVille.this.lblExportxls.setVisible(false);
						EmailingVille.this.lblExportCvs.setVisible(false);
						if ((EmailingVille.this.table_3.getRowCount() != 0)
								&& (EmailingVille.this.table_3.getColumnCount() != 0)) {
							EmailingVille.this.model.setColumnCount(0);
							EmailingVille.this.model.setRowCount(0);
							EmailingVille.this.table_3
									.setModel(EmailingVille.this.model);
							EmailingVille.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox.setBounds(242, 187, 795, 22);

			this.listeville = new DefaultComboBoxModel<Object>(
					Select.listeVille());
			this.comboBox.setModel(this.listeville);
			AutoCompletion.enable(this.comboBox);

		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(EmailingVille.class
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
					EmailingVille.this.dispose();
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
					EmailingVille.this.dispose();
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
					EmailingVille.this.dispose();
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
					EmailingVille.this.dispose();
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
			this.label_4 = new JLabel(
					"(CTRL+C ou Pomme+C pour copier les donn\u00E9es)");
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(242, 682, 317, 14);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMerciDeSlectionner());
			this.layeredPane.add(this.getLblEmailingParMagasin());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getComboBox());
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
			this.layeredPane.add(this.getCheckBox());
			this.layeredPane.add(this.getCheckBox_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getCheckBox_2());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"Tri par Ville (Clients titulaire d'une carte de fidelit\u00E9");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 110, 317, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(EmailingVille.class
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
							EmailingVille.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingVille.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingVille.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par ville (titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingVille.this.membres.size(); j++) {

							for (int i = 0; i <= (EmailingVille.this.entetes.length - 1); i++) {
								if (EmailingVille.this.donnees[j][i] != null) {
									writer.append(EmailingVille.this.donnees[j][i]
											.toString());
									if (i == (EmailingVille.this.entetes.length - 1)) {
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

						EmailingVille.this.Message = "Exportation du fichier Extraction par ville (titulaire carte).csv réalisée avec succès";
						EmailingVille.this.etat = true;
						EmailingVille.this.choixformat = "CSV7";
						final MessageExport fenetre = new MessageExport(
								EmailingVille.this.Message,
								EmailingVille.this.interfaceActuelle,
								EmailingVille.this.etat,
								EmailingVille.this.choixformat);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingVille.this.Message = "Impossible de générer le fichier CSV";
						EmailingVille.this.etat = false;
						EmailingVille.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingVille.this.Message,
								EmailingVille.this.interfaceActuelle,
								EmailingVille.this.etat,
								EmailingVille.this.choixformat);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(891, 675, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(EmailingVille.class
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
							EmailingVille.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingVille.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingVille.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par ville (titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(EmailingVille.this.table_3, file);
						EmailingVille.this.etat = true;
						EmailingVille.this.Message = "Exportation du fichier Extraction par ville (titulaire carte).xls réalisée avec succès";
						EmailingVille.this.choixformat = "XLS7";
						final MessageExport fenetre = new MessageExport(
								EmailingVille.this.Message,
								EmailingVille.this.interfaceActuelle,
								EmailingVille.this.etat,
								EmailingVille.this.choixformat);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingVille.this.etat = false;
						EmailingVille.this.choixformat = "XLS";
						EmailingVille.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingVille.this.Message,
								EmailingVille.this.interfaceActuelle,
								EmailingVille.this.etat,
								EmailingVille.this.choixformat);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(720, 681, 133, 28);
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
					EmailingVille.this.dispose();
					EmailingVille.this.interfacePrecedente.setVisible(true);
					EmailingVille.this.interfacePrecedente.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(873, 55, 179, 44);
		}
		return this.lblFermer;
	}

	private JLabel getLblMerciDeSlectionner() {
		if (this.lblMerciDeSlectionner == null) {
			this.lblMerciDeSlectionner = new JLabel(
					"Merci de s\u00E9lectionner une ville");
			this.lblMerciDeSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSlectionner.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner.setBounds(554, 191, 205, 14);
		}
		return this.lblMerciDeSlectionner;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(EmailingVille.class
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
			this.lblSelectionnerLesInformations.setBounds(242, 242, 292, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(EmailingVille.class
					.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingVille.this.checkBox.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.checkBox_1.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.checkBox_2.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxCivilit.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxNom.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxPrnom.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxAdresse.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxVille.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxCodepostal.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxDateDeNaissance.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxEmail.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxNCarteDe.isSelected() == true) {

						compteur++;
					}
					if (EmailingVille.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (compteur > 4) {
						EmailingVille.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingVille.this.membres = Select
							.eMailingville(EmailingVille.this.selectionIDville);

					if (EmailingVille.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingVille.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);
						EmailingVille.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingVille.this.lblValider.setVisible(false);

						if ((EmailingVille.this.table_3.getRowCount() != 0)
								|| (EmailingVille.this.table_3.getColumnCount() != 0)) {
							EmailingVille.this.model.setColumnCount(0);
							EmailingVille.this.model.setRowCount(0);
							EmailingVille.this.table_3
									.setModel(EmailingVille.this.model);
							EmailingVille.this.table_3.repaint();
						}
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingVille.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingVille.this.interfaceActuelle.setEnabled(false);
						EmailingVille.this.interfaceActuelle.setVisible(false);
						EmailingVille.this.lblValider.setVisible(false);

						EmailingVille.this.lblMerciDeSlectionner
								.setVisible(true);

					} else

					{

						EmailingVille.this.entetes = new String[compteur];

						EmailingVille.this.donnees = new Object[EmailingVille.this.membres
								.size()][EmailingVille.this.entetes.length];

						for (int j = 0; j < EmailingVille.this.membres.size(); j++) {

							for (int i = 0; i < (EmailingVille.this.entetes.length - 1); i++) {

								if (EmailingVille.this.chckbxCivilit
										.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Civilité";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingVille.this.chckbxNom.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Nom";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getNomIndividu().toUpperCase();
									i++;

								}
								if (EmailingVille.this.chckbxPrnom.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Prénom";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getPrenomIndividu().toLowerCase();
									i++;

								}
								if (EmailingVille.this.chckbxAdresse
										.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Adresse";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingVille.this.chckbxVille.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Ville";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingVille.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Code Postal";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}
								if (EmailingVille.this.chckbxDateDeNaissance
										.isSelected() == true) {
									if (EmailingVille.this.membres.get(j)
											.getDateNaissanceIndividu() != null) {
										EmailingVille.this.entetes[i] = "Date de Naissance";
										EmailingVille.this.donnees[j][i] = ""
												+ EmailingVille.this.membres
														.get(j)
														.getDateNaissanceIndividu();
										i++;
									} else {
										EmailingVille.this.entetes[i] = "Date de Naissance";
										EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
												.get(j)
												.getDateNaissanceIndividu();
										i++;
									}
								}
								if (EmailingVille.this.checkBox_2.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Age";

									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EmailingVille.this.chckbxEmail.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Adresse Mail";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingVille.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Newsletter";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}
								if (EmailingVille.this.chckbxNCarteDe
										.isSelected() == true) {
									if (EmailingVille.this.membres.get(j)
											.getNumerocarte() != null) {
										EmailingVille.this.entetes[i] = "N°Client";
										EmailingVille.this.donnees[j][i] = ""
												+ EmailingVille.this.membres
														.get(j)
														.getNumerocarte();
										i++;
									} else {
										EmailingVille.this.entetes[i] = "N°Client";
										EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
												.get(j).getNumerocarte();
										i++;
									}
								}
								if (EmailingVille.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingVille.this.entetes[i] = "Magasin";
									EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingVille.this.checkBox.isSelected() == true) {
									if (EmailingVille.this.membres.get(j)
											.getTelephonefixe() != null) {
										EmailingVille.this.entetes[i] = "Téléphone";
										EmailingVille.this.donnees[j][i] = ""
												+ EmailingVille.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EmailingVille.this.entetes[i] = "Téléphone";
										EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
												.get(j).getTelephonefixe();
										i++;
									}

								}
								if (EmailingVille.this.checkBox_1.isSelected() == true) {
									if (EmailingVille.this.membres.get(j)
											.getTelephonemobile() != null) {
										EmailingVille.this.entetes[i] = "Mobile";
										EmailingVille.this.donnees[j][i] = ""
												+ EmailingVille.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EmailingVille.this.entetes[i] = "Mobile";
										EmailingVille.this.donnees[j][i] = EmailingVille.this.membres
												.get(j).getTelephonemobile();
										i++;
									}

								}
							}

						}

						if (EmailingVille.this.membres.size() != 0) {

							EmailingVille.this.model = new DefaultTableModel(
									EmailingVille.this.donnees,
									EmailingVille.this.entetes);

							EmailingVille.this.table_3
									.setModel(EmailingVille.this.model);

						}

					}

					EmailingVille.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingVille.this.lblExportxls.setVisible(true);
					EmailingVille.this.lblExportCvs.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(935, 365, 99, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(242, 403, 785, 245);
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
