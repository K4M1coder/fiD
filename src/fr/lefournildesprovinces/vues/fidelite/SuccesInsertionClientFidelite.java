package fr.lefournildesprovinces.vues.fidelite;

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
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.InterrogationClientPorteurdeCarte;

/**
 * @author admin
 *
 */
public class SuccesInsertionClientFidelite extends JFrame {

	private static Connection c;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = -8276626397309922805L;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_Magasin;
	private JLabel label_Operation;
	private JLabel lblClientInsreAvec;
	private JLabel lblContinuer;
	private JLabel lblModifierLaDerniere;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblQuitter;
	private JLayeredPane layeredPane;
	private String libelleoperation;
	private String nommagasinconcerne;
	private String privilege;
	private final JFrame interfaceActuelle;
	private final JPanel contentPane;
	private final String choixmenuprecdentoperation;
	private final String civiliteClient;
	private final String nomClient;
	private final String numerocarte;
	private final String prenomClient;
	private final int magasin;
	private final int operation;
	private static PreparedStatement stm;

	public SuccesInsertionClientFidelite(final String civilite,
			final String nom, final String prenom, final String dateNaissance,
			final String numcarte, final String age,
			final String choixetprovenance, final int idoperation,
			final int idmagasinoperation) {
		System.out.println("successinsertion invoked");
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				SuccesInsertionClientFidelite.this.lblClientInsreAvec
						.setText("Client "
								+ SuccesInsertionClientFidelite.this.civiliteClient
								+ " "
								+ SuccesInsertionClientFidelite.this.nomClient
								+ " "
								+ SuccesInsertionClientFidelite.this.prenomClient
								+ " inséré avec succès");
				System.out
						.print(SuccesInsertionClientFidelite.this.choixmenuprecdentoperation);
				try {
					c = Connexion.getCon();

					final String sql = "SELECT LIBELLEOPERATIONCOMMERCIALE FROM OPERATION_COMMERCIALE WHERE IDOPERATIONCOMMERCIALE=?";

					stm = c.prepareStatement(sql);
					stm.setInt(1, SuccesInsertionClientFidelite.this.operation);
					rs = stm.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						SuccesInsertionClientFidelite.this.libelleoperation = rs
								.getString(1);

					}
					rs.close();
					stm.close();
				} catch (final Exception e)

