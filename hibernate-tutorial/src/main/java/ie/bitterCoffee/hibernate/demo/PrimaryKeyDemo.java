package ie.bitterCoffee.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ie.bitterCoffee.hibernate.demo.entity.Student;

public class PrimaryKeyDemo
{

	public static void main(String[] args)
	{
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//create a student object
			System.out.println("Creating a new student object ...");
			Student tempStudent1 = new Student("Paul","Doe","paulwall@example.ie");
			Student tempStudent2 = new Student("Mary","Public","marypublic@example.ie");
			Student tempStudent3 = new Student("Boita","Applebum","boitaApplebum@example.ie");
			
			//start a transaction
			session.beginTransaction();
			
			//save java object
			System.out.println("Saving the student ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally
		{
			factory.close();
		}		
	}
}
