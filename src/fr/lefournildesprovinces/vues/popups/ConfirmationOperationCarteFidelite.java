package fr.lefournildesprovinces.vues.popups;

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
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Clientcartedefidelite;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.vues.fidelite.MajFicheClientCarteFidelite;
import fr.lefournildesprovinces.vues.fidelite.PassworddeleteClientfidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.opcom.SuccesOperationClientCarteFidelite;

public class ConfirmationOperationCarteFidelite extends JFrame {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = 6711187180819443869L;
	private final String choixmenuprecedent;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasin = 0;
	private final int idoperation = 0;
	private final JFrame interfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblMessage;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewMessagenumeroClient;
	private JLabel lblNon;
	private JLabel lblOui;
	private final String messageinsertion2 = null;
	private final String numeroCarteFideliteClient;
	private String privilege;
	private final String provenance = "test";
	private String text = null;

	public ConfirmationOperationCarteFidelite(final JFrame interfaceActuelle, final String numeroCarteFidelite,
			final String choix, final String text) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				String civ = null;
				String NomCli = null;
				String PrenomCli = null;
				final Vector<Clientcartedefidelite> infosclient = Select
						.infosclientcartefidelite(ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient);
				for (int i = 0; i < infosclient.size(); i++) {
					civ = infosclient.get(i).getCiviliteIndividu();
					NomCli = infosclient.get(i).getNomIndividu();
					PrenomCli = infosclient.get(i).getPrenomIndividu();
				}

				switch (ConfirmationOperationCarteFidelite.this.choixmenuprecedent) {
				case "DMenu > Gestion Carte de Fidélité > Désincription Pub":
					ConfirmationOperationCarteFidelite.this.lblMessage.setText("Souhaitez-vous désinscrire " + civ + " "
							+ NomCli + " " + PrenomCli + " de la newsletter ?");
					ConfirmationOperationCarteFidelite.this.lblNewLabel.setText(text);
					break;
				case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
					ConfirmationOperationCarteFidelite.this.lblMessage
							.setText("Souhaitez-vous supprimer la fiche " + civ + " " + NomCli + " " + PrenomCli + "?");
					ConfirmationOperationCarteFidelite.this.lblNewLabel.setText(text);
					break;
				case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
					ConfirmationOperationCarteFidelite.this.lblMessage.setText(
							"Souhaitez-vous mettre a jour la fiche " + civ + " " + NomCli + " " + PrenomCli + "?");
					ConfirmationOperationCarteFidelite.this.lblNewLabel.setText(text);
					break;
				}

