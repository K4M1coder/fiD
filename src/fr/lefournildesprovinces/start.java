package fr.lefournildesprovinces;

import java.awt.EventQueue;

import javax.swing.UIManager;

import fr.lefournildesprovinces.controler.Control;

public class start {

	/**
	 *  this is the entry point of the application
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		lookNFeel();

	}

	public static void lookNFeel(){
		/**
		 *  set look and feel
		 **/

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		new start();

	}

	/**
	 * Launch the application GUI.
	 */
	public start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control control = new Control();
					control.vueLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
