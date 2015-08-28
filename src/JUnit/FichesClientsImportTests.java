package JUnit;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.lefournildesprovinces.dao.ClientDAO;
import fr.lefournildesprovinces.dao.ClientPOI;
import fr.lefournildesprovinces.ressources.models.imports.Client;

public class FichesClientsImportTests {

	private static final Logger log = Logger.getLogger(FichesClientsImportTests.class);

	private static final String fileName = "src/JUnit/resources/TemplateImportClients.xlsx";
	private static final String sheetName = "NouvelleFichesClients";

	private ClientDAO dao;

	@Before
	public void doBefore() {
		dao = new ClientPOI(fileName, sheetName);
	}

	@Test
	public void findAllClients() {
		log.debug("findAllClients");

		// Arrange
		final int expectedSize = 8;

		// Act
		final List<Client> clients = dao.findAllClients();

		// Assert
		for(Client cli:clients){
			System.out.println(cli.toString());
		}
		Assert.assertNotNull(clients);
		Assert.assertEquals(expectedSize, clients.size());

	}

	@Test
	public void findNewsletterAllowedRecords() {
		fail("not yet implemented");

	}

	@Test
	public void ClientCiviliteIsValid() {
		fail("not yet implemented");

	}

	@Test
	public void mailIsValid() {
		fail("not yet implemented");

	}

	@Test
	public void dateForMySQLisValid() {
		fail("not yet implemented");

	}

}
