package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.ConfirmationOperationCarteFidelite;

public class SelectionNumeroCarteFidelite extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = -6658093948890261836L;
	private final String choixmenuprecedent;
	private final JPanel contentPane;
	private JLabel fond;
	private JTextField formattedTextField;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblChiffres;
	private JLabel lblFermer;
	private JLabel lblMenuChoix;
	private JLabel lblNclient;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblValider;
	private String message;
	private String numeroCarteFidelite;
	private String privilege;
	private JSeparator separator;
	private String text;

	public SelectionNumeroCarteFidelite(final String choix) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				SelectionNumeroCarteFidelite.this.lblMenuChoix
						.setText(SelectionNumeroCarteFidelite.this.choixmenuprecedent);

				switch (SelectionNumeroCarteFidelite.this.choixmenuprecedent) {

				case "Menu > Gestion Carte de Fidélité > Désincription Newslettter":
					SelectionNumeroCarteFidelite.this.lblNewLabel
							.setText("Désincription Newslettter");
					break;
				case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
					SelectionNumeroCarteFidelite.this.lblNewLabel
							.setText("Suppression carte de fidélite");
					break;
				case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
					SelectionNumeroCarteFidelite.this.lblNewLabel
							.setText("Mise à Jour d'une carte de fidélité");
					break;

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
										.getResource("/Images/fonds/menus-grises-fidelite.png")));
				this.label_1.setEnabled(false);
				this.label_1.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				break;

			case "invite":
				this.label_1.setEnabled(false);
				this.label_1.setVisible(false);
				this.label_3.setEnabled(false);
				this.label_3.setVisible(false);

				this.fond
						.setIcon(new ImageIcon(
								SelectionNumeroCarteFidelite.class
										.getResource("/Images/fonds/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						SelectionNumeroCarteFidelite.class
								.getResource("/Images/fonds/menus_fidelite.png")));
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
					SelectionNumeroCarteFidelite.this.lblValider
							.setVisible(true);
				}
			});
			this.formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.formattedTextField.setForeground(Color.GRAY);
			this.formattedTextField.setBorder(new LineBorder(new Color(171,
					173, 179)));
			this.formattedTextField.setBounds(512, 406, 259, 20);

		}
		return this.formattedTextField;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SelectionNumeroCarteFidelite.this.dispose();
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
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					SelectionNumeroCarteFidelite.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(475, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					SelectionNumeroCarteFidelite.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(592, 231, 114, 44);
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
					SelectionNumeroCarteFidelite.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(706, 231, 114, 44);
		}
		return this.label_3;
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

	private JLabel getLblChiffres() {
		if (this.lblChiffres == null) {
			// lblChiffres = new JLabel("* 13 chiffres Obligatoires");
			this.lblChiffres = new JLabel("");
			this.lblChiffres.setForeground(Color.GRAY);
			this.lblChiffres.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblChiffres.setBounds(240, 527, 169, 14);
		}
		return this.lblChiffres;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite fenetre = new GestionCartesDeFidelite();
					fenetre.setVisible(true);
					SelectionNumeroCarteFidelite.this.dispose();
				}
			});
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setBounds(880, 231, 158, 48);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuChoix() {
		if (this.lblMenuChoix == null) {
			this.lblMenuChoix = new JLabel("");
			this.lblMenuChoix.setVisible(false);
			this.lblMenuChoix.setForeground(Color.GRAY);
			this.lblMenuChoix.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuChoix.setBounds(243, 353, 293, 14);
		}
		return this.lblMenuChoix;
	}

	private JLabel getLblNclient() {
		if (this.lblNclient == null) {
			this.lblNclient = new JLabel("N\u00B0 Client * ");
			this.lblNclient.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNclient.setForeground(Color.GRAY);
			this.lblNclient.setBounds(369, 409, 133, 14);
		}
		return this.lblNclient;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 471, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					SelectionNumeroCarteFidelite.class
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
					SelectionNumeroCarteFidelite.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setVisible(false);
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					int idcarte = 0;
					boolean verification = true;
					SelectionNumeroCarteFidelite.this.numeroCarteFidelite = SelectionNumeroCarteFidelite.this.formattedTextField
							.getText().toString().toUpperCase();

					if (SelectionNumeroCarteFidelite.this.numeroCarteFidelite
							.isEmpty()) {
						verification = false;
						SelectionNumeroCarteFidelite.this.message = "Merci de vérifier le numéro de carte renseigné - Ce champ ne peut pas être vide";
					}

					// if (!numeroCarteFidelite.isEmpty()) {
					//
					// if (numeroCarteFidelite.length() != 13) {
					// verification = false;
					// message =
					// "Merci de vérifier le numéro de client renseigné - 13 caractéres obligatoires";
					// }
					//
					// }

					if (!SelectionNumeroCarteFidelite.this.numeroCarteFidelite
							.isEmpty()) {
						// && (numeroCarteFidelite.length() == 13)) {
						try {
							c = Connexion.getCon();

							final String sql = "SELECT IDCARTEDEFIDELITE FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";

							preStm = c.prepareStatement(sql);

							preStm.setString(
									1,
									SelectionNumeroCarteFidelite.this.numeroCarteFidelite);

							rs = preStm.executeQuery();

							while (rs.next()) {
								idcarte = rs.getInt(1);
							}

							System.out.print(idcarte);
							rs.close();
							preStm.close();

						} catch (final SQLException e1) {
							e1.printStackTrace();

						}

						if (idcarte == 0)

						{

							verification = false;
							SelectionNumeroCarteFidelite.this.message = "La carte n° "
									+ SelectionNumeroCarteFidelite.this.numeroCarteFidelite
									+ " n'existe pas";

						}

					}
					if (verification == true) {

						switch (SelectionNumeroCarteFidelite.this.choixmenuprecedent) {

						case "Menu > Gestion Carte de Fidélité > Désincription Newslettter":
							SelectionNumeroCarteFidelite.this.text = "Désincription Newslettter";
							final ConfirmationOperationCarteFidelite fenetre = new ConfirmationOperationCarteFidelite(
									SelectionNumeroCarteFidelite.this.interfaceActuelle,
									SelectionNumeroCarteFidelite.this.numeroCarteFidelite,
									SelectionNumeroCarteFidelite.this.choixmenuprecedent,
									SelectionNumeroCarteFidelite.this.text);
							fenetre.setVisible(true);
							break;

						case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
							SelectionNumeroCarteFidelite.this.text = "Suppression Fiche Client";
							final ConfirmationOperationCarteFidelite fenetre2 = new ConfirmationOperationCarteFidelite(
									SelectionNumeroCarteFidelite.this.interfaceActuelle,
									SelectionNumeroCarteFidelite.this.numeroCarteFidelite,
									SelectionNumeroCarteFidelite.this.choixmenuprecedent,
									SelectionNumeroCarteFidelite.this.text);
							fenetre2.setVisible(true);
							break;

						case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
							SelectionNumeroCarteFidelite.this.text = "Mise à Jour Fiche Client";
							final ConfirmationOperationCarteFidelite fenetre3 = new ConfirmationOperationCarteFidelite(
									SelectionNumeroCarteFidelite.this.interfaceActuelle,
									SelectionNumeroCarteFidelite.this.numeroCarteFidelite,
									SelectionNumeroCarteFidelite.this.choixmenuprecedent,
									SelectionNumeroCarteFidelite.this.text);
							fenetre3.setVisible(true);
							break;
						}
					} else {
						System.out.print("impossible");

						final AlerteSelection fenetre = new AlerteSelection(
								SelectionNumeroCarteFidelite.this.interfaceActuelle,
								SelectionNumeroCarteFidelite.this.message);
						fenetre.setVisible(true);
						SelectionNumeroCarteFidelite.this.interfaceActuelle
								.setEnabled(false);
						SelectionNumeroCarteFidelite.this.lblValider
								.setVisible(false);
					}
				}
			});
			this.lblValider.setBounds(887, 383, 150, 67);
		}
		return this.lblValider;
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
