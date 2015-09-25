package fr.lefournildesprovinces.vues.popups;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class AlerteSelection extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -3295807283009907957L;

	private final JPanel contentPane;
	private final JFrame interfacePrecedente;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private final String messageErreur;

	public AlerteSelection(final JFrame interfaceActuelle, final String message) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent e) {
				AlerteSelection.this.lblNewLabel
						.setText(AlerteSelection.this.messageErreur);
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		this.setBounds(100, 100, 621, 209);
		this.contentPane = new JPanel();
		this.contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				AlerteSelection.this.interfacePrecedente.setEnabled(true);
				AlerteSelection.this.interfacePrecedente.setVisible(true);

				AlerteSelection.this.dispose();
			}
		});

		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.interfacePrecedente = interfaceActuelle;
		this.messageErreur = message;
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_2());
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
			this.lblNewLabel.setBounds(41, 113, 537, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(AlerteSelection.class
					.getResource("/Images/fonds/avertissements.png")));
			this.lblNewLabel_1.setBounds(0, 0, 628, 215);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setIcon(new ImageIcon(AlerteSelection.class
					.getResource("/Images/actionbutons/annuler.png")));
			this.lblNewLabel_2.setBounds(265, 148, 149, 23);
		}
		return this.lblNewLabel_2;
	}
}
