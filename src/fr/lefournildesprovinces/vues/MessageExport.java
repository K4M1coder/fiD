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
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MessageExport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3556001437429006403L;
	private final String choixFormat;
	private final JPanel contentPane;
	private String desktopPath;
	private final JFrame interfaceprecedente;
	private JLabel label;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblSouhaitezvousOuvrirLe;
	private final String MessageAffichage;

	public MessageExport(final String Message, final JFrame fenetreprecedente,
			final boolean etat, final String choixformatprecedent) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				MessageExport.this.label
						.setText(MessageExport.this.MessageAffichage);
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 619, 211);
		this.contentPane = new JPanel();

		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);

		this.interfaceprecedente = fenetreprecedente;
		this.MessageAffichage = Message;
		this.choixFormat = choixformatprecedent;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label.setHorizontalAlignment(SwingConstants.CENTER);
			this.label.setHorizontalTextPosition(SwingConstants.CENTER);
			this.label.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label.setForeground(Color.RED);
			this.label.setBounds(25, 75, 562, 14);
		}
		return this.label;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();

			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLblSouhaitezvousOuvrirLe());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblOui());

			final JLabel lblLeFichierExport = new JLabel(
					"Le fichier export\u00E9 se trouve sur le bureau dans le repertoire  Base Marketing Client");
			lblLeFichierExport.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLeFichierExport.setForeground(Color.GRAY);
			lblLeFichierExport.setBounds(74, 100, 466, 14);
			this.layeredPane.add(lblLeFichierExport);
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(MessageExport.class
					.getResource("/Images/avertissements.png")));
			this.lblNewLabel.setBounds(0, 0, 628, 215);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setIcon(new ImageIcon(MessageExport.class
					.getResource("/Images/non.png")));
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					MessageExport.this.dispose();
					MessageExport.this.interfaceprecedente.setEnabled(true);

				}
			});
			this.lblNon.setForeground(Color.GRAY);
			this.lblNon.setBounds(235, 145, 51, 26);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(new ImageIcon(MessageExport.class
					.getResource("/Images/oui.png")));
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					MessageExport.this.dispose();
					MessageExport.this.interfaceprecedente.setEnabled(true);
					final Desktop desk = Desktop.getDesktop();
					try {

						final String os = System.getProperty("os.name")
								.toLowerCase();
						;
						if (os.contains("mac")) {
							MessageExport.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";
						} else {
							MessageExport.this.desktopPath = System
									.getProperty("user.home") + "/Desktop";

						}

						switch (MessageExport.this.choixFormat)

						{

						case "XLS":
							final File dir = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file = new File(dir,
									"Extraction par age (titulaire carte).xls");
							desk.open(file);
							break;

						case "CSV":
							final File dir2 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file2 = new File(dir2,
									"Extraction par age (titulaire carte).csv");
							desk.open(file2);
							break;

						case "XLS1":
							final File dir5 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file5 = new File(dir5,
									"Extraction par age (non titulaire carte).xls");
							desk.open(file5);
							break;

						case "CSV1":
							final File dir6 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file6 = new File(dir6,
									"Extraction par age (non titulaire carte).csv");
							desk.open(file6);
							break;

						case "XLS2":
							final File dir7 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file7 = new File(dir7,
									"Extraction par anniversaire (titulaire carte).xls");
							desk.open(file7);
							break;

						case "CSV2":
							final File dir8 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file8 = new File(dir8,
									"Extraction par anniversaire (titulaire carte).csv");
							desk.open(file8);
							break;

						case "XLS3":
							final File dir9 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file9 = new File(dir9,
									"Extraction par magasin (titulaire carte).xls");
							desk.open(file9);
							break;

						case "CSV3":
							final File dir10 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file10 = new File(dir10,
									"Extraction par magasin (titulaire carte).csv");
							desk.open(file10);
							break;

						case "XLS4":
							final File dir11 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file11 = new File(dir11,
									"Extraction par magasin (non titulaire carte).xls");
							desk.open(file11);
							break;

						case "CSV4":
							final File dir12 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file12 = new File(dir12,
									"Extraction par magasin (non titulaire carte).csv");
							desk.open(file12);
							break;

						case "XLS5":
							final File dir13 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file13 = new File(dir13,
									"Extraction par operation commerciale (titulaire carte).xls");
							desk.open(file13);
							break;

						case "CSV5":
							final File dir14 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file14 = new File(dir14,
									"Extraction par operation commerciale (titulaire carte).csv");
							desk.open(file14);
							break;

						case "XLS6":
							final File dir15 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file15 = new File(dir15,
									"Extraction par operation commerciale (non titulaire carte).xls");
							desk.open(file15);
							break;

						case "CSV6":
							final File dir16 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file16 = new File(dir16,
									"Extraction par operation commerciale (non titulaire carte).csv");
							desk.open(file16);
							break;

						case "XLS7":
							final File dir17 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file17 = new File(dir17,
									"Extraction par ville (titulaire carte).xls");
							desk.open(file17);
							break;

						case "CSV7":
							final File dir18 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file18 = new File(dir18,
									"Extraction par ville (titulaire carte).csv");
							desk.open(file18);
							break;

						case "XLS8":
							final File dir19 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file19 = new File(dir19,
									"Extraction par ville (non titulaire carte).xls");
							desk.open(file19);
							break;

						case "CSV8":
							final File dir20 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file20 = new File(dir20,
									"Extraction par ville (non titulaire carte).csv");
							desk.open(file20);
							break;

						case "XLS9":
							final File dir21 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file21 = new File(dir21,
									"Extraction par ensemble client (titulaire carte).xls");
							desk.open(file21);
							break;

						case "CSV9":
							final File dir22 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file22 = new File(dir22,
									"Extraction par ensemble client (titulaire carte).csv");
							desk.open(file22);
							break;

						case "XLS10":
							final File dir23 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file23 = new File(dir23,
									"Extraction par ensemble client (non titulaire carte).xls");
							desk.open(file23);
							break;

						case "CSV10":
							final File dir24 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file24 = new File(dir24,
									"Extraction par ensemble client (non titulaire carte).csv");
							desk.open(file24);
							break;

						case "DOC":
							final File dir3 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file3 = new File(dir3,
									"Fiche client (titulaire carte).doc");
							desk.open(file3);
							break;

						case "DOC2":
							final File dir4 = new File(
									MessageExport.this.desktopPath
											+ "/Base Marketing Client/");
							final File file4 = new File(dir4,
									"Fiche client (non titulaire carte).doc");
							desk.open(file4);
							break;

						}

					} catch (final IOException e1) {

						e1.printStackTrace();
					}

				}
			});
			this.lblOui.setForeground(Color.GRAY);
			this.lblOui.setBounds(322, 145, 51, 26);
		}
		return this.lblOui;
	}

	private JLabel getLblSouhaitezvousOuvrirLe() {
		if (this.lblSouhaitezvousOuvrirLe == null) {
			this.lblSouhaitezvousOuvrirLe = new JLabel(
					"Souhaitez-vous ouvrir le fichier ?");
			this.lblSouhaitezvousOuvrirLe.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblSouhaitezvousOuvrirLe.setForeground(Color.GRAY);
			this.lblSouhaitezvousOuvrirLe.setBounds(215, 120, 185, 14);
		}
		return this.lblSouhaitezvousOuvrirLe;
	}
}
