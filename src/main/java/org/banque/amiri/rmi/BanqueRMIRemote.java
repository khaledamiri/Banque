package org.banque.amiri.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.banque.amiri.entities.Compte;

public interface BanqueRMIRemote extends Remote {

	public Compte saveCompte(Compte cp) throws RemoteException;

	public Compte getCompte(String code) throws RemoteException;

	public boolean verser(String code, double montant, Long codeEmp)
			throws RemoteException;

	public boolean retirer(String code, double montant, Long codeEmp)
			throws RemoteException;

	public boolean virement(String cpte1, String cpte2, double montant,
			Long codeEmp) throws RemoteException;
}
