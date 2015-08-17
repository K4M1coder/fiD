package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.ClientOperationCommerciale;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class ConfirmationSuppressionClientOC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 249181412573311625L;
	private String adresse;
	private String civilite;
	private final JPanel contentPane;
	private String CP;
	private final String datenaissance;
	private final String datenaissanceclientrequete;
	private JLabel fond;
	private int idclientselcetionne;
	private final JFrame interfaceprecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblAdresse;
	private JLabel lblDateNaissance;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNomClient;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblSuppression;
	private final String nomclient;
	private final String prenomclient;
	private String privilege;
	private String ville;

	public ConfirmationSuppressionClientOC(final String nom,
			final String prenom, final String date,
			final JFrame interfaceactuelle, final String daterequete) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

				final Vector<ClientOperationCommerciale> infosclient = Select
						.infosclient(
								ConfirmationSuppressionClientOC.this.nomclient,
								ConfirmationSuppressionClientOC.this.prenomclient,
								ConfirmationSuppressionClientOC.this.datenaissanceclientrequete);

				for (int i = 0; i < infosclient.size(); i++) {
					ConfirmationSuppressionClientOC.this.idclientselcetionne = infosclient
							.get(i).getIdclient();
					ConfirmationSuppressionClientOC.this.civilite = infosclient
							.get(i).getCiviliteIndividu().toString();
					ConfirmationSuppressionClientOC.this.adresse = infosclient
							.get(i).getAdresseIndividu().toString();
					ConfirmationSuppressionClientOC.this.CP = infosclient
							.get(i).getCodePostalIndividu().toString();
					ConfirmationSuppressionClientOC.this.ville = infosclient
							.get(i).getVilleIndividu().toString();
				}

				ConfirmationSuppressionClientOC.this.lblNewLabel
						.setText("Etes-vous sûr de vouloir supprimer la fiche Client n° "
								+ ConfirmationSuppressionClientOC.this.idclientselcetionne
								+ "?");
				ConfirmationSuppressionClientOC.this.lblNewLabel_1
						.setText(ConfirmationSuppressionClientOC.this.civilite
								+ " "
								+ ConfirmationSuppressionClientOC.this.nomclient
								+ " "
								+ ConfirmationSuppressionClientOC.this.prenomclient);
				ConfirmationSuppressionClientOC.this.lblNewLabel_3
						.setText(ConfirmationSuppressionClientOC.this.datenaissance);
				ConfirmationSuppressionClientOC.this.lblNewLabel_2
						.setText(ConfirmationSuppressionClientOC.this.adresse);
				ConfirmationSuppressionClientOC.this.lblNewLabel_4
						.setText(ConfirmationSuppressionClientOC.this.CP + " "
								+ ConfirmationSuppressionClientOC.this.ville);

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
		this.interfaceprecedente = interfaceactuelle;
		this.nomclient = nom;
		this.prenomclient = prenom;
		this.datenaissance = date;
		this.datenaissanceclientrequete = daterequete;
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								ConfirmationSuppressionClientOC.class
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
								ConfirmationSuppressionClientOC.class
										.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						ConfirmationSuppressionClientOC.class
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
					ConfirmationSuppressionClientOC.this.dispose();
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
					ConfirmationSuppressionClientOC.this.dispose();
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
					ConfirmationSuppressionClientOC.this.dispose();
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
					ConfirmationSuppressionClientOC.this.dispose();
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
					ConfirmationSuppressionClientOC.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(869, 232, 177, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNomClient());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblDateNaissance());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getLblNewLabel_4());
			this.layeredPane.add(this.getLblNewLabel_5());
			this.layeredPane.add(this.getLblSuppression());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNewLabel_6());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_7());
		}
		return this.layeredPane;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse :");
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setBounds(476, 429, 65, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblDateNaissance() {
		if (this.lblDateNaissance == null) {
			this.lblDateNaissance = new JLabel("Date Naissance :");
			this.lblDateNaissance.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblDateNaissance.setForeground(Color.GRAY);
			this.lblDateNaissance.setBounds(436, 404, 105, 14);
		}
		return this.lblDateNaissance;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.RED);
			this.lblNewLabel.setBounds(428, 319, 428, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(538, 379, 220, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setBounds(538, 429, 220, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_3.setForeground(Color.GRAY);
			this.lblNewLabel_3.setBounds(538, 404, 220, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_4.setForeground(Color.GRAY);
			this.lblNewLabel_4.setBounds(538, 450, 220, 14);
		}
		return this.lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (this.lblNewLabel_5 == null) {
			this.lblNewLabel_5 = new JLabel(
					"Attention cela supprimera l'ensemble des donn\u00E9es associ\u00E9es au client");
			this.lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_5.setForeground(Color.RED);
			this.lblNewLabel_5.setBounds(451, 344, 417, 14);
		}
		return this.lblNewLabel_5;
	}

	private JLabel getLblNewLabel_6() {
		if (this.lblNewLabel_6 == null) {
			this.lblNewLabel_6 = new JLabel("Supprimer un bulletin");
			this.lblNewLabel_6.setForeground(Color.GRAY);
			this.lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_6.setBounds(242, 286, 490, 14);
		}
		return this.lblNewLabel_6;
	}

	private JLabel getLblNewLabel_7() {
		if (this.lblNewLabel_7 == null) {
			this.lblNewLabel_7 = new JLabel("");
			this.lblNewLabel_7.setIcon(new ImageIcon(
					ConfirmationSuppressionClientOC.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_7.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_7;
	}

	private JLabel getLblNomClient() {
		if (this.lblNomClient == null) {
			this.lblNomClient = new JLabel("Nom Client :");
			this.lblNomClient.setForeground(Color.GRAY);
			this.lblNomClient.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNomClient.setBounds(462, 379, 79, 14);
		}
		return this.lblNomClient;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setIcon(new ImageIcon(
					ConfirmationSuppressionClientOC.class
							.getResource("/Images/annuler.png")));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					ConfirmationSuppressionClientOC.this.dispose();
					ConfirmationSuppressionClientOC.this.interfaceprecedente
							.setVisible(true);
					ConfirmationSuppressionClientOC.this.interfaceprecedente
							.setEnabled(true);

				}
			});
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(538, 503, 99, 52);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.setIcon(new ImageIcon(
					ConfirmationSuppressionClientOC.class
							.getResource("/Images/valider.png")));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final String nomcomplet = ConfirmationSuppressionClientOC.this.civilite
							+ " "
							+ ConfirmationSuppressionClientOC.this.nomclient
							+ " "
							+ ConfirmationSuppressionClientOC.this.prenomclient;
					final PasswordClientOC fenetre = new PasswordClientOC(
							ConfirmationSuppressionClientOC.this.idclientselcetionne,
							nomcomplet);
					fenetre.setVisible(true);
					ConfirmationSuppressionClientOC.this.dispose();

				}
			});
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setBounds(676, 503, 99, 52);
		}
		return this.lblOui;
	}

	private JLabel getLblSuppression() {
		if (this.lblSuppression == null) {
			this.lblSuppression = new JLabel("Confirmer la suppression ?");
			this.lblSuppression.setForeground(Color.GRAY);
			this.lblSuppression.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblSuppression.setBounds(339, 523, 162, 14);
		}
		return this.lblSuppression;
	}
}