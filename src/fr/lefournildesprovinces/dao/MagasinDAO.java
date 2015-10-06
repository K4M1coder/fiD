package fr.lefournildesprovinces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import fr.lefournildesprovinces.ressources.models.Magasin;

public class MagasinDAO {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	private static Statement stm;

	public static Object[] listemagasinsautorises(final String userName) {
		final Vector<Magasin> result = new Vector<Magasin>();
		try {
			c = Connexion.getCon();
			final String SQL = "select MAGASIN.IDMAGASIN,"
					+ " NOMMAGASIN"
					+ " from MAGASIN"
					+ " inner join GERER on GERER.IDMAGASIN=MAGASIN.IDMAGASIN"
					+ " inner join USERS on USERS.IDUSER=GERER.IDUSER"
					+ " WHERE USERS.IDENTIFIANT=?";

			preStm = c.prepareStatement(SQL);
			preStm.setString(1, userName);
			rs = preStm.executeQuery();
		} catch (final Exception e) {
			System.out.println("erreur" + e.getMessage());
		}
		try {
			result.add(new Magasin());
			Magasin listeMagasins = null;
			while (rs.next()) {
				listeMagasins = new Magasin();
				listeMagasins.setIdMagasin(rs.getInt(1));
				listeMagasins.setNomMagasin(rs.getString(2));
				result.add(listeMagasins);
			}
			rs.close();
			preStm.close();
		} catch (final Exception e) {
			System.out.println("error" + e.getMessage());
		}
		Collections.sort(result);
		return result.toArray(new Object[0]);
	}

	public static Object[] listemagasins() {
		final Vector<Magasin> result = new Vector<Magasin>();
		try {
			c = Connexion.getCon();
			stm = c.createStatement();
			final String SQL = "SELECT IDMAGASIN, NOMMAGASIN FROM MAGASIN";
			rs = stm.executeQuery(SQL);
		} catch (final Exception e) {
			System.out.println("erreur" + e.getMessage());
		}
		try {
			result.add(new Magasin());
			Magasin listeMagasins = null;
			while (rs.next()) {
				listeMagasins = new Magasin();
				listeMagasins.setIdMagasin(rs.getInt(1));
				listeMagasins.setNomMagasin(rs.getString(2));
				result.add(listeMagasins);
			}
			rs.close();
			stm.close();
		} catch (final Exception e) {
			System.out.println("error" + e.getMessage());
		}
		Collections.sort(result);
		return result.toArray(new Object[0]);
	}

	public static void userShopsToAdd(List<Magasin> addShopsList, int iduser) {
			try {
				c = Connexion.getCon();
				c.setAutoCommit(false);

				for (Magasin m : addShopsList) {
					final String sql = "INSERT INTO GERER (IDUSER,IDMAGASIN) VALUES (?,?)";

					preStm = c.prepareStatement(sql);
					preStm.setInt(1, iduser);
					preStm.setInt(2, m.getIdMagasin());
					preStm.executeUpdate();
					preStm.close();
				}

				System.out.println("comminting");
				c.commit();
				c.setAutoCommit(true);
				System.out.println("donne");
			} catch (SQLException e) {
				if (preStm != null){
					try {
						preStm.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
					e.printStackTrace();
			}

	}

	public static void userShopsToDel(List<Magasin> delShopsList, int iduser) {
		try {
			c = Connexion.getCon();
			c.setAutoCommit(false);

			for (Magasin m : delShopsList) {
				final String sql = "DELETE FROM GERER WHERE IDUSER=? and IDMAGASIN=?";

				preStm = c.prepareStatement(sql);
				preStm.setInt(1, iduser);
				preStm.setInt(2, m.getIdMagasin());
				preStm.executeUpdate();
				preStm.close();
			}

			System.out.println("comminting");
			c.commit();
			c.setAutoCommit(true);
			System.out.println("donne");
		} catch (SQLException e) {
			if (preStm != null){
				try {
					preStm.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
				e.printStackTrace();
		}

	}

}
