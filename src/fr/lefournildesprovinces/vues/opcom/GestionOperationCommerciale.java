package fr.lefournildesprovinces.vues.opcom;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class GestionOperationCommerciale extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 4171970833583757649L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblFermer;
	private JLabel lblMenuPrincipal;
	private JLabel lblMerciDeFaire;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblValider;
	private String privilege;
	private String selection;
	private String text;

	public GestionOperationCommerciale() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {

			}
		});
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
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;

	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { null, "NOUVELLE Opération Commerciale",
					"METTRE A JOUR une Opération Commerciale",
					"SUPPRIMER une Opération Commerciale" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						GestionOperationCommerciale.this.selection = GestionOperationCommerciale.this.comboBox
								.getSelectedItem().toString();
						if (!selection.isEmpty()) {
							GestionOperationCommerciale.this.lblMerciDeFaire
									.setVisible(false);
							GestionOperationCommerciale.this.lblValider
									.setVisible(true);
							GestionOperationCommerciale.this.lblValider
									.setEnabled(true);
						} else {
							GestionOperationCommerciale.this.lblMerciDeFaire
									.setVisible(true);
							GestionOperationCommerciale.this.lblValider
									.setVisible(false);
							GestionOperationCommerciale.this.lblValider
									.setEnabled(false);
						}

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								GestionOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						GestionOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						GestionOperationCommerciale.this.interfaceActuelle
								.setVisible(false);
						GestionOperationCommerciale.this.lblMerciDeFaire
								.setVisible(true);
						GestionOperationCommerciale.this.lblValider
								.setVisible(false);
						GestionOperationCommerciale.this.lblValider
								.setEnabled(false);

					}

				}
			});
			this.comboBox.setEditable(true);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setBounds(447, 414, 386, 22);
			this.comboBox.setFocusable(true);
			this.comboBox.setEditable(false);
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
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond
						.setIcon(new ImageIcon(
								GestionOperationCommerciale.class
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
								GestionOperationCommerciale.class
										.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						GestionOperationCommerciale.class
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
					GestionOperationCommerciale.this.dispose();
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
					GestionOperationCommerciale.this.dispose();
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
					GestionOperationCommerciale.this.dispose();
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
					GestionOperationCommerciale.this.dispose();
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(704, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenuPrincipal());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblMerciDeFaire());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					GestionOperationCommerciale.this.dispose();
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
				}
			});
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setBounds(873, 231, 175, 45);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuPrincipal() {
		if (this.lblMenuPrincipal == null) {
			this.lblMenuPrincipal = new JLabel(
					"Gestion des Op\u00E9rations Commerciales");
			this.lblMenuPrincipal.setVisible(false);
			this.lblMenuPrincipal.setForeground(Color.GRAY);
			this.lblMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMenuPrincipal.setBounds(411, 369, 254, 14);
		}
		return this.lblMenuPrincipal;
	}

	private JLabel getLblMerciDeFaire() {
		if (this.lblMerciDeFaire == null) {
			this.lblMerciDeFaire = new JLabel("Merci de faire un choix");
			this.lblMerciDeFaire.setForeground(Color.GRAY);
			this.lblMerciDeFaire.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeFaire.setBounds(887, 392, 150, 67);
		}
		return this.lblMerciDeFaire;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					"Gestion des Op\u00E9rations Commerciales (Cr\u00E9ation, Mise \u00E0 jour ou suppression d'un op\u00E9ration commerciale)");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 631, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					GestionOperationCommerciale.class
							.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setIcon(new ImageIcon(
					GestionOperationCommerciale.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					validateAction();
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setBounds(887, 392, 150, 67);
			this.lblValider.setVisible(false);
			this.lblValider.setEnabled(false);
		}
		return this.lblValider;
	}

	private void validateAction() {
		switch (GestionOperationCommerciale.this.selection) {

		case "NOUVELLE Opération Commerciale":
			final NouvelleOperationCommerciale operation = new NouvelleOperationCommerciale();
			operation.setVisible(true);
			GestionOperationCommerciale.this.dispose();
			break;

		case "METTRE A JOUR une Opération Commerciale":
			GestionOperationCommerciale.this.text = "Mise à Jour d'une Opération Commerciale";
			final SelectionOperationCommerciale operation2 = new SelectionOperationCommerciale(
					GestionOperationCommerciale.this.selection,
					GestionOperationCommerciale.this.text);
			operation2.setVisible(true);
			GestionOperationCommerciale.this.dispose();
			break;

		case "SUPPRIMER une Opération Commerciale":
			GestionOperationCommerciale.this.text = "Suppression d'une Opération Commerciale";
			final SelectionOperationCommerciale operation3 = new SelectionOperationCommerciale(
					GestionOperationCommerciale.this.selection,
					GestionOperationCommerciale.this.text);
			operation3.setVisible(true);
			GestionOperationCommerciale.this.dispose();
			break;
		}

	}
}
