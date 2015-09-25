package fr.lefournildesprovinces.vues.magasins;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.SuccesMagasinOperation;
import fr.lefournildesprovinces.vues.popups.ErrorPassword;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;

public class Password extends JFrame {

	private static Connection c;
	/**
	 *
	 */
	private static final long serialVersionUID = -2834870965879093822L;
	private static PreparedStatement stm;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasintest = 0;
	private final int idoperationtest = 0;
	private final JFrame interfaceactuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLayeredPane layeredPane;
	private JLabel lblAnnuler;
	private JLabel lblEntrerVotreMot;
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblValider;
	private final String magasinselectionne;
	private final String messageinsertion2 = null;
	private final String provenance = "test";
	private final int selection;
	private final String text = "Suppression magasin";
	private JPasswordField textField;

	public Password(final int choix, final String magasinconcerne) {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();

		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.selection = choix;

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.magasinselectionne = magasinconcerne;
		this.interfaceactuelle = this;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Password.class
					.getResource("/Images/fonds/menus_magasin.png")));
			this.fond.setBounds(216, 232, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("Suppression d'un magasin");
			this.label.setForeground(Color.GRAY);
			this.label.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label.setBounds(238, 288, 147, 14);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Password.this.dispose();
				}
			});
			this.label_1.setBounds(238, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					Password.this.dispose();
				}
			});
			this.label_2.setBounds(351, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					Password.this.dispose();
				}
			});
			this.label_3.setBounds(592, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					Password.this.dispose();
				}
			});
			this.label_4.setBounds(706, 231, 114, 44);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Password.this.dispose();
				}
			});
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.label_5.setBounds(871, 231, 184, 46);
		}
		return this.label_5;
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
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblAnnuler() {
		if (this.lblAnnuler == null) {
			this.lblAnnuler = new JLabel("");
			this.lblAnnuler.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblAnnuler.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblAnnuler.setIcon(new ImageIcon(Password.class
					.getResource("/Images/actionbutons/annuler.png")));
			this.lblAnnuler.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblAnnuler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins fenetre = new GestionMagasins();
					fenetre.setVisible(true);
					Password.this.dispose();
				}
			});
			this.lblAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAnnuler.setForeground(Color.GRAY);
			this.lblAnnuler.setBounds(789, 411, 147, 70);
		}
		return this.lblAnnuler;
	}

	private JLabel getLblEntrerVotreMot() {
		if (this.lblEntrerVotreMot == null) {
			this.lblEntrerVotreMot = new JLabel(
					"Entrer votre Mot de Passe Administrateur pour confirmer et exc\u00E9cuter l'op\u00E9ration");
			this.lblEntrerVotreMot.setForeground(Color.GRAY);
			this.lblEntrerVotreMot.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEntrerVotreMot.setBounds(408, 370, 484, 14);
		}
		return this.lblEntrerVotreMot;
	}

	private JLabel getLblMotDePasse() {
		if (this.lblMotDePasse == null) {
			this.lblMotDePasse = new JLabel("Mot de Passe");
			this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMotDePasse.setForeground(Color.GRAY);
			this.lblMotDePasse.setBounds(370, 440, 88, 14);
		}
		return this.lblMotDePasse;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(Password.class
					.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, -1, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(Password.class
					.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final char[] tabPassword = Password.this.textField
							.getPassword();
					final String motdepasse = String.valueOf(tabPassword);

					if (motdepasse.equals(Motdepassesuppression
							.getPasswordelete())) {

						boolean etat = true;

						String message = null;

						try {

							c = Connexion.getCon();
							c.setAutoCommit(false);
							final String suppressionClientMagasinTableFrequenter = "DELETE FROM FREQUENTER WHERE IDMAGASIN=?";
							stm = c.prepareStatement(suppressionClientMagasinTableFrequenter);
							stm.setInt(1, Password.this.selection);
							stm.executeUpdate();

							final String suppressionClientMagasinTableParticiper = "DELETE FROM  PARTICIPER WHERE IDMAGASIN=?";
							stm = c.prepareStatement(suppressionClientMagasinTableParticiper);
							stm.setInt(1, Password.this.selection);
							stm.executeUpdate();

							final String suppressionClientMagasinTableDelivrer = "DELETE FROM DELIVRER  WHERE IDMAGASIN=?";
							stm = c.prepareStatement(suppressionClientMagasinTableDelivrer);
							stm.setInt(1, Password.this.selection);
							stm.executeUpdate();

							final String suppressionMagasin = "DELETE FROM MAGASIN WHERE MAGASIN.IDMAGASIN=?";
							stm = c.prepareStatement(suppressionMagasin);
							stm.setInt(1, Password.this.selection);
							stm.executeUpdate();

							// on ne supprime pas les client de la base ils ont
							// potentillement toujours client

							c.commit();

							c.setAutoCommit(true);
							message = "le magasin "
									+ Password.this.magasinselectionne
									+ " à été supprimé de la base";
							Message.setMessageaffichagefond(Password.this.text);
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									message, etat, Password.this.text,
									Password.this.messageinsertion2,
									Password.this.provenance,
									Password.this.idoperationtest,
									Password.this.idmagasintest);
							fenetre.setVisible(true);
							Password.this.dispose();

						} catch (final SQLException e1) {
							e1.printStackTrace();
							etat = false;
							message = "impossible de supprimer"
									+ Password.this.magasinselectionne
									+ " de la base";
							Message.setMessageaffichagefond(Password.this.text);
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									message, etat, Password.this.text,
									Password.this.messageinsertion2,
									Password.this.provenance,
									Password.this.idoperationtest,
									Password.this.idmagasintest);
							fenetre.setVisible(true);
							Password.this.dispose();
						}

					} else {
						final ErrorPassword fenetre = new ErrorPassword(
								Password.this.interfaceactuelle);
						fenetre.setVisible(true);
						Password.this.interfaceactuelle.setVisible(false);
						Password.this.interfaceactuelle.setEnabled(false);
					}
				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(637, 411, 142, 70);
		}
		return this.lblValider;
	}

	private JPasswordField getTextField() {
		if (this.textField == null) {
			this.textField = new JPasswordField();
			this.textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textField.setForeground(Color.GRAY);
			this.textField.setBorder(new LineBorder(Color.GRAY));
			this.textField.setBounds(468, 437, 151, 20);
			this.textField.setColumns(10);
		}
		return this.textField;
	}
}
