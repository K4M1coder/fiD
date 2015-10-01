package fr.lefournildesprovinces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;

import fr.lefournildesprovinces.ressources.models.ClientOperationCommerciale;
import fr.lefournildesprovinces.ressources.models.Clientcartedefidelite;
import fr.lefournildesprovinces.ressources.models.DateNaissanceClient;
import fr.lefournildesprovinces.ressources.models.Magasin;
import fr.lefournildesprovinces.ressources.models.MagasinsInfos;
import fr.lefournildesprovinces.ressources.models.NomClient;
import fr.lefournildesprovinces.ressources.models.OperationCommerciale;
import fr.lefournildesprovinces.ressources.models.OperationCommercialeInfos;
import fr.lefournildesprovinces.ressources.models.PrenomClient;
import fr.lefournildesprovinces.ressources.models.ResultatRecherche;
import fr.lefournildesprovinces.ressources.models.UtilisateursLogiciel;
import fr.lefournildesprovinces.ressources.models.Ville;
import fr.lefournildesprovinces.ressources.models.infosparticipation;

public class Select {

	private static Connection c;
	private static PreparedStatement preStm;
	private static ResultSet rs;
	private static Statement stm;

	public static Vector<ResultatRecherche> eMailinganniversaire(final String valeurCasechoix,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{

		System.out.println("=======" + valeurCasechoix.length() + "=========");
		System.out.println(valeurCasechoix);

		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (valeurCasechoix.length() == 2) {
			if (boutoncochetous == true) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT  CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%m')=? GROUP BY CLIENT.IDCLIENT ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
			if (boutoncochetous == false) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT  CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%m')=? AND FREQUENTER.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);
					preStm.setInt(2, magasinidSelectionne);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
		}
		if (valeurCasechoix.equals("TOUS")) {
			if (boutoncochetous == true) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT GROUP BY CLIENT.IDCLIENT ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
			if (boutoncochetous == false) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT  CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE FREQUENTER.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setInt(1, magasinidSelectionne);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
		}
		if (valeurCasechoix.length() > 4) {
			if (boutoncochetous == true) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%m/%d')=? GROUP BY CLIENT.IDCLIENT ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
			if (boutoncochetous == false) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT  CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%m/%d')=? AND FREQUENTER.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);
					preStm.setInt(2, magasinidSelectionne);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
		}
		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setNumerocarte(rs.getString(11));
				liste.setTelephonefixe(rs.getString(12));
				liste.setTelephonemobile(rs.getString(13));
				liste.setAge(rs.getString(14));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailinganniversaireSansCarte(final String valeurCasechoix,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{

		System.out.println("=======" + valeurCasechoix.length() + "=========");

		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (valeurCasechoix.length() == 2) {
			if (boutoncochetous == true) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT DISTINCT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%M')=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
			if (boutoncochetous == false) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT DISTINCT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%M')=? AND FREQUENTER.IDMAGASIN=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);
					preStm.setInt(2, magasinidSelectionne);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
		}
		if (valeurCasechoix.equals("TOUS")) {
			if (boutoncochetous == true) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT DISTINCT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
			if (boutoncochetous == false) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT DISTINCT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE FREQUENTER.IDMAGASIN=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setInt(1, magasinidSelectionne);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
		}
		if (valeurCasechoix.length() > 4) {
			if (boutoncochetous == true) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT DISTINCT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%M/%D')=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
			if (boutoncochetous == false) {
				try {

					c = Connexion.getCon();
					final String SQL = "SELECT DISTINCT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE DATE_FORMAT(DATENAISSANCECLIENT, '%M/%D')=? AND FREQUENTER.IDMAGASIN=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) ORDER BY DATENAISSANCECLIENT ASC ";
					preStm = c.prepareStatement(SQL);

					preStm.setString(1, valeurCasechoix);
					preStm.setInt(2, magasinidSelectionne);

					rs = preStm.executeQuery();
				} catch (final Exception e) {

					System.out.println("erreur" + e.getMessage());
				}
			}
		}
		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingmagasin(final int magasinidSelectionne)

	{

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE MAGASIN.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, magasinidSelectionne);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setNumerocarte(rs.getString(11));
				liste.setTelephonefixe(rs.getString(12));
				liste.setTelephonemobile(rs.getString(13));
				liste.setAge(rs.getString(14));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingmagasinSansCarte(final int magasinidSelectionne)

	{

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE MAGASIN.IDMAGASIN=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, magasinidSelectionne);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingoperationcommerciale(final int idoperationcommerciale,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{
		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (boutoncochetous == true) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE PARTICIPER.IDOPERATIONCOMMERCIALE=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, idoperationcommerciale);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}
		if (boutoncochetous == false) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE PARTICIPER.IDOPERATIONCOMMERCIALE=? AND PARTICIPER.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, idoperationcommerciale);
				preStm.setInt(2, magasinidSelectionne);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setNumerocarte(rs.getString(11));
				liste.setTelephonefixe(rs.getString(12));
				liste.setTelephonemobile(rs.getString(13));
				liste.setAge(rs.getString(14));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingoperationcommercialeSansCarte(final int idoperationcommerciale,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{
		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (boutoncochetous == true) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN WHERE PARTICIPER.IDOPERATIONCOMMERCIALE=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, idoperationcommerciale);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}
		if (boutoncochetous == false) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN WHERE PARTICIPER.IDOPERATIONCOMMERCIALE=? AND PARTICIPER.IDMAGASIN=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, idoperationcommerciale);
				preStm.setInt(2, magasinidSelectionne);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingoperationcommercialeTOUS(final int idoperationcommerciale,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{
		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (boutoncochetous == true) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN WHERE PARTICIPER.IDOPERATIONCOMMERCIALE=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, idoperationcommerciale);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}
		if (boutoncochetous == false) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN WHERE PARTICIPER.IDOPERATIONCOMMERCIALE=? AND PARTICIPER.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, idoperationcommerciale);
				preStm.setInt(2, magasinidSelectionne);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingTrancheAge(final int valuemin, final int valuemax,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{
		/*
		 * Calendar now = Calendar.getInstance(); int
		 * year=now.get(Calendar.YEAR); System.out.println(year+"\n");
		 *
		 * int AnneeFin=year-valuemin; int Anneedebut=year-valuemax;
		 *
		 * System.out.println(Anneedebut+"\n");
		 * System.out.println(AnneeFin+"\n");
		 */

		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (boutoncochetous == true) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE AGECLIENT BETWEEN ? AND ? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, valuemin);
				preStm.setInt(2, valuemax);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}
		if (boutoncochetous == false) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE AGECLIENT BETWEEN ? AND ? AND FREQUENTER.IDMAGASIN=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, valuemin);
				preStm.setInt(2, valuemax);
				preStm.setInt(3, magasinidSelectionne);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setNumerocarte(rs.getString(11));
				liste.setTelephonefixe(rs.getString(12));
				liste.setTelephonemobile(rs.getString(13));
				liste.setAge(rs.getString(14));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingTrancheAgeSansCarte(final int valuemin, final int valuemax,
			final int magasinidSelectionne, final boolean boutoncochetous)

