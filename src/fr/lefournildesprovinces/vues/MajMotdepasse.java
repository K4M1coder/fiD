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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class MajMotdepasse extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8433946420651749054L;
	private static Statement stm;
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
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNouveauMotDe;
	private final String provenance = "test";
	private JPasswordField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private final String utilisateur;
	private JLabel valider;

	public MajMotdepasse(final String utilisateurselectionne) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				MajMotdepasse.this.lblNewLabel_2
						.setText(MajMotdepasse.this.utilisateur);
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
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.utilisateur = utilisateurselectionne;
		this.interfaceActuelle = this;
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(MajMotdepasse.class
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
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					MajMotdepasse.this.dispose();
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
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					MajMotdepasse.this.dispose();
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
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					MajMotdepasse.this.dispose();
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
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					MajMotdepasse.this.dispose();
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
					MajMotdepasse.this.dispose();
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

					final char[] tabPassword7 = MajMotdepasse.this.textField_2
							.getPassword();
					final String verificationmotdepasse = String
							.valueOf(tabPassword7);

					String motdepasseenbase = null;
					try {
						c = Connexion.getCon();

						final String sql = "SELECT MOTDEPASSE FROM USERS WHERE IDENTIFIANT=?";

						preStm = c.prepareStatement(sql);

						preStm.setString(1, MajMotdepasse.this.utilisateur);

						rs = preStm.executeQuery();

					} catch (final SQLException e6) {
						e6.getMessage();
					}

					try {
						while (rs.next()) {

							motdepasseenbase = rs.getString(1);

						}
						rs.close();
						stm.close();

					} catch (final Exception e4)

					{
						System.out.print("error" + e4.getMessage());

					}

					if (motdepasseenbase.equals(verificationmotdepasse)) {

						MajMotdepasse.this.textField_2.setEnabled(false);
						MajMotdepasse.this.label_5.setVisible(false);
						MajMotdepasse.this.textField.setEnabled(true);
						MajMotdepasse.this.valider.setVisible(true);
					} else {
						final String message = "les mots de passe ne correspondent pas";
						final AlerteSelection fenetre = new AlerteSelection(
								MajMotdepasse.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajMotdepasse.this.interfaceActuelle.setEnabled(false);

					}
				}
			});
			this.label_5.setIcon(new ImageIcon(MajMotdepasse.class
					.getResource("/Images/valider.png")));
			this.label_5.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_5.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_5.setBounds(876, 369, 150, 67);
			this.label_5.setVisible(false);
		}
		return this.label_5;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getLblNouveauMotDe());
			this.layeredPane.add(this.getLblConfirmerLeMot());
			this.layeredPane.add(this.getValider());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblMotDePasse());
			this.layeredPane.add(this.getTextField_2());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_3());
		}
		return this.layeredPane;
	}

	private JLabel getLblConfirmerLeMot() {
		if (this.lblConfirmerLeMot == null) {
			this.lblConfirmerLeMot = new JLabel("Confirmer le Mot de Passe *");
			this.lblConfirmerLeMot.setForeground(Color.GRAY);
			this.lblConfirmerLeMot.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblConfirmerLeMot.setBounds(363, 477, 168, 14);
		}
		return this.lblConfirmerLeMot;
	}

	private JLabel getLblMotDePasse() {
		if (this.lblMotDePasse == null) {
			this.lblMotDePasse = new JLabel("Mot de Passe *");
			this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMotDePasse.setForeground(Color.GRAY);
			this.lblMotDePasse.setBounds(435, 392, 96, 14);
		}
		return this.lblMotDePasse;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Mettre à jour un mot de passe utilisateur");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 624, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("Utilisateur Selectionn\u00E9 :");
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setBounds(446, 356, 144, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(590, 356, 228, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setIcon(new ImageIcon(MajMotdepasse.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_3.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNouveauMotDe() {
		if (this.lblNouveauMotDe == null) {
			this.lblNouveauMotDe = new JLabel("Nouveau Mot de Passe *");
			this.lblNouveauMotDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNouveauMotDe.setForeground(Color.GRAY);
			this.lblNouveauMotDe.setBounds(383, 435, 148, 14);
		}
		return this.lblNouveauMotDe;
	}

	private JPasswordField getTextField() {
		if (this.textField == null) {
			this.textField = new JPasswordField();
			this.textField.setEnabled(false);
			this.textField.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {
					MajMotdepasse.this.textField_1.setEnabled(true);
				}
			});
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setForeground(Color.GRAY);
			this.textField.setBounds(532, 432, 228, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}

	private JPasswordField getTextField_1() {
		if (this.textField_1 == null) {
			this.textField_1 = new JPasswordField();
			this.textField_1
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField_1.setEnabled(false);
			this.textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_1.setForeground(Color.GRAY);
			this.textField_1.setBounds(532, 474, 228, 20);
			this.textField_1.setColumns(10);
		}
		return this.textField_1;
	}

	private JPasswordField getTextField_2() {
		if (this.textField_2 == null) {
			this.textField_2 = new JPasswordField();
			this.textField_2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent arg0) {
					MajMotdepasse.this.label_5.setVisible(true);
				}
			});
			this.textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField_2.setForeground(Color.GRAY);
			this.textField_2.setBounds(532, 392, 227, 20);
			this.textField_2.setColumns(10);
		}
		return this.textField_2;
	}

	private JLabel getValider() {
		if (this.valider == null) {
			this.valider = new JLabel("");
			this.valider.setVisible(false);
			this.valider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final char[] tabPassword = MajMotdepasse.this.textField
							.getPassword();
					final char[] tabPassword2 = MajMotdepasse.this.textField_1
							.getPassword();
					final String motdepasse1 = String.valueOf(tabPassword);

					final String motdepasse2 = String.valueOf(tabPassword2);

					if (motdepasse1.isEmpty()) {
						final String message = "Le champs Mot de Passe ne peut être vide";
						final AlerteSelection fenetre = new AlerteSelection(
								MajMotdepasse.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajMotdepasse.this.interfaceActuelle.setEnabled(false);

						MajMotdepasse.this.valider.setVisible(false);
						MajMotdepasse.this.textField.setText(null);
						MajMotdepasse.this.textField_1.setText(null);
					}
					if (motdepasse2.isEmpty()) {
						final String message = "Le champs Mot de Passe ne peut être vide";
						final AlerteSelection fenetre = new AlerteSelection(
								MajMotdepasse.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajMotdepasse.this.interfaceActuelle.setEnabled(false);

						MajMotdepasse.this.valider.setVisible(false);
						MajMotdepasse.this.textField.setText(null);
						MajMotdepasse.this.textField_1.setText(null);
					}

					if (motdepasse1.equals(motdepasse2)) {

						try {

							c = Connexion.getCon();
							c.setAutoCommit(false);

							final String sql = "UPDATE USERS SET MOTDEPASSE=? WHERE IDENTIFIANT=?";

							preStm = c.prepareStatement(sql);
							preStm.setString(1, motdepasse1);
							preStm.setString(2, MajMotdepasse.this.utilisateur);

							preStm.executeUpdate();

							c.commit();
							c.setAutoCommit(true);
							final String messageInsertion = "l'utilisateur "
									+ MajMotdepasse.this.utilisateur
									+ " à été modifié avec succès";
							final String messageinsertion2 = null;
							final String text = "Mettre à jour un mot de passe utilisateur";
							Message.setMessageaffichagefond(text);
							System.out.print(messageInsertion);
							final boolean etat = true;
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									messageInsertion, etat, text,
									messageinsertion2,
									MajMotdepasse.this.provenance,
									MajMotdepasse.this.idoperationtest,
									MajMotdepasse.this.idmagasintest);
							fenetre.setVisible(true);
							fenetre.setAlwaysOnTop(true);
							MajMotdepasse.this.dispose();

						} catch (final Exception e1) {

							System.out.print("erreur" + e1.getMessage());
							try {
								c.rollback();

								final String messageInsertion = "Impossible de mettre à jour l'utilisateur "
										+ MajMotdepasse.this.utilisateur;
								final String messageinsertion2 = null;
								final String text = "Mise à Jour d'un mot de passe Utilisateur";
								Message.setMessageaffichagefond(text);
								System.out.print(messageInsertion);
								final boolean etat = false;
								;
								final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
										messageInsertion, etat, text,
										messageinsertion2,
										MajMotdepasse.this.provenance,
										MajMotdepasse.this.idoperationtest,
										MajMotdepasse.this.idmagasintest);
								fenetre.setVisible(true);

								fenetre.setAlwaysOnTop(true);
								MajMotdepasse.this.dispose();

							} catch (final SQLException e2) {

								e2.printStackTrace();
							}
						}

						try {
							preStm.close();
						} catch (final SQLException e1) {

							e1.printStackTrace();
						}

					} else {
						final String message = "les mots de passe ne sont pas identiques";
						final AlerteSelection fenetre = new AlerteSelection(
								MajMotdepasse.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MajMotdepasse.this.interfaceActuelle.setEnabled(false);

					}

				}
			});
			this.valider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.valider.setHorizontalAlignment(SwingConstants.CENTER);
			this.valider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.valider.setIcon(new ImageIcon(MajMotdepasse.class
					.getResource("/Images/valider.png")));
			this.valider.setBounds(876, 447, 150, 67);

		}
		return this.valider;
	}
}
