package org.banque.amiri.metier;

import org.banque.amiri.entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte cpte);

	public Compte getCompte(String codeCpte);
}
