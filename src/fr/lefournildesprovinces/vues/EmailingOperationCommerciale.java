package fr.lefournildesprovinces.vues;

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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.OperationCommerciale;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.util.ExcelExporter;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class EmailingOperationCommerciale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4585613773891453209L;
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
	private JLayeredPane layeredPane;
	private JLabel lblEmailingParMagasin;
	private JLabel lblExportCvs;
	private JLabel lblExportxls;
	private JLabel lblFermer;
	private JLabel lblMerciDeSlectionner;
	private JLabel lblMerciDeSlectionner_1;
	private JLabel lblNewLabel;
	private JLabel lblOu;
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

	public EmailingOperationCommerciale(final JFrame interfacepre) {
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
							EmailingOperationCommerciale.this.chckbxToutDselectionner
									.setSelected(false);
							EmailingOperationCommerciale.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(855, 331, 188, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(344, 331, 97, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(242, 331, 100, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(344, 385, 97, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxDateDeNaissance.setForeground(Color.GRAY);
			this.chckbxDateDeNaissance
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxDateDeNaissance.setBounds(443, 331, 141, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(443, 357, 141, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(855, 357, 188, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNCarteDe.setForeground(Color.GRAY);
			this.chckbxNCarteDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNCarteDe.setBounds(586, 331, 157, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(242, 357, 100, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(242, 385, 100, 23);
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

							if (EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EmailingOperationCommerciale.this.table_3
										.selectAll();
								EmailingOperationCommerciale.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(242, 678, 280, 23);
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
			this.chckbxSurLensembleDes.setBounds(242, 236, 219, 23);
			this.chckbxSurLensembleDes.setSelected(true);
			this.chckbxSurLensembleDes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					if (EmailingOperationCommerciale.this.chckbxSurLensembleDes
							.isSelected() != true) {

						EmailingOperationCommerciale.this.comboBox_1
								.setVisible(true);
						EmailingOperationCommerciale.this.comboBox_1
								.setEnabled(true);
						EmailingOperationCommerciale.this.lblOu
								.setVisible(true);
						// lblMerciDeSlectionner_1.setVisible(true);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(false);
						EmailingOperationCommerciale.this.etatbouton = false;
					} else

					{
						EmailingOperationCommerciale.this.comboBox_1
								.setVisible(false);
						EmailingOperationCommerciale.this.comboBox_1
								.setEnabled(false);
						EmailingOperationCommerciale.this.lblOu
								.setVisible(false);
						EmailingOperationCommerciale.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(true);
						EmailingOperationCommerciale.this.etatbouton = true;

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

					EmailingOperationCommerciale.this.chckbxNom
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxPrnom
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxCivilit
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxAdresse
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxCodepostal
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxVille
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxEmail
							.setSelected(false);
					EmailingOperationCommerciale.this.checkBox
							.setSelected(false);
					EmailingOperationCommerciale.this.checkBox_2
							.setSelected(false);
					EmailingOperationCommerciale.this.checkBox_1
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxNCarteDe
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxDateDeNaissance
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxMagasinDeReference
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(242, 445, 157, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EmailingOperationCommerciale.this.chckbxNom
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxPrnom
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxCivilit
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxAdresse
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxCodepostal
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxVille
							.setSelected(true);
					EmailingOperationCommerciale.this.checkBox
							.setSelected(true);
					EmailingOperationCommerciale.this.checkBox_1
							.setSelected(true);
					EmailingOperationCommerciale.this.checkBox_2
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxEmail
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxNCarteDe
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxDateDeNaissance
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxMagasinDeReference
							.setSelected(true);
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(422, 445, 151, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(344, 357, 97, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(745, 331, 108, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(745, 357, 108, 23);
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
					EmailingOperationCommerciale.this.chckbxToutDselectionner
							.setSelected(false);
					EmailingOperationCommerciale.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_2.setSelected(true);
			this.checkBox_2.setForeground(Color.GRAY);
			this.checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox_2.setBounds(586, 357, 157, 23);
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

						EmailingOperationCommerciale.this.selectionIDOperation = ((OperationCommerciale) EmailingOperationCommerciale.this.comboBox
								.getSelectedItem()).getIdOperationCommerciale();
						EmailingOperationCommerciale.this.lblMerciDeSlectionner
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setEnabled(false);
						EmailingOperationCommerciale.this.lblMerciDeSlectionner
								.setVisible(true);
						EmailingOperationCommerciale.this.chckbxNom
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxPrnom
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxCivilit
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxAdresse
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxCodepostal
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxVille
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxEmail
								.setSelected(true);
						EmailingOperationCommerciale.this.checkBox
								.setSelected(true);
						EmailingOperationCommerciale.this.checkBox_1
								.setSelected(true);
						EmailingOperationCommerciale.this.checkBox_2
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxNCarteDe
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingOperationCommerciale.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingOperationCommerciale.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingOperationCommerciale.this.lblExportxls
								.setVisible(false);
						EmailingOperationCommerciale.this.lblExportCvs
								.setVisible(false);
						if ((EmailingOperationCommerciale.this.table_3
								.getRowCount() != 0)
								&& (EmailingOperationCommerciale.this.table_3
										.getColumnCount() != 0)) {
							EmailingOperationCommerciale.this.model
									.setColumnCount(0);
							EmailingOperationCommerciale.this.model
									.setRowCount(0);
							EmailingOperationCommerciale.this.table_3
									.setModel(EmailingOperationCommerciale.this.model);
							EmailingOperationCommerciale.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox.setBounds(242, 169, 776, 22);
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
						EmailingOperationCommerciale.this.selectionIDMagasin = ((Magasin) EmailingOperationCommerciale.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						EmailingOperationCommerciale.this.lblMerciDeSlectionner_1
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(true);

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setEnabled(false);
						EmailingOperationCommerciale.this.lblMerciDeSlectionner_1
								.setVisible(true);
						EmailingOperationCommerciale.this.chckbxNom
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxPrnom
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxCivilit
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxAdresse
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxCodepostal
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxVille
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxEmail
								.setSelected(true);
						EmailingOperationCommerciale.this.checkBox
								.setSelected(true);
						EmailingOperationCommerciale.this.checkBox_1
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxAbonnementNewsletter
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxNCarteDe
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxDateDeNaissance
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxMagasinDeReference
								.setSelected(true);
						EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingOperationCommerciale.this.chckbxToutSlectionner
								.setSelected(false);
						EmailingOperationCommerciale.this.chckbxToutDselectionner
								.setSelected(false);
						EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
								.setVisible(false);
						EmailingOperationCommerciale.this.lblExportxls
								.setVisible(false);
						EmailingOperationCommerciale.this.lblExportCvs
								.setVisible(false);
						if ((EmailingOperationCommerciale.this.table_3
								.getRowCount() != 0)
								&& (EmailingOperationCommerciale.this.table_3
										.getColumnCount() != 0)) {
							EmailingOperationCommerciale.this.model
									.setColumnCount(0);
							EmailingOperationCommerciale.this.model
									.setRowCount(0);
							EmailingOperationCommerciale.this.table_3
									.setModel(EmailingOperationCommerciale.this.model);
							EmailingOperationCommerciale.this.table_3.repaint();
						}
					}

				}
			});
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(532, 236, 486, 22);
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
			this.fond.setIcon(new ImageIcon(EmailingOperationCommerciale.class
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
					EmailingOperationCommerciale.this.dispose();
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
					EmailingOperationCommerciale.this.dispose();
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
					EmailingOperationCommerciale.this.dispose();
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
					EmailingOperationCommerciale.this.dispose();
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
			this.label_4.setBounds(242, 703, 331, 14);
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
			this.layeredPane.add(this.getLblOu());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());

		}
		return this.layeredPane;
	}

	private JLabel getLblEmailingParMagasin() {
		if (this.lblEmailingParMagasin == null) {
			this.lblEmailingParMagasin = new JLabel(
					"tri par Operation Commerciale (Clients  titulaire d'une carte de fidelit\u00E9)");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 110, 441, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(
					EmailingOperationCommerciale.class
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
							EmailingOperationCommerciale.this.desktopPath = System
									.getProperty("user.home") + "";
						} else {
							EmailingOperationCommerciale.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingOperationCommerciale.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par operation commerciale (titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EmailingOperationCommerciale.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EmailingOperationCommerciale.this.entetes.length - 1); i++) {
								if (EmailingOperationCommerciale.this.donnees[j][i] != null) {
									writer.append(EmailingOperationCommerciale.this.donnees[j][i]
											.toString());
									if (i == (EmailingOperationCommerciale.this.entetes.length - 1)) {
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

						EmailingOperationCommerciale.this.Message = "Exportation du fichier Extraction par opération (titulaire carte).csv réalisée avec succès";
						EmailingOperationCommerciale.this.etat = true;
						EmailingOperationCommerciale.this.choixformat = "CSV5";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommerciale.this.Message,
								EmailingOperationCommerciale.this.interfaceActuelle,
								EmailingOperationCommerciale.this.etat,
								EmailingOperationCommerciale.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EmailingOperationCommerciale.this.Message = "Impossible de générer le fichier CSV";
						EmailingOperationCommerciale.this.etat = false;
						EmailingOperationCommerciale.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommerciale.this.Message,
								EmailingOperationCommerciale.this.interfaceActuelle,
								EmailingOperationCommerciale.this.etat,
								EmailingOperationCommerciale.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(885, 683, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(
					EmailingOperationCommerciale.class
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
							EmailingOperationCommerciale.this.desktopPath = System
									.getProperty("user.home") + "";
						} else {
							EmailingOperationCommerciale.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EmailingOperationCommerciale.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par operation commerciale (titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(
								EmailingOperationCommerciale.this.table_3, file);
						EmailingOperationCommerciale.this.etat = true;
						EmailingOperationCommerciale.this.Message = "Exportation du fichier Extraction par opération (titulaire carte).xls réalisée avec succès";
						EmailingOperationCommerciale.this.choixformat = "XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommerciale.this.Message,
								EmailingOperationCommerciale.this.interfaceActuelle,
								EmailingOperationCommerciale.this.etat,
								EmailingOperationCommerciale.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EmailingOperationCommerciale.this.etat = false;
						EmailingOperationCommerciale.this.choixformat = "XLS5";
						EmailingOperationCommerciale.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EmailingOperationCommerciale.this.Message,
								EmailingOperationCommerciale.this.interfaceActuelle,
								EmailingOperationCommerciale.this.etat,
								EmailingOperationCommerciale.this.choixformat);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(712, 689, 133, 28);
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
					EmailingOperationCommerciale.this.dispose();
					EmailingOperationCommerciale.this.interfacePrecedente
							.setVisible(true);
					EmailingOperationCommerciale.this.interfacePrecedente
							.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(874, 55, 169, 44);
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
			this.lblMerciDeSlectionner.setBounds(496, 173, 312, 14);
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
			this.lblMerciDeSlectionner_1.setBounds(681, 240, 230, 14);
			this.lblMerciDeSlectionner_1.setEnabled(true);

		}
		return this.lblMerciDeSlectionner_1;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					EmailingOperationCommerciale.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblOu() {
		if (this.lblOu == null) {
			this.lblOu = new JLabel("Ou");
			this.lblOu.setForeground(Color.GRAY);
			this.lblOu.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOu.setBounds(469, 240, 41, 14);
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
			this.lblSelectionnerLesInformations.setBounds(242, 299, 268, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(
					EmailingOperationCommerciale.class
							.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EmailingOperationCommerciale.this.checkBox.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.checkBox_1
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxCivilit
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.checkBox_2
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxNom
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxPrnom
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxAdresse
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxVille
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxCodepostal
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxDateDeNaissance
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxEmail
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxNCarteDe
							.isSelected() == true) {

						compteur++;
					}
					if (EmailingOperationCommerciale.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (compteur > 4) {
						EmailingOperationCommerciale.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EmailingOperationCommerciale.this.membres = Select
							.eMailingoperationcommerciale(
									EmailingOperationCommerciale.this.selectionIDOperation,
									EmailingOperationCommerciale.this.selectionIDMagasin,
									EmailingOperationCommerciale.this.etatbouton);

					if (EmailingOperationCommerciale.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(false);

						if ((EmailingOperationCommerciale.this.table_3
								.getRowCount() != 0)
								|| (EmailingOperationCommerciale.this.table_3
										.getColumnCount() != 0)) {
							EmailingOperationCommerciale.this.model
									.setColumnCount(0);
							EmailingOperationCommerciale.this.model
									.setRowCount(0);
							EmailingOperationCommerciale.this.table_3
									.setModel(EmailingOperationCommerciale.this.model);
							EmailingOperationCommerciale.this.table_3.repaint();
						}
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EmailingOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						EmailingOperationCommerciale.this.interfaceActuelle
								.setVisible(false);
						EmailingOperationCommerciale.this.lblValider
								.setVisible(false);

						EmailingOperationCommerciale.this.lblMerciDeSlectionner
								.setVisible(true);

					} else

					{

						EmailingOperationCommerciale.this.entetes = new String[compteur];

						EmailingOperationCommerciale.this.donnees = new Object[EmailingOperationCommerciale.this.membres
								.size()][EmailingOperationCommerciale.this.entetes.length];

						for (int j = 0; j < EmailingOperationCommerciale.this.membres
								.size(); j++) {

							for (int i = 0; i < (EmailingOperationCommerciale.this.entetes.length - 1); i++) {

								if (EmailingOperationCommerciale.this.chckbxCivilit
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Civilité";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EmailingOperationCommerciale.this.chckbxNom
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Nom";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getNomIndividu();
									i++;

								}
								if (EmailingOperationCommerciale.this.chckbxPrnom
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Prénom";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getPrenomIndividu();
									i++;

								}
								if (EmailingOperationCommerciale.this.chckbxAdresse
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Adresse";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EmailingOperationCommerciale.this.chckbxVille
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Ville";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EmailingOperationCommerciale.this.chckbxCodepostal
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Code Postal";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}
								if (EmailingOperationCommerciale.this.chckbxDateDeNaissance
										.isSelected() == true) {
									if (EmailingOperationCommerciale.this.membres
											.get(j).getDateNaissanceIndividu() != null) {
										EmailingOperationCommerciale.this.entetes[i] = "Date de Naissance";
										EmailingOperationCommerciale.this.donnees[j][i] = "'"
												+ EmailingOperationCommerciale.this.membres
														.get(j)
														.getDateNaissanceIndividu();
										i++;
									} else {
										EmailingOperationCommerciale.this.entetes[i] = "Date de Naissance";
										EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
												.get(j)
												.getDateNaissanceIndividu();
										i++;
									}
								}
								if (EmailingOperationCommerciale.this.checkBox_2
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Age";

									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EmailingOperationCommerciale.this.chckbxEmail
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Adresse Mail";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EmailingOperationCommerciale.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Newsletter";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}
								if (EmailingOperationCommerciale.this.chckbxNCarteDe
										.isSelected() == true) {
									if (EmailingOperationCommerciale.this.membres
											.get(j).getNumerocarte() != null) {
										EmailingOperationCommerciale.this.entetes[i] = "N°Client";
										EmailingOperationCommerciale.this.donnees[j][i] = "'"
												+ EmailingOperationCommerciale.this.membres
														.get(j)
														.getNumerocarte();
										i++;
									} else {
										EmailingOperationCommerciale.this.entetes[i] = "N°Client";
										EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
												.get(j).getNumerocarte();
										i++;
									}
								}
								if (EmailingOperationCommerciale.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EmailingOperationCommerciale.this.entetes[i] = "Magasin";
									EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EmailingOperationCommerciale.this.checkBox
										.isSelected() == true) {
									if (EmailingOperationCommerciale.this.membres
											.get(j).getTelephonefixe() != null) {
										EmailingOperationCommerciale.this.entetes[i] = "Téléphone";
										EmailingOperationCommerciale.this.donnees[j][i] = "'"
												+ EmailingOperationCommerciale.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EmailingOperationCommerciale.this.entetes[i] = "Téléphone";
										EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
												.get(j).getTelephonefixe();
										i++;
									}

								}
								if (EmailingOperationCommerciale.this.checkBox_1
										.isSelected() == true) {
									if (EmailingOperationCommerciale.this.membres
											.get(j).getTelephonemobile() != null) {
										EmailingOperationCommerciale.this.entetes[i] = "Mobile";
										EmailingOperationCommerciale.this.donnees[j][i] = "'"
												+ EmailingOperationCommerciale.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EmailingOperationCommerciale.this.entetes[i] = "Mobile";
										EmailingOperationCommerciale.this.donnees[j][i] = EmailingOperationCommerciale.this.membres
												.get(j).getTelephonemobile();
										i++;
									}

								}
							}

						}

						if (EmailingOperationCommerciale.this.membres.size() != 0) {

							EmailingOperationCommerciale.this.model = new DefaultTableModel(
									EmailingOperationCommerciale.this.donnees,
									EmailingOperationCommerciale.this.entetes);

							EmailingOperationCommerciale.this.table_3
									.setModel(EmailingOperationCommerciale.this.model);

						}

					}

					EmailingOperationCommerciale.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EmailingOperationCommerciale.this.lblExportxls
							.setVisible(true);
					EmailingOperationCommerciale.this.lblExportCvs
							.setVisible(true);

				}
			});
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(919, 445, 99, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(new LineBorder(Color.GRAY));
			this.scrollPane_1.setBounds(242, 488, 776, 183);
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
