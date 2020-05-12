package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {

		//Creating objects of Person type
		Person p1 = new Person(null, "Bob Brown", "bob@outlook.com");
		Person p2 = new Person(null, "Mary Grey", "mary@outlook.com");
		Person p3 = new Person(null, "Luke Blue", "luke@outlook.com");
		
		//Starting EntityManagerFactory and EntityManager classes
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaCourse");
		EntityManager em = emf.createEntityManager();
		
		//Starting a transaction
		em.getTransaction().begin();
		
		//Creating the objects to be inserted in the database
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		//Actually inserting then into the database
		em.getTransaction().commit();
		
		//Monitoring the person with the ID = 2
		Person p = em.find(Person.class, 2);

		System.out.println(p);
		
		//Starting another transaction
		em.getTransaction().begin();
		
		//Removing the person monitored
		em.remove(p);
		
		//Updating database
		em.getTransaction().commit();
		
		System.out.println("Done!");

		em.close();
		emf.close();

	}

}
