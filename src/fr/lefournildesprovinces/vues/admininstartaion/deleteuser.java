package fr.lefournildesprovinces.vues.admininstartaion;

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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.ressources.models.UtilisateurLogiciel;
import fr.lefournildesprovinces.vues.menus.GestionAdministrativeUttilisateursApplication;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.SuccesOperation;

public class deleteuser extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	/**
	 *
	 */
	private static final long serialVersionUID = 8894070255804692453L;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasintest = 0;
	private final int idoperationtest = 0;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private final String provenance = "admin";
	private final String utilisateur;
	protected UtilisateurLogiciel user;

	public deleteuser(final String utilisateurselectionne) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				deleteuser.this.label_6
						.setText("Etes vous sur de vouloir supprimer l'utilisateur "
								+ deleteuser.this.utilisateur + " ?");
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
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(deleteuser.class
					.getResource("/Images/fonds/menus_accueil-2.png")));
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
					deleteuser.this.dispose();
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
					deleteuser.this.dispose();
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
					deleteuser.this.dispose();
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
					deleteuser.this.dispose();
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
					deleteuser.this.dispose();
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

					deleteuser.this.user = Select.getUser(deleteuser.this.utilisateur);

					try {
						c = Connexion.getCon();
						c.setAutoCommit(false);

						System.out.println("delete user N°" + deleteuser.this.user.getNumeroutilisateur()+" with name : "+deleteuser.this.user.getIdentifiant());
						System.out.println("delete shopsAllowed");
						final String sqlDelUserShopsAllowed = "DELETE FROM GERER WHERE IDUSER=?";
						preStm = c.prepareStatement(sqlDelUserShopsAllowed);
						preStm.setString(1, deleteuser.this.user.getNumeroutilisateur());
						preStm.executeUpdate();

						System.out.println("delete profile");
						final String sqlDelUser = "DELETE FROM USERS WHERE IDENTIFIANT=?";
						preStm = c.prepareStatement(sqlDelUser);
						preStm.setString(1, deleteuser.this.user.getIdentifiant());
						preStm.executeUpdate();

						final String messageInsertion = "l'utilisateur "
								+ deleteuser.this.utilisateur
								+ " à été supprimé avec succès";
						final String messageinsertion2 = null;
						final String text = "Supprimer un utilisateur";
						Message.setMessageaffichagefond(text);
						System.out.println("\nmessage "+messageInsertion);
						System.out.println("message2 "+messageinsertion2);
						final boolean etat = true;
						System.out.println("delete :"+deleteuser.this.provenance);
						final SuccesOperation fenetre = new SuccesOperation(
								messageInsertion, etat, text,
								messageinsertion2, deleteuser.this.provenance,
								deleteuser.this.idoperationtest,
								deleteuser.this.idmagasintest,null);
						fenetre.setVisible(true);
						fenetre.setAlwaysOnTop(true);
						deleteuser.this.dispose();

						c.commit();
						c.setAutoCommit(true);

					} catch (final SQLException e6) {
						try {
							c.rollback();

							final String messageInsertion = "Impossible de supprimer l'utilisateur "
									+ deleteuser.this.utilisateur;
							final String messageinsertion2 = null;
							final String text = "Supprimer un utilisateur";
							Message.setMessageaffichagefond(text);
							System.out.print(messageInsertion);
							final boolean etat = false;
							;
							final SuccesOperation fenetre = new SuccesOperation(
									messageInsertion, etat, text,
									messageinsertion2,
									deleteuser.this.provenance,
									deleteuser.this.idoperationtest,
									deleteuser.this.idmagasintest,null);
							fenetre.setVisible(true);

							fenetre.setAlwaysOnTop(true);
							deleteuser.this.dispose();

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
			this.label_5.setIcon(new ImageIcon(deleteuser.class
					.getResource("/Images/actionbutons/valider.png")));
			this.label_5.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_5.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_5.setBounds(641, 413, 150, 67);
			this.label_5.setVisible(true);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("");
			this.label_6.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setBounds(384, 356, 513, 14);
		}
		return this.label_6;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_3());
		}
		return this.layeredPane;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Supprimer un utilisateur");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 624, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final GestionAdministrativeUttilisateursApplication fenetre = new GestionAdministrativeUttilisateursApplication();
					fenetre.setVisible(true);
					deleteuser.this.dispose();
				}
			});
			this.lblNewLabel_1.setIcon(new ImageIcon(deleteuser.class
					.getResource("/Images/actionbutons/annuler.png")));
			this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_1.setBounds(511, 404, 102, 84);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(465, 356, 353, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setIcon(new ImageIcon(deleteuser.class
					.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_3.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_3;
	}
}
