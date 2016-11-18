package org.banque.amiri.service;

import java.util.List;

import org.banque.amiri.entities.Employe;
import org.banque.amiri.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {

	@Autowired
	EmployeMetier employeMetier;

	@RequestMapping(value = "/employes", method = RequestMethod.POST)
	@ResponseBody
	public Employe saveEmploye(@RequestBody Employe employe) {
		return employeMetier.saveEmploye(employe);
	}

	
	@RequestMapping(value = "/employes", method = RequestMethod.GET)
	public List<Employe> listEmploye() {
		return employeMetier.listEmploye();
	}
	
	
	
}
