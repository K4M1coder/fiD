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
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.MessageExport;

public class EmailingVilleSansCarte extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1372845022787897153L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
	private JCheckBox chckbxCivilit;
	private JCheckBox chckbxCodepostal;
	private JCheckBox chckbxEmail;
	private JCheckBox chckbxMagasinDeReference;
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

	public EmailingVilleSansCarte(final JFrame interfacepre) {
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
							EmailingVilleSansCarte.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingVilleSansCarte.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(856, 264, 196, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(484, 264, 89, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(242, 264, 104, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(348, 290, 134, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(575, 264, 162, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(575, 290, 162, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(242, 290, 104, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(348, 264, 134, 23);
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

							if (EmailingVilleSansCarte.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingVilleSansCarte.this.table_3.selectAll();
								EmailingVilleSansCarte.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(242, 654, 270, 23);
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

					EmailingVilleSansCarte.this.chckbxNom.setSelected(false);
					EmailingVilleSansCarte.this.chckbxPrnom.setSelected(false);
					EmailingVilleSansCarte.this.chckbxCivilit
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxAdresse
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxCodepostal
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxVille.setSelected(false);
					EmailingVilleSansCarte.this.chckbxEmail.setSelected(false);
					EmailingVilleSansCarte.this.checkBox.setSelected(false);
					EmailingVilleSansCarte.this.checkBox_1.setSelected(false);
					EmailingVilleSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingVilleSansCarte.this.checkBox_2.setSelected(false);

					EmailingVilleSansCarte.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(242, 364, 163, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingVilleSansCarte.this.chckbxNom.setSelected(true);
					EmailingVilleSansCarte.this.chckbxPrnom.setSelected(true);
					EmailingVilleSansCarte.this.chckbxCivilit.setSelected(true);
					EmailingVilleSansCarte.this.chckbxAdresse.setSelected(true);
					EmailingVilleSansCarte.this.chckbxCodepostal
							.setSelected(true);
					EmailingVilleSansCarte.this.chckbxVille.setSelected(true);
					EmailingVilleSansCarte.this.checkBox.setSelected(true);
					EmailingVilleSansCarte.this.checkBox_1.setSelected(true);
					EmailingVilleSansCarte.this.chckbxEmail.setSelected(true);
					EmailingVilleSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingVilleSansCarte.this.checkBox_2.setSelected(true);

					EmailingVilleSansCarte.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(407, 364, 155, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(484, 290, 89, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(744, 264, 110, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(744, 290, 110, 23);
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
					EmailingVilleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingVilleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_2.setSelected(true);
			this.checkBox_2.setForeground(Color.GRAY);
			this.checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox_2.setBounds(856, 290, 174, 23);
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
						EmailingVilleSansCarte.this.selectionIDville = ((Ville) EmailingVilleSansCarte.this.comboBox
								.getSelectedItem()).getIdville();
						System.out
								.print(EmailingVilleSansCarte.this.selectionIDville);
						EmailingVilleSansCarte.this.lblMerciDeSlectionner
								.setVisible(false);
						EmailingVilleSansCarte.this.lblValider.setVisible(true);
					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingVilleSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingVilleSansCarte.this.lblValider
								.setVisible(false);
						EmailingVilleSansCarte.this.lblValider
								.setEnabled(false);
						EmailingVilleSansCarte.this.lblMerciDeSlectionner
								.setVisible(true);
						EmailingVilleSansCarte.this.chckbxNom.setSelected(true);
						EmailingVilleSansCarte.this.chckbxPrnom
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxCivilit
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxAdresse
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxCodepostal
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxVille
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxEmail
								.setSelected(true);
						EmailingVilleSansCarte.this.checkBox.setSelected(true);
						EmailingVilleSansCarte.this.checkBox_1
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingVilleSansCarte.this.checkBox_2
								.setSelected(true);

						EmailingVilleSansCarte.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingVilleSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingVilleSansCarte.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingVilleSansCarte.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingVilleSansCarte.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingVilleSansCarte.this.lblExportxls
								.setVisible(false);
						EmailingVilleSansCarte.this.lblExportCvs
								.setVisible(false);
						if ((EmailingVilleSansCarte.this.table_3.getRowCount() != 0)
								&& (EmailingVilleSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingVilleSansCarte.this.model.setColumnCount(0);
							EmailingVilleSansCarte.this.model.setRowCount(0);
							EmailingVilleSansCarte.this.table_3
									.setModel(EmailingVilleSansCarte.this.model);
							EmailingVilleSansCarte.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox.setBounds(242, 187, 784, 22);

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
			this.fond.setIcon(new ImageIcon(EmailingVilleSansCarte.class
					.getResource("/Images/fonds/menus-extraction-long.png")));
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
					EmailingVilleSansCarte.this.dispose();
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
					EmailingVilleSansCarte.this.dispose();
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
					EmailingVilleSansCarte.this.dispose();
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
					EmailingVilleSansCarte.this.dispose();
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
			this.label_4.setBounds(242, 684, 331, 14);
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
					"Tri par Ville (Clients non titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 110, 344, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(
					EmailingVilleSansCarte.class
							.getResource("/Images/actionbutons/export-csv.png")));
			this.lblExportCvs.setVisible(false);
			this.lblExportCvs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					try {

						final String os = System.getProperty("os.name")
								.toLowerCase();
						;
						if (os.contains("mac")) {
							EmailingVilleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingVilleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingVilleSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par ville (non titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingVilleSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EmailingVilleSansCarte.this.entetes.length - 1); i++) {
								if (EmailingVilleSansCarte.this.donnees[j][i] != null) {
									writer.append(EmailingVilleSansCarte.this.donnees[j][i]
											.toString());
									if (i == (EmailingVilleSansCarte.this.entetes.length - 1)) {
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

						EmailingVilleSansCarte.this.Message = "Exportation du fichier Extraction par ville (non titulaire carte).csv réalisée avec succès";
						EmailingVilleSansCarte.this.etat = true;
						EmailingVilleSansCarte.this.choixformat = "CSV8";
						final MessageExport fenetre = new MessageExport(
								EmailingVilleSansCarte.this.Message,
								EmailingVilleSansCarte.this.interfaceActuelle,
								EmailingVilleSansCarte.this.etat,
								EmailingVilleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingVilleSansCarte.this.Message = "Impossible de générer le fichier CSV";
						EmailingVilleSansCarte.this.etat = false;
						EmailingVilleSansCarte.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingVilleSansCarte.this.Message,
								EmailingVilleSansCarte.this.interfaceActuelle,
								EmailingVilleSansCarte.this.etat,
								EmailingVilleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(890, 667, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(
					EmailingVilleSansCarte.class
							.getResource("/Images/actionbutons/export-excel.png")));
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
							EmailingVilleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingVilleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingVilleSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par ville (non titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(EmailingVilleSansCarte.this.table_3,
								file);
						EmailingVilleSansCarte.this.etat = true;
						EmailingVilleSansCarte.this.Message = "Exportation du fichier Extraction par ville (non titulaire carte).xls réalisée avec succès";
						EmailingVilleSansCarte.this.choixformat = "XLS8";
						final MessageExport fenetre = new MessageExport(
								EmailingVilleSansCarte.this.Message,
								EmailingVilleSansCarte.this.interfaceActuelle,
								EmailingVilleSansCarte.this.etat,
								EmailingVilleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingVilleSansCarte.this.etat = false;
						EmailingVilleSansCarte.this.choixformat = "XLS";
						EmailingVilleSansCarte.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingVilleSansCarte.this.Message,
								EmailingVilleSansCarte.this.interfaceActuelle,
								EmailingVilleSansCarte.this.etat,
								EmailingVilleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(723, 673, 133, 28);
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
					EmailingVilleSansCarte.this.dispose();
					EmailingVilleSansCarte.this.interfacePrecedente
							.setVisible(true);
					EmailingVilleSansCarte.this.interfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(878, 55, 174, 44);
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
			this.lblNewLabel.setIcon(new ImageIcon(EmailingVilleSansCarte.class
					.getResource("/Images/fonds/fond-logiciel.png")));
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
			this.lblSelectionnerLesInformations.setBounds(242, 243, 270, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(EmailingVilleSansCarte.class
					.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingVilleSansCarte.this.checkBox.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.checkBox_1.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.checkBox_2.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxCivilit.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxNom.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxPrnom.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxAdresse.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxVille.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxCodepostal
							.isSelected() == true) {

						compteur++;
					}

					if (EmailingVilleSansCarte.this.chckbxEmail.isSelected() == true) {

						compteur++;
					}
					if (EmailingVilleSansCarte.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}

					if (EmailingVilleSansCarte.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (compteur > 4) {
						EmailingVilleSansCarte.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingVilleSansCarte.this.membres = Select
							.eMailingvilleSansCarte(EmailingVilleSansCarte.this.selectionIDville);

					if (EmailingVilleSansCarte.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingVilleSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingVilleSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingVilleSansCarte.this.lblValider
								.setVisible(false);

						if ((EmailingVilleSansCarte.this.table_3.getRowCount() != 0)
								|| (EmailingVilleSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingVilleSansCarte.this.model.setColumnCount(0);
							EmailingVilleSansCarte.this.model.setRowCount(0);
							EmailingVilleSansCarte.this.table_3
									.setModel(EmailingVilleSansCarte.this.model);
							EmailingVilleSansCarte.this.table_3.repaint();
						}
					}else{
						chckbxSelectionnerLensembleDes.setText("selectionner les "+membres.size()+" résultats");
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingVilleSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingVilleSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingVilleSansCarte.this.lblValider
								.setVisible(false);

						EmailingVilleSansCarte.this.lblMerciDeSlectionner
								.setVisible(true);

					} else

					{

						EmailingVilleSansCarte.this.entetes = new String[compteur];

						EmailingVilleSansCarte.this.donnees = new Object[EmailingVilleSansCarte.this.membres
								.size()][EmailingVilleSansCarte.this.entetes.length];

						for (int j = 0; j < EmailingVilleSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i < (EmailingVilleSansCarte.this.entetes.length - 1); i++) {

								if (EmailingVilleSansCarte.this.chckbxCivilit
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Civilité";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingVilleSansCarte.this.chckbxNom
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Nom";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getNomIndividu().toUpperCase();
									i++;

								}
								if (EmailingVilleSansCarte.this.chckbxPrnom
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Prénom";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getPrenomIndividu().toLowerCase();
									i++;

								}
								if (EmailingVilleSansCarte.this.chckbxAdresse
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Adresse";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingVilleSansCarte.this.chckbxVille
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Ville";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingVilleSansCarte.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Code Postal";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}

								if (EmailingVilleSansCarte.this.checkBox_2
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Age";

									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EmailingVilleSansCarte.this.chckbxEmail
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Adresse Mail";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingVilleSansCarte.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Newsletter";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}

								if (EmailingVilleSansCarte.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingVilleSansCarte.this.entetes[i] = "Magasin";
									EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingVilleSansCarte.this.checkBox
										.isSelected() == true) {
									if (EmailingVilleSansCarte.this.membres
											.get(j).getTelephonefixe() != null) {
										EmailingVilleSansCarte.this.entetes[i] = "Téléphone";
										EmailingVilleSansCarte.this.donnees[j][i] = ""
												+ EmailingVilleSansCarte.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EmailingVilleSansCarte.this.entetes[i] = "Téléphone";
										EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
												.get(j).getTelephonefixe();
										i++;
									}
								}
								if (EmailingVilleSansCarte.this.checkBox_1
										.isSelected() == true) {
									if (EmailingVilleSansCarte.this.membres
											.get(j).getTelephonemobile() != null) {
										EmailingVilleSansCarte.this.entetes[i] = "Mobile";
										EmailingVilleSansCarte.this.donnees[j][i] = ""
												+ EmailingVilleSansCarte.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EmailingVilleSansCarte.this.entetes[i] = "Mobile";
										EmailingVilleSansCarte.this.donnees[j][i] = EmailingVilleSansCarte.this.membres
												.get(j).getTelephonemobile();
										i++;
									}

								}
							}

						}

						if (EmailingVilleSansCarte.this.membres.size() != 0) {

							EmailingVilleSansCarte.this.model = new DefaultTableModel(
									EmailingVilleSansCarte.this.donnees,
									EmailingVilleSansCarte.this.entetes);

							EmailingVilleSansCarte.this.table_3
									.setModel(EmailingVilleSansCarte.this.model);

						}

					}

					EmailingVilleSansCarte.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingVilleSansCarte.this.lblExportxls.setVisible(true);
					EmailingVilleSansCarte.this.lblExportCvs.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(927, 364, 99, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(242, 404, 784, 243);
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
