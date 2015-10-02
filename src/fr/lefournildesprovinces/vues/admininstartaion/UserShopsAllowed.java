package fr.lefournildesprovinces.vues.admininstartaion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.vues.menus.GestionCartesDeFidelite;
import fr.lefournildesprovinces.vues.menus.GestionExtractionBases;
import fr.lefournildesprovinces.vues.menus.GestionMagasins;
import fr.lefournildesprovinces.vues.menus.GestionOperationsCommerciales;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;

public class UserShopsAllowed extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 6340878408145735684L;

	/**
	 *
	 */
	private DefaultListModel<Object> availableShopsModel;
	private JButton btn_AddAll;
	private JButton btn_AddOne;
	private JButton btn_DelAll;
	private JButton btn_DelOne;
	private JLabel action_Menu_Acceuil;
	private JLabel action_Menu_Extraction;
	private JLabel action_Menu_Fidelite;
	private JLabel action_Menu_Magasin;
	private JLabel action_Menu_OperationsCommerciales;
	private JLabel action_Retour;
	private JLabel action_Valider;
	private JLabel ariane;
	private JLabel background;
	private JLabel fond;
	private JLabel lblFieldPrivilege;
	private JLabel lblFieldUser;
	private JLabel lblTextPrivilege;
	private JLabel lblTextUser;
	private JLabel lbl_AddShops;
	private JLabel lbl_AllShops;
	private JLabel lbl_AllowedShops;
	private JLabel lbl_DelShops;
	private JLayeredPane layeredPane_Base;
	private JList<Object> list_AllowedShops;
	private JList<Object> list_AvailableShops;
	private JScrollPane scrollPane_AllowedShops;
	private JScrollPane scrollPane_Shops;
	private JTextPane lbl_Note;
	private final JFrame interfaceActuelle;
	private final JFrame interfacePrecedente;
	private final JPanel contentPane;
	private final String selecteduser;

	private DefaultListModel<Object> allowedShopsModel;

	public UserShopsAllowed(final String utilisateurselectionne, final JFrame interfacePrecedente) {
		this.selecteduser = utilisateurselectionne;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {

				// TODO
			}
		});
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 800);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(this.contentPane);
		this.contentPane.add(this.getLayeredPane_Base(), BorderLayout.CENTER);
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		this.interfacePrecedente = interfacePrecedente;
		this.interfaceActuelle = this;
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private JLabel getAction_Retour() {
		if (this.action_Retour == null) {
			this.action_Retour = new JLabel("");
			this.action_Retour.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					UserShopsAllowed.this.interfacePrecedente.setEnabled(true);
					UserShopsAllowed.this.interfacePrecedente.setVisible(true);
					UserShopsAllowed.this.dispose();

				}
			});
			this.action_Retour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.action_Retour.setBounds(876, 231, 179, 44);
		}
		return this.action_Retour;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(UserShopsAllowed.class.getResource("/Images/fonds/menus_accueil-2.png")));
			this.fond.setBounds(216, 231, 850, 338);
		}
		return this.fond;
	}

	private JLabel getLbl_TextUser() {
		if (this.lblTextUser == null) {
			this.lblTextUser = new JLabel("L'utilisateur :");
			lblTextUser.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblTextUser.setForeground(Color.GRAY);
			this.lblTextUser.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTextUser.setBounds(735, 348, 101, 14);
		}
		return this.lblTextUser;
	}

	private JLabel getLbl_FieldUser() {
		if (this.lblFieldUser == null) {
			this.lblFieldUser = new JLabel(this.selecteduser);
			lblFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblFieldUser.setForeground(Color.GRAY);
			this.lblFieldUser.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblFieldUser.setBounds(846, 348, 150, 14);
		}
		return this.lblFieldUser;
	}

	private JLabel getLbl_TextPrivilege() {
		if (this.lblTextPrivilege == null) {
			this.lblTextPrivilege = new JLabel("avec le privilege :");
			lblTextPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblTextPrivilege.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTextPrivilege.setForeground(Color.GRAY);
			this.lblTextPrivilege.setBounds(735, 378, 101, 14);
		}
		return this.lblTextPrivilege;
	}

	private JLabel getLbl_FieldPrivilege() {
		if (this.lblFieldPrivilege == null) {
			this.lblFieldPrivilege = new JLabel("UTILISATEUR");
			lblFieldPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblFieldPrivilege.setForeground(Color.GRAY);
			this.lblFieldPrivilege.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblFieldPrivilege.setBounds(846, 378, 150, 14);
		}
		return this.lblFieldPrivilege;
	}

	private JTextPane getTextPane_Note() {
		if (this.lbl_Note == null) {
			this.lbl_Note = new JTextPane();
			lbl_Note.setBackground(Color.YELLOW);
			lbl_Note.setText("ne pourra acceder qu'aux magasins qui lui sont attribués");
			this.lbl_Note.setForeground(new Color(139, 69, 19));
			this.lbl_Note.setFont(new Font("Tahoma", Font.BOLD, 12));
			this.lbl_Note.setBounds(735, 412, 261, 36);
			StyledDocument doc = this.lbl_Note.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		return this.lbl_Note;
	}

	private JButton getJBtn_AddAll() {
		if (this.btn_AddAll == null) {
			this.btn_AddAll = new JButton("> Tous >");
			this.btn_AddAll.setBounds(435, 408, 85, 23);
		}
		return this.btn_AddAll;
	}

	private JButton getJBtn_AddOne() {
		if (this.btn_AddOne == null) {
			this.btn_AddOne = new JButton("> 1 >");
			this.btn_AddOne.setBounds(435, 374, 85, 23);
		}
		return this.btn_AddOne;
	}

	private JButton getJBtn_DelAll() {
		if (this.btn_DelAll == null) {
			this.btn_DelAll = new JButton("< Tous <");
			this.btn_DelAll.setBounds(435, 518, 85, 23);
		}
		return this.btn_DelAll;
	}

	private JButton getJBtn_DelOne() {
		if (this.btn_DelOne == null) {
			this.btn_DelOne = new JButton("< 1 <");
			this.btn_DelOne.setBounds(435, 484, 85, 23);
		}
		return this.btn_DelOne;
	}

	private JLayeredPane getLayeredPane_Base() {
		if (this.layeredPane_Base == null) {
			this.layeredPane_Base = new JLayeredPane();
			this.layeredPane_Base.add(this.getLbl_Valider());
			this.layeredPane_Base.add(this.getTextPane_Note());
			this.layeredPane_Base.add(this.getLbl_TextUser());
			this.layeredPane_Base.add(this.getLbl_FieldUser());
			this.layeredPane_Base.add(this.getLbl_TextPrivilege());
			this.layeredPane_Base.add(this.getLbl_FieldPrivilege());
			this.layeredPane_Base.add(this.getLbl_AddShops());
			this.layeredPane_Base.add(this.getLbl_DelShops());
			this.layeredPane_Base.add(this.getJBtn_AddOne());
			this.layeredPane_Base.add(this.getJBtn_AddAll());
			this.layeredPane_Base.add(this.getJBtn_DelOne());
			this.layeredPane_Base.add(this.getJBtn_DelAll());
			this.layeredPane_Base.add(this.getLbl_allowedShops());
			this.layeredPane_Base.add(this.getLbl_allShops());
			this.layeredPane_Base.add(this.getScrollPane_AllowedShops());
			this.layeredPane_Base.add(this.getScrollPane_Shops());
			this.layeredPane_Base.add(this.getLbl_Ariane());
			this.layeredPane_Base.add(this.getMenu_Acceuil());
			this.layeredPane_Base.add(this.getMenu_Fidelite());
			this.layeredPane_Base.add(this.getMenu_Magasin());
			this.layeredPane_Base.add(this.getMenu_OperationsCommerciales());
			this.layeredPane_Base.add(this.getMenu_Extraction());
			this.layeredPane_Base.add(this.getAction_Retour());
			this.layeredPane_Base.add(this.getFond());
			this.layeredPane_Base.add(this.getLblBackground());

		}
		return this.layeredPane_Base;
	}

	private JLabel getLbl_allowedShops() {
		if (this.lbl_AllowedShops == null) {
			this.lbl_AllowedShops = new JLabel("Magasins attribués");
			lbl_AllowedShops.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbl_AllowedShops.setForeground(Color.GRAY);
			this.lbl_AllowedShops.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lbl_AllowedShops.setBounds(530, 322, 179, 14);
		}
		return this.lbl_AllowedShops;
	}

	private JLabel getLbl_AddShops() {
		if (this.lbl_AddShops == null) {
			this.lbl_AddShops = new JLabel("Ajouter");
			lbl_AddShops.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbl_AddShops.setForeground(Color.GRAY);
			this.lbl_AddShops.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lbl_AddShops.setBounds(435, 348, 85, 14);
		}
		return this.lbl_AddShops;
	}

	private JLabel getLbl_DelShops() {
		if (this.lbl_DelShops == null) {
			this.lbl_DelShops = new JLabel("Supprimer");
			lbl_DelShops.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbl_DelShops.setForeground(Color.GRAY);
			this.lbl_DelShops.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lbl_DelShops.setBounds(435, 459, 85, 14);
		}
		return this.lbl_DelShops;
	}

	private JLabel getLbl_allShops() {
		if (this.lbl_AllShops == null) {
			this.lbl_AllShops = new JLabel("Liste des magasins");
			lbl_AllShops.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbl_AllShops.setForeground(Color.GRAY);
			this.lbl_AllShops.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lbl_AllShops.setBounds(246, 322, 179, 14);
		}
		return this.lbl_AllShops;
	}

	private JLabel getLbl_Ariane() {
		if (this.ariane == null) {
			this.ariane = new JLabel("ADMINISTRATION > PROFIL > Attribuer des magasins");
			this.ariane.setForeground(Color.GRAY);
			this.ariane.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.ariane.setBounds(242, 286, 624, 14);
		}
		return this.ariane;
	}

	private JLabel getLbl_Valider() {
		if (this.action_Valider == null) {
			this.action_Valider = new JLabel("");
			this.action_Valider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.action_Valider.setHorizontalAlignment(SwingConstants.CENTER);
			this.action_Valider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.action_Valider.setIcon(new ImageIcon(UserShopsAllowed.class.getResource("/Images/actionbutons/valider.png")));
			this.action_Valider.setBounds(811, 484, 108, 33);
			this.action_Valider.setVisible(true);
			this.action_Valider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					validateAction();
				}
			});


		}
		return this.action_Valider;
	}

	private JLabel getLblBackground() {
		if (this.background == null) {
			this.background = new JLabel("");
			this.background
					.setIcon(new ImageIcon(Selectionutilisateur.class.getResource("/Images/fonds/fond-logiciel.png")));
			this.background.setBounds(0, 0, 1281, 800);
		}
		return this.background;
	}

	private JLabel getMenu_Acceuil() {
		if (this.action_Menu_Acceuil == null) {
			this.action_Menu_Acceuil = new JLabel("");
			this.action_Menu_Acceuil.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.action_Menu_Acceuil.setBounds(242, 231, 114, 44);
		}
		return this.action_Menu_Acceuil;
	}

	private JLabel getMenu_Extraction() {
		if (this.action_Menu_Extraction == null) {
			this.action_Menu_Extraction = new JLabel("");
			this.action_Menu_Extraction.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionExtractionBases collecte = new GestionExtractionBases();
					collecte.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.action_Menu_Extraction.setBounds(702, 231, 114, 44);
		}
		return this.action_Menu_Extraction;
	}

	private JLabel getMenu_Fidelite() {
		if (this.action_Menu_Fidelite == null) {
			this.action_Menu_Fidelite = new JLabel("");
			this.action_Menu_Fidelite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionCartesDeFidelite gestionclientcarte = new GestionCartesDeFidelite();
					gestionclientcarte.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.action_Menu_Fidelite.setBounds(367, 231, 114, 44);
		}
		return this.action_Menu_Fidelite;
	}

	private JLabel getMenu_Magasin() {
		if (this.action_Menu_Magasin == null) {
			this.action_Menu_Magasin = new JLabel("");
			this.action_Menu_Magasin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionMagasins gestionMagasin = new GestionMagasins();
					gestionMagasin.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.action_Menu_Magasin.setBounds(476, 231, 114, 44);
		}
		return this.action_Menu_Magasin;
	}

	private JLabel getMenu_OperationsCommerciales() {
		if (this.action_Menu_OperationsCommerciales == null) {
			this.action_Menu_OperationsCommerciales = new JLabel("");
			this.action_Menu_OperationsCommerciales.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final GestionOperationsCommerciales operation = new GestionOperationsCommerciales();
					operation.setVisible(true);
					UserShopsAllowed.this.dispose();
				}
			});
			this.action_Menu_OperationsCommerciales.setBounds(588, 231, 114, 44);
		}
		return this.action_Menu_OperationsCommerciales;
	}

	private JScrollPane getScrollPane_AllowedShops() {
		if (this.scrollPane_AllowedShops == null) {
			this.scrollPane_AllowedShops = new JScrollPane();
			this.scrollPane_AllowedShops.setBorder(null);
			this.scrollPane_AllowedShops.setBounds(530, 348, 179, 194);
			this.scrollPane_AllowedShops.setViewportView(this.getList_AllowedShops());
		}
		return this.scrollPane_AllowedShops;
	}

	private JScrollPane getScrollPane_Shops() {
		if (this.scrollPane_Shops == null) {
			this.scrollPane_Shops = new JScrollPane();
			this.scrollPane_Shops.setBorder(null);
			this.scrollPane_Shops.setBounds(246, 347, 179, 194);
			this.scrollPane_Shops.setViewportView(this.getList_Shops());

		}
		return this.scrollPane_Shops;
	}

	private JList<Object> getList_AllowedShops() {
		if (this.list_AllowedShops == null) {
			this.allowedShopsModel = new DefaultListModel<Object>();
			this.list_AllowedShops = new JList<Object>(allowedShopsModel);
			this.list_AllowedShops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			for (Object o : Select.listemagasinsautorises(this.selecteduser)) {
				if (!o.toString().equals("")) {
					this.allowedShopsModel.addElement(o);
				}
			}

		}
		return this.list_AllowedShops;
	}

	private JList<Object> getList_Shops() {
		if (this.list_AvailableShops == null) {
			this.availableShopsModel = new DefaultListModel<Object>();
			this.list_AvailableShops = new JList<Object>(availableShopsModel);
			this.list_AvailableShops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			System.out.println("allowed "+ this.allowedShopsModel.getSize() +" shops are " + this.allowedShopsModel);
			for (Object o : Select.listemagasins()) {
				if (!o.toString().equals("")) {
					System.out.print("check if " + o + " is allowed :");
					DefaultListModel<Object> allowed = (DefaultListModel<Object>) this.list_AllowedShops.getModel();
					System.out.println(allowed.contains(o));
					if (!this.allowedShopsModel.contains(o)) { // need to override equals to make this working as i expect. look at Magasin class
						this.availableShopsModel.addElement(o);
					}
				}

			}

		}
		return this.list_AvailableShops;
	}

	private void validateAction() {

		UserShopsAllowed.this.interfaceActuelle.setEnabled(false);
	}
}
