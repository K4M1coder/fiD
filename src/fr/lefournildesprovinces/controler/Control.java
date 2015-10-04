package fr.lefournildesprovinces.controler;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.vues.admininstartaion.UserShopsAllowed;
import fr.lefournildesprovinces.vues.menus.Login;

public class Control {

	public class Base {

	}

	public void initUI() {

		System.out.println("Control initUILogin invoked");
		final Login fenetre = new Login();
		fenetre.setVisible(true);

	}

	public void initUIUserShopsmanagement(String param, JFrame frame) {
		System.out.println("initUIUserShopsmanagement invoked");
		UserShopsAllowed uiUserShopAllowed = new UserShopsAllowed(param, frame);
		uiUserShopAllowed.setVisible(true);
	}

	public void setUserShopsManagement(Object userShopsToAdd, Object userShopsToDel) {
		// TODO
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

	public static void sortShopsListModel(DefaultListModel<Object> model) {
		{
			List<Magasin> list = new ArrayList<>();
			for (int i = 0; i < model.size(); i++) {
				list.add((Magasin) model.get(i));
			}
			Collections.sort(list);
			model.removeAllElements();
			for (Magasin s : list) {
				model.addElement(s);

			}
		}
	}
}
