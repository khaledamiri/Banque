package org.banque.amiri.dao;

import org.banque.amiri.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long>{

}
