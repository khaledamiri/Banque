package org.banque.amiri.dao;

import org.banque.amiri.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,String>{

}
