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

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.excelandcvsoperations.ExcelExporter;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class EnsembleSansCarte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8894792559551482873L;
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
	private JLabel lblNewLabel;
	private JLabel lblSelectionnerLesInformations;
	private JLabel lblValider;
	private Vector<ResultatRecherche> membres;
	private String Message;
	private DefaultTableModel model;
	private JScrollPane scrollPane_1;
	private JTable table_3;

	public EnsembleSansCarte(final JFrame interfacepre) {
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
							EnsembleSansCarte.this.chckbxToutDselectionner
									.setSelected(false);
							EnsembleSansCarte.this.chckbxToutSlectionner
									.setSelected(false);
						}
					});
			this.chckbxAbonnementNewsletter.setForeground(Color.GRAY);
			this.chckbxAbonnementNewsletter.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxAbonnementNewsletter.setBounds(860, 198, 186, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxAdresse.setForeground(Color.GRAY);
			this.chckbxAdresse.setBounds(472, 198, 90, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCivilit.setForeground(Color.GRAY);
			this.chckbxCivilit.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCivilit.setBounds(242, 198, 110, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxCodepostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxCodepostal.setForeground(Color.GRAY);
			this.chckbxCodepostal.setBounds(332, 224, 138, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxEmail.setForeground(Color.GRAY);
			this.chckbxEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxEmail.setBounds(860, 224, 186, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxMagasinDeReference.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxMagasinDeReference.setForeground(Color.GRAY);
			this.chckbxMagasinDeReference.setBounds(574, 198, 167, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxNom.setForeground(Color.GRAY);
			this.chckbxNom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxNom.setBounds(242, 224, 90, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxPrnom.setForeground(Color.GRAY);
			this.chckbxPrnom.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxPrnom.setBounds(332, 198, 138, 23);
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

							if (EnsembleSansCarte.this.chckbxSelectionnerLensembleDes
									.isSelected() == true) {
								EnsembleSansCarte.this.table_3.selectAll();
								EnsembleSansCarte.this.table_3
										.setFocusable(true);

							}
						}
					});
			this.chckbxSelectionnerLensembleDes.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.chckbxSelectionnerLensembleDes.setForeground(Color.GRAY);
			this.chckbxSelectionnerLensembleDes.setBounds(242, 679, 283, 23);
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

					EnsembleSansCarte.this.chckbxNom.setSelected(false);
					EnsembleSansCarte.this.chckbxPrnom.setSelected(false);
					EnsembleSansCarte.this.chckbxCivilit.setSelected(false);
					EnsembleSansCarte.this.chckbxAdresse.setSelected(false);
					EnsembleSansCarte.this.chckbxCodepostal.setSelected(false);
					EnsembleSansCarte.this.chckbxVille.setSelected(false);
					EnsembleSansCarte.this.chckbxEmail.setSelected(false);
					EnsembleSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(false);
					EnsembleSansCarte.this.checkBox.setSelected(false);
					EnsembleSansCarte.this.checkBox_1.setSelected(false);

					EnsembleSansCarte.this.chckbxMagasinDeReference
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
					EnsembleSansCarte.this.checkBox_2.setSelected(false);

				}
			});
			this.chckbxToutDselectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.chckbxToutDselectionner.setForeground(Color.GRAY);
			this.chckbxToutDselectionner.setBounds(242, 334, 175, 23);
		}
		return this.chckbxToutDselectionner;
	}

	private JCheckBox getChckbxToutSlectionner() {
		if (this.chckbxToutSlectionner == null) {
			this.chckbxToutSlectionner = new JCheckBox("Tout s\u00E9lectionner");
			this.chckbxToutSlectionner.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					EnsembleSansCarte.this.chckbxNom.setSelected(true);
					EnsembleSansCarte.this.chckbxPrnom.setSelected(true);
					EnsembleSansCarte.this.chckbxCivilit.setSelected(true);
					EnsembleSansCarte.this.chckbxAdresse.setSelected(true);
					EnsembleSansCarte.this.chckbxCodepostal.setSelected(true);
					EnsembleSansCarte.this.chckbxVille.setSelected(true);
					EnsembleSansCarte.this.chckbxEmail.setSelected(true);
					EnsembleSansCarte.this.chckbxAbonnementNewsletter
							.setSelected(true);
					EnsembleSansCarte.this.checkBox.setSelected(true);
					EnsembleSansCarte.this.checkBox_2.setSelected(false);
					EnsembleSansCarte.this.checkBox_1.setSelected(true);

					EnsembleSansCarte.this.chckbxMagasinDeReference
							.setSelected(true);
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
				}
			});
			this.chckbxToutSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxToutSlectionner.setForeground(Color.GRAY);
			this.chckbxToutSlectionner.setBounds(419, 334, 154, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.chckbxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.chckbxVille.setForeground(Color.GRAY);
			this.chckbxVille.setBounds(472, 224, 90, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox.setForeground(Color.GRAY);
			this.checkBox.setBounds(743, 198, 100, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_1.setForeground(Color.GRAY);
			this.checkBox_1.setBounds(743, 224, 100, 23);
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
					EnsembleSansCarte.this.chckbxToutDselectionner
							.setSelected(false);
					EnsembleSansCarte.this.chckbxToutSlectionner
							.setSelected(false);
				}
			});
			this.checkBox_2.setSelected(true);
			this.checkBox_2.setForeground(Color.GRAY);
			this.checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.checkBox_2.setBounds(574, 224, 167, 23);
		}
		return this.checkBox_2;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(EnsembleSansCarte.class
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
					EnsembleSansCarte.this.dispose();
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
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					EnsembleSansCarte.this.dispose();
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
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					EnsembleSansCarte.this.dispose();
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
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					EnsembleSansCarte.this.dispose();
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
			this.label_4.setBounds(242, 706, 307, 14);
		}
		return this.label_4;
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
					"Ensemble des client non titulaire d'une carte de fid\u00E9lit\u00E9");
			this.lblEmailingParMagasin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailingParMagasin.setForeground(Color.GRAY);
			this.lblEmailingParMagasin.setBounds(242, 110, 345, 14);
		}
		return this.lblEmailingParMagasin;
	}

	private JLabel getLblExportCvs() {
		if (this.lblExportCvs == null) {
			this.lblExportCvs = new JLabel("");
			this.lblExportCvs.setIcon(new ImageIcon(EnsembleSansCarte.class
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
							EnsembleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EnsembleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EnsembleSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par ensemble client (non titulaire carte).csv");

						final FileWriter writer = new FileWriter(file);

						for (int j = 0; j < EnsembleSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i <= (EnsembleSansCarte.this.entetes.length - 1); i++) {
								if (EnsembleSansCarte.this.donnees[j][i] != null) {
									writer.append(EnsembleSansCarte.this.donnees[j][i]
											.toString());
									if (i == (EnsembleSansCarte.this.entetes.length - 1)) {
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

						EnsembleSansCarte.this.Message = "Exportation du fichier Extraction par ensemble client (non titulaire carte).csv réalisée avec succès";
						EnsembleSansCarte.this.etat = true;
						EnsembleSansCarte.this.choixformat = "CSV10";
						final MessageExport fenetre = new MessageExport(
								EnsembleSansCarte.this.Message,
								EnsembleSansCarte.this.interfaceActuelle,
								EnsembleSansCarte.this.etat,
								EnsembleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EnsembleSansCarte.this.interfaceActuelle
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e) {
						e.printStackTrace();
						EnsembleSansCarte.this.Message = "Impossible de générer le fichier CSV";
						EnsembleSansCarte.this.etat = false;
						EnsembleSansCarte.this.choixformat = "CSV";
						final MessageExport fenetre = new MessageExport(
								EnsembleSansCarte.this.Message,
								EnsembleSansCarte.this.interfaceActuelle,
								EnsembleSansCarte.this.etat,
								EnsembleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EnsembleSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportCvs.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblExportCvs.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblExportCvs.setForeground(Color.GRAY);
			this.lblExportCvs.setBounds(897, 679, 133, 34);
		}
		return this.lblExportCvs;
	}

	private JLabel getLblExportxls() {
		if (this.lblExportxls == null) {
			this.lblExportxls = new JLabel("");
			this.lblExportxls.setIcon(new ImageIcon(EnsembleSansCarte.class
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
							EnsembleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							EnsembleSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								EnsembleSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Extraction par ensemble client (non titulaire carte).xls");

						final ExcelExporter exp = new ExcelExporter();
						exp.exportTable(EnsembleSansCarte.this.table_3, file);
						EnsembleSansCarte.this.etat = true;
						EnsembleSansCarte.this.Message = "Exportation du fichier Extraction par ensemble client (non titulaire carte).xls réalisée avec succès";
						EnsembleSansCarte.this.choixformat = "XLS10";
						final MessageExport fenetre = new MessageExport(
								EnsembleSansCarte.this.Message,
								EnsembleSansCarte.this.interfaceActuelle,
								EnsembleSansCarte.this.etat,
								EnsembleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EnsembleSansCarte.this.interfaceActuelle
								.setEnabled(false);

					} catch (final IOException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
						EnsembleSansCarte.this.etat = false;
						EnsembleSansCarte.this.choixformat = "XLS";
						EnsembleSansCarte.this.Message = "Impossible de générer le fichier XLS";
						final MessageExport fenetre = new MessageExport(
								EnsembleSansCarte.this.Message,
								EnsembleSansCarte.this.interfaceActuelle,
								EnsembleSansCarte.this.etat,
								EnsembleSansCarte.this.choixformat);
						fenetre.setVisible(true);
						EnsembleSansCarte.this.interfaceActuelle
								.setEnabled(false);

					}

				}
			});
			this.lblExportxls.setBounds(742, 685, 133, 28);
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
					EnsembleSansCarte.this.dispose();
					EnsembleSansCarte.this.interfacePrecedente.setVisible(true);
					EnsembleSansCarte.this.interfacePrecedente.setEnabled(true);
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(885, 55, 155, 44);
		}
		return this.lblFermer;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(EnsembleSansCarte.class
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
			this.lblSelectionnerLesInformations.setBounds(242, 163, 283, 14);
		}
		return this.lblSelectionnerLesInformations;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(EnsembleSansCarte.class
					.getResource("/Images/valider.png")));
			this.lblValider.setHorizontalAlignment(SwingConstants.RIGHT);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					int compteur = 0;
					if (EnsembleSansCarte.this.checkBox.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.checkBox_1.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.checkBox_2.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxCivilit.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxNom.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxPrnom.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxAdresse.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxVille.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxCodepostal.isSelected() == true) {

						compteur++;
					}

					if (EnsembleSansCarte.this.chckbxEmail.isSelected() == true) {

						compteur++;
					}
					if (EnsembleSansCarte.this.chckbxAbonnementNewsletter
							.isSelected() == true) {

						compteur++;
					}

					if (EnsembleSansCarte.this.chckbxMagasinDeReference
							.isSelected() == true) {

						compteur++;
					}
					if (compteur > 4) {
						EnsembleSansCarte.this.table_3
								.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					}
					System.out.print(compteur);

					EnsembleSansCarte.this.membres = Select.ensembleSansCarte();

					if (EnsembleSansCarte.this.membres.size() == 0) {
						final String message = "Aucun Résultat";

						final AlerteSelection fenetre = new AlerteSelection(
								EnsembleSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EnsembleSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EnsembleSansCarte.this.chckbxSelectionnerLensembleDes
								.setSelected(false);
						EnsembleSansCarte.this.lblValider.setVisible(false);

						if ((EnsembleSansCarte.this.table_3.getRowCount() != 0)
								|| (EnsembleSansCarte.this.table_3
										.getColumnCount() != 0)) {
							EnsembleSansCarte.this.model.setColumnCount(0);
							EnsembleSansCarte.this.model.setRowCount(0);
							EnsembleSansCarte.this.table_3
									.setModel(EnsembleSansCarte.this.model);
							EnsembleSansCarte.this.table_3.repaint();
						}
					}
					if (compteur < 2) {
						final String message = "Deux choix en sortie minimum";

						final AlerteSelection fenetre = new AlerteSelection(
								EnsembleSansCarte.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						EnsembleSansCarte.this.interfaceActuelle
								.setEnabled(false);
						EnsembleSansCarte.this.interfaceActuelle
								.setVisible(false);
						EnsembleSansCarte.this.lblValider.setVisible(false);

					} else

					{

						EnsembleSansCarte.this.entetes = new String[compteur];

						EnsembleSansCarte.this.donnees = new Object[EnsembleSansCarte.this.membres
								.size()][EnsembleSansCarte.this.entetes.length];

						for (int j = 0; j < EnsembleSansCarte.this.membres
								.size(); j++) {

							for (int i = 0; i < (EnsembleSansCarte.this.entetes.length - 1); i++) {

								if (EnsembleSansCarte.this.chckbxCivilit
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Civilité";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getCiviliteIndividu();
									i++;

								}
								if (EnsembleSansCarte.this.chckbxNom
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Nom";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getNomIndividu();
									i++;

								}
								if (EnsembleSansCarte.this.chckbxPrnom
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Prénom";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getPrenomIndividu();
									i++;

								}
								if (EnsembleSansCarte.this.chckbxAdresse
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Adresse";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getAdresseIndividu();
									i++;
								}
								if (EnsembleSansCarte.this.chckbxVille
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Ville";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getVilleIndividu();
									i++;
								}
								if (EnsembleSansCarte.this.chckbxCodepostal
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Code Postal";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getCodePostalIndividu();
									i++;
								}

								if (EnsembleSansCarte.this.checkBox_2
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Age";

									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getAge() + " ans";
									i++;
								}
								if (EnsembleSansCarte.this.chckbxEmail
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Adresse Mail";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getEmail();
									i++;
								}
								if (EnsembleSansCarte.this.chckbxAbonnementNewsletter
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Newsletter";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getNewsletterIndividu();
									i++;
								}

								if (EnsembleSansCarte.this.chckbxMagasinDeReference
										.isSelected() == true) {
									EnsembleSansCarte.this.entetes[i] = "Magasin";
									EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
											.get(j).getNommagasin();
									i++;
								}
								if (EnsembleSansCarte.this.checkBox
										.isSelected() == true) {
									if (EnsembleSansCarte.this.membres.get(j)
											.getTelephonefixe() != null) {
										EnsembleSansCarte.this.entetes[i] = "Téléphone";
										EnsembleSansCarte.this.donnees[j][i] = "'"
												+ EnsembleSansCarte.this.membres
														.get(j)
														.getTelephonefixe();
										i++;
									} else {
										EnsembleSansCarte.this.entetes[i] = "Téléphone";
										EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
												.get(j).getTelephonefixe();
										i++;
									}

								}
								if (EnsembleSansCarte.this.checkBox_1
										.isSelected() == true) {
									if (EnsembleSansCarte.this.membres.get(j)
											.getTelephonemobile() != null) {
										EnsembleSansCarte.this.entetes[i] = "Mobile";
										EnsembleSansCarte.this.donnees[j][i] = "'"
												+ EnsembleSansCarte.this.membres
														.get(j)
														.getTelephonemobile();
										i++;
									} else {
										EnsembleSansCarte.this.entetes[i] = "Mobile";
										EnsembleSansCarte.this.donnees[j][i] = EnsembleSansCarte.this.membres
												.get(j).getTelephonemobile();
										i++;
									}

								}
							}

						}

						if (EnsembleSansCarte.this.membres.size() != 0) {

							EnsembleSansCarte.this.model = new DefaultTableModel(
									EnsembleSansCarte.this.donnees,
									EnsembleSansCarte.this.entetes);

							EnsembleSansCarte.this.table_3
									.setModel(EnsembleSansCarte.this.model);

						}

					}

					EnsembleSansCarte.this.chckbxSelectionnerLensembleDes
							.setVisible(true);
					EnsembleSansCarte.this.lblExportxls.setVisible(true);
					EnsembleSansCarte.this.lblExportCvs.setVisible(true);

				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(934, 334, 99, 23);
		}
		return this.lblValider;
	}

	private JScrollPane getScrollPane_1() {
		if (this.scrollPane_1 == null) {
			this.scrollPane_1 = new JScrollPane();
			this.scrollPane_1.setBorder(null);
			this.scrollPane_1.setBounds(242, 378, 791, 293);
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
