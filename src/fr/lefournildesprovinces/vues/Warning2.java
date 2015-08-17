package fr.lefournildesprovinces.vues;

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

import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class Warning2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176693910960518120L;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idoperationselectionne;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblEnSupprimantLe;
	private JLabel lblEtesVousSr;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNon;
	private JLabel lblOui;
	private final String operationselectionne;
	private String privilege;

	public Warning2(final int idoperation, final String operation,
			final String text) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				Warning2.this.lblNewLabel.setText(text);
				Warning2.this.lblEnSupprimantLe
						.setText("En supprimant l'opération commerciale "
								+ Warning2.this.operationselectionne
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
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.operationselectionne = operation;
		this.idoperationselectionne = idoperation;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(Warning2.class
						.getResource("/Images/menus-grises-operation.png")));
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

				this.fond.setIcon(new ImageIcon(Warning2.class
						.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(Warning2.class
						.getResource("/Images/menus_operation.png")));
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
					Warning2.this.dispose();
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
					final GestionCarteDeFidelite gestionclientcarte = new GestionCarteDeFidelite();
					gestionclientcarte.setVisible(true);
					Warning2.this.dispose();
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
					final GestionMagasin gestionMagasin = new GestionMagasin();
					gestionMagasin.setVisible(true);
					Warning2.this.dispose();
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
					final Extraction collecte = new Extraction();
					collecte.setVisible(true);
					Warning2.this.dispose();
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
					Warning2.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(867, 232, 184, 44);
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

	private JLabel getLblEnSupprimantLe() {
		if (this.lblEnSupprimantLe == null) {
			this.lblEnSupprimantLe = new JLabel();
			this.lblEnSupprimantLe
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblEnSupprimantLe.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEnSupprimantLe.setForeground(Color.GRAY);
			this.lblEnSupprimantLe.setBounds(257, 393, 776, 14);
		}
		return this.lblEnSupprimantLe;
	}

	private JLabel getLblEtesVousSr() {
		if (this.lblEtesVousSr == null) {
			this.lblEtesVousSr = new JLabel(
					"Etes vous sur de vouloir continuer ?");
			this.lblEtesVousSr.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEtesVousSr.setForeground(Color.GRAY);
			this.lblEtesVousSr.setBounds(539, 418, 223, 14);
		}
		return this.lblEtesVousSr;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 520, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(Warning2.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setIcon(new ImageIcon(Warning2.class
					.getResource("/Images/annuler.png")));
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationCommerciale fenetre = new GestionOperationCommerciale();
					fenetre.setVisible(true);
					Warning2.this.dispose();

				}
			});
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setForeground(Color.RED);
			this.lblNon.setBounds(504, 431, 124, 97);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.setIcon(new ImageIcon(Warning2.class
					.getResource("/Images/valider.png")));
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final PasswordOperationCommerciale fenetre = new PasswordOperationCommerciale(
							Warning2.this.idoperationselectionne,
							Warning2.this.operationselectionne);
					fenetre.setVisible(true);
					Warning2.this.dispose();

				}
			});
			this.lblOui.setForeground(Color.RED);
			this.lblOui.setBounds(641, 431, 121, 97);
		}
		return this.lblOui;
	}
}
