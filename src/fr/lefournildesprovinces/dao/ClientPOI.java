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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import fr.lefournildesprovinces.ressources.models.imports.Client;
import fr.lefournildesprovinces.ressources.models.imports.FicheClient;
import fr.lefournildesprovinces.ressources.models.imports.PublicationsCommierciale;

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
		System.out.print("Load " + fileName);
		final File file = new File(fileName);
		System.out.println(" : OK");

		final List<Client> clients = new ArrayList<Client>();

		try {
			final Workbook workbook = WorkbookFactory.create(file);
			final Sheet sheet = workbook.getSheet(sheetName);

			int index = 1;
			Row row = sheet.getRow(index++);

			while (row != null) {

				System.out.println("load ROW " + (index - 1));
				final Client client = rowToClient(row);
				clients.add(client);
				System.out.println("ROW " + (index - 1) + " successfully loaded to " + client + "\n");

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

		String tel;

		System.out.println("civilite");
		final String civilite = getCellValue(row, 0, "String").getStringCellValue();
		client.setCivilite(civilite);

		System.out.println("nom");
		final String nom = getCellValue(row, 1, "String").getStringCellValue();
		client.setNom(nom);

		System.out.println("prenom");
		final String prenom = getCellValue(row, 2, "String").getStringCellValue();
		client.setPrenom(prenom);

		System.out.println("adresse");
		final String adresse = getCellValue(row, 3, "String").getStringCellValue();
		client.setAdresse(adresse);

		System.out.println("ville");
		final String ville = getCellValue(row, 4, "String").getStringCellValue();
		client.setVille(ville);

		System.out.println("codepostale");
		final int codePostal = (int) getCellValue(row, 5, "Int").getNumericCellValue();
		client.setCodePostal(codePostal);

		System.out.println("datedenaissance");
		final String dateDeNaissance =getCellValue(row, 6, "String").getStringCellValue();
		if (!dateDeNaissance.equals(null)) {
			client.setDateNaissance(formatStringToDate(dateDeNaissance, "yyyy/MM/dd"));
		}
		client.setDateNaissance(null);

		System.out.println("age");
		final String age = getCellValue(row, 7, "String").getStringCellValue();
		client.setAge(age);

		System.out.println("mail");
		final String mail = getCellValue(row, 8, "String").getStringCellValue();
		client.setMail(mail);

		System.out.println("newsletter");
		final String newletterStatus = getCellValue(row, 9, "String").getStringCellValue();
		final Boolean newsletter = PublicationsCommierciale.valueOfByCode(newletterStatus).getCode();
		client.setNewsletter(newsletter);

		System.out.println("numcli");
		final String numCli = getCellValue(row, 10, "String").getStringCellValue();
		client.setNumCli(numCli);

		System.out.println("magasin");
		final String magasin = getCellValue(row, 11, "String").getStringCellValue();
		client.setMagasin(magasin);

		System.out.println("telfix");
		tel = getCellValue(row, 12, "String").getStringCellValue();
		tel = checkTel(tel);
		System.out.println(" -> "+tel.toString());
		final int telFix;
		if (!tel.equals("notATelNumber")) {
			telFix = Integer.parseInt(tel);
			client.setTelFix(telFix);
		}

		System.out.println("telmob");
		tel = getCellValue(row, 13, "String").getStringCellValue();
		tel = checkTel(tel);
		System.out.println(" -> "+tel.toString());
		final int telMob;
		if (!tel.equals("notATelNumber")) {
			telMob = Integer.parseInt(tel);
			client.setTelFix(telMob);
		}

		return client;

	}

	private static Cell getCellValue(Row row, int cn, String returnType) {
		Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
		// System.out.print("= " + cell);
		// System.out.println("\ncelltype " + cell.getCellType());
		System.out.print("Search for \"" + returnType + "\" in the ");

		final int cellType = cell.getCellType();
		switch (cellType) {
		case 0: // Cell.CELL_TYPE_NUMERIC
			System.out.print("NUMERIC");
			break;
		case 1: // Cell.CELL_TYPE_STRING
			System.out.print("STRING");
			break;
		case 2: // Cell.CELL_TYPE_FORMULA
			System.out.print("FORMULA");
			break;
		case 3: // Cell.CELL_TYPE_BLANK
			System.out.print("BLANK");
			break;
		case 4: // Cell.CELL_TYPE_BOOLEAN
			System.out.print("BOOLEAN");
			break;
		case 5: // Cell.CELL_TYPE_ERROR
			System.out.print("ERROR");
			break;
		}

		switch (returnType) {
		case "boolean":
			break;
		case "int":
			break;
		case "long":
			break;
		case "short":
			break;
		case "String":
			cell.setCellType(Cell.CELL_TYPE_STRING);
			System.out.print("switched to STRING");
			break;
		case "date":
//			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			break;
		}

		System.out.print(" cell [" + (cell.getRowIndex() + 1) + "," + (cell.getColumnIndex() + 1) + "] : " + cell.toString());

		if ((cell.equals(null)) || (cell.equals("")) || (cell.getCellType() == Cell.CELL_TYPE_BLANK)) {
			System.out.print("isNull");

		}
		System.out.println();
		return cell;
	}

	/**
	 * this function check the phone string remove ' if exist in first place
	 * check if there is more than 10 chars its wrong check if ther is non
	 * digits chars its wrong
	 *
	 * @param tel
	 * @return tel
	 */
	private static String checkTel(String tel) {
		while ((tel.startsWith("'")) || (tel.startsWith("0"))) {
			tel = tel.substring(1);
		}
		if (tel.matches("\\d+")) {

			if (tel.length() == 4) {
				return tel;
			}
			if ((tel.length()) == 9) {
				tel = "0" + tel;
				return tel;
			}

		}
		return "notATelNumber";
	}

	/**
	 * Split an input String with a regex delimiter.
	 *
	 * @param string
	 *            to split<br>
	 *            <br>
	 *
	 * @param splitRegEx
	 *            for split delimiters. <br>
	 *            if splitRegEx is empty, default one (
	 *            <strong>\\s*,\\s*</strong>) will be used :<br>
	 *            zero or more whitespace, a literal comma, zero or more
	 *            whitespace which will place the words into the list and
	 *            collapse any whitespace between the words and commas.
	 * @return ArrayList of String from <strong>string</strong>
	 */

	@SuppressWarnings("unused")
	private static List<String> stringToList(final String string, String splitRegEx) {
		String defaultdelimiter = "\\s*,\\s*";
		splitRegEx = (splitRegEx.equals("")) ? defaultdelimiter : splitRegEx;

		final List<String> list = Arrays.asList(string.split(splitRegEx));

		return list;
	}

	private static Date formatStringToDate(final String dateInString, String format) {

		DateFormat dateFormat = new SimpleDateFormat(format);

		Date date = new Date();
		try {
			// System.out.print("["+dateInString+"]->");
			date = (dateInString.equals("")) ? null : dateFormat.parse(dateInString);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;

	}

}
