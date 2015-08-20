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
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;

public class Consultationficheutilisateur extends JFrame {

	private static Connection c;
	private static ResultSet rs;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3663211058305640819L;
	private static PreparedStatement stm;
	private final JPanel contentPane;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblIdentifiant;
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblPrivilges;
	private String privilege;

	private final String utilisateur;

	public Consultationficheutilisateur(final String utilisateurselectionne,
			final String password) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				try {
					c = Connexion.getCon();

					final String sql = "SELECT PRIVILEGE FROM USERS WHERE IDENTIFIANT=?";

					stm = c.prepareStatement(sql);
					stm.setString(1,
							Consultationficheutilisateur.this.utilisateur);
					rs = stm.executeQuery();
				} catch (final SQLException e56) {
					e56.getMessage();
				}
				try {
					while (rs.next()) {

						Consultationficheutilisateur.this.privilege = rs
								.getString(1);

					}
					rs.close();
					stm.close();
				} catch (final Exception e8)

				{
					System.out.print("error" + e8.getMessage());

				}

				switch (Consultationficheutilisateur.this.privilege) {
				case "administrateur":
					Consultationficheutilisateur.this.lblNewLabel_2
							.setText("Cet Utilisateur possède tous les droits d'accès sur l'ensemble du logiciel");
					Consultationficheutilisateur.this.lblNewLabel_3
							.setText("Administrateur");
					break;

				case "utilisateur":
					Consultationficheutilisateur.this.lblNewLabel_2
							.setText("Cet Utilisateur possède tous les droits à l'exception de l'extraction des informations");
					Consultationficheutilisateur.this.lblNewLabel_3
							.setText("Utilisateur");
					break;

				case "invite":
					Consultationficheutilisateur.this.lblNewLabel_2
							.setText("Cet Utilisateur possède des droits restreints à la saisie et à la mise à jour d'informations");
					Consultationficheutilisateur.this.lblNewLabel_3
							.setText("Invité");
					break;

				}

				Consultationficheutilisateur.this.lblNewLabel
						.setText(Consultationficheutilisateur.this.utilisateur);
				Consultationficheutilisateur.this.lblNewLabel_1
						.setText("**********");

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
			this.fond.setIcon(new ImageIcon(Consultationficheutilisateur.class
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
					Consultationficheutilisateur.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					Consultationficheutilisateur.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					Consultationficheutilisateur.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					Consultationficheutilisateur.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					Consultationficheutilisateur.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(876, 231, 179, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblIdentifiant());
			this.layeredPane.add(this.getLblMotDePasse());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblPrivilges());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNewLabel_4());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_5());
		}
		return this.layeredPane;
	}

	private JLabel getLblIdentifiant() {
		if (this.lblIdentifiant == null) {
			this.lblIdentifiant = new JLabel("Identifiant :");
			this.lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblIdentifiant.setForeground(Color.GRAY);
			this.lblIdentifiant.setBounds(486, 392, 81, 14);
		}
		return this.lblIdentifiant;
	}

	private JLabel getLblMotDePasse() {
		if (this.lblMotDePasse == null) {
			this.lblMotDePasse = new JLabel("Mot de Passe :");
			this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMotDePasse.setForeground(Color.GRAY);
			this.lblMotDePasse.setBounds(471, 417, 96, 14);
		}
		return this.lblMotDePasse;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(562, 392, 173, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setBounds(562, 417, 173, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setForeground(Color.RED);
			this.lblNewLabel_2.setBounds(243, 489, 759, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_3.setForeground(Color.GRAY);
			this.lblNewLabel_3.setBounds(562, 442, 162, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("Consulter une fiche utilisateur");
			this.lblNewLabel_4.setForeground(Color.GRAY);
			this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_4.setBounds(242, 286, 184, 14);
		}
		return this.lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (this.lblNewLabel_5 == null) {
			this.lblNewLabel_5 = new JLabel("");
			this.lblNewLabel_5.setIcon(new ImageIcon(
					Consultationficheutilisateur.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_5.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_5;
	}

	private JLabel getLblPrivilges() {
		if (this.lblPrivilges == null) {
			this.lblPrivilges = new JLabel("Privil\u00E8ges :");
			this.lblPrivilges.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrivilges.setForeground(Color.GRAY);
			this.lblPrivilges.setBounds(491, 442, 76, 14);
		}
		return this.lblPrivilges;
	}
}
