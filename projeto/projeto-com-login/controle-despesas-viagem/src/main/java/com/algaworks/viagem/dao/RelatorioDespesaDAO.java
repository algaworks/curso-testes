package com.algaworks.viagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.viagem.modelo.RelatorioDespesa;

public class RelatorioDespesaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	@Inject
	public RelatorioDespesaDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(RelatorioDespesa relatorioDespesa) {
		manager.persist(relatorioDespesa);
	}
	
	public RelatorioDespesa buscarPeloCodigo(Long codigo) {
		return this.manager.find(RelatorioDespesa.class, codigo);
	}

	public List<RelatorioDespesa> buscarTodos() {
		return this.manager.createQuery("from RelatorioDespesa").getResultList();
	}
	
}
