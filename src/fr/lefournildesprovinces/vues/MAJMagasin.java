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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import org.apache.commons.validator.routines.EmailValidator;

import fr.lefournildesprovinces.dao.Connexion;
import fr.lefournildesprovinces.dao.Select;
import fr.lefournildesprovinces.ressources.models.MagasinsInfos;
import fr.lefournildesprovinces.ressources.models.Message;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.util.AutoCompletion;
import fr.lefournildesprovinces.vues.menus.Extraction;
import fr.lefournildesprovinces.vues.menus.GestionCarteDeFidelite;
import fr.lefournildesprovinces.vues.menus.MenuPrincipal;
import fr.lefournildesprovinces.vues.menus.choixgestionOC;
import fr.lefournildesprovinces.vues.popups.AlerteSelection;

public class MAJMagasin extends JFrame {

	private static Connection c;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1725578339466407014L;
	private static PreparedStatement stm;
	private String adresse;
	private String codePostal;
	private JComboBox<Object> comboBoxVille;
	private final JPanel contentPane;
	private String fax;
	private JLabel fond;
	private final int idmagasinSelectionne;
	private final int idmagasintest = 0;
	private final int idoperationtest = 0;
	private int idVille;
	private final JFrame interfaceActuelle;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLayeredPane layeredPane;
	private JLabel lblAdresse;
	private JLabel lblCodePostal;
	private JLabel lblEmailMagasin;
	private JLabel lblFax;
	private JLabel lblFermer;
	private JLabel lblLibllMagasin;
	private JLabel lblListeDes;
	private JLabel lblMenuAjouter;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblTelephone;
	private JLabel lblValider;
	private JLabel lblVille;
	private ComboBoxModel<Object> listeville;
	private String mail;
	private MaskFormatter mask;
	private final String messageinsertion2 = null;
	private String nommagasin;
	private final String provenance = "test";
	private String telephone;
	private final String text = "Mise à jour d'un magasin";
	private JTextField textFieldAdresse;
	private JTextField textFieldCodePostal;
	private JTextField textFieldFax = null;
	private JTextField textFieldLibelleMagasin;
	private JTextField textFieldMail = null;
	private JTextField textFieldTelephone;
	private String ville;

	public MAJMagasin(final int selection) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(final WindowEvent arg0) {
				final MagasinsInfos infosMagasin = Select
						.infosMagasins(MAJMagasin.this.idmagasinSelectionne);
				final String nomMagasin = infosMagasin.getNomMagasin();
				final String adresseMagasin = infosMagasin.getAdresseMagasin();
				final String telephonemagasin = infosMagasin
						.getTelephoneMagasin();
				final String faxmagasin = infosMagasin.getFaxMagasin();
				final String mailmagasin = infosMagasin.getMailMagasin();

				MAJMagasin.this.textFieldLibelleMagasin.setText(nomMagasin);
				MAJMagasin.this.textFieldAdresse.setText(adresseMagasin);
				MAJMagasin.this.textFieldTelephone.setText(telephonemagasin);
				MAJMagasin.this.textFieldFax.setText(faxmagasin);
				MAJMagasin.this.textFieldMail.setText(mailmagasin);

				for (int i = 1; i < MAJMagasin.this.comboBoxVille.getModel()
						.getSize(); i++) {

					final String S1 = MAJMagasin.this.comboBoxVille
							.getItemAt(i).toString();
					final String villeMagasin = infosMagasin.getVilleMagasin();
					final String codePostalMagasin = infosMagasin
							.getCodePostalMagasin();
					if (S1.equals(villeMagasin)) {
						MAJMagasin.this.comboBoxVille.setSelectedIndex(i);
						MAJMagasin.this.textFieldCodePostal
								.setText(codePostalMagasin);
						break;
					}

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
		this.setLocationRelativeTo(null);

		this.setResizable(false);
		this.interfaceActuelle = this;
		this.idmagasinSelectionne = selection;
		this.setBackground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
	}

	private JComboBox<Object> getComboBoxVille() {
		if (this.comboBoxVille == null) {
			this.comboBoxVille = new JComboBox<Object>();
			this.comboBoxVille.setBackground(Color.WHITE);
			this.comboBoxVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.comboBoxVille.setForeground(Color.GRAY);

			this.comboBoxVille.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					try {

						final String CP = ((Ville) MAJMagasin.this.comboBoxVille
								.getSelectedItem()).getCodePostalVille();
						MAJMagasin.this.textFieldCodePostal.setText(CP);
					} catch (final Exception e) {

					}
				}
			});

