package com.api.usercontrol.userDto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UsuarioDto {

	@NotBlank
	@Size(max = 50)
	private String username;
	
	@NotBlank
	@Size(max = 10)
	private String password;
	
	private boolean is_enabled;
		
	@NotBlank
	@Size(max = 50)
	private String name;
	
	@NotBlank
	@Size(max = 50)
	private String surname;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(max = 15)
	private String phon;
	
	private LocalDateTime register_data;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs_enabled() {
		return is_enabled;
	}

	public void setIs_enabled(boolean is_enabled) {
		this.is_enabled = is_enabled;
	}

	public LocalDateTime getRegister_data() {
		return register_data;
	}

	public void setRegister_data(LocalDateTime register_data) {
		this.register_data = register_data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhon() {
		return phon;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}
	
		
}
