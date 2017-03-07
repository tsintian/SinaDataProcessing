package main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RecreateTables {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;

	
	private void initTables(){			
		
		this.emf = Persistence.createEntityManagerFactory("dataProcess");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
	}

	public static void main(String[] args) {
		System.out.println("are you sure to run this porgram now? if so it will recreate all the tables in the database.(yes/no?)");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		if(!choice.trim().equals("yes")){
			System.out.println("what you chose is  cancel and the programe will exit.");
			input.close();
			return;
		}
		input.close();
		
		RecreateTables rt = new RecreateTables();
		rt.initTables();
		
	}

}
