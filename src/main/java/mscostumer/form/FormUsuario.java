package mscostumer.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import mscostumer.model.Usuario;
import mscostumer.repository.UsuarioRepository;

public class FormUsuario {
	
	@NotNull @NotEmpty 
	String fnome;
	
	@NotNull @NotEmpty 
	String lnome;
	
	@NotNull @NotEmpty 
	String sex;
	
	@NotNull @NotEmpty 
	String cpf;
	
	@NotNull @NotEmpty 
	String birthdate; 
	
	@NotNull @NotEmpty 
	String login;
	
	@NotNull @NotEmpty 
	String senha;

	public String getFnome() {
		return fnome;
	}
	public void setFnome(String fnome) {
		this.fnome = fnome;
	}
	public String getLnome() {
		return lnome;
	}
	public void setLnome(String lnome) {
		this.lnome = lnome;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario converter(UsuarioRepository usuarioRepository) {
		
		List<Usuario> user = usuarioRepository.findByFnome(fnome);
		
		return new Usuario(fnome,lnome,sex,cpf,birthdate,login,senha);
		
	}
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		
		usuario.setFnome(fnome);
		usuario.setLnome(lnome);
		usuario.setSex(sex);
		usuario.setCpf(cpf);
		usuario.setBirthdate(birthdate);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		return usuario;
	}
}

