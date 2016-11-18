package org.banque.amiri.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="GROUPES")
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeGroupe;
	private String nomGroups;
	@ManyToMany(mappedBy = "groupes")
	private Collection<Employe> employes;

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupe(String nomGroups) {
		super();
		this.nomGroups = nomGroups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomGroups == null) ? 0 : nomGroups.hashCode());
		result = prime * result
				+ ((codeGroupe == null) ? 0 : codeGroupe.hashCode());
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
		Groupe other = (Groupe) obj;
		if (nomGroups == null) {
			if (other.nomGroups != null)
				return false;
		} else if (!nomGroups.equals(other.nomGroups))
			return false;
		if (codeGroupe == null) {
			if (other.codeGroupe != null)
				return false;
		} else if (!codeGroupe.equals(other.codeGroupe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Groupe [codeGroupe=" + codeGroupe + ", nomGroups=" + nomGroups
				+ "]";
	}

	public Long getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(Long numGroupe) {
		this.codeGroupe = numGroupe;
	}

	public String getNomGroups() {
		return nomGroups;
	}

	public void setNomGroups(String nomGroups) {
		this.nomGroups = nomGroups;
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

}
