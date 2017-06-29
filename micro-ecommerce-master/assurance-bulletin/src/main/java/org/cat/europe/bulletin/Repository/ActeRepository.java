package org.cat.europe.bulletin.Repository;


import java.util.Collection;

import javax.transaction.Transactional;

import org.cat.europe.bulletin.domain.ActeMedicale;
import org.cat.europe.bulletin.domain.BulletinDeSoin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ActeRepository extends CrudRepository<ActeMedicale, Long>{
	
/*
 * 	@Query(value="select * from ArticleMedicale as a where a.acte_id= ?1",nativeQuery=true)
	Collection<ArticleMedicale> findByActe(Long id);
 */

	@Query(value="select * from BulletinDeSoin as b where b.bulletin_id=?1",nativeQuery=true)
	Collection<BulletinDeSoin> findByBul(Long id);




}
