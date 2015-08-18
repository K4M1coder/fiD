package fr.lefournildesprovinces.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Properties;

public class Connexion {

	static Connection con = null;

	public static Connection connect() {

		String driverClassName = "com.mysql.jdbc.Driver";
		Class<?> driverClass;
		Driver d;
		try {
			System.out.println("Loading MySQL driver...");
			driverClass = Class.forName(driverClassName, true, Thread
					.currentThread().getContextClassLoader());
			d = (Driver) driverClass.newInstance();
			ArrayList<String> listParams = new ArrayList<String>(SQLCredentials.getList());

// the SQLCredentials.java should be like this :
//
//			import java.util.ArrayList;
//
//			public class SQLCredentials {
//
//				public static ArrayList<String> getList() {
//					ArrayList<String> listParams = new ArrayList<String>();
//					listparams.add("*://"); // Driver
//					listparams.add("*"); // Server_name
//					listparams.add(":*"); // Port
//					listparams.add("/*"); // database_name
//					listparams.add("*"); // SQL_username
//					listparams.add("*"); // SQL_password
//					return listParams;
//				}
//			}

			Properties connectProperties = new Properties();
			connectProperties.put("user", listParams.get(4));
			connectProperties.put("password", listParams.get(5));
			con = d.connect(listParams.get(0)+listParams.get(1)+listParams.get(2)+listParams.get(3),
					connectProperties);

		} catch (Exception e) {
			System.out.println("##### Connection failed #####" + e.getMessage());
			e.printStackTrace();
		}

		return con;

		// try {
		// System.out.println("Loading driver...");
		// Class.forName("com.mysql.jdbc.Driver");
		// System.out.println("Driver loaded!");
		// } catch (final ClassNotFoundException e) {
		// throw new RuntimeException(
		// "Cannot find the driver in the classpath!", e);
		// }
		//
		// try {
		//
		// final String url = "jdbc:mysql://127.0.0.1:3306/fournil_fid";
		// con = DriverManager.getConnection(url, "root",
		// "password");
		//
		// return con;
		//
		// } catch (final Exception e)
		//
		// {
		// System.out
		// .println("##### Connection failed #####" + e.getMessage());
		// return con = null;
		// }
	}

	// private ClassLoader getClassLoader()
	// {
	// if( classLoader == null )
	// {
	// classLoader = this.getClass().getClassLoader();
	// }
	// return classLoader;
	// }

	public static Connection getCon() {
		if (con == null) {
			connect();
		}
		return con;

	}
}
