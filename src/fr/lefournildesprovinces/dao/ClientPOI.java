package fr.lefournildesprovinces.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import fr.lefournildesprovinces.ressources.models.imports.Client;
import fr.lefournildesprovinces.ressources.models.imports.FicheClient;
import sun.org.mozilla.javascript.internal.json.JsonParser.ParseException;

public class ClientPOI implements ClientDAO{

	private static final Logger log = Logger.getLogger(ClientPOI.class);

	private String filename;

	@Override
	public List<Client> allclients() {

		final  File file = new File(filename);

		final List<Client> clients = new ArrayList<Client>();

		try {
			final Workbook workbook = WorkbookFactory.create(file);
			final Sheet sheet = workbook.getSheet("Feuil1");

			int index = 1;
			Row row = sheet.getRow(index++);

			while (row != null) {

				final Client client = rowToClient(row);
				clients.add(client);

				row = sheet.getRow(index++);
			}

		} catch (InvalidFormatException | IOException e) {
			log.error(e.getMessage(), e);
			// e.printStackTrace();
		}

		return clients;
	}

	private static Client rowToClient(final Row row){
		final FicheClient client = new FicheClient();

		final String civilite = row.getCell(0).getStringCellValue();
		client.setCivilite(civilite);

		final String nom = row.getCell(1).getStringCellValue();
		client.setNom(nom);

		final String prenom = row.getCell(2).getStringCellValue();
		client.setPrenom(prenom);

		final String adresse = row.getCell(3).getStringCellValue();
		client.setAdresse(adresse);

		final String ville = row.getCell(4).getStringCellValue();
		client.setVille(ville);

		final int codePostal = (int) row.getCell(5).getNumericCellValue();
		client.setCodePostal(codePostal);

		final String dateDeNaissance =  row.getCell(6).getStringCellValue();
		final dateNaissance = (Date) dateDeNaissance;
		client.setDateNaissance(dateNaissance);

		final int age = (int) row.getCell(7).getNumericCellValue();
		client.setAge(age);

		final String mail = row.getCell(8).getStringCellValue();
		client.setMail(mail);

		final String newletterStatus = row.getCell(9).getStringCellValue();
		final Boolean newsletter = PubliationsCommerciales.valueOfByCode(newsletterStatus);
		client.setNewsletter(newsletter);

		final String numCli = row.getCell(10).getStringCellValu);
		client.setNumCli(numCli);

		final String magasin = row.getCell(11).getStringCellValue();
		client.setMagasin(magasin);

		final String fix = row.getCell(12).getStringCellValue();
		final int telFix = (int) fix;
		client.setTelFix(telFix);

		final String gsm = row.getCell(13).getStringCellValue();
		final int telMob = (int) gsm;
		client.setTelMob(telMob);


		return client;

	}

	private static List<String> stringToList(final String s) {	// if there is more than one entry coma separated in a cell
		final List<String> list = new ArrayList<String>();		// this could be usefull to convert the CellString into ArrayList
		// TODO ... Utilise le Splitter de Guava...
		return list;
	}
	
	private static Date dateformat(final String dateInString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		try{
			Date date = formatter.parse(dateInString);
			String dateNaissance = formatter.format(date));
			
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("invalid date");
		}
		
		return null;
		
		
		
	}

}
