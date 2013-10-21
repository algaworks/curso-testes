package com.algaworks.viagem.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.viagem.modelo.RelatorioDespesa;
import com.algaworks.viagem.util.jpa.Transactional;

public class RelatorioDespesaDAO implements Serializable {

	private EntityManager manager;

	@Inject
	public RelatorioDespesaDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public void salvar(RelatorioDespesa relatorioDespesa) {
		manager.persist(relatorioDespesa);
	}
	
	public RelatorioDespesa buscarPeloCodigo(Long codigo) {
		return this.manager.find(RelatorioDespesa.class, codigo);
	}
	
}
