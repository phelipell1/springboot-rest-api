package com.rest.poject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Empresas")
public class Empresas {

	private long id;
	private String nomeEmpresa;
	private String cnpjEmpresa;
	private Date DataFundacao;
	private Empregados proprietario;
	private List<Empregados> listEmpregados;
	
	public Empresas() {
		super();
	}

	public Empresas(long id, String nomeEmpresa, String cnpjEmpresa, Date dataFundacao, Empregados proprietario,
			List<Empregados> listEmpregados) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpjEmpresa = cnpjEmpresa;
		this.DataFundacao = dataFundacao;
		this.proprietario = proprietario;
		this.listEmpregados = listEmpregados;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome_empresa", nullable = false)
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	@Column(name = "cnpj_empresa", nullable = false)
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
	@Column(name = "data_fundacao", nullable = false)
	public Date getDataFundacao() {
		return DataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		DataFundacao = dataFundacao;
	}
	
	
	@OneToOne
	@JoinColumn(name = "empregado_id")
	public Empregados getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Empregados proprietario) {
		this.proprietario = proprietario;
	}
	@OneToMany
	@JoinColumn(name = "empresa_id")
	public List<Empregados> getListEmpregados() {
		return listEmpregados;
	}

	public void setListEmpregados(List<Empregados> listEmpregados) {
		this.listEmpregados = listEmpregados;
	}
	
}
