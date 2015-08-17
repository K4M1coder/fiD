package fr.lefournildesprovinces.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class SuppressionClientOC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6409798500793216521L;
	private String age;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private JComboBox<Object> comboBox_2;
	private final JPanel contentPane;
	private String datenaissance;
	private JLabel fond;
	private final JFrame interfaceactuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblMenuSuppression;
	private JLabel lblMerciDeChoisir;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblRetour;
	private ComboBoxModel<Object> mod;
	private ComboBoxModel<Object> mod2;
	private ComboBoxModel<Object> mod3;
	private String nomClient;
	private String prenomClient;
	private String privilege;
	private final String selection;

	public SuppressionClientOC(final String choix, final String text) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				SuppressionClientOC.this.lblNewLabel_3.setText(text);
				switch (SuppressionClientOC.this.selection) {
				case "METTRE A JOUR un bulletin":
					SuppressionClientOC.this.lblMenuSuppression
							.setText("Mise a jour d'un bulletin");
					break;

				case "SUPPRIMER un bulletin":
					SuppressionClientOC.this.lblMenuSuppression
							.setText("Supprimer d'un bulletin");
					break;
				}

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
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceactuelle = this;
		this.selection = choix;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setEditable(true);

			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						SuppressionClientOC.this.nomClient = SuppressionClientOC.this.comboBox
								.getSelectedItem().toString();
						System.out.print(SuppressionClientOC.this.nomClient);
						SuppressionClientOC.this.mod2 = new DefaultComboBoxModel<Object>(
								Select.listePrenomclient(SuppressionClientOC.this.nomClient));
						SuppressionClientOC.this.comboBox_1
								.setModel(SuppressionClientOC.this.mod2);
						SuppressionClientOC.this.comboBox_1.setEnabled(true);
						SuppressionClientOC.this.lblNewLabel.setVisible(false);
					} catch (final Exception e) {

						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								SuppressionClientOC.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						SuppressionClientOC.this.interfaceactuelle
								.setEnabled(false);
						SuppressionClientOC.this.interfaceactuelle
								.setVisible(false);
						SuppressionClientOC.this.lblNewLabel.setVisible(true);
					}
				}
			});
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setBounds(462, 377, 314, 22);
			this.mod = new DefaultComboBoxModel<Object>(Select.listenomclient());
			this.comboBox.setModel(this.mod);
			AutoCompletion.enable(this.comboBox);

		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			this.comboBox_1 = new JComboBox<Object>();
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.setEditable(true);
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						SuppressionClientOC.this.prenomClient = SuppressionClientOC.this.comboBox_1
								.getSelectedItem().toString();
						SuppressionClientOC.this.mod3 = new DefaultComboBoxModel<Object>(
								Select.listeageClient(
										SuppressionClientOC.this.nomClient,
										SuppressionClientOC.this.prenomClient));
						SuppressionClientOC.this.comboBox_2
								.setModel(SuppressionClientOC.this.mod3);
						SuppressionClientOC.this.comboBox_2.setEnabled(true);
						SuppressionClientOC.this.lblNewLabel_1
								.setVisible(false);
						SuppressionClientOC.this.comboBox_2.setFocusable(false);
					} catch (final Exception e1) {

						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								SuppressionClientOC.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						SuppressionClientOC.this.interfaceactuelle
								.setEnabled(false);
						SuppressionClientOC.this.interfaceactuelle
								.setVisible(false);
						SuppressionClientOC.this.lblNewLabel_1.setVisible(true);
					}

				}
			});
			this.comboBox_1.setBounds(462, 407, 314, 22);
			AutoCompletion.enable(this.comboBox_1);
			this.comboBox_1.setEnabled(false);

		}
		return this.comboBox_1;
	}

	private JComboBox<Object> getComboBox_2() {
		if (this.comboBox_2 == null) {
			this.comboBox_2 = new JComboBox<Object>();
			this.comboBox_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					try {
						SuppressionClientOC.this.lblMerciDeChoisir
								.setVisible(false);
						SuppressionClientOC.this.age = SuppressionClientOC.this.comboBox_2
								.getSelectedItem().toString();

						System.out.print(SuppressionClientOC.this.age + "\n");

						SuppressionClientOC.this.lblNewLabel_2.setVisible(true);
						SuppressionClientOC.this.lblNewLabel_2.setEnabled(true);

					} catch (final Exception e1) {
						SuppressionClientOC.this.lblMerciDeChoisir
								.setVisible(true);
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								SuppressionClientOC.this.interfaceactuelle,
								message);
						fenetre.setVisible(true);
						SuppressionClientOC.this.interfaceactuelle
								.setEnabled(false);
						SuppressionClientOC.this.interfaceactuelle
								.setVisible(false);
					}

				}
			});
			this.comboBox_2.setEditable(true);
			this.comboBox_2.setBackground(Color.WHITE);
			this.comboBox_2.setBorder(null);
			this.comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_2.setForeground(Color.GRAY);
			this.comboBox_2.setBounds(462, 438, 314, 22);
			this.comboBox_2.setEnabled(false);

		}
		return this.comboBox_2;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(SuppressionClientOC.class
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

				this.fond.setIcon(new ImageIcon(SuppressionClientOC.class
						.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(SuppressionClientOC.class
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
					SuppressionClientOC.this.dispose();
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
					SuppressionClientOC.this.dispose();
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
					SuppressionClientOC.this.dispose();
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
					SuppressionClientOC.this.dispose();
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
			this.layeredPane.add(this.getLblMenuSuppression());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLblNewLabel_1());
			this.layeredPane.add(this.getLblMerciDeChoisir());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getComboBox_2());
			this.layeredPane.add(this.getLblNewLabel_2());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNewLabel_3());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_4());
		}
		return this.layeredPane;
	}

	private JLabel getLblMenuSuppression() {
		if (this.lblMenuSuppression == null) {
			this.lblMenuSuppression = new JLabel("");
			this.lblMenuSuppression.setVisible(false);
			this.lblMenuSuppression.setForeground(Color.GRAY);
			this.lblMenuSuppression.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMenuSuppression.setBounds(250, 322, 501, 14);
		}
		return this.lblMenuSuppression;
	}

	private JLabel getLblMerciDeChoisir() {
		if (this.lblMerciDeChoisir == null) {
			this.lblMerciDeChoisir = new JLabel(
					"Taper ou s\u00E9lectionner son \u00E2ge");
			this.lblMerciDeChoisir.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeChoisir.setForeground(Color.GRAY);
			this.lblMerciDeChoisir.setBounds(534, 442, 206, 14);
		}
		return this.lblMerciDeChoisir;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel(
					" Taper ou S\u00E9lectionner  le  nom du client");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(499, 380, 252, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel(
					"Taper ou s\u00E9lectionner son pr\u00E9nom");
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_1.setForeground(Color.GRAY);
			this.lblNewLabel_1.setBounds(519, 411, 232, 14);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (this.lblNewLabel_2 == null) {
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel_2.setIcon(new ImageIcon(SuppressionClientOC.class
					.getResource("/Images/valider.png")));
			this.lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					switch (SuppressionClientOC.this.selection) {
					case "METTRE A JOUR un bulletin":
						final MajClientOperationCommerciale fenetre1 = new MajClientOperationCommerciale(
								SuppressionClientOC.this.nomClient,
								SuppressionClientOC.this.prenomClient,
								SuppressionClientOC.this.age);
						fenetre1.setVisible(true);
						SuppressionClientOC.this.dispose();
						System.out.print(SuppressionClientOC.this.nomClient
								+ " " + SuppressionClientOC.this.prenomClient
								+ " " + SuppressionClientOC.this.age);
						break;

					case "SUPPRIMER un bulletin":
						final ConfirmationSuppressionClientOC fenetre = new ConfirmationSuppressionClientOC(
								SuppressionClientOC.this.nomClient,
								SuppressionClientOC.this.prenomClient,
								SuppressionClientOC.this.datenaissance,
								SuppressionClientOC.this.interfaceactuelle,
								SuppressionClientOC.this.age);
						fenetre.setVisible(true);
						SuppressionClientOC.this.interfaceactuelle
								.setEnabled(false);
						SuppressionClientOC.this.interfaceactuelle
								.setVisible(false);
						break;
					}
				}
			});
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblNewLabel_2.setForeground(Color.GRAY);
			this.lblNewLabel_2.setBounds(888, 414, 150, 67);
			this.lblNewLabel_2.setVisible(false);
			this.lblNewLabel_2.setEnabled(false);

		}
		return this.lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (this.lblNewLabel_3 == null) {
			this.lblNewLabel_3 = new JLabel("");
			this.lblNewLabel_3.setForeground(Color.GRAY);
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel_3.setBounds(242, 286, 509, 14);
		}
		return this.lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (this.lblNewLabel_4 == null) {
			this.lblNewLabel_4 = new JLabel("");
			this.lblNewLabel_4.setIcon(new ImageIcon(SuppressionClientOC.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_4.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_4;
	}

	private JLabel getLblRetour() {
		if (this.lblRetour == null) {
			this.lblRetour = new JLabel("");
			this.lblRetour.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					final GestionOperationCommerciale2 fenetre = new GestionOperationCommerciale2();
					fenetre.setVisible(true);
					SuppressionClientOC.this.dispose();
				}
			});
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setBounds(870, 231, 183, 47);
		}
		return this.lblRetour;
	}
}
