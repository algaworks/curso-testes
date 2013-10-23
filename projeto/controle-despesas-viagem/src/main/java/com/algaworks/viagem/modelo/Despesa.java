package com.algaworks.viagem.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="despesa")
public class Despesa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String descricao;
	private double valor;
	private RelatorioDespesa relatorioDespesa;

	public Despesa() {
	}
	
	public Despesa(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@NotNull
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_relatorio_despesa")
	public RelatorioDespesa getRelatorioDespesa() {
		return relatorioDespesa;
	}
	public void setRelatorioDespesa(RelatorioDespesa relatorioDespesa) {
		this.relatorioDespesa = relatorioDespesa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Despesa other = (Despesa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
