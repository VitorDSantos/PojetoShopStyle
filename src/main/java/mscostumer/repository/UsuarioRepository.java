package mscostumer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mscostumer.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	List<Usuario>findByFnome(String fnome);
	
	Optional<Usuario> findByLogin(String login);

}
