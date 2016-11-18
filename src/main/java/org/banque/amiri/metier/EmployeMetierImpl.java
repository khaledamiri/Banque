package org.banque.amiri.metier;

import java.util.List;

import org.banque.amiri.dao.EmployeRepository;
import org.banque.amiri.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier {
	
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public List<Employe> listEmploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

	@Override
	public Employe saveEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

}
