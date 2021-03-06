package fr.lefournildesprovinces;

import java.awt.EventQueue;

import javax.swing.UIManager;

import fr.lefournildesprovinces.controler.Control;

public class start {

	/**
	 * this is the entry point of the application
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start launch");
		Boolean checkArgs = true;
		int countArgs = 0;
		for (String s : args) {
			countArgs++;
			// System.out.println("arg "+countArgs+" is \""+s+"\"");
			if (s.equals("with-jws-launcher")) {
				checkArgs = true;
			} else {
				checkArgs = false;
			}
		}
		checkArgs = (countArgs == 1) ? checkArgs : false;
		if (checkArgs == false) {
			System.out
					.print("Launching this way is forbiden. try with the web acces\nprogram stoped with exit code : 0");
//			System.exit(0);
		}

		lookNFeel();
	}

	public static void lookNFeel() {
		/**
		 * set look and feel
		 **/

		System.out.println("load IHM");
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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
					control.initUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
