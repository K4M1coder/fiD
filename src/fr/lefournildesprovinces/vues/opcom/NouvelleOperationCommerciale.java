package fr.lefournildesprovinces.vues.opcom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.SuccesOperation;

public class NouvelleOperationCommerciale extends JFrame {

	private static Connection c;
	/**
	 *
	 */
	private static final long serialVersionUID = -1917680553948794549L;
	private static PreparedStatement stm;
	private String AnneeDebut;
	private String AnneeFin;
	private JComboBox<Object> comboBoxAnneeDebut;
	private JComboBox<Object> comboBoxAnneeFin;
	private JComboBox<Object> comboBoxJourDebut;
	private JComboBox<Object> comboBoxJourFin;
	private JComboBox<Object> comboBoxMoisDebut;
	private JComboBox<Object> comboBoxMoisFin;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasintest = 0;
	private final int idoperationtest = 0;
	private final JFrame interfaceActuelle;
	private String JourDebut;
	private String JourFin;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblAnneDebut;
	private JLabel lblAnneFin;
	private JLabel lblChampsObligatoire;
	private JLabel lblDateDeDbut;
	private JLabel lblDateDeFin;
	private JLabel lblFermer;
	private JLabel lblJourDebut;
	private JLabel lblJourFin;
	private JLabel lblLibelleDeLopration;
	private JLabel lblMenuNouvelle;
	private JLabel lblMoisDebut;
	private JLabel lblMoisFin;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblValider;
	private final String messageinsertion2 = null;
	private String MoisDebut;
	private String MoisFin;
	private String privilege;
	private final String provenance = "test";
	private String text;
	private JTextField textFieldLibelleOperationCommerciale;

