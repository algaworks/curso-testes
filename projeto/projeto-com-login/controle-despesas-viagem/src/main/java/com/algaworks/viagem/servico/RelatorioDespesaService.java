package com.algaworks.viagem.servico;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.viagem.dao.RelatorioDespesaDAO;
import com.algaworks.viagem.modelo.RelatorioDespesa;
import com.algaworks.viagem.util.jpa.Transactional;

public class RelatorioDespesaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RelatorioDespesaDAO relatorioDespesaDAO;

	@Inject
	public RelatorioDespesaService(RelatorioDespesaDAO relatorioDespesaDAO) {
		this.relatorioDespesaDAO = relatorioDespesaDAO;
	}

	@Transactional
	public void salvar(RelatorioDespesa relatorioDespesa) throws NegocioException {
		// Alguma regra de negócio
		if (!possuiDespesa(relatorioDespesa)) {
			throw new NegocioException("É necessário ter pelo menos uma despesa no relatório.");
		}
		
		// Salva no banco de dados.
		this.relatorioDespesaDAO.salvar(relatorioDespesa);
	}

	private boolean possuiDespesa(RelatorioDespesa relatorioDespesa) {
		return relatorioDespesa.getDespesas() != null && !relatorioDespesa.getDespesas().isEmpty();
	}
	
}
