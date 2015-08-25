package JUnit;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import fr.lefournildesprovinces.dao.ClientDAO;
import fr.lefournildesprovinces.dao.ClientPOI;

public class FichesClientsImportTests {

	private static final Logger log = Logger.getLogger(FichesClientsImportTests.class);

	private static final String fileName = "src/JUnit/resouces/TemplateImportClients.xlsx";

	private ClientDAO dao;


	@Before
	public void doBefore(){
		dao = new ClientPOI(fileName);
	}
	@Test
	public void findAllRecords() {
		fail("Not yet implemented");
	}

	@Test
	public void findNewsletterAllowedRecords(){
		fail("Not yet implemented");
	}

	@Test
	public void ClientCiviliteIsValid(){
		fail("Not yet implemented");
	}

	@Test
	public void mailIsValid(){
		fail("Not yet implemented");
	}

	@Test
	public void dateForMySQLisValid(){
		fail("Not yet implemented");
	}

}
