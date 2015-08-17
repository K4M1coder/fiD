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
import fr.lefournildesprovinces.ressources.models.OperationCommerciale;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasin;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class SelectionOperationCommerciale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2457668521366857012L;
	private final String choixmenuprecedent;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private int idoperationselectionnee;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblMenuGestion;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRetour;
	private JLabel lblValider;
	private ComboBoxModel<Object> mod;
	private String operationselectionnee;
	private String privilege;
	private String text;

	public SelectionOperationCommerciale(final String choix, final String text) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				SelectionOperationCommerciale.this.label_4.setText(text);

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
		this.choixmenuprecedent = choix;
		this.interfaceActuelle = this;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						SelectionOperationCommerciale.this.lblNewLabel
								.setVisible(false);
						SelectionOperationCommerciale.this.operationselectionnee = SelectionOperationCommerciale.this.comboBox
								.getSelectedItem().toString();
						SelectionOperationCommerciale.this.idoperationselectionnee = ((OperationCommerciale) SelectionOperationCommerciale.this.comboBox
								.getSelectedItem()).getIdOperationCommerciale();
						SelectionOperationCommerciale.this.lblValider
								.setVisible(true);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								SelectionOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						SelectionOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						SelectionOperationCommerciale.this.interfaceActuelle
								.setVisible(false);

						SelectionOperationCommerciale.this.lblValider
								.setVisible(false);

						SelectionOperationCommerciale.this.lblNewLabel
								.setVisible(true);
					}
				}
			});
			this.comboBox.setEditable(true);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setBounds(463, 414, 354, 22);
			this.mod = new DefaultComboBoxModel<Object>(
					Select.listeOperationCommerciale());
			this.comboBox.setModel(this.mod);
			this.comboBox.setEditable(false);
			this.comboBox.setFocusable(false);
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
								SelectionOperationCommerciale.class
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

				this.fond
						.setIcon(new ImageIcon(
								SelectionOperationCommerciale.class
										.getResource("/Images/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(
						SelectionOperationCommerciale.class
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
					SelectionOperationCommerciale.this.dispose();
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
					SelectionOperationCommerciale.this.dispose();
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
					SelectionOperationCommerciale.this.dispose();
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
					SelectionOperationCommerciale.this.dispose();
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
			this.label_4.setForeground(Color.GRAY);
			this.label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.label_4.setBounds(242, 286, 592, 14);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenuGestion());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLabel_4());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblMenuGestion() {
		if (this.lblMenuGestion == null) {
			this.lblMenuGestion = new JLabel(
					"Menu > Gestion Operation Commerciale > Selection");
			this.lblMenuGestion.setVisible(false);
			this.lblMenuGestion.setForeground(Color.GRAY);
			this.lblMenuGestion.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuGestion.setBounds(260, 325, 287, 14);
		}
		return this.lblMenuGestion;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Selectionner une op\u00E9ration");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setBounds(570, 418, 172, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(
					SelectionOperationCommerciale.class
							.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblRetour() {
		if (this.lblRetour == null) {
			this.lblRetour = new JLabel("");
			this.lblRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final GestionOperationCommerciale operation = new GestionOperationCommerciale();
					operation.setVisible(true);
					SelectionOperationCommerciale.this.dispose();
				}
			});
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setBounds(871, 231, 172, 44);
		}
		return this.lblRetour;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setIcon(new ImageIcon(
					SelectionOperationCommerciale.class
							.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					switch (SelectionOperationCommerciale.this.choixmenuprecedent) {
					case "METTRE A JOUR une Opération Commerciale":
						final MAJOperationCommerciale fenetre2 = new MAJOperationCommerciale(
								SelectionOperationCommerciale.this.idoperationselectionnee);
						fenetre2.setVisible(true);
						SelectionOperationCommerciale.this.dispose();
						break;

					case "SUPPRIMER une Opération Commerciale":
						SelectionOperationCommerciale.this.text = "Suppression d'une Opération Commerciale";
						final Warning2 fenetre = new Warning2(
								SelectionOperationCommerciale.this.idoperationselectionnee,
								SelectionOperationCommerciale.this.operationselectionnee,
								SelectionOperationCommerciale.this.text);
						fenetre.setVisible(true);
						SelectionOperationCommerciale.this.dispose();
						break;
					}

				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(887, 392, 150, 67);
			this.lblValider.setVisible(false);
		}
		return this.lblValider;
	}
}
