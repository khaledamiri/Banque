package org.banque.amiri.service;

import java.util.Date;

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

//test khaled
	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	@ResponseBody
	public Compte saveCompte(@RequestBody Compte cpte) {
		cpte.setDateCreation(new Date());
		return compteMetier.saveCompte(cpte);
	}
	@RequestMapping(value = "/comptes/{numCompte}", method = RequestMethod.GET)
	public Compte getCompte(@PathVariable String numCompte) {
		return compteMetier.getCompte(numCompte);
	}
}
