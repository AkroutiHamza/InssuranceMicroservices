package com.cat.user.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.Identifiable;

@Entity
@Table(name = "User")
public class User implements Identifiable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private String name;
	private String password;
	private String email;

	@Enumerated(EnumType.STRING)
	private Type roleType;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Permission> permissions = new HashSet<Permission>();

	public User(Collection<Permission> permissions) {
		this.permissions.addAll(permissions);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Type getRoleType() {
		return roleType;
	}

	public void setRoleType(Type roleType) {
		this.roleType = roleType;
	}

	public User(Permission... items) {
		this(Arrays.asList(items));
	}

	public User() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Permission> getItems() {
		return permissions;
	}

	public static enum Type {

		/**
		 * {@link User} Admin User with all rights
		 */
		ADMIN,

		/**
		 * {@link User} Payment Consultant for the company
		 */
		PAYMENT_AGMENT,

		/**
		 * The {@link User} CNAM Agent
		 */
		CNAM_AGENT,

		/**
		 * The {@link User} Company Employee
		 */
		EMPLOYEE,

	}
}
