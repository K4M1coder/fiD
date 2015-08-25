package fr.lefournildesprovinces.dao;

import java.util.List;

import fr.lefournildesprovinces.ressources.models.imports.Client;

public interface ClientDAO {

	List<Client> findAllClients();

}
