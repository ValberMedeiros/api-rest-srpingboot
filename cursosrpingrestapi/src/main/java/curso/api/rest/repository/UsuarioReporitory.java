package curso.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.api.rest.modelo.Usuario;

@Repository
public interface UsuarioReporitory  extends CrudRepository<Usuario, Long>{
	
}
