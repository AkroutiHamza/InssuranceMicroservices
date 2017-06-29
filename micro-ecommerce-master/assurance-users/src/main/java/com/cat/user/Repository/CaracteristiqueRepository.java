package com.cat.user.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cat.user.domain.Caracteristique;

@Transactional
public interface CaracteristiqueRepository extends CrudRepository<Caracteristique, Long> {

	public Caracteristique findByPoste(String poste);
}
