package com.cat.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.cat.user.domain.User;
import com.cat.user.domain.User.Type;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	
	@RestResource(path="roleType")
	List<User> findByRoleType(@Param("roleType") Type roleType);
	
	
	@RestResource(path="name")
	List<User> findByName(@Param("name") String name);
}
