package fr.lefournildesprovinces.vues.magasins;

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

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.Warning;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class SelectionMagasin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4458185263109460967L;
	private final String choixoperation;
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
	private JLabel lblMenuGestion;
	private JLabel lblMerciDeSlectionner;
	private JLabel lblNewLabel;
	private JLabel lblSelectionDunMagasin;
	private JLabel lblValider;
	private String magasinselectionne;
	private ComboBoxModel<Object> mod;
	private int selection;

	public SelectionMagasin(final String choix) {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_1(), BorderLayout.CENTER);
		this.choixoperation = choix;
		this.setBounds(100, 100, 1280, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					try {
						SelectionMagasin.this.lblMerciDeSlectionner
								.setVisible(false);
						SelectionMagasin.this.magasinselectionne = SelectionMagasin.this.comboBox
								.getSelectedItem().toString();
						SelectionMagasin.this.selection = ((Magasin) SelectionMagasin.this.comboBox
								.getSelectedItem()).getIdMagasin();
						SelectionMagasin.this.lblValider.setVisible(true);
						System.out
								.print(SelectionMagasin.this.magasinselectionne);
					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								SelectionMagasin.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						SelectionMagasin.this.interfaceActuelle
								.setEnabled(false);
						SelectionMagasin.this.interfaceActuelle
								.setVisible(false);
						SelectionMagasin.this.lblMerciDeSlectionner
								.setVisible(true);
						SelectionMagasin.this.lblValider.setVisible(false);

					}

				}
			});
			this.comboBox.setEditable(true);
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setBorder(null);
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setBounds(439, 414, 404, 22);
			this.mod = new DefaultComboBoxModel<Object>(Select.listemagasins());
			this.comboBox.setModel(this.mod);
			this.comboBox.setEditable(false);
			this.comboBox.setFocusable(false);

		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(SelectionMagasin.class
					.getResource("/Images/menus_magasin.png")));
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel("");
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					SelectionMagasin.this.dispose();
				}
			});
			this.label.setBounds(349, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					SelectionMagasin.this.dispose();
				}
			});
			this.label_1.setBounds(590, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					SelectionMagasin.this.dispose();
				}
			});
			this.label_2.setBounds(704, 231, 114, 44);
		}
		return this.label_2;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("");
			this.label_3.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SelectionMagasin.this.dispose();
				}
			});
			this.label_3.setBounds(236, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMenuGestion());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblMerciDeSlectionner());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblSelectionDunMagasin());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					SelectionMagasin.this.dispose();
				}
			});
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setBounds(869, 231, 184, 46);
		}
		return this.lblFermer;
	}

	private JLabel getLblMenuGestion() {
		if (this.lblMenuGestion == null) {
			this.lblMenuGestion = new JLabel(
					"Menu > Gestion des Magasins >Selection Magasin");
			this.lblMenuGestion.setVisible(false);
			this.lblMenuGestion.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuGestion.setForeground(Color.GRAY);
			this.lblMenuGestion.setBounds(266, 517, 294, 14);
		}
		return this.lblMenuGestion;
	}

	private JLabel getLblMerciDeSlectionner() {
		if (this.lblMerciDeSlectionner == null) {
			this.lblMerciDeSlectionner = new JLabel(
					"Merci de s\u00E9lectionner un Magasin");
			this.lblMerciDeSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSlectionner.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner.setBounds(547, 418, 212, 14);
		}
		return this.lblMerciDeSlectionner;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(SelectionMagasin.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblSelectionDunMagasin() {
		if (this.lblSelectionDunMagasin == null) {
			this.lblSelectionDunMagasin = new JLabel("Selection d'un magasin");
			this.lblSelectionDunMagasin.setForeground(Color.GRAY);
			this.lblSelectionDunMagasin.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblSelectionDunMagasin.setBounds(242, 287, 155, 14);
		}
		return this.lblSelectionDunMagasin;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setVisible(false);
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(SelectionMagasin.class
					.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					System.out.print(SelectionMagasin.this.choixoperation);

					switch (SelectionMagasin.this.choixoperation) {
					case "METTRE A JOUR un Magasin":
						final MAJMagasin fenetre1 = new MAJMagasin(
								SelectionMagasin.this.selection);
						fenetre1.setVisible(true);
						SelectionMagasin.this.dispose();
						break;

					case "SUPPRIMER un Magasin":
						final Warning fenetre2 = new Warning(
								SelectionMagasin.this.selection,
								SelectionMagasin.this.magasinselectionne);
						fenetre2.setVisible(true);
						SelectionMagasin.this.dispose();

						break;

					}
				}
			});
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(887, 392, 150, 67);
		}
		return this.lblValider;
	}
}
