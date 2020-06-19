package com.rest.poject.model;

import java.util.Date;

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
	private String nomeCompleto;
	private String endereco;
	private String email;
	private String telefone;
	private String CPF;
	private Date dateNascimento;
	private int funcao;
	private double salario;
	
	public Empregados() {
		super();
	}

	public Empregados(long id, String nomeCompleto, String endereco, String email, String telefone, String cPF,
			Date dateNascimento, int funcao, double salario) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.CPF = cPF;
		this.dateNascimento = dateNascimento;
		this.funcao = funcao;
		this.salario = salario;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome_completo", nullable = false)
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	@Column(name = "Endereco", nullable = false)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "Telefone", nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name = "CPF", nullable = false)
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	@Column(name = "data_nascimento", nullable = false)
	public Date getDateNascimento() {
		return dateNascimento;
	}

	public void setDateNascimento(Date dateNascimento) {
		this.dateNascimento = dateNascimento;
	}
	
	@Column(name = "funcao", nullable = false)
	public int getFuncao() {
		return funcao;
	}

	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}
	
	@Column(name = "salario", nullable = false)
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
