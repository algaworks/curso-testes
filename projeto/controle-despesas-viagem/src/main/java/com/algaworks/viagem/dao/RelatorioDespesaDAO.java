package com.algaworks.viagem.dao;

import javax.persistence.EntityManager;

import com.algaworks.viagem.modelo.RelatorioDespesa;

public class RelatorioDespesaDAO {

	private EntityManager manager;
	
	public RelatorioDespesaDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(RelatorioDespesa relatorioDespesa) {
		System.out.println("Salvando no banco de dados...");
	}
	
	public RelatorioDespesa buscarPeloCodigo(Long codigo) {
		return this.manager.find(RelatorioDespesa.class, codigo);
	}
	
}
