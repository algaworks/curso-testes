package com.algaworks.viagem.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.viagem.dao.RelatorioDespesaDAO;
import com.algaworks.viagem.modelo.RelatorioDespesa;

@Named
@ViewScoped
public class PesquisaRelatorioDespesasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<RelatorioDespesa> relatoriosDespesas;
	
	@Inject
	private RelatorioDespesaDAO relatorioDespesaDAO;
	
	@PostConstruct
	public void init() {
		this.relatoriosDespesas = this.relatorioDespesaDAO.buscarTodos();
	}

	public List<RelatorioDespesa> getRelatoriosDespesas() {
		return relatoriosDespesas;
	}

}
