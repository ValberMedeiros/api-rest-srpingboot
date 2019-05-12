package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.modelo.Usuario;
import curso.api.rest.repository.UsuarioReporitory;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioReporitory usuarioRepository;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get() , HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> findAllUsers () {
		
		List<Usuario> users = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);	
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> insertUser (@RequestBody Usuario usuario){
		Usuario userSave = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(userSave, HttpStatus.OK);
	}
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> editUser (@RequestBody Usuario usuario){
		Usuario userEdit = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(userEdit, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public ResponseEntity deleteUser (@PathVariable (value= "id") Long id){
		
		usuarioRepository.deleteById(id);
		return new ResponseEntity ("Usuario deletado com sucesso", HttpStatus.OK);
	}
}
