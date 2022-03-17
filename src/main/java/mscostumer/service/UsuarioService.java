package mscostumer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mscostumer.dto.UsuarioDto;
import mscostumer.form.FormUsuario;
import mscostumer.model.Usuario;
import mscostumer.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void cadastrar(FormUsuario formUsuario) {

		Usuario cadastroUser = new Usuario();

		cadastroUser.setFnome(formUsuario.getFnome());
		cadastroUser.setLnome(formUsuario.getLnome());
		cadastroUser.setSex(formUsuario.getSex());
		cadastroUser.setCpf(formUsuario.getCpf());
		cadastroUser.setBirthdate(formUsuario.getBirthdate());
		cadastroUser.setLogin(formUsuario.getLogin());
		cadastroUser.setSenha(formUsuario.getSenha());

		usuarioRepository.save(cadastroUser);
	}

	@Transactional
	public void atualizar(Long id, FormUsuario formUsuario) {

		Usuario atualizarUser = usuarioRepository.getById(id);
		
		atualizarUser.setFnome(formUsuario.getFnome());
		atualizarUser.setLnome(formUsuario.getLnome());
		atualizarUser.setSex(formUsuario.getSex());
		atualizarUser.setCpf(formUsuario.getCpf());
		atualizarUser.setBirthdate(formUsuario.getBirthdate());
		atualizarUser.setLogin(formUsuario.getLogin());
		atualizarUser.setSenha(formUsuario.getSenha());

	}

	public List<UsuarioDto> listar() {
		List<Usuario> users;
		users = usuarioRepository.findAll();
		return UsuarioDto.converter(users);
	}

	public UsuarioDto detalhar(Long id) {
		Usuario usuarios = usuarioRepository.getById(id);
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setFnome(usuarios.getFnome());
		usuarioDto.setLnome(usuarios.getLnome());
		usuarioDto.setSex(usuarios.getSex());
		usuarioDto.setCpf(usuarios.getCpf());
		usuarioDto.setBirthdate(usuarios.getBirthdate());
		usuarioDto.setLogin(usuarios.getLogin());
		usuarioDto.setSenha(usuarios.getSenha());
		
		return usuarioDto;
		
	}

	public void remover(Long id) {
		usuarioRepository.deleteById(id);
	}
}
