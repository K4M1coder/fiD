package fr.lefournildesprovinces.vues.opcom;

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
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class ConfirmationChoixOperationMagasin extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 7731677423161046162L;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasin;
	private final int IdOperationCommerciale;
	private final JFrame interfacePrecedente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblContinuer;
	private JLabel lblMagasin;
	private JLabel lblMagasinSelectionne;
	private JLabel lblNewLabel;
	private JLabel lblNon;
	private JLabel lblNouvelleParticipation;
	private JLabel lbloperationSelectionnee;
	private JLabel lblOpration;
	private JLabel lblOui;
	private final String libelleOperationCommerciale;
	private final String NomMagasin;
	private String privilege;

	public ConfirmationChoixOperationMagasin(final JFrame interfaceActuelle,
			final String nomOperationCommerciale,
			final int numeroOperationCommerciale, final String Magasin,
			final int numeromagasin) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				ConfirmationChoixOperationMagasin.this.lbloperationSelectionnee
						.setText(ConfirmationChoixOperationMagasin.this.libelleOperationCommerciale);
				ConfirmationChoixOperationMagasin.this.lblMagasinSelectionne
						.setText(ConfirmationChoixOperationMagasin.this.NomMagasin);

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
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.interfacePrecedente = interfaceActuelle;
		this.libelleOperationCommerciale = nomOperationCommerciale;
		this.IdOperationCommerciale = numeroOperationCommerciale;
		this.NomMagasin = Magasin;
		this.idmagasin = numeromagasin;

	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								ConfirmationChoixOperationMagasin.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
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
								ConfirmationChoixOperationMagasin.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						ConfirmationChoixOperationMagasin.class
								.getResource("/Images/fonds/menus_operation.png")));
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
					ConfirmationChoixOperationMagasin.this.dispose();
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
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					ConfirmationChoixOperationMagasin.this.dispose();
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
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					ConfirmationChoixOperationMagasin.this.dispose();
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
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					ConfirmationChoixOperationMagasin.this.dispose();
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
					ConfirmationChoixOperationMagasin.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(866, 232, 181, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblOpration());
			this.layeredPane.add(this.getLblMagasin());
			this.layeredPane.add(this.getLblContinuer());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLbloperationSelectionnee());
			this.layeredPane.add(this.getLblMagasinSelectionne());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getLblNouvelleParticipation());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblContinuer() {
		if (this.lblContinuer == null) {
			this.lblContinuer = new JLabel("Continuer ?");
			this.lblContinuer.setForeground(Color.GRAY);
			this.lblContinuer.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblContinuer.setBounds(425, 472, 81, 14);
		}
		return this.lblContinuer;
	}

	private JLabel getLblMagasin() {
		if (this.lblMagasin == null) {
			this.lblMagasin = new JLabel("Magasin :");
			this.lblMagasin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMagasin.setForeground(Color.GRAY);
			this.lblMagasin.setBounds(436, 412, 70, 14);
		}
		return this.lblMagasin;
	}

	private JLabel getLblMagasinSelectionne() {
		if (this.lblMagasinSelectionne == null) {
			this.lblMagasinSelectionne = new JLabel("");
			this.lblMagasinSelectionne
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMagasinSelectionne.setForeground(Color.GRAY);
			this.lblMagasinSelectionne.setBounds(508, 412, 265, 14);
		}
		return this.lblMagasinSelectionne;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(
					ConfirmationChoixOperationMagasin.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setIcon(new ImageIcon(
					ConfirmationChoixOperationMagasin.class
							.getResource("/Images/actionbutons/annuler.png")));
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					ConfirmationChoixOperationMagasin.this.dispose();
					ConfirmationChoixOperationMagasin.this.interfacePrecedente
							.setEnabled(true);
					ConfirmationChoixOperationMagasin.this.interfacePrecedente
							.setVisible(true);
				}
			});
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(516, 437, 99, 84);
		}
		return this.lblNon;
	}

	private JLabel getLblNouvelleParticipation() {
		if (this.lblNouvelleParticipation == null) {
			this.lblNouvelleParticipation = new JLabel("Saisir un bulletin");
			this.lblNouvelleParticipation.setForeground(Color.GRAY);
			this.lblNouvelleParticipation.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblNouvelleParticipation.setBounds(242, 286, 323, 14);
		}
		return this.lblNouvelleParticipation;
	}

	private JLabel getLbloperationSelectionnee() {
		if (this.lbloperationSelectionnee == null) {
			this.lbloperationSelectionnee = new JLabel("");
			this.lbloperationSelectionnee.setForeground(Color.GRAY);
			this.lbloperationSelectionnee.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lbloperationSelectionnee.setBounds(507, 366, 266, 14);
		}
		return this.lbloperationSelectionnee;
	}

	private JLabel getLblOpration() {
		if (this.lblOpration == null) {
			this.lblOpration = new JLabel("Op\u00E9ration :");
			this.lblOpration.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOpration.setForeground(Color.GRAY);
			this.lblOpration.setBounds(427, 366, 79, 14);
		}
		return this.lblOpration;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.setIcon(new ImageIcon(
					ConfirmationChoixOperationMagasin.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final InterrogationClientPorteurdeCarte fenetre = new InterrogationClientPorteurdeCarte(
							ConfirmationChoixOperationMagasin.this.IdOperationCommerciale,
							ConfirmationChoixOperationMagasin.this.idmagasin);
					fenetre.setVisible(true);
					ConfirmationChoixOperationMagasin.this.interfacePrecedente
							.dispose();
					ConfirmationChoixOperationMagasin.this.dispose();

				}
			});
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setBounds(657, 437, 99, 84);
		}
		return this.lblOui;
	}
}
