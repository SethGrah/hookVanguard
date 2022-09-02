package com.skillstorm.hook.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="USERS")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Users {
	
	@Id
	@Column(name="USERNAME")
	@NotBlank
	private String username;
	
	@NotBlank
	@Column(name="EMAIL")
	private String email;

	@NotBlank
	@Column(name="PASSWORD")
	private String password;
	
	public Users() {
		super();
	}
	
	public Users(@NotBlank String username, @NotBlank String email, @NotBlank String password) {
	}

	
	
	public Users(Users user) {
		
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
