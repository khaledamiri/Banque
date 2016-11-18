package org.banque.amiri.dao;

import org.banque.amiri.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository  extends JpaRepository<Operation,String>{

}
