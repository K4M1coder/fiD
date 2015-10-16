package fr.lefournildesprovinces.vues.opcom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.ressources.models.OperationCommercialeInfos;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.SuccesOperation;

public class MAJOperationCommerciale extends JFrame {

	private static Connection c;
	/**
	 *
	 */
	private static final long serialVersionUID = 3173171250319915928L;
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
	private final int identifiantoperation;
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

	public MAJOperationCommerciale(final int idoperationselectionnee) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				final OperationCommercialeInfos listeinfos = Select
						.InfosoperationCommerciale(MAJOperationCommerciale.this.identifiantoperation);
				final String libelleoperation = listeinfos
						.getLibelleOperationCommerciale();
				MAJOperationCommerciale.this.textFieldLibelleOperationCommerciale
						.setText(libelleoperation);

				final Date debutOperation = listeinfos
						.getDatebutOperationCommerciale();
				System.out.print(debutOperation + "\n");

				final SimpleDateFormat formatanneedebut = new SimpleDateFormat(
						"yyyy");
				final String anneedebut = formatanneedebut
						.format(debutOperation);

				final SimpleDateFormat formatmoisdebut = new SimpleDateFormat(
						"MMMM");
				final String mois = formatmoisdebut.format(debutOperation);

				final char[] char_table_debut = mois.toCharArray();
				char_table_debut[0] = Character
						.toUpperCase(char_table_debut[0]);
				final String moisdebut = new String(char_table_debut);

				final SimpleDateFormat formatjourdebut = new SimpleDateFormat(
						"dd");
				final String jourdebut = formatjourdebut.format(debutOperation);

				System.out.print(jourdebut + "\n" + moisdebut + "\n"
						+ anneedebut);

				final Date finOperation = listeinfos
						.getDatefinOperationCommerciale();
				System.out.print(finOperation + "\n");

				final SimpleDateFormat formatanneefin = new SimpleDateFormat(
						"yyyy");
				final String anneefin = formatanneefin.format(finOperation);

				final SimpleDateFormat formatmoisfin = new SimpleDateFormat(
						"MMMM");
				final String mois2 = formatmoisfin.format(finOperation);

				final char[] char_table_fin = mois2.toCharArray();
				char_table_fin[0] = Character.toUpperCase(char_table_fin[0]);
				final String moisfin = new String(char_table_fin);

				final SimpleDateFormat formatjourfin = new SimpleDateFormat(
						"dd");
				final String jourfin = formatjourfin.format(finOperation);

				System.out.print(jourfin + "\n" + moisfin + "\n" + anneefin);

				for (int i = 1; i < MAJOperationCommerciale.this.comboBoxJourDebut
						.getModel().getSize(); i++) {

					final String S1 = MAJOperationCommerciale.this.comboBoxJourDebut
							.getItemAt(i).toString().substring(1);
					if (S1.equals(jourdebut)) {
						MAJOperationCommerciale.this.comboBoxJourDebut
								.setSelectedIndex(i);
						break;
					}

				}

				for (int i = 1; i < MAJOperationCommerciale.this.comboBoxMoisDebut
						.getModel().getSize(); i++) {

					final String S1 = MAJOperationCommerciale.this.comboBoxMoisDebut
							.getItemAt(i).toString().substring(1);
					if (S1.equals(moisdebut)) {
						MAJOperationCommerciale.this.comboBoxMoisDebut
								.setSelectedIndex(i);
						break;
					}

				}

				for (int i = 1; i < MAJOperationCommerciale.this.comboBoxAnneeDebut
						.getModel().getSize(); i++) {

					final String S1 = MAJOperationCommerciale.this.comboBoxAnneeDebut
							.getItemAt(i).toString().substring(1);
					if (S1.equals(anneedebut)) {
						MAJOperationCommerciale.this.comboBoxAnneeDebut
								.setSelectedIndex(i);
						break;
					}

				}

				for (int i = 1; i < MAJOperationCommerciale.this.comboBoxJourFin
						.getModel().getSize(); i++) {

					final String S1 = MAJOperationCommerciale.this.comboBoxJourFin
							.getItemAt(i).toString().substring(1);
					if (S1.equals(jourfin)) {
						MAJOperationCommerciale.this.comboBoxJourFin
								.setSelectedIndex(i);
						break;
					}

				}

