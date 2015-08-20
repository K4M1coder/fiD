package fr.lefournildesprovinces.vues.admininstartaion;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.SuccesMagasinOperation;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class newuser extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5879133843605934709L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasintest = 0;
	private final int idoperationtest = 0;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLayeredPane layeredPane;
	private JLabel lblConfirmerLeMot;
	private JLabel lblIdentifiant;
	private JLabel lblMerciDeFaire;
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblPrivilge;
	private String message;
	private final String provenance = "test";
	private String selection;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;

	public newuser() {

		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

		this.interfaceActuelle = this;
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { null, " ADMINISTRATEUR", " UTILISATEUR",
					" INVITE" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.setBorder(null);
			this.comboBox.setEnabled(false);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						newuser.this.selection = newuser.this.comboBox
								.getSelectedItem().toString().substring(1)
								.toLowerCase();
						newuser.this.label_5.setVisible(true);
						newuser.this.lblMerciDeFaire.setVisible(false);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								newuser.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						newuser.this.interfaceActuelle.setEnabled(false);
						newuser.this.interfaceActuelle.setVisible(false);
						newuser.this.label_5.setVisible(false);
						newuser.this.label_5.setEnabled(false);
						newuser.this.lblMerciDeFaire.setVisible(false);

					}

				}
			});
			this.comboBox.setFocusable(false);
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setBounds(579, 459, 199, 22);
		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(newuser.class
					.getResource("/Images/menus_accueil-2.png")));
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
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					newuser.this.dispose();
				}
			});
			this.label.setBounds(367, 231, 114, 44);
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
					newuser.this.dispose();
				}
			});
			this.label_1.setBounds(476, 231, 114, 44);
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
					newuser.this.dispose();
				}
			});
			this.label_2.setBounds(588, 231, 114, 44);
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
					newuser.this.dispose();
				}
			});
			this.label_3.setBounds(702, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					newuser.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(876, 231, 179, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					boolean verification = true;

					final String nomuser = newuser.this.textField.getText();

					if (newuser.this.textField.getText().isEmpty()) {
						verification = false;
						newuser.this.message = "Le champs identifiant ne peut etre vide";
					}

					final char[] tabPassword = newuser.this.textField_1
							.getPassword();
					final String passuser = String.valueOf(tabPassword);

					if (newuser.this.textField_1.getPassword().length == 0) {
						verification = false;
						newuser.this.message = "Le champs mot de passe ne peut etre vide";

					}
					final char[] tabPassword2 = newuser.this.textField_1
							.getPassword();
					final String passuser2 = String.valueOf(tabPassword2);
					if (newuser.this.textField_2.getPassword().length == 0) {
						verification = false;
						newuser.this.message = "Le champs mot de passe ne peut etre vide";
					}

					if (!passuser.equals(passuser2)) {

						verification = false;
						newuser.this.message = "Les mots de passe ne correpondent pas";

					}

					if (verification == true) {

						try {
							c = Connexion.getCon();
							c.setAutoCommit(false);

							final String sql = "INSERT INTO USERS (IDENTIFIANT,MOTDEPASSE,PRIVILEGE) VALUES (?,?,?)";

							preStm = c.prepareStatement(sql);

							preStm.setString(1, nomuser);
							preStm.setString(2, passuser);
							preStm.setString(3, newuser.this.selection);

							preStm.executeUpdate();

							final String messageInsertion = "l'utilisateur "
									+ nomuser + " à été crée avec succès";
							final String messageinsertion2 = null;
							final String text = "Créer un profil utilisateur";
							Message.setMessageaffichagefond(text);
							System.out.print(messageInsertion);
							final boolean etat = true;
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									messageInsertion, etat, text,
									messageinsertion2, newuser.this.provenance,
									newuser.this.idoperationtest,
									newuser.this.idmagasintest);
							fenetre.setVisible(true);
							fenetre.setAlwaysOnTop(true);
							newuser.this.dispose();

							c.commit();
							c.setAutoCommit(true);

						} catch (final SQLException e6) {
							try {
								c.rollback();

								final String messageInsertion = "Impossible de crée l'utilisateur "
										+ nomuser;
								final String messageinsertion2 = null;
								final String text = "Créer un profil utilisateur";
								Message.setMessageaffichagefond(text);
								System.out.print(messageInsertion);
								final boolean etat = false;
								;
								final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
										messageInsertion, etat, text,
										messageinsertion2,
										newuser.this.provenance,
										newuser.this.idoperationtest,
										newuser.this.idmagasintest);
								fenetre.setVisible(true);
								fenetre.setAlwaysOnTop(true);
								newuser.this.dispose();

							} catch (final SQLException e2) {

								e2.printStackTrace();
							}
						}

						try {
							preStm.close();
						} catch (final SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {

						final AlerteSelection fenetre = new AlerteSelection(
								newuser.this.interfaceActuelle,
								newuser.this.message);
						fenetre.setVisible(true);
						newuser.this.interfaceActuelle.setEnabled(false);
						newuser.this.interfaceActuelle.setVisible(false);
						newuser.this.label_5.setVisible(false);
						newuser.this.label_5.setEnabled(false);
						newuser.this.lblMerciDeFaire.setVisible(true);

					}

				}
			});
			this.label_5.setIcon(new ImageIcon(newuser.class
					.getResource("/Images/valider.png")));
			this.label_5.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_5.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_5.setBounds(842, 436, 150, 67);
			this.label_5.setVisible(false);
		}
		return this.label_5;
	}

	private JLabel getLabel_6_1() {
		if (this.lblIdentifiant == null) {
			this.lblIdentifiant = new JLabel("Identifiant * :");
			this.lblIdentifiant.setForeground(Color.GRAY);
			this.lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblIdentifiant.setBounds(483, 366, 76, 14);
		}
		return this.lblIdentifiant;
	}

	private JLabel getLabel_6_2() {
		if (this.lblMotDePasse == null) {
			this.lblMotDePasse = new JLabel("Mot de Passe * :");
			this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMotDePasse.setForeground(Color.GRAY);
			this.lblMotDePasse.setBounds(468, 391, 91, 14);
		}
		return this.lblMotDePasse;
	}

	private JLabel getLabel_6_3() {
		if (this.lblConfirmerLeMot == null) {
			this.lblConfirmerLeMot = new JLabel("Confirmer le mot de passe * :");
			this.lblConfirmerLeMot.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblConfirmerLeMot.setForeground(Color.GRAY);
			this.lblConfirmerLeMot.setBounds(395, 416, 164, 14);
		}
		return this.lblConfirmerLeMot;
	}

	private JLabel getLabel_6_4() {
		if (this.lblPrivilge == null) {
			this.lblPrivilge = new JLabel("Privil\u00E8ge * :");
			this.lblPrivilge.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrivilge.setForeground(Color.GRAY);
			this.lblPrivilge.setBounds(494, 463, 65, 14);
		}
		return this.lblPrivilge;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6_1());
			this.layeredPane.add(this.getLabel_6_2());
			this.layeredPane.add(this.getLabel_6_3());
			this.layeredPane.add(this.getLabel_6_4());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getTextField_2());
			this.layeredPane.add(this.getLblMerciDeFaire());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblMerciDeFaire() {
		if (this.lblMerciDeFaire == null) {
			this.lblMerciDeFaire = new JLabel("Merci de faire un choix");
			this.lblMerciDeFaire.setForeground(Color.GRAY);
			this.lblMerciDeFaire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeFaire.setBounds(607, 463, 127, 14);
		}
		return this.lblMerciDeFaire;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Cr\u00E9er un profil utilisateur");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 624, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(newuser.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JTextField getTextField() {
		if (this.textField == null) {
			this.textField = new JTextField();
			this.textField.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {
					newuser.this.textField_1.setEnabled(true);
					newuser.this.textField_1.setEditable(true);
				}
			});
			this.textField.setForeground(Color.GRAY);
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setBounds(578, 363, 200, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}

	private JPasswordField getTextField_1() {
		if (this.textField_1 == null) {
			this.textField_1 = new JPasswordField();
			this.textField_1.setEditable(false);
			this.textField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					newuser.this.textField_2.setEnabled(true);
					newuser.this.textField_2.setEditable(true);
				}
			});
			this.textField_1
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_1.setEnabled(false);
			this.textField_1.setForeground(Color.GRAY);
			this.textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_1.setColumns(10);
			this.textField_1.setBounds(578, 388, 200, 20);
		}
		return this.textField_1;
	}

	private JPasswordField getTextField_2() {
		if (this.textField_2 == null) {
			this.textField_2 = new JPasswordField();
			this.textField_2.setEditable(false);
			this.textField_2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					newuser.this.comboBox.setEnabled(true);
				}
			});
			this.textField_2
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_2.setEnabled(false);
			this.textField_2.setForeground(Color.GRAY);
			this.textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_2.setColumns(10);
			this.textField_2.setBounds(578, 413, 200, 20);
		}
		return this.textField_2;
	}
}
