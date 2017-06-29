package org.cat.europe.bulletin.Repository;


import java.util.Collection;

import org.cat.europe.bulletin.domain.ProfessionelDeSante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProfessionelRepository extends CrudRepository<ProfessionelDeSante, Long>{
	public ProfessionelDeSante findByNom(String nom);
	/*
	@Query(value="select p from ProfessionelDeSante p where p.ActeMedicale.acte_id")
	public Collection<ProfessionelDeSante> profParActe(Long idAct);
	
	@Query(value="select p from ProfessionelDeSante p where p.selectionne=true")
	public Collection<ProfessionelDeSante> proSelectionne();
*/
	
	@Query(value="select * from ProfessionelDeSante as a where a.acte_id= ?1",nativeQuery=true)
	Collection<ProfessionelDeSante> findByActe(Long id);

	
	
 
	
 
}