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

import fr.lefournildesprovinces.controler.Control;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.OperationCommerciale;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.util.ExcelExporter;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.MessageExport;

public class EmailingOperationCommercialeSansCarte extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -3712303591581720760L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
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
	private JCheckBox checkBox_2;
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
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLayeredPane layeredPane;
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
	private ComboBoxModel<Object> listeoperationcommerciale;
	private Vector<ResultatRecherche> membres;
	private String Message;
	private DefaultTableModel model;
	private JScrollPane scrollPane_1;
	private int selectionIDMagasin;
	private int selectionIDOperation;
	private JTable table_3;
	private String privilege;

	public EmailingOperationCommercialeSansCarte(final JFrame interfacepre) {
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
							EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(857, 328, 195, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(475, 328, 98, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(242, 328, 98, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(342, 356, 131, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(575, 328, 171, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(575, 356, 171, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(242, 356, 98, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(342, 328, 131, 23);
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

							if (EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingOperationCommercialeSansCarte.this.table_3
										.selectAll();
								EmailingOperationCommercialeSansCarte.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(242, 676, 282, 23);
		}
		return this.chckbxSelectionnerLensembleDes;
	}

	private JCheckBox getChckbxSurLensembleDes() {
		if (this.chckbxSurLensembleDes == null) {
			this.chckbxSurLensembleDes = new JCheckBox(
					"Sur l'ensemble des magasins");

			this.chckbxSurLensembleDes
					.setFont(new Font("Tahoma", Font.BOLD, 11));

			this.chckbxSurLensembleDes.setForeground(Color.GRAY);
			this.chckbxSurLensembleDes.setBounds(242, 233, 204, 23);
			this.chckbxSurLensembleDes.setSelected(true);
			this.chckbxSurLensembleDes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (EmailingOperationCommercialeSansCarte.this.chckbxSurLensembleDes
							.isSelected() != true) {

						EmailingOperationCommercialeSansCarte.this.comboBox_1
								.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.comboBox_1
								.setEnabled(true);
						EmailingOperationCommercialeSansCarte.this.label_4
								.setVisible(true);
						// lblMerciDeSlectionner_1.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.etatbouton = false;
					} else

					{
						EmailingOperationCommercialeSansCarte.this.comboBox_1
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.comboBox_1
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.label_4
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.etatbouton = true;

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

					EmailingOperationCommercialeSansCarte.this.chckbxNom
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxPrnom
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxCivilit
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxAdresse
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxCodepostal
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxVille
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxEmail
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.checkBox_2
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.checkBox
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.checkBox_1
							.setSelected(false);

					EmailingOperationCommercialeSansCarte.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(242, 437, 164, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingOperationCommercialeSansCarte.this.chckbxNom
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxPrnom
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxCivilit
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxAdresse
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxCodepostal
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxVille
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxEmail
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.checkBox_2
							.setSelected(true);

					EmailingOperationCommercialeSansCarte.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(421, 437, 173, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(475, 354, 98, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(748, 328, 107, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(748, 356, 107, 23);
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
					EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_2.setSelected(true);
			this.checkBox_2.setForeground(Color.GRAY);
			this.checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox_2.setBounds(857, 356, 172, 23);
		}
		return this.checkBox_2;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
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

						EmailingOperationCommercialeSansCarte.this.selectionIDOperation = ((OperationCommerciale) EmailingOperationCommercialeSansCarte.this.comboBox
								.getSelectedItem()).getIdOperationCommerciale();
						EmailingOperationCommercialeSansCarte.this.lblMerciDeSlectionner
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.lblMerciDeSlectionner
								.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.chckbxNom
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxPrnom
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxCivilit
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxAdresse
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.checkBox_2
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxCodepostal
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxVille
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxEmail
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.checkBox
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.checkBox_1
								.setSelected(true);

						EmailingOperationCommercialeSansCarte.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblExportxls
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblExportCvs
								.setVisible(false);
						if ((EmailingOperationCommercialeSansCarte.this.table_3
								.getRowCount() != 0)
								&& (EmailingOperationCommercialeSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingOperationCommercialeSansCarte.this.model
									.setColumnCount(0);
							EmailingOperationCommercialeSansCarte.this.model
									.setRowCount(0);
							EmailingOperationCommercialeSansCarte.this.table_3
									.setModel(EmailingOperationCommercialeSansCarte.this.model);
							EmailingOperationCommercialeSansCarte.this.table_3
									.repaint();
						}
					}

				}
			});
			this.comboBox.setBounds(242, 166, 787, 22);
			this.comboBox.setFocusable(false);
			this.listeoperationcommerciale = new DefaultComboBoxModel<Object>(
					Select.listeOperationCommerciale());
			this.comboBox.setModel(this.listeoperationcommerciale);

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
						EmailingOperationCommercialeSansCarte.this.selectionIDMagasin = ((Magasin) EmailingOperationCommercialeSansCarte.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						EmailingOperationCommercialeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.lblMerciDeSlectionner_1
								.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.chckbxNom
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxPrnom
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxCivilit
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxAdresse
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxCodepostal
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxVille
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxEmail
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.checkBox
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.checkBox_1
								.setSelected(true);

						EmailingOperationCommercialeSansCarte.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblExportxls
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblExportCvs
								.setVisible(false);
						if ((EmailingOperationCommercialeSansCarte.this.table_3
								.getRowCount() != 0)
								&& (EmailingOperationCommercialeSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingOperationCommercialeSansCarte.this.model
									.setColumnCount(0);
							EmailingOperationCommercialeSansCarte.this.model
									.setRowCount(0);
							EmailingOperationCommercialeSansCarte.this.table_3
									.setModel(EmailingOperationCommercialeSansCarte.this.model);
							EmailingOperationCommercialeSansCarte.this.table_3
									.repaint();
						}
					}

				}
			});
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(521, 233, 508, 22);
			this.comboBox_1.setEnabled(false);
			this.listemagasins = new DefaultComboBoxModel<Object>(
					Control.listemagasins());
			this.comboBox_1.setModel(this.listemagasins);
			this.comboBox_1.setFocusable(false);

		}
		return this.comboBox_1;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(
					EmailingOperationCommercialeSansCarte.class
							.getResource("/Images/fonds/menus-extraction-long.png")));
			this.fond.setBounds(216, 55, 850, 690);

			this.privilege = Login.getPrivilege();
			switch (this.privilege) {

			case "utilisateur":

				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);
				break;
			}
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
					EmailingOperationCommercialeSansCarte.this.dispose();
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
					EmailingOperationCommercialeSansCarte.this.dispose();
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
					EmailingOperationCommercialeSansCarte.this.dispose();
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
					EmailingOperationCommercialeSansCarte.this.dispose();
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
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(464, 237, 34, 14);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel(
					"(CTRL+C ou Pomme+C pour copier les donn\u00E9es)");
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setBounds(242, 706, 310, 14);
		}
		return this.label_5;
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
			this.layeredPane.add(this.getLblMerciDeSlectionner_1());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getChckbxSurLensembleDes());
			this.layeredPane.add(this.getCheckBox());
			this.layeredPane.add(this.getCheckBox_1());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getCheckBox_2());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"Tri par Operation Commerciale (Clients non titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 110, 454, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(
					EmailingOperationCommercialeSansCarte.class
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
							EmailingOperationCommercialeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingOperationCommercialeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingOperationCommercialeSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par operation commerciale (non titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingOperationCommercialeSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EmailingOperationCommercialeSansCarte.this.entetes.length - 1); i++) {
								if (EmailingOperationCommercialeSansCarte.this.donnees[j][i] != null) {
									writer.append(EmailingOperationCommercialeSansCarte.this.donnees[j][i]
											.toString());
									if (i == (EmailingOperationCommercialeSansCarte.this.entetes.length - 1)) {
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

						EmailingOperationCommercialeSansCarte.this.Message = "Exportation du fichier Extraction par opération (non titulaire carte).csv réalisée avec succès";
						EmailingOperationCommercialeSansCarte.this.etat = true;
						EmailingOperationCommercialeSansCarte.this.choixformat = "CSV6";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommercialeSansCarte.this.Message,
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								EmailingOperationCommercialeSansCarte.this.etat,
								EmailingOperationCommercialeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingOperationCommercialeSansCarte.this.Message = "Impossible de générer le fichier CSV";
						EmailingOperationCommercialeSansCarte.this.etat = false;
						EmailingOperationCommercialeSansCarte.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommercialeSansCarte.this.Message,
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								EmailingOperationCommercialeSansCarte.this.etat,
								EmailingOperationCommercialeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(896, 681, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(
					EmailingOperationCommercialeSansCarte.class
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
							EmailingOperationCommercialeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingOperationCommercialeSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingOperationCommercialeSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par operation commerciale (non titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(
								EmailingOperationCommercialeSansCarte.this.table_3,
								file);
						EmailingOperationCommercialeSansCarte.this.etat = true;
						EmailingOperationCommercialeSansCarte.this.Message = "Exportation du fichier Extraction par opération (non titulaire carte).xls réalisée avec succès";
						EmailingOperationCommercialeSansCarte.this.choixformat = "XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommercialeSansCarte.this.Message,
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								EmailingOperationCommercialeSansCarte.this.etat,
								EmailingOperationCommercialeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingOperationCommercialeSansCarte.this.etat = false;
						EmailingOperationCommercialeSansCarte.this.choixformat = "XLS6";
						EmailingOperationCommercialeSansCarte.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommercialeSansCarte.this.Message,
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								EmailingOperationCommercialeSansCarte.this.etat,
								EmailingOperationCommercialeSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(737, 687, 133, 28);
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
					EmailingOperationCommercialeSansCarte.this.dispose();
					EmailingOperationCommercialeSansCarte.this.interfacePrecedente
							.setVisible(true);
					EmailingOperationCommercialeSansCarte.this.interfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(879, 55, 173, 47);
		}
		return this.lblFermer;
	}

	private JLabel getLblMerciDeSlectionner() {
		if (this.lblMerciDeSlectionner == null) {
			this.lblMerciDeSlectionner = new JLabel(
					"Merci de s\u00E9lectionner une op\u00E9ration Commerciale");
			this.lblMerciDeSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSlectionner.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner.setBounds(495, 170, 316, 14);
		}
		return this.lblMerciDeSlectionner;
	}

	private JLabel getLblMerciDeSlectionner_1() {
		if (this.lblMerciDeSlectionner_1 == null) {
			this.lblMerciDeSlectionner_1 = new JLabel(
					"Merci de s\u00E9lectionner un magasin");
			this.lblMerciDeSlectionner_1.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner_1.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblMerciDeSlectionner_1.setBounds(681, 237, 230, 14);
			this.lblMerciDeSlectionner_1.setEnabled(true);

		}
		return this.lblMerciDeSlectionner_1;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					EmailingOperationCommercialeSansCarte.class
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
			this.lblSelectionnerLesInformations.setBounds(242, 295, 282, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(EmailingOperationCommercialeSansCarte.class.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingOperationCommercialeSansCarte.this.checkBox
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.checkBox_1
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.checkBox_2
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxCivilit
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxNom
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxPrnom
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxAdresse
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxVille
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxCodepostal
							.isSelected() == true) {

						compteur++;
					}

					if (EmailingOperationCommercialeSansCarte.this.chckbxEmail
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommercialeSansCarte.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}

					if (EmailingOperationCommercialeSansCarte.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (compteur > 4) {
						EmailingOperationCommercialeSansCarte.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingOperationCommercialeSansCarte.this.membres = Select
							.eMailingoperationcommercialeSansCarte(
									EmailingOperationCommercialeSansCarte.this.selectionIDOperation,
									EmailingOperationCommercialeSansCarte.this.selectionIDMagasin,
									EmailingOperationCommercialeSansCarte.this.etatbouton);

					if (EmailingOperationCommercialeSansCarte.this.membres
							.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(false);

						if ((EmailingOperationCommercialeSansCarte.this.table_3
								.getRowCount() != 0)
								|| (EmailingOperationCommercialeSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EmailingOperationCommercialeSansCarte.this.model
									.setColumnCount(0);
							EmailingOperationCommercialeSansCarte.this.model
									.setRowCount(0);
							EmailingOperationCommercialeSansCarte.this.table_3
									.setModel(EmailingOperationCommercialeSansCarte.this.model);
							EmailingOperationCommercialeSansCarte.this.table_3
									.repaint();
						}
					}else{
						chckbxSelectionnerLensembleDes.setText("selectionner les "+membres.size()+" résultats");
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommercialeSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommercialeSansCarte.this.interfaceActuelle
								.setVisible(false);
						EmailingOperationCommercialeSansCarte.this.lblValider
								.setVisible(false);

						EmailingOperationCommercialeSansCarte.this.lblMerciDeSlectionner
								.setVisible(true);

					} else

					{

						EmailingOperationCommercialeSansCarte.this.entetes = new String[compteur];

						EmailingOperationCommercialeSansCarte.this.donnees = new Object[EmailingOperationCommercialeSansCarte.this.membres
								.size()][EmailingOperationCommercialeSansCarte.this.entetes.length];

						for (int j = 0; j < EmailingOperationCommercialeSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i < (EmailingOperationCommercialeSansCarte.this.entetes.length - 1); i++) {

								if (EmailingOperationCommercialeSansCarte.this.chckbxCivilit
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Civilité";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxNom
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Nom";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getNomIndividu().toUpperCase();
									i++;

								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxPrnom
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Prénom";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getPrenomIndividu().toLowerCase();
									i++;

								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxAdresse
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Adresse";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxVille
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Ville";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Code Postal";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}

								if (EmailingOperationCommercialeSansCarte.this.checkBox_2
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Age";

									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxEmail
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Adresse Mail";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingOperationCommercialeSansCarte.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Newsletter";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}

								if (EmailingOperationCommercialeSansCarte.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingOperationCommercialeSansCarte.this.entetes[i] = "Magasin";
									EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingOperationCommercialeSansCarte.this.checkBox
										.isSelected() == true) {
									if (EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getTelephonefixe() != null) {
										EmailingOperationCommercialeSansCarte.this.entetes[i] = "Téléphone";
										EmailingOperationCommercialeSansCarte.this.donnees[j][i] = ""
												+ EmailingOperationCommercialeSansCarte.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EmailingOperationCommercialeSansCarte.this.entetes[i] = "Téléphone";
										EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
												.get(j).getTelephonefixe();
										i++;
									}

								}
								if (EmailingOperationCommercialeSansCarte.this.checkBox_1
										.isSelected() == true) {
									if (EmailingOperationCommercialeSansCarte.this.membres
											.get(j).getTelephonemobile() != null) {
										EmailingOperationCommercialeSansCarte.this.entetes[i] = "Mobile";
										EmailingOperationCommercialeSansCarte.this.donnees[j][i] = ""
												+ EmailingOperationCommercialeSansCarte.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EmailingOperationCommercialeSansCarte.this.entetes[i] = "Mobile";
										EmailingOperationCommercialeSansCarte.this.donnees[j][i] = EmailingOperationCommercialeSansCarte.this.membres
												.get(j).getTelephonemobile();
										i++;
									}

								}
							}

						}

						if (EmailingOperationCommercialeSansCarte.this.membres
								.size() != 0) {

							EmailingOperationCommercialeSansCarte.this.model = new DefaultTableModel(
									EmailingOperationCommercialeSansCarte.this.donnees,
									EmailingOperationCommercialeSansCarte.this.entetes);

							EmailingOperationCommercialeSansCarte.this.table_3
									.setModel(EmailingOperationCommercialeSansCarte.this.model);

						}

					}

					EmailingOperationCommercialeSansCarte.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingOperationCommercialeSansCarte.this.lblExportxls
							.setVisible(true);
					EmailingOperationCommercialeSansCarte.this.lblExportCvs
							.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(930, 437, 99, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(242, 471, 787, 198);
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
