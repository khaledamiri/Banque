package org.banque.amiri.metier;

import org.banque.amiri.dao.CompteRepository;
import org.banque.amiri.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeMetierImpl implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cpte) {
		// TODO Auto-generated method stub
		return compteRepository.save(cpte);
	}

	@Override
	public Compte getCompte(String codeCpte) {
		Compte c=compteRepository.findOne(codeCpte);
		if (c==null) throw new RuntimeException("Compte Innexistant!");// de manniere professionnelle tu doit créer vous propre exception
		return c;
	}

}
