package fr.lefournildesprovinces.vues;

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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class SelectionNumeroCarteFidelite2 extends JFrame {

	private static Connection c;
	private static JFrame interfaceprecedente;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7251756838212278175L;
	private String birth;
	private final String choixmenuprecedent;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private JComboBox<Object> comboBox_2;
	private ComboBoxModel<Object> mod;
	private ComboBoxModel<Object> mod2;
	private ComboBoxModel<Object> mod3;
	private final JPanel contentPane;
	private JLabel fond;
	private JTextField formattedTextField;
	private String forname;
	ButtonGroup group = new ButtonGroup();
	private int idclient = 0;
	private int idclientconsulatation;
	private JFrame interfaceactuelle;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_7;
	private JLayeredPane layeredPane;
	private JLabel lblChiffres;
	private JLabel lblFermer;
	private JLabel lblMenuChoix;
	private JLabel lblNclient;
	private JLabel lblNewLabel;
	private JLabel lblOu;
	private JLabel lblTaperOuSlectionner;
	private JLabel lblTaperOuSlectionner_1;
	private JLabel lblTaperOuSlectionner_2;
	private JLabel lblValider;
	private String message;
	private String name;
	private String numcarteliste;
	private String numeroCarteFidelite;
	private String privilege;
	private JRadioButton rdbtnSelectionParNom;

	private JRadioButton rdbtnSelectionParNumero;

	private JSeparator separator;
	private String text;

	public SelectionNumeroCarteFidelite2(final JFrame interfaceder,
			final String choix) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				SelectionNumeroCarteFidelite2.this.lblMenuChoix
						.setText(SelectionNumeroCarteFidelite2.this.choixmenuprecedent);

				switch (SelectionNumeroCarteFidelite2.this.choixmenuprecedent) {

				case "Menu > Gestion Carte de Fidélité > Désincription Newslettter":
					SelectionNumeroCarteFidelite2.this.label_7
							.setText("Désincription Newslettter");
					break;
				case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
					SelectionNumeroCarteFidelite2.this.label_7
							.setText("Suppression d'une carte de fidélite");
					break;
				case "Menu > Gestion Carte de Fidélité > Mise à  Jour Fiche Client":
					SelectionNumeroCarteFidelite2.this.label_7
							.setText("Mise à  Jour d'une carte de fidélité");
					break;
				case "Consulter une carte de fidelité":
					SelectionNumeroCarteFidelite2.this.label_7
							.setText("Consulter une carte de fidelité");

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
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.interfaceActuelle = this;
		this.choixmenuprecedent = choix;
		interfaceprecedente = interfaceder;

	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					try {
						SelectionNumeroCarteFidelite2.this.name = SelectionNumeroCarteFidelite2.this.comboBox
								.getSelectedItem().toString();
						SelectionNumeroCarteFidelite2.this.mod2 = new DefaultComboBoxModel<Object>(
								Select.listePrenomclientfidelite(SelectionNumeroCarteFidelite2.this.name));
						SelectionNumeroCarteFidelite2.this.comboBox_1
								.setModel(SelectionNumeroCarteFidelite2.this.mod2);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner
								.setVisible(false);
					} catch (final Exception e1) {


						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						System.out.print("Nom " + message);
						final AlerteSelection fenetre = new AlerteSelection(
								SelectionNumeroCarteFidelite2.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						SelectionNumeroCarteFidelite2.this.interfaceactuelle
								.setEnabled(false);
						SelectionNumeroCarteFidelite2.this.lblValider
								.setVisible(false);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner
								.setVisible(true);
					}

				}
			});
			this.comboBox.setEnabled(false);
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setEditable(true);
			this.comboBox.setBorder(null);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBounds(528, 426, 278, 22);
			
			this.mod = new DefaultComboBoxModel<Object>(
					Select.listenomclientfidelite());
			this.comboBox.setModel(this.mod);
			AutoCompletion.enable(this.comboBox);

		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			this.comboBox_1 = new JComboBox<Object>();
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						SelectionNumeroCarteFidelite2.this.forname = SelectionNumeroCarteFidelite2.this.comboBox_1
								.getSelectedItem().toString();
						SelectionNumeroCarteFidelite2.this.mod3 = new DefaultComboBoxModel<Object>(
								Select.listedateClientfidelite(
										SelectionNumeroCarteFidelite2.this.name,
										SelectionNumeroCarteFidelite2.this.forname));
						SelectionNumeroCarteFidelite2.this.comboBox_2
								.setModel(SelectionNumeroCarteFidelite2.this.mod3);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_2
								.setVisible(false);

					} catch (final Exception e2) {

						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						System.out.println("Prénom" + message);
						final AlerteSelection fenetre = new AlerteSelection(
								SelectionNumeroCarteFidelite2.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						SelectionNumeroCarteFidelite2.this.interfaceactuelle
								.setEnabled(false);
						SelectionNumeroCarteFidelite2.this.lblValider
								.setVisible(false);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_2
								.setVisible(true);
					}
				}
			});
			this.comboBox_1.setEnabled(false);
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.setEditable(true);
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(528, 457, 278, 22);
			AutoCompletion.enable(this.comboBox_1);

		}
		return this.comboBox_1;
	}

	private JComboBox<Object> getComboBox_2() {
		if (this.comboBox_2 == null) {
			this.comboBox_2 = new JComboBox<Object>();
			this.comboBox_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					SelectionNumeroCarteFidelite2.this.lblValider
							.setVisible(true);
					try {
						SelectionNumeroCarteFidelite2.this.birth = SelectionNumeroCarteFidelite2.this.comboBox_2
								.getSelectedItem().toString();
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_1
								.setVisible(false);
					} catch (final Exception e3) {

						System.out.print("Age impossible");
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								SelectionNumeroCarteFidelite2.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						SelectionNumeroCarteFidelite2.this.interfaceactuelle
								.setEnabled(false);
						SelectionNumeroCarteFidelite2.this.lblValider
								.setVisible(false);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_1
								.setVisible(true);
					}

				}
			});
			this.comboBox_2.setForeground(Color.GRAY);
			this.comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_2.setEnabled(false);
			this.comboBox_2.setEditable(true);
			this.comboBox_2.setBorder(null);
			this.comboBox_2.setBackground(Color.WHITE);
			this.comboBox_2.setBounds(528, 488, 278, 22);
			AutoCompletion.enable(this.comboBox_2);

		}
		return this.comboBox_2;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								SelectionNumeroCarteFidelite.class
										.getResource("/Images/menus-grises-fidelite.png")));
				this.label_1.setEnabled(false);
				this.label_1.setVisible(false);
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);

				break;

			case "invite":
				this.label_1.setEnabled(false);
				this.label_1.setVisible(false);
				this.label_2.setEnabled(false);
				this.label_2.setVisible(false);

				this.fond
						.setIcon(new ImageIcon(
								SelectionNumeroCarteFidelite.class
										.getResource("/Images/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						SelectionNumeroCarteFidelite.class
								.getResource("/Images/menus_fidelite.png")));
				break;

			}

			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JTextField getFormattedTextField() {
		if (this.formattedTextField == null) {

			this.formattedTextField = new JTextField();
			this.formattedTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {
					SelectionNumeroCarteFidelite2.this.lblValider
							.setVisible(true);
					SelectionNumeroCarteFidelite2.this.lblNclient
							.setVisible(false);
				}
			});

			this.formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.formattedTextField.setForeground(Color.GRAY);
			this.formattedTextField.setBorder(new LineBorder(new Color(171,
					173, 179)));
			this.formattedTextField.setBounds(528, 351, 278, 20);

		}
		return this.formattedTextField;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SelectionNumeroCarteFidelite2.this.dispose();
				}
			});
			this.label.setBounds(240, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					SelectionNumeroCarteFidelite2.this.dispose();
				}
			});
			this.label_1.setBounds(692, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					SelectionNumeroCarteFidelite2.this.dispose();
				}
			});
			this.label_2.setBounds(461, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					SelectionNumeroCarteFidelite2.this.dispose();
				}
			});
			this.label_3.setBounds(575, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_7() {
		if (this.label_7 == null) {
			this.label_7 = new JLabel("");
			this.label_7.setForeground(Color.GRAY);
			this.label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_7.setBounds(242, 286, 564, 14);
		}
		return this.label_7;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenuChoix());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblNclient());
			this.layeredPane.add(this.getFormattedTextField());
			this.layeredPane.add(this.getLblChiffres());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getSeparator());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getRdbtnSelectionParNumero());
			this.layeredPane.add(this.getRdbtnSelectionParNom());
			this.layeredPane.add(this.getLblOu());
			this.layeredPane.add(this.getLblTaperOuSlectionner_1());
			this.layeredPane.add(this.getLblTaperOuSlectionner_2());
			this.layeredPane.add(this.getLblTaperOuSlectionner());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getComboBox_2());
			this.layeredPane.add(this.getLabel_7());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblChiffres() {
		if (this.lblChiffres == null) {
			// lblChiffres = new JLabel("* 13 chiffres Obligatoires");
			this.lblChiffres = new JLabel("");
			this.lblChiffres.setForeground(Color.GRAY);
			this.lblChiffres.setFont(new Font("Tahoma", Font.BOLD, 9));
			this.lblChiffres.setBounds(822, 356, 154, 11);
		}
		return this.lblChiffres;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SelectionNumeroCarteFidelite2.this.dispose();
				}
			});
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setBounds(868, 231, 185, 53);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuChoix() {
		if (this.lblMenuChoix == null) {
			this.lblMenuChoix = new JLabel("");
			this.lblMenuChoix.setVisible(false);
			this.lblMenuChoix.setForeground(Color.GRAY);
			this.lblMenuChoix.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuChoix.setBounds(226, 242, 293, 14);
		}
		return this.lblMenuChoix;
	}

	private JLabel getLblNclient() {
		if (this.lblNclient == null) {
			this.lblNclient = new JLabel("N\u00B0 Client * ");
			this.lblNclient.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNclient.setForeground(Color.GRAY);
			this.lblNclient.setBounds(602, 354, 143, 14);
		}
		return this.lblNclient;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					SelectionNumeroCarteFidelite2.class
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
			this.lblOu.setBounds(285, 392, 46, 14);
		}
		return this.lblOu;
	}

	private JLabel getLblTaperOuSlectionner() {
		if (this.lblTaperOuSlectionner == null) {
			this.lblTaperOuSlectionner = new JLabel(
					" Taper ou Sélectionner  le  nom du client");
			this.lblTaperOuSlectionner.setEnabled(false);
			this.lblTaperOuSlectionner.setForeground(Color.GRAY);
			this.lblTaperOuSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTaperOuSlectionner.setBounds(543, 430, 245, 14);
		}
		return this.lblTaperOuSlectionner;
	}

	private JLabel getLblTaperOuSlectionner_1() {
		if (this.lblTaperOuSlectionner_1 == null) {
			this.lblTaperOuSlectionner_1 = new JLabel(
					"Taper ou sélectionner un âge");
			this.lblTaperOuSlectionner_1.setEnabled(false);
			this.lblTaperOuSlectionner_1.setForeground(Color.GRAY);
			this.lblTaperOuSlectionner_1.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblTaperOuSlectionner_1.setBounds(576, 492, 197, 14);
		}
		return this.lblTaperOuSlectionner_1;
	}

	private JLabel getLblTaperOuSlectionner_2() {
		if (this.lblTaperOuSlectionner_2 == null) {
			this.lblTaperOuSlectionner_2 = new JLabel(
					"Taper ou sélectionner son prénom");
			this.lblTaperOuSlectionner_2.setEnabled(false);
			this.lblTaperOuSlectionner_2.setForeground(Color.GRAY);
			this.lblTaperOuSlectionner_2.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblTaperOuSlectionner_2.setBounds(554, 461, 220, 14);
		}
		return this.lblTaperOuSlectionner_2;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setVisible(false);
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(
					SelectionNumeroCarteFidelite2.class
							.getResource("/Images/valider.png")));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					if (SelectionNumeroCarteFidelite2.this.rdbtnSelectionParNumero
							.isSelected())

					{

						boolean verification = true;
						SelectionNumeroCarteFidelite2.this.numeroCarteFidelite = SelectionNumeroCarteFidelite2.this.formattedTextField
								.getText().toString().toUpperCase();
						System.out
								.print(SelectionNumeroCarteFidelite2.this.numeroCarteFidelite);
						SelectionNumeroCarteFidelite2.this.interfaceActuelle
								.setVisible(false);
						SelectionNumeroCarteFidelite2.this.interfaceActuelle
								.setEnabled(false);
						if (SelectionNumeroCarteFidelite2.this.numeroCarteFidelite
								.isEmpty()) {
							verification = false;
							SelectionNumeroCarteFidelite2.this.message = "Merci de vérifier le numéro de carte renseigné - Ce champ ne peut pas être vide";
						}

						// if (!numeroCarteFidelite.isEmpty()) {
						//
						// if (numeroCarteFidelite.length() != 13) {
						// verification = false;
						// message =
						// "Merci de vérifier le numéro de carte renseigné - 13 caractéres obligatoires";
						// }
						//
						// }

						if (!SelectionNumeroCarteFidelite2.this.numeroCarteFidelite
								.isEmpty()) {
							// && (numeroCarteFidelite.length() == 13)) {
							try {
								c = Connexion.getCon();

								final String sql = "SELECT IDCLIENT FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";

								preStm = c.prepareStatement(sql);

								preStm.setString(
										1,
										SelectionNumeroCarteFidelite2.this.numeroCarteFidelite);

								rs = preStm.executeQuery();

								while (rs.next()) {
									SelectionNumeroCarteFidelite2.this.idclient = rs
											.getInt(1);
								}

								System.out
										.print(SelectionNumeroCarteFidelite2.this.idclient);
								rs.close();
								preStm.close();

							} catch (final SQLException e1) {
								e1.printStackTrace();

							}

							if (SelectionNumeroCarteFidelite2.this.idclient == 0)

							{

								verification = false;
								SelectionNumeroCarteFidelite2.this.message = "La carte n° "
										+ SelectionNumeroCarteFidelite2.this.numeroCarteFidelite
										+ " n'existe pas";

							}

						}

						if (verification == true) {

							switch (SelectionNumeroCarteFidelite2.this.choixmenuprecedent) {

							case "Menu > Gestion Carte de Fidélité > Désincription Newslettter":
								SelectionNumeroCarteFidelite2.this.text = "Désincription Newslettter";
								final ConfirmationOperationCarteFidelite fenetre = new ConfirmationOperationCarteFidelite(
										SelectionNumeroCarteFidelite2.this.interfaceActuelle,
										SelectionNumeroCarteFidelite2.this.numeroCarteFidelite,
										SelectionNumeroCarteFidelite2.this.choixmenuprecedent,
										SelectionNumeroCarteFidelite2.this.text);
								fenetre.setVisible(true);
								interfaceprecedente.dispose();
								SelectionNumeroCarteFidelite2.this.dispose();

								break;

							case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
								SelectionNumeroCarteFidelite2.this.text = "Suppression d'une carte de fidélité";
								final ConfirmationOperationCarteFidelite fenetre2 = new ConfirmationOperationCarteFidelite(
										SelectionNumeroCarteFidelite2.this.interfaceActuelle,
										SelectionNumeroCarteFidelite2.this.numeroCarteFidelite,
										SelectionNumeroCarteFidelite2.this.choixmenuprecedent,
										SelectionNumeroCarteFidelite2.this.text);
								fenetre2.setVisible(true);
								interfaceprecedente.dispose();
								SelectionNumeroCarteFidelite2.this.dispose();
								break;

							case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
								SelectionNumeroCarteFidelite2.this.text = "Mise à jour d'une carte de fidélité";
								final ConfirmationOperationCarteFidelite fenetre3 = new ConfirmationOperationCarteFidelite(
										SelectionNumeroCarteFidelite2.this.interfaceActuelle,
										SelectionNumeroCarteFidelite2.this.numeroCarteFidelite,
										SelectionNumeroCarteFidelite2.this.choixmenuprecedent,
										SelectionNumeroCarteFidelite2.this.text);
								fenetre3.setVisible(true);
								interfaceprecedente.dispose();
								SelectionNumeroCarteFidelite2.this.dispose();
								break;

							case "Consulter une carte de fidelité":
								final FicheClientComplete consultationfiche = new FicheClientComplete(
										SelectionNumeroCarteFidelite2.this.idclient);
								consultationfiche.setVisible(true);
								interfaceprecedente.dispose();
								SelectionNumeroCarteFidelite2.this.dispose();
								break;
							}
						} else {
							System.out.print("impossible");

							final AlerteSelection fenetre = new AlerteSelection(
									SelectionNumeroCarteFidelite2.this.interfaceActuelle,
									SelectionNumeroCarteFidelite2.this.message);
							fenetre.setVisible(true);
							SelectionNumeroCarteFidelite2.this.interfaceActuelle
									.setEnabled(false);
							SelectionNumeroCarteFidelite2.this.lblValider
									.setVisible(false);
						}
					}

					if (SelectionNumeroCarteFidelite2.this.rdbtnSelectionParNom
							.isSelected()) {
						SelectionNumeroCarteFidelite2.this.name = SelectionNumeroCarteFidelite2.this.comboBox
								.getSelectedItem().toString();
						SelectionNumeroCarteFidelite2.this.forname = SelectionNumeroCarteFidelite2.this.comboBox_1
								.getSelectedItem().toString();
						SelectionNumeroCarteFidelite2.this.birth = SelectionNumeroCarteFidelite2.this.comboBox_2
								.getSelectedItem().toString();

						/*
						 * String eclatementDate[] = birth.split(" "); String
						 * day = eclatementDate[0]; System.out.print(day+"\n");
						 * String month = eclatementDate[1];
						 * System.out.print(month+"\n"); String year =
						 * eclatementDate[2]; System.out.print(year+"\n");
						 * 
						 * switch (month)
						 * 
						 * {
						 * 
						 * case "janvier": month="01"; break; case "février":
						 * month="02"; break; case "mars":month="03"; break;
						 * case "avril":month="04"; break; case
						 * "mai":month="05"; break; case "juin":month="06";
						 * break; case "juillet":month="07"; break; case
						 * "Août":month="08"; break; case
						 * "septembre":month="09"; break; case
						 * "octobre":month="10"; break; case
						 * "novembre":month="11"; break; case
						 * "décembre":month="12"; break;
						 * 
						 * }
						 * 
						 * String birthdate=year+"/"+month+"/"+day;
						 */

						try {
							c = Connexion.getCon();

							final String sql = "SELECT NUMEROCARTEDEFIDELITE FROM CARTE_DE_FIDELITE INNER JOIN CLIENT ON CLIENT.IDCLIENT=CARTE_DE_FIDELITE.IDCLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND AGECLIENT=?";

							preStm = c.prepareStatement(sql);

							preStm.setString(1,
									SelectionNumeroCarteFidelite2.this.name);
							preStm.setString(2,
									SelectionNumeroCarteFidelite2.this.forname);
							preStm.setString(3,
									SelectionNumeroCarteFidelite2.this.birth);

							rs = preStm.executeQuery();

							while (rs.next()) {
								SelectionNumeroCarteFidelite2.this.numcarteliste = rs
										.getString(1);
							}

							System.out
									.print(SelectionNumeroCarteFidelite2.this.numcarteliste);
							rs.close();
							preStm.close();

						} catch (final SQLException e1) {
							e1.printStackTrace();

						}
						try {
							c = Connexion.getCon();

							final String sql = "SELECT CLIENT.IDCLIENT FROM CARTE_DE_FIDELITE INNER JOIN CLIENT ON CLIENT.IDCLIENT=CARTE_DE_FIDELITE.IDCLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND AGECLIENT=?";

							preStm = c.prepareStatement(sql);

							preStm.setString(1,
									SelectionNumeroCarteFidelite2.this.name);
							preStm.setString(2,
									SelectionNumeroCarteFidelite2.this.forname);
							preStm.setString(3,
									SelectionNumeroCarteFidelite2.this.birth);

							rs = preStm.executeQuery();

							while (rs.next()) {
								SelectionNumeroCarteFidelite2.this.idclientconsulatation = rs
										.getInt(1);
							}

							System.out
									.print(SelectionNumeroCarteFidelite2.this.idclientconsulatation);
							rs.close();
							preStm.close();

						} catch (final SQLException e1) {
							e1.printStackTrace();

						}

						switch (SelectionNumeroCarteFidelite2.this.choixmenuprecedent) {

						case "Menu > Gestion Carte de Fidélité > Désincription Newslettter":
							SelectionNumeroCarteFidelite2.this.text = "Désincription Newslettter";
							final ConfirmationOperationCarteFidelite fenetre = new ConfirmationOperationCarteFidelite(
									SelectionNumeroCarteFidelite2.this.interfaceActuelle,
									SelectionNumeroCarteFidelite2.this.numcarteliste,
									SelectionNumeroCarteFidelite2.this.choixmenuprecedent,
									SelectionNumeroCarteFidelite2.this.text);
							fenetre.setVisible(true);
							interfaceprecedente.dispose();
							SelectionNumeroCarteFidelite2.this.dispose();
							break;

						case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
							SelectionNumeroCarteFidelite2.this.text = "Suppression Fiche Client";
							final ConfirmationOperationCarteFidelite fenetre2 = new ConfirmationOperationCarteFidelite(
									SelectionNumeroCarteFidelite2.this.interfaceActuelle,
									SelectionNumeroCarteFidelite2.this.numcarteliste,
									SelectionNumeroCarteFidelite2.this.choixmenuprecedent,
									SelectionNumeroCarteFidelite2.this.text);
							fenetre2.setVisible(true);
							SelectionNumeroCarteFidelite2.this.dispose();
							interfaceprecedente.dispose();
							break;

						case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
							SelectionNumeroCarteFidelite2.this.text = "Mise à Jour Fiche Client";
							final ConfirmationOperationCarteFidelite fenetre3 = new ConfirmationOperationCarteFidelite(
									SelectionNumeroCarteFidelite2.this.interfaceActuelle,
									SelectionNumeroCarteFidelite2.this.numcarteliste,
									SelectionNumeroCarteFidelite2.this.choixmenuprecedent,
									SelectionNumeroCarteFidelite2.this.text);
							fenetre3.setVisible(true);
							interfaceprecedente.dispose();
							SelectionNumeroCarteFidelite2.this.dispose();
							break;

						case "Consulter une carte de fidelité":
							final FicheClientComplete consultationfiche = new FicheClientComplete(
									SelectionNumeroCarteFidelite2.this.idclientconsulatation);
							consultationfiche.setVisible(true);
							interfaceprecedente.dispose();
							SelectionNumeroCarteFidelite2.this.dispose();
							break;
						}
					}
				}

			});
			this.lblValider.setBounds(902, 450, 121, 92);
		}
		return this.lblValider;
	}

	private JRadioButton getRdbtnSelectionParNom() {
		if (this.rdbtnSelectionParNom == null) {
			this.rdbtnSelectionParNom = new JRadioButton(
					"Selection par NOM CLIENT");
			this.rdbtnSelectionParNom.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					if (SelectionNumeroCarteFidelite2.this.rdbtnSelectionParNom
							.isSelected()) {
						SelectionNumeroCarteFidelite2.this.comboBox
								.setEnabled(true);
						SelectionNumeroCarteFidelite2.this.comboBox_1
								.setEnabled(true);
						SelectionNumeroCarteFidelite2.this.comboBox_2
								.setEnabled(true);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_1
								.setEnabled(true);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_2
								.setEnabled(true);
						SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner
								.setEnabled(true);
						SelectionNumeroCarteFidelite2.this.lblNclient
								.setEnabled(false);
						SelectionNumeroCarteFidelite2.this.formattedTextField
								.setEnabled(false);
						SelectionNumeroCarteFidelite2.this.formattedTextField
								.setText(null);
						SelectionNumeroCarteFidelite2.this.lblValider
								.setVisible(false);

					}

				}
			});
			this.rdbtnSelectionParNom
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.rdbtnSelectionParNom.setForeground(Color.GRAY);
			this.rdbtnSelectionParNom.setBounds(285, 427, 197, 23);
			this.group.add(this.rdbtnSelectionParNom);
		}
		return this.rdbtnSelectionParNom;
	}

	private JRadioButton getRdbtnSelectionParNumero() {
		if (this.rdbtnSelectionParNumero == null) {
			this.rdbtnSelectionParNumero = new JRadioButton(
					"Selection par N\u00B0 de CLIENT");
			this.rdbtnSelectionParNumero
					.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(final ActionEvent e) {
							if (SelectionNumeroCarteFidelite2.this.rdbtnSelectionParNumero
									.isSelected()) {

								SelectionNumeroCarteFidelite2.this.comboBox
										.setEnabled(false);
								SelectionNumeroCarteFidelite2.this.comboBox_1
										.setEnabled(false);
								SelectionNumeroCarteFidelite2.this.comboBox_2
										.setEnabled(false);
								SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_1
										.setEnabled(false);
								SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner_2
										.setEnabled(false);
								SelectionNumeroCarteFidelite2.this.lblTaperOuSlectionner
										.setEnabled(false);
								SelectionNumeroCarteFidelite2.this.lblNclient
										.setEnabled(true);
								SelectionNumeroCarteFidelite2.this.formattedTextField
										.setEnabled(true);

							}
						}
					});
			this.rdbtnSelectionParNumero.setForeground(Color.GRAY);
			this.rdbtnSelectionParNumero.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.rdbtnSelectionParNumero.setBounds(285, 350, 197, 23);
			this.rdbtnSelectionParNumero.setSelected(true);
			this.group.add(this.rdbtnSelectionParNumero);

		}
		return this.rdbtnSelectionParNumero;
	}

	private JSeparator getSeparator() {
		if (this.separator == null) {
			this.separator = new JSeparator();
			this.separator.setLocation(216, 231);
			// separator.setBounds(10, 29, 50, 2);
		}
		return this.separator;
	}
}
