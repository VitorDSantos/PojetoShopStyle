package mscostumer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mscostumer.enuns.StatusUser;


@Entity
public class Usuario implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String fnome;
	private String lnome;
	private String sex;
	private String cpf;
	private String birthdate;
	@Column(unique=true)
	private String login;
	private String senha;
	private StatusUser statusUser;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	public Usuario(
			@NotNull @NotEmpty 
			String fnome, 
			@NotNull @NotEmpty 
			String lnome, 
			@NotNull @NotEmpty 
			String sex,
			@NotNull @NotEmpty 
			String cpf,
			@NotNull @NotEmpty 
			String birthdate, 
			@NotNull @NotEmpty 
			String login, 
			@NotNull @NotEmpty 
			String senha) {
		this.fnome = fnome;
		this.lnome = lnome;
		this.sex = sex;
		this.cpf = cpf;
		this.birthdate = birthdate;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public StatusUser getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(StatusUser statusUser) {
		this.statusUser = statusUser;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}
	
	public String getSenha() {
		return this.senha ;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return this.senha ;
	}



	}
	