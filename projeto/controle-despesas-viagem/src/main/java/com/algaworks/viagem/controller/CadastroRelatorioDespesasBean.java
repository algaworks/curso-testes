package com.algaworks.viagem.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.viagem.modelo.Despesa;
import com.algaworks.viagem.modelo.RelatorioDespesa;
import com.algaworks.viagem.servico.NegocioException;
import com.algaworks.viagem.servico.RelatorioDespesaService;
import com.algaworks.viagem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroRelatorioDespesasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RelatorioDespesa relatorioDespesa;
	private Despesa despesa;
	
	@Inject
	private RelatorioDespesaService relatorioDespesaService;
	
	@Inject
	private FacesUtil facesUtil;
	
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
		try { 
			relatorioDespesaService.salvar(this.relatorioDespesa);
			this.relatorioDespesa = new RelatorioDespesa();
			facesUtil.info("Relatório salvo com sucesso!");
		} catch (NegocioException e) {
			facesUtil.error(e.getMessage());
		}
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
