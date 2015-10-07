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
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import fr.lefournildesprovinces.controler.Control;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.util.ExcelExporter;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.MessageExport;

public class EmailingAge extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 3216508257207380800L;
	private JCheckBox chckbxAbonnementNewsletter;
	private JCheckBox chckbxAdresse;
	private JCheckBox chckbxAge;
	private JCheckBox chckbxCivilit;
	private JCheckBox chckbxCodepostal;
	private JCheckBox chckbxDateDeNaissance;
	private JCheckBox chckbxEmail;
	private JCheckBox chckbxMagasinDeReference;
	private JCheckBox chckbxMobile;
	private JCheckBox chckbxNCarteDe;
	private JCheckBox chckbxNom;
	private JCheckBox chckbxPrnom;
	private JCheckBox chckbxSelectionnerLensembleDes;
	private JCheckBox chckbxSurLensembleDes;
	private JCheckBox chckbxTelephone;
	private JCheckBox chckbxToutDselectionner;
	private JCheckBox chckbxToutSlectionner;
	private JCheckBox chckbxVille;
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
	private JLabel lblNewLabel_1;
	private JLabel lblOu;
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

	public EmailingAge(final JFrame interfacepre) {
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
							EmailingAge.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingAge.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(870, 314, 182, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(335, 314, 112, 23);
			this.chckbxAdresse.setSelected(true);
		}
		return this.chckbxAdresse;
	}

	private JCheckBox getChckbxAge() {
		if (this.chckbxAge == null) {
			this.chckbxAge = new JCheckBox("Age");
			this.chckbxAge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAge.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxAge.setForeground(Color.GRAY);
			this.chckbxAge.setBounds(598, 340, 159, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(246, 314, 87, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(335, 368, 112, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxDateDeNaissance.setForeground(Color.GRAY);
			this.chckbxDateDeNaissance
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxDateDeNaissance.setBounds(446, 314, 150, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(446, 340, 150, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(870, 340, 182, 23);
			this.chckbxMagasinDeReference.setSelected(true);
		}
		return this.chckbxMagasinDeReference;
	}

	private JCheckBox getChckbxMobile() {
		if (this.chckbxMobile == null) {
			this.chckbxMobile = new JCheckBox("Mobile");
			this.chckbxMobile.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxMobile.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxMobile.setForeground(Color.GRAY);
			this.chckbxMobile.setBounds(770, 314, 98, 23);
			this.chckbxMobile.setSelected(true);
		}
		return this.chckbxMobile;
	}

	private JCheckBox getChckbxNCarteDe() {
		if (this.chckbxNCarteDe == null) {
			this.chckbxNCarteDe = new JCheckBox(
					"N\u00B0 Carte de Fid\u00E9lit\u00E9");
			this.chckbxNCarteDe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxNCarteDe.setForeground(Color.GRAY);
			this.chckbxNCarteDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNCarteDe.setBounds(598, 314, 159, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(246, 340, 87, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(246, 368, 87, 23);
			this.chckbxPrnom.setSelected(true);

		}
		return this.chckbxPrnom;
	}

	private JCheckBox getChckbxSelectionnerLensembleDes() {
		if (this.chckbxSelectionnerLensembleDes == null) {
			this.chckbxSelectionnerLensembleDes = new JCheckBox(
					"Selectionner l'ensemble des résultats ");
			this.chckbxSelectionnerLensembleDes.setVisible(false);
			this.chckbxSelectionnerLensembleDes
					.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(final MouseEvent e) {

							if (EmailingAge.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingAge.this.table_3.selectAll();
								EmailingAge.this.table_3.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(246, 656, 511, 23);
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
			this.chckbxSurLensembleDes.setBounds(246, 238, 200, 23);
			this.chckbxSurLensembleDes.setSelected(false);
			this.chckbxSurLensembleDes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (EmailingAge.this.chckbxSurLensembleDes.isSelected() != true) {

						EmailingAge.this.comboBox_1.setVisible(true);
						EmailingAge.this.comboBox_1.setEnabled(true);
						// lblMerciDeSlectionner_1.setVisible(true);
						EmailingAge.this.lblValider.setVisible(false);
						EmailingAge.this.lblOu.setVisible(true);
						EmailingAge.this.etatbouton = false;
					} else

					{
						EmailingAge.this.comboBox_1.setVisible(false);
						EmailingAge.this.comboBox_1.setEnabled(false);
						EmailingAge.this.lblOu.setVisible(false);
						EmailingAge.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAge.this.lblValider.setVisible(true);
						EmailingAge.this.etatbouton = true;

					}

				}
			});

		}
		return this.chckbxSurLensembleDes;
	}

	private JCheckBox getChckbxTelephone() {
		if (this.chckbxTelephone == null) {
			this.chckbxTelephone = new JCheckBox("Telephone");
			this.chckbxTelephone.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxTelephone.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxTelephone.setForeground(Color.GRAY);
			this.chckbxTelephone.setBounds(770, 340, 98, 23);
			this.chckbxTelephone.setSelected(true);
		}
		return this.chckbxTelephone;
	}

	private JCheckBox getChckbxToutDselectionner() {
		if (this.chckbxToutDselectionner == null) {
			this.chckbxToutDselectionner = new JCheckBox(
					"Tout d\u00E9selectionner");
			this.chckbxToutDselectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					EmailingAge.this.chckbxNom.setSelected(false);
					EmailingAge.this.chckbxPrnom.setSelected(false);
					EmailingAge.this.chckbxCivilit.setSelected(false);
					EmailingAge.this.chckbxAdresse.setSelected(false);
					EmailingAge.this.chckbxCodepostal.setSelected(false);
					EmailingAge.this.chckbxVille.setSelected(false);
					EmailingAge.this.chckbxEmail.setSelected(false);
					EmailingAge.this.chckbxTelephone.setSelected(false);
					EmailingAge.this.chckbxMobile.setSelected(false);
					EmailingAge.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingAge.this.chckbxNCarteDe.setSelected(false);
					EmailingAge.this.chckbxDateDeNaissance.setSelected(false);
					EmailingAge.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
					EmailingAge.this.chckbxAge.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(246, 410, 160, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingAge.this.chckbxNom.setSelected(true);
					EmailingAge.this.chckbxPrnom.setSelected(true);
					EmailingAge.this.chckbxCivilit.setSelected(true);
					EmailingAge.this.chckbxAdresse.setSelected(true);
					EmailingAge.this.chckbxCodepostal.setSelected(true);
					EmailingAge.this.chckbxVille.setSelected(true);
					EmailingAge.this.chckbxEmail.setSelected(true);
					EmailingAge.this.chckbxTelephone.setSelected(true);
					EmailingAge.this.chckbxMobile.setSelected(true);
					EmailingAge.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingAge.this.chckbxNCarteDe.setSelected(true);
					EmailingAge.this.chckbxDateDeNaissance.setSelected(true);
					EmailingAge.this.chckbxMagasinDeReference.setSelected(true);
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxAge.setSelected(true);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(410, 410, 182, 23);
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
					EmailingAge.this.chckbxToutDselectionner.setSelected(false);
					EmailingAge.this.chckbxToutSlectionner.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(335, 340, 112, 23);
			this.chckbxVille.setSelected(true);
		}
		return this.chckbxVille;
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
						EmailingAge.this.selectionIDMagasin = ((Magasin) EmailingAge.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						EmailingAge.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAge.this.lblValider.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAge.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);
						EmailingAge.this.interfaceActuelle.setVisible(false);
						EmailingAge.this.lblValider.setVisible(false);
						EmailingAge.this.lblValider.setEnabled(false);
						EmailingAge.this.chckbxAge.setSelected(true);
						EmailingAge.this.chckbxNom.setSelected(true);
						EmailingAge.this.chckbxPrnom.setSelected(true);
						EmailingAge.this.chckbxCivilit.setSelected(true);
						EmailingAge.this.chckbxAdresse.setSelected(true);
						EmailingAge.this.chckbxCodepostal.setSelected(true);
						EmailingAge.this.chckbxVille.setSelected(true);
						EmailingAge.this.chckbxEmail.setSelected(true);
						EmailingAge.this.chckbxTelephone.setSelected(true);
						EmailingAge.this.chckbxMobile.setSelected(true);
						EmailingAge.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingAge.this.chckbxNCarteDe.setSelected(true);
						EmailingAge.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingAge.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingAge.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAge.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingAge.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingAge.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingAge.this.lblExportxls.setVisible(false);
						EmailingAge.this.lblExportCvs.setVisible(false);
						if ((EmailingAge.this.table_3.getRowCount() != 0)
								&& (EmailingAge.this.table_3.getColumnCount() != 0)) {
							EmailingAge.this.model.setColumnCount(0);
							EmailingAge.this.model.setRowCount(0);
							EmailingAge.this.table_3
									.setModel(EmailingAge.this.model);
							EmailingAge.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox_1.setVisible(false);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(515, 238, 515, 22);
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
			this.fond.setIcon(new ImageIcon(EmailingAge.class
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
					EmailingAge.this.dispose();
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
					EmailingAge.this.dispose();
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
					EmailingAge.this.dispose();
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
					EmailingAge.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(573, 55, 114, 44);
		}
		return this.label_3;
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
			this.layeredPane.add(this.getSlider_1());
			this.layeredPane.add(this.getSlider_1_1());
			this.layeredPane.add(this.getChckbxAge());
			this.layeredPane.add(this.getChckbxTelephone());
			this.layeredPane.add(this.getChckbxMobile());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblOu());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());

		}
		return this.layeredPane;
	}

	private JLabel getLblAgeMaximum() {
		if (this.lblAgeMaximum == null) {
			this.lblAgeMaximum = new JLabel("Age Maximum : 18");
			this.lblAgeMaximum.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAgeMaximum.setForeground(Color.GRAY);
			this.lblAgeMaximum.setBounds(585, 199, 135, 14);

		}
		return this.lblAgeMaximum;
	}

	private JLabel getLblAgeMinimum() {
		if (this.lblAgeMinimum == null) {
			this.lblAgeMinimum = new JLabel("Age Minimum : 18");
			this.lblAgeMinimum.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAgeMinimum.setForeground(Color.GRAY);
			this.lblAgeMinimum.setBounds(296, 199, 110, 14);

		}
		return this.lblAgeMinimum;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"Tri Par tranche d'\u00E2ge (Clients  titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 110, 366, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(EmailingAge.class
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
							EmailingAge.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingAge.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(EmailingAge.this.desktopPath
								+ "/Base Marketing Client/");

						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par age (titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingAge.this.membres.size(); j++) {

							for (int i = 0; i <= (EmailingAge.this.entetes.length - 1); i++) {
								System.out.println(writer.append(EmailingAge.this.donnees[j][i]
										.toString()));
								if (EmailingAge.this.donnees[j][i] != null) {
									writer.append(EmailingAge.this.donnees[j][i]
											.toString());
									if (i == (EmailingAge.this.entetes.length - 1)) {
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

						EmailingAge.this.Message = "Exportation du fichier Extraction par age (titulaire carte).csv réalisée avec succès";
						EmailingAge.this.etat = true;
						EmailingAge.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingAge.this.Message,
								EmailingAge.this.interfaceActuelle,
								EmailingAge.this.etat,
								EmailingAge.this.choixformat);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingAge.this.Message = "Impossible de générer le fichier CSV";
						EmailingAge.this.etat = false;
						EmailingAge.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingAge.this.Message,
								EmailingAge.this.interfaceActuelle,
								EmailingAge.this.etat,
								EmailingAge.this.choixformat);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(897, 671, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportxls.setIcon(new ImageIcon(EmailingAge.class
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
							EmailingAge.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EmailingAge.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(EmailingAge.this.desktopPath
								+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par age (titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(EmailingAge.this.table_3, file);
						EmailingAge.this.etat = true;
						EmailingAge.this.Message = "Exportation du fichier Extraction par age (titulaire carte).xls réalisée avec succès";
						EmailingAge.this.choixformat = "XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingAge.this.Message,
								EmailingAge.this.interfaceActuelle,
								EmailingAge.this.etat,
								EmailingAge.this.choixformat);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingAge.this.etat = false;
						EmailingAge.this.choixformat = "XLS";
						EmailingAge.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingAge.this.Message,
								EmailingAge.this.interfaceActuelle,
								EmailingAge.this.etat,
								EmailingAge.this.choixformat);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(742, 677, 133, 28);
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
					EmailingAge.this.dispose();
					EmailingAge.this.interfacePrecedente.setVisible(true);
					EmailingAge.this.interfacePrecedente.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(870, 55, 182, 45);
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
			this.lblMerciDeSlectionner.setBounds(246, 145, 237, 14);
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
			this.lblMerciDeSlectionner_1.setBounds(655, 242, 200, 14);
			this.lblMerciDeSlectionner_1.setEnabled(true);

		}
		return this.lblMerciDeSlectionner_1;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"(CTRL+C ou Pomme+C pour copier les donn\u00E9es)");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(246, 686, 298, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(EmailingAge.class
					.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblOu() {
		if (this.lblOu == null) {
			this.lblOu = new JLabel("Ou");
			this.lblOu.setVisible(false);
			this.lblOu.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOu.setForeground(Color.GRAY);
			this.lblOu.setBounds(468, 242, 33, 14);
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
			this.lblSelectionnerLesInformations.setBounds(246, 279, 230, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.RIGHT);
			this.lblValider.setIcon(new ImageIcon(EmailingAge.class
					.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.TRAILING);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingAge.this.chckbxMobile.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxTelephone.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxCivilit.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxNom.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxPrnom.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxAdresse.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxVille.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxCodepostal.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxDateDeNaissance.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxEmail.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxNCarteDe.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxMagasinDeReference.isSelected() == true) {

						compteur++;
					}
					if (EmailingAge.this.chckbxAge.isSelected() == true) {

						compteur++;
					}

					if (compteur > 4) {
						EmailingAge.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingAge.this.membres = Select.eMailingTrancheAge(
							EmailingAge.this.valuemin,
							EmailingAge.this.valuemax,
							EmailingAge.this.selectionIDMagasin,
							EmailingAge.this.etatbouton);

					if (EmailingAge.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAge.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);
						EmailingAge.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAge.this.lblValider.setVisible(false);

						if ((EmailingAge.this.table_3.getRowCount() != 0)
								|| (EmailingAge.this.table_3.getColumnCount() != 0)) {
							EmailingAge.this.model.setColumnCount(0);
							EmailingAge.this.model.setRowCount(0);
							EmailingAge.this.table_3
									.setModel(EmailingAge.this.model);
							EmailingAge.this.table_3.repaint();
						} else {
						}

					}else{
						chckbxSelectionnerLensembleDes.setText("selectionner les "+membres.size()+" résultats");
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAge.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);
						EmailingAge.this.interfaceActuelle.setVisible(false);
						EmailingAge.this.lblValider.setVisible(false);

						EmailingAge.this.lblMerciDeSlectionner.setVisible(true);

					} else

					{

						EmailingAge.this.entetes = new String[compteur];

						EmailingAge.this.donnees = new Object[EmailingAge.this.membres
								.size()][EmailingAge.this.entetes.length];

						for (int j = 0; j < EmailingAge.this.membres.size(); j++) {

							for (int i = 0; i < (EmailingAge.this.entetes.length - 1); i++) {

								if (EmailingAge.this.chckbxCivilit.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Civilité";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingAge.this.chckbxNom.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Nom";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getNomIndividu();
									i++;

								}
								if (EmailingAge.this.chckbxPrnom.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Prénom";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getPrenomIndividu().toUpperCase();
									i++;

								}
								if (EmailingAge.this.chckbxAdresse.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Adresse";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getAdresseIndividu().toLowerCase();
									i++;
								}
								if (EmailingAge.this.chckbxVille.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Ville";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingAge.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Code Postal";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}
								if (EmailingAge.this.chckbxDateDeNaissance
										.isSelected() == true) {
									if (EmailingAge.this.membres.get(j)
											.getDateNaissanceIndividu() != null) {
										EmailingAge.this.entetes[i] = "Date de Naissance";
										EmailingAge.this.donnees[j][i] = ""+EmailingAge.this.membres
														.get(j)
														.getDateNaissanceIndividu();
										i++;
									} else {
										EmailingAge.this.entetes[i] = "Date de Naissance";
										EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
												.get(j)
												.getDateNaissanceIndividu();
										i++;
									}
								}
								if (EmailingAge.this.chckbxAge.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Age";
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
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getAge();
									i++;
								}
								if (EmailingAge.this.chckbxEmail.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Adresse Mail";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingAge.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Newsletter";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}
								if (EmailingAge.this.chckbxNCarteDe
										.isSelected() == true) {
									if (EmailingAge.this.membres.get(j)
											.getNumerocarte() != null) {
										EmailingAge.this.entetes[i] = "N°Client";
										EmailingAge.this.donnees[j][i] = ""+EmailingAge.this.membres.get(
														j).getNumerocarte();
										i++;
									} else {
										EmailingAge.this.entetes[i] = "N°Client";
										EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
												.get(j).getNumerocarte();
										i++;
									}
								}
								if (EmailingAge.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingAge.this.entetes[i] = "Magasin";
									EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingAge.this.chckbxTelephone
										.isSelected() == true) {
									if (EmailingAge.this.membres.get(j)
											.getTelephonefixe() != null) {
										EmailingAge.this.entetes[i] = "Telephone";
										EmailingAge.this.donnees[j][i] = ""+EmailingAge.this.membres.get(
														j).getTelephonefixe();
										i++;
									} else {
										EmailingAge.this.entetes[i] = "Telephone";
										EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
												.get(j).getTelephonefixe();
										i++;

									}

								}
								if (EmailingAge.this.chckbxMobile.isSelected() == true) {
									if (EmailingAge.this.membres.get(j)
											.getTelephonemobile() != null) {
										EmailingAge.this.entetes[i] = "Mobile";
										EmailingAge.this.donnees[j][i] = ""+EmailingAge.this.membres.get(
														j).getTelephonemobile();
										i++;
									} else {
										EmailingAge.this.entetes[i] = "Mobile";
										EmailingAge.this.donnees[j][i] = EmailingAge.this.membres
												.get(j).getTelephonemobile();
										i++;

									}

								}

							}

						}

						if (EmailingAge.this.membres.size() != 0) {

							EmailingAge.this.model = new DefaultTableModel(
									EmailingAge.this.donnees,
									EmailingAge.this.entetes);

							EmailingAge.this.table_3
									.setModel(EmailingAge.this.model);

						}

					}

					EmailingAge.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingAge.this.lblExportxls.setVisible(true);
					EmailingAge.this.lblExportCvs.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(895, 410, 135, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(246, 453, 788, 196);
			this.scrollPane_1.setViewportView(this.getTable_3());
		}
		return this.scrollPane_1;
	}

	private JSlider getSlider_1() {
		if (this.slider == null) {
			this.slider = new JSlider(SwingConstants.HORIZONTAL, 18, 100, 18);
			this.slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {

					EmailingAge.this.valuemin = EmailingAge.this.slider
							.getValue();
					EmailingAge.this.slider_1
							.setValue(EmailingAge.this.valuemin);
					EmailingAge.this.lblAgeMinimum.setText("Age Minimum : "
							+ EmailingAge.this.valuemin);

				}

			});

			this.slider.setBounds(246, 177, 200, 23);
		}
		return this.slider;
	}

	private JSlider getSlider_1_1() {
		if (this.slider_1 == null) {
			this.slider_1 = new JSlider(SwingConstants.HORIZONTAL, 18, 100, 18);
			this.slider_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(final MouseEvent arg0) {
					if (EmailingAge.this.valuemax >= EmailingAge.this.valuemin) {
						EmailingAge.this.lblValider.setVisible(true);
						EmailingAge.this.chckbxSurLensembleDes.setVisible(true);

						EmailingAge.this.lblOu.setVisible(true);

						EmailingAge.this.comboBox_1.setVisible(true);
						EmailingAge.this.comboBox_1.setEnabled(true);

						EmailingAge.this.lblMerciDeSlectionner_1
								.setVisible(true);
						EmailingAge.this.lblValider.setVisible(false);
						EmailingAge.this.etatbouton = false;

					} else {
						final String message = "Age maximum < Age Minimum";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingAge.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						EmailingAge.this.interfaceActuelle.setEnabled(false);
						EmailingAge.this.interfaceActuelle.setVisible(false);
						EmailingAge.this.lblValider.setVisible(false);
						EmailingAge.this.lblValider.setEnabled(false);
						EmailingAge.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingAge.this.chckbxSurLensembleDes
								.setVisible(false);
						EmailingAge.this.comboBox_1.setVisible(false);

						EmailingAge.this.chckbxNom.setSelected(true);
						EmailingAge.this.chckbxPrnom.setSelected(true);
						EmailingAge.this.chckbxCivilit.setSelected(true);
						EmailingAge.this.chckbxAdresse.setSelected(true);
						EmailingAge.this.chckbxCodepostal.setSelected(true);
						EmailingAge.this.chckbxVille.setSelected(true);
						EmailingAge.this.chckbxEmail.setSelected(true);
						EmailingAge.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingAge.this.chckbxNCarteDe.setSelected(true);
						EmailingAge.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingAge.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingAge.this.chckbxAge.setSelected(true);
						EmailingAge.this.chckbxTelephone.setSelected(true);
						EmailingAge.this.chckbxMobile.setSelected(true);
						EmailingAge.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingAge.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingAge.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingAge.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingAge.this.lblExportxls.setVisible(false);
						EmailingAge.this.lblExportCvs.setVisible(false);
						if ((EmailingAge.this.table_3.getRowCount() != 0)
								&& (EmailingAge.this.table_3.getColumnCount() != 0)) {
							EmailingAge.this.model.setColumnCount(0);
							EmailingAge.this.model.setRowCount(0);
							EmailingAge.this.table_3
									.setModel(EmailingAge.this.model);
							EmailingAge.this.table_3.repaint();
						}
					}
				}
			});
			this.slider_1.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent e) {

					EmailingAge.this.valuemax = EmailingAge.this.slider_1
							.getValue();
					EmailingAge.this.lblAgeMaximum.setText("Age Maximum : "
							+ EmailingAge.this.valuemax);

				}
			});
			this.slider_1.setBounds(537, 177, 200, 23);

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