	{
		/*
		 * Calendar now = Calendar.getInstance(); int
		 * year=now.get(Calendar.YEAR); System.out.println(year+"\n");
		 *
		 * int AnneeFin=year-valuemin; int Anneedebut=year-valuemax;
		 *
		 * System.out.println(Anneedebut+"\n");
		 * System.out.println(AnneeFin+"\n");
		 */

		System.out.println(boutoncochetous);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		if (boutoncochetous == true) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE AGECLIENT BETWEEN ? AND ? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC ";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, valuemin);
				preStm.setInt(2, valuemax);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}
		if (boutoncochetous == false) {
			try {

				c = Connexion.getCon();
				final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE AGECLIENT BETWEEN ? AND ? AND FREQUENTER.IDMAGASIN=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
				preStm = c.prepareStatement(SQL);

				preStm.setInt(1, valuemin);
				preStm.setInt(2, valuemax);
				preStm.setInt(3, magasinidSelectionne);

				rs = preStm.executeQuery();
			} catch (final Exception e) {

				System.out.println("erreur" + e.getMessage());
			}
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingville(final int idville)

	{
		System.out.println(idville);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE VILLE.IDVILLE=? GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, idville);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setNumerocarte(rs.getString(11));
				liste.setTelephonefixe(rs.getString(12));
				liste.setTelephonemobile(rs.getString(13));
				liste.setAge(rs.getString(14));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> eMailingvilleSansCarte(final int idville)

	{
		System.out.println(idville);

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE VILLE.IDVILLE=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, idville);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> ensembleporteurcarte()

	{

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, NUMEROCARTEDEFIDELITE ,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
			preStm = c.prepareStatement(SQL);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setNumerocarte(rs.getString(11));
				liste.setTelephonefixe(rs.getString(12));
				liste.setTelephonemobile(rs.getString(13));
				liste.setAge(rs.getString(14));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> ensembleSansCarte()

	{

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE) GROUP BY CLIENT.IDCLIENT ORDER BY AGECLIENT ASC";
			preStm = c.prepareStatement(SQL);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> fichecompleteporteurcarte(final int idclient)

	{
		final int identifiantclient = idclient;

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, VIP,NUMEROCARTEDEFIDELITE ,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT WHERE CLIENT.IDCLIENT=?";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, identifiantclient);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setVIP(rs.getString(11));
				liste.setNumerocarte(rs.getString(12));
				liste.setTelephonefixe(rs.getString(13));
				liste.setTelephonemobile(rs.getString(14));
				liste.setAge(rs.getString(15));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ResultatRecherche> fichecompleteSansCarte(final int idclient)

	{
		final int identifiantclient = idclient;

		final Vector<ResultatRecherche> requete = new Vector<ResultatRecherche>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATE_FORMAT(DATENAISSANCECLIENT, '%d/%m/%Y'), NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT,AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN WHERE CLIENT.IDCLIENT=? AND CLIENT.IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE)";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, identifiantclient);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			ResultatRecherche liste;
			while (rs.next()) {

				liste = new ResultatRecherche();

				liste.setCiviliteIndividu(rs.getString(1));
				liste.setNomIndividu(rs.getString(2));
				liste.setPrenomIndividu(rs.getString(3));
				liste.setAdresseIndividu(rs.getString(4));
				liste.setVilleIndividu(rs.getString(5));
				liste.setCodePostalIndividu(rs.getString(6));
				liste.setDateNaissanceIndividu(rs.getString(7));
				liste.setNommagasin(rs.getString(8));
				liste.setEmail(rs.getString(9));
				liste.setNewsletterIndividu(rs.getString(10));
				liste.setTelephonefixe(rs.getString(11));
				liste.setTelephonemobile(rs.getString(12));
				liste.setAge(rs.getString(13));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<ClientOperationCommerciale> infosclient(final String nom, final String prenom,
			final String age)

	{

		System.out.println(nom + "\n");
		System.out.println(prenom + "\n");
		System.out.println(age + "\n");

		final Vector<ClientOperationCommerciale> requete = new Vector<ClientOperationCommerciale>();

		try {

			c = Connexion.getCon();

			final String sql = "SELECT CLIENT.IDCLIENT, CIVILITECLIENT, NOMCLIENT, PRENOMCLIENT, ADRESSECLIENT, NOMVILLE, CODEPOSTALVILLE, DATENAISSANCECLIENT, NOMMAGASIN, MAILCLIENT, ABONNEMENTNEWSLETTERCLIENT, LIBELLEOPERATIONCOMMERCIALE,TELEPHONEFIXECLIENT,TELEPHONEPORTABLECLIENT, AGECLIENT FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN INNER JOIN PARTICIPER ON PARTICIPER.IDCLIENT=CLIENT.IDCLIENT INNER JOIN OPERATION_COMMERCIALE ON OPERATION_COMMERCIALE.IDOPERATIONCOMMERCIALE=PARTICIPER.IDOPERATIONCOMMERCIALE WHERE CLIENT.NOMCLIENT=? AND CLIENT.PRENOMCLIENT=? AND CLIENT.AGECLIENT=?";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nom);
			preStm.setString(2, prenom);
			preStm.setString(3, age);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			ClientOperationCommerciale liste;
			while (rs.next()) {
				liste = new ClientOperationCommerciale();

				liste.setIdclient(rs.getInt(1));
				liste.setCiviliteIndividu(rs.getString(2));
				liste.setNomIndividu(rs.getString(3));
				liste.setPrenomIndividu(rs.getString(4));
				liste.setAdresseIndividu(rs.getString(5));
				liste.setVilleIndividu(rs.getString(6));
				liste.setCodePostalIndividu(rs.getString(7));
				liste.setDateNaissanceIndividu(rs.getString(8));
				liste.setNommagasin(rs.getString(9));
				liste.setEmail(rs.getString(10));
				liste.setNewsletterIndividu(rs.getString(11));
				liste.setLibelleoperationcommerciale(rs.getString(12));
				liste.setNumerofixe(rs.getString(13));
				liste.setNumeroportable(rs.getString(14));
				liste.setAge(rs.getString(15));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<Clientcartedefidelite> infosclientcartefidelite(final String numerocartefidelite)

	{

		final Vector<Clientcartedefidelite> requete = new Vector<Clientcartedefidelite>();

		try {

			c = Connexion.getCon();

			final String sql = "SELECT CLIENT.IDCLIENT," + " CIVILITECLIENT," + " NOMCLIENT," + " PRENOMCLIENT,"
					+ " ADRESSECLIENT," + " NOMVILLE," + " CODEPOSTALVILLE," + " DATENAISSANCECLIENT," + " NOMMAGASIN,"
					+ " MAILCLIENT," + " ABONNEMENTNEWSLETTERCLIENT," + " NUMEROCARTEDEFIDELITE," + " AGECLIENT,"
					+ " TELEPHONEFIXECLIENT," + " TELEPHONEPORTABLECLIENT," + " VIP" + " FROM CLIENT"
					+ " INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE"
					+ " INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT"
					+ " INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN"
					+ " INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT"
					+ " WHERE NUMEROCARTEDEFIDELITE=?";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, numerocartefidelite);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			Clientcartedefidelite liste;
			while (rs.next()) {
				liste = new Clientcartedefidelite();

				liste.setIdclient(rs.getInt(1));
				liste.setCiviliteIndividu(rs.getString(2));
				liste.setNomIndividu(rs.getString(3));
				liste.setPrenomIndividu(rs.getString(4));
				liste.setAdresseIndividu(rs.getString(5));
				liste.setVilleIndividu(rs.getString(6));
				liste.setCodePostalIndividu(rs.getString(7));
				liste.setDateNaissanceIndividu(rs.getString(8));
				liste.setNommagasin(rs.getString(9));
				liste.setEmail(rs.getString(10));
				liste.setNewsletterIndividu(rs.getString(11));
				liste.setNumerocarte(rs.getString(12));
				liste.setAge(rs.getString(13));
				liste.setTelfixe(rs.getString(14));
				liste.setMobile(rs.getString(15));
				liste.setVip(rs.getBoolean(16));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static MagasinsInfos infosMagasins(final int idmagasin)

	{
		final MagasinsInfos requete = new MagasinsInfos();
		final int identifiantMagasin = idmagasin;
		try {

			c = Connexion.getCon();
			final String sql = "SELECT NOMMAGASIN, ADRESSEMAGASIN,TELEPHONEMAGASIN,FAXMAGASIN, MAILMAGASIN, NOMVILLE, CODEPOSTALVILLE FROM MAGASIN INNER JOIN VILLE ON VILLE.IDVILLE=MAGASIN.IDVILLE  WHERE IDMAGASIN=?";
			preStm = c.prepareStatement(sql);

			preStm.setInt(1, identifiantMagasin);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			while (rs.next()) {

				requete.setNomMagasin(rs.getString(1));
				requete.setAdresseMagasin(rs.getString(2));
				requete.setVilleMagasin(rs.getString(6));
				requete.setCodePostalMagasin(rs.getString(7));
				requete.setTelephoneMagasin(rs.getString(3));
				requete.setFaxMagasin(rs.getString(4));
				requete.setMailMagasin(rs.getString(5));
			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static OperationCommercialeInfos InfosoperationCommerciale(final int idoperation)

	{
		final OperationCommercialeInfos requete = new OperationCommercialeInfos();
		final int identifiantoperation = idoperation;
		try {

			c = Connexion.getCon();
			final String sql = "SELECT LIBELLEOPERATIONCOMMERCIALE, DATE_FORMAT(DATEDEBUTOPERATIONCOMMERCIALE, '%Y/%m/%d'), DATE_FORMAT(DATEFINOPERATIONCOMMERCIALE, '%Y/%m/%d') FROM OPERATION_COMMERCIALE WHERE IDOPERATIONCOMMERCIALE=?";

			preStm = c.prepareStatement(sql);

			preStm.setInt(1, identifiantoperation);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			while (rs.next()) {

				requete.setLibelleOperationCommerciale(rs.getString(1));
				requete.setDatebutOperationCommerciale(rs.getDate(2));
				requete.setDatefinOperationCommerciale(rs.getDate(3));

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Vector<infosparticipation> infospartipationjeux(final int idclient)

	{
		final int identifiantclient = idclient;

		final Vector<infosparticipation> requete = new Vector<infosparticipation>();

		try {

			c = Connexion.getCon();
			final String SQL = "SELECT LIBELLEOPERATIONCOMMERCIALE, NOMMAGASIN ,DATE_FORMAT(DATEDEBUTOPERATIONCOMMERCIALE, '%d/%m/%Y') FROM PARTICIPER INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=PARTICIPER.IDMAGASIN INNER JOIN OPERATION_COMMERCIALE ON OPERATION_COMMERCIALE.IDOPERATIONCOMMERCIALE=PARTICIPER.IDOPERATIONCOMMERCIALE WHERE PARTICIPER.IDCLIENT=?";
			preStm = c.prepareStatement(SQL);

			preStm.setInt(1, identifiantclient);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			infosparticipation liste;
			while (rs.next()) {

				liste = new infosparticipation();

				liste.setLibelleoperationcommerciale(rs.getString(1));
				liste.setNommagasin(rs.getString(2));
				liste.setDate(rs.getString(3));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static Object[] listeageClient(final String nomClient, final String prenomClient)

	{
		final Vector<DateNaissanceClient> requete = new Vector<DateNaissanceClient>();

		try {

			c = Connexion.getCon();

			// String sqldatefrancaise="SET lc_time_names = 'fr_FR'";
			// preStm=c.prepareStatement(sqldatefrancaise);
			// preStm.executeQuery();

			final String sql = "SELECT DISTINCT AGECLIENT FROM CLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND IDCLIENT IN (SELECT IDCLIENT FROM PARTICIPER)";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nomClient);
			preStm.setString(2, prenomClient);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			DateNaissanceClient liste;
			while (rs.next()) {

				liste = new DateNaissanceClient();
				liste.setDatenaissance(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listeageClientsanscarte(final String nomClient, final String prenomClient)

	{
		final Vector<DateNaissanceClient> requete = new Vector<DateNaissanceClient>();

		try {

			c = Connexion.getCon();

			// String sqldatefrancaise="SET lc_time_names = 'fr_FR'";
			// preStm=c.prepareStatement(sqldatefrancaise);
			// preStm.executeQuery();

			final String sql = "SELECT DISTINCT AGECLIENT FROM CLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=? AND IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE)";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nomClient);
			preStm.setString(2, prenomClient);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			DateNaissanceClient liste;
			while (rs.next()) {

				liste = new DateNaissanceClient();
				liste.setDatenaissance(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listedateClientfidelite(final String nomClient, final String prenomClient)

	{
		final Vector<DateNaissanceClient> requete = new Vector<DateNaissanceClient>();

		try {

			c = Connexion.getCon();

			final String sql = "SELECT DISTINCT AGECLIENT FROM CARTE_DE_FIDELITE INNER JOIN CLIENT ON CLIENT.IDCLIENT=CARTE_DE_FIDELITE.IDCLIENT WHERE NOMCLIENT=? AND PRENOMCLIENT=?";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nomClient);
			preStm.setString(2, prenomClient);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			DateNaissanceClient liste;
			while (rs.next()) {

				liste = new DateNaissanceClient();
				liste.setDatenaissance(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listeClientFideliteHomonymes(final String nomClient, final String prenomClient)

	{
		final Vector<Clientcartedefidelite> requete = new Vector<Clientcartedefidelite>();

		try {

			c = Connexion.getCon();
			final String sql = "SELECT" + " CLIENT.IDCLIENT," + " CIVILITECLIENT," + " NOMCLIENT," + " PRENOMCLIENT,"
					+ " ADRESSECLIENT," + " NOMVILLE," + " CODEPOSTALVILLE," + " DATENAISSANCECLIENT," + " NOMMAGASIN,"
					+ " MAILCLIENT," + " ABONNEMENTNEWSLETTERCLIENT," + " NUMEROCARTEDEFIDELITE," + " AGECLIENT,"
					+ " TELEPHONEFIXECLIENT," + " TELEPHONEPORTABLECLIENT"
					+ " FROM CLIENT INNER JOIN VILLE ON VILLE.IDVILLE=CLIENT.IDVILLE"
					+ " INNER JOIN FREQUENTER ON FREQUENTER.IDCLIENT=CLIENT.IDCLIENT"
					+ " INNER JOIN MAGASIN ON MAGASIN.IDMAGASIN=FREQUENTER.IDMAGASIN"
					+ " INNER JOIN CARTE_DE_FIDELITE ON CARTE_DE_FIDELITE.IDCLIENT=CLIENT.IDCLIENT"
					+ " WHERE NOMCLIENT=?" + " AND PRENOMCLIENT=?";

			preStm = c.prepareStatement(sql);
			preStm.setString(1, nomClient);
			preStm.setString(2, prenomClient);
			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur\n" + e.getMessage() + "\n");
			e.printStackTrace();
		}

		try {

			requete.add(null);
			Clientcartedefidelite cliForSearchByNomPrenom;
			while (rs.next()) {

				cliForSearchByNomPrenom = new Clientcartedefidelite();

				cliForSearchByNomPrenom.setIdclient(rs.getInt(1));
				cliForSearchByNomPrenom.setCiviliteIndividu(rs.getString(2));
				cliForSearchByNomPrenom.setNomIndividu(rs.getString(3));
				cliForSearchByNomPrenom.setPrenomIndividu(rs.getString(4));
				cliForSearchByNomPrenom.setAdresseIndividu(rs.getString(5));
				cliForSearchByNomPrenom.setVilleIndividu(rs.getString(6));
				cliForSearchByNomPrenom.setCodePostalIndividu(rs.getString(7));
				cliForSearchByNomPrenom.setDateNaissanceIndividu(rs.getString(8));
				cliForSearchByNomPrenom.setNommagasin(rs.getString(9));
				cliForSearchByNomPrenom.setEmail(rs.getString(10));
				cliForSearchByNomPrenom.setNewsletterIndividu(rs.getString(11));
				cliForSearchByNomPrenom.setNumerocarte(rs.getString(12));
				cliForSearchByNomPrenom.setAge(rs.getString(13));
				cliForSearchByNomPrenom.setTelfixe(rs.getString(14));
				cliForSearchByNomPrenom.setMobile(rs.getString(15));

				requete.add(cliForSearchByNomPrenom);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listemagasins()
	{
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
		return result.toArray(new Object[0]);
	}

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
		return result.toArray(new Object[0]);
	}

	public static Object[] listenomclient()

	{
		final Vector<NomClient> requete = new Vector<NomClient>();

		try {

			c = Connexion.getCon();
			final String sql = "SELECT DISTINCT NOMCLIENT FROM CLIENT WHERE IDCLIENT IN (SELECT IDCLIENT FROM PARTICIPER)";

			preStm = c.prepareStatement(sql);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			NomClient liste;
			while (rs.next()) {

				liste = new NomClient();
				liste.setNom(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("errorlistenom" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listenomclientfidelite() {
		final Vector<NomClient> requete = new Vector<NomClient>();
		try {
			c = Connexion.getCon();
			final String sql = "SELECT DISTINCT NOMCLIENT FROM CARTE_DE_FIDELITE INNER JOIN CLIENT ON CLIENT.IDCLIENT=CARTE_DE_FIDELITE.IDCLIENT";
			preStm = c.prepareStatement(sql);
			rs = preStm.executeQuery();
		} catch (final Exception e) {
			System.out.println("erreur" + e.getMessage());
		}
		try {
			requete.add(null);
			NomClient liste;
			while (rs.next()) {
				liste = new NomClient();
				liste.setNom(rs.getString(1));
				requete.add(liste);
				System.out.println("listenomclientfidelite, liste is : " + liste);
			}
			rs.close();
			preStm.close();
		} catch (final Exception e) {
			System.out.println("errorlistenom" + e.getMessage());
		}

		// Collections.sort(requete, NomClient.Comparators.NAME);
		// Object[] result = requete.toArray(new Object[0]);
		// return result;
		Collections.sort(requete);
		return requete.toArray(new Object[0]);
	}

	public static Object[] listenomclientsanscarte()

	{
		final Vector<NomClient> requete = new Vector<NomClient>();

		try {

			c = Connexion.getCon();
			final String sql = "SELECT DISTINCT NOMCLIENT FROM CLIENT WHERE IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE)";

			preStm = c.prepareStatement(sql);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			NomClient liste;
			while (rs.next()) {

				liste = new NomClient();
				liste.setNom(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("errorlistenom" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listeOperationCommerciale() {

		final Vector<OperationCommerciale> requete = new Vector<OperationCommerciale>();

		try {

			c = Connexion.getCon();

			stm = c.createStatement();
			final String SQL = "SELECT IDOPERATIONCOMMERCIALE, LIBELLEOPERATIONCOMMERCIALE FROM OPERATION_COMMERCIALE";

			rs = stm.executeQuery(SQL);
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			requete.add(null);
			OperationCommerciale liste = null;
			while (rs.next()) {

				liste = new OperationCommerciale();
				liste.setIdOperationCommerciale(rs.getInt(1));
				liste.setLibelleOperationCommerciale(rs.getString(2));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listePrenomclient(final String nomClient)

	{
		final Vector<PrenomClient> requete = new Vector<PrenomClient>();

		try {

			c = Connexion.getCon();
			final String sql = "SELECT DISTINCT PRENOMCLIENT FROM CLIENT WHERE NOMCLIENT=? AND IDCLIENT IN (SELECT IDCLIENT FROM PARTICIPER)";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nomClient);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			PrenomClient liste;
			while (rs.next()) {

				liste = new PrenomClient();
				liste.setPrenom(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listePrenomclientfidelite(final String nomClient)

	{
		final Vector<PrenomClient> requete = new Vector<PrenomClient>();

		try {

			c = Connexion.getCon();
			final String sql = "SELECT DISTINCT PRENOMCLIENT FROM CARTE_DE_FIDELITE INNER JOIN CLIENT ON CLIENT.IDCLIENT=CARTE_DE_FIDELITE.IDCLIENT WHERE NOMCLIENT=?";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nomClient);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			PrenomClient liste;
			while (rs.next()) {

				liste = new PrenomClient();
				liste.setPrenom(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		Collections.sort(requete);
		return requete.toArray(new Object[0]);

	}

	public static Object[] listePrenomclientsanscarte(final String nomClient)

	{
		final Vector<PrenomClient> requete = new Vector<PrenomClient>();

		try {

			c = Connexion.getCon();
			final String sql = "SELECT DISTINCT PRENOMCLIENT FROM CLIENT WHERE NOMCLIENT=? AND IDCLIENT NOT IN (SELECT IDCLIENT FROM CARTE_DE_FIDELITE)";

			preStm = c.prepareStatement(sql);

			preStm.setString(1, nomClient);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			PrenomClient liste;
			while (rs.next()) {

				liste = new PrenomClient();
				liste.setPrenom(rs.getString(1));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listeutilisateur(final String selection)

	{
		final Vector<UtilisateursLogiciel> requete = new Vector<UtilisateursLogiciel>();

		try {

			c = Connexion.getCon();
			String sql;
			if (selection.equals("Supprimer un utilisateur")
					|| selection.equals("Mettre a jour un privilege utilisateur")) {
				sql = "SELECT IDUSER, IDENTIFIANT, MOTDEPASSE FROM USERS";
			} else {

				sql = "SELECT IDUSER, IDENTIFIANT, MOTDEPASSE FROM USERS ";
			}
			preStm = c.prepareStatement(sql);

			rs = preStm.executeQuery();

		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {

			requete.add(null);
			UtilisateursLogiciel liste;
			while (rs.next()) {

				liste = new UtilisateursLogiciel();
				liste.setNumeroutilisateur(rs.getString(1));
				liste.setIdentifiant(rs.getString(2));
				liste.setMotdepasse(rs.getString(3));

				requete.add(liste);

			}

			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);

	}

	public static Object[] listeVille() {

		final Vector<Ville> requete = new Vector<Ville>();

		try {

			c = Connexion.getCon();

			stm = c.createStatement();
			final String SQL = "SELECT IDVILLE, NOMVILLE,CODEPOSTALVILLE FROM VILLE ORDER BY VILLE.NOMVILLE";

			rs = stm.executeQuery(SQL);
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			requete.add(new Ville());
			Ville liste = null;
			while (rs.next()) {

				liste = new Ville();
				liste.setIdville(rs.getInt(1));
				liste.setNomVille(rs.getString(2));
				liste.setCodePostalVille(rs.getString(3));

				requete.add(liste);
			}
			rs.close();
			stm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete.toArray(new Object[0]);
	}

	public static String privilege(final String nomutilisateur, final String password)

	{
		String requete = null;

		try {

			c = Connexion.getCon();

			final String SQL = "SELECT PRIVILEGE FROM USERS WHERE IDENTIFIANT=? AND MOTDEPASSE=?";
			preStm = c.prepareStatement(SQL);
			preStm.setString(1, nomutilisateur);
			preStm.setString(2, password);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			while (rs.next()) {

				requete = (rs.getString(1));

			}
			rs.close();
			preStm.close();

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}

	public static boolean verificationuUsers(final String nomutilisateur, final String password)

	{
		boolean requete = false;

		try {

			c = Connexion.getCon();

			final String SQL = "SELECT COUNT(IDUSER) FROM USERS WHERE IDENTIFIANT=? AND MOTDEPASSE=?";
			preStm = c.prepareStatement(SQL);
			preStm.setString(1, nomutilisateur);
			preStm.setString(2, password);

			rs = preStm.executeQuery();
		} catch (final Exception e) {

			System.out.println("erreur" + e.getMessage());
		}

		try {
			int compteur = 0;
			while (rs.next()) {

				compteur = (rs.getInt(1));

			}
			rs.close();
			preStm.close();

			if (compteur == 1) {

				requete = true;
			}

		} catch (final Exception e)

		{
			System.out.println("error" + e.getMessage());

		}

		return requete;

	}
}
