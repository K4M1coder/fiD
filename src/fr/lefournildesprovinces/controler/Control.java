package fr.lefournildesprovinces.controler;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import fr.lefournildesprovinces.dao.MagasinDAO;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.UtilisateurLogiciel;
import fr.lefournildesprovinces.vues.admininstartaion.UserShopsAllowed;
import fr.lefournildesprovinces.vues.fidelite.SelectionNumeroCarteFidelite2;
import fr.lefournildesprovinces.vues.menus.Login;
import fr.lefournildesprovinces.vues.popups.ConfirmationOperationCarteFidelite;

public class Control {

	public class Base {

	}

	public void initUI() {

		System.out.println("Control initUILogin invoked");
		final Login fenetre = new Login();
		fenetre.setVisible(true);
	}

	public static void initUIUserShopsmanagement(String param, JFrame frame) {
		System.out.println("initUIUserShopsmanagement invoked");
		UserShopsAllowed uiUserShopAllowed = new UserShopsAllowed(param, frame);
		uiUserShopAllowed.setVisible(true);
		frame.dispose();
	}

	public void getUserShopsManagement() {
		// TODO
	}

	public void readXLSX() {
		// TODO
	}

	public void writeXLSX(File file) {
		// TODO
	}

//	public static Object[] shopsAllowedForCurrentUser() {
	public static Object[] listemagasins() {
		final Object[] result;
		if (Login.getPrivilege().equals("administrateur")) {
			result = MagasinDAO.listemagasins();
		} else {
			result = MagasinDAO.listemagasinsautorises(Login.getlogin());
		}
		return result;
	}

	public static List<Magasin> sortShopsListModel(DefaultListModel<Object> model) {
		List<Magasin> list = new ArrayList<>();
		for (int i = 0; i < model.size(); i++) {
			list.add((Magasin) model.get(i));
		}
		Collections.sort(list);
		model.removeAllElements();
		for (Magasin s : list) {
			model.addElement(s);
		}
		return list;
	}

	public static void userShopsAllowedUpdate(DefaultListModel<Object> shopsToAddModel,
			DefaultListModel<Object> shopsToDelModel, UtilisateurLogiciel selecteduser) {
		if (shopsToAddModel.size() > 0) {
			List<Magasin> addList = sortShopsListModel(shopsToAddModel);
			System.out.println("add : " + addList);
			MagasinDAO.userShopsToAdd(addList, Integer.parseInt(selecteduser.getNumeroutilisateur()));
		}
		if (shopsToDelModel.size() > 0) {
			List<Magasin> delList = sortShopsListModel(shopsToDelModel);
			System.out.println("del : " + delList);
			MagasinDAO.userShopsToDel(delList, Integer.parseInt(selecteduser.getNumeroutilisateur()));
		}

	}

	public static void delCard(JFrame interfaceActuelle, String numcarteliste) {
		final ConfirmationOperationCarteFidelite fenetre2 = new ConfirmationOperationCarteFidelite(
				interfaceActuelle,
				numcarteliste,
				"Menu > Gestion Carte de Fidélité > Suppression Fiche Client",
				"Suppression Fiche Client");
		fenetre2.setVisible(true);

	}
}
