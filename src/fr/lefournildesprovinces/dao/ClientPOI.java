package fr.lefournildesprovinces.dao;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import fr.lefournildesprovinces.ressources.models.imports.PublicationsCommierciale;
import sun.org.mozilla.javascript.internal.json.JsonParser.ParseException;

public class ClientPOI implements ClientDAO {

	private static final Logger log = Logger.getLogger(ClientPOI.class);

	private String fileName;
	private String sheetName;

	public ClientPOI(String filename, String sheetName) {
		super();
		this.fileName = filename;
		this.sheetName = sheetName;
	}

	@Override
	public List<Client> findAllClients() {

		final File file = new File(fileName);

		final List<Client> clients = new ArrayList<Client>();

		try {
			final Workbook workbook = WorkbookFactory.create(file);
			final Sheet sheet = workbook.getSheet(sheetName);

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

	private static Client rowToClient(final Row row) {
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

		final String dateDeNaissance = row.getCell(6).getStringCellValue();
		try {
			client.setDateNaissance(formatStringToDate(dateDeNaissance, "yyyy/MM/dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		final String age = row.getCell(7).getStringCellValue();
		client.setAge(age);

		final String mail = row.getCell(8).getStringCellValue();
		client.setMail(mail);

		final String newletterStatus = row.getCell(9).getStringCellValue();
		final Boolean newsletter = PublicationsCommierciale.valueOfByCode(newletterStatus).getCode();
		client.setNewsletter(newsletter);

		final String numCli = row.getCell(10).getStringCellValue();
		client.setNumCli(numCli);

		final String magasin = row.getCell(11).getStringCellValue();
		client.setMagasin(magasin);

		final String fix = row.getCell(12).getStringCellValue();
		final int telFix = Integer.parseInt(fix);
		client.setTelFix(telFix);

		final String gsm = row.getCell(13).getStringCellValue();
		final int telMob = Integer.parseInt(gsm);
		client.setTelMob(telMob);

		return client;

	}

	/**
	 * Split an input String with a regex delimiter.
	 *
	 * @param string
	 *            to split<br><br>
	 *
	 * @param splitRegEx
	 *            for split delimiters.
	 * <br>if splitRegEx is empty, default one (<strong>\\s*,\\s*</strong>) will be used :<br>
	 * zero or more whitespace, a literal comma, zero or more whitespace which
	 * will place the words into the list and collapse any whitespace between
	 * the words and commas.
	 * @return ArrayList of String from <strong>string</strong>
	 */

	@SuppressWarnings("unused")
	private static List<String> stringToList(final String string, String splitRegEx) {
		String defaultdelimiter = "\\s*,\\s*";
		splitRegEx = (splitRegEx.equals("")) ? defaultdelimiter : splitRegEx;

		final List<String> list = Arrays.asList(string.split(splitRegEx));

		return list;
	}

	private static Date formatStringToDate(final String dateInString, String format) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat(format);

		Date date = new Date();
		try {
			date = dateFormat.parse(dateInString);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;

	}

}
