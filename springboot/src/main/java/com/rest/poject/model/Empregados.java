package com.rest.poject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empregados")
public class Empregados {
	
	private long id;
	private String primeiroNome;
	private String segundoNome;
	private String emailId;
	
	public Empregados() {
		super();
	}

	public Empregados(long id, String primeiroNome, String segundoNome, String emailId) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.segundoNome = segundoNome;
		this.emailId = emailId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "primeiro_nome", nullable = false)
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	@Column(name = "segundo_nome", nullable = false)
	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Empregados [id=" + id + ", primeiroNome=" + primeiroNome + ", segundoNome=" + segundoNome + ", emailId="
				+ emailId + "]";
	}

}
