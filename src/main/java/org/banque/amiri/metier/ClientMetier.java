package org.banque.amiri.metier;

import java.util.List;

import org.banque.amiri.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client client);
	public List<Client> listClient();

}
