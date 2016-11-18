package org.banque.amiri.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn(name = "code_emp_sup")
	private Employe employeSup;
	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	@ManyToMany
	@JoinTable(name = "EMP_GR")
	private Collection<Groupe> groupes;

	public Long getCodeEmploye() {
		return codeEmploye;
	}

	@JsonIgnore
	public Employe getEmployeSup() {
		return employeSup;
	}

	@JsonSetter
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}

	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	@Override
	public String toString() {
		return "Employe [codeEmploye=" + codeEmploye + ", nomEmploye="
				+ nomEmploye + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeEmploye == null) ? 0 : codeEmploye.hashCode());
		result = prime * result
				+ ((nomEmploye == null) ? 0 : nomEmploye.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (codeEmploye == null) {
			if (other.codeEmploye != null)
				return false;
		} else if (!codeEmploye.equals(other.codeEmploye))
			return false;
		if (nomEmploye == null) {
			if (other.nomEmploye != null)
				return false;
		} else if (!nomEmploye.equals(other.nomEmploye))
			return false;
		return true;
	}

	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;

	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
}
