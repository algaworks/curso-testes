package com.algaworks.viagem.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.viagem.dao.RelatorioDespesaDAO;
import com.algaworks.viagem.modelo.Despesa;
import com.algaworks.viagem.modelo.RelatorioDespesa;
import com.algaworks.viagem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroRelatorioDespesasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RelatorioDespesa relatorioDespesa;
	private Despesa despesa;
	
	@Inject
	private RelatorioDespesaDAO relatorioDespesaDAO;
	
	@PostConstruct
	public void init() {
		this.clean();
		this.relatorioDespesa = new RelatorioDespesa();
	}
	
	public void adicionar() {
		this.relatorioDespesa.getDespesas().add(this.despesa);
		this.clean();
	}
	
	public void salvar() {
		relatorioDespesaDAO.salvar(this.relatorioDespesa);
		this.relatorioDespesa = new RelatorioDespesa();
		FacesUtil.addSuccessMessage("Relatório salvo com sucesso!");
	}
	
	private void clean() {
		this.despesa = new Despesa();
	}

	public RelatorioDespesa getRelatorioDespesa() {
		return relatorioDespesa;
	}
	public void setRelatorioDespesa(RelatorioDespesa relatorioDespesa) {
		this.relatorioDespesa = relatorioDespesa;
	}

	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	
}