				ConfirmationOperationCarteFidelite.this.lblNewMessagenumeroClient
						.setText("Client Identifié par le numéro de carte de fidelité n° "
								+ ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient);

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
		this.numeroCarteFideliteClient = numeroCarteFidelite;
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.interfacePrecedente = interfaceActuelle;
		this.choixmenuprecedent = choix;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(
						ConfirmationOperationCarteFidelite.class.getResource("/Images/fonds/menus-grises-fidelite.png")));
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
				this.fond.setIcon(new ImageIcon(
						ConfirmationOperationCarteFidelite.class.getResource("/Images/fonds/menus-grises-fidelite.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						ConfirmationOperationCarteFidelite.class.getResource("/Images/fonds/menus_fidelite.png")));
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
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(593, 231, 114, 44);
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
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(707, 231, 114, 44);
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
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(875, 232, 170, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMessage());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLblNewMessagenumeroClient());
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

	private JLabel getLblMessage() {
		if (this.lblMessage == null) {
			this.lblMessage = new JLabel("");
			this.lblMessage.setForeground(Color.GRAY);
			this.lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblMessage.setBounds(242, 371, 803, 14);
		}
		return this.lblMessage;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 287, 525, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(
					new ImageIcon(ConfirmationOperationCarteFidelite.class.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewMessagenumeroClient() {
		if (this.lblNewMessagenumeroClient == null) {
			this.lblNewMessagenumeroClient = new JLabel("");
			this.lblNewMessagenumeroClient.setForeground(Color.GRAY);
			this.lblNewMessagenumeroClient.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewMessagenumeroClient.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewMessagenumeroClient.setBounds(364, 396, 553, 14);
		}
		return this.lblNewMessagenumeroClient;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setIcon(
					new ImageIcon(ConfirmationOperationCarteFidelite.class.getResource("/Images/actionbutons/annuler.png")));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					ConfirmationOperationCarteFidelite.this.interfacePrecedente.setVisible(true);
					ConfirmationOperationCarteFidelite.this.interfacePrecedente.setEnabled(true);
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(534, 440, 99, 76);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(
					new ImageIcon(ConfirmationOperationCarteFidelite.class.getResource("/Images/actionbutons/valider.png")));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					ConfirmationOperationCarteFidelite.this.interfacePrecedente.dispose();
					boolean etat = true;
					String message = null;
					int idcarte = 0;
					switch (ConfirmationOperationCarteFidelite.this.choixmenuprecedent) {
					case "Menu > Gestion Carte de Fidélité > Désincription Pub":

						ConfirmationOperationCarteFidelite.this.text = "Désincription Pub";
						try {
							c = Connexion.getCon();
							final String sql = "SELECT IDCARTEDEFIDELITE FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";
							preStm = c.prepareStatement(sql);
							preStm.setString(1, ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient);
							rs = preStm.executeQuery();
							while (rs.next()) {
								idcarte = rs.getInt(1);
							}
							System.out.print(idcarte);
							rs.close();
							preStm.close();
						} catch (final SQLException e1) {
							e1.printStackTrace();
						}
						if (idcarte == 0) {
							etat = false;
							message = "La carte n° " + ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient
									+ " n'existe pas";
							Message.setMessageaffichagefond(ConfirmationOperationCarteFidelite.this.text);
							final SuccesOperation fenetre1 = new SuccesOperation(message, etat,
									ConfirmationOperationCarteFidelite.this.text,
									ConfirmationOperationCarteFidelite.this.messageinsertion2,
									ConfirmationOperationCarteFidelite.this.provenance,
									ConfirmationOperationCarteFidelite.this.idoperation,
									ConfirmationOperationCarteFidelite.this.idmagasin,null);
							fenetre1.setVisible(true);
							ConfirmationOperationCarteFidelite.this.dispose();
						} else {
							try {
								c = Connexion.getCon();
								final String deletetabledelivrer = "UPDATE CLIENT INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT SET ABONNEMENTNEWSLETTERCLIENT='DéSINSCRIT' WHERE IDCARTEDEFIDELITE=?";
								preStm = c.prepareStatement(deletetabledelivrer);
								preStm.setInt(1, idcarte);
								preStm.executeUpdate();
							} catch (final SQLException e1) {
								e1.printStackTrace();
							}
							final SuccesOperationClientCarteFidelite fenetre2 = new SuccesOperationClientCarteFidelite(
									ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient,
									ConfirmationOperationCarteFidelite.this.choixmenuprecedent,
									ConfirmationOperationCarteFidelite.this.text);
							fenetre2.setVisible(true);
						}
						break;
					case "Menu > Gestion Carte de Fidélité > Suppression Fiche Client":
						ConfirmationOperationCarteFidelite.this.text = "Suppression Fiche Client";
						try {
							c = Connexion.getCon();
							final String sql = "SELECT IDCARTEDEFIDELITE FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";
							preStm = c.prepareStatement(sql);
							preStm.setString(1, ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient);
							rs = preStm.executeQuery();
							while (rs.next()) {
								idcarte = rs.getInt(1);
							}
							System.out.print(idcarte);
							rs.close();
							preStm.close();
						} catch (final SQLException e1) {
							e1.printStackTrace();
						}
						final PassworddeleteClientfidelite fenetre2 = new PassworddeleteClientfidelite(idcarte,
								ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient,
								ConfirmationOperationCarteFidelite.this.text);
						fenetre2.setVisible(true);
						ConfirmationOperationCarteFidelite.this.dispose();
						break;
					case "Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client":
						ConfirmationOperationCarteFidelite.this.text = "Mise à Jour Fiche Client";
						try {
							c = Connexion.getCon();
							final String sql = "SELECT IDCARTEDEFIDELITE FROM CARTE_DE_FIDELITE WHERE NUMEROCARTEDEFIDELITE=?";
							preStm = c.prepareStatement(sql);
							preStm.setString(1, ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient);
							rs = preStm.executeQuery();
							while (rs.next()) {
								idcarte = rs.getInt(1);
							}
							System.out.print(idcarte);
							rs.close();
							preStm.close();
						} catch (final SQLException e1) {
							e1.printStackTrace();
						}
						if (idcarte == 0) {

							etat = false;
							message = "La carte n° " + ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient
									+ " n'existe pas";
							final SuccesOperation fenetre = new SuccesOperation(message, etat,
									ConfirmationOperationCarteFidelite.this.text,
									ConfirmationOperationCarteFidelite.this.messageinsertion2,
									ConfirmationOperationCarteFidelite.this.provenance,
									ConfirmationOperationCarteFidelite.this.idoperation,
									ConfirmationOperationCarteFidelite.this.idmagasin,null);
							fenetre.setVisible(true);
							ConfirmationOperationCarteFidelite.this.dispose();
						}

						else {
							final int idop = 0;
							final int idmag = 0;
							final MajFicheClientCarteFidelite fenetre3 = new MajFicheClientCarteFidelite(
									ConfirmationOperationCarteFidelite.this.numeroCarteFideliteClient,
									ConfirmationOperationCarteFidelite.this.choixmenuprecedent, idop, idmag);
							fenetre3.setVisible(true);
						}
						break;
					}
					ConfirmationOperationCarteFidelite.this.dispose();
				}
			});
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setBounds(668, 440, 99, 76);
		}
		return this.lblOui;
	}
}
