package dataProcess.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dataProcess.pojo.M1605;

public class DataManager {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;

	public DataManager(){
		this.emf = Persistence.createEntityManagerFactory("dataProcess");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
	}
	public void txBegin(){
		tx.begin();
	}
	
	public void txCommit(){
		tx.commit();
	}
	
	
	public boolean pushM1605(M1605 data){
		em.persist(data);
		return true;
	}
	
	public void close(){
		if(em != null)
			em.close();
		if(emf != null)
			emf.close();
	}
	

}
