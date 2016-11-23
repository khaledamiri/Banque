package org.banque.amiri.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.banque.amiri.entities.Compte;
import org.banque.amiri.metier.CompteMetier;
import org.banque.amiri.metier.OperationMetier;
import org.banque.amiri.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class BanqueSOAPService {
//ce BEAN org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter qui va checher les annotation @WebService et les deploy
	@Autowired
	CompteMetier compteMetier;
	@Autowired
	OperationMetier operationMetier;

	@WebMethod
	public Compte getCompte(@WebParam(name = "codeCpte") String codeCpte) {
		return compteMetier.getCompte(codeCpte);
	}

	@WebMethod
	public boolean verser(@WebParam(name = "codeCpte") String code,
			@WebParam(name = "montant") double montant,
			@WebParam(name = "codeEmp") Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}

	@WebMethod
	public boolean retirer(@WebParam(name = "code") String code,
			@WebParam(name = "montant") double montant,
			@WebParam(name = "codeEmp") Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@WebMethod
	public boolean virement(@WebParam(name = "cpte1") String cpte1,
			@WebParam(name = "cpte2") String cpte2,
			@WebParam(name = "montant") double montant,
			@WebParam(name = "codeEmp") Long codeEmp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}

	@WebMethod
	public PageOperation getOperations(
			@WebParam(name = "numCompte") String numCompte,
			@WebParam(name = "page") int page, @WebParam(name = "size") int size) {
		return operationMetier.getOperations(numCompte, page, size);
	}

}
