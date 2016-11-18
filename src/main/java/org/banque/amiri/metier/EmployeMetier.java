package org.banque.amiri.metier;

import java.util.List;

import org.banque.amiri.entities.Employe;

public interface EmployeMetier {
	public Employe saveEmploye(Employe employe);

	public List<Employe> listEmploye();
}
