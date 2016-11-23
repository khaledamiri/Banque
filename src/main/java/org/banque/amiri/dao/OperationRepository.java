package org.banque.amiri.dao;

import org.banque.amiri.entities.Compte;
import org.banque.amiri.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, String> {
	// 1er version
	@Query("select o from Operation o where o.compte.numCompte=:x ")
	public Page<Operation> getOperations(@Param("x") String Code,
			Pageable pageable);

	// 2eme version
	public Page<Operation> findByCompte(Compte compte, Pageable pageable);
}
