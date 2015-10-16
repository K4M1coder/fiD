package fr.lefournildesprovinces.vues.opcom;

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
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class SuccesInsertionClientOC extends JFrame {

	private static Connection c;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = 8295829903159137666L;
	private static PreparedStatement stm;
	private final String ageClient;
	private final String civiliteClient;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasin;
	private final int IdOperationCommerciale;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblClientInsreAvec;
	private JLabel lblContinuer;
	private JLabel lblModifierLaDerniere;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblQuitter;
	private JLabel lblSaisieDunBulletin;
	private String libelleoperation;
	private final String nomClient;
	private String nommagasinconcerne;
	private final String prenomClient;
	private String privilege;

	public SuccesInsertionClientOC(final String civilite, final String nom,
			final String prenom, final String dateNaissance,
			final int numeroOperationCommerciale, final int numeromagasin,
			final String age) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				SuccesInsertionClientOC.this.lblClientInsreAvec
						.setText("Client "
								+ SuccesInsertionClientOC.this.civiliteClient
								+ " " + SuccesInsertionClientOC.this.nomClient
								+ " "
								+ SuccesInsertionClientOC.this.prenomClient
								+ " inséré avec succès");
				try {
					c = Connexion.getCon();

					final String sql = "SELECT LIBELLEOPERATIONCOMMERCIALE FROM OPERATION_COMMERCIALE WHERE IDOPERATIONCOMMERCIALE=?";

					stm = c.prepareStatement(sql);
					stm.setInt(1,
							SuccesInsertionClientOC.this.IdOperationCommerciale);
					rs = stm.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						SuccesInsertionClientOC.this.libelleoperation = rs
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

					stm.setInt(1, SuccesInsertionClientOC.this.idmagasin);

					rs = stm.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						SuccesInsertionClientOC.this.nommagasinconcerne = rs
								.getString(1);

					}
					rs.close();
					stm.close();
				} catch (final Exception e)

				{
					System.out.print("error" + e.getMessage());

				}

				SuccesInsertionClientOC.this.lblNewLabel_2
						.setText(SuccesInsertionClientOC.this.libelleoperation);
				SuccesInsertionClientOC.this.lblNewLabel_4
						.setText(SuccesInsertionClientOC.this.nommagasinconcerne);
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(249, 254, 30));
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.civiliteClient = civilite;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.IdOperationCommerciale = numeroOperationCommerciale;
		this.idmagasin = numeromagasin;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.ageClient = age;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(SuccesInsertionClientOC.class
						.getResource("/Images/fonds/menus-grises-operation.png")));
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

				this.fond.setIcon(new ImageIcon(SuccesInsertionClientOC.class
						.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(SuccesInsertionClientOC.class
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
					SuccesInsertionClientOC.this.dispose();
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
					SuccesInsertionClientOC.this.dispose();
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
					SuccesInsertionClientOC.this.dispose();
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
					SuccesInsertionClientOC.this.dispose();
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
					SuccesInsertionClientOC.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(871, 232, 177, 44);
		}
		return this.label_4;
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
			this.layeredPane.add(this.getLblSaisieDunBulletin());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblNewLabel_4());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
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
			this.lblClientInsreAvec.setBounds(265, 385, 761, 14);
		}
		return this.lblClientInsreAvec;
	}

	private JLabel getLblContinuer() {
		if (this.lblContinuer == null) {
			this.lblContinuer = new JLabel("");
			this.lblContinuer.setIcon(new ImageIcon(
					SuccesInsertionClientOC.class
							.getResource("/Images/actionbutons/continuer.png")));
			this.lblContinuer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblContinuer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final InterrogationClientPorteurdeCarte fenetre = new InterrogationClientPorteurdeCarte(
							SuccesInsertionClientOC.this.IdOperationCommerciale,
							SuccesInsertionClientOC.this.idmagasin);
					fenetre.setVisible(true);
					SuccesInsertionClientOC.this.dispose();
				}
			});
			this.lblContinuer.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblContinuer.setForeground(Color.RED);
			this.lblContinuer.setBounds(678, 437, 126, 23);
		}
		return this.lblContinuer;
	}

	private JLabel getLblModifierLaDerniere() {
		if (this.lblModifierLaDerniere == null) {
			this.lblModifierLaDerniere = new JLabel("");
			this.lblModifierLaDerniere.setIcon(new ImageIcon(
					SuccesInsertionClientOC.class
							.getResource("/Images/actionbutons/modifier.png")));
			this.lblModifierLaDerniere.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblModifierLaDerniere.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					final MajClientOperationCommerciale fenetre = new MajClientOperationCommerciale(
							SuccesInsertionClientOC.this.nomClient,
							SuccesInsertionClientOC.this.prenomClient,
							SuccesInsertionClientOC.this.ageClient);
					fenetre.setVisible(true);
					SuccesInsertionClientOC.this.dispose();
				}
			});
			this.lblModifierLaDerniere
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblModifierLaDerniere.setForeground(Color.RED);
			this.lblModifierLaDerniere.setBounds(489, 435, 99, 26);
		}
		return this.lblModifierLaDerniere;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					SuccesInsertionClientOC.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("Operation :");
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(831, 444, 75, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(903, 444, 145, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("Magasin :");
			this.lblNewLabel_3.setForeground(Color.GRAY);
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_3.setBounds(831, 474, 65, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setForeground(Color.GRAY);
			this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_4.setBounds(903, 474, 145, 14);
		}
		return this.lblNewLabel_4;
	}

	private JLabel getLblQuitter() {
		if (this.lblQuitter == null) {
			this.lblQuitter = new JLabel("");
			this.lblQuitter.setIcon(new ImageIcon(SuccesInsertionClientOC.class
					.getResource("/Images/actionbutons/quitter-saisie.png")));
			this.lblQuitter.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblQuitter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					SuccesInsertionClientOC.this.dispose();
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
				}
			});
			this.lblQuitter.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblQuitter.setForeground(Color.RED);
			this.lblQuitter.setBounds(489, 479, 136, 26);
		}
		return this.lblQuitter;
	}

	private JLabel getLblSaisieDunBulletin() {
		if (this.lblSaisieDunBulletin == null) {
			this.lblSaisieDunBulletin = new JLabel("Saisir un bulletin");
			this.lblSaisieDunBulletin.setForeground(Color.GRAY);
			this.lblSaisieDunBulletin
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblSaisieDunBulletin.setBounds(242, 286, 323, 14);
		}
		return this.lblSaisieDunBulletin;
	}
}
