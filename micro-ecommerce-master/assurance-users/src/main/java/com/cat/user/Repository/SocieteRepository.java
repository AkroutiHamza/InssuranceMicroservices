package com.cat.user.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cat.user.domain.Societe;

@Transactional
public interface SocieteRepository extends CrudRepository<Societe, Long> {

	public Societe findByNom(String nom);

}
