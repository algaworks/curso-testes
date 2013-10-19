package com.algaworks.viagem.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="relatorio_despesa")
public class RelatorioDespesa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private List<Despesa> despesas;
	
	public RelatorioDespesa() {
		this.despesas = new ArrayList<>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@OneToMany(mappedBy="despesa")
	public List<Despesa> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public void adicionar(Despesa despesa) {
		this.despesas.add(despesa);
	}
	
	@Transient
	public double getValorTotal() {
		double valorTotal = 0;
		
		for (Despesa despesa : despesas) {
			valorTotal += despesa.getValor();
		}
		
		return valorTotal;
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
		RelatorioDespesa other = (RelatorioDespesa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
