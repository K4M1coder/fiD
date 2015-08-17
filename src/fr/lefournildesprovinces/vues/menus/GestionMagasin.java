package fr.lefournildesprovinces.vues.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.NouveauMagasin;
import fr.lefournildesprovinces.vues.SelectionMagasin;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class GestionMagasin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6128973102053859455L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLayeredPane layeredPane;
	private JLabel lblFermer;
	private JLabel lblMenuPrincipal;
	private JLabel lblMerciDeFaire;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblValider;
	private JLabel lienaccueil;
	private JLabel lienextraction;
	private JLabel lienfidelite;
	private JLabel lienoperation;
	private String selection;
	private JLabel label_NewMag;
	private JLabel label_ModMag;
	private JLabel label_DelMag;

	public GestionMagasin() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setForeground(Color.GRAY);
		this.contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;

		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		
		GestionMagasin.this.lblMerciDeFaire.setVisible(false);
		GestionMagasin.this.lblMerciDeFaire.setEnabled(false);
		GestionMagasin.this.lblValider.setVisible(false);
		GestionMagasin.this.lblValider.setEnabled(false);
		GestionMagasin.this.comboBox.setVisible(false);
		GestionMagasin.this.comboBox.setEnabled(false);

	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { "", "NOUVEAU Magasin",
					"METTRE A JOUR un Magasin", "SUPPRIMER un Magasin" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						GestionMagasin.this.selection = GestionMagasin.this.comboBox
								.getSelectedItem().toString();
						if (!selection.isEmpty()) {
							GestionMagasin.this.lblValider.setVisible(true);
							GestionMagasin.this.lblMerciDeFaire
									.setVisible(false);
						} else {
							GestionMagasin.this.lblValider.setVisible(false);
							GestionMagasin.this.lblMerciDeFaire
									.setVisible(true);
						}
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								GestionMagasin.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						GestionMagasin.this.interfaceActuelle.setEnabled(false);
						GestionMagasin.this.interfaceActuelle.setVisible(false);
						GestionMagasin.this.lblValider.setVisible(false);
						GestionMagasin.this.lblMerciDeFaire.setVisible(true);

					}

				}
			});
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setBounds(442, 521, 404, 22);
			this.comboBox.setEditable(false);
			this.comboBox.setFocusable(true);
			this.comboBox.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if ('\n' == e.getKeyChar()) {
						validateAction();
					}
				};
			});
		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					GestionMagasin.this.dispose();
				}
			});
			this.fond.setIcon(new ImageIcon(GestionMagasin.class
					.getResource("/Images/menus_magasin.png")));
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLblMerciDeFaire());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLabel_NewMag());
			this.layeredPane.add(this.getLabel_ModMag());
			this.layeredPane.add(this.getLabel_DelMag());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLienaccueil());
			this.layeredPane.add(this.getLienextraction());
			this.layeredPane.add(this.getLienfidelite());
			this.layeredPane.add(this.getLienoperation());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblMenuPrincipal());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}
	
	private JLabel getLabel_NewMag() {
		if (this.label_NewMag == null) {
			this.label_NewMag = new JLabel("");
			this.label_NewMag.setIcon(new ImageIcon(GestionMagasin.class.getResource("/Images/menubutons/bouton-magasin-nouveau.png")));
			this.label_NewMag
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_NewMag.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_NewMag.setForeground(Color.GRAY);
			this.label_NewMag.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionMagasin.this.selection="NOUVEAU Magasin";
					validateAction();
				}
			});
			this.label_NewMag.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_NewMag.setBounds(256, 318, 145, 225);
		}
		return this.label_NewMag;
	}
	
	private JLabel getLabel_ModMag() {
		if (this.label_ModMag == null) {
			this.label_ModMag = new JLabel("");
			this.label_ModMag.setIcon(new ImageIcon(GestionMagasin.class.getResource("/Images/menubutons/bouton-magasin-mise-jour.png")));
			this.label_ModMag
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ModMag.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ModMag.setForeground(Color.GRAY);
			this.label_ModMag.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionMagasin.this.selection="METTRE A JOUR un Magasin";
					validateAction();
				}
			});
			this.label_ModMag.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ModMag.setBounds(416, 318, 145, 225);
		}
		return this.label_ModMag;
	}
	
	private JLabel getLabel_DelMag() {
		if (this.label_DelMag == null) {
			this.label_DelMag = new JLabel("");
			this.label_DelMag.setIcon(new ImageIcon(GestionMagasin.class.getResource("/Images/menubutons/bouton-magasin-suppression.png")));
			this.label_DelMag
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_DelMag.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_DelMag.setForeground(Color.GRAY);
			this.label_DelMag.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					GestionMagasin.this.selection="SUPPRIMER un Magasin";
					validateAction();
				}
			});
			this.label_DelMag.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_DelMag.setBounds(571, 318, 145, 225);
		}
		return this.label_DelMag;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setIcon(null);
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					GestionMagasin.this.dispose();
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
				}
			});
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(865, 242, 186, 33);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuPrincipal() {
		if (this.lblMenuPrincipal == null) {
			this.lblMenuPrincipal = new JLabel("Menu > Gestion des Magasins");
			this.lblMenuPrincipal.setForeground(Color.GRAY);
			this.lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuPrincipal.setBounds(237, 375, 143, 14);
		}
		return this.lblMenuPrincipal;
	}

	private JLabel getLblMerciDeFaire() {
		if (this.lblMerciDeFaire == null) {
			this.lblMerciDeFaire = new JLabel("Merci de faire un choix");
			this.lblMerciDeFaire.setForeground(Color.GRAY);
			this.lblMerciDeFaire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeFaire.setBounds(887, 499, 150, 67);
		}
		return this.lblMerciDeFaire;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(GestionMagasin.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel(
					"Cr\u00E9ation, Mise \u00E0 jour ou suppression d'un magasin");
			this.lblNewLabel_2.setBounds(236, 286, 849, 14);
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(GestionMagasin.class
					.getResource("/Images/valider.png")));
			this.lblValider.setVisible(false);
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					validateAction();
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setBounds(887, 499, 150, 67);
		}
		return this.lblValider;
	}

	private void validateAction() {

		switch (GestionMagasin.this.selection) {

		case "1": case "NOUVEAU Magasin":
			GestionMagasin.this.selection="NOUVEAU Magasin";
			final NouveauMagasin magasin = new NouveauMagasin();
			magasin.setVisible(true);
			GestionMagasin.this.dispose();
			break;

		case "2": case "METTRE A JOUR un Magasin":
			GestionMagasin.this.selection="METTRE A JOUR un Magasin";
			final SelectionMagasin fenetre = new SelectionMagasin(
					GestionMagasin.this.selection);
			fenetre.setVisible(true);
			GestionMagasin.this.dispose();
			break;

		case "3": case "SUPPRIMER un Magasin":
			GestionMagasin.this.selection="SUPPRIMER un Magasin";
			final SelectionMagasin fenetre2 = new SelectionMagasin(
					GestionMagasin.this.selection);
			fenetre2.setVisible(true);
			GestionMagasin.this.dispose();
			break;
		}

	}

	private JLabel getLienaccueil() {
		if (this.lienaccueil == null) {
			this.lienaccueil = new JLabel("");
			this.lienaccueil.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienaccueil.setBounds(236, 231, 114, 44);
		}
		return this.lienaccueil;
	}

	private JLabel getLienextraction() {
		if (this.lienextraction == null) {
			this.lienextraction = new JLabel("");
			this.lienextraction.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienextraction.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					GestionMagasin.this.dispose();
				}
			});
			this.lienextraction.setBounds(704, 231, 114, 44);
		}
		return this.lienextraction;
	}

	private JLabel getLienfidelite() {
		if (this.lienfidelite == null) {
			this.lienfidelite = new JLabel("");
			this.lienfidelite.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienfidelite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					GestionMagasin.this.dispose();
				}
			});
			this.lienfidelite.setBounds(349, 231, 114, 44);
		}
		return this.lienfidelite;
	}

	private JLabel getLienoperation() {
		if (this.lienoperation == null) {
			this.lienoperation = new JLabel("");
			this.lienoperation.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lienoperation.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					GestionMagasin.this.dispose();
				}
			});
			this.lienoperation.setBounds(590, 231, 114, 44);
		}
		return this.lienoperation;
	}
}
