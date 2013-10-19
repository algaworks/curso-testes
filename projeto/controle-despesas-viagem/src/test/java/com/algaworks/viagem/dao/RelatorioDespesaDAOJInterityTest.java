package com.algaworks.viagem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.viagem.modelo.RelatorioDespesa;
import com.jintegrity.core.JIntegrity;


public class RelatorioDespesaDAOJInterityTest {

	private static EntityManagerFactory factory;
	
	private JIntegrity helper = new JIntegrity();
	
	private EntityManager manager;
	
	private RelatorioDespesaDAO relatorioDespesaDAO;
	
	@BeforeClass
	public static void initClass() {
		try {
			factory = Persistence.createEntityManagerFactory("controleDepesasViagemPU");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void init() {
		helper.cleanAndInsert();
		
		this.manager = factory.createEntityManager();
		this.relatorioDespesaDAO = new RelatorioDespesaDAO(manager);
	}
	
	@After
	public void end() {
		this.manager.close();
	}
	
	@Test
	public void buscarRelatorioDespesa() {
		RelatorioDespesa relatorioDespesa = this.relatorioDespesaDAO.buscarPeloCodigo(1L);
		
		Assert.assertNotNull(relatorioDespesa);
		Assert.assertEquals(2, relatorioDespesa.getDespesas().size());
	}
}
