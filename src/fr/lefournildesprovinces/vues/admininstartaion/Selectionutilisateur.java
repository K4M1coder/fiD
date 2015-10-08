package fr.lefournildesprovinces.vues.admininstartaion;

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

import fr.lefournildesprovinces.controler.Control;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.UtilisateurLogiciel;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class Selectionutilisateur extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -2734534353365590098L;
	private JComboBox<Object> comboBox;
	private final JPanel contentPane;
	private JLabel fond;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLayeredPane layeredPane;
	private JLabel lblMerciDeSlectionner;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private ComboBoxModel<Object> mod;
	private String password;
	private final String selectionprecedente;
	private String utilisateurselectionne;
	private JLabel valider;

	public Selectionutilisateur(final String selection) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				Selectionutilisateur.this.lblNewLabel
						.setText(Selectionutilisateur.this.selectionprecedente);
				System.out.print(Selectionutilisateur.this.selectionprecedente);
				Selectionutilisateur.this.mod = new DefaultComboBoxModel<Object>(
						Select.listeutilisateur(Selectionutilisateur.this.selectionprecedente));
				Selectionutilisateur.this.comboBox
						.setModel(Selectionutilisateur.this.mod);
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
		this.selectionprecedente = selection;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.interfaceActuelle = this;
	}

	private JComboBox<Object> getComboBox() {
		if (this.comboBox == null) {
			this.comboBox = new JComboBox<Object>();
			this.comboBox.setBackground(Color.WHITE);
			this.comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBox.setForeground(Color.GRAY);
			this.comboBox.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.comboBox.setFocusable(false);
			this.comboBox.setBorder(null);
			this.comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {

					try {
						Selectionutilisateur.this.utilisateurselectionne = Selectionutilisateur.this.comboBox
								.getSelectedItem().toString().substring(1);
						Selectionutilisateur.this.password = ((UtilisateurLogiciel) Selectionutilisateur.this.comboBox
								.getSelectedItem()).getMotdepasse().toString();
						Selectionutilisateur.this.valider.setVisible(true);
						Selectionutilisateur.this.lblMerciDeSlectionner
								.setVisible(false);

					} catch (final Exception e1) {
						final String message = "Choix Impossible - Merci de vérifier votre sélection";
						final AlerteSelection fenetre = new AlerteSelection(
								Selectionutilisateur.this.interfaceActuelle,
								message);
						fenetre.setVisible(true);
						Selectionutilisateur.this.interfaceActuelle
								.setEnabled(false);
						Selectionutilisateur.this.interfaceActuelle
								.setVisible(false);
						Selectionutilisateur.this.valider.setVisible(false);
						Selectionutilisateur.this.valider.setEnabled(false);
						Selectionutilisateur.this.lblMerciDeSlectionner
								.setVisible(true);

					}
				}
			});
			this.comboBox.setBounds(350, 414, 475, 22);

		}
		return this.comboBox;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(Selectionutilisateur.class
					.getResource("/Images/fonds/menus_accueil-2.png")));
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
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					Selectionutilisateur.this.dispose();
				}
			});
			this.label.setBounds(367, 231, 114, 44);
		}
		return this.label;
	}

	private JLabel getLabel_1() {
		if (this.label_1 == null) {
			this.label_1 = new JLabel("");
			this.label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					Selectionutilisateur.this.dispose();
				}
			});
			this.label_1.setBounds(476, 231, 114, 44);
		}
		return this.label_1;
	}

	private JLabel getLabel_2() {
		if (this.label_2 == null) {
			this.label_2 = new JLabel("");
			this.label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					Selectionutilisateur.this.dispose();
				}
			});
			this.label_2.setBounds(588, 231, 114, 44);
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
					Selectionutilisateur.this.dispose();
				}
			});
			this.label_3.setBounds(702, 231, 114, 44);
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
					Selectionutilisateur.this.dispose();
				}
			});
			this.label_4.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_4.setBounds(876, 231, 179, 44);
		}
		return this.label_4;
	}

	private JLayeredPane getLayeredPane_1() {
		if (this.layeredPane == null) {
			this.layeredPane = new JLayeredPane();
			this.layeredPane.add(this.getLblMerciDeSlectionner());
			this.layeredPane.add(this.getValider());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getComboBox());
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

	private JLabel getLblMerciDeSlectionner() {
		if (this.lblMerciDeSlectionner == null) {
			this.lblMerciDeSlectionner = new JLabel(
					"Merci de s\u00E9lectionner un utilisateur");
			this.lblMerciDeSlectionner
					.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblMerciDeSlectionner.setForeground(Color.GRAY);
			this.lblMerciDeSlectionner.setBounds(488, 418, 235, 14);
		}
		return this.lblMerciDeSlectionner;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 286, 605, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(Selectionutilisateur.class
					.getResource("/Images/fonds/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getValider() {
		if (this.valider == null) {
			this.valider = new JLabel("");
			this.valider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent arg0) {

					switch (Selectionutilisateur.this.selectionprecedente)

					{

					case "Autoriser des magasins pour un utilisateur":

						Control.initUIUserShopsmanagement(Selectionutilisateur.this.utilisateurselectionne, interfaceActuelle);
//						final UserShopsAllowed fenetre = new UserShopsAllowed(Selectionutilisateur.this.utilisateurselectionne, interfaceActuelle);
//						fenetre.setVisible(true);
//						Selectionutilisateur.this.dispose();
						break;

					case "METTRE A JOUR un mot de passe utilisateur":
						final MajMotdepasse fenetre5 = new MajMotdepasse(
								Selectionutilisateur.this.utilisateurselectionne);
						fenetre5.setVisible(true);
						Selectionutilisateur.this.dispose();
						break;

					case "CONSULTER une fiche utilisateur":
						final Consultationficheutilisateur fenetre1 = new Consultationficheutilisateur(
								Selectionutilisateur.this.utilisateurselectionne,
								Selectionutilisateur.this.password);
						fenetre1.setVisible(true);
						Selectionutilisateur.this.dispose();
						break;

					case "SUPPRIMER un utilisateur":
						final deleteuser fenetre3 = new deleteuser(
								Selectionutilisateur.this.utilisateurselectionne);
						fenetre3.setVisible(true);
						Selectionutilisateur.this.dispose();
						break;

					case "METTRE A JOUR un privilege utilisateur":
						final Majprivilege fenetre4 = new Majprivilege(
								Selectionutilisateur.this.utilisateurselectionne);
						fenetre4.setVisible(true);
						Selectionutilisateur.this.dispose();
						break;

					}

				}
			});
			this.valider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.valider.setHorizontalAlignment(SwingConstants.CENTER);
			this.valider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.valider.setIcon(new ImageIcon(Selectionutilisateur.class
					.getResource("/Images/actionbutons/valider.png")));
			this.valider.setBounds(887, 392, 150, 67);
		}
		return this.valider;
	}
}