				{
					System.out.print("error" + e.getMessage());

				}
				try {
					c = Connexion.getCon();

					final String sql = "SELECT NOMMAGASIN FROM MAGASIN WHERE IDMAGASIN=?";

					stm = c.prepareStatement(sql);

					stm.setInt(1, SuccesInsertionClientFidelite.this.magasin);

					rs = stm.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						SuccesInsertionClientFidelite.this.nommagasinconcerne = rs
								.getString(1);

					}
					rs.close();
					stm.close();
				} catch (final Exception e)

				{
					System.out.print("error" + e.getMessage());

				}

				if (SuccesInsertionClientFidelite.this.choixmenuprecdentoperation
						.equals("creationcarteparoperation")) {

					SuccesInsertionClientFidelite.this.label_5.setVisible(true);
					SuccesInsertionClientFidelite.this.label_6.setVisible(true);
					SuccesInsertionClientFidelite.this.label_Operation.setVisible(true);
					SuccesInsertionClientFidelite.this.label_Magasin.setVisible(true);

					SuccesInsertionClientFidelite.this.label_Operation
							.setText(SuccesInsertionClientFidelite.this.libelleoperation);
					SuccesInsertionClientFidelite.this.label_Magasin
							.setText(SuccesInsertionClientFidelite.this.nommagasinconcerne);
				}
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setBackground(new Color(249, 254, 30));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.civiliteClient = civilite;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.numerocarte = numcarte;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.choixmenuprecdentoperation = choixetprovenance;
		this.operation = idoperation;
		this.magasin = idmagasinoperation;
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
								SuccesInsertionClientFidelite.class
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
								SuccesInsertionClientFidelite.class
										.getResource("/Images/fonds/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						SuccesInsertionClientFidelite.class
								.getResource("/Images/fonds/menus_fidelite.png")));
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
					SuccesInsertionClientFidelite.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(235, 231, 114, 44);
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
					SuccesInsertionClientFidelite.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(472, 231, 114, 44);
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
					SuccesInsertionClientFidelite.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(589, 231, 114, 44);
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
					SuccesInsertionClientFidelite.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(703, 231, 114, 44);
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
					SuccesInsertionClientFidelite.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.label_4.setBounds(878, 231, 175, 48);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("Operation :");
			this.label_5.setVisible(false);
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setBounds(863, 440, 75, 14);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("Magasin :");
			this.label_6.setVisible(false);
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setBounds(863, 466, 65, 14);
		}
		return this.label_6;
	}

	private JLabel getLabel_Operation() {
		if (this.label_Operation == null) {
			this.label_Operation = new JLabel("");
			this.label_Operation.setVisible(false);
			this.label_Operation.setForeground(Color.GRAY);
			this.label_Operation.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_Operation.setBounds(938, 440, 145, 14);
		}
		return this.label_Operation;
	}

	private JLabel getLabel_Magasin() {
		if (this.label_Magasin == null) {
			this.label_Magasin = new JLabel("");
			this.label_Magasin.setVisible(false);
			this.label_Magasin.setForeground(Color.GRAY);
			this.label_Magasin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_Magasin.setBounds(938, 466, 145, 14);
		}
		return this.label_Magasin;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblClientInsreAvec());
			this.layeredPane.add(this.getLblContinuer());
			this.layeredPane.add(this.getLblModifierLaDerniere());
			this.layeredPane.add(this.getLblQuitter());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getLabel_Operation());
			this.layeredPane.add(this.getLabel_Magasin());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblClientInsreAvec() {
		if (this.lblClientInsreAvec == null) {
			this.lblClientInsreAvec = new JLabel("");
			this.lblClientInsreAvec
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblClientInsreAvec
					.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblClientInsreAvec.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblClientInsreAvec.setForeground(Color.GRAY);
			this.lblClientInsreAvec.setBounds(256, 384, 771, 14);
		}
		return this.lblClientInsreAvec;
	}

	private JLabel getLblContinuer() {
		if (this.lblContinuer == null) {
			this.lblContinuer = new JLabel("");
			this.lblContinuer.setIcon(new ImageIcon(
					SuccesInsertionClientFidelite.class
							.getResource("/Images/actionbutons/continuer.png")));
			this.lblContinuer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblContinuer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					SuccesInsertionClientFidelite.this.dispose();
					if (SuccesInsertionClientFidelite.this.choixmenuprecdentoperation
							.equals("creationcarteparoperation")) {
						final InterrogationClientPorteurdeCarte fenetre = new InterrogationClientPorteurdeCarte(
								SuccesInsertionClientFidelite.this.operation,
								SuccesInsertionClientFidelite.this.magasin);
						fenetre.setVisible(true);
						SuccesInsertionClientFidelite.this.dispose();
					} else {

						final String numcarte = null;
						final int numoperation = 0;
						final int nummagasin = 0;
						final String choix = "succes";
						final FideliteNouvelleFicheClient nouvelleFiche = new FideliteNouvelleFicheClient(
								numcarte, numoperation, nummagasin, choix, interfaceActuelle);
						nouvelleFiche.setVisible(true);
						SuccesInsertionClientFidelite.this.dispose();
					}
				}
			});
			this.lblContinuer.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblContinuer.setForeground(Color.RED);
			this.lblContinuer.setBounds(691, 429, 126, 26);
		}
		return this.lblContinuer;
	}

	private JLabel getLblModifierLaDerniere() {
		if (this.lblModifierLaDerniere == null) {
			this.lblModifierLaDerniere = new JLabel("");
			this.lblModifierLaDerniere.setIcon(new ImageIcon(
					SuccesInsertionClientFidelite.class
							.getResource("/Images/actionbutons/modifier.png")));
			this.lblModifierLaDerniere.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblModifierLaDerniere.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					/*
					 * String eclatementDate[] = dateNaissanceClient.split("/");
					 * String day = eclatementDate[0]; String month =
					 * eclatementDate[1]; String year = eclatementDate[2];
					 *
					 * String dateNaissanceClientformat=year+"/"+month+"/"+day;
					 */

					final MajFicheClientCarteFidelite fenetre = new MajFicheClientCarteFidelite(
							SuccesInsertionClientFidelite.this.numerocarte,
							"test", 0, 0);
					fenetre.setVisible(true);
					SuccesInsertionClientFidelite.this.dispose();
				}
			});
			this.lblModifierLaDerniere
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblModifierLaDerniere.setForeground(Color.RED);
			this.lblModifierLaDerniere.setBounds(493, 429, 99, 26);
		}
		return this.lblModifierLaDerniere;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Nouvelle carte de fidélité");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(242, 286, 379, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					SuccesInsertionClientFidelite.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblQuitter() {
		if (this.lblQuitter == null) {
			this.lblQuitter = new JLabel("");
			this.lblQuitter.setIcon(new ImageIcon(
					SuccesInsertionClientFidelite.class
							.getResource("/Images/actionbutons/quitter-saisie.png")));
			this.lblQuitter.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblQuitter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					SuccesInsertionClientFidelite.this.dispose();
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
				}
			});
			this.lblQuitter.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblQuitter.setForeground(Color.RED);
			this.lblQuitter.setBounds(493, 466, 136, 26);
		}
		return this.lblQuitter;
	}
}