				for (int i = 1; i < MAJOperationCommerciale.this.comboBoxMoisFin
						.getModel().getSize(); i++) {

					final String S1 = MAJOperationCommerciale.this.comboBoxMoisFin
							.getItemAt(i).toString().substring(1);
					if (S1.equals(moisfin)) {
						MAJOperationCommerciale.this.comboBoxMoisFin
								.setSelectedIndex(i);
						break;
					}

				}

				for (int i = 1; i < MAJOperationCommerciale.this.comboBoxAnneeFin
						.getModel().getSize(); i++) {

					final String S1 = MAJOperationCommerciale.this.comboBoxAnneeFin
							.getItemAt(i).toString().substring(1);
					if (S1.equals(anneefin)) {
						MAJOperationCommerciale.this.comboBoxAnneeFin
								.setSelectedIndex(i);
						break;
					}

				}

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
		this.identifiantoperation = idoperationselectionnee;
	}

	private JComboBox<Object> getComboBoxAnneeDebut() {
		if (this.comboBoxAnneeDebut == null) {
			this.comboBoxAnneeDebut = new JComboBox<Object>();
			this.comboBoxAnneeDebut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						MAJOperationCommerciale.this.lblAnneDebut
								.setVisible(false);
						MAJOperationCommerciale.this.AnneeDebut = MAJOperationCommerciale.this.comboBoxAnneeDebut
								.getSelectedItem().toString().substring(1);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
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
			this.comboBoxAnneeDebut.setEditable(true);
			this.comboBoxAnneeDebut.setBackground(Color.WHITE);
			this.comboBoxAnneeDebut.setBorder(null);
			this.comboBoxAnneeDebut.setBounds(783, 408, 91, 22);
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
						MAJOperationCommerciale.this.lblAnneFin
								.setVisible(false);
						MAJOperationCommerciale.this.AnneeFin = MAJOperationCommerciale.this.comboBoxAnneeFin
								.getSelectedItem().toString().substring(1);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.comboBoxAnneeFin.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxAnneeFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxAnneeFin.setEditable(true);
			this.comboBoxAnneeFin.setBackground(Color.WHITE);
			this.comboBoxAnneeFin.setBorder(null);
			this.comboBoxAnneeFin.setForeground(Color.GRAY);
			this.comboBoxAnneeFin.setBounds(783, 439, 91, 22);
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
						MAJOperationCommerciale.this.lblJourDebut
								.setVisible(false);
						MAJOperationCommerciale.this.JourDebut = MAJOperationCommerciale.this.comboBoxJourDebut
								.getSelectedItem().toString().substring(1);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.comboBoxJourDebut.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxJourDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxJourDebut.setForeground(Color.GRAY);
			this.comboBoxJourDebut.setEditable(true);
			this.comboBoxJourDebut.setBackground(Color.WHITE);
			this.comboBoxJourDebut.setBorder(null);
			this.comboBoxJourDebut.setBounds(503, 408, 109, 22);
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
						MAJOperationCommerciale.this.lblJourFin
								.setVisible(false);
						MAJOperationCommerciale.this.JourFin = MAJOperationCommerciale.this.comboBoxJourFin
								.getSelectedItem().toString().substring(1);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.comboBoxJourFin.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxJourFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxJourFin.setEditable(true);
			this.comboBoxJourFin.setBackground(Color.WHITE);
			this.comboBoxJourFin.setBorder(null);
			this.comboBoxJourFin.setForeground(Color.GRAY);
			this.comboBoxJourFin.setBounds(503, 439, 109, 22);
		}
		return this.comboBoxJourFin;
	}

	private JComboBox<Object> getComboBoxMoisDebut() {
		if (this.comboBoxMoisDebut == null) {
			final String[] mois = { null, " Janvier", " Février", " Mars",
					" Avril", " Mai", " Juin", " Juillet", " Août",
					" Septembre", " Octobre", " Novembre", " Décembre" };
			this.comboBoxMoisDebut = new JComboBox<Object>(mois);
			this.comboBoxMoisDebut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						MAJOperationCommerciale.this.lblMoisDebut
								.setVisible(false);
						MAJOperationCommerciale.this.MoisDebut = MAJOperationCommerciale.this.comboBoxMoisDebut
								.getSelectedItem().toString().substring(1);

						switch (MAJOperationCommerciale.this.MoisDebut)

						{
						case "Janvier":
							MAJOperationCommerciale.this.MoisDebut = "01";
							break;
						case "Février":
							MAJOperationCommerciale.this.MoisDebut = "02";
							break;
						case "Mars":
							MAJOperationCommerciale.this.MoisDebut = "03";
							break;
						case "Avril":
							MAJOperationCommerciale.this.MoisDebut = "04";
							break;
						case "Mai":
							MAJOperationCommerciale.this.MoisDebut = "05";
							break;
						case "Juin":
							MAJOperationCommerciale.this.MoisDebut = "06";
							break;
						case "Juillet":
							MAJOperationCommerciale.this.MoisDebut = "07";
							break;
						case "Août":
							MAJOperationCommerciale.this.MoisDebut = "08";
							break;
						case "Septembre":
							MAJOperationCommerciale.this.MoisDebut = "09";
							break;
						case "Octobre":
							MAJOperationCommerciale.this.MoisDebut = "10";
							break;
						case "Novembre":
							MAJOperationCommerciale.this.MoisDebut = "11";
							break;
						case "Décembre":
							MAJOperationCommerciale.this.MoisDebut = "12";
							break;

						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.comboBoxMoisDebut.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxMoisDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMoisDebut.setForeground(Color.GRAY);
			this.comboBoxMoisDebut.setEditable(true);
			this.comboBoxMoisDebut.setBackground(Color.WHITE);
			this.comboBoxMoisDebut.setBorder(null);
			this.comboBoxMoisDebut.setBounds(622, 408, 147, 22);
		}
		return this.comboBoxMoisDebut;
	}

	private JComboBox<Object> getComboBoxMoisFin() {
		if (this.comboBoxMoisFin == null) {
			final String[] mois = { null, " Janvier", " Février", " Mars",
					" Avril", " Mai", " Juin", " Juillet", " Août",
					" Septembre", " Octobre", " Novembre", " Décembre" };
			this.comboBoxMoisFin = new JComboBox<Object>(mois);
			this.comboBoxMoisFin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						MAJOperationCommerciale.this.lblMoisFin
								.setVisible(false);
						MAJOperationCommerciale.this.MoisFin = MAJOperationCommerciale.this.comboBoxMoisFin
								.getSelectedItem().toString().substring(1);

						switch (MAJOperationCommerciale.this.MoisFin)

						{
						case "Janvier":
							MAJOperationCommerciale.this.MoisFin = "01";
							break;
						case "Février":
							MAJOperationCommerciale.this.MoisFin = "02";
							break;
						case "Mars":
							MAJOperationCommerciale.this.MoisFin = "03";
							break;
						case "Avril":
							MAJOperationCommerciale.this.MoisFin = "04";
							break;
						case "Mai":
							MAJOperationCommerciale.this.MoisFin = "05";
							break;
						case "Juin":
							MAJOperationCommerciale.this.MoisFin = "06";
							break;
						case "Juillet":
							MAJOperationCommerciale.this.MoisFin = "07";
							break;
						case "Août":
							MAJOperationCommerciale.this.MoisFin = "08";
							break;
						case "Septembre":
							MAJOperationCommerciale.this.MoisFin = "09";
							break;
						case "Octobre":
							MAJOperationCommerciale.this.MoisFin = "10";
							break;
						case "Novembre":
							MAJOperationCommerciale.this.MoisFin = "11";
							break;
						case "Décembre":
							MAJOperationCommerciale.this.MoisFin = "12";
							break;

						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.comboBoxMoisFin.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBoxMoisFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxMoisFin.setEditable(true);
			this.comboBoxMoisFin.setBackground(Color.WHITE);
			this.comboBoxMoisFin.setBorder(null);
			this.comboBoxMoisFin.setForeground(Color.GRAY);
			this.comboBoxMoisFin.setBounds(622, 439, 147, 22);
		}
		return this.comboBoxMoisFin;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(MAJOperationCommerciale.class
						.getResource("/Images/fonds/menus-grises-operation.png")));
				this.label_2.setEnabled(false);
				this.label_3.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				break;

			case "invite":
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				this.fond.setIcon(new ImageIcon(MAJOperationCommerciale.class
						.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(MAJOperationCommerciale.class
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
					MAJOperationCommerciale.this.dispose();
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
					MAJOperationCommerciale.this.dispose();
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
					MAJOperationCommerciale.this.dispose();
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
					MAJOperationCommerciale.this.dispose();
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
			this.layeredPane.add(this.getLblMenuNouvelle());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblLibelleDeLopration());
			this.layeredPane
					.add(this.getTextFieldLibelleOperationCommerciale());
			this.layeredPane.add(this.getLblChampsObligatoire());
			this.layeredPane.add(this.getLblDateDeDbut());
			this.layeredPane.add(this.getLblDateDeFin());
			this.layeredPane.add(this.getLblJourDebut());
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
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
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
			this.lblAnneDebut.setBounds(804, 412, 46, 14);
		}
		return this.lblAnneDebut;
	}

	private JLabel getLblAnneFin() {
		if (this.lblAnneFin == null) {
			this.lblAnneFin = new JLabel("Ann\u00E9e");
			this.lblAnneFin.setForeground(Color.GRAY);
			this.lblAnneFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAnneFin.setBounds(804, 443, 46, 14);
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
			this.lblDateDeDbut.setBounds(391, 412, 102, 14);
		}
		return this.lblDateDeDbut;
	}

	private JLabel getLblDateDeFin() {
		if (this.lblDateDeFin == null) {
			this.lblDateDeFin = new JLabel("Date de fin *");
			this.lblDateDeFin.setForeground(Color.GRAY);
			this.lblDateDeFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateDeFin.setBounds(410, 443, 83, 14);
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
					MAJOperationCommerciale.this.dispose();
				}
			});
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(869, 231, 184, 44);
		}
		return this.lblFermer;
	}

	private JLabel getLblJourDebut() {
		if (this.lblJourDebut == null) {
			this.lblJourDebut = new JLabel("Jour");
			this.lblJourDebut.setForeground(Color.GRAY);
			this.lblJourDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblJourDebut.setBounds(533, 412, 38, 14);
		}
		return this.lblJourDebut;
	}

	private JLabel getLblJourFin() {
		if (this.lblJourFin == null) {
			this.lblJourFin = new JLabel("Jour");
			this.lblJourFin.setForeground(Color.GRAY);
			this.lblJourFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblJourFin.setBounds(533, 443, 38, 14);
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
			this.lblLibelleDeLopration.setBounds(276, 380, 217, 14);
		}
		return this.lblLibelleDeLopration;
	}

	private JLabel getLblMenuNouvelle() {
		if (this.lblMenuNouvelle == null) {
			this.lblMenuNouvelle = new JLabel(
					"Menu > Mise à jour Op\u00E9ration Commerciale");
			this.lblMenuNouvelle.setVisible(false);
			this.lblMenuNouvelle.setForeground(Color.GRAY);
			this.lblMenuNouvelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuNouvelle.setBounds(242, 325, 206, 14);
		}
		return this.lblMenuNouvelle;
	}

	private JLabel getLblMoisDebut() {
		if (this.lblMoisDebut == null) {
			this.lblMoisDebut = new JLabel("Mois");
			this.lblMoisDebut.setForeground(Color.GRAY);
			this.lblMoisDebut.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMoisDebut.setBounds(684, 412, 40, 14);
		}
		return this.lblMoisDebut;
	}

	private JLabel getLblMoisFin() {
		if (this.lblMoisFin == null) {
			this.lblMoisFin = new JLabel("Mois");
			this.lblMoisFin.setForeground(Color.GRAY);
			this.lblMoisFin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMoisFin.setBounds(684, 443, 40, 14);
		}
		return this.lblMoisFin;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Mise à Jour d'une Opération Commerciale");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 532, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					MAJOperationCommerciale.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(MAJOperationCommerciale.class
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

					final String designationOperationCommercialetemporaire = MAJOperationCommerciale.this.textFieldLibelleOperationCommerciale
							.getText();
					System.out.print(designationOperationCommercialetemporaire);
					final String DateDebut = MAJOperationCommerciale.this.AnneeDebut
							+ "/"
							+ MAJOperationCommerciale.this.MoisDebut
							+ "/" + MAJOperationCommerciale.this.JourDebut;
					System.out.print(DateDebut + "\n");
					final String DateFin = MAJOperationCommerciale.this.AnneeFin
							+ "/"
							+ MAJOperationCommerciale.this.MoisFin
							+ "/"
							+ MAJOperationCommerciale.this.JourFin;
					System.out.print(DateFin + "\n");

					final String designationOperationCommerciale = designationOperationCommercialetemporaire;

					if (designationOperationCommerciale.isEmpty()) {
						message = "Merci de verifier le libéllé de l'opération commerciale";
						verification = false;
					}

					if (MAJOperationCommerciale.this.JourDebut.isEmpty()
							|| MAJOperationCommerciale.this.MoisDebut.isEmpty()
							|| MAJOperationCommerciale.this.AnneeDebut
									.isEmpty()
							|| MAJOperationCommerciale.this.JourFin.isEmpty()
							|| MAJOperationCommerciale.this.MoisFin.isEmpty()
							|| MAJOperationCommerciale.this.AnneeFin.isEmpty()) {
						message = "Un champs date est non renseigné";
						verification = false;
					}

					final SimpleDateFormat formatdatedebut = new SimpleDateFormat(
							"yyyy/MM/dd");
					try {
						DateDebutFormatDate = formatdatedebut.parse(DateDebut);
					} catch (final ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					final SimpleDateFormat formatdatefin = new SimpleDateFormat(
							"yyyy/MM/dd");
					try {
						DateFinFormatDate = formatdatefin.parse(DateFin);
					} catch (final ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					System.out.print("date1:" + DateDebutFormatDate + "\n");
					System.out.print("date2:" + DateFinFormatDate + "\n");

					if (DateFinFormatDate.before(DateDebutFormatDate)) {
						message = "La date de fin est anterieur à la date de début - Cliquer ici pour continuer";
						verification = false;

					}

					if (verification == true) {
						try {

							c = Connexion.getCon();
							c.setAutoCommit(false);

							final String sql = "UPDATE OPERATION_COMMERCIALE SET LIBELLEOPERATIONCOMMERCIALE=?, DATEDEBUTOPERATIONCOMMERCIALE=?, DATEFINOPERATIONCOMMERCIALE=? WHERE IDOPERATIONCOMMERCIALE=?";
							stm = c.prepareStatement(sql);

							stm.setString(1, designationOperationCommerciale);
							stm.setString(2, DateDebut);
							stm.setString(3, DateFin);
							stm.setInt(
									4,
									MAJOperationCommerciale.this.identifiantoperation);

							stm.executeUpdate();

							c.commit();
							c.setAutoCommit(true);
							final String messageInsertion = "Opération Commerciale "
									+ designationOperationCommerciale
									+ " mise à jour avec succès";
							System.out.print(messageInsertion);
							final boolean etat = true;
							MAJOperationCommerciale.this.text = "Mise à Jour d'une Opération Commerciale";
							Message.setMessageaffichagefond(MAJOperationCommerciale.this.text);
							final SuccesOperation fenetre = new SuccesOperation(
									messageInsertion,
									etat,
									MAJOperationCommerciale.this.text,
									MAJOperationCommerciale.this.messageinsertion2,
									MAJOperationCommerciale.this.provenance,
									MAJOperationCommerciale.this.idoperationtest,
									MAJOperationCommerciale.this.idmagasintest,null);
							fenetre.setVisible(true);
							fenetre.setAlwaysOnTop(true);
							MAJOperationCommerciale.this.dispose();

						} catch (final Exception e1) {
							System.out.print("erreur" + e1.getMessage());
							try {
								c.rollback();
								final String messageInsertion = "Impossible de mettre à jour opération Commerciale "
										+ designationOperationCommerciale;
								System.out.print(messageInsertion);
								final boolean etat = false;
								MAJOperationCommerciale.this.text = "Mise à Jour d'une Opération Commerciale";
								Message.setMessageaffichagefond(MAJOperationCommerciale.this.text);
								final SuccesOperation fenetre = new SuccesOperation(
										messageInsertion,
										etat,
										MAJOperationCommerciale.this.text,
										MAJOperationCommerciale.this.messageinsertion2,
										MAJOperationCommerciale.this.provenance,
										MAJOperationCommerciale.this.idoperationtest,
										MAJOperationCommerciale.this.idmagasintest,null);
								fenetre.setVisible(true);

								fenetre.setAlwaysOnTop(true);
								MAJOperationCommerciale.this.dispose();

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
								MAJOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						MAJOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
					}
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(871, 380, 155, 138);
		}
		return this.lblValider;
	}

	private JTextField getTextFieldLibelleOperationCommerciale() {
		if (this.textFieldLibelleOperationCommerciale == null) {
			this.textFieldLibelleOperationCommerciale = new JTextField();
			this.textFieldLibelleOperationCommerciale.setFont(new Font(
					"Tahoma", Font.BOLD, 11));
			this.textFieldLibelleOperationCommerciale.setForeground(Color.GRAY);
			this.textFieldLibelleOperationCommerciale.setBounds(503, 377, 371,
					20);
			this.textFieldLibelleOperationCommerciale.setColumns(10);
		}
		return this.textFieldLibelleOperationCommerciale;
	}
}
