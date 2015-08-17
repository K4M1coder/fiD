package fr.lefournildesprovinces.vues.menus;

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

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.lefournildesprovinces.vues.CollecteInformations;
import fr.lefournildesprovinces.vues.CollecteInformationsSansCarte;
import fr.lefournildesprovinces.vues.EmailingOperationCommercialeTOUS;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class Extraction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2630512454896778146L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblCollecteDonformations;
	private JLabel lblExtractionDesInformations;
	private JLabel lblMerciDeSelectionner;
	private JLabel lblNewLabel;
	private JLabel lblRetour;
	private JLabel lblValider;
	private String selection;
	private JLabel label_ExtBaseFid;
	private JLabel label_ExtBaseOCNoCard;
	private JLabel label_ExtBaseOCAll;

	public Extraction() {
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
		this.interfaceActuelle = this;
		
		Extraction.this.lblMerciDeSelectionner.setVisible(false);
		Extraction.this.lblMerciDeSelectionner.setEnabled(false);
		Extraction.this.lblValider.setVisible(false);
		Extraction.this.lblValider.setEnabled(false);
		Extraction.this.comboBox.setVisible(false);
		Extraction.this.comboBox.setEnabled(false);
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			final String[] choix = { " ", " Base CARTE DE FIDELITE",
					" Base OPERATION commerciale SANS CARTE",
					" Base OPERATION commmerciale (INTEGRALITE PARTICIPANTS)" };
			this.comboBox = new JComboBox<Object>(choix);
			this.comboBox.setBorder(null);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setFocusable(true);
			this.comboBox.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if ('\n' == e.getKeyChar()) {
						validateAction();
					}
				};
			});

			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						Extraction.this.selection = Extraction.this.comboBox
								.getSelectedItem().toString().substring(1);
						if (!selection.isEmpty()) {
							Extraction.this.lblMerciDeSelectionner
									.setVisible(false);
							Extraction.this.lblValider.setVisible(true);
						} else {
							Extraction.this.lblMerciDeSelectionner
									.setVisible(true);
							Extraction.this.lblValider.setVisible(false);
						}

					} catch (final Exception e) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								Extraction.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						Extraction.this.interfaceActuelle.setEnabled(false);
						Extraction.this.interfaceActuelle.setVisible(false);
						Extraction.this.lblValider.setVisible(false);
						Extraction.this.lblMerciDeSelectionner.setVisible(true);
					}

				}
			});
			this.comboBox.setBounds(428, 521, 437, 22);

		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Extraction.class
					.getResource("/Images/menus_extraction.png")));
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
					Extraction.this.dispose();
				}
			});
			this.label.setBounds(240, 231, 114, 44);
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
					Extraction.this.dispose();
				}
			});
			this.label_1.setBounds(349, 231, 114, 44);
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
					Extraction.this.dispose();
				}
			});
			this.label_2.setBounds(461, 231, 114, 44);
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
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					Extraction.this.dispose();
				}
			});
			this.label_3.setBounds(575, 231, 114, 44);
		}
		return this.label_3;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMerciDeSelectionner());
			this.layeredPane.add(this.getLblCollecteDonformations());
			this.layeredPane.add(this.getLblRetour());
			this.layeredPane.add(this.getLabel_ExtBaseFid());
			this.layeredPane.add(this.getLabel_ExtBaseOCNoCard());
			this.layeredPane.add(this.getLabel_ExtBaseOCAll());
			this.layeredPane.add(this.getComboBox());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblExtractionDesInformations());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel());
		}
		return this.layeredPane;
	}

	private JLabel getLblCollecteDonformations() {
		if (this.lblCollecteDonformations == null) {
			this.lblCollecteDonformations = new JLabel(
					"Collecte d'informations Emailing");
			this.lblCollecteDonformations.setVisible(false);
			this.lblCollecteDonformations.setForeground(Color.GRAY);
			this.lblCollecteDonformations.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblCollecteDonformations.setBounds(248, 326, 215, 14);
		}
		return this.lblCollecteDonformations;
	}

	private JLabel getLblExtractionDesInformations() {
		if (this.lblExtractionDesInformations == null) {
			this.lblExtractionDesInformations = new JLabel(
					"Extraction des informations");
			this.lblExtractionDesInformations.setFont(new Font("Tahoma",
					Font.BOLD, 11));
			this.lblExtractionDesInformations.setForeground(Color.GRAY);
			this.lblExtractionDesInformations.setBounds(242, 286, 221, 14);
		}
		return this.lblExtractionDesInformations;
	}

	private JLabel getLblMerciDeSelectionner() {
		if (this.lblMerciDeSelectionner == null) {
			this.lblMerciDeSelectionner = new JLabel("Merci de faire un choix");
			this.lblMerciDeSelectionner.setFont(new Font("Tahoma", Font.BOLD,
					11));
			this.lblMerciDeSelectionner.setForeground(Color.GRAY);
			this.lblMerciDeSelectionner.setBounds(886, 499, 150, 67);
		}
		return this.lblMerciDeSelectionner;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setIcon(new ImageIcon(Extraction.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblNewLabel.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblRetour() {
		if (this.lblRetour == null) {
			this.lblRetour = new JLabel("");
			this.lblRetour.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblRetour.setForeground(Color.GRAY);
			this.lblRetour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					Extraction.this.dispose();
				}
			});
			this.lblRetour.setBounds(887, 231, 149, 54);
		}
		return this.lblRetour;
	}
	
	private JLabel getLabel_ExtBaseFid() {
		if (this.label_ExtBaseFid == null) {
			this.label_ExtBaseFid = new JLabel("");
			this.label_ExtBaseFid.setIcon(new ImageIcon(Extraction.class.getResource("/Images/menubutons/bouton-extraction-fidelite.png")));
			this.label_ExtBaseFid
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ExtBaseFid.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ExtBaseFid.setForeground(Color.GRAY);
			this.label_ExtBaseFid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					Extraction.this.selection="Base CARTE DE FIDELITE";
					validateAction();
				}
			});
			this.label_ExtBaseFid.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ExtBaseFid.setBounds(256, 318, 145, 225);
		}
		return this.label_ExtBaseFid;
	}
	
	private JLabel getLabel_ExtBaseOCNoCard() {
		if (this.label_ExtBaseOCNoCard == null) {
			this.label_ExtBaseOCNoCard = new JLabel("");
			this.label_ExtBaseOCNoCard.setIcon(new ImageIcon(Extraction.class.getResource("/Images/menubutons/bouton-extraction-operation-sans.png")));
			this.label_ExtBaseOCNoCard
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ExtBaseOCNoCard.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ExtBaseOCNoCard.setForeground(Color.GRAY);
			this.label_ExtBaseOCNoCard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					Extraction.this.selection="Base OPERATION commerciale SANS CARTE";
					validateAction();
				}
			});
			this.label_ExtBaseOCNoCard.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ExtBaseOCNoCard.setBounds(416, 318, 145, 225);
		}
		return this.label_ExtBaseOCNoCard;
	}
	
	private JLabel getLabel_ExtBaseOCAll() {
		if (this.label_ExtBaseOCAll == null) {
			this.label_ExtBaseOCAll = new JLabel("");
			this.label_ExtBaseOCAll.setIcon(new ImageIcon(Extraction.class.getResource("/Images/menubutons/bouton-extraction-operation-tous.png")));
			this.label_ExtBaseOCAll
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_ExtBaseOCAll.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.label_ExtBaseOCAll.setForeground(Color.GRAY);
			this.label_ExtBaseOCAll.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {

					Extraction.this.selection="Base OPERATION commmerciale (INTEGRALITE PARTICIPANTS)";
					validateAction();
				}
			});
			this.label_ExtBaseOCAll.setHorizontalAlignment(SwingConstants.CENTER);
			this.label_ExtBaseOCAll.setBounds(571, 318, 145, 225);
		}
		return this.label_ExtBaseOCAll;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(Extraction.class
					.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					validateAction();
				}
			});
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setBounds(886, 499, 150, 67);
			this.lblValider.setVisible(false);
		}
		return this.lblValider;
	}
	
	private void validateAction() {

		switch (Extraction.this.selection) {

		case "Base CARTE DE FIDELITE":
			final CollecteInformations fenetre = new CollecteInformations(
					Extraction.this.selection);
			fenetre.setVisible(true);
			Extraction.this.interfaceActuelle.setVisible(false);
			Extraction.this.interfaceActuelle.setEnabled(false);
			break;

		case "Base OPERATION commerciale SANS CARTE":
			final CollecteInformationsSansCarte fenetre1 = new CollecteInformationsSansCarte(
					Extraction.this.selection);
			fenetre1.setVisible(true);
			Extraction.this.interfaceActuelle.setVisible(false);
			Extraction.this.interfaceActuelle.setEnabled(false);
			break;

		case "Base OPERATION commmerciale (INTEGRALITE PARTICIPANTS)":
			final EmailingOperationCommercialeTOUS fenetre3 = new EmailingOperationCommercialeTOUS(
					Extraction.this.interfaceActuelle);

			fenetre3.setVisible(true);
			Extraction.this.interfaceActuelle.setVisible(false);
			Extraction.this.interfaceActuelle.setEnabled(false);
			break;
		}

	}
}
