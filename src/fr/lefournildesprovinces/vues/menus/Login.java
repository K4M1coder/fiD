package fr.lefournildesprovinces.vues.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.applet.Accueil;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Motdepassesuppression;
import fr.lefournildesprovinces.vues.popups.Loading;

public class Login extends JFrame {

	private static String privilege;
	/**
	 *
	 */
	private static final long serialVersionUID = -1017183315514673563L;

	public static String getPrivilege() {
		return privilege;
	}

	public static void setPrivilege(final String privilege) {
		Login.privilege = privilege;
	}

	private JLabel boutonValider;
	private final JPanel contentPane;
	private JTextField fieldIdentifiant;
	private JPasswordField fieldPassword;
	private JLabel fond;
	private JLayeredPane layeredPane;
	private JLabel lblFermer;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private Loading lblLoading;

	private String motdepasse = null;

	private String utilisateur = null;

	public Login() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(249, 254, 30));
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));

	}

	public void setLblLoading(Loading lblLoading) {
		this.lblLoading = lblLoading;
	}

	/**
	 * Connect to the database and forward, either on the welcome screen, or
	 * display an error message.
	 */
	private void connect() {
		this.lblLoading.setVisible(true);

		this.utilisateur = this.fieldIdentifiant.getText();
		System.out.print("connect user : "+this.utilisateur+" / ");
		final char[] tabPassword = this.fieldPassword.getPassword();
		this.motdepasse = String.valueOf(tabPassword);
		System.out.println(this.motdepasse);

		Motdepassesuppression.setPasswordelete(this.motdepasse);

		final boolean validation = Select.verificationuUsers(this.utilisateur,
				this.motdepasse);
		if (validation == true) {
			privilege = Select.privilege(this.utilisateur, this.motdepasse);
			System.out.println("user "+this.utilisateur+" have "+privilege+" privilege ");
			final MenuPrincipal menu = new MenuPrincipal();
			menu.setVisible(true);
			this.dispose();
		} else {
			System.out.println("#### credential error ####");
			final LoginDenied fenetre = new LoginDenied();
			fenetre.setVisible(true);
			this.dispose();
		}
	}

	private JLabel getBoutonValider() {
		if (this.boutonValider == null) {
			this.boutonValider = new JLabel("");
			this.boutonValider.setIcon(null);
			this.boutonValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.boutonValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.boutonValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					Login.this.connect();
				}
			});
			this.boutonValider.setForeground(Color.GRAY);
			this.boutonValider.setBounds(743, 477, 179, 43);
		}
		return this.boutonValider;
	}

	private JTextField getFieldIdentifiant() {

		if (this.fieldIdentifiant == null) {
			this.fieldIdentifiant = new JTextField();
			this.fieldIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.fieldIdentifiant.setForeground(Color.GRAY);
			this.fieldIdentifiant.setBorder(null);
			this.fieldIdentifiant.setBounds(756, 409, 136, 20);
			this.fieldIdentifiant.setColumns(10);
			this.fieldIdentifiant.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					super.keyTyped(e);
					if ('\n' == e.getKeyChar()) {
						Login.this.connect();
					}
				}
			});
		}
		return this.fieldIdentifiant;
	}

	private JPasswordField getFieldPassword() {
		if (this.fieldPassword == null) {
			this.fieldPassword = new JPasswordField();
			this.fieldPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.fieldPassword.setForeground(Color.GRAY);
			this.fieldPassword.setBorder(null);
			this.fieldPassword.setBounds(756, 447, 136, 20);
			this.fieldPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent e) {
					super.keyTyped(e);
					if ('\n' == e.getKeyChar()) {
						Login.this.connect();
					}
				}
			});
		}
		return this.fieldPassword;
	}

	private JLabel getLabel_1() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Login.class
					.getResource("/Images/administration.png")));
			this.fond.setHorizontalTextPosition(SwingConstants.CENTER);
			this.fond.setHorizontalAlignment(SwingConstants.CENTER);
			this.fond.setBounds(216, 231, 850, 357);
		}
		return this.fond;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLoading());
			this.layeredPane.add(this.getFieldIdentifiant());
			this.layeredPane.add(this.getFieldPassword());
			this.layeredPane.add(this.getBoutonValider());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private Loading getLoading(){
		if (this.lblLoading==null){
			this.lblLoading = new Loading();
		}
		this.lblLoading.setVisible(false);
		return this.lblLoading;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.setIcon(null);
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					final Accueil fenetre = new Accueil();
					fenetre.setVisible(true);
					Login.this.dispose();
				}
			});
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setBounds(880, 231, 173, 52);
		}
		return this.lblFermer;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.RED);
			this.lblNewLabel.setBounds(465, 525, 352, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_1.setBounds(0, 0, 1280, 800);
		}
		return this.lblNewLabel_1;
	}
}
