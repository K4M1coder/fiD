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

import fr.lefournildesprovinces.vues.fidelite.FideliteNouvelleFicheClient;

public class carteinexistantecreation extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -6445018466547613205L;

	private final JPanel contentPane;
	private final int idmagasin;
	private final int idoperation;
	private final JFrame interfacePrecedente;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNon;
	private JLabel lblOui;
	private JLabel lblSouhaitezVousCrer;
	private final String messageErreur;
	private final String numerocarteclient;

	public carteinexistantecreation(final JFrame interfaceActuelle,
			final String message, final String numcarte,
			final int operationcommerciale, final int nummagasin) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				carteinexistantecreation.this.lblNewLabel
						.setText(carteinexistantecreation.this.messageErreur);
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 622, 209);
		this.contentPane = new JPanel();

		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.interfacePrecedente = interfaceActuelle;
		this.messageErreur = message;
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.numerocarteclient = numcarte;
		this.idoperation = operationcommerciale;
		this.idmagasin = nummagasin;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblOui());
			this.layeredPane.add(this.getLblNon());
			this.layeredPane.add(this.getLblSouhaitezVousCrer());

			final JLabel lblLaParticipationDe = new JLabel(
					"La participation de ce client \u00E0 \u00E9t\u00E9 prise en compte pour cette op\u00E9ration");
			lblLaParticipationDe.setForeground(Color.GRAY);
			lblLaParticipationDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLaParticipationDe.setBounds(109, 73, 404, 14);
			this.layeredPane.add(lblLaParticipationDe);
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(33, 96, 537, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					carteinexistantecreation.class
							.getResource("/Images/avertissements.png")));
			this.lblNewLabel_1.setBounds(0, 0, 628, 215);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNon() {
		if (this.lblNon == null) {
			this.lblNon = new JLabel("");
			this.lblNon.setIcon(new ImageIcon(carteinexistantecreation.class
					.getResource("/Images/non.png")));
			this.lblNon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					carteinexistantecreation.this.interfacePrecedente
							.setVisible(true);
					carteinexistantecreation.this.interfacePrecedente
							.setEnabled(true);
					carteinexistantecreation.this.dispose();

				}
			});
			this.lblNon.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNon.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNon.setForeground(Color.GRAY);
			this.lblNon.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNon.setBounds(319, 141, 55, 31);
		}
		return this.lblNon;
	}

	private JLabel getLblOui() {
		if (this.lblOui == null) {
			this.lblOui = new JLabel("");
			this.lblOui.setIcon(new ImageIcon(carteinexistantecreation.class
					.getResource("/Images/oui.png")));
			this.lblOui.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final String choix = "creationcarteparoperation";
					final FideliteNouvelleFicheClient fenetre = new FideliteNouvelleFicheClient(
							carteinexistantecreation.this.numerocarteclient,
							carteinexistantecreation.this.idoperation,
							carteinexistantecreation.this.idmagasin, choix, carteinexistantecreation.this);
					fenetre.setVisible(true);
					carteinexistantecreation.this.interfacePrecedente.dispose();
					carteinexistantecreation.this.dispose();

				}
			});
			this.lblOui.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblOui.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblOui.setForeground(Color.GRAY);
			this.lblOui.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblOui.setBounds(232, 141, 44, 31);
		}
		return this.lblOui;
	}

	private JLabel getLblSouhaitezVousCrer() {
		if (this.lblSouhaitezVousCrer == null) {
			this.lblSouhaitezVousCrer = new JLabel(
					"Souhaitez vous cre\u00E9r la carte maintenant ?");
			this.lblSouhaitezVousCrer
					.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblSouhaitezVousCrer.setForeground(Color.GRAY);
			this.lblSouhaitezVousCrer
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblSouhaitezVousCrer.setBounds(122, 121, 361, 14);
		}
		return this.lblSouhaitezVousCrer;
	}
}
