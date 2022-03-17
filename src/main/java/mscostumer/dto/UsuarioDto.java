package mscostumer.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import mscostumer.model.Usuario;



public class UsuarioDto {
	private Long id;
	
	private String fnome;

	private String lnome;

	private String sex;

	private String cpf;

	private String birthdate;

	private String login;

	private String senha;
	
	public UsuarioDto (Usuario usuario) {
		
		this.id = usuario.getId();
		this.fnome = usuario.getFnome();
		this.lnome = usuario.getLnome();
		this.sex = usuario.getSex();
		this.cpf = usuario.getCpf();
		this.birthdate = usuario.getBirthdate();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
	}

	public UsuarioDto() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static List<UsuarioDto> converter(List<Usuario> usuario) {
		 
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
}
