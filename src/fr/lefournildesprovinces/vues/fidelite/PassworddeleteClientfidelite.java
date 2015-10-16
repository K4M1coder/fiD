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
import java.sql.SQLException;

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
import fr.lefournildesprovinces.ressources.models.Motdepassesuppression;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.GestionOperationCommerciale;
import fr.lefournildesprovinces.vues.popups.ErrorPassword;
import fr.lefournildesprovinces.vues.popups.SuccesOperation;

public class PassworddeleteClientfidelite extends JFrame {

	private static Connection c;
	/**
	 *
	 */
	private static final long serialVersionUID = 960524369481813363L;
	private static PreparedStatement stm;
	private final JPanel contentPane;
	private JLabel fond;
	int idcartefidelite;
	private final int idmagasintest = 0;

	private final int idoperationtest = 0;
	private final JFrame interfaceactuelle;

	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblAnnuler;
	private JLabel lblEntrerVotreMot;
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblValider;
	private final String messageinsertion2 = null;
	String numcarte;
	private String privilege;
	private final String provenance = "delete";
	private String text;
	private JPasswordField textField;

	public PassworddeleteClientfidelite(final int idcarte,
			final String numeroCarteFideliteClient, final String text) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				PassworddeleteClientfidelite.this.lblNewLabel.setText(text);

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

		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.interfaceactuelle = this;
		this.idcartefidelite = idcarte;
		this.numcarte = numeroCarteFideliteClient;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								PassworddeleteClientfidelite.class
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
								PassworddeleteClientfidelite.class
										.getResource("/Images/fonds/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						PassworddeleteClientfidelite.class
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
					PassworddeleteClientfidelite.this.dispose();
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
					PassworddeleteClientfidelite.this.dispose();

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
					PassworddeleteClientfidelite.this.dispose();
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
					PassworddeleteClientfidelite.this.dispose();
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
					PassworddeleteClientfidelite.this.dispose();
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

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblEntrerVotreMot());
			this.layeredPane.add(this.getTextField());
			this.layeredPane.add(this.getLblMotDePasse());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblAnnuler());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblAnnuler() {
		if (this.lblAnnuler == null) {
			this.lblAnnuler = new JLabel("");
			this.lblAnnuler.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblAnnuler.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblAnnuler.setIcon(new ImageIcon(
					PassworddeleteClientfidelite.class
							.getResource("/Images/actionbutons/annuler.png")));
			this.lblAnnuler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationCommerciale fenetre = new GestionOperationCommerciale();
					fenetre.setVisible(true);
					PassworddeleteClientfidelite.this.dispose();
				}
			});
			this.lblAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAnnuler.setForeground(Color.GRAY);
			this.lblAnnuler.setBounds(789, 410, 147, 70);
		}
		return this.lblAnnuler;
	}

	private JLabel getLblEntrerVotreMot() {
		if (this.lblEntrerVotreMot == null) {
			this.lblEntrerVotreMot = new JLabel(
					"Entrer votre Mot de Passe Administrateur pour confirmer et excecuter l'op\u00E9ration");
			this.lblEntrerVotreMot.setForeground(Color.GRAY);
			this.lblEntrerVotreMot.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEntrerVotreMot.setBounds(408, 369, 486, 14);
		}
		return this.lblEntrerVotreMot;
	}

	private JLabel getLblMotDePasse() {
		if (this.lblMotDePasse == null) {
			this.lblMotDePasse = new JLabel("Mot de Passe");
			this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMotDePasse.setForeground(Color.GRAY);
			this.lblMotDePasse.setBounds(370, 439, 88, 14);
		}
		return this.lblMotDePasse;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(242, 286, 486, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					PassworddeleteClientfidelite.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setIcon(new ImageIcon(
					PassworddeleteClientfidelite.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final char[] tabPassword = PassworddeleteClientfidelite.this.textField
							.getPassword();
					final String motdepasse = String.valueOf(tabPassword);

					if (motdepasse.equals(Motdepassesuppression
							.getPasswordelete())) {

						boolean etat = true;

						String message = null;

						try {

							c = Connexion.getCon();
							c.setAutoCommit(false);

							final String deletetabledelivrer = "DELETE FROM DELIVRER WHERE IDCARTEDEFIDELITE=?";

							stm = c.prepareStatement(deletetabledelivrer);

							stm.setInt(
									1,
									PassworddeleteClientfidelite.this.idcartefidelite);

							stm.executeUpdate();

							final String deletetablecarte = "DELETE FROM CARTE_DE_FIDELITE WHERE IDCARTEDEFIDELITE=?";

							stm = c.prepareStatement(deletetablecarte);

							stm.setInt(
									1,
									PassworddeleteClientfidelite.this.idcartefidelite);

							stm.executeUpdate();
							// on ne supprime pas les client de la base ils ont
							// potentillement toujours client

							c.commit();

							c.setAutoCommit(true);
							PassworddeleteClientfidelite.this.text = "Suppression Fiche Client";
							Message.setMessageaffichagefond(PassworddeleteClientfidelite.this.text);
							message = "la carte "
									+ PassworddeleteClientfidelite.this.numcarte
									+ " à été supprimée de la base";
							final SuccesOperation fenetre = new SuccesOperation(
									message,
									etat,
									PassworddeleteClientfidelite.this.text,
									PassworddeleteClientfidelite.this.messageinsertion2,
									PassworddeleteClientfidelite.this.provenance,
									PassworddeleteClientfidelite.this.idoperationtest,
									PassworddeleteClientfidelite.this.idmagasintest,null);
							fenetre.setVisible(true);
							PassworddeleteClientfidelite.this.dispose();

						} catch (final SQLException e1) {
							try {
								c.rollback();
								e1.printStackTrace();
								etat = false;
								PassworddeleteClientfidelite.this.text = "Suppression Fiche Client";
								Message.setMessageaffichagefond(PassworddeleteClientfidelite.this.text);
								message = "impossible de supprimer la carte "
										+ PassworddeleteClientfidelite.this.numcarte
										+ " de la base";
								final SuccesOperation fenetre = new SuccesOperation(
										message,
										etat,
										PassworddeleteClientfidelite.this.text,
										PassworddeleteClientfidelite.this.messageinsertion2,
										PassworddeleteClientfidelite.this.provenance,
										PassworddeleteClientfidelite.this.idoperationtest,
										PassworddeleteClientfidelite.this.idmagasintest,null);
								fenetre.setVisible(true);
								PassworddeleteClientfidelite.this.dispose();
							} catch (final SQLException e3) {
								e3.getMessage();
							}
						}

					} else {
						final ErrorPassword fenetre = new ErrorPassword(
								PassworddeleteClientfidelite.this.interfaceactuelle);
						fenetre.setVisible(true);
						PassworddeleteClientfidelite.this.interfaceactuelle
								.setVisible(false);
						PassworddeleteClientfidelite.this.interfaceactuelle
								.setEnabled(false);
					}
				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(637, 410, 142, 70);
		}
		return this.lblValider;
	}

	private JPasswordField getTextField() {
		if (this.textField == null) {
			this.textField = new JPasswordField();
			this.textField.setForeground(Color.GRAY);
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setBorder(new LineBorder(Color.GRAY));
			this.textField.setBounds(468, 436, 151, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}
}
