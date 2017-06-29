package org.cat.europe.bulletin.Repository;

import java.util.Collection;

import org.cat.europe.bulletin.domain.ArticleMedicale;
import org.cat.europe.bulletin.domain.ProfessionelDeSante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ArticleRepository extends CrudRepository<ArticleMedicale, Long>{

	public ArticleMedicale findByLibelle(String libelle);
	
	
	
	@Query(value="select * from ArticleMedicale as a where a.acte_id= ?1",nativeQuery=true)
	Collection<ArticleMedicale> findByActe(Long id);
	
}
