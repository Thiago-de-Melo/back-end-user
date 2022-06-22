package com.api.usercontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.usercontrol.models.Usuario;
import com.api.usercontrol.services.UserService;
import com.api.usercontrol.userDto.UsuarioDto;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UsuarioDto userDto) {
		var user = new Usuario();
		BeanUtils.copyProperties(userDto, user);
		user.setRegister_data(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));		
	}
	
	@GetMapping
	public ResponseEntity<Object> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());	
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<Object> buscarPorUserName(@PathVariable(value = "username") String username) {
		Optional<Usuario> userOpitional = userService.findByUserName(username);
		if(!userOpitional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar usuário com esse username.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userOpitional.get());	
	}
	
	@GetMapping("/nome/{name}")
	public ResponseEntity<Object> buscarPorName(@PathVariable(value = "name") String name) {
		Optional<Usuario> userOpitional = userService.findByName(name);
		if(!userOpitional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar usuário com esse nome.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userOpitional.get());	
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Object> buscarPorEmail(@PathVariable(value = "email") String email) {
		Optional<Usuario> userOpitional = userService.findByEmail(email);
		if(!userOpitional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar usuário com esse email.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userOpitional.get());	
	}
		
}
