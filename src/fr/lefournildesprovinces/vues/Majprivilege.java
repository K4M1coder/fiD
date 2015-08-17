package fr.lefournildesprovinces.vues;

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

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class Majprivilege extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7536686983541607640L;
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
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private final String provenance = "test";
	private String selection;
	private final String utilisateur;

	public Majprivilege(final String utilisateurselectionne) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				Majprivilege.this.lblNewLabel_2
						.setText(Majprivilege.this.utilisateur);
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

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { null, " ADMINISTRATEUR", " UTILISATEUR",
					" INVITE" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setBorder(null);
			this.comboBox.setFocusable(false);
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						Majprivilege.this.selection = Majprivilege.this.comboBox
								.getSelectedItem().toString().substring(1)
								.toLowerCase();
						Majprivilege.this.label_5.setVisible(true);
						Majprivilege.this.lblNewLabel_3.setVisible(false);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								Majprivilege.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						Majprivilege.this.interfaceActuelle.setEnabled(false);
						Majprivilege.this.interfaceActuelle.setVisible(false);
						Majprivilege.this.label_5.setVisible(false);
						Majprivilege.this.label_5.setEnabled(false);
						Majprivilege.this.lblNewLabel_3.setVisible(true);

					}

				}
			});
			this.comboBox.setBounds(512, 416, 311, 22);
		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Majprivilege.class
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
					Majprivilege.this.dispose();
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
					Majprivilege.this.dispose();
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
					Majprivilege.this.dispose();
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
					Majprivilege.this.dispose();
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
					Majprivilege.this.dispose();
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

					try {
						c = Connexion.getCon();
						c.setAutoCommit(false);

						final String sql = "UPDATE USERS SET PRIVILEGE=? WHERE IDENTIFIANT=?";

						preStm = c.prepareStatement(sql);
						preStm.setString(1, Majprivilege.this.selection);
						preStm.setString(2, Majprivilege.this.utilisateur);

						preStm.executeUpdate();

						final String messageInsertion = "le privilege de l'utilisateur "
								+ Majprivilege.this.utilisateur
								+ " à été modifié avec succès";
						final String messageinsertion2 = null;
						final String text = "Mettre à jour un privilege utilisateur";
						Message.setMessageaffichagefond(text);
						System.out.print(messageInsertion);
						final boolean etat = true;
						final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
								messageInsertion, etat, text,
								messageinsertion2,
								Majprivilege.this.provenance,
								Majprivilege.this.idoperationtest,
								Majprivilege.this.idmagasintest);
						fenetre.setVisible(true);
						fenetre.setAlwaysOnTop(true);
						Majprivilege.this.dispose();

						c.commit();
						c.setAutoCommit(true);

					} catch (final SQLException e6) {
						try {
							c.rollback();

							final String messageInsertion = "Impossible de mettre à jour le privilege pour l'utilisateur "
									+ Majprivilege.this.utilisateur;
							final String messageinsertion2 = null;
							final String text = "Mettre à jour un privilege utilisateur";
							Message.setMessageaffichagefond(text);
							System.out.print(messageInsertion);
							final boolean etat = false;
							;
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									messageInsertion, etat, text,
									messageinsertion2,
									Majprivilege.this.provenance,
									Majprivilege.this.idoperationtest,
									Majprivilege.this.idmagasintest);
							fenetre.setVisible(true);

							fenetre.setAlwaysOnTop(true);
							Majprivilege.this.dispose();

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

				}
			});
			this.label_5.setIcon(new ImageIcon(Majprivilege.class
					.getResource("/Images/valider.png")));
			this.label_5.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_5.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_5.setBounds(881, 394, 150, 67);
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
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblMotDePasse());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_4());
		}
		return this.layeredPane;
	}

	private JLabel getLblMotDePasse() {
		if (this.lblMotDePasse == null) {
			this.lblMotDePasse = new JLabel("Privilege *");
			this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMotDePasse.setForeground(Color.GRAY);
			this.lblMotDePasse.setBounds(440, 420, 73, 14);
		}
		return this.lblMotDePasse;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Mettre \u00E0 jour un privilege utilisateur");
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
			this.lblNewLabel_1.setBounds(451, 384, 144, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(595, 384, 228, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel(
					"Merci de S\u00E9lectionner un privil\u00E8ge");
			this.lblNewLabel_3.setForeground(Color.GRAY);
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_3.setBounds(568, 420, 216, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setIcon(new ImageIcon(Majprivilege.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_4.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_4;
	}
}
