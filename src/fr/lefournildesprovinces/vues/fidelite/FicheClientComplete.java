package fr.lefournildesprovinces.vues.fidelite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import fr.lefournildesprovinces.controler.Control;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.models.infosparticipation;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;
import fr.lefournildesprovinces.vues.popups.ConfirmationOperationCarteFidelite;
import fr.lefournildesprovinces.vues.popups.MessageExport;

public class FicheClientComplete extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 2754566991054388046L;
	private JLabel label_Supprimer;
	private String adresseclientcarte;
	private String adressemailclientcarte;
	private String adressemailcontact;
	private String ageclientcarte;
	private String choixformat;
	private String codepostalclientcarte;
	private final JPanel contentPane;
	private String datenaisanceclient;
	private String desktopPath;
	private boolean etat;
	private JLabel fond;
	private final int indentifiantclient;
	private final JFrame interfaceActuelle;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_7_2;
	private JLabel label_8;
	private JLabel label_9;
	private JLayeredPane layeredPane;
	private JLabel lblAdresse;
	private JLabel lblAge;
	private JLabel lblCodePostal;
	private JLabel lblDateDeNaisance;
	private JLabel lblEmail;
	private JLabel lblFicheClientP;
	private JLabel lblLuiEcrire;
	private JLabel lblMagasinDeRfrence;
	private JLabel lblMobile;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblVip;
	private JLabel lblNewsletter;
	private JLabel lblParticipationOprationCommerciale;
	private JLabel lblPrint;
	private JLabel lblRetour;
	private JLabel lblTlphone;
	private JLabel lblVille;
	private String magasinreferenceclientcarte;
	private String Message;
	private String newsletterclientcarte;
	private String nomclientcarte;
	private String numerocarteclientfidelite;
	private JPanel panel;
	private JPanel panel_1;
	private String privilege;
	private JScrollPane scrollPane;
	private String telephoneclientcarte;
	private String telephonemobileclientcarte;
	private JTextArea textArea;
	private String villeclientcarte;
	private JLabel label_MAJ;
	protected String numCli;

	public FicheClientComplete(final int idclient) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

				final Vector<ResultatRecherche> resultatsfiche = new Vector<ResultatRecherche>(
						Select.fichecompleteporteurcarte(FicheClientComplete.this.indentifiantclient));

				for (int i = 0; i < resultatsfiche.size(); i++) {
					FicheClientComplete.this.numCli = resultatsfiche.get(i).getNumerocarte();
					FicheClientComplete.this.lblNewLabel.setText("N° de client : " + numCli);
					FicheClientComplete.this.label_10.setText(resultatsfiche.get(i).getNommagasin());
					FicheClientComplete.this.label_2.setText(resultatsfiche.get(i).getCiviliteIndividu());
					FicheClientComplete.this.lblNewLabel_3.setText(resultatsfiche.get(i).getPrenomIndividu());
					FicheClientComplete.this.lblNewLabel_4.setText(resultatsfiche.get(i).getNomIndividu());
					FicheClientComplete.this.label_3.setText(resultatsfiche.get(i).getAdresseIndividu());
					FicheClientComplete.this.label_4.setText(resultatsfiche.get(i).getVilleIndividu());
					FicheClientComplete.this.label_8.setText(resultatsfiche.get(i).getCodePostalIndividu());
					FicheClientComplete.this.label_5.setText(resultatsfiche.get(i).getTelephonefixe());
					FicheClientComplete.this.label_9.setText(resultatsfiche.get(i).getTelephonemobile());
					FicheClientComplete.this.label_6.setText(resultatsfiche.get(i).getEmail());
					FicheClientComplete.this.label_7.setText(resultatsfiche.get(i).getNewsletterIndividu());
					FicheClientComplete.this.label_7_2.setText(resultatsfiche.get(i).getVIP());
					FicheClientComplete.this.label_11.setText(resultatsfiche.get(i).getDateNaissanceIndividu());
					FicheClientComplete.this.lblNewLabel_2.setText(resultatsfiche.get(i).getAge() + " ans");
					FicheClientComplete.this.adressemailcontact = resultatsfiche.get(i).getEmail();
					if (FicheClientComplete.this.adressemailcontact != null) {
						FicheClientComplete.this.lblLuiEcrire.setVisible(true);
					}
					if (FicheClientComplete.this.label_7_2.getText().equals("0")) {
						FicheClientComplete.this.lblNewLabel_1.setIcon(
								new ImageIcon(FicheClientComplete.class.getResource("/Images/cartesfid/carte-vierge.png")));
					} else {
						FicheClientComplete.this.lblNewLabel_1.setIcon(
								new ImageIcon(FicheClientComplete.class.getResource("/Images/cartesfid/carte-vierge-vip2.png")));
					}
				}

				final Vector<infosparticipation> resultatsficheparticipation = new Vector<infosparticipation>(
						Select.infospartipationjeux(FicheClientComplete.this.indentifiantclient));

				for (int i = 0; i < resultatsficheparticipation.size(); i++) {

					FicheClientComplete.this.textArea
							.append(resultatsficheparticipation.get(i).getLibelleoperationcommerciale());
					FicheClientComplete.this.textArea.append("\t");
					FicheClientComplete.this.textArea.append(resultatsficheparticipation.get(i).getNommagasin());
					FicheClientComplete.this.textArea.append("\n");
				}

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
		this.indentifiantclient = idclient;
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.interfaceActuelle = this;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();
			switch (this.privilege) {

			case "utilisateur":
				this.label_14.setVisible(false);
				this.label_14.setEnabled(false);
				this.fond.setIcon(
						new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/menus-extraction-long-extraction.png")));

				break;

			case "invite":
				this.label_14.setVisible(false);
				this.label_14.setEnabled(false);
				this.fond.setIcon(
						new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/menus-extraction-long-extraction.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Images/fonds/menus-extraction-long.png")));
				break;
			}
			this.fond.setBounds(216, 55, 850, 690);
		}
		return this.fond;
	}

	private JLabel getLabel_10() {
		if (this.label_10 == null) {
			this.label_10 = new JLabel("");
			this.label_10.setForeground(Color.GRAY);
			this.label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_10.setBounds(825, 174, 212, 14);
		}
		return this.label_10;
	}

	private JLabel getLabel_11() {
		if (this.label_11 == null) {
			this.label_11 = new JLabel("");
			this.label_11.setForeground(Color.GRAY);
			this.label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_11.setBounds(781, 199, 160, 14);
		}
		return this.label_11;
	}

	private JLabel getLabel_12() {
		if (this.label_12 == null) {
			this.label_12 = new JLabel("");
			this.label_12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					FicheClientComplete.this.dispose();
				}
			});
			this.label_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_12.setBounds(238, 55, 114, 44);
		}
		return this.label_12;
	}

	private JLabel getLabel_13() {
		if (this.label_13 == null) {
			this.label_13 = new JLabel("");
			this.label_13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					FicheClientComplete.this.dispose();
				}
			});
			this.label_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_13.setBounds(347, 55, 114, 44);
		}
		return this.label_13;
	}

	private JLabel getLabel_14() {
		if (this.label_14 == null) {
			this.label_14 = new JLabel("");
			this.label_14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					FicheClientComplete.this.dispose();
				}
			});
			this.label_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_14.setBounds(459, 55, 114, 44);
		}
		return this.label_14;
	}

	private JLabel getLabel_15() {
		if (this.label_15 == null) {
			this.label_15 = new JLabel("");
			this.label_15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					FicheClientComplete.this.dispose();
				}
			});
			this.label_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_15.setBounds(573, 55, 114, 44);
		}
		return this.label_15;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label_2.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.label_2.setForeground(Color.RED);
			this.label_2.setBounds(267, 310, 43, 14);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setForeground(Color.GRAY);
			this.label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_3.setBounds(730, 224, 307, 14);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(716, 249, 233, 14);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setBounds(743, 299, 114, 14);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("");
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setBounds(713, 324, 324, 14);
		}
		return this.label_6;
	}

	private JLabel getLabel_7() {
		if (this.label_7 == null) {
			this.label_7 = new JLabel("");
			this.label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_7.setForeground(Color.GRAY);
			this.label_7.setBounds(754, 386, 283, 14);
		}
		return this.label_7;
	}

	private JLabel getLabel_7_2() {
		if (this.label_7_2 == null) {
			this.label_7_2 = new JLabel("");
			this.label_7_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_7_2.setForeground(Color.GRAY);
			this.label_7_2.setBounds(754, 400, 283, 14);
		}
		return this.label_7_2;
	}

	private JLabel getLabel_8() {
		if (this.label_8 == null) {
			this.label_8 = new JLabel("");
			this.label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_8.setForeground(Color.GRAY);
			this.label_8.setBounds(995, 249, 43, 14);
		}
		return this.label_8;
	}

	private JLabel getLabel_9() {
		if (this.label_9 == null) {
			this.label_9 = new JLabel("");
			this.label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_9.setForeground(Color.GRAY);
			this.label_9.setBounds(922, 299, 121, 14);
		}
		return this.label_9;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getlabel_Supprimer());
			this.layeredPane.add(this.getLabel_MAJ());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getLblCodePostal());
			this.layeredPane.add(this.getLblTlphone());
			this.layeredPane.add(this.getLblMobile());
			this.layeredPane.add(this.getLblNewsletter());
			this.layeredPane.add(this.getLblVip());
			this.layeredPane.add(this.getLblEmail());
			this.layeredPane.add(this.getLblParticipationOprationCommerciale());
			this.layeredPane.add(this.getLblFicheClientP());
			this.layeredPane.add(this.getLblVille());
			this.layeredPane.add(this.getPanel());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getLabel_7());
			this.layeredPane.add(this.getLabel_7_2());
			this.layeredPane.add(this.getLabel_8());
			this.layeredPane.add(this.getLabel_9());
			this.layeredPane.add(this.getLabel_10());
			this.layeredPane.add(this.getLblNewLabel_4());
			this.layeredPane.add(this.getLblDateDeNaisance());
			this.layeredPane.add(this.getLabel_11());
			this.layeredPane.add(this.getLabel_12());
			this.layeredPane.add(this.getLabel_13());
			this.layeredPane.add(this.getLabel_14());
			this.layeredPane.add(this.getLabel_15());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getLblPrint());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblMagasinDeRfrence());
			this.layeredPane.add(this.getLblLuiEcrire());
			this.layeredPane.add(this.getPanel_1());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_5());
		}
		return this.layeredPane;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse :");
			this.lblAdresse.setForeground(new Color(139, 69, 19));
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblAdresse.setBounds(663, 224, 66, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblAge() {
		if (this.lblAge == null) {
			this.lblAge = new JLabel("Age :");
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblAge.setForeground(new Color(139, 69, 19));
			this.lblAge.setBounds(951, 199, 43, 14);
		}
		return this.lblAge;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("CP :");
			this.lblCodePostal.setForeground(new Color(139, 69, 19));
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblCodePostal.setBounds(959, 249, 35, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblDateDeNaisance() {
		if (this.lblDateDeNaisance == null) {
			this.lblDateDeNaisance = new JLabel("Date de naisance :");
			this.lblDateDeNaisance.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblDateDeNaisance.setForeground(new Color(139, 69, 19));
			this.lblDateDeNaisance.setBounds(662, 199, 121, 14);
		}
		return this.lblDateDeNaisance;
	}

	private JLabel getLblEmail() {
		if (this.lblEmail == null) {
			this.lblEmail = new JLabel("Email :");
			this.lblEmail.setForeground(new Color(139, 69, 19));
			this.lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblEmail.setBounds(663, 324, 50, 14);
		}
		return this.lblEmail;
	}

	private JLabel getLblFicheClientP() {
		if (this.lblFicheClientP == null) {
			this.lblFicheClientP = new JLabel("Fiche Client titulaire d'une carte de fid\u00E9lit\u00E9");
			this.lblFicheClientP.setForeground(Color.GRAY);
			this.lblFicheClientP.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblFicheClientP.setBounds(242, 110, 269, 14);
		}
		return this.lblFicheClientP;
	}

	private JLabel getLblLuiEcrire() {
		if (this.lblLuiEcrire == null) {
			this.lblLuiEcrire = new JLabel("");
			this.lblLuiEcrire.setIcon(new ImageIcon(FicheClientComplete.class.getResource("/Images/actionbutons/ecrire.png")));
			this.lblLuiEcrire.setVisible(false);
			this.lblLuiEcrire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblLuiEcrire.setForeground(Color.RED);
			this.lblLuiEcrire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblLuiEcrire.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					final Desktop desktop = Desktop.getDesktop();
					final String message = "mailto:" + FicheClientComplete.this.adressemailcontact
							+ "?subject=Le%20Fournil%20des%20Provinces";
					final URI uri = URI.create(message);
					try {
						desktop.mail(uri);
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
			});
			this.lblLuiEcrire.setBounds(910, 343, 120, 32);
		}
		return this.lblLuiEcrire;
	}

	private JLabel getlabel_Supprimer() {
		if (this.label_Supprimer == null) {
			this.label_Supprimer = new JLabel("");
			this.label_Supprimer.setIcon(new ImageIcon(
					FicheClientComplete.class.getResource("/Images/menubutons/bouton-fidelite-supression.png")));
			this.label_Supprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_Supprimer.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_Supprimer.setForeground(Color.GRAY);
			this.label_Supprimer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					Control.delCard(interfaceActuelle, numCli);
				}
			});
			this.label_Supprimer.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_Supprimer.setBounds(428, 501, 145, 225);
		}
		return this.label_Supprimer;
	}

	private JLabel getLabel_MAJ() {
		if (this.label_MAJ == null) {
			this.label_MAJ = new JLabel("");
			this.label_MAJ.setIcon(new ImageIcon(
					FicheClientComplete.class.getResource("/Images/menubutons/bouton-fidelite-mise-jour.png")));
			this.label_MAJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_MAJ.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_MAJ.setForeground(Color.GRAY);
			this.label_MAJ.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final ConfirmationOperationCarteFidelite fenetre3 = new ConfirmationOperationCarteFidelite(
							FicheClientComplete.this.interfaceActuelle, FicheClientComplete.this.numCli,
							"Menu > Gestion Carte de Fidélité > Mise à Jour Fiche Client", "Mise à Jour Fiche Client");
					fenetre3.setVisible(true);
//					FicheClientComplete.this.interfacePrecedente.dispose();
					FicheClientComplete.this.dispose();
				}
			});
			this.label_MAJ.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_MAJ.setBounds(273, 501, 145, 225);
		}
		return this.label_MAJ;
	}

	private JLabel getLblMagasinDeRfrence() {
		if (this.lblMagasinDeRfrence == null) {
			this.lblMagasinDeRfrence = new JLabel("Magasin de r\u00E9f\u00E9rence  :");
			this.lblMagasinDeRfrence.setBounds(663, 174, 160, 14);
			this.lblMagasinDeRfrence.setForeground(new Color(139, 69, 19));
			this.lblMagasinDeRfrence.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return this.lblMagasinDeRfrence;
	}

	private JLabel getLblMobile() {
		if (this.lblMobile == null) {
			this.lblMobile = new JLabel("Mobile :");
			this.lblMobile.setForeground(new Color(139, 69, 19));
			this.lblMobile.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblMobile.setBounds(862, 299, 57, 14);
		}
		return this.lblMobile;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setForeground(Color.RED);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(267, 476, 187, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			// String cardpath="/Images/carte-vierge-vip2.png";
			// System.out.println("client vip :
			// "+FicheClientComplete.this.label_7_2.getText());
			// if (FicheClientComplete.this.label_7_2.getText().equals("0")){
			// cardpath="/Images/carte-vierge.png";
			// }
			// this.lblNewLabel_1.setIcon(new
			// ImageIcon(FicheClientComplete.class.getResource("/Images/carte-vierge.png")));
			this.lblNewLabel_1.setBounds(242, 280, 360, 237);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(995, 199, 43, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setForeground(Color.RED);
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblNewLabel_3.setBounds(320, 335, 134, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setForeground(Color.RED);
			this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.lblNewLabel_4.setBounds(320, 310, 134, 14);
		}
		return this.lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (this.lblNewLabel_5 == null) {
			this.lblNewLabel_5 = new JLabel("");
			this.lblNewLabel_5
					.setIcon(new ImageIcon(FicheClientComplete.class.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_5.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_5;
	}

	private JLabel getLblNewsletter() {
		if (this.lblNewsletter == null) {
			this.lblNewsletter = new JLabel("Newsletter :");
			this.lblNewsletter.setForeground(new Color(139, 69, 19));
			this.lblNewsletter.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblNewsletter.setBounds(663, 386, 81, 14);
		}
		return this.lblNewsletter;
	}

	private JLabel getLblVip() {
		if (this.lblVip == null) {
			this.lblVip = new JLabel("privilege :");
			this.lblVip.setForeground(new Color(139, 69, 19));
			this.lblVip.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblVip.setBounds(663, 400, 81, 14);
		}
		return this.lblVip;
	}

	private JLabel getLblParticipationOprationCommerciale() {
		if (this.lblParticipationOprationCommerciale == null) {
			this.lblParticipationOprationCommerciale = new JLabel("Participation op\u00E9rations Commerciales :");
			this.lblParticipationOprationCommerciale.setForeground(new Color(139, 69, 19));
			this.lblParticipationOprationCommerciale.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblParticipationOprationCommerciale.setBounds(663, 443, 256, 14);
		}
		return this.lblParticipationOprationCommerciale;
	}

	private JLabel getLblPrint() {
		if (this.lblPrint == null) {
			this.lblPrint = new JLabel("");
			this.lblPrint.setIcon(new ImageIcon(FicheClientComplete.class.getResource("/Images/actionbutons/export-imp.png")));
			this.lblPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrint.setForeground(Color.GRAY);
			this.lblPrint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblPrint.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					/*
					 * Properties props = new Properties();
					 *
					 * props.put("awt.print.paperSize", "a4");
					 * props.put("awt.print.destination", "printer");
					 *
					 * PrintJob pJob =
					 * interfacefenetre.getToolkit().getPrintJob(
					 * interfacefenetre,"Printing_Test", props); if (pJob !=
					 * null) { Graphics pg = pJob.getGraphics();
					 * interfacefenetre.printAll(pg); // c'est ca qui imprime
					 * pg.dispose(); } pJob.end();
					 */

					try {

						FicheClientComplete.this.desktopPath = System.getProperty("user.home") + "/Desktop";
						final String os = System.getProperty("os.name").toLowerCase();
						;
						if (os.contains("mac")) {
							FicheClientComplete.this.desktopPath = System.getProperty("user.home") + "/Desktop";
						} else {
							FicheClientComplete.this.desktopPath = System.getProperty("user.home") + "/Desktop";

						}
						final File dir = new File(FicheClientComplete.this.desktopPath + "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir, "Fiche client (titulaire carte).doc");

						final FileWriter writer = new FileWriter(file);
						final Vector<ResultatRecherche> resultatsfiche = new Vector<ResultatRecherche>(
								Select.fichecompleteporteurcarte(FicheClientComplete.this.indentifiantclient));
						for (int i = 0; i < resultatsfiche.size(); i++) {

							FicheClientComplete.this.nomclientcarte = resultatsfiche.get(i).getCiviliteIndividu() + " "
									+ resultatsfiche.get(i).getNomIndividu() + " "
									+ resultatsfiche.get(i).getPrenomIndividu();
							FicheClientComplete.this.numerocarteclientfidelite = resultatsfiche.get(i).getNumerocarte();
							FicheClientComplete.this.magasinreferenceclientcarte = resultatsfiche.get(i)
									.getNommagasin();
							FicheClientComplete.this.adresseclientcarte = resultatsfiche.get(i).getAdresseIndividu();
							FicheClientComplete.this.villeclientcarte = resultatsfiche.get(i).getVilleIndividu();
							FicheClientComplete.this.codepostalclientcarte = resultatsfiche.get(i)
									.getCodePostalIndividu();
							FicheClientComplete.this.telephoneclientcarte = resultatsfiche.get(i).getTelephonefixe();
							FicheClientComplete.this.telephonemobileclientcarte = resultatsfiche.get(i)
									.getTelephonemobile();
							FicheClientComplete.this.adressemailclientcarte = resultatsfiche.get(i).getEmail();
							FicheClientComplete.this.newsletterclientcarte = resultatsfiche.get(i)
									.getNewsletterIndividu();
							FicheClientComplete.this.datenaisanceclient = resultatsfiche.get(i)
									.getDateNaissanceIndividu();
							FicheClientComplete.this.ageclientcarte = resultatsfiche.get(i).getAge() + " ans";
						}
						writer.append("Client : ");
						writer.append(FicheClientComplete.this.nomclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Numero de Carte : ");
						writer.append(FicheClientComplete.this.numerocarteclientfidelite);
						writer.append("\n");
						writer.append("\n");
						writer.append("Date de Naissance : ");
						if (FicheClientComplete.this.datenaisanceclient != null) {
							writer.append(FicheClientComplete.this.datenaisanceclient);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Age : ");
						if (FicheClientComplete.this.ageclientcarte != null) {
							writer.append(FicheClientComplete.this.ageclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Adresse : ");
						if (FicheClientComplete.this.adresseclientcarte != null) {
							writer.append(FicheClientComplete.this.adresseclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Code Postal : ");
						writer.append(FicheClientComplete.this.codepostalclientcarte);
						writer.append("\t");
						writer.append("Ville : ");
						writer.append(FicheClientComplete.this.villeclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Telephone : ");
						if (FicheClientComplete.this.telephoneclientcarte != null) {
							writer.append(FicheClientComplete.this.telephoneclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Mobile : ");
						if (FicheClientComplete.this.telephonemobileclientcarte != null) {
							writer.append(FicheClientComplete.this.telephonemobileclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Email : ");
						if (FicheClientComplete.this.adressemailclientcarte != null) {
							writer.append(FicheClientComplete.this.adressemailclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Newsletter : ");
						writer.append(FicheClientComplete.this.newsletterclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Magsin de reference : ");
						writer.append(FicheClientComplete.this.magasinreferenceclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Participation Operations Commerciales : ");
						writer.append("\n");
						writer.append("\n");

						final Vector<infosparticipation> resultatsficheparticipation = new Vector<infosparticipation>(
								Select.infospartipationjeux(FicheClientComplete.this.indentifiantclient));

						for (int i = 0; i < resultatsficheparticipation.size(); i++) {
							writer.append("\t\t\t");
							writer.append(resultatsficheparticipation.get(i).getLibelleoperationcommerciale());
							writer.append("\t");
							writer.append(resultatsficheparticipation.get(i).getNommagasin());
							writer.append("\n");

						}

						/*
						 * Desktop bureau=Desktop.getDesktop();
						 * bureau.print(file);
						 *
						 *
						 * try { Thread.sleep(6000); } catch
						 * (InterruptedException e15) { // TODO Auto-generated
						 * catch block e15.printStackTrace(); }
						 */

						FicheClientComplete.this.Message = "Exportation du fichier Fiche client (titulaire carte).rtf réalisée avec succès";
						FicheClientComplete.this.etat = true;
						FicheClientComplete.this.choixformat = "DOC";
						final MessageExport fenetre = new MessageExport(FicheClientComplete.this.Message,
								FicheClientComplete.this.interfaceActuelle, FicheClientComplete.this.etat,
								FicheClientComplete.this.choixformat);
						fenetre.setVisible(true);
						FicheClientComplete.this.interfaceActuelle.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e99) {
						e99.printStackTrace();
						FicheClientComplete.this.Message = "Impossible d'imprimer la fiche client";
						FicheClientComplete.this.etat = false;
						FicheClientComplete.this.choixformat = "DOC";
						final AlerteSelection fenetre = new AlerteSelection(FicheClientComplete.this.interfaceActuelle,
								FicheClientComplete.this.Message);
						fenetre.setVisible(true);
						FicheClientComplete.this.interfaceActuelle.setEnabled(false);

					}

				}

			});
			this.lblPrint.setBounds(327, 224, 184, 34);

		}
		return this.lblPrint;
	}

	private JLabel getLblRetour() {
		if (this.lblRetour == null) {
			this.lblRetour = new JLabel("");
			this.lblRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					FicheClientComplete.this.dispose();

				}
			});
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.setBounds(880, 55, 172, 44);
		}
		return this.lblRetour;
	}

	private JLabel getLblTlphone() {
		if (this.lblTlphone == null) {
			this.lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
			this.lblTlphone.setForeground(new Color(139, 69, 19));
			this.lblTlphone.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblTlphone.setBounds(663, 299, 79, 14);
		}
		return this.lblTlphone;
	}

	private JLabel getLblVille() {
		if (this.lblVille == null) {
			this.lblVille = new JLabel("Ville :");
			this.lblVille.setForeground(new Color(139, 69, 19));
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblVille.setBounds(663, 249, 43, 14);
		}
		return this.lblVille;
	}

	private JPanel getPanel() {
		if (this.panel == null) {
			this.panel = new JPanel();
			this.panel.setBounds(663, 468, 367, 218);
			this.panel.setLayout(null);
			this.panel.add(this.getScrollPane());
		}
		return this.panel;
	}

	private JPanel getPanel_1() {
		if (this.panel_1 == null) {
			this.panel_1 = new JPanel();
			this.panel_1.setBorder(new LineBorder(Color.GRAY));
			this.panel_1.setBackground(Color.WHITE);
			this.panel_1.setBounds(649, 159, 393, 542);
		}
		return this.panel_1;
	}

	private JScrollPane getScrollPane() {
		if (this.scrollPane == null) {
			this.scrollPane = new JScrollPane();
			this.scrollPane.setBorder(null);
			this.scrollPane.setBounds(0, 0, 367, 218);
			this.scrollPane.setViewportView(this.getTextArea());
		}
		return this.scrollPane;
	}

	private JTextArea getTextArea() {
		if (this.textArea == null) {
			this.textArea = new JTextArea();
			this.textArea.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textArea.setForeground(Color.GRAY);
		}
		return this.textArea;
	}
}
