package com.algaworks.viagem.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class RelatorioDespesaTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		Locale.setDefault(new Locale("pt", "BR"));
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void permiteAdicionarDespesas() {
		Despesa despesa1 = new Despesa("Taxi", 40.0);
		Despesa despesa2 = new Despesa("Almoço", 20.0);
		
		RelatorioDespesa relatorio = new RelatorioDespesa();
		relatorio.adicionar(despesa1);
		relatorio.adicionar(despesa2);
		
		assertEquals(2, relatorio.getDespesas().size());
	}
	
	@Test
	public void calculaValorTotalDasDespesas() {
		Despesa despesa1 = new Despesa("Taxi", 40.0);
		Despesa despesa2 = new Despesa("Almoço", 20.0);
		Despesa despesa3 = new Despesa("Diária hotel", 120.0);
		Despesa despesa4 = new Despesa("Almoço", 25.0);
		
		RelatorioDespesa relatorio = new RelatorioDespesa();
		relatorio.adicionar(despesa1);
		relatorio.adicionar(despesa2);
		relatorio.adicionar(despesa3);
		relatorio.adicionar(despesa4);
		
		assertEquals(205.0, relatorio.getValorTotal(), 0.0001);
	}
	
	@Test
	public void descricaoDeveSerInformada() {
		Despesa despesa = new Despesa();
		
		Set<ConstraintViolation<Despesa>> restricoes = validator.validate(despesa);
		
		assertEquals(1, restricoes.size());
	}

}
