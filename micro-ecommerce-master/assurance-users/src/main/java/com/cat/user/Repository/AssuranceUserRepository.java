package com.cat.user.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.cat.user.domain.AssuranceUsers;

@Transactional
public interface AssuranceUserRepository extends CrudRepository<AssuranceUsers, Long>{

}
