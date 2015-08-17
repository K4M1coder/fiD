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

import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class Verifparticipation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7920034468999901706L;
	private final JPanel contentPane;
	private JLabel fond;
	private final int idmagasin;
	private final int IdOperationCommerciale;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblCliquerPourContinuer;
	private JLabel lblMerciDeVerifier;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private final String Message;
	private final String numcarte;
	private String privilege;
	private final String provenance;

	public Verifparticipation(final String Messagepre, final String ncarte,
			final String pro, final int idop, final String text, final int idmag) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				Verifparticipation.this.lblNewLabel
						.setText(Verifparticipation.this.Message);
				Verifparticipation.this.lblNewLabel_1.setText(text);

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
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.Message = Messagepre;
		this.numcarte = ncarte;
		this.provenance = pro;
		this.IdOperationCommerciale = idop;
		this.idmagasin = idmag;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(Verifparticipation.class
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

				this.fond.setIcon(new ImageIcon(Verifparticipation.class
						.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(Verifparticipation.class
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
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Verifparticipation.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(240, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.setBounds(349, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(463, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
				}
			});
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.setBounds(705, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblMerciDeVerifier());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblCliquerPourContinuer());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_3());
		}
		return this.layeredPane;
	}

	private JLabel getLblCliquerPourContinuer() {
		if (this.lblCliquerPourContinuer == null) {
			this.lblCliquerPourContinuer = new JLabel("");
			this.lblCliquerPourContinuer.setIcon(new ImageIcon(
					Verifparticipation.class
							.getResource("/Images/continuer.png")));
			this.lblCliquerPourContinuer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MajFicheClientCarteFidelite fenetre = new MajFicheClientCarteFidelite(
							Verifparticipation.this.numcarte,
							Verifparticipation.this.provenance,
							Verifparticipation.this.IdOperationCommerciale,
							Verifparticipation.this.idmagasin);
					fenetre.setVisible(true);
					Verifparticipation.this.dispose();
					System.out.print(Verifparticipation.this.provenance);
				}
			});
			this.lblCliquerPourContinuer
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblCliquerPourContinuer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblCliquerPourContinuer.setForeground(Color.GRAY);
			this.lblCliquerPourContinuer.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblCliquerPourContinuer.setBounds(536, 471, 209, 65);
		}
		return this.lblCliquerPourContinuer;
	}

	private JLabel getLblMerciDeVerifier() {
		if (this.lblMerciDeVerifier == null) {
			this.lblMerciDeVerifier = new JLabel(
					"Merci de verifier la fiche client et de completer le cas \u00E9ch\u00E9ant");
			this.lblMerciDeVerifier.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeVerifier.setForeground(Color.GRAY);
			this.lblMerciDeVerifier.setBounds(467, 424, 397, 14);
		}
		return this.lblMerciDeVerifier;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(255, 389, 767, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setBounds(242, 286, 649, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Verifparticipation.this.dispose();
				}
			});
			this.lblNewLabel_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNewLabel_2.setBounds(871, 231, 184, 44);
		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setIcon(new ImageIcon(Verifparticipation.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_3.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_3;
	}
}
