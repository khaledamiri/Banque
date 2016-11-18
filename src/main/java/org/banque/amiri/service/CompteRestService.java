package org.banque.amiri.service;

import org.banque.amiri.entities.Compte;
import org.banque.amiri.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {

	@Autowired
	private CompteMetier compteMetier;


	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	@ResponseBody
	public Compte saveCompte(@RequestBody Compte cpte) {
		return compteMetier.saveCompte(cpte);
	}
	@RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
	public Compte getCompte(@PathVariable String codeCpte) {
		return compteMetier.getCompte(codeCpte);
	}
}
