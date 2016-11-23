package org.banque.amiri.metier;

import java.util.Date;

import org.banque.amiri.dao.CompteRepository;
import org.banque.amiri.dao.EmployeRepository;
import org.banque.amiri.dao.OperationRepository;
import org.banque.amiri.entities.Compte;
import org.banque.amiri.entities.Employe;
import org.banque.amiri.entities.Operation;
import org.banque.amiri.entities.Retrait;
import org.banque.amiri.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findOne(code);
		Employe e = employeRepository.findOne(codeEmp);
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setEmploye(e);
		o.setCompte(cp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde() + montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findOne(code);
		if (cp.getSolde() < montant)
			throw new RuntimeException("Solde Insufisant");
		Employe e = employeRepository.findOne(codeEmp);
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setEmploye(e);
		o.setCompte(cp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde() - montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant,
			Long codeEmp) {
		retirer(cpte1, montant, codeEmp);
		retirer(cpte2, montant, codeEmp);
		return false;
	}

	@Override
	@Transactional
	public PageOperation getOperations(String numCompte, int page, int size) {
		// 1er version
		Page<Operation> pageOp = operationRepository.getOperations(numCompte,
				new PageRequest(page, size));
		PageOperation pOp = new PageOperation();
		pOp.setOperations(pageOp.getContent());
		pOp.setPage(pageOp.getNumber());
		pOp.setTotalPages(pageOp.getTotalPages());
		pOp.setTotalOperations((int) pageOp.getTotalElements());
		// 2eme version
		// Compte cp=compteRepository.findOne(numCompte);
		// Page<Operation> pageOperation2=operationRepository.findByCompte(cp,
		// new PageRequest(page, size));
		return pOp;
	}
}
