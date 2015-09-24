package fr.lefournildesprovinces.controler;

import java.io.File;

import fr.lefournildesprovinces.vues.menus.Login;

public class Control {

	public void vueLogin(){
		System.out.println("Control init invoked");
		final Login fenetre = new Login();
		fenetre.setVisible(true);
	}

	public void readXLSX(){
	//TODO
	}
	public void writeXLSX(File file){
	//TODO
	}

}
