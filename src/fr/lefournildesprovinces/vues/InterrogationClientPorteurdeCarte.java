package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class InterrogationClientPorteurdeCarte extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	/**
	 * 
	 */
	private static final long serialVersionUID = -6744392373577270749L;
	private static PreparedStatement stm1;
	private int Clienttpresent;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasin;
	private final int IdOperationCommerciale;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLayeredPane layeredPane;
	private JLabel lblAnnuler;
	private JLabel lblCeClientPossede;
	private JLabel lblMerciDeSaisir;
	private JLabel lblNewLabel;
	private JLabel lblNon;
	private JLabel lblNouvelleParticipation;
	private JLabel lblOui;
	private JLabel lblValider;

	private String libelleoperation;
	private String message;

	private String nommagasinconcerne;
	private int numeroClient;
	private String privilege;
	private final String text = "Saisir un bulletin";
	private JTextField textField;

	public InterrogationClientPorteurdeCarte(final int idOC, final int idmag) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				try {
					c = Connexion.getCon();

					final String sql = "SELECT LIBELLEOPERATIONCOMMERCIALE FROM OPERATION_COMMERCIALE WHERE IDOPERATIONCOMMERCIALE=?";

					stm1 = c.prepareStatement(sql);
					stm1.setInt(
							1,
							InterrogationClientPorteurdeCarte.this.IdOperationCommerciale);
					rs = stm1.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						InterrogationClientPorteurdeCarte.this.libelleoperation = rs
								.getString(1);

					}
					rs.close();
					stm1.close();
				} catch (final Exception e45)

				{
					System.out.print("error" + e45.getMessage());

				}
				try {
					c = Connexion.getCon();

					final String sql2 = "SELECT NOMMAGASIN FROM MAGASIN WHERE IDMAGASIN=?";

					stm1 = c.prepareStatement(sql2);

					stm1.setInt(1,
							InterrogationClientPorteurdeCarte.this.idmagasin);

					rs = stm1.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						InterrogationClientPorteurdeCarte.this.nommagasinconcerne = rs
								.getString(1);

					}
					rs.close();
					stm1.close();
				} catch (final Exception e41)

				{
					System.out.print("error" + e41.getMessage());

				}
				InterrogationClientPorteurdeCarte.this.label_6
						.setText(InterrogationClientPorteurdeCarte.this.libelleoperation);
				InterrogationClientPorteurdeCarte.this.label_8
						.setText(InterrogationClientPorteurdeCarte.this.nommagasinconcerne);
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
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.IdOperationCommerciale = idOC;
		this.idmagasin = idmag;
		this.interfaceActuelle = this;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								InterrogationClientPorteurdeCarte.class
										.getResource("/Images/menus-grises-operation.png")));
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
								InterrogationClientPorteurdeCarte.class
										.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						InterrogationClientPorteurdeCarte.class
								.getResource("/Images/menus_operation.png")));
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
					InterrogationClientPorteurdeCarte.this.dispose();
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
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					InterrogationClientPorteurdeCarte.this.dispose();
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
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					InterrogationClientPorteurdeCarte.this.dispose();
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
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					InterrogationClientPorteurdeCarte.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(704, 231, 114, 44);
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
					InterrogationClientPorteurdeCarte.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(862, 231, 188, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("Operation :");
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setBounds(239, 500, 75, 14);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("");
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setBounds(311, 500, 145, 14);
		}
		return this.label_6;
	}

	private JLabel getLabel_7() {
		if (this.label_7 == null) {
			this.label_7 = new JLabel("Magasin :");
			this.label_7.setForeground(Color.GRAY);
			this.label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_7.setBounds(239, 530, 65, 14);
		}
		return this.label_7;
	}

	private JLabel getLabel_8() {
		if (this.label_8 == null) {
			this.label_8 = new JLabel("");
			this.label_8.setForeground(Color.GRAY);
			this.label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_8.setBounds(311, 530, 145, 14);
		}
		return this.label_8;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblCeClientPossede());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLblMerciDeSaisir());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblAnnuler());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNouvelleParticipation());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getLabel_7());
			this.layeredPane.add(this.getLabel_8());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblAnnuler() {
		if (this.lblAnnuler == null) {
			this.lblAnnuler = new JLabel("");
			this.lblAnnuler.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblAnnuler.setIcon(new ImageIcon(
					InterrogationClientPorteurdeCarte.class
							.getResource("/Images/annuler.png")));
			this.lblAnnuler.setVisible(false);
			this.lblAnnuler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final InterrogationClientPorteurdeCarte fenetre = new InterrogationClientPorteurdeCarte(
							InterrogationClientPorteurdeCarte.this.IdOperationCommerciale,
							InterrogationClientPorteurdeCarte.this.idmagasin);
					fenetre.setVisible(true);
					InterrogationClientPorteurdeCarte.this.dispose();
				}
			});
			this.lblAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblAnnuler.setForeground(Color.GRAY);
			this.lblAnnuler.setBounds(737, 393, 99, 66);
		}
		return this.lblAnnuler;
	}

	private JLabel getLblCeClientPossede() {
		if (this.lblCeClientPossede == null) {
			this.lblCeClientPossede = new JLabel(
					"Ce client est il porteur d'une carte de fid\u00E9lit\u00E9 ?");
			this.lblCeClientPossede.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCeClientPossede.setForeground(Color.GRAY);
			this.lblCeClientPossede.setBounds(511, 376, 283, 14);
		}
		return this.lblCeClientPossede;
	}

	private JLabel getLblMerciDeSaisir() {
		if (this.lblMerciDeSaisir == null) {
			this.lblMerciDeSaisir = new JLabel(
					"Merci de saisir le numero de la carte");
			this.lblMerciDeSaisir.setForeground(Color.GRAY);
			this.lblMerciDeSaisir.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSaisir.setBounds(300, 420, 241, 14);
			this.lblMerciDeSaisir.setVisible(false);
			this.lblMerciDeSaisir.setEnabled(false);
		}
		return this.lblMerciDeSaisir;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					InterrogationClientPorteurdeCarte.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setIcon(new ImageIcon(
					InterrogationClientPorteurdeCarte.class
							.getResource("/Images/non.png")));
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionClientOperationCommerciale fenetre = new GestionClientOperationCommerciale(
							InterrogationClientPorteurdeCarte.this.IdOperationCommerciale,
							InterrogationClientPorteurdeCarte.this.idmagasin);

					fenetre.setVisible(true);

					InterrogationClientPorteurdeCarte.this.dispose();
				}
			});
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(566, 414, 51, 26);
		}
		return this.lblNon;
	}

	private JLabel getLblNouvelleParticipation() {
		if (this.lblNouvelleParticipation == null) {
			this.lblNouvelleParticipation = new JLabel("Saisir un bulletin");
			this.lblNouvelleParticipation.setForeground(Color.GRAY);
			this.lblNouvelleParticipation.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblNouvelleParticipation.setBounds(242, 286, 323, 14);
		}
		return this.lblNouvelleParticipation;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(new ImageIcon(
					InterrogationClientPorteurdeCarte.class
							.getResource("/Images/oui.png")));
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					InterrogationClientPorteurdeCarte.this.lblOui
							.setVisible(false);
					InterrogationClientPorteurdeCarte.this.lblOui
							.setEnabled(false);
					InterrogationClientPorteurdeCarte.this.lblNon
							.setVisible(false);
					InterrogationClientPorteurdeCarte.this.lblOui
							.setEnabled(false);
					InterrogationClientPorteurdeCarte.this.lblMerciDeSaisir
							.setVisible(true);
					InterrogationClientPorteurdeCarte.this.lblMerciDeSaisir
							.setEnabled(true);
					InterrogationClientPorteurdeCarte.this.textField
							.setVisible(true);
					InterrogationClientPorteurdeCarte.this.textField
							.setEnabled(true);
					InterrogationClientPorteurdeCarte.this.lblValider
							.setVisible(true);
					InterrogationClientPorteurdeCarte.this.lblValider
							.setEnabled(true);
					InterrogationClientPorteurdeCarte.this.lblAnnuler
							.setVisible(true);

				}
			});
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setBounds(654, 414, 73, 26);
		}
		return this.lblOui;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setIcon(new ImageIcon(
					InterrogationClientPorteurdeCarte.class
							.getResource("/Images/valider.png")));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final String numcarte = InterrogationClientPorteurdeCarte.this.textField
							.getText();
					boolean verification = true;
					int idcarte = 0;

					if (numcarte.isEmpty()) {
						verification = false;
						InterrogationClientPorteurdeCarte.this.message = "Merci de vérifier votre numéro de client - Ce champ ne peut être vide";
					}

					// if (!numcarte.isEmpty()) {
					// if (numcarte.length() != 13) {
					// verification = false;
					// message =
					// "Merci de vérifier votre numéro de client - 13 caractéres obligatoires";
					// }
					// }

					// if (!numcarte.isEmpty() && (numcarte.length() == 13)) {
					if (!numcarte.isEmpty()) {
						try {

							c = Connexion.getCon();

							final String sql = "SELECT IDCARTEDEFIDELITE FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";

							preStm = c.prepareStatement(sql);

							preStm.setString(1, numcarte);

							rs = preStm.executeQuery();

							while (rs.next()) {
								idcarte = rs.getInt(1);
							}

							rs.close();
							preStm.close();

						} catch (final SQLException e1) {
							e1.printStackTrace();

						}

						if (idcarte == 0)

						{

							verification = false;
							InterrogationClientPorteurdeCarte.this.message = " Cependant La carte n° "
									+ numcarte
									+ " n'est rattachée à aucun client";

						}

					}
					if (verification == true) {
						final String provenance = "operation_commerciale";

						try {
							c = Connexion.getCon();

							final String sql = "SELECT IDCLIENT FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";

							preStm = c.prepareStatement(sql);

							preStm.setString(1, numcarte);

							rs = preStm.executeQuery();

							while (rs.next()) {
								InterrogationClientPorteurdeCarte.this.numeroClient = rs
										.getInt(1);
							}

							preStm.close();
							rs.close();
							System.out
									.print(InterrogationClientPorteurdeCarte.this.numeroClient);

							final String testdejajouer = "SELECT COUNT(*) FROM PARTICIPER WHERE IDOPERATIONCOMMERCIALE=? AND IDCLIENT=? AND IDMAGASIN=?";
							preStm = c.prepareStatement(testdejajouer);

							preStm.setInt(
									1,
									InterrogationClientPorteurdeCarte.this.IdOperationCommerciale);
							preStm.setInt(
									2,
									InterrogationClientPorteurdeCarte.this.numeroClient);
							preStm.setInt(
									3,
									InterrogationClientPorteurdeCarte.this.idmagasin);

							rs = preStm.executeQuery();
							while (rs.next()) {
								InterrogationClientPorteurdeCarte.this.Clienttpresent = rs
										.getInt(1);
							}

							preStm.close();
							rs.close();

							System.out
									.print(InterrogationClientPorteurdeCarte.this.Clienttpresent);

							if (InterrogationClientPorteurdeCarte.this.Clienttpresent == 0) {

								final String table_participer = "INSERT INTO PARTICIPER(IDOPERATIONCOMMERCIALE,IDCLIENT,IDMAGASIN) VALUES (?,?,?)";
								preStm = c.prepareStatement(table_participer);

								preStm.setInt(
										1,
										InterrogationClientPorteurdeCarte.this.IdOperationCommerciale);
								preStm.setInt(
										2,
										InterrogationClientPorteurdeCarte.this.numeroClient);
								preStm.setInt(
										3,
										InterrogationClientPorteurdeCarte.this.idmagasin);

								preStm.executeUpdate();

								preStm.close();

								InterrogationClientPorteurdeCarte.this.message = "la participation de ce client est bien prise en compte";
								final Verifparticipation fenetre = new Verifparticipation(
										InterrogationClientPorteurdeCarte.this.message,
										numcarte,
										provenance,
										InterrogationClientPorteurdeCarte.this.IdOperationCommerciale,
										InterrogationClientPorteurdeCarte.this.text,
										InterrogationClientPorteurdeCarte.this.idmagasin);
								fenetre.setVisible(true);
								InterrogationClientPorteurdeCarte.this
										.dispose();

								/*
								 * MajFicheClientCarteFidelite fenetre=new
								 * MajFicheClientCarteFidelite(numcarte,
								 * provenance, IdOperationCommerciale);
								 * fenetre.setVisible(true); dispose();
								 */

							}

							else {

								System.out.print("impossible");
								InterrogationClientPorteurdeCarte.this.message = "la participation de ce client est déjé validée, elle ne sera donc pas prise en compte";
								final Verifparticipation fenetre = new Verifparticipation(
										InterrogationClientPorteurdeCarte.this.message,
										numcarte,
										provenance,
										InterrogationClientPorteurdeCarte.this.IdOperationCommerciale,
										InterrogationClientPorteurdeCarte.this.text,
										InterrogationClientPorteurdeCarte.this.idmagasin);
								fenetre.setVisible(true);
								InterrogationClientPorteurdeCarte.this
										.dispose();

							}

						} catch (final SQLException e1) {
							e1.printStackTrace();

						}

					} else {
						System.out.print("impossible");
						// if ((idcarte == 0) && (numcarte.length() == 13)) {
						if ((idcarte == 0)) {
							final carteinexistantecreation fenetre = new carteinexistantecreation(
									InterrogationClientPorteurdeCarte.this.interfaceActuelle,
									InterrogationClientPorteurdeCarte.this.message,
									numcarte,
									InterrogationClientPorteurdeCarte.this.IdOperationCommerciale,
									InterrogationClientPorteurdeCarte.this.idmagasin);
							fenetre.setVisible(true);
							InterrogationClientPorteurdeCarte.this.interfaceActuelle
									.setVisible(false);

						} else {
							final AlerteSelection fenetre = new AlerteSelection(
									InterrogationClientPorteurdeCarte.this.interfaceActuelle,
									InterrogationClientPorteurdeCarte.this.message);
							fenetre.setVisible(true);
							InterrogationClientPorteurdeCarte.this.interfaceActuelle
									.setEnabled(false);
							InterrogationClientPorteurdeCarte.this.interfaceActuelle
									.setVisible(false);
						}
					}

				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(858, 389, 99, 77);
			this.lblValider.setVisible(false);
			this.lblValider.setEnabled(false);
		}
		return this.lblValider;
	}

	private JTextField getTextField() {
		if (this.textField == null) {
			this.textField = new JTextField();
			this.textField.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textField.setForeground(Color.GRAY);
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setBounds(541, 417, 178, 20);
			this.textField.setColumns(10);
			this.textField.setVisible(false);
			this.textField.setEnabled(false);
		}
		return this.textField;
	}
}
