package fr.lefournildesprovinces.vues;

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

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.models.infosparticipation;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class FicheClientCompleteSansCarte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3481196798959409227L;
	private String adresseclientcarte;
	private String adressemailclientcarte;
	private String adressemailcontact;
	private String ageclientcarte;
	private String choixformat;
	private String codepostalclientcarte;
	private final JPanel contentPane;
	private String desktopPath;
	private boolean etat;
	private JLabel fond;
	private final int indentifiantclient;
	private final JFrame interfacefenetre;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_10;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLayeredPane layeredPane;
	private JLabel lblAdresse;
	private JLabel lblAge;
	private JLabel lblCodePostal;
	private JLabel lblEmail;
	private JLabel lblFicheClientP;
	private JLabel lblMagasinDeRfrence;
	private JLabel lblMobile;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
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
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private String telephoneclientcarte;
	private String telephonemobileclientcarte;
	private JTextArea textArea;
	private String villeclientcarte;

	public FicheClientCompleteSansCarte(final int idclient) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

				final Vector<ResultatRecherche> resultatsfiche = new Vector<ResultatRecherche>(
						Select.fichecompleteSansCarte(FicheClientCompleteSansCarte.this.indentifiantclient));

				for (int i = 0; i < resultatsfiche.size(); i++) {

					FicheClientCompleteSansCarte.this.label_1
							.setText(resultatsfiche.get(i)
									.getCiviliteIndividu());
					FicheClientCompleteSansCarte.this.label_10
							.setText(resultatsfiche.get(i).getNommagasin());
					FicheClientCompleteSansCarte.this.lblNewLabel_3
							.setText(resultatsfiche.get(i).getNomIndividu());
					FicheClientCompleteSansCarte.this.lblNewLabel_4
							.setText(resultatsfiche.get(i).getPrenomIndividu());
					FicheClientCompleteSansCarte.this.label_3
							.setText(resultatsfiche.get(i).getAdresseIndividu());
					FicheClientCompleteSansCarte.this.label_4
							.setText(resultatsfiche.get(i).getVilleIndividu());
					FicheClientCompleteSansCarte.this.label_8
							.setText(resultatsfiche.get(i)
									.getCodePostalIndividu());
					FicheClientCompleteSansCarte.this.label_5
							.setText(resultatsfiche.get(i).getTelephonefixe());
					FicheClientCompleteSansCarte.this.label_9
							.setText(resultatsfiche.get(i).getTelephonemobile());
					FicheClientCompleteSansCarte.this.label_6
							.setText(resultatsfiche.get(i).getEmail());
					FicheClientCompleteSansCarte.this.label_7
							.setText(resultatsfiche.get(i)
									.getNewsletterIndividu());

					FicheClientCompleteSansCarte.this.lblNewLabel_2
							.setText(resultatsfiche.get(i).getAge() + " ans");
					FicheClientCompleteSansCarte.this.adressemailcontact = resultatsfiche
							.get(i).getEmail();
					if (FicheClientCompleteSansCarte.this.adressemailcontact != null) {
						FicheClientCompleteSansCarte.this.label
								.setVisible(true);
					}
				}
				FicheClientCompleteSansCarte.this.lblNewLabel
						.setText("Non titulaire d'une carte");

				final Vector<infosparticipation> resultatsficheparticipation = new Vector<infosparticipation>(
						Select.infospartipationjeux(FicheClientCompleteSansCarte.this.indentifiantclient));

				for (int i = 0; i < resultatsficheparticipation.size(); i++) {

					FicheClientCompleteSansCarte.this.textArea
							.append(resultatsficheparticipation.get(i)
									.getLibelleoperationcommerciale());
					FicheClientCompleteSansCarte.this.textArea.append("\t");
					FicheClientCompleteSansCarte.this.textArea
							.append(resultatsficheparticipation.get(i)
									.getNommagasin());
					FicheClientCompleteSansCarte.this.textArea.append("\n");
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
		this.interfacefenetre = this;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(FicheClientCompleteSansCarte.class
					.getResource("/Images/menus-extraction-long.png")));
			this.fond.setBounds(216, 55, 850, 690);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label.setIcon(new ImageIcon(FicheClientCompleteSansCarte.class
					.getResource("/Images/ecrire.png")));
			this.label.setVisible(false);
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final Desktop desktop = Desktop.getDesktop();
					final String message = "mailto:"
							+ FicheClientCompleteSansCarte.this.adressemailcontact
							+ "?subject=Le%20Fournil%20des%20Provinces";
					final URI uri = URI.create(message);
					try {
						desktop.mail(uri);
					} catch (final IOException e85) {
						// TODO Auto-generated catch block
						e85.printStackTrace();
					}
				}
			});
			this.label.setForeground(Color.RED);
			this.label.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label.setBounds(918, 343, 120, 32);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_1.setForeground(Color.RED);
			this.label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.label_1.setBounds(267, 310, 43, 14);
		}
		return this.label_1;
	}

	private JLabel getLabel_10() {
		if (this.label_10 == null) {
			this.label_10 = new JLabel("");
			this.label_10.setForeground(Color.GRAY);
			this.label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_10.setBounds(820, 174, 221, 14);
		}
		return this.label_10;
	}

	private JLabel getLabel_12() {
		if (this.label_12 == null) {
			this.label_12 = new JLabel("");
			this.label_12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					FicheClientCompleteSansCarte.this.dispose();
				}
			});
			this.label_12.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					FicheClientCompleteSansCarte.this.dispose();
				}
			});
			this.label_13.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					FicheClientCompleteSansCarte.this.dispose();
				}
			});
			this.label_14.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					FicheClientCompleteSansCarte.this.dispose();
				}
			});
			this.label_15.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_15.setBounds(573, 55, 114, 44);
		}
		return this.label_15;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setForeground(Color.GRAY);
			this.label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_3.setBounds(733, 225, 297, 14);
		}
		return this.label_3;
	}

	private JLabel getLabel_4() {
		if (this.label_4 == null) {
			this.label_4 = new JLabel("");
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(733, 249, 221, 14);
		}
		return this.label_4;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("");
			this.label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_5.setForeground(Color.GRAY);
			this.label_5.setBounds(744, 299, 108, 14);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("");
			this.label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_6.setForeground(Color.GRAY);
			this.label_6.setBounds(723, 324, 310, 14);
		}
		return this.label_6;
	}

	private JLabel getLabel_7() {
		if (this.label_7 == null) {
			this.label_7 = new JLabel("");
			this.label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_7.setForeground(Color.GRAY);
			this.label_7.setBounds(754, 386, 272, 14);
		}
		return this.label_7;
	}

	private JLabel getLabel_8() {
		if (this.label_8 == null) {
			this.label_8 = new JLabel("");
			this.label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_8.setForeground(Color.GRAY);
			this.label_8.setBounds(990, 249, 50, 14);
		}
		return this.label_8;
	}

	private JLabel getLabel_9() {
		if (this.label_9 == null) {
			this.label_9 = new JLabel("");
			this.label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_9.setForeground(Color.GRAY);
			this.label_9.setBounds(919, 299, 123, 14);
		}
		return this.label_9;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getLblCodePostal());
			this.layeredPane.add(this.getLblTlphone());
			this.layeredPane.add(this.getLblMobile());
			this.layeredPane.add(this.getLblNewsletter());
			this.layeredPane.add(this.getLblEmail());
			this.layeredPane.add(this.getLblMagasinDeRfrence());
			this.layeredPane.add(this.getLblParticipationOprationCommerciale());
			this.layeredPane.add(this.getLblFicheClientP());
			this.layeredPane.add(this.getLblVille());
			this.layeredPane.add(this.getPanel());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLabel_5());
			this.layeredPane.add(this.getLabel_6());
			this.layeredPane.add(this.getLabel_7());
			this.layeredPane.add(this.getLabel_8());
			this.layeredPane.add(this.getLabel_9());
			this.layeredPane.add(this.getLabel_10());
			this.layeredPane.add(this.getLabel_12());
			this.layeredPane.add(this.getLabel_13());
			this.layeredPane.add(this.getLabel_14());
			this.layeredPane.add(this.getLabel_15());
			this.layeredPane.add(this.getLblAge());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblPrint());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLblNewLabel_4());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getPanel_1());
			this.layeredPane.add(this.getLblNewLabel_1());
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
			this.lblAdresse.setBounds(663, 224, 64, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblAge() {
		if (this.lblAge == null) {
			this.lblAge = new JLabel("Age :");
			this.lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblAge.setForeground(new Color(139, 69, 19));
			this.lblAge.setBounds(662, 199, 48, 14);
		}
		return this.lblAge;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("CP :");
			this.lblCodePostal.setForeground(new Color(139, 69, 19));
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblCodePostal.setBounds(959, 249, 36, 14);
		}
		return this.lblCodePostal;
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
			this.lblFicheClientP = new JLabel(
					"Fiche Client non-titulaire d'une carte de fid\u00E9lit\u00E9");
			this.lblFicheClientP.setForeground(Color.GRAY);
			this.lblFicheClientP.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblFicheClientP.setBounds(242, 110, 301, 14);
		}
		return this.lblFicheClientP;
	}

	private JLabel getLblMagasinDeRfrence() {
		if (this.lblMagasinDeRfrence == null) {
			this.lblMagasinDeRfrence = new JLabel(
					"Magasin de r\u00E9f\u00E9rence  :");
			this.lblMagasinDeRfrence.setForeground(new Color(139, 69, 19));
			this.lblMagasinDeRfrence.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblMagasinDeRfrence.setBounds(663, 174, 155, 14);
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
			this.lblNewLabel.setBounds(270, 476, 181, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					FicheClientCompleteSansCarte.class
							.getResource("/Images/carte-vierge.png")));
			this.lblNewLabel_1.setBounds(242, 280, 360, 237);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_2.setBounds(710, 199, 332, 14);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setForeground(Color.RED);
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.lblNewLabel_3.setBounds(320, 310, 134, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setForeground(Color.RED);
			this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lblNewLabel_4.setBounds(320, 335, 134, 14);
		}
		return this.lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5() {
		if (this.lblNewLabel_5 == null) {
			this.lblNewLabel_5 = new JLabel("");
			this.lblNewLabel_5.setIcon(new ImageIcon(
					FicheClientCompleteSansCarte.class
							.getResource("/Images/fond-logiciel.png")));
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

	private JLabel getLblParticipationOprationCommerciale() {
		if (this.lblParticipationOprationCommerciale == null) {
			this.lblParticipationOprationCommerciale = new JLabel(
					"Participation op\u00E9rations Commerciales :");
			this.lblParticipationOprationCommerciale.setForeground(new Color(
					139, 69, 19));
			this.lblParticipationOprationCommerciale.setFont(new Font("Tahoma",
					Font.BOLD, 12));
			this.lblParticipationOprationCommerciale.setBounds(663, 443, 256,
					14);
		}
		return this.lblParticipationOprationCommerciale;
	}

	private JLabel getLblPrint() {
		if (this.lblPrint == null) {
			this.lblPrint = new JLabel("");
			this.lblPrint.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblPrint.setIcon(new ImageIcon(
					FicheClientCompleteSansCarte.class
							.getResource("/Images/export-imp.png")));
			this.lblPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblPrint.setForeground(Color.GRAY);
			this.lblPrint.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					try {

						final String os = System.getProperty("os.name")
								.toLowerCase();
						;
						if (os.contains("mac")) {
							FicheClientCompleteSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							FicheClientCompleteSansCarte.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						final File dir = new File(
								FicheClientCompleteSansCarte.this.desktopPath
										+ "/Base Marketing Client/");
						dir.mkdirs();
						final File file = new File(dir,
								"Fiche client (non titulaire carte).doc");

						final FileWriter writer = new FileWriter(file);
						final Vector<ResultatRecherche> resultatsfiche = new Vector<ResultatRecherche>(
								Select.fichecompleteSansCarte(FicheClientCompleteSansCarte.this.indentifiantclient));
						for (int i = 0; i < resultatsfiche.size(); i++) {

							FicheClientCompleteSansCarte.this.nomclientcarte = resultatsfiche
									.get(i).getCiviliteIndividu()
									+ " "
									+ resultatsfiche.get(i).getNomIndividu()
									+ " "
									+ resultatsfiche.get(i).getPrenomIndividu();
							FicheClientCompleteSansCarte.this.magasinreferenceclientcarte = resultatsfiche
									.get(i).getNommagasin();
							FicheClientCompleteSansCarte.this.adresseclientcarte = resultatsfiche
									.get(i).getAdresseIndividu();
							FicheClientCompleteSansCarte.this.villeclientcarte = resultatsfiche
									.get(i).getVilleIndividu();
							FicheClientCompleteSansCarte.this.codepostalclientcarte = resultatsfiche
									.get(i).getCodePostalIndividu();
							FicheClientCompleteSansCarte.this.telephoneclientcarte = resultatsfiche
									.get(i).getTelephonefixe();
							FicheClientCompleteSansCarte.this.telephonemobileclientcarte = resultatsfiche
									.get(i).getTelephonemobile();
							FicheClientCompleteSansCarte.this.adressemailclientcarte = resultatsfiche
									.get(i).getEmail();
							FicheClientCompleteSansCarte.this.newsletterclientcarte = resultatsfiche
									.get(i).getNewsletterIndividu();
							FicheClientCompleteSansCarte.this.ageclientcarte = resultatsfiche
									.get(i).getAge() + " ans";
						}
						writer.append("Client : ");
						writer.append(FicheClientCompleteSansCarte.this.nomclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Age : ");
						if (FicheClientCompleteSansCarte.this.ageclientcarte != null) {
							writer.append(FicheClientCompleteSansCarte.this.ageclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Adresse : ");
						if (FicheClientCompleteSansCarte.this.adresseclientcarte != null) {
							writer.append(FicheClientCompleteSansCarte.this.adresseclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Code Postal : ");
						writer.append(FicheClientCompleteSansCarte.this.codepostalclientcarte);
						writer.append("\t");
						writer.append("Ville : ");
						writer.append(FicheClientCompleteSansCarte.this.villeclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Telephone : ");
						if (FicheClientCompleteSansCarte.this.telephoneclientcarte != null) {
							writer.append(FicheClientCompleteSansCarte.this.telephoneclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Mobile : ");
						if (FicheClientCompleteSansCarte.this.telephonemobileclientcarte != null) {
							writer.append(FicheClientCompleteSansCarte.this.telephonemobileclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Email : ");
						if (FicheClientCompleteSansCarte.this.adressemailclientcarte != null) {
							writer.append(FicheClientCompleteSansCarte.this.adressemailclientcarte);
						}
						writer.append("\n");
						writer.append("\n");
						writer.append("Newsletter : ");
						writer.append(FicheClientCompleteSansCarte.this.newsletterclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Magsin de reference : ");
						writer.append(FicheClientCompleteSansCarte.this.magasinreferenceclientcarte);
						writer.append("\n");
						writer.append("\n");
						writer.append("Participation Operations Commerciales : ");
						writer.append("\n");
						writer.append("\n");

						final Vector<infosparticipation> resultatsficheparticipation = new Vector<infosparticipation>(
								Select.infospartipationjeux(FicheClientCompleteSansCarte.this.indentifiantclient));

						for (int i = 0; i < resultatsficheparticipation.size(); i++) {
							writer.append("\t\t\t");
							writer.append(resultatsficheparticipation.get(i)
									.getLibelleoperationcommerciale());
							writer.append("\t");
							writer.append(resultatsficheparticipation.get(i)
									.getNommagasin());
							writer.append("\n");

						}

						/*
						 * Desktop bureau=Desktop.getDesktop();
						 * bureau.print(file);
						 * 
						 * try { Thread.sleep(6000); } catch
						 * (InterruptedException e) { catch block
						 * e.printStackTrace(); }
						 */

						FicheClientCompleteSansCarte.this.Message = "Exportation du fichier Fiche client (non titulaire carte).rtf réalisée avec succès";
						FicheClientCompleteSansCarte.this.etat = true;
						FicheClientCompleteSansCarte.this.choixformat = "DOC2";
						final MessageExport fenetre = new MessageExport(
								FicheClientCompleteSansCarte.this.Message,
								FicheClientCompleteSansCarte.this.interfacefenetre,
								FicheClientCompleteSansCarte.this.etat,
								FicheClientCompleteSansCarte.this.choixformat);
						fenetre.setVisible(true);
						FicheClientCompleteSansCarte.this.interfacefenetre
								.setEnabled(false);

						writer.flush();
						writer.close();

					} catch (final IOException e99) {
						e99.printStackTrace();
						FicheClientCompleteSansCarte.this.Message = "Impossible d'imprimer la fiche client";
						FicheClientCompleteSansCarte.this.etat = false;
						FicheClientCompleteSansCarte.this.choixformat = "DOC2";
						final AlerteSelection fenetre = new AlerteSelection(
								FicheClientCompleteSansCarte.this.interfacefenetre,
								FicheClientCompleteSansCarte.this.Message);
						fenetre.setVisible(true);
						FicheClientCompleteSansCarte.this.interfacefenetre
								.setEnabled(false);

					}

				}
			});
			this.lblPrint.setBounds(320, 224, 184, 34);
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
					FicheClientCompleteSansCarte.this.dispose();

				}
			});
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.setBounds(877, 55, 163, 44);
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
			this.lblVille.setBounds(663, 249, 64, 14);
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
			this.textArea.setBorder(null);
		}
		return this.textArea;
	}
}
