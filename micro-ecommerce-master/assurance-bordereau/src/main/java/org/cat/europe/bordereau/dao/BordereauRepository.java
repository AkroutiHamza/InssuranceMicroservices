package org.cat.europe.bordereau.dao;

import org.cat.europe.bordereau.domain.Bordereau;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

@Transactional

public interface BordereauRepository extends CrudRepository<Bordereau, Long> {

	public Bordereau findByReference(String reference);

}
