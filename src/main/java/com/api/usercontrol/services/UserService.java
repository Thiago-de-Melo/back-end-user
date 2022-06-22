package com.api.usercontrol.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.usercontrol.models.Usuario;
import com.api.usercontrol.repositories.UserRepository;


@Service
public class UserService {
	
	final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public Usuario save(Usuario user) {
		return userRepository.save(user);
	}

	public Optional<Usuario> findByUserName(String username) {
		return userRepository.buscaPorUserName(username);
	}

	public Object findAll() {
		return userRepository.findAll();
	}

	public Optional<Usuario> findByName(String name) {
		return userRepository.buscaPorName(name);
	}

	public Optional<Usuario> findByEmail(String email) {
		return userRepository.buscaPorEmail(email);
	}

	
}