			this.comboBoxVille.setBorder(null);
			this.comboBoxVille.setEditable(true);
			this.comboBoxVille.setBounds(456, 409, 160, 22);

			this.listeville = new DefaultComboBoxModel<Object>(
					Select.listeVille());
			this.comboBoxVille.setModel(this.listeville);
			AutoCompletion.enable(this.comboBoxVille);

		}
		return this.comboBoxVille;
	}

	private JLabel getFond() {
		if (this.fond == null) {
			this.fond = new JLabel("");
			this.fond.setIcon(new ImageIcon(MAJMagasin.class
					.getResource("/Images/menus_magasin.png")));
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
					MAJMagasin.this.dispose();
				}
			});
			this.label
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label.setBounds(236, 231, 114, 44);
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
					MAJMagasin.this.dispose();
				}
			});
			this.label_1.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					final choixgestionOC operation = new choixgestionOC();
					operation.setVisible(true);
					MAJMagasin.this.dispose();
				}
			});
			this.label_2.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.label_2.setBounds(590, 231, 114, 44);
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
					MAJMagasin.this.dispose();
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
			this.layeredPane.add(this.getLblMenuAjouter());
			this.layeredPane.add(this.getLblFermer());
			this.layeredPane.add(this.getLblLibllMagasin());
			this.layeredPane.add(this.getTextFieldLibelleMagasin());
			this.layeredPane.add(this.getLblAdresse());
			this.layeredPane.add(this.getTextField_1());
			this.layeredPane.add(this.getLblVille());
			this.layeredPane.add(this.getLblCodePostal());
			this.layeredPane.add(this.getLblTelephone());
			this.layeredPane.add(this.getComboBoxVille());
			this.layeredPane.add(this.getTextField_1_1());
			this.layeredPane.add(this.getTextFieldCodePostal());
			this.layeredPane.add(this.getLblFax());
			this.layeredPane.add(this.getTextFieldFax());
			this.layeredPane.add(this.getLblValider());
			this.layeredPane.add(this.getLblListeDes());
			this.layeredPane.add(this.getLblEmailMagasin());
			this.layeredPane.add(this.getTextFieldMail());
			this.layeredPane.add(this.getLblNewLabel());
			this.layeredPane.add(this.getLabel());
			this.layeredPane.add(this.getLabel_1());
			this.layeredPane.add(this.getLabel_2());
			this.layeredPane.add(this.getLabel_3());
			this.layeredPane.add(this.getFond());
			this.layeredPane.add(this.getLblNewLabel_1());
		}
		return this.layeredPane;
	}

	private JLabel getLblAdresse() {
		if (this.lblAdresse == null) {
			this.lblAdresse = new JLabel("Adresse *");
			this.lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblAdresse.setForeground(Color.GRAY);
			this.lblAdresse.setBounds(377, 382, 73, 14);
		}
		return this.lblAdresse;
	}

	private JLabel getLblCodePostal() {
		if (this.lblCodePostal == null) {
			this.lblCodePostal = new JLabel("Code Postal *");
			this.lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblCodePostal.setForeground(Color.GRAY);
			this.lblCodePostal.setBounds(630, 413, 86, 14);
		}
		return this.lblCodePostal;
	}

	private JLabel getLblEmailMagasin() {
		if (this.lblEmailMagasin == null) {
			this.lblEmailMagasin = new JLabel("Email Magasin");
			this.lblEmailMagasin.setForeground(Color.GRAY);
			this.lblEmailMagasin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblEmailMagasin.setBounds(353, 478, 97, 14);
		}
		return this.lblEmailMagasin;
	}

	private JLabel getLblFax() {
		if (this.lblFax == null) {
			this.lblFax = new JLabel(" Fax ");
			this.lblFax.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblFax.setForeground(Color.GRAY);
			this.lblFax.setBounds(630, 447, 41, 14);
		}
		return this.lblFax;
	}

	private JLabel getLblFermer() {
		if (this.lblFermer == null) {
			this.lblFermer = new JLabel("");
			this.lblFermer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					final MenuPrincipal fenetre = new MenuPrincipal();
					fenetre.setVisible(true);
					MAJMagasin.this.dispose();
				}
			});
			this.lblFermer.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblFermer.setForeground(Color.GRAY);
			this.lblFermer.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblFermer.setBounds(864, 231, 189, 48);
		}
		return this.lblFermer;
	}

	private JLabel getLblLibllMagasin() {
		if (this.lblLibllMagasin == null) {
			this.lblLibllMagasin = new JLabel("Libell\u00E9 Magasin *");
			this.lblLibllMagasin.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblLibllMagasin.setForeground(Color.GRAY);
			this.lblLibllMagasin.setBounds(337, 351, 113, 14);
		}
		return this.lblLibllMagasin;
	}

	private JLabel getLblListeDes() {
		if (this.lblListeDes == null) {
			this.lblListeDes = new JLabel("* Champs Obligatoires");
			this.lblListeDes.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblListeDes.setForeground(Color.GRAY);
			this.lblListeDes.setBounds(232, 530, 150, 14);
		}
		return this.lblListeDes;
	}

	private JLabel getLblMenuAjouter() {
		if (this.lblMenuAjouter == null) {
			this.lblMenuAjouter = new JLabel("Menu > Mise \u00E0 Jour Magasin");
			this.lblMenuAjouter.setVisible(false);
			this.lblMenuAjouter.setForeground(Color.GRAY);
			this.lblMenuAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblMenuAjouter.setBounds(242, 326, 136, 14);
		}
		return this.lblMenuAjouter;
	}

	private JLabel getLblNewLabel() {
		if (this.lblNewLabel == null) {
			this.lblNewLabel = new JLabel("Mise \u00E0 jour d'un magasin");
			this.lblNewLabel.setForeground(Color.GRAY);
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblNewLabel.setBounds(242, 287, 189, 14);
		}
		return this.lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (this.lblNewLabel_1 == null) {
			this.lblNewLabel_1 = new JLabel("");
			this.lblNewLabel_1.setIcon(new ImageIcon(MAJMagasin.class
					.getResource("/Images/fond-logiciel.png")));
			this.lblNewLabel_1.setBounds(0, 0, 1281, 800);
		}
		return this.lblNewLabel_1;
	}

	private JLabel getLblTelephone() {
		if (this.lblTelephone == null) {
			this.lblTelephone = new JLabel("Telephone *");
			this.lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblTelephone.setForeground(Color.GRAY);
			this.lblTelephone.setBounds(364, 447, 86, 14);
		}
		return this.lblTelephone;
	}

	private JLabel getLblValider() {
		if (this.lblValider == null) {
			this.lblValider = new JLabel("");
			this.lblValider.setHorizontalTextPosition(SwingConstants.CENTER);
			this.lblValider.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblValider.setIcon(new ImageIcon(MAJMagasin.class
					.getResource("/Images/valider.png")));
			this.lblValider.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					boolean verification = true;
					String message = null;
					try {

						MAJMagasin.this.nommagasin = MAJMagasin.this.textFieldLibelleMagasin
								.getText().toUpperCase();
						MAJMagasin.this.adresse = MAJMagasin.this.textFieldAdresse
								.getText().toUpperCase();
						MAJMagasin.this.ville = MAJMagasin.this.comboBoxVille
								.getSelectedItem().toString().toUpperCase();
						MAJMagasin.this.idVille = ((Ville) MAJMagasin.this.comboBoxVille
								.getSelectedItem()).getIdville();
						MAJMagasin.this.codePostal = MAJMagasin.this.textFieldCodePostal
								.getText();
						MAJMagasin.this.telephone = MAJMagasin.this.textFieldTelephone
								.getText();
						MAJMagasin.this.fax = null;
						MAJMagasin.this.mail = null;

						if (!MAJMagasin.this.textFieldFax.getText().isEmpty()) {
							MAJMagasin.this.fax = MAJMagasin.this.textFieldFax
									.getText();
							if (MAJMagasin.this.fax.length() != 10) {
								verification = false;
								message = "Merci de vérifier votre numéro de Fax, il doit contenir 10 chiffres";

							}

						}

						if (!MAJMagasin.this.textFieldMail.getText().isEmpty()) {

							MAJMagasin.this.mail = MAJMagasin.this.textFieldMail
									.getText();
							if (!EmailValidator.getInstance().isValid(
									MAJMagasin.this.mail)) {
								verification = false;
								message = "Merci de vérifier l'adresse mail saisie";

							}
						}

						if (MAJMagasin.this.nommagasin.length() == 0) {
							verification = false;
							message = "Merci de vérifier le nom du magasin, ce champs ne peut être vide";

						}
						if (MAJMagasin.this.adresse.isEmpty()) {
							verification = false;
							message = "Merci de vérifier l'adresse saisie";

						}

						if (MAJMagasin.this.codePostal.isEmpty()
								|| (MAJMagasin.this.codePostal.length() < 5)) {
							verification = false;
							message = "Merci de vérifier le Code Postal, pour infos il doit contenir 5 chiffres";

						}

						if (MAJMagasin.this.telephone.isEmpty()
								|| (MAJMagasin.this.telephone.length() != 10)) {
							verification = false;
							message = "Merci de vérifier le n°de telephone, pour infos il doit contenir 10 chiffres";

						}

						for (int i = 0; i < MAJMagasin.this.telephone.length(); i++) {

							if (!Character.isDigit(MAJMagasin.this.telephone
									.charAt(i)))

							{
								verification = false;
								message = "Merci de vérifier le n°de telephone, pour infos il ne doit pas contenir de lettres";
								break;
							}

						}

						for (int i = 0; i < MAJMagasin.this.codePostal.length(); i++) {

							if (!Character.isDigit(MAJMagasin.this.codePostal
									.charAt(i)))

							{
								verification = false;
								message = "Merci de vérifier le code Postal, il ne doit 5 Chiffres et aucune lettre";
								break;
							}

						}

					} catch (final Exception e1) {
						verification = false;
						message = "Merci de selectionner une ville dans la liste";
					}

					if (verification == true) {
						System.out.print("succes insertion possible");
						try {
							c = Connexion.getCon();

							final String sql = "UPDATE MAGASIN SET  IDVILLE=?, NOMMAGASIN=?, ADRESSEMAGASIN=?, TELEPHONEMAGASIN=?, FAXMAGASIN=?, MAILMAGASIN=? WHERE IDMAGASIN=?";

							stm = c.prepareStatement(sql);

							System.out.print(MAJMagasin.this.nommagasin
									+ MAJMagasin.this.adresse
									+ MAJMagasin.this.ville
									+ MAJMagasin.this.codePostal
									+ MAJMagasin.this.telephone
									+ MAJMagasin.this.fax
									+ MAJMagasin.this.mail);

							// update avec prepared statement

							stm.setInt(1, MAJMagasin.this.idVille);
							stm.setString(2, MAJMagasin.this.nommagasin);
							stm.setString(3, MAJMagasin.this.adresse);
							stm.setString(4, MAJMagasin.this.telephone);
							stm.setString(5, MAJMagasin.this.fax);
							stm.setString(6, MAJMagasin.this.mail);
							stm.setInt(7, MAJMagasin.this.idmagasinSelectionne);

							stm.executeUpdate();

							final String messageInsertion = "Magasin "
									+ MAJMagasin.this.nommagasin
									+ " mis à jour avec succès";
							System.out.print(messageInsertion);
							final boolean etat = true;
							Message.setMessageaffichagefond(MAJMagasin.this.text);
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									messageInsertion, etat,
									MAJMagasin.this.text,
									MAJMagasin.this.messageinsertion2,
									MAJMagasin.this.provenance,
									MAJMagasin.this.idoperationtest,
									MAJMagasin.this.idmagasintest);
							fenetre.setVisible(true);
							fenetre.setAlwaysOnTop(true);
							MAJMagasin.this.dispose();

						} catch (final Exception e1)

						{
							System.out.print("erreur" + e1.getMessage());
							final String messageInsertion = "Impossible de mettre à jour le magasin "
									+ MAJMagasin.this.nommagasin;
							System.out.print(messageInsertion);
							final boolean etat = false;
							Message.setMessageaffichagefond(MAJMagasin.this.text);
							final SuccesMagasinOperation fenetre = new SuccesMagasinOperation(
									messageInsertion, etat,
									MAJMagasin.this.text,
									MAJMagasin.this.messageinsertion2,
									MAJMagasin.this.provenance,
									MAJMagasin.this.idoperationtest,
									MAJMagasin.this.idmagasintest);
							fenetre.setVisible(true);

							fenetre.setAlwaysOnTop(true);
							MAJMagasin.this.dispose();
						}
						try {

							if (stm != null) {
								stm.close();
							}

						} catch (final Exception e3) {
							e3.printStackTrace();
						}
					}

					else

					{
						System.out.print("impossible");

						final AlerteSelection fenetre = new AlerteSelection(
								MAJMagasin.this.interfaceActuelle, message);
						fenetre.setVisible(true);
						MAJMagasin.this.interfaceActuelle.setEnabled(false);
					}

				}
			});
			this.lblValider.setCursor(Cursor
					.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.lblValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblValider.setForeground(Color.GRAY);
			this.lblValider.setBounds(864, 441, 150, 89);
		}
		return this.lblValider;
	}

	private JLabel getLblVille() {
		if (this.lblVille == null) {
			this.lblVille = new JLabel("Ville *");
			this.lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.lblVille.setForeground(Color.GRAY);
			this.lblVille.setBounds(400, 413, 50, 14);
		}
		return this.lblVille;
	}

	private JTextField getTextField_1() {
		if (this.textFieldAdresse == null) {
			this.textFieldAdresse = new JTextField();
			this.textFieldAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldAdresse.setForeground(Color.GRAY);
			this.textFieldAdresse.setBackground(Color.WHITE);
			this.textFieldAdresse.setBorder(new LineBorder(new Color(171, 173,
					179)));
			this.textFieldAdresse.setBounds(456, 379, 385, 20);
			this.textFieldAdresse.setColumns(10);
		}
		return this.textFieldAdresse;
	}

	private JTextField getTextField_1_1() {
		if (this.textFieldTelephone == null) {
			try {
				this.mask = new MaskFormatter("##########");
				this.mask.setValidCharacters("0123456789");
			} catch (final ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.textFieldTelephone = new JTextField();
			this.textFieldTelephone.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldTelephone.setForeground(Color.GRAY);
			this.textFieldTelephone.setBackground(Color.WHITE);
			this.textFieldTelephone.setBorder(new LineBorder(new Color(171,
					173, 179)));
			this.textFieldTelephone.setBounds(456, 444, 160, 20);
			this.textFieldTelephone.setColumns(10);
		}
		return this.textFieldTelephone;
	}

	private JTextField getTextFieldCodePostal() {
		if (this.textFieldCodePostal == null) {

			this.textFieldCodePostal = new JTextField();
			this.textFieldCodePostal.setEditable(false);
			this.textFieldCodePostal.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldCodePostal.setForeground(Color.GRAY);
			this.textFieldCodePostal.setBackground(Color.WHITE);
			this.textFieldCodePostal.setBorder(new LineBorder(new Color(171,
					173, 179)));
			this.textFieldCodePostal.setBounds(716, 410, 125, 20);
			this.textFieldCodePostal.setColumns(10);
		}
		return this.textFieldCodePostal;
	}

	private JTextField getTextFieldFax() {
		if (this.textFieldFax == null) {

			this.textFieldFax = new JTextField();
			this.textFieldFax.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldFax.setForeground(Color.GRAY);
			this.textFieldFax
					.setBorder(new LineBorder(new Color(171, 173, 179)));
			this.textFieldFax.setBounds(681, 444, 160, 20);
			this.textFieldFax.setColumns(10);
		}
		return this.textFieldFax;
	}

	private JTextField getTextFieldLibelleMagasin() {
		if (this.textFieldLibelleMagasin == null) {
			this.textFieldLibelleMagasin = new JTextField();
			this.textFieldLibelleMagasin.setFont(new Font("Tahoma", Font.BOLD,
					11));

			this.textFieldLibelleMagasin.setForeground(Color.GRAY);
			this.textFieldLibelleMagasin.setBorder(new LineBorder(new Color(
					171, 173, 179)));
			this.textFieldLibelleMagasin.setBackground(Color.WHITE);
			this.textFieldLibelleMagasin.setBounds(456, 348, 385, 20);
			this.textFieldLibelleMagasin.setColumns(10);
		}
		return this.textFieldLibelleMagasin;
	}

	private JTextField getTextFieldMail() {
		if (this.textFieldMail == null) {
			this.textFieldMail = new JTextField();
			this.textFieldMail.setFont(new Font("Tahoma", Font.BOLD, 11));
			this.textFieldMail.setForeground(Color.GRAY);
			this.textFieldMail.setBorder(new LineBorder(
					new Color(171, 173, 179)));
			this.textFieldMail.setBounds(456, 475, 385, 20);
			this.textFieldMail.setColumns(10);
		}
		return this.textFieldMail;
	}
}
