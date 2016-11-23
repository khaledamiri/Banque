package org.banque.amiri.service;

import java.util.List;

import org.banque.amiri.entities.Client;
import org.banque.amiri.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	@ResponseBody
	// Avec RestController n'est pas important sauf avec @Controller c'est important
	// ResponseBody vous specifier à spring le resultat qui va serialiser dans le coeur de la reponse
	// RequestBody indiquer a spring de recuperer les données de client dans le coeur de la requete et ces données la dans la format json et le desiarialise
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
}
