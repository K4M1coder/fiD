package fr.lefournildesprovinces.vues.admininstartaion;

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

import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class UserShopsAllowed extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 8433946420651749054L;
	private JLabel action_Retour;
	private JLabel action_Valider;
	private JLabel ariane;
	private JLabel background;
	private JLabel fond;
	private JLabel menu_Extraction;
	private JLabel menu_Fidelite;
	private JLabel menu_Magasin;
	private JLabel menu_OperationsCommerciales;
	private JLayeredPane layeredPane;
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private final JPanel contentPane;


	public UserShopsAllowed(final String utilisateurselectionne, final JFrame interfacePrecedente) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				// TODO
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
		this.interfacePrecedente= interfacePrecedente;
		this.interfaceActuelle = this;
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private JLabel getAction_Retour() {
		if (this.action_Retour == null) {
			this.action_Retour = new JLabel("");
			this.action_Retour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.action_Retour.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.action_Retour.setBounds(876, 231, 179, 44);
		}
		return this.action_Retour;
	}

	private JLabel getLblNewLabel_1() {
		if (this.background == null) {
			this.background = new JLabel("");
			this.background.setIcon(new ImageIcon(Selectionutilisateur.class
					.getResource("/Images/fonds/fond-logiciel.png")));
			this.background.setBounds(0, 0, 1281, 800);
		}
		return this.background;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(UserShopsAllowed.class
					.getResource("/Images/fonds/menus_accueil-2.png")));
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLbl_Ariane());
			this.layeredPane.add(this.getMenu_Fidelite());
			this.layeredPane.add(this.getMenu_Magasin());
			this.layeredPane.add(this.getMenu_OperationsCommerciales());
			this.layeredPane.add(this.getMenu_Extraction());
			this.layeredPane.add(this.getAction_Retour());
			this.layeredPane.add(this.getLbl_Valider());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());

		}
		return this.layeredPane;
	}

	private JLabel getLbl_Ariane() {
		if (this.ariane == null) {
			this.ariane = new JLabel(
					"Mettre à jour un mot de passe utilisateur");
			this.ariane.setForeground(Color.GRAY);
			this.ariane.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.ariane.setBounds(242, 286, 624, 14);
		}
		return this.ariane;
	}

	private JLabel getLbl_Valider() {
		if (this.action_Valider == null) {
			this.action_Valider = new JLabel("");
			this.action_Valider.setVisible(false);
			this.action_Valider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					validateAction();
				}
			});
			this.action_Valider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.action_Valider.setHorizontalAlignment(SwingConstants.CENTER);
			this.action_Valider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.action_Valider.setIcon(new ImageIcon(UserShopsAllowed.class
					.getResource("/Images/actionbutons/valider.png")));
			this.action_Valider.setBounds(876, 447, 150, 67);

		}
		return this.action_Valider;
	}

	private JLabel getMenu_Extraction() {
		if (this.menu_Extraction == null) {
			this.menu_Extraction = new JLabel("");
			this.menu_Extraction.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.menu_Extraction.setBounds(702, 231, 114, 44);
		}
		return this.menu_Extraction;
	}

	private JLabel getMenu_Fidelite() {
		if (this.menu_Fidelite == null) {
			this.menu_Fidelite = new JLabel("");
			this.menu_Fidelite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.menu_Fidelite.setBounds(367, 231, 114, 44);
		}
		return this.menu_Fidelite;
	}

	private JLabel getMenu_Magasin() {
		if (this.menu_Magasin == null) {
			this.menu_Magasin = new JLabel("");
			this.menu_Magasin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.menu_Magasin.setBounds(476, 231, 114, 44);
		}
		return this.menu_Magasin;
	}

	private JLabel getMenu_OperationsCommerciales() {
		if (this.menu_OperationsCommerciales == null) {
			this.menu_OperationsCommerciales = new JLabel("");
			this.menu_OperationsCommerciales.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.menu_OperationsCommerciales.setBounds(588, 231, 114, 44);
		}
		return this.menu_OperationsCommerciales;
	}

	private void validateAction() {

		UserShopsAllowed.this.interfaceActuelle.setEnabled(false);
	}
}
