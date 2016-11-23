package org.banque.amiri.metier;



public interface OperationMetier {
	public boolean verser(String code, double montant, Long codeEmp);

	public boolean retirer(String code, double montant, Long codeEmp);

	public boolean virement(String cpte1, String cpte2, double montant,
			Long codeEmp);
	
	public PageOperation getOperations(String numCompte,int page,int size);
}
