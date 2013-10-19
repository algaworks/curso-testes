package com.algaworks.viagem.servico;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.algaworks.viagem.dao.RelatorioDespesaDAO;
import com.algaworks.viagem.modelo.Despesa;
import com.algaworks.viagem.modelo.RelatorioDespesa;

public class RelatorioDespesaServiceTest {

	@Test
	public void salvarRelatorioDespesa() {
		Despesa despesa1 = new Despesa("Taxi", 25.0);
		RelatorioDespesa relatorio = new RelatorioDespesa();
		relatorio.adicionar(despesa1);
		
		RelatorioDespesaService servico = new RelatorioDespesaService();
		RelatorioDespesaDAO relatorioDAO = mock(RelatorioDespesaDAO.class);
		
		servico.relatorioDespesaDAO = relatorioDAO;
		
		servico.salvar(relatorio);
	}
	
}
