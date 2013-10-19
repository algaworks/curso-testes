package com.algaworks.viagem.servico;

import com.algaworks.viagem.dao.RelatorioDespesaDAO;
import com.algaworks.viagem.modelo.RelatorioDespesa;

public class RelatorioDespesaService {

	RelatorioDespesaDAO relatorioDespesaDAO;
	
	public void salvar(RelatorioDespesa relatorioDespesa) {
		// Alguma regra de negócio
		validar(relatorioDespesa);
		
		// Salva no banco de dados.
		this.relatorioDespesaDAO.salvar(relatorioDespesa);
	}

	private void validar(RelatorioDespesa relatorioDespesa) {
		if (!possuiDespesa(relatorioDespesa)) {
			throw new IllegalArgumentException("É necessário ter pelo menos uma despesa no relatório.");
		}
	}

	private boolean possuiDespesa(RelatorioDespesa relatorioDespesa) {
		return relatorioDespesa.getDespesas() != null && !relatorioDespesa.getDespesas().isEmpty();
	}
	
}
