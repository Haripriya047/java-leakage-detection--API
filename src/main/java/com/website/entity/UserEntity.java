package com.website.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String email;
	private String allocatedData;
	private String alterationData;

	public String getAllocatedData() {
		return allocatedData;
	}

	public void setAllocatedData(String allocatedData) {
		this.allocatedData = allocatedData;
	}

	public String getAlterationData() {
		return alterationData;
	}

	public void setAlterationData(String alterationData) {
		this.alterationData = alterationData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
