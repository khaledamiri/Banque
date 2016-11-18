package org.banque.amiri.metier;

import java.util.List;

import org.banque.amiri.dao.ClientRepository;
import org.banque.amiri.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * MicroService
 * 
 */

@Service
public class ClientMetierImpl implements ClientMetier {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
