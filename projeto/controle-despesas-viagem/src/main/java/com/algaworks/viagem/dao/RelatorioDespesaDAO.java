package com.algaworks.viagem.dao;

import java.io.Serializable;

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
	
}
