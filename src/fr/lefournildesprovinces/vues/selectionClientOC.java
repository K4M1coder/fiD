package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class selectionClientOC extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4704559585980446620L;
	private String ageclient;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private JComboBox<Object> comboBox_2;
	private final JPanel contentPane;
	private JLabel fond;
	int idclient;
	private final JFrame interfaceactuelle;
	private final JFrame interfaceprecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblInformationsClientNon;
	private JLabel lblMenuSuppression;
	private JLabel lblMerciDeChoisir;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblRetour;
	private ComboBoxModel<Object> mod;
	private ComboBoxModel<Object> mod2;
	private ComboBoxModel<Object> mod3;
	private String nomClient;
	private String prenomClient;

	public selectionClientOC(final JFrame fenetrepre) {

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
		this.interfaceactuelle = this;
		this.interfaceprecedente = fenetrepre;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setEditable(true);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));

			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						selectionClientOC.this.nomClient = selectionClientOC.this.comboBox
								.getSelectedItem().toString();
						selectionClientOC.this.mod2 = new DefaultComboBoxModel<Object>(
								Select.listePrenomclientsanscarte(selectionClientOC.this.nomClient));
						selectionClientOC.this.comboBox_1
								.setModel(selectionClientOC.this.mod2);
						selectionClientOC.this.comboBox_1.setEnabled(true);
						selectionClientOC.this.lblNewLabel.setVisible(false);
					} catch (final Exception e) {

						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								selectionClientOC.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						selectionClientOC.this.interfaceactuelle
								.setEnabled(false);
						selectionClientOC.this.interfaceactuelle
								.setVisible(false);
						selectionClientOC.this.lblNewLabel.setVisible(true);
					}
				}
			});
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setBounds(459, 376, 343, 22);
			this.mod = new DefaultComboBoxModel<Object>(
					Select.listenomclientsanscarte());
			this.comboBox.setModel(this.mod);
			AutoCompletion.enable(this.comboBox);

		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			this.comboBox_1 = new JComboBox<Object>();
			this.comboBox_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.setEditable(true);
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						selectionClientOC.this.prenomClient = selectionClientOC.this.comboBox_1
								.getSelectedItem().toString();
						selectionClientOC.this.mod3 = new DefaultComboBoxModel<Object>(
								Select.listeageClientsanscarte(
										selectionClientOC.this.nomClient,
										selectionClientOC.this.prenomClient));
						selectionClientOC.this.comboBox_2
								.setModel(selectionClientOC.this.mod3);
						selectionClientOC.this.comboBox_2.setEnabled(true);
						selectionClientOC.this.lblNewLabel_1.setVisible(false);
						selectionClientOC.this.comboBox_2.setFocusable(false);
					} catch (final Exception e1) {

						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								selectionClientOC.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						selectionClientOC.this.interfaceactuelle
								.setEnabled(false);
						selectionClientOC.this.interfaceactuelle
								.setVisible(false);
						selectionClientOC.this.lblNewLabel_1.setVisible(true);
					}

				}
			});
			this.comboBox_1.setBounds(459, 407, 343, 22);
			AutoCompletion.enable(this.comboBox_1);
			this.comboBox_1.setEnabled(false);

		}
		return this.comboBox_1;
	}

	private JComboBox<Object> getComboBox_2() {
		if (this.comboBox_2 == null) {
			this.comboBox_2 = new JComboBox<Object>();
			this.comboBox_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						selectionClientOC.this.ageclient = selectionClientOC.this.comboBox_2
								.getSelectedItem().toString();
						selectionClientOC.this.lblMerciDeChoisir
								.setVisible(false);

						selectionClientOC.this.lblNewLabel_2.setVisible(true);
						selectionClientOC.this.lblNewLabel_2.setEnabled(true);

					} catch (final Exception e1) {

						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								selectionClientOC.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						selectionClientOC.this.interfaceactuelle
								.setEnabled(false);
						selectionClientOC.this.interfaceactuelle
								.setVisible(false);
					}

				}
			});
			this.comboBox_2.setEditable(true);
			this.comboBox_2.setBackground(Color.WHITE);
			this.comboBox_2.setBorder(null);
			this.comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_2.setForeground(Color.GRAY);
			this.comboBox_2.setBounds(459, 438, 343, 22);
			this.comboBox_2.setEnabled(false);

		}
		return this.comboBox_2;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(selectionClientOC.class
					.getResource("/Images/menus_extraction.png")));
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
					selectionClientOC.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(238, 231, 114, 44);
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
					selectionClientOC.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(347, 231, 114, 44);
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
					selectionClientOC.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(459, 231, 114, 44);
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
					selectionClientOC.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(573, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenuSuppression());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblMerciDeChoisir());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getComboBox_2());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblInformationsClientNon());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_3());
		}
		return this.layeredPane;
	}

	private JLabel getLblInformationsClientNon() {
		if (this.lblInformationsClientNon == null) {
			this.lblInformationsClientNon = new JLabel(
					"Fiche Client non-titulaire d'une carte de fidélité");
			this.lblInformationsClientNon.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblInformationsClientNon.setForeground(Color.GRAY);
			this.lblInformationsClientNon.setBounds(242, 286, 403, 14);
		}
		return this.lblInformationsClientNon;
	}

	private JLabel getLblMenuSuppression() {
		if (this.lblMenuSuppression == null) {
			this.lblMenuSuppression = new JLabel("");
			this.lblMenuSuppression.setForeground(Color.GRAY);
			this.lblMenuSuppression.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMenuSuppression.setBounds(226, 242, 501, 14);
		}
		return this.lblMenuSuppression;
	}

	private JLabel getLblMerciDeChoisir() {
		if (this.lblMerciDeChoisir == null) {
			this.lblMerciDeChoisir = new JLabel(
					"Taper ou s\u00E9lectionner un \u00E2ge");
			this.lblMerciDeChoisir.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeChoisir.setForeground(Color.GRAY);
			this.lblMerciDeChoisir.setBounds(527, 442, 206, 14);
		}
		return this.lblMerciDeChoisir;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Taper ou s\u00E9lectionner  le  nom du client");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(505, 380, 244, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel(
					"Taper ou s\u00E9lectionner son prénom");
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(515, 411, 233, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNewLabel_2.setIcon(new ImageIcon(selectionClientOC.class
					.getResource("/Images/valider.png")));
			this.lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					try {
						c = Connexion.getCon();

						final String sql = "SELECT CLIENT.IDCLIENT FROM CLIENT WHERE CLIENT.NOMCLIENT=? AND CLIENT.PRENOMCLIENT=? AND CLIENT.AGECLIENT=?";

						preStm = c.prepareStatement(sql);

						preStm.setString(1, selectionClientOC.this.nomClient);
						preStm.setString(2, selectionClientOC.this.prenomClient);
						preStm.setString(3, selectionClientOC.this.ageclient);

						rs = preStm.executeQuery();

					} catch (final Exception e) {

						System.out.print("erreur" + e.getMessage());
					}

					try {

						while (rs.next()) {

							selectionClientOC.this.idclient = rs.getInt(1);
						}

						rs.close();
						preStm.close();

					} catch (final Exception e)

					{
						System.out.print("error" + e.getMessage());

					}

					System.out.print(selectionClientOC.this.idclient);
					final FicheClientCompleteSansCarte fenetre = new FicheClientCompleteSansCarte(
							selectionClientOC.this.idclient);
					fenetre.setVisible(true);
					selectionClientOC.this.dispose();

				}
			});
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setBounds(887, 416, 150, 67);
			this.lblNewLabel_2.setVisible(false);
			this.lblNewLabel_2.setEnabled(false);

		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setIcon(new ImageIcon(selectionClientOC.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_3.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblRetour() {
		if (this.lblRetour == null) {
			this.lblRetour = new JLabel("");
			this.lblRetour.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					selectionClientOC.this.interfaceprecedente.dispose();
					selectionClientOC.this.dispose();
				}
			});
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setBounds(870, 231, 183, 46);
		}
		return this.lblRetour;
	}
}
