package mscostumer.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mscostumer.dto.UsuarioDto;
import mscostumer.form.FormUsuario;
import mscostumer.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "Users", allEntries = true)
	public ResponseEntity<String> adicionar(@RequestBody @Valid FormUsuario userForm) {
		usuarioService.cadastrar(userForm);
		return new ResponseEntity<>("Usuario adicionado.", HttpStatus.CREATED); 
	}
	
	@GetMapping
	@Cacheable(value = "Users")
	public List<UsuarioDto> listar() {
		return usuarioService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> detalhar(@PathVariable Long id) {
		UsuarioDto usuarioDto = usuarioService.detalhar(id);
		return ResponseEntity.ok(usuarioDto);
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "Users", allEntries = true)
	public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody FormUsuario formUser) {
		usuarioService.atualizar(id, formUser);
		return new ResponseEntity<>("Usuario atualizado.", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "Users", allEntries = true)
	public ResponseEntity<String> remover(@PathVariable Long id) {
		usuarioService.remover(id);
		return new ResponseEntity<>("Usuario do ID "+id+" foi excluido.", HttpStatus.OK);
	}
}
