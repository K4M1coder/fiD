package fr.lefournildesprovinces.vues.magasins;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;

public class Warning extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8172889158567781416L;
	private final JPanel contentPane;
	private JLabel fond;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblEnSupprimantLe;
	private JLabel lblEtesVousSr;
	private JLabel lblNewLabel;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblSuppressionDunMagasin;
	private final String magasinselectionne;
	private final int selection;

	public Warning(final int choix, final String magasinconcerne) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				Warning.this.lblEnSupprimantLe
						.setText("En supprimant le magasin "
								+ Warning.this.magasinselectionne
								+ " vous supprimer le fichier Client Associé");
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
		this.selection = choix;

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.magasinselectionne = magasinconcerne;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

		System.out.print(this.magasinselectionne);
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Warning.class
					.getResource("/Images/menus_magasin.png")));
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Warning.this.dispose();
				}
			});
			this.label.setBounds(226, 231, 122, 44);
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
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					Warning.this.dispose();
				}
			});
			this.label_1.setBounds(348, 231, 114, 44);
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
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					Warning.this.dispose();
				}
			});
			this.label_2.setBounds(588, 231, 114, 44);
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
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					Warning.this.dispose();
				}
			});
			this.label_3.setBounds(701, 231, 114, 44);
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
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Warning.this.dispose();
				}
			});
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.label_4.setBounds(858, 232, 184, 46);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblEnSupprimantLe());
			this.layeredPane.add(this.getLblEtesVousSr());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblSuppressionDunMagasin());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblEnSupprimantLe() {
		if (this.lblEnSupprimantLe == null) {
			this.lblEnSupprimantLe = new JLabel();
			this.lblEnSupprimantLe
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblEnSupprimantLe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEnSupprimantLe.setForeground(Color.GRAY);
			this.lblEnSupprimantLe.setBounds(257, 395, 767, 14);
		}
		return this.lblEnSupprimantLe;
	}

	private JLabel getLblEtesVousSr() {
		if (this.lblEtesVousSr == null) {
			this.lblEtesVousSr = new JLabel(
					"Etes vous sur de vouloir continuer ?");
			this.lblEtesVousSr.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEtesVousSr.setForeground(Color.GRAY);
			this.lblEtesVousSr.setBounds(539, 420, 235, 14);
		}
		return this.lblEtesVousSr;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(Warning.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setIcon(new ImageIcon(Warning.class
					.getResource("/Images/annuler.png")));
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Warning.this.dispose();

				}
			});
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(504, 433, 124, 97);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblOui.setIcon(new ImageIcon(Warning.class
					.getResource("/Images/valider.png")));
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final Password fenetre = new Password(
							Warning.this.selection,
							Warning.this.magasinselectionne);
					fenetre.setVisible(true);
					Warning.this.dispose();

				}
			});
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setBounds(641, 433, 121, 97);
		}
		return this.lblOui;
	}

	private JLabel getLblSuppressionDunMagasin() {
		if (this.lblSuppressionDunMagasin == null) {
			this.lblSuppressionDunMagasin = new JLabel(
					"Suppression d'un magasin");
			this.lblSuppressionDunMagasin.setForeground(Color.GRAY);
			this.lblSuppressionDunMagasin.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblSuppressionDunMagasin.setBounds(236, 286, 147, 14);
		}
		return this.lblSuppressionDunMagasin;
	}
}
