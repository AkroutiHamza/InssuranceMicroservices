package org.cat.europe.bulletin.Repository;


import javax.transaction.Transactional;

import org.cat.europe.bulletin.domain.BulletinDeSoin;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface BulletinRepository extends CrudRepository<BulletinDeSoin, Long>{

	
}
