package com.algaworks.viagem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.viagem.helper.DbUnitHelper;
import com.algaworks.viagem.modelo.RelatorioDespesa;

public class RelatorioDespesaDAOTest {

	private static DbUnitHelper dbUnitHelper;
	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	private RelatorioDespesaDAO relatorioDespesaDAO;
	
	@BeforeClass
	public static void initClass() {
		try {
			factory = Persistence.createEntityManagerFactory("controleDepesasViagemPU");
			dbUnitHelper = new DbUnitHelper("DbUnitXml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void init() {
		dbUnitHelper.execute(DatabaseOperation.DELETE_ALL, "Despesa.xml");
		dbUnitHelper.execute(DatabaseOperation.DELETE_ALL, "RelatorioDespesa.xml");
		
		dbUnitHelper.execute(DatabaseOperation.INSERT, "RelatorioDespesa.xml");
		dbUnitHelper.execute(DatabaseOperation.INSERT, "Despesa.xml");
		
		this.manager = factory.createEntityManager();
		this.relatorioDespesaDAO = new RelatorioDespesaDAO(manager); 
	}
	
	@After
	public void end() {
		dbUnitHelper.close();
		this.manager.close();
	}
	
	@Test
	public void buscarRelatorioDespesa() {
		RelatorioDespesa relatorioDespesa = this.relatorioDespesaDAO.buscarPeloCodigo(1L);
		
		Assert.assertNotNull(relatorioDespesa);
		Assert.assertEquals(2, relatorioDespesa.getDespesas().size());
	}
	
}
