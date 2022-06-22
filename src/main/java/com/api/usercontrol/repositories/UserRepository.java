package com.api.usercontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.usercontrol.models.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, UUID> {

	@Query(value = "from Usuario us where us.username = ?1")
	Optional<Usuario> buscaPorUserName(String username);

	@Query(value = "from Usuario us where us.name = ?1")
	Optional<Usuario> buscaPorName(String name);

	@Query(value = "from Usuario us where us.email = ?1")
	Optional<Usuario> buscaPorEmail(String email);
		
	
}
