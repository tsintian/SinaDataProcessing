package test;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dataProcess.pojo.Student;

public class StudentTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;

	public StudentTest(){
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
		
		
		StudentTest st = new StudentTest();
		st.insert();
		st.close();

	}
	
	private void insert(){
		Student s = new Student();
		s.setId(10);
		s.setName("qin你好");
		s.setBirthday(new Date());
		s.setGender("male");
		
		tx.begin();
		em.persist(s);
		tx.commit();
		
	}
	
	private void close(){
		if(em != null)
			em.close();
		if(emf != null)
			emf.close();
	}

}
