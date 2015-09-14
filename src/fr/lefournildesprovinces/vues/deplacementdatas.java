package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.ressources.models.infostemporaire;
import fr.lefournildesprovinces.vues.fidelite.ConfirmationInsertionClientFidelite;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class deplacementdatas extends JFrame {

	private static Connection c;
	private static ResultSet rs;
	/**
	 *
	 */
	private static final long serialVersionUID = 2168098610236879418L;
	private JLabel lblCesDonnesSeront;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblSouhaitezVousContinuer;
	private JLayeredPane layeredPane;
	private Vector<infostemporaire> requete;
	private final Boolean privilegeClient;
	private final JFrame InterfacePrecedente;
	private final JPanel contentPane;
	private final String adresseClient;
	private final String ageClient;
	private final String choixetprovenance;
	private final String civiliteClient;
	private final String codePostalClient;
	private final String dateNaissanceClient;
	private final String emailClient;
	private final String magasinClient;
	private final String newsletterClient;
	private final String nomClient;
	private final String numcarte;
	private final String numerofixe;
	private final String numeroportable;
	private final String prenomClient;
	private final String villeClient;
	private final int compteur;
	private final int idmagasinClient;
	private final int idmagasinclientparticipant;
	private final int idoperationclientparticipant;
	private final int idvilleClient;
	private int numeroclient;
	private static PreparedStatement stm;

	public deplacementdatas(final JFrame interfaceActuelle,
			final String numerocarte, final String magasin,
			final int idmagasin, final String civilite, final String nom,
			final String prenom, final String adresse, final int idville,
			final String ville, final String CodePostal,
			final String dateComplete, final String email,
			final String newsletter, final String numfixe, final String numpor,
			final String age, final Boolean privilege, final int idoperationcommercialeparticipation,
			final int idmagasinparticipation, final String choixmenuprecedent,
			final int compteur2) {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 619, 210);
		this.contentPane = new JPanel();

		this.contentPane.setBorder(new LineBorder(Color.GRAY));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.InterfacePrecedente = interfaceActuelle;
		this.numcarte = numerocarte;
		this.idmagasinClient = idmagasin;
		this.magasinClient = magasin;
		this.civiliteClient = civilite;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.adresseClient = adresse;
		this.idvilleClient = idville;
		this.villeClient = ville;
		this.codePostalClient = CodePostal;
		this.dateNaissanceClient = dateComplete;
		this.emailClient = email;
		this.newsletterClient = newsletter;
		this.numerofixe = numfixe;
		this.numeroportable = numpor;
		this.ageClient = age;
		this.privilegeClient=privilege;
		this.idoperationclientparticipant = idoperationcommercialeparticipation;
		this.idmagasinclientparticipant = idmagasinparticipation;
		this.choixetprovenance = choixmenuprecedent;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.compteur = compteur2;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblCesDonnesSeront());
			this.layeredPane.add(this.getLblSouhaitezVousContinuer());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblCesDonnesSeront() {
		if (this.lblCesDonnesSeront == null) {
			this.lblCesDonnesSeront = new JLabel(
					"ces données seront donc conservées et jointe à la nouvelle carte de fidelité");
			this.lblCesDonnesSeront.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCesDonnesSeront.setForeground(Color.GRAY);
			this.lblCesDonnesSeront.setBounds(107, 93, 439, 14);
		}
		return this.lblCesDonnesSeront;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Ce client à déja participé à des opérations commerciales");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(161, 68, 335, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(deplacementdatas.class
					.getResource("/Images/avertissements.png")));
			this.lblNewLabel_1.setBounds(0, 0, 628, 215);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setIcon(new ImageIcon(deplacementdatas.class
					.getResource("/Images/non.png")));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre2 = new MenuPrincipal();
					fenetre2.setVisible(true);
					deplacementdatas.this.dispose();
				}
			});
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNon.setForeground(Color.GRAY);
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setBounds(339, 134, 48, 51);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(new ImageIcon(deplacementdatas.class
					.getResource("/Images/oui.png")));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					try {
						c = Connexion.getCon();
						c.setAutoCommit(false);

						final String idclient = "SELECT IDCLIENT FROM CLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND AGECLIENT=?";
						stm = c.prepareStatement(idclient);
						stm.setString(1, deplacementdatas.this.nomClient);
						stm.setString(2, deplacementdatas.this.prenomClient);
						stm.setString(3, deplacementdatas.this.ageClient);
						rs = stm.executeQuery();

						while (rs.next())

						{
							deplacementdatas.this.numeroclient = rs.getInt(1);
						}

						stm.close();
						rs.close();

						deplacementdatas.this.requete = new Vector<infostemporaire>();

						final String copyinfos = "SELECT IDMAGASIN, IDOPERATIONCOMMERCIALE FROM PARTICIPER WHERE IDCLIENT=?";
						stm = c.prepareStatement(copyinfos);
						stm.setInt(1, deplacementdatas.this.numeroclient);

						rs = stm.executeQuery();

						System.out.print("&&&&&&&&"
								+ deplacementdatas.this.numeroclient
								+ "&&&&&&&&&");

						infostemporaire liste;
						while (rs.next())

						{
							liste = new infostemporaire();
							liste.setIdMagasinTemporaire(rs.getInt(1));
							liste.setIdoperationTemporaire(rs.getInt(2));
							deplacementdatas.this.requete.add(liste);
						}

						stm.close();
						rs.close();

						c.setAutoCommit(false);
						System.out.print("====="
								+ deplacementdatas.this.requete.size()
								+ "=======");

						final String suppressionClientMagasinTableParticiper = "DELETE FROM  PARTICIPER WHERE IDCLIENT=?";
						stm = c.prepareStatement(suppressionClientMagasinTableParticiper);
						stm.setInt(1, deplacementdatas.this.numeroclient);
						stm.executeUpdate();

						final String suppressionClientMagasinfrequenter = "DELETE FROM  FREQUENTER WHERE IDCLIENT=?";
						stm = c.prepareStatement(suppressionClientMagasinfrequenter);
						stm.setInt(1, deplacementdatas.this.numeroclient);
						stm.executeUpdate();

						final String suppressionClientMagasinClient = "DELETE FROM  CLIENT WHERE IDCLIENT=?";
						stm = c.prepareStatement(suppressionClientMagasinClient);
						stm.setInt(1, deplacementdatas.this.numeroclient);
						stm.executeUpdate();

						c.commit();
						c.setAutoCommit(true);

					} catch (final SQLException e3) {
						e3.getMessage();
					}

					final ConfirmationInsertionClientFidelite fenetre = new ConfirmationInsertionClientFidelite(
							deplacementdatas.this.InterfacePrecedente,
							deplacementdatas.this.numcarte,
							deplacementdatas.this.magasinClient,
							deplacementdatas.this.idmagasinClient,
							deplacementdatas.this.civiliteClient,
							deplacementdatas.this.nomClient,
							deplacementdatas.this.prenomClient,
							deplacementdatas.this.adresseClient,
							deplacementdatas.this.idvilleClient,
							deplacementdatas.this.villeClient,
							deplacementdatas.this.codePostalClient,
							deplacementdatas.this.dateNaissanceClient,
							deplacementdatas.this.emailClient,
							deplacementdatas.this.newsletterClient,
							deplacementdatas.this.numerofixe,
							deplacementdatas.this.numeroportable,
							deplacementdatas.this.ageClient,
							deplacementdatas.this.privilegeClient,
							deplacementdatas.this.idoperationclientparticipant,
							deplacementdatas.this.idmagasinclientparticipant,
							deplacementdatas.this.choixetprovenance,
							deplacementdatas.this.compteur,
							deplacementdatas.this.requete);
					fenetre.setVisible(true);
					deplacementdatas.this.dispose();

				}
			});
			this.lblOui.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.setForeground(Color.GRAY);
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setBounds(254, 143, 57, 33);
		}
		return this.lblOui;
	}

	private JLabel getLblSouhaitezVousContinuer() {
		if (this.lblSouhaitezVousContinuer == null) {
			this.lblSouhaitezVousContinuer = new JLabel(
					"Souhaitez vous continuer ?");
			this.lblSouhaitezVousContinuer.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblSouhaitezVousContinuer.setForeground(Color.GRAY);
			this.lblSouhaitezVousContinuer.setBounds(244, 118, 167, 14);
		}
		return this.lblSouhaitezVousContinuer;
	}
}
