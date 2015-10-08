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
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.ErrorPassword;
import fr.lefournildesprovinces.vues.popups.SuccesOperation;

public class PasswordOperationCommerciale extends JFrame {

	private static Connection c;
	/**
	 *
	 */
	private static final long serialVersionUID = -6457511930818648661L;
	private static PreparedStatement stm;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasintest = 0;
	private final int idoperationselectionne;

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
	private final String operationselectionne;
	private String privilege;
	private final String provenance = "test";
	private String text;
	private JPasswordField textField;

	public PasswordOperationCommerciale(final int idoperation,
			final String operation) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

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
		this.operationselectionne = operation;
		this.idoperationselectionne = idoperation;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								PasswordOperationCommerciale.class
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

				this.fond
						.setIcon(new ImageIcon(
								PasswordOperationCommerciale.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						PasswordOperationCommerciale.class
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
					PasswordOperationCommerciale.this.dispose();
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
					PasswordOperationCommerciale.this.dispose();
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
					PasswordOperationCommerciale.this.dispose();
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
					PasswordOperationCommerciale.this.dispose();
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
					PasswordOperationCommerciale.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(867, 232, 181, 44);
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
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblAnnuler() {
		if (this.lblAnnuler == null) {
			this.lblAnnuler = new JLabel("");
			this.lblAnnuler.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblAnnuler.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblAnnuler.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblAnnuler.setIcon(new ImageIcon(
					PasswordOperationCommerciale.class
							.getResource("/Images/actionbutons/annuler.png")));
			this.lblAnnuler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationCommerciale fenetre = new GestionOperationCommerciale();
					fenetre.setVisible(true);
					PasswordOperationCommerciale.this.dispose();
				}
			});
			this.lblAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblAnnuler.setForeground(Color.WHITE);
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
			this.lblNewLabel = new JLabel(
					"Suppression d'une Opération Commerciale");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(242, 286, 493, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					PasswordOperationCommerciale.class
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
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setIcon(new ImageIcon(
					PasswordOperationCommerciale.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final char[] tabPassword = PasswordOperationCommerciale.this.textField
							.getPassword();
					final String motdepasse = String.valueOf(tabPassword);

					if (motdepasse.equals(Motdepassesuppression
							.getPasswordelete())) {

						boolean etat = true;

						String message = null;

						try {

							c = Connexion.getCon();
							c.setAutoCommit(false);
							final String suppressionClientMagasinTableFrequenter = "DELETE FROM PARTICIPER WHERE IDOPERATIONCOMMERCIALE=?";
							stm = c.prepareStatement(suppressionClientMagasinTableFrequenter);
							stm.setInt(
									1,
									PasswordOperationCommerciale.this.idoperationselectionne);
							stm.executeUpdate();

							final String suppressionClientMagasinTableParticiper = "DELETE FROM  OPERATION_COMMERCIALE WHERE IDOPERATIONCOMMERCIALE=?";
							stm = c.prepareStatement(suppressionClientMagasinTableParticiper);
							stm.setInt(
									1,
									PasswordOperationCommerciale.this.idoperationselectionne);
							stm.executeUpdate();

							// on ne supprime pas les client de la base ils ont
							// potentillement toujours client

							c.commit();

							c.setAutoCommit(true);
							PasswordOperationCommerciale.this.text = "Suppression d'une Opération Commerciale";
							Message.setMessageaffichagefond(PasswordOperationCommerciale.this.text);
							message = "l'opération "
									+ PasswordOperationCommerciale.this.operationselectionne
									+ " à été supprimée de la base";
							final SuccesOperation fenetre = new SuccesOperation(
									message,
									etat,
									PasswordOperationCommerciale.this.text,
									PasswordOperationCommerciale.this.messageinsertion2,
									PasswordOperationCommerciale.this.provenance,
									PasswordOperationCommerciale.this.idoperationtest,
									PasswordOperationCommerciale.this.idmagasintest);
							fenetre.setVisible(true);
							PasswordOperationCommerciale.this.dispose();

						} catch (final SQLException e1) {
							e1.printStackTrace();
							etat = false;
							PasswordOperationCommerciale.this.text = "Suppression d'une Opération Commerciale";
							Message.setMessageaffichagefond(PasswordOperationCommerciale.this.text);
							message = "impossible de supprimer"
									+ PasswordOperationCommerciale.this.operationselectionne
									+ " de la base";
							final SuccesOperation fenetre = new SuccesOperation(
									message,
									etat,
									PasswordOperationCommerciale.this.text,
									PasswordOperationCommerciale.this.messageinsertion2,
									PasswordOperationCommerciale.this.provenance,
									PasswordOperationCommerciale.this.idoperationtest,
									PasswordOperationCommerciale.this.idmagasintest);
							fenetre.setVisible(true);
							PasswordOperationCommerciale.this.dispose();
						}

					} else {
						final ErrorPassword fenetre = new ErrorPassword(
								PasswordOperationCommerciale.this.interfaceactuelle);
						fenetre.setVisible(true);
						PasswordOperationCommerciale.this.interfaceactuelle
								.setVisible(false);
						PasswordOperationCommerciale.this.interfaceactuelle
								.setEnabled(false);
					}
				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.WHITE);
			this.lblValider.setBounds(637, 410, 142, 70);
		}
		return this.lblValider;
	}

	private JPasswordField getTextField() {
		if (this.textField == null) {
			this.textField = new JPasswordField();
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setBorder(new LineBorder(Color.GRAY));
			this.textField.setBounds(468, 436, 151, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}
}
