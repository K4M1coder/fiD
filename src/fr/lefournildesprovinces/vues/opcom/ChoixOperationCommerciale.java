package fr.lefournildesprovinces.vues.opcom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.controler.Control;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.OperationCommerciale;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class ChoixOperationCommerciale extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -1971424119866122001L;

	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_1;
	private final JPanel contentPane;
	private JLabel fond;
	private int idmagasin;
	private int idoperationcommerciale;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblChampsObligatoire;
	private JLabel lblFermer;
	private JLabel lblMenuChoix;
	private JLabel lblNouvelleParticipation;
	private JLabel lblSelectionnerUneOpration;
	private JLabel lblSelectionnerUnMagasin;
	private JLabel lblValider;
	private String libelleOperationcommerciale;
	private ComboBoxModel<Object> listemagasins;
	private ComboBoxModel<Object> listeOperationCommerciale;
	private String nommagasin;
	private String privilege;

	public ChoixOperationCommerciale() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {

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

		this.interfaceActuelle = this;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setBorder(null);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {
						ChoixOperationCommerciale.this.libelleOperationcommerciale = ChoixOperationCommerciale.this.comboBox
								.getSelectedItem().toString();
						ChoixOperationCommerciale.this.idoperationcommerciale = ((OperationCommerciale) ChoixOperationCommerciale.this.comboBox
								.getSelectedItem()).getIdOperationCommerciale();
						ChoixOperationCommerciale.this.lblSelectionnerUneOpration
								.setVisible(false);
						ChoixOperationCommerciale.this.comboBox_1
								.setEnabled(true);
					} catch (final Exception e) {
						final String message = "Merci de selectionner une opération commerciale dans la liste";
						final AlerteSelection fenetre = new AlerteSelection(
								ChoixOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						ChoixOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						ChoixOperationCommerciale.this.lblSelectionnerUneOpration
								.setVisible(true);
						ChoixOperationCommerciale.this.lblValider
								.setVisible(false);
						ChoixOperationCommerciale.this.comboBox_1
								.setEnabled(false);

					}
				}
			});
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBounds(451, 390, 384, 22);
			this.listeOperationCommerciale = new DefaultComboBoxModel<Object>(
					Select.listeOperationCommerciale());
			this.comboBox.setModel(this.listeOperationCommerciale);
			this.comboBox.setFocusable(false);
		}
		return this.comboBox;
	}

	private JComboBox<Object> getComboBox_1() {
		if (this.comboBox_1 == null) {
			this.comboBox_1 = new JComboBox<Object>();
			this.comboBox_1.setBorder(null);
			this.comboBox_1.setForeground(Color.GRAY);
			this.comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					try {
						ChoixOperationCommerciale.this.nommagasin = ChoixOperationCommerciale.this.comboBox_1
								.getSelectedItem().toString();
						ChoixOperationCommerciale.this.idmagasin = ((Magasin) ChoixOperationCommerciale.this.comboBox_1
								.getSelectedItem()).getIdMagasin();
						ChoixOperationCommerciale.this.lblSelectionnerUnMagasin
								.setVisible(false);
						ChoixOperationCommerciale.this.lblValider
								.setVisible(true);
					} catch (final Exception e1) {
						final String message = "Merci de selectionner un magasin dans la liste";
						final AlerteSelection fenetre = new AlerteSelection(
								ChoixOperationCommerciale.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						ChoixOperationCommerciale.this.interfaceActuelle
								.setEnabled(false);
						ChoixOperationCommerciale.this.lblSelectionnerUnMagasin
								.setVisible(true);
						ChoixOperationCommerciale.this.lblValider
								.setVisible(false);
					}
				}
			});
			this.comboBox_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox_1.setBackground(Color.WHITE);
			this.comboBox_1.setBounds(451, 426, 384, 22);
			this.listemagasins = new DefaultComboBoxModel<Object>(
					Control.listemagasins());
			this.comboBox_1.setModel(this.listemagasins);
			this.comboBox_1.setEnabled(false);
			this.comboBox_1.setFocusable(false);

		}
		return this.comboBox_1;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.privilege = Login.getPrivilege();

			switch (this.privilege) {

			case "utilisateur":

				this.fond.setIcon(new ImageIcon(ChoixOperationCommerciale.class
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
				this.fond.setIcon(new ImageIcon(ChoixOperationCommerciale.class
						.getResource("/Images/fonds/menus-grises-operation.png")));
				break;

			case "administrateur":
				this.fond.setIcon(new ImageIcon(ChoixOperationCommerciale.class
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
					ChoixOperationCommerciale.this.dispose();
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
					ChoixOperationCommerciale.this.dispose();
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
					ChoixOperationCommerciale.this.dispose();
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
					ChoixOperationCommerciale.this.dispose();
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
			this.layeredPane.add(this.getLblMenuChoix());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblSelectionnerUneOpration());
			this.layeredPane.add(this.getLblSelectionnerUnMagasin());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getComboBox_1());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblChampsObligatoire());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getLblNouvelleParticipation());
			this.layeredPane.add(this.getFond());

			final JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ChoixOperationCommerciale.class
					.getResource("/Images/fonds/fond-logiciel.png")));
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 1281, 800);
			this.layeredPane.add(lblNewLabel);
		}
		return this.layeredPane;
	}

	private JLabel getLblChampsObligatoire() {
		if (this.lblChampsObligatoire == null) {
			this.lblChampsObligatoire = new JLabel("* Champs Obligatoire");
			this.lblChampsObligatoire.setForeground(Color.GRAY);
			this.lblChampsObligatoire
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblChampsObligatoire.setBounds(232, 530, 150, 14);
		}
		return this.lblChampsObligatoire;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					ChoixOperationCommerciale.this.dispose();
				}
			});
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setBounds(869, 231, 175, 48);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuChoix() {
		if (this.lblMenuChoix == null) {
			this.lblMenuChoix = new JLabel(
					"Menu > Choix de l'Op\u00E9ration Commerciale");
			this.lblMenuChoix.setVisible(false);
			this.lblMenuChoix.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuChoix.setForeground(Color.GRAY);
			this.lblMenuChoix.setBounds(264, 323, 200, 14);
		}
		return this.lblMenuChoix;
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

	private JLabel getLblSelectionnerUneOpration() {
		if (this.lblSelectionnerUneOpration == null) {
			this.lblSelectionnerUneOpration = new JLabel(
					"S\u00E9lectionner Une Op\u00E9ration Commerciale *");
			this.lblSelectionnerUneOpration.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblSelectionnerUneOpration.setForeground(Color.GRAY);
			this.lblSelectionnerUneOpration.setBounds(534, 394, 264, 14);
			this.lblSelectionnerUneOpration.setVisible(true);
		}
		return this.lblSelectionnerUneOpration;
	}

	private JLabel getLblSelectionnerUnMagasin() {
		if (this.lblSelectionnerUnMagasin == null) {
			this.lblSelectionnerUnMagasin = new JLabel(
					"Selectionner un Magasin Participant *");
			this.lblSelectionnerUnMagasin.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblSelectionnerUnMagasin.setForeground(Color.GRAY);
			this.lblSelectionnerUnMagasin.setBounds(549, 430, 249, 14);
			this.lblSelectionnerUnMagasin.setVisible(true);
		}
		return this.lblSelectionnerUnMagasin;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(
					ChoixOperationCommerciale.class
							.getResource("/Images/actionbutons/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final ConfirmationChoixOperationMagasin fenetre = new ConfirmationChoixOperationMagasin(
							ChoixOperationCommerciale.this.interfaceActuelle,
							ChoixOperationCommerciale.this.libelleOperationcommerciale,
							ChoixOperationCommerciale.this.idoperationcommerciale,
							ChoixOperationCommerciale.this.nommagasin,
							ChoixOperationCommerciale.this.idmagasin);
					fenetre.setVisible(true);

					ChoixOperationCommerciale.this.interfaceActuelle
							.setEnabled(false);
					ChoixOperationCommerciale.this.interfaceActuelle
							.setVisible(false);

					ChoixOperationCommerciale.this.dispose();

				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setBounds(887, 403, 150, 67);
			this.lblValider.setVisible(false);
		}
		return this.lblValider;
	}
}