	public NouvelleOperationCommerciale() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

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
		this.setResizable(false);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;
	}

	private JComboBox<Object> getComboBoxAnneeDebut() {
		if (this.comboBoxAnneeDebut == null) {
			this.comboBoxAnneeDebut = new JComboBox<Object>();
			this.comboBoxAnneeDebut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						NouvelleOperationCommerciale.this.lblAnneDebut
								.setVisible(false);
						NouvelleOperationCommerciale.this.AnneeDebut = NouvelleOperationCommerciale.this.comboBoxAnneeDebut
								.getSelectedItem().toString().substring(1);
						NouvelleOperationCommerciale.this.comboBoxJourFin
								.setEnabled(true);
						NouvelleOperationCommerciale.this.lblJourFin
								.setVisible(false);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						NouvelleOperationCommerciale.this.lblAnneDebut
								.setVisible(true);
					}
				}
			});
			this.comboBoxAnneeDebut.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxAnneeDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxAnneeDebut.setForeground(Color.GRAY);
			this.comboBoxAnneeDebut.addItem(null);
			for (int annee = 2012; annee < 2035; annee++) {
				this.comboBoxAnneeDebut.addItem(" " + annee);

			}
			this.comboBoxAnneeDebut.setBackground(Color.WHITE);
			this.comboBoxAnneeDebut.setBorder(null);
			this.comboBoxAnneeDebut.setBounds(783, 408, 78, 22);
			this.comboBoxAnneeDebut.setEnabled(false);
		}
		return this.comboBoxAnneeDebut;
	}

	private JComboBox<Object> getComboBoxAnneeFin() {
		if (this.comboBoxAnneeFin == null) {
			this.comboBoxAnneeFin = new JComboBox<Object>();
			this.comboBoxAnneeFin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						NouvelleOperationCommerciale.this.lblAnneFin
								.setVisible(false);
						NouvelleOperationCommerciale.this.AnneeFin = NouvelleOperationCommerciale.this.comboBoxAnneeFin
								.getSelectedItem().toString().substring(1);
						NouvelleOperationCommerciale.this.lblValider
								.setVisible(true);
						NouvelleOperationCommerciale.this.lblValider
								.setEnabled(true);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						NouvelleOperationCommerciale.this.lblAnneFin
								.setVisible(true);
					}
				}
			});
			this.comboBoxAnneeFin.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxAnneeFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxAnneeFin.setBackground(Color.WHITE);
			this.comboBoxAnneeFin.setBorder(null);
			this.comboBoxAnneeFin.setForeground(Color.GRAY);
			this.comboBoxAnneeFin.setBounds(783, 438, 78, 22);
			this.comboBoxAnneeFin.setEnabled(false);
			this.comboBoxAnneeFin.addItem(null);
			for (int annee = 2012; annee < 2035; annee++) {
				this.comboBoxAnneeFin.addItem(" " + annee);
			}
		}
		return this.comboBoxAnneeFin;
	}

	private JComboBox<Object> getComboBoxJourDebut() {
		if (this.comboBoxJourDebut == null) {
			final String[] jour = { null, " 01", " 02", " 03", " 04", " 05",
					" 06", " 07", " 08", " 09", " 10", " 11", " 12", " 13",
					" 14", " 15", " 16", " 17", " 18", " 19", " 20", " 21",
					" 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29",
					" 30", " 31" };
			this.comboBoxJourDebut = new JComboBox<Object>(jour);
			this.comboBoxJourDebut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {

						NouvelleOperationCommerciale.this.lblJourDebut
								.setVisible(false);
						NouvelleOperationCommerciale.this.JourDebut = NouvelleOperationCommerciale.this.comboBoxJourDebut
								.getSelectedItem().toString().substring(1);
						NouvelleOperationCommerciale.this.comboBoxMoisDebut
								.setEnabled(true);
						NouvelleOperationCommerciale.this.lblMoisDebut
								.setVisible(false);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						NouvelleOperationCommerciale.this.lblJourDebut
								.setVisible(true);
					}
				}
			});
			this.comboBoxJourDebut.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxJourDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxJourDebut.setForeground(Color.GRAY);
			this.comboBoxJourDebut.setBackground(Color.WHITE);
			this.comboBoxJourDebut.setBorder(null);
			this.comboBoxJourDebut.setBounds(508, 408, 113, 22);
			this.comboBoxJourDebut.setEnabled(false);

		}
		return this.comboBoxJourDebut;
	}

	private JComboBox<Object> getComboBoxJourFin() {
		if (this.comboBoxJourFin == null) {
			final String[] jour = { null, " 01", " 02", " 03", " 04", " 05",
					" 06", " 07", " 08", " 09", " 10", " 11", " 12", " 13",
					" 14", " 15", " 16", " 17", " 18", " 19", " 20", " 21",
					" 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29",
					" 30", " 31" };
			this.comboBoxJourFin = new JComboBox<Object>(jour);

			this.comboBoxJourFin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						NouvelleOperationCommerciale.this.lblJourFin
								.setVisible(false);
						NouvelleOperationCommerciale.this.JourFin = NouvelleOperationCommerciale.this.comboBoxJourFin
								.getSelectedItem().toString().substring(1);
						NouvelleOperationCommerciale.this.comboBoxMoisFin
								.setEnabled(true);
						NouvelleOperationCommerciale.this.lblMoisFin
								.setVisible(false);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						NouvelleOperationCommerciale.this.lblJourFin
								.setVisible(true);
					}
				}
			});
			this.comboBoxJourFin.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxJourFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxJourFin.setBackground(Color.WHITE);
			this.comboBoxJourFin.setBorder(null);
			this.comboBoxJourFin.setForeground(Color.GRAY);
			this.comboBoxJourFin.setBounds(508, 438, 113, 22);
			this.comboBoxJourFin.setEnabled(false);
		}
		return this.comboBoxJourFin;
	}

	private JComboBox<Object> getComboBoxMoisDebut() {
		if (this.comboBoxMoisDebut == null) {
			final String[] mois = { null, " Janvier", " Fevrier", " Mars",
					" Avril", " Mai", " Juin", " Juillet", " Août",
					" Septembre", " Octobre", " Novembre", " Décembre" };
			this.comboBoxMoisDebut = new JComboBox<Object>(mois);
			this.comboBoxMoisDebut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						NouvelleOperationCommerciale.this.lblMoisDebut
								.setVisible(false);
						NouvelleOperationCommerciale.this.MoisDebut = NouvelleOperationCommerciale.this.comboBoxMoisDebut
								.getSelectedItem().toString().substring(1);
						NouvelleOperationCommerciale.this.comboBoxAnneeDebut
								.setEnabled(true);
						NouvelleOperationCommerciale.this.lblAnneDebut
								.setVisible(false);
						switch (NouvelleOperationCommerciale.this.MoisDebut)

						{
						case "Janvier":
							NouvelleOperationCommerciale.this.MoisDebut = "01";
							break;
						case "Fevrier":
							NouvelleOperationCommerciale.this.MoisDebut = "02";
							break;
						case "Mars":
							NouvelleOperationCommerciale.this.MoisDebut = "03";
							break;
						case "Avril":
							NouvelleOperationCommerciale.this.MoisDebut = "04";
							break;
						case "Mai":
							NouvelleOperationCommerciale.this.MoisDebut = "05";
							break;
						case "Juin":
							NouvelleOperationCommerciale.this.MoisDebut = "06";
							break;
						case "Juillet":
							NouvelleOperationCommerciale.this.MoisDebut = "07";
							break;
						case "Août":
							NouvelleOperationCommerciale.this.MoisDebut = "08";
							break;
						case "Septembre":
							NouvelleOperationCommerciale.this.MoisDebut = "09";
							break;
						case "Octobre":
							NouvelleOperationCommerciale.this.MoisDebut = "10";
							break;
						case "Novembre":
							NouvelleOperationCommerciale.this.MoisDebut = "11";
							break;
						case "Décembre":
							NouvelleOperationCommerciale.this.MoisDebut = "12";
							break;

						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vÃ©rifier votre sÃ©lection";
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						NouvelleOperationCommerciale.this.lblMoisDebut
								.setVisible(true);
					}
				}
			});
			this.comboBoxMoisDebut.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxMoisDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMoisDebut.setForeground(Color.GRAY);
			this.comboBoxMoisDebut.setBackground(Color.WHITE);
			this.comboBoxMoisDebut.setBorder(null);
			this.comboBoxMoisDebut.setBounds(631, 408, 138, 22);
			this.comboBoxMoisDebut.setEnabled(false);
		}
		return this.comboBoxMoisDebut;
	}

	private JComboBox<Object> getComboBoxMoisFin() {
		if (this.comboBoxMoisFin == null) {
			final String[] mois = { null, " Janvier", " Fevrier", " Mars",
					" Avril", " Mai", " Juin", " Juillet", " Août",
					" Septembre", " Octobre", " Novembre", " Décembre" };
			this.comboBoxMoisFin = new JComboBox<Object>(mois);
			this.comboBoxMoisFin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						NouvelleOperationCommerciale.this.lblMoisFin
								.setVisible(false);
						NouvelleOperationCommerciale.this.MoisFin = NouvelleOperationCommerciale.this.comboBoxMoisFin
								.getSelectedItem().toString().substring(1);
						NouvelleOperationCommerciale.this.comboBoxAnneeFin
								.setEnabled(true);
						NouvelleOperationCommerciale.this.lblAnneFin
								.setVisible(false);
						switch (NouvelleOperationCommerciale.this.MoisFin)

						{
						case "Janvier":
							NouvelleOperationCommerciale.this.MoisFin = "01";
							break;
						case "Fevrier":
							NouvelleOperationCommerciale.this.MoisFin = "02";
							break;
						case "Mars":
							NouvelleOperationCommerciale.this.MoisFin = "03";
							break;
						case "Avril":
							NouvelleOperationCommerciale.this.MoisFin = "04";
							break;
						case "Mai":
							NouvelleOperationCommerciale.this.MoisFin = "05";
							break;
						case "Juin":
							NouvelleOperationCommerciale.this.MoisFin = "06";
							break;
						case "Juillet":
							NouvelleOperationCommerciale.this.MoisFin = "07";
							break;
						case "Août":
							NouvelleOperationCommerciale.this.MoisFin = "08";
							break;
						case "Septembre":
							NouvelleOperationCommerciale.this.MoisFin = "09";
							break;
						case "Octobre":
							NouvelleOperationCommerciale.this.MoisFin = "10";
							break;
						case "Novembre":
							NouvelleOperationCommerciale.this.MoisFin = "11";
							break;
						case "Décembre":
							NouvelleOperationCommerciale.this.MoisFin = "12";
							break;

						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						NouvelleOperationCommerciale.this.lblMoisFin
								.setVisible(true);
					}
				}
			});
			this.comboBoxMoisFin.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxMoisFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMoisFin.setBackground(Color.WHITE);
			this.comboBoxMoisFin.setBorder(null);
			this.comboBoxMoisFin.setForeground(Color.GRAY);
			this.comboBoxMoisFin.setBounds(631, 438, 138, 22);
			this.comboBoxMoisFin.setEnabled(false);
		}
		return this.comboBoxMoisFin;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								NouvelleOperationCommerciale.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
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
								NouvelleOperationCommerciale.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						NouvelleOperationCommerciale.class
								.getResource("/Images/fonds/menus_operation.png")));
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
					NouvelleOperationCommerciale.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(239, 231, 114, 44);
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
					NouvelleOperationCommerciale.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(348, 231, 114, 44);
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
					NouvelleOperationCommerciale.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(462, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					NouvelleOperationCommerciale.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(704, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblJourDebut());
			this.layeredPane.add(this.getLblMenuNouvelle());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblLibelleDeLopration());
			this.layeredPane
					.add(this.getTextFieldLibelleOperationCommerciale());
			this.layeredPane.add(this.getLblChampsObligatoire());
			this.layeredPane.add(this.getLblDateDeDbut());
			this.layeredPane.add(this.getLblDateDeFin());
			this.layeredPane.add(this.getLblJourFin());
			this.layeredPane.add(this.getLblMoisDebut());
			this.layeredPane.add(this.getLblMoisFin());
			this.layeredPane.add(this.getLblAnneDebut());
			this.layeredPane.add(this.getLblAnneFin());
			this.layeredPane.add(this.getComboBoxJourDebut());
			this.layeredPane.add(this.getComboBoxMoisDebut());
			this.layeredPane.add(this.getComboBoxAnneeDebut());
			this.layeredPane.add(this.getComboBoxJourFin());
			this.layeredPane.add(this.getComboBoxMoisFin());
			this.layeredPane.add(this.getComboBoxAnneeFin());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblAnneDebut() {
		if (this.lblAnneDebut == null) {
			this.lblAnneDebut = new JLabel("Ann\u00E9e");
			this.lblAnneDebut.setForeground(Color.GRAY);
			this.lblAnneDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAnneDebut.setBounds(799, 412, 36, 14);
		}
		return this.lblAnneDebut;
	}

	private JLabel getLblAnneFin() {
		if (this.lblAnneFin == null) {
			this.lblAnneFin = new JLabel("Ann\u00E9e");
			this.lblAnneFin.setForeground(Color.GRAY);
			this.lblAnneFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAnneFin.setBounds(799, 442, 36, 14);
		}
		return this.lblAnneFin;
	}

	private JLabel getLblChampsObligatoire() {
		if (this.lblChampsObligatoire == null) {
			this.lblChampsObligatoire = new JLabel("* Champs Obligatoire");
			this.lblChampsObligatoire
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblChampsObligatoire.setForeground(Color.GRAY);
			this.lblChampsObligatoire.setBounds(232, 530, 150, 14);
		}
		return this.lblChampsObligatoire;
	}

	private JLabel getLblDateDeDbut() {
		if (this.lblDateDeDbut == null) {
			this.lblDateDeDbut = new JLabel("Date de d\u00E9but *");
			this.lblDateDeDbut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateDeDbut.setForeground(Color.GRAY);
			this.lblDateDeDbut.setBounds(408, 412, 90, 14);
		}
		return this.lblDateDeDbut;
	}

	private JLabel getLblDateDeFin() {
		if (this.lblDateDeFin == null) {
			this.lblDateDeFin = new JLabel("Date de fin *");
			this.lblDateDeFin.setForeground(Color.GRAY);
			this.lblDateDeFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateDeFin.setBounds(427, 442, 71, 14);
		}
		return this.lblDateDeFin;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationCommerciale fenetre = new GestionOperationCommerciale();
					fenetre.setVisible(true);
					NouvelleOperationCommerciale.this.dispose();
				}
			});
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(870, 229, 179, 48);
		}
		return this.lblFermer;
	}

	private JLabel getLblJourDebut() {
		if (this.lblJourDebut == null) {
			this.lblJourDebut = new JLabel("Jour");
			this.lblJourDebut.setForeground(Color.GRAY);
			this.lblJourDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblJourDebut.setBounds(551, 412, 25, 14);

		}
		return this.lblJourDebut;
	}

	private JLabel getLblJourFin() {
		if (this.lblJourFin == null) {
			this.lblJourFin = new JLabel("Jour");
			this.lblJourFin.setForeground(Color.GRAY);
			this.lblJourFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblJourFin.setBounds(551, 442, 25, 14);
		}
		return this.lblJourFin;
	}

	private JLabel getLblLibelleDeLopration() {
		if (this.lblLibelleDeLopration == null) {
			this.lblLibelleDeLopration = new JLabel(
					"Libelle de l'Op\u00E9ration Commerciale *");
			this.lblLibelleDeLopration.setForeground(Color.GRAY);
			this.lblLibelleDeLopration
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblLibelleDeLopration.setBounds(293, 380, 205, 14);
		}
		return this.lblLibelleDeLopration;
	}

	private JLabel getLblMenuNouvelle() {
		if (this.lblMenuNouvelle == null) {
			this.lblMenuNouvelle = new JLabel(
					"Nouvelle Op\u00E9ration Commerciale");
			this.lblMenuNouvelle.setVisible(false);
			this.lblMenuNouvelle.setForeground(Color.GRAY);
			this.lblMenuNouvelle.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMenuNouvelle.setBounds(249, 332, 184, 14);
		}
		return this.lblMenuNouvelle;
	}

	private JLabel getLblMoisDebut() {
		if (this.lblMoisDebut == null) {
			this.lblMoisDebut = new JLabel("Mois");
			this.lblMoisDebut.setForeground(Color.GRAY);
			this.lblMoisDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMoisDebut.setBounds(684, 412, 26, 14);
		}
		return this.lblMoisDebut;
	}

	private JLabel getLblMoisFin() {
		if (this.lblMoisFin == null) {
			this.lblMoisFin = new JLabel("Mois");
			this.lblMoisFin.setForeground(Color.GRAY);
			this.lblMoisFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMoisFin.setBounds(684, 442, 26, 14);
		}
		return this.lblMoisFin;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Nouvelle Op\u00E9ration Commerciale");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 570, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					NouvelleOperationCommerciale.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(
					NouvelleOperationCommerciale.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					boolean verification = true;
					Date DateFinFormatDate = null;
					Date DateDebutFormatDate = null;
					String message = null;

					final String designationOperationCommercialetemporaire = NouvelleOperationCommerciale.this.textFieldLibelleOperationCommerciale
							.getText();
					System.out.print(designationOperationCommercialetemporaire);
					final String DateDebut = NouvelleOperationCommerciale.this.AnneeDebut
							+ "/"
							+ NouvelleOperationCommerciale.this.MoisDebut
							+ "/" + NouvelleOperationCommerciale.this.JourDebut;
					System.out.print(DateDebut);
					final String DateFin = NouvelleOperationCommerciale.this.AnneeFin
							+ "/"
							+ NouvelleOperationCommerciale.this.MoisFin
							+ "/" + NouvelleOperationCommerciale.this.JourFin;
					System.out.print(DateFin);

					final String designationOperationCommerciale = designationOperationCommercialetemporaire
							+ " - "
							+ NouvelleOperationCommerciale.this.MoisDebut
							+ "/"
							+ NouvelleOperationCommerciale.this.AnneeDebut;

					if (designationOperationCommerciale.isEmpty()) {
						message = "Merci de verifier le libéllé de l'opération commerciale";
						verification = false;
					}

					if (NouvelleOperationCommerciale.this.JourDebut.isEmpty()
							|| NouvelleOperationCommerciale.this.MoisDebut
									.isEmpty()
							|| NouvelleOperationCommerciale.this.AnneeDebut
									.isEmpty()
							|| NouvelleOperationCommerciale.this.JourFin
									.isEmpty()
							|| NouvelleOperationCommerciale.this.MoisFin
									.isEmpty()
							|| NouvelleOperationCommerciale.this.AnneeFin
									.isEmpty()) {
						message = "Un champs date est non renseigné - Cliquer pour continuer";
						verification = false;
					}

					final SimpleDateFormat formatdatedebut = new SimpleDateFormat(
							"yyyy/MM/dd");
					try {
						DateDebutFormatDate = formatdatedebut.parse(DateDebut);
					} catch (final ParseException e1) {

						e1.printStackTrace();
					}

					final SimpleDateFormat formatdatefin = new SimpleDateFormat(
							"yyyy/MM/dd");
					try {
						DateFinFormatDate = formatdatefin.parse(DateFin);
					} catch (final ParseException e1) {

						e1.printStackTrace();
					}

					if (DateFinFormatDate.before(DateDebutFormatDate)) {
						message = "La date de fin est anterieur à la date de début - Cliquer ici pour continuer";
						verification = false;

					}

					if (verification == true) {
						try {

							c = Connexion.getCon();
							c.setAutoCommit(false);

							final String sql = "INSERT INTO OPERATION_COMMERCIALE (LIBELLEOPERATIONCOMMERCIALE, DATEDEBUTOPERATIONCOMMERCIALE, DATEFINOPERATIONCOMMERCIALE) VALUES (?,?,?)";
							stm = c.prepareStatement(sql);

							stm.setString(1, designationOperationCommerciale);
							stm.setString(2, DateDebut);
							stm.setString(3, DateFin);

							stm.executeUpdate();

							c.commit();
							c.setAutoCommit(true);
							final String messageInsertion = "Opération Commerciale "
									+ designationOperationCommerciale
									+ " insérée avec succès";
							System.out.print(messageInsertion);
							final boolean etat = true;
							NouvelleOperationCommerciale.this.text = "Nouvelle Opération Commerciale";
							Message.setMessageaffichagefond(NouvelleOperationCommerciale.this.text);
							final SuccesOperation fenetre = new SuccesOperation(
									messageInsertion,
									etat,
									NouvelleOperationCommerciale.this.text,
									NouvelleOperationCommerciale.this.messageinsertion2,
									NouvelleOperationCommerciale.this.provenance,
									NouvelleOperationCommerciale.this.idoperationtest,
									NouvelleOperationCommerciale.this.idmagasintest);
							fenetre.setVisible(true);
							fenetre.setAlwaysOnTop(true);
							NouvelleOperationCommerciale.this.dispose();

						} catch (final Exception e1) {
							System.out.print("erreur" + e1.getMessage());
							try {
								c.rollback();
								final String messageInsertion = "Impossible d'insérer opération Commerciale "
										+ designationOperationCommerciale;
								System.out.print(messageInsertion);
								final boolean etat = false;
								NouvelleOperationCommerciale.this.text = "Nouvelle Opération Commerciale";
								Message.setMessageaffichagefond(NouvelleOperationCommerciale.this.text);
								final SuccesOperation fenetre = new SuccesOperation(
										messageInsertion,
										etat,
										NouvelleOperationCommerciale.this.text,
										NouvelleOperationCommerciale.this.messageinsertion2,
										NouvelleOperationCommerciale.this.provenance,
										NouvelleOperationCommerciale.this.idoperationtest,
										NouvelleOperationCommerciale.this.idmagasintest);
								fenetre.setVisible(true);

								fenetre.setAlwaysOnTop(true);
								NouvelleOperationCommerciale.this.dispose();

							} catch (final SQLException e2) {

								e2.printStackTrace();
							}
						}

						try {

							if (stm != null) {
								stm.close();
							}

						} catch (final Exception e3) {
							e3.printStackTrace();
						}
					} else {
						final AlerteSelection fenetre = new AlerteSelection(
								NouvelleOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						NouvelleOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(871, 380, 155, 138);
			this.lblValider.setVisible(false);
			this.lblValider.setEnabled(false);
		}
		return this.lblValider;
	}

	private JTextField getTextFieldLibelleOperationCommerciale() {
		if (this.textFieldLibelleOperationCommerciale == null) {
			this.textFieldLibelleOperationCommerciale = new JTextField();
			this.textFieldLibelleOperationCommerciale.setFont(new Font(
					"Tahoma", Font.BOLD, 11));
			this.textFieldLibelleOperationCommerciale
					.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(final KeyEvent arg0) {

							NouvelleOperationCommerciale.this.comboBoxJourDebut
									.setEnabled(true);
							NouvelleOperationCommerciale.this.lblJourDebut
									.setVisible(false);

						}
					});
			this.textFieldLibelleOperationCommerciale.setForeground(Color.GRAY);
			this.textFieldLibelleOperationCommerciale.setBounds(508, 377, 353,
					20);
			this.textFieldLibelleOperationCommerciale.setColumns(10);
		}
		return this.textFieldLibelleOperationCommerciale;
	}
}
